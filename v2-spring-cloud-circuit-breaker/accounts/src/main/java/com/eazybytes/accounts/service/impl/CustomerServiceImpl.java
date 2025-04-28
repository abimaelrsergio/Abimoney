package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.dto.*;
import com.eazybytes.accounts.entity.*;
import com.eazybytes.accounts.exception.*;
import com.eazybytes.accounts.mapper.*;
import com.eazybytes.accounts.repository.*;
import com.eazybytes.accounts.service.*;
import com.eazybytes.accounts.service.client.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);

        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }

}
