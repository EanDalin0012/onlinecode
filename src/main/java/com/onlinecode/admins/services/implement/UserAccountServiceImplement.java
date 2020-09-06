package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.UserAccountDao;
import com.onlinecode.admins.services.UserAccountService;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImplement implements UserAccountService {
    @Autowired
    private UserAccountDao userAccountDao;

    @Override
    public int updateUserAccount(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "userName", "enabled", "accountLocked", "credentialsExpired", "accountExpired");
        return userAccountDao.updateUserAccount(param);
    }

    @Override
    public MultiMap getList(MMap param) {
        return userAccountDao.getList(param);
    }

    @Override
    public int count() {
        return 0;
    }

}
