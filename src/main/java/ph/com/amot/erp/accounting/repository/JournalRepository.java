package ph.com.amot.erp.accounting.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.amot.erp.accounting.model.Journal;

public interface JournalRepository
	extends JpaRepository<Journal, Long> {

    Journal findById(long id);

    List<Journal> findByJournalDate(Date journalDate);

}
