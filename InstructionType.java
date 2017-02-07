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