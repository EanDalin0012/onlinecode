package com.onlinecode.admins.dao;

import com.onlinecode.core.map.MMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailsDao {
    Long save(MMap param);
}
