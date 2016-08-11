package ph.com.amot.erp.accounting.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT_PERIOD")
public class AccountingPeriod implements Serializable {

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
}
