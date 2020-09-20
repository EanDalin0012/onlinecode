package com.onlinecode.admins.services;

import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;

public interface VendorService {
    MultiMap retrieveList(MMap param) throws Exception;
    Long save(MMap param) throws Exception;
    Long delete(MMap param) throws Exception;
    Long update(MMap param) throws Exception;
    int count();
    int sequence();
}