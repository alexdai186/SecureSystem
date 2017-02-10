/**
 * Secure System Subject
 */
class S_Subject {
    private String name;
    private SecurityLevel securityLevel;
    private int temp = 0;
    public S_Subject(String n, SecurityLevel level) {
        name = n;
        securityLevel = level;
    }
    // Getter
    public String getName(){
        return name;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public int getTemp() {
        return temp;
    }    
    // Setter
    public void setTemp(int t) {
        temp = t;
    }

}