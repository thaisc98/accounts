package bank.accounts.service;

import bank.accounts.dto.CustomerDto;

public interface AccountsService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);
}
