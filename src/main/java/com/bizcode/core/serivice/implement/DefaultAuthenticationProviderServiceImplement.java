package com.bizcode.core.serivice.implement;

import com.bizcode.core.dao.DefaultAuthenticationProviderDao;
import com.bizcode.core.map.MMap;
import com.bizcode.core.serivice.DefaultAuthenticationProviderService;
import com.bizcode.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class DefaultAuthenticationProviderServiceImplement implements UserDetailsService, DefaultAuthenticationProviderService {

    @Autowired
    private DefaultAuthenticationProviderDao defaultAuthenticationProviderDao;

    @Override
    public MMap getUserByName(MMap param) throws Exception {
        ValidatorUtil.validate(param,"username");
        return defaultAuthenticationProviderDao.getUserByName(param);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            MMap input = new MMap();
            input.setString("userName", username);
            MMap userInfo = defaultAuthenticationProviderDao.getUserByName(input);

            String userName = userInfo.getString("username");
            String password = userInfo.getString("password");
            Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>)  userInfo.getMMap("authorities");
            if (userInfo != null) {
                UserDetails userDetails = User.builder()
                        .username(userName)
                        .password(password)
                        .authorities(authorities)
                        .build();
                return userDetails;
            }
            throw new UsernameNotFoundException("User not found_0");

        } catch (Exception e) {
            throw e;
        }
    }
}
