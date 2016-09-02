package co.dwsoftware.erp.gefi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaAuditing
@ComponentScan("co.dwsoftware.erp.gefi")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
