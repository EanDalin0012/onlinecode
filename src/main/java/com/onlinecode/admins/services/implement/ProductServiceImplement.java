package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.ProductDao;
import com.onlinecode.admins.services.ProductService;
import com.onlinecode.admins.utils.ValidatorUtil;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public MultiMap retrieveList(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "status");
        return productDao.retrieveList(param);
    }

    @Override
    public Long save(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id", "name", "status", "user_id", "category_id");
        return productDao.save(param);
    }

    @Override
    public Long delete(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id", "status","user_id");
        return productDao.delete(param);
    }

    @Override
    public Long update(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id", "name", "status", "user_id");
        return productDao.update(param);
    }

    @Override
    public Long updateShowOnWeb(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id", "web_show", "status", "user_id");
        return productDao.updateShowOnWeb(param);
    }

    @Override
    public Long updateShowOnMobile(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id", "mobile_show", "status", "user_id");
        return productDao.updateShowOnMobile(param);
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
