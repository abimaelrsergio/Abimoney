package com.eazybytes.loans.dto;

import org.springframework.boot.context.properties.*;

import java.util.*;

@ConfigurationProperties(prefix = "loans")
public record LoansContactInfoDto(
        String message,
        Map<String, String> contactDetails,
        List<String> onCallSupport
) {
}
