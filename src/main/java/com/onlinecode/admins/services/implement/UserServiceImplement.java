package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.UserDao;
import com.onlinecode.admins.services.UserService;
import com.onlinecode.admins.utils.ValidatorUtil;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public MultiMap getList(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "status");
        return userDao.getList(param);
    }

    @Override
    public int save(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "user_name", "passwd", "is_first_login", "enable", "account_lock", "credential_expired", "account_expired", "status", "user_id");
        return userDao.save(param);
    }

    @Override
    public int delete(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id");
        return userDao.delete(param);
    }


    @Override
    public MMap loadUserByUserName(MMap param) throws ValidatorException {
        com.onlinecode.admins.utils.ValidatorUtil.validate(param, "user_name");
        return userDao.loadUserByUserName(param);
    }

    @Override
    public int update(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id", "firstName", "lastName", "dateBirth", "email", "password", "contact", "gender", "addressID", "userID");
        return userDao.update(param);
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public int sequence() {
        return userDao.sequence();
    }
}
