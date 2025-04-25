package com.eazybytes.cards.dto;

import org.springframework.boot.context.properties.*;

import java.util.*;

@ConfigurationProperties(prefix = "cards")
public record CardsContactInfoDto(
        String message,
        Map<String, String> contactDetails,
        List<String> onCallSupport
) {
}
