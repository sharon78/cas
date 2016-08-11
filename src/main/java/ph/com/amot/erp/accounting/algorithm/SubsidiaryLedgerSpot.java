package ph.com.amot.erp.accounting.algorithm;

import ph.com.amot.erp.accounting.model.SubsidiaryDistribution;

public abstract class SubsidiaryLedgerSpot
	extends AlgorithmSpot {

    private SubsidiaryDistribution subsidiaryDistribution;

    public abstract boolean writeToSubsidiary();

}
