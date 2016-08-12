package ph.com.amot.erp.accounting.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "COST_CENTER")
public class CostCenter
	implements Serializable {

    @Column(name = "SEQ", nullable = false)
    private String seq;

    @Id
    @Column(name = "COST_CENTER_CODE", nullable = false)
    private String costCenterCode;

    @Column(name = "COST_CENTER_TITLE", nullable = false)
    private String costCenterTitle;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "EFF_DATE", nullable = false)
    private Date effectiveDate;

    @OneToMany(mappedBy = "costCenter")
    private Set<Journal> journals;

    public String getSeq() {
	return seq;
    }

    public String getCostCenterCode() {
	return costCenterCode;
    }

    public String getCostCenterTitle() {
	return costCenterTitle;
    }

    public String getDescription() {
	return description;
    }

    public Date getEffectiveDate() {
	return effectiveDate;
    }

    public Set<Journal> getJournals() {
	return journals;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public void setCostCenterCode(String costCenterCode) {
	this.costCenterCode = costCenterCode;
    }

    public void setCostCenterTitle(String costCenterTitle) {
	this.costCenterTitle = costCenterTitle;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setEffectiveDate(Date effectiveDate) {
	this.effectiveDate = effectiveDate;
    }

    public void setJournals(Set<Journal> journals) {
	this.journals = journals;
    }

}
