package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.ResourceImageDao;
import com.onlinecode.admins.services.ResourceImageService;
import com.onlinecode.admins.utils.ValidatorUtil;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceImageServiceImplement implements ResourceImageService {
    @Autowired
    private ResourceImageDao resourceImageDao;

    @Override
    public Long save(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id", "original_name", "file_size", "file_type", "file_extension","file_source");
        return resourceImageDao.save(param);
    }

    @Override
    public Long delete(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id");
        return resourceImageDao.delete(param);
    }

    @Override
    public Long update(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "id");
        return resourceImageDao.update(param);
    }

    @Override
    public String getResourcesImageById(MMap param) throws ValidatorException {
        ValidatorUtil.validate(param, "uuid");
        return resourceImageDao.getResourcesImageById(param);
    }
}
