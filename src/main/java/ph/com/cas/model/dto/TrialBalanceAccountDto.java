package ph.com.cas.model.dto;

public class TrialBalanceAccountDto {

    private String seq;
    private String accountCode;
    private String accountTitle;
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

    public void setDebitAmount(double debitAmount) {
	this.debitAmount = debitAmount;
    }

    public void setCreditAmount(double creditAmount) {
	this.creditAmount = creditAmount;
    }

}
