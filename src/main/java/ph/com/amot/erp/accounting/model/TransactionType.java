/**
 * TransactionType example: adjustment, etc.
 * This is a list of common accounting transactions.
 * **/
package ph.com.amot.erp.accounting.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TransactionType implements Serializable {
	private long id;
	private String seq;
	private String FTTypeCode;
	private String FTTypeTitle;
	private Date effectiveDate;

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

	public String getFTTypeCode() {
		return FTTypeCode;
	}

	public void setFTTypeCode(String fTTypeCode) {
		FTTypeCode = fTTypeCode;
	}

	public String getFTTypeTitle() {
		return FTTypeTitle;
	}

	public void setFTTypeTitle(String fTTypeTitle) {
		FTTypeTitle = fTTypeTitle;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Override
	public String toString() {
		return "TransactionType [id=" + id + ", seq=" + seq + ", FTTypeCode=" + FTTypeCode + ", FTTypeTitle="
				+ FTTypeTitle + ", effectiveDate=" + effectiveDate + "]";
	}

}
