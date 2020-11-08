package com.onlinecode.webs.service.imp;

import com.onlinecode.core.map.MMap;
import com.onlinecode.webs.dao.ReaderImgDao;
import com.onlinecode.webs.service.ReaderImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderImgServiceImp implements ReaderImgService {

    @Autowired
    private ReaderImgDao readerImgDao;
    @Override
    public MMap getResourcesImageById(MMap param) {
        return readerImgDao.getResourcesImageById(param);
    }
}
