import java.lang.String;
import java.lang.Integer;
import java.util.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class SecureSystem {
    private ArrayList<S_Subject> subjList;

    public InstructionObject parseArgs(String[] args){
        InstructionObject insObject = new InstructionObject();
        final InstructionObject BadInstruction = new InstructionObject(InstructionType.BAD);

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
                        insObject.setInstructionType(InstructionType.WRITE);
                    }
                    catch(Exception e) {
                        insObject.setInstructionType(InstructionType.BAD);
                    }
                }
                break;
            default:
                // bad command, not a read/write
                insObject.setInstructionType(InstructionType.BAD);
                break;
        }

        if (insObject.getInstructionType() == InstructionType.BAD)
            return BadInstruction;

        /* Sets Subject for Instruction */
        insObject.setSubject(args[1].toLowerCase());
        insObject.setObject(args[2].toLowerCase());
        
        return insObject;
    }

    public void printState(ReferenceMonitor ref, InstructionObject ins, int type) {

        ArrayList<S_Object> obj_list = ref.getObjects();
        if (type == -1) {
            System.out.println("Bad Instruction");
        }
        if (ins.getInstructionType().equals(InstructionType.WRITE)) {
            System.out.println(ins.getSubjectName() + " writes value " + ins.getValue() + " to " + ins.getObjectName());
        }
        if (ins.getInstructionType().equals(InstructionType.READ)) {
            System.out.println(ins.getSubjectName() + " reads " + ins.getObjectName());
        }

        System.out.println("The current state is: ");
        for (S_Object obj: obj_list) {
            System.out.println("\t" + obj.getName() + " has value: " + obj.getValue());
        }
        for (S_Subject subj: subjList) {
            System.out.println("\t" + subj.getName() + " has recently read: " + subj.getTemp());
        }
    }

    public static void main(String[] args) throws IOException {

        SecureSystem sys = new SecureSystem();

        // Create two new subjects
        S_Subject lyle = new S_Subject("lyle", SecurityLevel.LOW);
        S_Subject hal = new S_Subject("hal", SecurityLevel.HIGH);

        // Create two new objects
         ReferenceMonitor ref = new ReferenceMonitor();
         ref.createObject("lobj", SecurityLevel.LOW);
         ref.createObject("hobj", SecurityLevel.HIGH);

        sys.subjList = new ArrayList<>();
        sys.subjList.add(lyle);
        sys.subjList.add(hal);

        File file = new File(args[0]);
        Scanner scan = new Scanner(file);
        System.out.println("Reading from file: " + file.toString() + "\n");

        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] arr = line.split("\\s+");
            InstructionObject ins = sys.parseArgs(arr);
            int type = ref.execute(ins, sys.subjList);
            sys.printState(ref, ins, type);
            System.out.println();
        }
    }
}
