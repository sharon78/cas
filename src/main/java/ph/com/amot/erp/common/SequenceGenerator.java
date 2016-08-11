package ph.com.amot.erp.common;

import ph.com.amot.erp.accounting.enums.SequenceGroup;
import ph.com.amot.erp.common.ERPConstants;

/**
 * Utility for generating sequence number
 */
public class SequenceGenerator {

    private static int seqNo = 0;

    public SequenceGenerator() {

    }

    /**
     * restart the sequence number.
     */
    public static void newSeq() {
	seqNo = 0;
    }

    /**
     * generate the sequence number.
     * 
     * @param sequenceGroup
     *            - of enum SequenceGroup
     */
    public static String getSeqNo(SequenceGroup sequenceGroup) {

	String newSeqNo;
	StringBuilder newSeqGen = new StringBuilder();

	seqNo = sequenceGroup.getValue() + seqNo;
	newSeqNo = String.valueOf(seqNo);

	if (newSeqNo.trim().length() < 2) {
	    newSeqGen.append(ERPConstants.ZERO_STRING).append(newSeqNo);
	    newSeqNo = newSeqGen.toString();
	}

	return newSeqNo;
    }
}
