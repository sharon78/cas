package ph.com.cas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.cas.model.template.AccountingTemplate;

public interface AccountingTemplateRepository
	extends JpaRepository<AccountingTemplate, Long> {

    AccountingTemplate findByTemplateCode(String templateCode);
}
