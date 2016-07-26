package ph.com.cas.model.dto;

import java.util.List;

import ph.com.cas.model.Account;

public class LedgerDto {

    private List<Account> accounts;

    public List<Account> getAccounts() {
	return accounts;
    }

    public void setAccounts(List<Account> accounts) {
	this.accounts = accounts;
    }

}
