/**
 * Chart of Accounts
 * 
 * */
package ph.com.amot.erp.accounting.model;

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ph.com.amot.erp.accounting.model.template.AccountingTemplateDetail;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT")
public class Account
	implements Serializable {

    @Column(name = "SEQ", nullable = false)
    private String seq;

    @Id
    @Column(name = "ACCT_CODE", nullable = false)
    private String accountCode;

    @Column(name = "ACCT_CODE_CREF", nullable = true)
    private String accountCrossRef;

    @Column(name = "IS_GROUP_TITLE", nullable = false)
    private Boolean isGroupTitle;

    @Column(name = "ACCT_TITLE", nullable = false)
    private String accountTitle;

    @Column(name = "ACCT_DESC", nullable = false)
    private String accountDescription;

    @Temporal(TemporalType.DATE)
    @Column(name = "EFF_DATE", nullable = false)
    private Date effectiveDate;

    @Column(name = "VERSION", nullable = false)
    private int version;

    @Column(name = "LEVEL", nullable = false)
    private int level;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private Set<JournalEntry> journalEntries;

    @Transient
    private int journalsRecno;

    @OneToMany(mappedBy = "account")
    private List<Ledger> journals;

    @JsonIgnore
    @OneToOne(mappedBy = "account")
    private AccountingTemplateDetail accountingTemplateDetails;

    public String getSeq() {
	return seq;
    }

    public String getAccountCode() {
	return accountCode;
    }

    public String getAccountCrossRef() {
	return accountCrossRef;
    }

    public Boolean getIsGroupTitle() {
	return isGroupTitle;
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

    public int getLevel() {
	return level;
    }

    public Set<JournalEntry> getJournalEntries() {
	return journalEntries;
    }

    public int getJournalsRecno() {
	return journalsRecno;
    }

    public List<Ledger> getJournals() {
	return journals;
    }

    public AccountingTemplateDetail getAccountingTemplateDetails() {
	return accountingTemplateDetails;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public void setAccountCode(String accountCode) {
	this.accountCode = accountCode;
    }

    public void setAccountCrossRef(String accountCrossRef) {
	this.accountCrossRef = accountCrossRef;
    }

    public void setIsGroupTitle(Boolean isGroupTitle) {
	this.isGroupTitle = isGroupTitle;
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

    public void setLevel(int level) {
	this.level = level;
    }

    public void setJournalEntries(Set<JournalEntry> journalEntries) {
	this.journalEntries = journalEntries;
    }

    public void setJournalsRecno(int journalsRecno) {
	this.journalsRecno = journalsRecno;
    }

    public void setJournals(List<Ledger> journals) {
	this.journals = journals;
    }

    public void setAccountingTemplateDetails(AccountingTemplateDetail accountingTemplateDetails) {
	this.accountingTemplateDetails = accountingTemplateDetails;
    }

}
