package ph.com.amot.erp.accounting.controller;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import ph.com.amot.erp.accounting.enums.EntryTransaction;
import ph.com.amot.erp.accounting.model.Account;
import ph.com.amot.erp.accounting.model.template.AccountingTemplate;
import ph.com.amot.erp.accounting.model.template.AccountingTemplateDetail;
import ph.com.amot.erp.accounting.repository.AccountRepository;
import ph.com.amot.erp.accounting.repository.AccountingTemplateDetailRepository;
import ph.com.amot.erp.accounting.repository.AccountingTemplateRepository;
import ph.com.amot.erp.accounting.service.AccountService;
import ph.com.amot.erp.accounting.xml.AccountXMLContentHandler;

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
	account.setIsGroupTitle(false);

	acctRepository.save(account);

	Account account2 = new Account();
	account2.setAccountCode("2000");
	account2.setAccountTitle("Accounts Payable");
	account2.setAccountDescription("Accounts Payable");
	account2.setEffectiveDate(new Date());
	account2.setSeq("02");
	account2.setVersion(1);
	account2.setAccountCrossRef("0000");
	account.setIsGroupTitle(false);

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

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    @ResponseBody
    public HttpStatus test() throws SAXException, IOException {
	LOG.info("********* testAccount()");

	FileInputStream fileInputStream;
	fileInputStream = new FileInputStream("c:\\accounts.xml");

	InputSource source = new InputSource(fileInputStream);

	XMLReader parser = XMLReaderFactory.createXMLReader();
	AccountXMLContentHandler xmlHandler = new AccountXMLContentHandler();
	parser.setContentHandler(xmlHandler);
	parser.parse(source);

	accountService.createAccounts(xmlHandler.getAccounts());

	return HttpStatus.OK;
    }

    @Autowired
    AccountRepository acctRepository;

    @Autowired
    AccountingTemplateRepository accountingTemplateRepository;

    @Autowired
    AccountingTemplateDetailRepository accountingTemplateDetailRepository;

    @Autowired
    AccountService accountService;
}
