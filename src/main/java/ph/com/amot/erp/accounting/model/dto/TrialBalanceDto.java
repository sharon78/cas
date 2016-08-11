package ph.com.amot.erp.accounting.model.dto;

import java.util.List;

public class TrialBalanceDto {

    private List<TrialBalanceAccountDto> accounts;
    private double totalDebit;
    private double totalCredit;

    public List<TrialBalanceAccountDto> getAccounts() {
	return accounts;
    }

    public void setAccounts(List<TrialBalanceAccountDto> accounts) {
	this.accounts = accounts;
    }

    public double getTotalDebit() {
	return totalDebit;
    }

    public double getTotalCredit() {
	return totalCredit;
    }

    public void setTotalDebit(double totalDebit) {
	this.totalDebit = totalDebit;
    }

    public void setTotalCredit(double totalCredit) {
	this.totalCredit = totalCredit;
    }

}
