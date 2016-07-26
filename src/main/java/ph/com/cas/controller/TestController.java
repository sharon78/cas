package ph.com.cas.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.com.cas.enums.EntryTransaction;
import ph.com.cas.model.Account;
import ph.com.cas.model.template.AccountingTemplate;
import ph.com.cas.model.template.AccountingTemplateDetail;
import ph.com.cas.repository.AccountRepository;
import ph.com.cas.repository.AccountingTemplateDetailRepository;
import ph.com.cas.repository.AccountingTemplateRepository;

@Controller
@RequestMapping(value = "/testdata")
public class TestController {
    Logger LOG = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public HttpStatus home() {
	LOG.info("********* testAccount()");

	Account account = new Account();
	account.setAccountCode("1000");
	account.setAccountTitle("Cash on hand");
	account.setAccountDescription("Cash on hand");
	account.setEffectiveDate(new Date());
	account.setSeq("01");
	account.setVersion(1);
	account.setAccountCrossRef("0000");

	acctRepository.save(account);

	Account account2 = new Account();
	account2.setAccountCode("2000");
	account2.setAccountTitle("Accounts Payable");
	account2.setAccountDescription("Accounts Payable");
	account2.setEffectiveDate(new Date());
	account2.setSeq("02");
	account2.setVersion(1);
	account2.setAccountCrossRef("0000");

	acctRepository.save(account2);

	AccountingTemplate accountingTemplate = new AccountingTemplate();
	accountingTemplate.setSeq("01");
	accountingTemplate.setTemplateCode("PAY01");
	accountingTemplate.setTemplateDescription("Payment of Bill");

	Set<AccountingTemplateDetail> accountingTemplateDetails = new HashSet<AccountingTemplateDetail>();

	AccountingTemplateDetail accountingTemplateDetail = new AccountingTemplateDetail();
	accountingTemplateDetail.setAccount(account2);
	accountingTemplateDetail.setSeq("01");
	accountingTemplateDetail.setTransaction(EntryTransaction.DEBIT);
	accountingTemplateDetail.setAccountingTemplate(accountingTemplate);
	accountingTemplateDetails.add(accountingTemplateDetail);

	AccountingTemplateDetail accountingTemplateDetail2 = new AccountingTemplateDetail();
	accountingTemplateDetail2.setAccount(account);
	accountingTemplateDetail2.setSeq("02");
	accountingTemplateDetail2.setTransaction(EntryTransaction.CREDIT);
	accountingTemplateDetail2.setAccountingTemplate(accountingTemplate);
	accountingTemplateDetails.add(accountingTemplateDetail2);

	// accountingTemplateRepository.save(accountingTemplate);
	accountingTemplateDetailRepository.save(accountingTemplateDetails);

	return HttpStatus.OK;
    }

    @Autowired
    AccountRepository acctRepository;

    @Autowired
    AccountingTemplateRepository accountingTemplateRepository;

    @Autowired
    AccountingTemplateDetailRepository accountingTemplateDetailRepository;
}
