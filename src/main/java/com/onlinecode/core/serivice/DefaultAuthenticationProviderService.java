package com.bizcode.core.serivice;

import com.bizcode.core.map.MMap;

public interface DefaultAuthenticationProviderService {
    MMap getUserByName(MMap param) throws Exception;
}
