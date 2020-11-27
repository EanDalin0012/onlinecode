package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.AccountDao;
import com.onlinecode.admins.services.AccountService;
import com.onlinecode.admins.utils.ValidatorUtil;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplement implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public MultiMap retrieveList(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "status");
        return accountDao.retrieveList(param);
    }

    @Override
    public int save(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "status");
        return accountDao.save(param);
    }

    @Override
    public int delete(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "status");
        return accountDao.delete(param);
    }

    @Override
    public int update(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "status");
        return accountDao.update(param);
    }

    @Override
    public int count() {
        return accountDao.count();
    }

    @Override
    public int sequence() {
        return accountDao.sequence();
    }
}
