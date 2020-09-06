package com.onlinecode.admins.services;

import com.onlinecode.core.map.MMap;

public interface ResourceFileInfoService {
    long getLastId();

    int fileUpload(MMap param);

    MMap getResourceById(MMap param);

    int deleteById(MMap param);
}
