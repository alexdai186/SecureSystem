/**
 * Secure System Object
 */
class S_Object {
    private String name;
    private SecurityLevel securityLevel;
    private int value = 0;

    public S_Object(String n, SecurityLevel level) {
        name = n;
        securityLevel = level;
    }
    // Getters
    public String getName(){
        return name;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public int getValue() {
        return value;
    }    
    // Setter
    public void setValue(int v) {
        value = v;
    }
}