/**
 * copyright 2016 by Sharon Amot
 * 
 */
package ph.com.amot.erp.accounting.model;

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
import ph.com.amot.erp.accounting.model.subsidiary.Cash;
import ph.com.amot.erp.accounting.model.subsidiary.Cheque;

@SuppressWarnings("serial")
@Entity
@Table(name = "SUB_DISTRIBUTION")
public class SubsidiaryDistribution implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "SEQ", nullable = false)
	private String seq;

	@Column(name = "SUB_TYPE", nullable = false)
	private SubsidiaryType subsidiaryType;

	@OneToOne
	@JoinColumn(name = "JOURNAL_ENTRY_ID", nullable = false)
	private JournalEntry journalEntry;

	@OneToOne(mappedBy = "subsidiaryDistribution")
	private Cheque cheque;

	@OneToOne(mappedBy = "subsidiaryDistribution")
	private Cash cash;

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

	public SubsidiaryType getSubsidiaryType() {
		return subsidiaryType;
	}

	public void setSubsidiaryType(SubsidiaryType subsidiaryType) {
		this.subsidiaryType = subsidiaryType;
	}

	public JournalEntry getJournalEntry() {
		return journalEntry;
	}

	public void setJournalEntry(JournalEntry journalEntry) {
		this.journalEntry = journalEntry;
	}

	public Cheque getCheque() {
		return cheque;
	}

	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}

}
