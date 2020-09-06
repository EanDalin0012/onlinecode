package com.onlinecode.core.serivice;

import com.onlinecode.core.map.MMap;

public interface DefaultAuthenticationProviderService {
    MMap getUserByName(MMap param) throws Exception;
}
