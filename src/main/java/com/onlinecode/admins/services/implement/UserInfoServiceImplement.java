package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.UserInfoDao;
import com.onlinecode.admins.services.UserInfoService;
import com.onlinecode.admins.utils.ValidatorUtil;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImplement implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public MultiMap retrieveList(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "status");
        return userInfoDao.retrieveList(param);
    }

    @Override
    public int save(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id","first_name","last_name","gender","date_birth","email","contact","status","user_id");
        return userInfoDao.save(param);
    }

    @Override
    public int delete(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "status","id");
        return userInfoDao.delete(param);
    }

    @Override
    public int update(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id","first_name","last_name","gender","date_birth","email","contact","status","user_id");
        return userInfoDao.update(param);
    }

    @Override
    public int count() {
        return userInfoDao.count();
    }

}
