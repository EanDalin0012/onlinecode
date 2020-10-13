package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.CategoryDao;
import com.onlinecode.admins.services.CategoryService;
import com.onlinecode.admins.utils.FieldValueValidator;
import com.onlinecode.admins.utils.ValidatorUtil;
import com.onlinecode.core.exception.ApplicationException;
import com.onlinecode.core.exception.ValueException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImplement implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public MultiMap retrieveList(MMap param) throws ApplicationException, ValueException {
        FieldValueValidator.validateFieldValue(param, "status");
        return categoryDao.retrieveList(param);
    }

    @Override
    public Long save(MMap param) throws ApplicationException, ValueException {
        FieldValueValidator.validateFieldValue(param,"name","status", "user_id");
        return categoryDao.save(param);
    }

    @Override
    public Long delete(MMap param) throws ApplicationException, ValueException {
        FieldValueValidator.validateFieldValue(param, "id","status", "user_id");
        return categoryDao.delete(param);
    }

    @Override
    public MMap retrieveCategoryById(MMap param) throws ApplicationException, ValueException {
        FieldValueValidator.validateFieldValue(param, "id","status");
        return categoryDao.retrieveCategoryById(param);
    }

    @Override
    public Long update(MMap param) throws ApplicationException, ValueException {
        ValidatorUtil.validate(param, "id","status", "name", "user_id");
        FieldValueValidator.validateFieldValue(param, "id","status", "name", "user_id");
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
