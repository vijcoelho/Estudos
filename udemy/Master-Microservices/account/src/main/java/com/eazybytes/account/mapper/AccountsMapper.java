package com.eazybytes.account.mapper;

import com.eazybytes.account.dto.AccountsDto;
import com.eazybytes.account.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(final Accounts accounts,final AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(final AccountsDto accountsDto, final Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
