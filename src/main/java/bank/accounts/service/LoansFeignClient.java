package bank.accounts.service;

import bank.accounts.model.Customer;
import bank.accounts.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "my-loans", consumes = "application/json")
    List<Loans> getLoansDetails(@RequestBody Customer customer);
}
