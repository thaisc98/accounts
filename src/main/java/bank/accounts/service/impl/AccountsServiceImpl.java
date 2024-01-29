package bank.accounts.service.impl;

import bank.accounts.constants.AccountsConstants;
import bank.accounts.dto.CustomerDto;
import bank.accounts.entity.Accounts;
import bank.accounts.entity.Customer;
import bank.accounts.exception.CustomerAlreadyExistsException;
import bank.accounts.mapper.CustomerMapper;
import bank.accounts.repository.AccountsRepository;
import bank.accounts.repository.CustomerRepository;
import bank.accounts.service.AccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number "
                    + customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Tekashi");
        Customer savedCustomer =  customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }


    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccounNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccounNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Tekashi");
        return newAccount;
    }
}
