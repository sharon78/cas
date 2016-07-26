/**
 * Chart of Accounts
 * 
 * */
package ph.com.cas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ph.com.cas.model.template.AccountingTemplateDetail;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT")
public class Account
	implements Serializable {

    @Id
    @Column(name = "ACCT_CODE", nullable = false)
    private String accountCode;

    @Column(name = "ACCT_CODE_CREF", nullable = true)
    private String accountCrossRef;

    @Column(name = "SEQ", nullable = false)
    private String seq;

    @Column(name = "ACCT_TITLE", nullable = false)
    private String accountTitle;

    @Column(name = "ACCT_DESC", nullable = false)
    private String accountDescription;

    @Temporal(TemporalType.DATE)
    @Column(name = "EFF_DATE", nullable = false)
    private Date effectiveDate;

    @Column(name = "VERSION", nullable = false)
    private int version;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private Set<JournalEntry> journalEntries;

    @OneToMany(mappedBy = "account")
    private List<Ledger> ledgerAccounts;

    @OneToOne(mappedBy = "account")
    private AccountingTemplateDetail accountingTemplateDetails;

    public String getAccountCode() {
	return accountCode;
    }

    public String getAccountCrossRef() {
	return accountCrossRef;
    }

    public String getSeq() {
	return seq;
    }

    public String getAccountTitle() {
	return accountTitle;
    }

    public String getAccountDescription() {
	return accountDescription;
    }

    public Date getEffectiveDate() {
	return effectiveDate;
    }

    public int getVersion() {
	return version;
    }

    public Set<JournalEntry> getJournalEntries() {
	return journalEntries;
    }

    public List<Ledger> getLedgerAccounts() {
	return ledgerAccounts;
    }

    public AccountingTemplateDetail getAccountingTemplateDetails() {
	return accountingTemplateDetails;
    }

    public void setAccountCode(String accountCode) {
	this.accountCode = accountCode;
    }

    public void setAccountCrossRef(String accountCrossRef) {
	this.accountCrossRef = accountCrossRef;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public void setAccountTitle(String accountTitle) {
	this.accountTitle = accountTitle;
    }

    public void setAccountDescription(String accountDescription) {
	this.accountDescription = accountDescription;
    }

    public void setEffectiveDate(Date effectiveDate) {
	this.effectiveDate = effectiveDate;
    }

    public void setVersion(int version) {
	this.version = version;
    }

    public void setJournalEntries(Set<JournalEntry> journalEntries) {
	this.journalEntries = journalEntries;
    }

    public void setLedgerAccounts(List<Ledger> ledgerAccounts) {
	this.ledgerAccounts = ledgerAccounts;
    }

    public void setAccountingTemplateDetails(AccountingTemplateDetail accountingTemplateDetails) {
	this.accountingTemplateDetails = accountingTemplateDetails;
    }

}
