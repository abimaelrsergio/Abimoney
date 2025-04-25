package com.eazybytes.cards.dto;

import lombok.*;
import org.springframework.boot.context.properties.*;

import java.util.*;

@Getter
@Setter
@ConfigurationProperties(prefix = "cards")
public class CardsContactInfoDto{
        private String message;
        private Map<String, String> contactDetails;
        private List<String> onCallSupport;
}
