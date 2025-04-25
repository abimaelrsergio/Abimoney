package com.eazybytes.accounts.dto;

import org.springframework.boot.context.properties.*;

import java.util.*;

@ConfigurationProperties(prefix = "accounts")
public record AccountsContactInfoDto(
        String message,
        Map<String, String> contactDetails,
        List<String> onCallSupport
){}
