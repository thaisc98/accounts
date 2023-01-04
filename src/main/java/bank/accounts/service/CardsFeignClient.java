package bank.accounts.service;

import bank.accounts.model.Cards;
import bank.accounts.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("cards")
public interface CardsFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "my-cards", consumes = "application/json")
    List<Cards> getCardDetails(@RequestBody Customer customer);
}
