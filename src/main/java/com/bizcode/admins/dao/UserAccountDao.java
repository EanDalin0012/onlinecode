package com.bizcode.admins.dao;

import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountDao {
    int updateUserAccount(MMap param);

    MultiMap getList(MMap param);

    int count();
}
