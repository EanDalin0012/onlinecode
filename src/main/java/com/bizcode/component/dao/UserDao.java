package com.bizcode.component.dao;

import com.bizcode.core.map.MMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    MMap loadUserByUsername(MMap param);
}
