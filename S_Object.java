class S_Object {
    private String name;
    private SecurityLevel securityLevel;
    private int temp = 0;

    public S_Object(String n, SecurityLevel level) {
        name = n;
        securityLevel = level;
    }

    public void setTemp(int t) {
        temp = t;
    }
}