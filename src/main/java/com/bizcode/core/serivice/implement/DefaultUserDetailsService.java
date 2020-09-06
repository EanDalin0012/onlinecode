package com.bizcode.core.serivice.implement;

import com.bizcode.core.dao.DefaultAuthenticationProviderDao;
import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class DefaultUserDetailsService implements UserDetailsService {
    @Autowired
    private DefaultAuthenticationProviderDao appUserRepository;

    public DefaultUserDetailsService(DefaultAuthenticationProviderDao appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MMap input = new MMap();
        input.setString("username", username);

        MMap userInfo = appUserRepository.getUserByName(input);

        if (userInfo != null) {
            MultiMap _authorities = userInfo.getMultiMap("authorities");
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            for (MMap _authority : _authorities.toListData()) {
                authorities.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return _authority.getString("name");
                    }
                });
            }

            return new User("admin",
                    "",
                    authorities);
        }
        return null;
    }
}
