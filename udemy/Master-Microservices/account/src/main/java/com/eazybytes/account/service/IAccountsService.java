package com.eazybytes.account.service;

import com.eazybytes.account.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public interface IAccountsService {

    void createAccount(final CustomerDto customerDto);

    CustomerDto fetchAccount(final String mobileNumber);

    Boolean updateAccount(final CustomerDto customerDto);
}
