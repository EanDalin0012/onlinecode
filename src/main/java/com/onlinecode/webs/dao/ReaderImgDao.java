package com.onlinecode.webs.dao;

import com.onlinecode.core.map.MMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReaderImgDao {
    MMap getResourcesImageById(MMap param);
}
