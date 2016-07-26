package ph.com.cas.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ph.com.cas.enums.EntryTransaction;

@SuppressWarnings("serial")
@Entity
@Table(name = "JOURNAL_ENTRY")
public class JournalEntry
	implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "SEQ", nullable = false)
    private String seq;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "JOURNAL_ID", nullable = false)
    private Journal journal;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_CODE", nullable = false)
    private Account account;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LEDGER_ID", nullable = false)
    private Ledger ledgerAccount;

    @JsonIgnore
    @OneToOne(mappedBy = "journalEntry")
    private SubsidiaryDistribution subsidiaryDistribution;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCT_ENTRY", nullable = false)
    private EntryTransaction transaction;

    @Column(name = "AMOUNT", nullable = false)
    private double amount;

    @Transient
    private long journalId;

    @Transient
    private String accountCode;

    @Transient
    private long ledgerId;

    public long getId() {
	return id;
    }

    public String getSeq() {
	return seq;
    }

    public Journal getJournal() {
	return journal;
    }

    public Account getAccount() {
	return account;
    }

    public Ledger getLedgerAccount() {
	return ledgerAccount;
    }

    public SubsidiaryDistribution getSubsidiaryDistribution() {
	return subsidiaryDistribution;
    }

    public EntryTransaction getTransaction() {
	return transaction;
    }

    public double getAmount() {
	return amount;
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public void setJournal(Journal journal) {
	this.journal = journal;
    }

    public void setAccount(Account account) {
	this.account = account;
    }

    public void setLedgerAccount(Ledger ledgerAccount) {
	this.ledgerAccount = ledgerAccount;
    }

    public void setSubsidiaryDistribution(SubsidiaryDistribution subsidiaryDistribution) {
	this.subsidiaryDistribution = subsidiaryDistribution;
    }

    public void setTransaction(EntryTransaction transaction) {
	this.transaction = transaction;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    @Override
    public String toString() {
	return "JournalEntry [id=" + id + ", seq=" + seq + ", journal=" + journal + ", account=" + account
		+ ", ledgerAccount=" + ledgerAccount + ", subsidiaryDistribution=" + subsidiaryDistribution
		+ ", transaction=" + transaction + ", amount=" + amount + "]";
    }

}
