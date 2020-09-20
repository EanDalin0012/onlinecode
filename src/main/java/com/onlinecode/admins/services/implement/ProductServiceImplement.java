package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.ProductDao;
import com.onlinecode.admins.services.ProductService;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public MultiMap retrieveList(MMap param) throws Exception {
        ValidatorUtil.validate(param, "status");
        return productDao.retrieveList(param);
    }

    @Override
    public Long save(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "name", "status", "user_id");
        return productDao.save(param);
    }

    @Override
    public Long delete(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "status","user_id");
        return productDao.delete(param);
    }

    @Override
    public Long update(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "name", "status", "user_id");
        return productDao.update(param);
    }

    @Override
    public int count() {
        return productDao.count();
    }

    @Override
    public int sequence() {
        return productDao.sequence();
    }
}
