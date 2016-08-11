package ph.com.amot.erp.accounting.model.dto;

public class TrialBalanceAccountDto {

    private String seq;
    private String accountCode;
    private String accountTitle;
    private Boolean isGroupTitle;
    private int tab;
    private double debitAmount;
    private double creditAmount;

    public String getSeq() {
	return seq;
    }

    public String getAccountCode() {
	return accountCode;
    }

    public String getAccountTitle() {
	return accountTitle;
    }

    public Boolean getIsGroupTitle() {
	return isGroupTitle;
    }

    public int getTab() {
	return tab;
    }

    public double getDebitAmount() {
	return debitAmount;
    }

    public double getCreditAmount() {
	return creditAmount;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public void setAccountCode(String accountCode) {
	this.accountCode = accountCode;
    }

    public void setAccountTitle(String accountTitle) {
	this.accountTitle = accountTitle;
    }

    public void setIsGroupTitle(Boolean isGroupTitle) {
	this.isGroupTitle = isGroupTitle;
    }

    public void setTab(int tab) {
	this.tab = tab;
    }

    public void setDebitAmount(double debitAmount) {
	this.debitAmount = debitAmount;
    }

    public void setCreditAmount(double creditAmount) {
	this.creditAmount = creditAmount;
    }

}
