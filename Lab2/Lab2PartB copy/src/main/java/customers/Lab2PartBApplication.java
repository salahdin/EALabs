package customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Lab2PartBApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Lab2PartBApplication.class, args);

		CustomerService customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");
	}
}