package ph.com.cas.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.com.cas.algorithm.JournalTemplateProcessor;
import ph.com.cas.model.Journal;
import ph.com.cas.model.JournalEntry;
import ph.com.cas.model.dto.JournalDto;
import ph.com.cas.model.dto.JournalEntryDto;
import ph.com.cas.model.dto.JournalListDto;
import ph.com.cas.repository.JournalRepository;
import ph.com.cas.service.JournalEntryService;

@Controller
@RequestMapping(value = "/journal")
public class JournalController {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus addJournal(@RequestBody JournalEntryDto journalDto) {
	try {
	    Set<JournalEntry> journalEntry = journalTemplateProcessor.processAlgoritm(journalDto);
	    journalService.createJournalEntry(journalEntry);
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

	    if (e instanceof ClassNotFoundException) {

	    }

	    if (e instanceof InstantiationException) {

	    }

	    if (e instanceof IllegalAccessException) {

	    }
	}
	return HttpStatus.CREATED;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public JournalListDto listAllJournal() {

	JournalListDto journalListDto = new JournalListDto();

	List<Journal> journals = journalRepository.findAll();

	journalListDto.setJournals(journals);

	return journalListDto;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JournalDto retrieveJournalByJournalNo(@PathVariable long id) {

	JournalDto journalDto = new JournalDto();
	Journal journal = journalRepository.findById(id);
	journalDto.setJournal(journal);

	return journalDto;
    }

    @Autowired
    private JournalTemplateProcessor journalTemplateProcessor;

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private JournalEntryService journalService;
}
