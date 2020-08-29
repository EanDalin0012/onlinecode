package com.bizcode.admins.services;

import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryService {
    MultiMap retrieveList(MMap param) throws Exception;
    Long save(MMap param) throws Exception;
    Long delete(MMap param) throws Exception;
    MMap retrieveCategoryById(MMap param) throws Exception;
    Long update(MMap param) throws Exception;
    int count();
}
