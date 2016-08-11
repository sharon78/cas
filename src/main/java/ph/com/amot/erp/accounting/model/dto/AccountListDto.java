package ph.com.amot.erp.accounting.model.dto;

import java.util.Date;
import java.util.List;

import ph.com.amot.erp.accounting.model.Ledger;
import ph.com.amot.erp.accounting.model.template.AccountingTemplateDetail;

public class AccountListDto {

    private String accountCode;
    private String accountCrossRef;
    private String accountTitle;
    private String accountDescription;
    private Date effectiveDate;
    private String seq;
    private int version;
    private List<Ledger> ledgerAccounts;
    private AccountingTemplateDetail accountingTemplateDetails;

}
