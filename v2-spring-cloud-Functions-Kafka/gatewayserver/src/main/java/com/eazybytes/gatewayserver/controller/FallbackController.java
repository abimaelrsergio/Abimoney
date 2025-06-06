package com.eazybytes.gatewayserver.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@RestController
public class FallbackController {
    @RequestMapping("/contactSupport")
    public Mono<String> contactSupport() {
        return Mono.just("An error occured. Please try after some time or contact support team!!!");
    }
}
