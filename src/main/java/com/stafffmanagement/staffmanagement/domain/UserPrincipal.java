package com.stafffmanagement.staffmanagement.domain;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@AllArgsConstructor
public class UserPrincipal implements UserDetails {
    private PortalUser portalUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return stream(this.portalUser.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.portalUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.portalUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.portalUser.isNotLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.portalUser.isActive();
    }
}
