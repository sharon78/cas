package ph.com.cas.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.cas.model.JournalEntry;
import ph.com.cas.repository.JournalEntryRepository;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public Boolean createJournalEntry(Set<JournalEntry> journalEntries) {

	journalEntryRepository.save(journalEntries);

	return true;
    }
}
