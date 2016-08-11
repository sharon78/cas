package ph.com.amot.erp.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.amot.erp.accounting.model.template.AccountingTemplateDetail;

public interface AccountingTemplateDetailRepository
	extends JpaRepository<AccountingTemplateDetail, Long> {

}
