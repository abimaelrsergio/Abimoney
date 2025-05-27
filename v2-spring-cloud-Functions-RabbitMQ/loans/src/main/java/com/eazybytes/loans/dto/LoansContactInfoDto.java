package com.eazybytes.loans.dto;

import lombok.*;
import org.springframework.boot.context.properties.*;

import java.util.*;

@Getter
@Setter
@ConfigurationProperties(prefix = "loans")
public class LoansContactInfoDto{
        private String message;
        private Map<String, String> contactDetails;
        private List<String> onCallSupport;
}
