package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    public EmailSender emailSender() {
        return new EmailSenderImpl();
    }

    @Bean
    @Profile("prod")
    public CustomerRepository customerRepository() {
        return new CustomerRepositoryImpl();
    }

    @Bean
    @Profile("test")
    public CustomerRepository customerRepositoryMock() {
        return new CustomerRepositoryMock();
    }

    @Bean
    public Logger logger(){
        return new LoggerImpl();
    }



}
