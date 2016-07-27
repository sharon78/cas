/**
 * copyright 2016 by SMA-Tech
 * 
 * Journal is a book that is maintained on a daily basis for 
 * recording all the financial entries of the day. Passing the 
 * entries is called journal entry. Journal entries are passed 
 * according to rules of debit and credit of double entry system.
 * 
 * */
package ph.com.cas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ph.com.cas.enums.EntryTransaction;

@SuppressWarnings("serial")
@Entity
@Table(name = "JOURNAL")
public class Journal
	implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "SEQ", nullable = false)
    private String seq;

    @Temporal(TemporalType.DATE)
    @Column(name = "JOURNAL_DATE", nullable = false)
    private Date journalDate;

    @Column(name = "JOURNAL_DESC", nullable = false)
    private String journalDescription;

    @OneToMany(mappedBy = "journal", fetch = FetchType.LAZY)
    private Set<JournalEntry> journalEntries;

    @OneToMany(mappedBy = "journal", fetch = FetchType.LAZY)
    private Set<Ledger> ledgerAccounts;

    public long getId() {
	return id;
    }

    public String getSeq() {
	return seq;
    }

    public Date getJournalDate() {
	return journalDate;
    }

    public String getJournalDescription() {
	return journalDescription;
    }

    public Set<JournalEntry> getJournalEntries() {
	return journalEntries;
    }

    public Set<Ledger> getLedgerAccounts() {
	return ledgerAccounts;
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public void setJournalDate(Date journalDate) {
	this.journalDate = journalDate;
    }

    public void setJournalDescription(String journalDescription) {
	this.journalDescription = journalDescription;
    }

    public void setJournalEntries(Set<JournalEntry> journalEntries) {
	this.journalEntries = journalEntries;
    }

    public void setLedgerAccounts(Set<Ledger> ledgerAccounts) {
	this.ledgerAccounts = ledgerAccounts;
    }

    public Boolean isJournalEntriesEqual() {

	Boolean isEqual = Boolean.FALSE;
	double creditAmt = 0.00;
	double debitAmt = 0.00;

	for (JournalEntry journalEntry : journalEntries) {

	    if (journalEntry.getTransaction().equals(EntryTransaction.DEBIT)) {
		debitAmt = +journalEntry.getAmount();
	    } else if (journalEntry.getTransaction().equals(EntryTransaction.CREDIT)) {
		creditAmt = +journalEntry.getAmount();
	    }
	}

	if (debitAmt == creditAmt) {
	    isEqual = Boolean.TRUE;
	}

	return isEqual;
    }

    @Override
    public String toString() {
	return "Journal [id=" + id + ", seq=" + seq + ", journalDate=" + journalDate + ", journalDescription="
		+ journalDescription + ", journalEntries=" + journalEntries + ", ledgerAccounts=" + ledgerAccounts
		+ "]";
    }

}
