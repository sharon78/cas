package ph.com.amot.erp.accounting.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.com.amot.erp.accounting.model.Account;
import ph.com.amot.erp.accounting.model.Ledger;
import ph.com.amot.erp.accounting.model.dto.LedgerDto;
import ph.com.amot.erp.accounting.repository.AccountRepository;
import ph.com.amot.erp.accounting.repository.LedgerRepository;

@Controller
@RequestMapping(value = "/ledger")
public class LedgerController {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerController.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public LedgerDto listLedger() {

	LedgerDto ledgerDto = new LedgerDto();

	List<Account> accounts = accountRepository.findAll();

	ledgerDto.setAccounts(accounts);

	return ledgerDto;
    }

    @RequestMapping(value = "/journal/journaldate/between[{lowDateString},{highDateString}]", method = RequestMethod.GET)
    @ResponseBody
    public LedgerDto listLedgerBetweenDates(@PathVariable String lowDateString, @PathVariable String highDateString)
	    throws ParseException {

	SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

	Date lowDate = formatter.parse(lowDateString);
	Date highDate = formatter.parse(highDateString);

	LOG.info(">>> lowDate >" + lowDate);
	LOG.info(">>> highDate >" + highDate);

	LedgerDto ledgerDto = new LedgerDto();

	List<Account> accounts = accountRepository.findAll();

	LOG.info(">>> accounts >" + accounts.size());

	for (Account account : accounts) {
	    List<Ledger> ledgers = ledgerRepository.findAllBetweenDates(account.getAccountCode(), lowDate, highDate);
	    LOG.info(">>> ledgers >" + ledgers.size());
	    account.setJournals(ledgers);
	}

	ledgerDto.setAccounts(accounts);

	return ledgerDto;
    }

    @RequestMapping(value = "/journal/journaldate/month[{month}]", method = RequestMethod.GET)
    @ResponseBody
    public LedgerDto listLedgerForMonth() {
	return null;
    }

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private LedgerRepository ledgerRepository;
}
