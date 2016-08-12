/**
 * Cash book is a record of all the transactions related to cash. 
 * Examples include: expenses paid in cash, revenue collected in 
 * cash, payments made to creditors, payments received from debtors, 
 * cash deposited in bank, withdrawn of cash for office use, etc.
 * 
 * */
package ph.com.amot.erp.accounting.model.subsidiary;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ph.com.amot.erp.accounting.enums.SubsidiaryType;

@SuppressWarnings("serial")
@Entity
@Table(name = "CASH_REGISTER")
public class Cash
	implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "SEQ")
    private String seq;

    @Column(name = "SUB_TYPE_ID")
    private SubsidiaryType subsidiaryType;

    @Column(name = "PARTICULARS")
    private String particulars;

    @Column(name = "DISCOUNT_PERCENT")
    private double discountPercentage;

    @Column(name = "DISCOUNT_AMT")
    private double discount;

    @Column(name = "AMOUNT")
    private double amount;

}
