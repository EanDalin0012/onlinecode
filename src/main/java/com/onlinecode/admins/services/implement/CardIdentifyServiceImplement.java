package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.CardIdentifyDao;
import com.onlinecode.admins.services.CardIdentifyService;
import com.onlinecode.admins.utils.ValidatorUtil;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinecode.core.exception.ValidatorException;

@Service
public class CardIdentifyServiceImplement implements CardIdentifyService {

    @Autowired
    private CardIdentifyDao cardIdentifyDao;

    @Override
    public MultiMap retrieveList(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "status");
        return cardIdentifyDao.retrieveList(param);
    }

    @Override
    public MMap retrieveCardIdentifyById(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "card_id");
        return cardIdentifyDao.retrieveCardIdentifyById(param);
    }

    @Override
    public int save(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "card_id","status");
        return cardIdentifyDao.save(param);
    }

    @Override
    public int delete(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id","status");
        return cardIdentifyDao.delete(param);
    }

    @Override
    public int update(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id","card_id","status");
        return cardIdentifyDao.update(param);
    }

    @Override
    public int count() {
        return cardIdentifyDao.count();
    }



}
