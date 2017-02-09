class S_Object {
    private String name;
    private SecurityLevel securityLevel;
    private int value = 0;

    public S_Object(String n, SecurityLevel level) {
        name = n;
        securityLevel = level;
    }

    public void setValue(int v) {
        value = v;
    }
}