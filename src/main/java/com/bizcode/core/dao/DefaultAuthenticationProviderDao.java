package com.bizcode.core.dao;

import com.bizcode.core.map.MMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DefaultAuthenticationProviderDao {
    MMap getUserByName(MMap param);
}
