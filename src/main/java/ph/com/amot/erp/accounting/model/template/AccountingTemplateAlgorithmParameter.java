package ph.com.amot.erp.accounting.model.template;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT_TEMP_ALGO_PARAM")
public class AccountingTemplateAlgorithmParameter implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "SEQ", nullable = false)
	private String seq;

	@Column(name = "PARAM", nullable = false)
	private String param;

	@Column(name = "VALUE", nullable = false)
	private String value;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_TEMP_ALGO_ID")
	private AccountingTemplateAlgorithm accountingTemplateAlgorithm;

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

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public AccountingTemplateAlgorithm getAccountingTemplateAlgorithm() {
		return accountingTemplateAlgorithm;
	}

	public void setAccountingTemplateAlgorithm(AccountingTemplateAlgorithm accountingTemplateAlgorithm) {
		this.accountingTemplateAlgorithm = accountingTemplateAlgorithm;
	}

	@Override
	public String toString() {
		return "AccountingTemplateAlgorithmParameter [id=" + id + ", seq=" + seq + ", param=" + param + ", value="
				+ value + ", accountingTemplateAlgorithm=" + accountingTemplateAlgorithm + "]";
	}

}
