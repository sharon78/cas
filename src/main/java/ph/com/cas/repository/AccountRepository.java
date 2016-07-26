package ph.com.cas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ph.com.cas.model.Account;

public interface AccountRepository
	extends CrudRepository<Account, String> {

    List<Account> findAll();

    List<Account> findByAccountCode(String accountCode);
}
