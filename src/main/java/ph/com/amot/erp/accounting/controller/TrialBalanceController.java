package ph.com.amot.erp.accounting.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.com.amot.erp.accounting.enums.EntryTransaction;
import ph.com.amot.erp.accounting.model.Account;
import ph.com.amot.erp.accounting.model.JournalEntry;
import ph.com.amot.erp.accounting.model.dto.TrialBalanceAccountDto;
import ph.com.amot.erp.accounting.model.dto.TrialBalanceDto;
import ph.com.amot.erp.accounting.repository.AccountRepository;

@Controller
@RequestMapping(value = "/trialbalance")
public class TrialBalanceController {

    @RequestMapping(value = "/year/{year}", method = RequestMethod.GET)
    @ResponseBody
    public TrialBalanceDto viewTrialBalanceByYear(@PathVariable("year") int year) {

	List<Account> accounts = accountRepository.findAll();
	List<TrialBalanceAccountDto> trialBalanceAccountDtos = new ArrayList<TrialBalanceAccountDto>();
	TrialBalanceDto trialBalanceDto = new TrialBalanceDto();
	double totalDebit = 0;
	double totalCredit = 0;

	for (Account account : accounts) {
	    TrialBalanceAccountDto trialBalanceAccountDto = mapAccountToDto(account);
	    trialBalanceAccountDtos.add(trialBalanceAccountDto);
	    totalDebit = totalDebit + trialBalanceAccountDto.getDebitAmount();
	    totalCredit = totalCredit + trialBalanceAccountDto.getCreditAmount();
	}

	trialBalanceDto.setAccounts(trialBalanceAccountDtos);
	trialBalanceDto.setTotalDebit(totalDebit);
	trialBalanceDto.setTotalCredit(totalCredit);

	return trialBalanceDto;
    }

    @RequestMapping(value = "/month/{month}", method = RequestMethod.GET)
    @ResponseBody
    public void viewTrialBalanceByMonth(@PathVariable("month") int month) {

    }

    private TrialBalanceAccountDto mapAccountToDto(Account account) {

	TrialBalanceAccountDto trialBalanceAccountDto = new TrialBalanceAccountDto();
	trialBalanceAccountDto.setAccountCode(account.getAccountCode());
	trialBalanceAccountDto.setAccountTitle(account.getAccountTitle());
	trialBalanceAccountDto.setSeq(account.getSeq());
	trialBalanceAccountDto.setIsGroupTitle(account.getIsGroupTitle());
	trialBalanceAccountDto.setTab(account.getLevel() == 0 ? 0 : account.getLevel() * 10);

	Set<JournalEntry> journalEntries = account.getJournalEntries();

	double debitAmount = 0;
	double creditAmount = 0;

	for (JournalEntry journalEntry : journalEntries) {
	    if (EntryTransaction.DEBIT.equals(journalEntry.getTransaction())) {
		debitAmount = debitAmount + journalEntry.getAmount();
	    } else if (EntryTransaction.CREDIT.equals(journalEntry.getTransaction())) {
		creditAmount = creditAmount + journalEntry.getAmount();
	    }
	}

	trialBalanceAccountDto.setDebitAmount(debitAmount);
	trialBalanceAccountDto.setCreditAmount(creditAmount);

	return trialBalanceAccountDto;
    }

    @Autowired
    AccountRepository accountRepository;
}
