package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.UserDao;
import com.onlinecode.admins.services.UserService;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public MultiMap getList(MMap param) throws Exception {
        ValidatorUtil.validate(param, "status");
        return userDao.getList(param);
    }

    @Override
    public int save(MMap param) throws Exception {
        ValidatorUtil.validate(param, "firstName", "lastName", "dateBirth", "email", "password", "contact", "gender", "addressID", "userID");
        return userDao.save(param);
    }

    @Override
    public int delete(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id");
        return userDao.delete(param);
    }

    @Override
    public MMap getValueById(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id");
        return userDao.getValueById(param
        );
    }

    @Override
    public MMap loadUserByUserName(MMap param) throws Exception {
        return userDao.loadUserByUserName(param);
    }

    @Override
    public int update(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "firstName", "lastName", "dateBirth", "email", "password", "contact", "gender", "addressID", "userID");
        return userDao.update(param);
    }

    @Override
    public int count() {
        return userDao.count();
    }
}
