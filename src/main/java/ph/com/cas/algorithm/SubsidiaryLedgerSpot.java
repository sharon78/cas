package ph.com.cas.algorithm;

import ph.com.cas.model.SubsidiaryDistribution;

public abstract class SubsidiaryLedgerSpot
	extends AlgorithmSpot {

    private SubsidiaryDistribution subsidiaryDistribution;

    public abstract boolean writeToSubsidiary();

}
