package com.onlinecode.admins.services;

import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;

public interface UserInfoService {
    MultiMap retrieveList(MMap param) throws ValidatorException;
    int save(MMap param) throws ValidatorException;
    int delete(MMap param) throws ValidatorException;
    int update(MMap param) throws ValidatorException;
    int count();
}
