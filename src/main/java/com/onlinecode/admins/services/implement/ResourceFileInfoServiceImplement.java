package com.onlinecode.admins.services.implement;

import com.onlinecode.admins.dao.ResourceFileInfoDao;
import com.onlinecode.admins.services.ResourceFileInfoService;
import com.onlinecode.core.map.MMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceFileInfoServiceImplement implements ResourceFileInfoService {
    @Autowired
    private ResourceFileInfoDao resourceFileInfoDao;

    @Override
    public long getLastId() {
        return resourceFileInfoDao.getLastId();
    }

    @Override
    public int fileUpload(MMap param) {
        return resourceFileInfoDao.fileUpload(param);
    }

    @Override
    public MMap getResourceById(MMap param) {
        return resourceFileInfoDao.getResourceById(param);
    }

    @Override
    public int deleteById(MMap param) {
        return resourceFileInfoDao.deleteById(param);
    }
}
