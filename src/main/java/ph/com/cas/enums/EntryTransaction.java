package ph.com.cas.enums;

public enum EntryTransaction {
    DEBIT("dr"), CREDIT("cr");

    private String value;

    private EntryTransaction(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }
}
