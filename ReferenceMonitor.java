import java.util.ArrayList;

/**
 * Firewall
*/
public class ReferenceMonitor {
    // Instance fields
    private ArrayList<S_Object> obj_list;
    private ObjectManager object = new ObjectManager();

    // Constructor
    public ReferenceMonitor() {
        obj_list = new ArrayList<>();
    }

    // Creates new objects and add them to object list
    public void createObject(String name, SecurityLevel level) {
        S_Object temp = new S_Object(name, level);
        obj_list.add(temp);
    }
    // Getter
    public ArrayList<S_Object> getObjects() {
        return obj_list;
    }

    public int executeRead(S_Subject subj, S_Object obj) {
        return object.read(subj, obj);
    }

    public int executeWrite(S_Object obj, int value) {
        return object.write(obj, value);
    }

    // Executes the instruction accordinly and returns a code when done
    public int execute(InstructionObject ins, ArrayList<S_Subject> subjList) {
        // If the instruction is bad, don't do anything, do not allow access
        if (ins.getInstructionType() == InstructionType.BAD) {
            return -1;
        }
        // Otherwise, it's either a read or write operation
        for (S_Subject subj: subjList) {
            if (ins.getSubjectName().equals(subj.getName())) {
                for (S_Object obj: obj_list) {
                    if (ins.getObjectName().equals(obj.getName())) {
                        // READ operation
                        if (ins.getInstructionType() == InstructionType.READ) {
                            // checks for clearance
                            if (subj.getSecurityLevel().equals(obj.getSecurityLevel()) ||
                                (subj.getSecurityLevel() == SecurityLevel.HIGH && obj.getSecurityLevel() == SecurityLevel.LOW)) {
                                return executeRead(subj, obj);
                            }
                            else {
                                // no access, no action
                                object.invalid_read(subj);
                                return -2;
                            }
                        }
                        // WRITE operation
                        else if (ins.getInstructionType() == InstructionType.WRITE) {
                            // checks for clearance
                            if (subj.getSecurityLevel().equals(obj.getSecurityLevel()) ||
                                (subj.getSecurityLevel() == SecurityLevel.LOW && obj.getSecurityLevel() == SecurityLevel.HIGH)) {
                                int value = ins.getValue();
                                return executeWrite(obj, value);
                            }
                            else {
                                // no access, no action
                                return -2;
                            }
                        }
                    }
                }
                //System.out.println("Object doesn't Exist");
                return -1;
            }
        }
        //System.out.println("Subject doesn't Exist");
        return -1;
    }

    class ObjectManager {
        public int read(S_Subject subj, S_Object obj) {
            // update temp
            int temp = obj.getValue();
            subj.setTemp(temp);
            return temp;

        }
        // changes the object's value
        public int write(S_Object obj, int value) {
            obj.setValue(value);
            return 0;
        }
        // Returns 0 to subject for an invalid read
        public void invalid_read(S_Subject subj) {
            subj.setTemp(0);
        }
    }
    
}
