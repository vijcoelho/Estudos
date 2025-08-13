package com.eazybytes.account.service.impl;

import com.eazybytes.account.constants.AccountsConstants;
import com.eazybytes.account.dto.AccountsDto;
import com.eazybytes.account.dto.CustomerDto;
import com.eazybytes.account.entity.Accounts;
import com.eazybytes.account.entity.Customer;
import com.eazybytes.account.exception.CustomerAlreadyExistsException;
import com.eazybytes.account.exception.ResourceNotFoundException;
import com.eazybytes.account.mapper.AccountsMapper;
import com.eazybytes.account.mapper.CustomerMapper;
import com.eazybytes.account.repository.AccountsRepository;
import com.eazybytes.account.repository.CustomerRepository;
import com.eazybytes.account.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        final Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        final Optional<Customer> customerOptional = customerRepository
                .findByMobileNumber(customerDto.getMobileNumber());

        customerOptional.ifPresent(c -> {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number " +
                    customerDto.getMobileNumber());
        });

        customer.setCreatedAt(LocalDate.now());
        customer.setCreatedBy("ADMIN");
        final Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(final Customer customer) {
        final Accounts accounts = new Accounts();
        accounts.setCustomerId(customer.getCustomerId());

        final Long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        accounts.setAccountNumber(randomAccNumber);
        accounts.setAccountType(AccountsConstants.SAVINGS);
        accounts.setBranchAddress(AccountsConstants.ADDRESS);
        accounts.setCreatedAt(LocalDate.now());
        accounts.setCreatedBy("ADMIN");

        return accounts;
    }

    @Override
    public CustomerDto fetchAccount(final String mobileNumber) {
        final Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer", "mobileNumber", mobileNumber));

        final Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Account", "customerId", customer.getCustomerId().toString()));

        final CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        return customerDto;
    }

    @Override
    public Boolean updateAccount(final CustomerDto customerDto) {
        boolean isUpdated = false;

        final AccountsDto accountsDto = customerDto.getAccountsDto();
        if (Objects.nonNull(accountsDto)) {
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Account", "AccountNumber", accountsDto.getAccountNumber().toString()));

            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            final Long customerId = accounts.getCustomerId();
            final Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Customer", "CustomerId", customerId.toString()));

            CustomerMapper.mapToCustomer(customerDto, customer);
            customerRepository.save(customer);

            isUpdated = true;
        }
        return isUpdated;
    }
}
