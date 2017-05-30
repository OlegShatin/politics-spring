package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import ru.kpfu.itis.group11501.shatin.politics_web_project.security.SecurityConfig;

import java.util.List;

/**
 * @author Oleg Shatin
 * Date: 3/27/17 9:12 PM
 *
 * This enum contains all user roles that currently exist in the project.
 * Add roles and authorities here.
 * Constant names are used as Spring Security role names.
 * Note that role is just an authority with name prefixed with 'ROLE_'
 *
 * Spring Security role hierarchy is generated automatically on startup (see {@link SecurityConfig})
 */
public enum UserRole {

    ROLE_SIMPLE(""),
    ROLE_AGENT("EDIT_CANDIDATE"),
    ROLE_SUPERUSER("ROLE_SIMPLE, ROLE_AGENT");

    private List<GrantedAuthority> authorities;

    UserRole(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    /**
     * Construct a role by the list of implied roles and authorities
     * @param authorities Comma separated list of implied roles and authorities
     */
    UserRole(String authorities) {
        this(AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
