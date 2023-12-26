package sakibul.domain;

public enum Quota {
    NOTHING("N/A"),
    A("a"),
    B("b"),
    C("c");
    String value;

    Quota(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
