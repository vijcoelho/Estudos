package com.eazybytes.account.controller;

import com.eazybytes.account.constants.AccountsConstants;
import com.eazybytes.account.dto.CustomerDto;
import com.eazybytes.account.dto.ResponseDto;
import com.eazybytes.account.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private final IAccountsService iAccountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody final CustomerDto customerDto) {
        iAccountsService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(
                        AccountsConstants.STATUS_201,
                        AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetail(@RequestParam final String mobileNumber) {
        final CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody final CustomerDto customerDto) {
        final boolean isUpdate = iAccountsService.updateAccount(customerDto);
        if (isUpdate) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }
}
