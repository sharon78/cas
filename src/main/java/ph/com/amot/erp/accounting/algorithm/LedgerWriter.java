package ph.com.amot.erp.accounting.algorithm;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import ph.com.amot.erp.accounting.enums.SequenceGroup;
import ph.com.amot.erp.accounting.model.Journal;
import ph.com.amot.erp.accounting.model.JournalEntry;
import ph.com.amot.erp.accounting.model.Ledger;
import ph.com.amot.erp.accounting.model.dto.JournalEntryDto;
import ph.com.amot.erp.common.SequenceGenerator;

/**
 * @author Sharon Amot &copy 2016
 * @since July 2016
 * @version 1.0
 */
@Component
public class LedgerWriter {

    private Set<JournalEntry> newJournalEntries;

    /**
     * Creates a ledger entry. Always set <b>isAccountEntryCreated</b> to
     * Boolean.FALSE at the end of the method.
     * 
     * @param none
     * @return none
     */
    public void createLedgerEntry(Set<JournalEntry> journalEntries, JournalEntryDto journalDto) {

	newJournalEntries = new HashSet<JournalEntry>();
	SequenceGenerator.newSeq();

	Journal journal = new Journal();
	journal.setJournalDate(journalDto.getJournalDate());
	journal.setJournalDescription(journalDto.getJournalDescription());
	SequenceGenerator.newSeq();
	journal.setSeq(SequenceGenerator.getSeqNo(SequenceGroup.ONE));

	SequenceGenerator.newSeq();
	for (JournalEntry journalEntry : journalEntries) {
	    Ledger ledger = new Ledger();
	    ledger.setSeq(SequenceGenerator.getSeqNo(SequenceGroup.ONE));
	    ledger.setAccount(journalEntry.getAccount());
	    ledger.setJournal(journal);
	    journalEntry.setLedgerAccount(ledger);
	    journalEntry.setJournal(journal);
	    newJournalEntries.add(journalEntry);
	}

    }

    public Set<JournalEntry> getNewJournalEntries() {
	return newJournalEntries;
    }

}
