package ph.com.amot.erp.accounting.model.template;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT_TEMP_ALGO")
public class AccountingTemplateAlgorithm implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "SEQ", nullable = false)
	private String seq;

	@Column(name = "ALGORITHM_CODE", nullable = false)
	private String algorithmCode;

	@Column(name = "ALGORITHM_DESCRIPTION", nullable = false)
	private String algorithmDescription;

	@Column(name = "ALGORITHM_CLASS", nullable = false)
	private String algorithmClass;

	@OneToMany(mappedBy = "accountingTemplateAlgorithm")
	private Set<AccountingTemplateAlgorithmParameter> accountingTemplateAlgoritmParams;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_TEMPLATE_ID")
	private AccountingTemplate accountingTemplate;

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

	public String getAlgorithmCode() {
		return algorithmCode;
	}

	public void setAlgorithmCode(String algorithmCode) {
		this.algorithmCode = algorithmCode;
	}

	public String getAlgorithmDescription() {
		return algorithmDescription;
	}

	public void setAlgorithmDescription(String algorithmDescription) {
		this.algorithmDescription = algorithmDescription;
	}

	public String getAlgorithmClass() {
		return algorithmClass;
	}

	public void setAlgorithmClass(String algorithmClass) {
		this.algorithmClass = algorithmClass;
	}

	public Set<AccountingTemplateAlgorithmParameter> getAccountingTemplateAlgoritmParams() {
		return accountingTemplateAlgoritmParams;
	}

	public void setAccountingTemplateAlgoritmParams(
			Set<AccountingTemplateAlgorithmParameter> accountingTemplateAlgoritmParams) {
		this.accountingTemplateAlgoritmParams = accountingTemplateAlgoritmParams;
	}

	public AccountingTemplate getAccountingTemplate() {
		return accountingTemplate;
	}

	public void setAccountingTemplate(AccountingTemplate accountingTemplate) {
		this.accountingTemplate = accountingTemplate;
	}

	@Override
	public String toString() {
		return "AccountingTemplateAlgorithm [id=" + id + ", seq=" + seq + ", algorithmCode=" + algorithmCode
				+ ", algorithmDescription=" + algorithmDescription + ", algorithmClass=" + algorithmClass
				+ ", accountingTemplateAlgoritmParams=" + accountingTemplateAlgoritmParams + ", accountingTemplate="
				+ accountingTemplate + "]";
	}

}
