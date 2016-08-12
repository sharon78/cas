package ph.com.amot.erp.accounting.model.subsidiary;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ph.com.amot.erp.accounting.enums.SubsidiaryType;

@SuppressWarnings("serial")
@Entity
@Table(name = "CHEQUE_REGISTER")
public class Cheque
	implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "SEQ")
    private String seq;

    @Column(name = "SUB_TYPE_ID")
    private SubsidiaryType subsidiaryType;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "BANK_BRANCH")
    private String bankBranch;

    @Column(name = "CHEQUE_NO")
    private String chequeNumber;

    @Column(name = "PARTICULARS")
    private String particulars;

    @Column(name = "AMOUNT")
    private double amount;

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

    public SubsidiaryType getSubsidiaryType() {
	return subsidiaryType;
    }

    public void setSubsidiaryType(SubsidiaryType subsidiaryType) {
	this.subsidiaryType = subsidiaryType;
    }

    public String getBankName() {
	return bankName;
    }

    public void setBankName(String bankName) {
	this.bankName = bankName;
    }

    public String getBankBranch() {
	return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
	this.bankBranch = bankBranch;
    }

    public String getChequeNumber() {
	return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
	this.chequeNumber = chequeNumber;
    }

    public String getParticulars() {
	return particulars;
    }

    public void setParticulars(String particulars) {
	this.particulars = particulars;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

}
