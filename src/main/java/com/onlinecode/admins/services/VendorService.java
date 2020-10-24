package com.onlinecode.admins.services;

import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;

public interface VendorService {
    MultiMap retrieveList(MMap param) throws Exception, ValidatorException;
    Long save(MMap param) throws Exception, ValidatorException;
    Long delete(MMap param) throws Exception, ValidatorException;
    Long update(MMap param) throws Exception, ValidatorException;
    int count();
    int sequence();
}
