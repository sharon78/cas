package ph.com.amot.erp.accounting.model.dto;

import java.util.ArrayList;
import java.util.List;

import ph.com.amot.erp.accounting.model.Journal;

public class JournalListDto {

    private int journalsRecno;
    private List<Journal> journals;

    public List<Journal> getJournals() {
	return journals;
    }

    public int getJournalsRecno() {
	return journalsRecno;
    }

    public void setJournalsRecno(int journalsRecno) {
	this.journalsRecno = journalsRecno;
    }

    public void setJournals(List<Journal> journals) {
	List<Journal> journalsImmutable = new ArrayList<Journal>();
	journalsImmutable.addAll(journals);
	this.journals = journalsImmutable;
	this.journalsRecno = journalsImmutable.size();
    }

}
