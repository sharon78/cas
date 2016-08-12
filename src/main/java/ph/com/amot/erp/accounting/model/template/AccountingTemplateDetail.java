package ph.com.amot.erp.accounting.model.template;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ph.com.amot.erp.accounting.enums.EntryTransaction;
import ph.com.amot.erp.accounting.model.Account;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT_TEMPLATE_DETAILS")
public class AccountingTemplateDetail
	implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "SEQ", nullable = false)
    private String seq;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "ACCT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_ACCT_ID"))
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCT_ENTRY", nullable = false)
    private EntryTransaction transaction;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEMPLATE_ID", foreignKey = @ForeignKey(name = "FK_TEMPLATE_ID"))
    private AccountingTemplate accountingTemplate;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getSeq() {
	return seq;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public Account getAccount() {
	return account;
    }

    public void setAccount(Account account) {
	this.account = account;
    }

    public EntryTransaction getTransaction() {
	return transaction;
    }

    public void setTransaction(EntryTransaction transaction) {
	this.transaction = transaction;
    }

    public AccountingTemplate getAccountingTemplate() {
	return accountingTemplate;
    }

    public void setAccountingTemplate(AccountingTemplate accountingTemplate) {
	this.accountingTemplate = accountingTemplate;
    }

    @Override
    public String toString() {
	return "AccountingTemplateDetails [id=" + id + ", seq=" + seq + ", account=" + account + ", transaction="
		+ transaction + ", accountingTemplate=" + accountingTemplate + "]";
    }

}
