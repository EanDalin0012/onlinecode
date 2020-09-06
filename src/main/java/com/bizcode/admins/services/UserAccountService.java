package com.bizcode.admins.services;

import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;

public interface UserAccountService {
    int updateUserAccount(MMap param) throws Exception;

    MultiMap getList(MMap param);

    int count();
}
