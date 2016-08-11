package ph.com.amot.erp.accounting.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.amot.erp.accounting.model.Account;
import ph.com.amot.erp.accounting.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Boolean createAccounts(Set<Account> accounts) {

	accountRepository.save(accounts);

	return Boolean.TRUE;
    }
}
