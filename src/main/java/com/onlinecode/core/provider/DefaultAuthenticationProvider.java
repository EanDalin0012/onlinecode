package com.onlinecode.core.provider;

import com.onlinecode.admins.api.UserAPI;
import com.onlinecode.core.constant.UserLockStatus;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.core.serivice.implement.DefaultAuthenticationProviderServiceImplement;
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

import java.util.ArrayList;
import java.util.List;

public class DefaultAuthenticationProvider implements AuthenticationProvider {
    private static final Logger log = LoggerFactory.getLogger(UserAPI.class);
    @Autowired
    private DefaultAuthenticationProviderServiceImplement userService;

    public DefaultAuthenticationProvider(DefaultAuthenticationProviderServiceImplement userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("\n<<<<<==============Start Authorization ===============>>>>>>>>>>>>\n");
        try {
            MMap input = new MMap();
            input.setString("user_name", authentication.getName());
            MMap userInfo = userService.getUserByName(input);
            log.info("<<<<<==============authorization param : {user_name:"+authentication.getName()+"}===============>>>>>>>>>>>>");

            if (userInfo == null) {
                log.info("<<<<<==============Authorization user not found===============>>>>>>>>>>>>");
                throw new UsernameNotFoundException("User Not found");
            }

            if (userInfo.getBoolean("accountLocked")) {
                log.info("<<<<<==============user account is locked===============>>>>>>>>>>>>");
                throw new UsernameNotFoundException("Your user account locked");
            }

            if (!userInfo.getBoolean("enabled")) {
                log.info("<<<<<==============user enabled false===============>>>>>>>>>>>>");
                throw new UsernameNotFoundException("Your user account enabled");
            }

            if (userInfo.getBoolean("accountExpired")) {
                log.info("<<<<<==============user account expired===============>>>>>>>>>>>>");
                throw new UsernameNotFoundException("Your user account account expired");
            }

            if (userInfo.getBoolean("credentialsExpired")) {
                log.info("<<<<<==============user account credentials expired ===============>>>>>>>>>>>>");
                throw new UsernameNotFoundException("Your user account credentials expired");
            }


            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String _password = userInfo.getString("password");
            String password = (String) authentication.getCredentials();
            boolean isPasswordMatch = passwordEncoder.matches(password, _password);

            if (!isPasswordMatch) {
                int count = trackLockUser(authentication.getName(), "User input wrong password");
                if (count >= 5) {
                    throw new UsernameNotFoundException("Your account is locked. Please contact to admin for unlocked you account");
                }
                throw new UsernameNotFoundException("Password invalid " + count + " time");
            }

            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            MultiMap authorities = userInfo.getMultiMap("authorities");
            for (MMap authority : authorities.toListData()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getString("name")));
            }

            MMap param = new MMap();
            param.setString("userName", authentication.getName());
            userService.updateLoginSuccess(param);
            log.info("\n<<<<<==============End Authorization ===============>>>>>>>>>>>>\n");
            return new UsernamePasswordAuthenticationToken(
                    userInfo.getString("username"),
                    userInfo.getString("password"),
                    grantedAuthorities);

        } catch (UsernameNotFoundException ex) {
            log.info("\n<<<<<============== get error user name not found exception ===============>>>>>>>>>>>>\n" +ex);
            throw ex;
        } catch (Exception e) {
            log.error("\n ==>> ***get error class default authentication exception ***<<==\n", e);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private int trackLockUser(String _userName, String _message) throws Exception {
        int count = 1;
        try {
            MMap _input = new MMap();
            _input.setString("user_name", _userName);
            _input.setBoolean("isLocked", false);
            MMap _objLockUser = userService.getTrackUserLockByUserName(_input);

            if (_objLockUser != null) {
                int _count = _objLockUser.getInt("count");
                if (_count <= 5) {
                    count = (_count + 1);
                    int length = count;
                    MMap _update = new MMap();
                    _update.setString("user_name", _userName);
                    _update.setInt("id", _objLockUser.getInt("id"));
                    _update.setString("status", UserLockStatus.Processing.Value());
                    _update.setString("message", _message);
                    _update.setInt("count", length);
                    _update.setBoolean("isLocked", false);
                    userService.trackUpdateUserLock(_update);

//                  Update Status User Account ot account locked = true
                    if (length >= 5) {
                        MMap update_ = new MMap();
                        update_.setInt("id", _objLockUser.getInt("id"));
                        update_.setBoolean("isLocked", true);
                        update_.setBoolean("isUpdateLocked", false);
                        update_.setString("status", UserLockStatus.End.Value());
                        userService.trackUpdateUserIsLocked(update_);

                        MMap _lockUser = new MMap();
                        _lockUser.setString("user_name", _userName);
                        _lockUser.setBoolean("accountLocked", true);
                        userService.lockedUser(_lockUser);
                    }
                }
            } else {
                MMap _save = new MMap();
                _save.setString("user_name", _userName);
                _save.setString("message", _message);
                _save.setInt("count", count);
                _save.setString("status", UserLockStatus.Start.Value());
                _save.setBoolean("isLocked", false);
                userService.trackLockSaveUserLock(_save);
            }

        } catch (Exception e) {
            log.error("get error user service lock user", e);
            e.printStackTrace();
            throw e;
        }
        return count;
    }
}
