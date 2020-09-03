package com.bizcode.admins.services;

import com.bizcode.core.map.MMap;

public interface ResourceFileInfoService {
    long getLastId();
    int fileUpload(MMap param);
    MMap getResourceById(MMap param);
    int deleteById(MMap param);
}
