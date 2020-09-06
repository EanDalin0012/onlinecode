package com.bizcode.admins.dao;

import com.bizcode.core.map.MMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceFileInfoDao {
    long getLastId();

    int fileUpload(MMap param);

    MMap getResourceById(MMap param);

    int deleteById(MMap param);
}
