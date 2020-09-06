package com.onlinecode.admins.services;

import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;

public interface UserAccountService {
    int updateUserAccount(MMap param) throws Exception;

    MultiMap getList(MMap param);

    int count();
}
