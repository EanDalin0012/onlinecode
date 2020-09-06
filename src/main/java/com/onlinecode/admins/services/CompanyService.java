package com.onlinecode.admins.services;


import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyService {
    MultiMap getList(MMap param);

    Long save(MMap param) throws Exception;

    Long delete(MMap param) throws Exception;

    MMap getValueById(MMap param) throws Exception;

    Long update(MMap param) throws Exception;

    int count();
}
