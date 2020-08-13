package com.bizcode.core.provider;

import com.bizcode.admins.api.UserAPI;
import com.bizcode.core.encryption.Encoders;
import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import com.bizcode.core.serivice.implement.DefaultAuthenticationProviderServiceImplement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = LoggerFactory.getLogger(UserAPI.class);

    private DefaultAuthenticationProviderServiceImplement userService;

    public DefaultAuthenticationProvider(DefaultAuthenticationProviderServiceImplement userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        try {
            MMap input = new MMap();
            input.setString("username", authentication.getName());
            MMap userInfo = userService.getUserByName(input);

            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            MultiMap authorities = userInfo.getMultiMap("authorities");
            for (MMap authority: authorities.toListData()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getString("name")));
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            String _password = userInfo.getString("password");
            String password  = (String) authentication.getCredentials();
            boolean isPasswordMatch = passwordEncoder.matches(password, _password);

            if ( !isPasswordMatch) {
                throw new UsernameNotFoundException("Password invalid");
            }

            if (!userInfo.getString("username").equalsIgnoreCase(authentication.getName()) || userInfo == null) {
                throw new UsernameNotFoundException("User not found");
            }

            return new UsernamePasswordAuthenticationToken(
                    userInfo.getString("username"),
                    userInfo.getString("password"),
                    grantedAuthorities);

        } catch (Exception e) {
            log.error("\n ==>> ***get error class DefaultAuthenticationProvider ***<<==\n", e);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
