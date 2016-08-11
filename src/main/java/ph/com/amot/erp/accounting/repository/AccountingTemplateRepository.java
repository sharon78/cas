package ph.com.amot.erp.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.amot.erp.accounting.model.template.AccountingTemplate;

public interface AccountingTemplateRepository
	extends JpaRepository<AccountingTemplate, Long> {

    AccountingTemplate findByTemplateCode(String templateCode);
}
