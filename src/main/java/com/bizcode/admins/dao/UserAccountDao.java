package com.bizcode.admins.dao;

import com.bizcode.core.map.MMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountDao {
    int updateUserAccount(MMap param);
}
