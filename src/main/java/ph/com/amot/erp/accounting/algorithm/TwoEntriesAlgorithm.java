package ph.com.amot.erp.accounting.algorithm;

import ph.com.amot.erp.accounting.model.JournalEntry;

/**
 * This is the default algorithm if, no algorithm is present in a template
 * 
 * @author Sharon Amot &copy 2016
 * @since July 2016
 * @version 1.0
 */
public class TwoEntriesAlgorithm
	extends AlgorithmSpot {

    /**
     * Iterates <b>journalEntries</b> and set amount.
     */
    @Override
    public void invoke() {

	for (JournalEntry journalEntry : journalEntries) {
	    journalEntry.setAmount(getJournalDto().getAmount());
	}
    }

}
