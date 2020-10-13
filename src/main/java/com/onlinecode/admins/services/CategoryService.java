package com.onlinecode.admins.services;

import com.onlinecode.core.exception.ApplicationException;
import com.onlinecode.core.exception.ValueException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;

public interface CategoryService {
    MultiMap retrieveList(MMap param) throws Exception, ApplicationException, ValueException;
    Long save(MMap param) throws Exception, ApplicationException, ValueException;
    Long delete(MMap param) throws Exception, ApplicationException, ValueException;
    MMap retrieveCategoryById(MMap param) throws Exception, ApplicationException, ValueException;
    Long update(MMap param) throws Exception, ApplicationException, ValueException;
    int count();
    int sequence();
}
