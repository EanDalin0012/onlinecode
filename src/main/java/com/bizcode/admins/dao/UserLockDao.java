package com.bizcode.admins.dao;

import com.bizcode.core.map.MMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLockDao {
    MMap getUserLockByUserName(MMap param);
    int saveUserLock(MMap param);
    MMap updateUserLock(MMap param);
}
