/**
 * Spring configuration file
 * */
package ph.com.amot.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class ERPApplication {

    public static void main(String[] args) {
	SpringApplication.run(ERPApplication.class, args);
    }
}
