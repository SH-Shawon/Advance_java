package sakibul.domain;

public enum Country {
    BANGLADESH("Bangladesh"),
    INDIA("India"),
    JAPAN("Japan");


    private final String selectedCountry;
    Country(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public String getSelectedCountry() {
        return selectedCountry;
    }
}
