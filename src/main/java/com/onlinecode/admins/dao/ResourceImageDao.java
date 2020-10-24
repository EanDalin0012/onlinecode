package com.onlinecode.admins.dao;

import com.onlinecode.core.map.MMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceImageDao {
    Long save(MMap param);
    Long delete(MMap param);
    Long update(MMap param);
    String getResourcesImageById(MMap param);
}
