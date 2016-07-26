package ph.com.cas.model.dto;

import java.util.ArrayList;
import java.util.List;

import ph.com.cas.model.Journal;

public class JournalListDto {

    private int totalJournals;
    private List<Journal> journals;

    public List<Journal> getJournals() {
	return journals;
    }

    public int getTotalJournals() {
	return totalJournals;
    }

    public void setTotalJournals(int totalJournals) {
	this.totalJournals = totalJournals;
    }

    public void setJournals(List<Journal> journals) {
	List<Journal> journalsImmutable = new ArrayList<Journal>();
	journalsImmutable.addAll(journals);
	this.journals = journalsImmutable;
	this.totalJournals = journalsImmutable.size();
    }

}
