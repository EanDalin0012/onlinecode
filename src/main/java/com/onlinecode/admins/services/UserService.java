package com.bizcode.admins.services;

import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;

public interface UserService {
    MultiMap getList(MMap param) throws Exception;

    int save(MMap param) throws Exception;

    int delete(MMap param) throws Exception;

    MMap getValueById(MMap param) throws Exception;

    MMap loadUserByUserName(MMap param) throws Exception;

    int update(MMap param) throws Exception;

    int count();
}
