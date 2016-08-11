package ph.com.amot.erp.accounting.model.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class JournalEntryDto {

    private String templateCode;
    private Map<String, String> info;
    @Temporal(TemporalType.DATE)
    private Date journalDate;
    private String journalDescription;
    private List<Map<String, String>> journalEntries;
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

    public List<Map<String, String>> getJournalEntries() {
	return journalEntries;
    }

    public void setJournalEntries(List<Map<String, String>> journalEntries) {
	this.journalEntries = journalEntries;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    @Override
    public String toString() {
	return "JournalEntryDto [templateCode=" + templateCode + ", info=" + info + ", journalDate=" + journalDate
		+ ", journalDescription=" + journalDescription + ", journalEntries=" + journalEntries + ", amount="
		+ amount + "]";
    }

}
