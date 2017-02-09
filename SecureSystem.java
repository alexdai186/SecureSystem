import java.lang.String;
import java.lang.Integer;
import java.util.*;
import java.io.IOException;

public class SecureSystem {
    private ArrayList<S_Subject> subjList;

    public InstructionObject parseArgs(String[] args){
        InstructionObject insObject = new InstructionObject();        
        // check what the command is
        String type = args[0].toLowerCase();
        switch(type) {
            case "read":
                // checks if read command is illegal
                if (args.length != 3) {
                    insObject.setInstructionType(InstructionType.BAD);
                    // return insObject;
                }
                else {
                    insObject.setInstructionType(InstructionType.READ);
                }
                break;
            case "write":
                // checks if write command is illegal
                if (args.length != 4) {
                    insObject.setInstructionType(InstructionType.BAD);
                    // return insObject;
                }
                else {
                    try {
                        insObject.setValue(Integer.parseInt(args[3]));
                    }
                    catch(Exception e) {
                        insObject.setInstructionType(InstructionType.BAD);
                        return insObject;
                    }
                    insObject.setInstructionType(InstructionType.WRITE);
                }
                break;
            default:
                // bad command, not a read/write
                insObject.setInstructionType(InstructionType.BAD);
                break;
        }

        if (insObject.getInstructionType() == InstructionType.BAD)
            return insObject;

        /* Sets Subject for Instruction */
        insObject.setSubject(args[1].toLowerCase());
        insObject.setObject(args[2].toLowerCase());
        
        return insObject;
    }

    public void printState(ReferenceMonitor ref) {

        ArrayList<S_Object> obj_list = new ArrayList<>();
        obj_list = ref.getObjects();

        if ()

    }

    public static void main(String[] args) throws IOException {

        SecureSystem sys = new SecureSystem();

        // Create two new subjects
        S_Subject hal = new S_Subject("hal", SecurityLevel.HIGH);
        S_Subject lyle = new S_Subject("lyle", SecurityLevel.LOW);

        // Create two new objects
         ReferenceMonitor ref = new ReferenceMonitor();
         ref.createObject("lobj", SecurityLevel.LOW);
         ref.createObject("hobj", SecurityLevel.HIGH);

        sys.subjList = new ArrayList<>();
        sys.subjList.add(hal);
        sys.subjList.add(lyle);

        InstructionObject ins = sys.parseArgs(args);

        sys.printState(ref, ins);
    }
}
