package com.bizcode.admins.dao;

import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao {
    MultiMap retrieveList(MMap param);

    Long save(MMap param);

    Long delete(MMap param);

    MMap retrieveCategoryById(MMap param);

    Long update(MMap param);

    int count();
}
