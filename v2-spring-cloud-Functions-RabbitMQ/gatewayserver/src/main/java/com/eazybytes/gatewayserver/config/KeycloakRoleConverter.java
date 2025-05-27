package com.eazybytes.gatewayserver.config;

import org.springframework.core.convert.converter.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.oauth2.jwt.*;

import java.util.*;
import java.util.stream.*;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String, Object> realmAccess = (Map<String, Object>) source.getClaims().get("realm_access");
        if (realmAccess == null || realmAccess.isEmpty()) {
            return new ArrayList<>();
        }
        Collection<GrantedAuthority> returnValue = ((List<String>) realmAccess.get("roles"))
                .stream().map(roleName -> "ROLE_"+roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return returnValue;
    }

}
