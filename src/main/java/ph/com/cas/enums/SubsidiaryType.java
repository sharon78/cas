package ph.com.cas.enums;

public enum SubsidiaryType {

    ASSET("asset"), CASH("cash"), CHECK("check"), EQUITY("equity"), LIABILITY("liability"), PAYABLE("payable"),
    PETTY_CASH("pettycash"), PURCHASE("purchase"), PURCHASE_RETURN("purchasereturn"), RECEIVABLE("receivable"),
    SALE("sale"), SALE_RETURN("salereturn"), BANK_RECON("bankrecon"), TRIAL_BALANCE("trialbalance");

    private String value;

    private SubsidiaryType(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }
}
