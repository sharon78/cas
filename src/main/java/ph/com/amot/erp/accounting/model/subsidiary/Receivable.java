package ph.com.amot.erp.accounting.model.subsidiary;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ph.com.amot.erp.accounting.enums.SubsidiaryType;
import ph.com.amot.erp.accounting.model.SubsidiaryDistribution;

@SuppressWarnings("serial")
@Entity
@Table(name = "RECEIVABLE_REGISTER")
public class Receivable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "SEQ")
	private String seq;

	@Column(name = "SUB_TYPE_ID")
	private SubsidiaryType subsidiaryType;

	@OneToOne
	@JoinColumn(name = "SUB_DISTRIBUTION_ID", nullable = false)
	private SubsidiaryDistribution subsidiaryDistribution;

	@Column(name = "PARTICULARS")
	private String particulars;

	@Column(name = "DISCOUNT_PERCENT")
	private double discountPercentage;

	@Column(name = "DISCOUNT_AMT")
	private double discount;

	@Column(name = "AMOUNT")
	private double amount;
}
