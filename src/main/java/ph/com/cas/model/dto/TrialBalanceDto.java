package ph.com.cas.model.dto;

import java.util.List;

public class TrialBalanceDto {

    List<TrialBalanceAccountDto> accounts;

    public List<TrialBalanceAccountDto> getAccounts() {
	return accounts;
    }

    public void setAccounts(List<TrialBalanceAccountDto> accounts) {
	this.accounts = accounts;
    }

}
