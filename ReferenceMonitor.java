import java.util.ArrayList;

public class ReferenceMonitor {

    private ArrayList<S_Object> obj_list;
    private ObjectManager object = new ObjectManager();

    public ReferenceMonitor() {
        obj_list = new ArrayList<>();
    }

    public void createObject(String name, SecurityLevel level) {
        S_Object temp = new S_Object(name, level);
        obj_list.add(temp);
    }

    public ArrayList<S_Object> getObjects() {
        return obj_list;
    }

    public int executeRead(S_Subject subj, S_Object obj) {
        return object.read(subj, obj);
    }

    public int executeWrite(S_Object obj, int value) {
        return object.write(obj, value);
    }

    public int execute(InstructionObject ins, ArrayList<S_Subject> subjList){
        if (ins.getInstructionType() == InstructionType.BAD) {
            return -1;
        }
        for (S_Subject subj: subjList) {
            if (ins.getSubjectName().equals(subj.getName())) {
                for (S_Object obj: obj_list) {
                    if (ins.getObjectName().equals(obj.getName())) {
                        // READ operation
                        if (ins.getInstructionType() == InstructionType.READ) {
                            if (subj.getSecurityLevel().equals(obj.getSecurityLevel()) ||
                                (subj.getSecurityLevel() == SecurityLevel.HIGH && obj.getSecurityLevel() == SecurityLevel.LOW)) {
                                return executeRead(subj, obj);
                            }
                            else {
                                System.out.println("SecurityLevel Error");
                                return -1;
                            }
                        }
                        // WRITE operation
                        else if (ins.getInstructionType() == InstructionType.WRITE) {
                            if (subj.getSecurityLevel().equals(obj.getSecurityLevel()) ||
                                (subj.getSecurityLevel() == SecurityLevel.LOW && obj.getSecurityLevel() == SecurityLevel.HIGH)) {
                                int value = obj.getValue();
                                return executeWrite(obj, value);
                            }
                            else {
                                System.out.println("SecurityLevel Error");
                                return -1;
                            }
                        }
                    }
                }
                System.out.println("Object doesn't Exist");
                return -1;
            }
        }
        System.out.println("Subject doesn't Exist");
        return -1;
    }

    class ObjectManager {

        public int read(S_Subject subj, S_Object obj) {
            // update temp
            int temp = obj.getValue();
            subj.setTemp(temp);
            return temp;

        }

        public int write(S_Object obj, int value) {
            // changes the object's value
            obj.setValue(value);
            return 0;
        }
    }
    
}
