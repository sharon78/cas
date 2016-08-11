package ph.com.amot.erp.accounting.enums;

/**
 * sequence will be increased by ONE, FIVE, TEN, FIFTEEN or TWENTY
 */
public enum SequenceGroup {

    ONE(1), FIVE(5), TEN(10), FIFTEEN(15), TWENTY(20);

    private int value;

    private SequenceGroup(int value) {
	this.value = value;
    }

    public int getValue() {
	return value;
    }
}
