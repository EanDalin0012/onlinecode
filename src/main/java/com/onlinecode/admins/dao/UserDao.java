package com.onlinecode.admins.dao;

import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    MultiMap getList(MMap param);

    int save(MMap param);

    int delete(MMap param);

    MMap getValueById(MMap param);

    MMap loadUserByUserName(MMap param);

    int update(MMap param);

    int count();
}
