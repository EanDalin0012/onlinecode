package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.VendorDao;
import com.onlinecode.admins.services.VendorService;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImplement implements VendorService {

    @Autowired
    private VendorDao vendorDao;

    @Override
    public MultiMap retrieveList(MMap param) throws Exception {
        ValidatorUtil.validate(param, "status");
        return vendorDao.retrieveList(param);
    }

    @Override
    public Long save(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "name", "contact", "user_id", "status");
        return vendorDao.save(param);
    }

    @Override
    public Long delete(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "user_id", "status");
        return vendorDao.delete(param);
    }

    @Override
    public Long update(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "name", "contact", "user_id", "status");
        return vendorDao.update(param);
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int sequence() {
        return 0;
    }
}
