package sakibul.domain;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String selected;

    Gender(String selected) {
        this.selected = selected;
    }

    public String getSelected() {
        return selected;
    }
}
