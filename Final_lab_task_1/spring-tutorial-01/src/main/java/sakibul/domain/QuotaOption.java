package sakibul.domain;

import sakibul.domain.Quota;

public class QuotaOption {
    private String label;
    private Quota value;

    public QuotaOption(String label, Quota value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Quota getValue() {
        return value;
    }

    public void setValue(Quota value) {
        this.value = value;
    }


}

