package ph.com.amot.erp.accounting.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ph.com.amot.erp.accounting.model.Account;
import ph.com.amot.erp.accounting.model.Ledger;

public interface LedgerRepository
	extends JpaRepository<Ledger, Long> {

    List<Ledger> findByAccount(Account account);

    @Query("from Ledger l where (l.journalEntry.journal.journalDate between :lowDate and :highDate) and l.account.accountCode=:accountCode")
    List<Ledger> findAllByMonth();

    @Query("from Ledger l where (l.journalEntry.journal.journalDate between :lowDate and :highDate) and l.account.accountCode=:accountCode")
    List<Ledger> findAllBetweenDates(@Param("accountCode") String accountCode, @Param("lowDate") Date lowDate,
	    @Param("highDate") Date highDate);

}
