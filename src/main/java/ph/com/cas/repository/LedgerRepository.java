package ph.com.cas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ph.com.cas.model.Account;
import ph.com.cas.model.Ledger;

public interface LedgerRepository
	extends JpaRepository<Ledger, Long> {

    List<Ledger> findByAccount(Account account);

    @Query("from Ledger l where (l.journalEntry.journal.journalDate between :lowDate and :highDate) and l.account=:account")
    List<Ledger> findAllBetweenDates(@Param("account") Account account, @Param("lowDate") Date lowDate,
	    @Param("highDate") Date highDate);

}
