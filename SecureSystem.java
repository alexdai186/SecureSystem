import java.lang.String;
import java.lang.Integer;
import java.util.*;
import ReferenceMonitor.class;

// An enum for InstructionType
public enum InstructionType {
    READ("read"),
    WRITE("write"),
    BAD("bad");
    private String value;
    private InstructionType(String v) {
        value = v;
    }
    public String getValue() {
        return value;
    }
}

// SecurityLevel should be a class with a defined "dominates" relation.
public enum SecurityLevel {
    // HOW TO ESTABLISH DOMINANCE????????????????????????????
    LOW("low"),
    HIGH("high");
    private String level;
    private SecurityLevel(String l) {
        level = l;
    }
    public String getLevel() {
        return level;
    }

}

/**
 * InstructionObject class
 * Stores type of instruction (read, write, bad), name of subject, name of object, and optional value
 */
public class InstructionObject {
    private InstructionType insType;
    private String subjectName;
    private String objectName;
    private int value;

    // Constructors
    public InstructionObject() {}
    public InstructionObject(InstructionType i, String sName, String oName) {
        insType = i;
        subjectName = sName;
        objectName = oName;
        value = v;
    }
    // Setters
    public void setValue(int v) {
        value = v;
    }

    public void setInstructionType(InstructionType i) {
        insType = i;
    }

    public void setSubject(String s) {
        subjectName = s;
    }

    public void setObject(String o) {
        objectName = o;
    }

    // Getters
    public InstructionType getInstructionType() {
        return insType;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getObjectName() {
        return objectName;
    }

    public int getValue() {
        return value;
    }
}

public class SecureSystem {
    private ArrayList<S_Subject> subjList; 
    
    public class S_Subject {
        private String name;
        private String securityLevel;
        private int temp = 0;
        public S_Subject(String n, SecurityLevel level) {
            name = n;
            securityLevel = level;
        }

        public void setTemp(int t) {
            temp = t;
        }
    }

    static public InstructionObject parseArgs(String[] args){
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

    public static void main(String[] args) throws IOException {

        // Create two new subjects
        S_Subject hal = new S_Subject("hal", SecurityLevel.HIGH);
        S_Subject lyle = new S_Subject("lyle", SecurityLevel.LOW);

        // Create two new objects
        ReferenceMonitor sys = new ReferenceMonitor();
        sys.createObject("lobj", "LOW");
        sys.createObject("hobj", "HIGH");

        subjList = new ArrayList<S_Subject>();
        subjList.add(hal);
        subjList.add(lyle);

        parseArgs(args);
    }
}
