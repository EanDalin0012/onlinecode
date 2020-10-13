package com.onlinecode.admins.services;

import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;

public interface CategoryService {
    MultiMap retrieveList(MMap param) throws   ValidatorException, Exception;
    Long save(MMap param) throws ValidatorException, Exception ;
    Long delete(MMap param) throws  ValidatorException, Exception;
    MMap retrieveCategoryById(MMap param) throws ValidatorException, Exception;
    Long update(MMap param) throws  ValidatorException, Exception;
    int count();
    int sequence();
}
