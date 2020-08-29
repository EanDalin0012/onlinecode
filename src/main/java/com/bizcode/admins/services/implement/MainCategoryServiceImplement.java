package com.bizcode.admins.services.implement;

import com.bizcode.admins.dao.CategoryDao;
import com.bizcode.admins.services.MainCategoryService;
import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import com.bizcode.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainCategoryServiceImplement implements MainCategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public MultiMap retrieveList(MMap param) throws Exception {
        ValidatorUtil.validate(param, "status");
        return categoryDao.retrieveList(param);
    }

    @Override
    public Long save(MMap param) throws Exception {
        ValidatorUtil.validate(param, "name");
        return categoryDao.save(param);
    }

    @Override
    public Long delete(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "status");
        return categoryDao.delete(param);
    }

    @Override
    public MMap retrieveCategoryById(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id");
        return categoryDao.retrieveCategoryById(param);
    }

    @Override
    public Long update(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "name", "status");
        return categoryDao.update(param);
    }

    @Override
    public int count() {
        return categoryDao.count();
    }
}
