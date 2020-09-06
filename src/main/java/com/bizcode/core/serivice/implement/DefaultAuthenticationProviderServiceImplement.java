package com.bizcode.core.serivice.implement;

import com.bizcode.core.dao.DefaultAuthenticationProviderDao;
import com.bizcode.core.map.MMap;
import com.bizcode.core.serivice.DefaultAuthenticationProviderService;
import com.bizcode.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(DefaultAuthenticationProviderServiceImplement.class);

    @Autowired
    private DefaultAuthenticationProviderDao defaultAuthenticationProviderDao;

    @Override
    public MMap getUserByName(MMap param) throws Exception {
        ValidatorUtil.validate(param, "username");
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
            Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>) userInfo.getMMap("authorities");
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
            log.error("get error exception service loadUserByUsername:", e);
            throw e;
        }
    }

    public MMap getTrackUserLockByUserName(MMap param) throws Exception {
        MMap out = new MMap();
        try {
            ValidatorUtil.validate(param, "userName", "isLocked");
            out = defaultAuthenticationProviderDao.getTrackUserLockByUserName(param);
        } catch (Exception e) {
            log.error("get error exception service getTrackUserLockByUserName:", e);
            throw e;
        }
        return out;
    }

    public int lockedUser(MMap param) throws Exception {
        try {
            ValidatorUtil.validate(param, "userName", "accountLocked");
            return defaultAuthenticationProviderDao.lockedUser(param);
        } catch (Exception e) {
            log.error("get error exception service lockedUser:", e);
            throw e;
        }
    }

    public int trackLockSaveUserLock(MMap param) throws Exception {
        try {
            ValidatorUtil.validate(param, "userName", "message", "count", "status", "isLocked");
            return defaultAuthenticationProviderDao.trackSaveUserLock(param);
        } catch (Exception e) {
            log.error("get error exception service trackLockSaveUserLock:", e);
            throw e;
        }
    }

    public int trackUpdateUserLock(MMap param) throws Exception {
        try {
            ValidatorUtil.validate(param, "id", "userName", "message", "count", "status", "isLocked");
            return defaultAuthenticationProviderDao.trackUpdateUserLock(param);
        } catch (Exception e) {
            log.error("get error exception service trackLockUpdateUserLock:", e);
            throw e;
        }
    }

    public int trackUpdateUserIsLocked(MMap param) throws Exception {
        try {
            ValidatorUtil.validate(param, "id", "status", "isLocked", "isUpdateLocked");
            return defaultAuthenticationProviderDao.trackUpdateUserIsLocked(param);
        } catch (Exception e) {
            log.error("get error exception service trackUpdateUserIsLocked:", e);
            throw e;
        }
    }

    public int updateLoginSuccess(MMap param) throws Exception {
        int _return = 0;
        try {
            ValidatorUtil.validate(param, "userName");
            _return = defaultAuthenticationProviderDao.updateLoginSuccess(param);
        } catch (Exception e) {
            log.error("get error exception service updateLoginSuccess", e);
            throw e;
        }

        return _return;
    }
}
