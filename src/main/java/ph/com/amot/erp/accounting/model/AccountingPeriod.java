package ph.com.amot.erp.accounting.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT_PERIOD")
public class AccountingPeriod
	implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "SEQ")
    private String seq;

    @Column(name = "PERIOD")
    private String period;

    @Column(name = "CAP_START_DATE")
    private Date capStartDate;

    @Column(name = "CAP_END_DATE")
    private Date capEndDate;

    @Column(name = "VERSION")
    private int version;

    @OneToMany(mappedBy = "accountingPeriod")
    private Set<Journal> journals;

    public long getId() {
	return id;
    }

    public String getSeq() {
	return seq;
    }

    public String getPeriod() {
	return period;
    }

    public Date getCapStartDate() {
	return capStartDate;
    }

    public Date getCapEndDate() {
	return capEndDate;
    }

    public int getVersion() {
	return version;
    }

    public Set<Journal> getJournals() {
	return journals;
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public void setPeriod(String period) {
	this.period = period;
    }

    public void setCapStartDate(Date capStartDate) {
	this.capStartDate = capStartDate;
    }

    public void setCapEndDate(Date capEndDate) {
	this.capEndDate = capEndDate;
    }

    public void setVersion(int version) {
	this.version = version;
    }

    public void setJournals(Set<Journal> journals) {
	this.journals = journals;
    }

}
