package ph.com.amot.erp.accounting.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ph.com.amot.erp.accounting.model.Account;

public interface AccountRepository
	extends CrudRepository<Account, String> {

    List<Account> findAll();

    List<Account> findByAccountCode(String accountCode);

    @Query("from Ledger l where (l.journalEntry.journal.journalDate between :lowDate and :highDate)")
    List<Account> findAllBetweenDates(@Param("lowDate") Date lowDate, @Param("highDate") Date highDate);
}
