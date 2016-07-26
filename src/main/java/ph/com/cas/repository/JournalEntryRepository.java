package ph.com.cas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ph.com.cas.model.JournalEntry;

public interface JournalEntryRepository
	extends JpaRepository<JournalEntry, Long> {

    @Query("from JournalEntry j where j.journal.journalDate between :lowDate and :highDate")
    List<JournalEntry> findAllBetweenDates(@Param("lowDate") Date lowDate, @Param("highDate") Date highDate);
}
