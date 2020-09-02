package com.bizcode.admins.services.implement;

import com.bizcode.admins.dao.UserAccountDao;
import com.bizcode.admins.services.UserAccountService;
import com.bizcode.core.map.MMap;
import com.bizcode.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImplement implements UserAccountService {
    @Autowired
    private UserAccountDao userAccountDao;
    @Override
    public int updateUserAccount(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "userName", "enable", "accountLock", "credentialsExpired", "accountExpired");
        return userAccountDao.updateUserAccount(param);
    }

}
