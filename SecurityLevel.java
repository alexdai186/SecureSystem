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
