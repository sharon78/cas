package ph.com.cas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.cas.model.template.AccountingTemplateDetail;

public interface AccountingTemplateDetailRepository
	extends JpaRepository<AccountingTemplateDetail, Long> {

}
