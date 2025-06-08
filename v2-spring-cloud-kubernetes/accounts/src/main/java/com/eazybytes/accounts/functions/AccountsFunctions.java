package com.eazybytes.accounts.functions;

import com.eazybytes.accounts.service.*;
import lombok.extern.slf4j.*;
import org.springframework.context.annotation.*;

import java.util.function.*;

@Slf4j
@Configuration
public class AccountsFunctions {

    @Bean
    public Consumer<Long> updateCommunication(IAccountsService accountsService) {
        return accountNumber -> {
            log.info("Updating Communication status for the account number: {} ", accountNumber.toString());
            accountsService.updateCommunicationStatus(accountNumber);
        };
    }

}
