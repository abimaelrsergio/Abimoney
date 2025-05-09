package com.eazybytes.accounts.dto;

import lombok.*;
import org.springframework.boot.context.properties.*;

import java.util.*;

@Getter
@Setter
@ConfigurationProperties(prefix = "accounts")
public class AccountsContactInfoDto{
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
