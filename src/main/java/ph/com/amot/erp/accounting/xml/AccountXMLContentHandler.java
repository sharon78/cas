package ph.com.amot.erp.accounting.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import ph.com.amot.erp.accounting.model.Account;

public class AccountXMLContentHandler
	implements ContentHandler {

    private static final String SEQ = "seq";
    private static final String EFFDATE = "effdate";
    private static final String VERSION = "ver";
    private static final String ACCOUNT = "account";
    private static final String CODE = "code";
    private static final String CODECREF = "codecref";
    private static final String TITLE = "title";
    private static final String DESC = "desc";
    private static final String ISGROUPTITLE = "isGroupTitle";
    private static final String LEVEL = "level";

    private Account account;
    private Set<Account> accounts;
    private String seq;
    private String isGroupTitle;
    private String effDate;
    private String version;
    private String code;
    private String codeCref;
    private String title;
    private String desc;
    private String level;
    private String nodeName;

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {
	accounts = new HashSet<Account>();
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

	if (ACCOUNT.equals(qName)) {
	    seq = atts.getValue(SEQ);
	    effDate = atts.getValue(EFFDATE);
	    version = atts.getValue(VERSION);
	    isGroupTitle = atts.getValue(ISGROUPTITLE);
	}

	nodeName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

	if (ACCOUNT.equals(qName)) {
	    account = new Account();
	    account.setSeq(seq);
	    try {
		account.setEffectiveDate(formatDate(effDate));
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	    account.setIsGroupTitle(Boolean.parseBoolean(isGroupTitle));
	    account.setVersion(Integer.parseInt(version));
	    account.setAccountCode(code);
	    account.setAccountCrossRef(codeCref);
	    account.setAccountTitle(title);
	    account.setAccountDescription(desc);
	    account.setLevel(Integer.parseInt(level));
	    accounts.add(account);
	}

	nodeName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
	if (CODE.equals(nodeName)) {
	    code = String.valueOf(ch).substring(start, start + length);
	} else if (CODECREF.equals(nodeName)) {
	    codeCref = String.valueOf(ch).substring(start, start + length);
	} else if (TITLE.equals(nodeName)) {
	    title = String.valueOf(ch).substring(start, start + length);
	} else if (DESC.equals(nodeName)) {
	    desc = String.valueOf(ch).substring(start, start + length);
	} else if (LEVEL.equals(nodeName)) {
	    level = String.valueOf(ch).substring(start, start + length);
	}

    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }

    private Date formatDate(String dateStr) throws ParseException {

	SimpleDateFormat formatter = new SimpleDateFormat("M-dd-yyyy");
	Date date = formatter.parse(dateStr);
	return date;
    }

    public Set<Account> getAccounts() {

	return accounts;
    }

}
