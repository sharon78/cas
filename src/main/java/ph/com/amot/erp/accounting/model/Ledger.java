package ph.com.amot.erp.accounting.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ph.com.amot.erp.accounting.enums.EntryTransaction;

@SuppressWarnings("serial")
@Entity
@Table(name = "GENERAL_LEDGER")
public class Ledger
	implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "SEQ")
    private String seq;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ACCT_ID")
    private Account account;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "JOURNAL_ID")
    private Journal journal;

    @JsonIgnore
    @OneToOne(mappedBy = "ledgerAccount")
    private JournalEntry journalEntry;

    // json fields
    @Transient
    private long journalId;

    @Transient
    @Temporal(TemporalType.DATE)
    private Date journalDate;

    @Transient
    private String particulars;

    @Transient
    private EntryTransaction transaction;

    @Transient
    private double amount;

    public long getId() {
	return id;
    }

    public String getSeq() {
	return seq;
    }

    public Account getAccount() {
	return account;
    }

    public Journal getJournal() {
	return journal;
    }

    public JournalEntry getJournalEntry() {
	return journalEntry;
    }

    public long getJournalId() {
	return journal.getId();
    }

    public Date getJournalDate() {
	return journal.getJournalDate();
    }

    public String getParticulars() {
	return journal.getJournalDescription();
    }

    public EntryTransaction getTransaction() {
	return journalEntry.getTransaction();
    }

    public double getAmount() {
	return journalEntry.getAmount();
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public void setAccount(Account account) {
	this.account = account;
    }

    public void setJournal(Journal journal) {
	this.journal = journal;
    }

    public void setJournalEntry(JournalEntry journalEntry) {
	this.journalEntry = journalEntry;
    }

    public void setJournalId(long journalId) {
	this.journalId = journalId;
    }

    public void setJournalDate(Date journalDate) {
	this.journalDate = journalDate;
    }

    public void setParticulars(String particulars) {
	this.particulars = particulars;
    }

    public void setTransaction(EntryTransaction transaction) {
	this.transaction = transaction;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

}
