package com.onlinecode.admins.dao;

import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VendorDao {
    MultiMap retrieveList(MMap param);
    Long save(MMap param);
    Long delete(MMap param);
    Long update(MMap param);
    int count();
    int sequence();
}
