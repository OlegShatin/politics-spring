package ru.kpfu.itis.group11501.shatin.politics_web_project.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.User;

import java.io.Serializable;

/**
 * @author Oleg Shatin
 * Date: 4/21/17 6:13 PM
 *
 * Abstract class for custom Spring Security permission evaluators. Evaluates requests for specific domain object class
 * Each class that can be possibly evaluated should be handled by only one evaluator
 *
 * see also:
 * {@link CommunityPermissionEvaluator}
 * {@link GlobalPermissionEvaluator}
 */
public abstract class AbstractPermissionEvaluator<D> implements PermissionEvaluator {

    @Override
    public final boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if(!isQuerySupported(authentication, permission))
            return false;

        User user = ((UserDetails) authentication.getPrincipal()).getUser();

        try{
            @SuppressWarnings("unchecked")
            D d = ((D) targetDomainObject);
            return hasPermission(user, d, (String) permission);
        } catch (ClassCastException e) {
            //type not supported
            return false;
        }
    }

    @Override
    public final boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        if(!isQuerySupported(authentication, permission))
            return false;

        User user = ((UserDetails) authentication.getPrincipal()).getUser();

        return getSupportedType().equals(targetType) &&
                hasPermission(user, getDomainObject((Integer) targetId), (String) permission);

    }

    private boolean isQuerySupported(Authentication authentication, Object permission) {
        return permission != null && authentication.getPrincipal() instanceof UserDetails;
    }

    protected abstract boolean hasPermission(User user, D domainObject, String permission);

    protected abstract D getDomainObject(int id);

    protected abstract String getSupportedType();
}
