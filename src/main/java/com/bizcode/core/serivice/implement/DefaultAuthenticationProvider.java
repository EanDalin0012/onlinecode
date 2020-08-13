package com.bizcode.core.serivice.implement;

import com.bizcode.core.dao.DefaultAuthenticationProviderDao;
import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class DefaultAuthenticationProvider implements AuthenticationProvider {

    private final DefaultAuthenticationProviderDao defaultAuthenticationProviderDao;

    public DefaultAuthenticationProvider(DefaultAuthenticationProviderDao defaultAuthenticationProviderDao) {
        this.defaultAuthenticationProviderDao = defaultAuthenticationProviderDao;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.getName() == null || authentication.getCredentials() == null) {
            System.out.println("\n\n\n <<<<==== Authentication Name is null ===>>>>>> \n\n\n");
            return null;
        }

        if (authentication.getName().isEmpty() || authentication.getCredentials().toString().isEmpty()) {
            System.out.println("\n\n\n <<<<==== Authentication Name is isEmpty ===>>>>>> \n\n\n");
            return null;
        }
        // TODO
        MMap input = new MMap();
        input.setString("username", authentication.getName());
        MMap _user = defaultAuthenticationProviderDao.getUserByName(input);
        if (_user != null ) {
            final String providedUserEmail = authentication.getName();
            final Object providedUserPassword = authentication.getCredentials();
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            MultiMap _authorities = _user.getMultiMap("authorities");

            for (MMap _authority:_authorities.toListData()) {
                authorities.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return _authority.getString("name");
                    }
                });
            }

            if (providedUserEmail.equalsIgnoreCase(_user.getString("username"))) {
                throw new UsernameNotFoundException("Invalid username");
            }

            if (providedUserPassword.equals(_user.getString("password")) ) {
                throw new UsernameNotFoundException("Invalid password.");
            }

            return new UsernamePasswordAuthenticationToken(
                    _user.getString("username"),
                    _user.getString("password"),
                    authorities);

        }
        throw new UsernameNotFoundException("Invalid username or password.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
