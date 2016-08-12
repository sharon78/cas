package ph.com.amot.erp.accounting.algorithm;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.com.amot.erp.accounting.model.JournalEntry;
import ph.com.amot.erp.accounting.model.dto.JournalEntryDto;
import ph.com.amot.erp.accounting.model.template.AccountingTemplate;
import ph.com.amot.erp.accounting.model.template.AccountingTemplateAlgorithm;
import ph.com.amot.erp.accounting.repository.AccountingTemplateRepository;

/**
 * @author Sharon Amot &copy 2016
 * @since July 2016
 * @version 1.0
 */
@Component
public class JournalTemplateProcessor {

    private JournalEntryDto journalDto;
    private AlgorithmSpot algoSpot;

    public JournalTemplateProcessor() {

    }

    /**
     * Retrieves algorithm(s) from template and process each algorithm by
     * calling invoke() method
     * 
     * @param templateCode
     *            - String type.
     * @return none
     * @see AlgorithmSpot.invoke()
     */
    public Set<JournalEntry> processAlgoritm(JournalEntryDto journalDto) throws ClassNotFoundException,
	    InstantiationException, IllegalAccessException {

	String templateCode = journalDto.getTemplateCode();
	AccountingTemplate accountingTemplate = templateRepository.findByTemplateCode(templateCode);

	if (accountingTemplate != null) {

	    Set<AccountingTemplateAlgorithm> templateAlgoritms = accountingTemplate.getTemplateAlgorithm();

	    if (templateAlgoritms.isEmpty()) {
		algoSpot = new TwoEntriesAlgorithm();
		algoSpot.setAccountingTemplate(accountingTemplate);
		algoSpot.setJournalDto(journalDto);
		algoSpot.invoke();
		algoSpot.setIsAccountEntryCreated(Boolean.FALSE);
	    } else {

		for (AccountingTemplateAlgorithm templateAlgorithm : templateAlgoritms) {

		    Class<?> algoClass = Class.forName(templateAlgorithm.getAlgorithmClass());
		    algoSpot = (AlgorithmSpot) algoClass.newInstance();
		    algoSpot.setAccountingTemplate(accountingTemplate);
		    algoSpot.setAlgorithm(templateAlgorithm);
		    algoSpot.setJournalDto(journalDto);
		    algoSpot.invoke();
		}

		algoSpot.setIsAccountEntryCreated(Boolean.FALSE);
	    }
	    ledgerWriter.createLedgerEntry(algoSpot.getJournalEntries(), journalDto);
	    // subLedgerSpot = (SubsidiaryLedgerSpot) algoSpot;

	}
	return ledgerWriter.getNewJournalEntries();
    }

    public JournalEntryDto getJournalDto() {
	return journalDto;
    }

    public void setJournalDto(JournalEntryDto journalDto) {
	this.journalDto = journalDto;
    }

    @Autowired
    private LedgerWriter ledgerWriter;

    @Autowired
    private AccountingTemplateRepository templateRepository;
}
