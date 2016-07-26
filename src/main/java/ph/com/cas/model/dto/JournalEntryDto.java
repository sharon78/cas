package ph.com.cas.model.dto;

import java.util.Date;
import java.util.Map;

public class JournalEntryDto {

    private String templateCode;
    private Map<String, String> info;
    private Date journalDate;
    private String journalDescription;
    private double amount;

    public String getTemplateCode() {
	return templateCode;
    }

    public Map<String, String> getInfo() {
	return info;
    }

    public Date getJournalDate() {
	return journalDate;
    }

    public String getJournalDescription() {
	return journalDescription;
    }

    public double getAmount() {
	return amount;
    }

    public void setTemplateCode(String templateCode) {
	this.templateCode = templateCode;
    }

    public void setInfo(Map<String, String> info) {
	this.info = info;
    }

    public void setJournalDate(Date journalDate) {
	this.journalDate = journalDate;
    }

    public void setJournalDescription(String journalDescription) {
	this.journalDescription = journalDescription;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    @Override
    public String toString() {
	return "JournalDto [templateCode=" + templateCode + ", info=" + info + ", journalDate=" + journalDate
		+ ", journalDescription=" + journalDescription + ", amount=" + amount + "]";
    }

}
