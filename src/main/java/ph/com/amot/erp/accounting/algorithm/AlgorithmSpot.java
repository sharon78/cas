package ph.com.amot.erp.accounting.algorithm;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ph.com.amot.erp.accounting.enums.SequenceGroup;
import ph.com.amot.erp.accounting.model.JournalEntry;
import ph.com.amot.erp.accounting.model.dto.JournalEntryDto;
import ph.com.amot.erp.accounting.model.template.AccountingTemplate;
import ph.com.amot.erp.accounting.model.template.AccountingTemplateAlgorithm;
import ph.com.amot.erp.accounting.model.template.AccountingTemplateDetail;
import ph.com.amot.erp.common.ERPConstants;
import ph.com.amot.erp.common.SequenceGenerator;

/**
 * To implement new Algorithm class, extend this class
 * 
 * @author Sharon Amot &copy 2016
 * @since July 2016
 * @version 1.0
 */
public abstract class AlgorithmSpot {

    private AccountingTemplate accountingTemplate;
    private AccountingTemplateAlgorithm algorithm;
    private JournalEntryDto journalDto;

    protected static Map<String, String> sessionVariables;
    protected static Set<JournalEntry> journalEntries;
    /**
     * always set this to Boolean.FALSE when work is done.
     */
    protected static Boolean isAccountEntryCreated = Boolean.FALSE;

    /**
     * Override this method for implementation
     * 
     * @return void
     */
    public abstract void invoke();

    public AccountingTemplate getAccountingTemplate() {
	return accountingTemplate;
    }

    public void setAccountingTemplate(AccountingTemplate accountingTemplate) {
	this.accountingTemplate = accountingTemplate;

	if (!isAccountEntryCreated) {

	    Set<AccountingTemplateDetail> templateDetails = accountingTemplate.getTemplateDetails();
	    journalEntries = new HashSet<JournalEntry>();

	    SequenceGenerator.newSeq();
	    for (AccountingTemplateDetail templateDetail : templateDetails) {
		JournalEntry journalEntry = new JournalEntry();
		journalEntry.setSeq(SequenceGenerator.getSeqNo(SequenceGroup.ONE));
		journalEntry.setAccount(templateDetail.getAccount());
		journalEntry.setAmount(ERPConstants.ZERO_AMOUNT);
		journalEntry.setTransaction(templateDetail.getTransaction());
		journalEntries.add(journalEntry);
	    }
	    isAccountEntryCreated = Boolean.TRUE;
	}
    }

    public AccountingTemplateAlgorithm getAlgorithm() {
	return algorithm;
    }

    public void setAlgorithm(AccountingTemplateAlgorithm algorithm) {
	this.algorithm = algorithm;
    }

    public JournalEntryDto getJournalDto() {
	return journalDto;
    }

    public void setJournalDto(JournalEntryDto journalDto) {
	this.journalDto = journalDto;
    }

    public Set<JournalEntry> getJournalEntries() {
	return journalEntries;
    }

    public Boolean getIsAccountEntryCreated() {
	return isAccountEntryCreated;
    }

    public void setIsAccountEntryCreated(Boolean isAccountEntryCreated) {
	AlgorithmSpot.isAccountEntryCreated = isAccountEntryCreated;
    }

}
