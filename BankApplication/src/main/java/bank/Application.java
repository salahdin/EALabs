package bank;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountServiceImpl;
import bank.service.AccountService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;


@SpringBootApplication
public class Application {
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void run() {
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");

		// use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdraw(1263862, 230);

		// use account 2;
		accountService.deposit(4253892, 12450);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");

		// show balances
		Collection<Account> accountlist = accountService.getAllAccounts();
		for (Account account : accountlist) {
			System.out.println("Balance for account " + account.getAccountNumber() + " is " + account.getBalance());
			System.out.println("Account Entry for account " + account.getAccountNumber() + " is " + account.getEntryList());
		}
	}
}


