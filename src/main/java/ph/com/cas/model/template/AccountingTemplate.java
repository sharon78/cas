package ph.com.cas.model.template;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT_TEMPLATE")
public class AccountingTemplate
	implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "SEQ")
    private String seq;

    @Column(name = "TEMPLATE_CODE")
    private String templateCode;

    @Column(name = "TEMPLATE_DESCRIPTION")
    private String templateDescription;

    @OneToMany(mappedBy = "accountingTemplate", cascade = CascadeType.ALL)
    private Set<AccountingTemplateDetail> templateDetails;

    @OneToMany(mappedBy = "accountingTemplate")
    private Set<AccountingTemplateAlgorithm> templateAlgorithm;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getSeq() {
	return seq;
    }

    public void setSeq(String seq) {
	this.seq = seq;
    }

    public String getTemplateCode() {
	return templateCode;
    }

    public void setTemplateCode(String templateCode) {
	this.templateCode = templateCode;
    }

    public String getTemplateDescription() {
	return templateDescription;
    }

    public void setTemplateDescription(String templateDescription) {
	this.templateDescription = templateDescription;
    }

    public Set<AccountingTemplateDetail> getTemplateDetails() {
	return templateDetails;
    }

    public void setTemplateDetails(Set<AccountingTemplateDetail> templateDetails) {
	this.templateDetails = templateDetails;
    }

    public Set<AccountingTemplateAlgorithm> getTemplateAlgorithm() {
	return templateAlgorithm;
    }

    public void setTemplateAlgorithm(Set<AccountingTemplateAlgorithm> templateAlgorithm) {
	this.templateAlgorithm = templateAlgorithm;
    }

    @Override
    public String toString() {
	return "AccountingTemplate [id=" + id + ", seq=" + seq + ", templateCode=" + templateCode
		+ ", templateDescription=" + templateDescription + ", templateDetails=" + templateDetails
		+ ", templateAlgorithm=" + templateAlgorithm + "]";
    }

}
