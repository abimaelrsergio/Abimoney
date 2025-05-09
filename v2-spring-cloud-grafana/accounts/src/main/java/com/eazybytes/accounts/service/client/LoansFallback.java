package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

@Component
public class LoansFallback implements LoansFeignClient{

    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
