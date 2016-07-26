package ph.com.cas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.cas.model.Journal;

public interface JournalRepository
	extends JpaRepository<Journal, Long> {

    Journal findById(long id);

    List<Journal> findByJournalDate(Date journalDate);

}
