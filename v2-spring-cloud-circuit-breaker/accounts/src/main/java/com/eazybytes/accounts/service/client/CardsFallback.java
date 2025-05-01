package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

@Component
public class CardsFallback implements CardsFeignClient{
    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
