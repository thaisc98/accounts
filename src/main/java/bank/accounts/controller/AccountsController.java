package bank.accounts.controller;

import bank.accounts.model.Accounts;
import bank.accounts.model.Customer;
import bank.accounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AccountsController {

    private AccountsRepository accountsRepository;

    public AccountsController(AccountsRepository accountsRepository){
        this.accountsRepository = accountsRepository;
    }

    @PostMapping("/my-account")
    public Accounts getAccountsDetails(@RequestBody Customer customer){
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        return Objects.nonNull(accounts) ? accounts : null;
    }

}
