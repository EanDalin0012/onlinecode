package com.onlinecode.admins.dao;

import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao {
    MultiMap retrieveList(MMap param);
    int save(MMap param);
    int delete(MMap param);
    int update(MMap param);
    int count();
}
