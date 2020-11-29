package com.onlinecode.admins.services;

import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;

public interface UserService {
    MultiMap getList(MMap param) throws Exception, ValidatorException;
    int save(MMap param) throws Exception, ValidatorException;
    int delete(MMap param) throws Exception, ValidatorException;
    MMap loadUserByUserName(MMap param) throws Exception, ValidatorException;
    int update(MMap param) throws Exception, ValidatorException;
    int count();
    int sequence();
}
