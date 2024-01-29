package bank.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@RefreshScope
//@ComponentScans({ @ComponentScan("bank.accounts.controller")})
@EnableJpaRepositories("bank.accounts.repository")
//@ComponentScan(basePackages = { "bank.accounts.*" })
//@EntityScan("bank.accounts.*")
//@EnableFeignClients
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
