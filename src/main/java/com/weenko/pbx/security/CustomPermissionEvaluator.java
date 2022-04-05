package com.weenko.pbx.security;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

        private final Logger logger = LoggerFactory.getLogger(CustomPermissionEvaluator.class);

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomain, Object permission) {
        logger.debug("Checking "+targetDomain.toString()+"'s "+permission.toString());
        if ((auth == null) || !(targetDomain instanceof String) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth, targetDomain.toString().toUpperCase(), permission.toString().toUpperCase());
    }

    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
        logger.debug("custom Checking "+targetType+"'s "+permission.toString());
        if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth, targetType.toUpperCase(), permission.toString().toUpperCase());
    }

    private boolean hasPrivilege(Authentication auth, String targetType, String permission) {
        String specificPermission = targetType.toUpperCase()+"_"+permission.toUpperCase();
        for (final GrantedAuthority grantedAuth : auth.getAuthorities())
                if (grantedAuth.getAuthority().contains(specificPermission))
                    return true;
        return false;
    }

}
