package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.CategoryDao;
import com.onlinecode.admins.services.CategoryService;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImplement implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public MultiMap retrieveList(MMap param) throws Exception {
        ValidatorUtil.validate(param, "status");
        return categoryDao.retrieveList(param);
    }

    @Override
    public Long save(MMap param) throws Exception{
        ValidatorUtil.validate(param, "name","status", "user_id");
        return categoryDao.save(param);
    }

    @Override
    public Long delete(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id","status", "user_id");
        return categoryDao.delete(param);
    }

    @Override
    public MMap retrieveCategoryById(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id","status");
        return categoryDao.retrieveCategoryById(param);
    }

    @Override
    public Long update(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id","status", "name", "user_id");
        return categoryDao.update(param);
    }

    @Override
    public int count() {
        return categoryDao.count();
    }

    @Override
    public int sequence() {
        return categoryDao.sequence();
    }
}
