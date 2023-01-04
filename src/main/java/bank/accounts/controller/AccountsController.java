package bank.accounts.controller;

import bank.accounts.config.AccountsServiceConfig;
import bank.accounts.model.*;
import bank.accounts.repository.AccountsRepository;
import bank.accounts.service.CardsFeignClient;
import bank.accounts.service.LoansFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class AccountsController {

    private AccountsRepository accountsRepository;

    @Autowired
    AccountsServiceConfig accountsServiceConfig;

    @Autowired
    CardsFeignClient cardsFeignClient;

    @Autowired
    LoansFeignClient loansFeignClient;

    public AccountsController(AccountsRepository accountsRepository){
        this.accountsRepository = accountsRepository;
    }

    @PostMapping("/my-account")
    public Accounts getAccountsDetails(@RequestBody Customer customer){
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        return Objects.nonNull(accounts) ? accounts : null;
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow =  new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountsServiceConfig.getMsg(), accountsServiceConfig.getBuildVersion(),
                accountsServiceConfig.getMailDetails(), accountsServiceConfig.getActiveBranches());
        return ow.writeValueAsString(properties);
    }

    @PostMapping("/my-customer-details")
    public CustomerDetails getCustomerDetails(@RequestBody Customer customer){
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        List<Loans> loans = loansFeignClient.getLoansDetails(customer);
        List<Cards> cards = cardsFeignClient.getCardDetails(customer);

        return CustomerDetails.builder().
                accounts(accounts).loans(loans).cards(cards).build();
    }

}
