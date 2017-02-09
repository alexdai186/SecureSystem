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
    public InstructionObject(InstructionType i) { insType = i; }
    // public InstructionObject(InstructionType i, String sName, String oName) {
    //     insType = i;
    //     subjectName = sName;
    //     objectName = oName;
    //     value = v;
    // }
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
