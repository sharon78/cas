package ph.com.cas;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ph.com.cas.model.Account;
import ph.com.cas.repository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CasApplication.class)
@WebAppConfiguration
public class CasApplicationTests {

	Logger LOG = LoggerFactory.getLogger(CasApplicationTests.class);

	@Test
	public void contextLoads() {

	}

	@Test
	public void testAccount() {
		LOG.info("********* testAccount()");

		Account account = new Account();
		account.setAccountCode("1234");
		account.setAccountTitle("Cash on hand");
		account.setAccountDescription("Cash on hand");
		account.setEffectiveDate(new Date());
		account.setSeq("01");
		account.setVersion(1);

		Account newAccount = acctRepository.save(account);

		LOG.info("*********" + newAccount.toString());
	}

	@Autowired
	AccountRepository acctRepository;

}
