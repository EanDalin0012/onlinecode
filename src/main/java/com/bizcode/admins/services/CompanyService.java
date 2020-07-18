package com.bizcode.admins.services;


import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyService {
    MultiMap getList(MMap param);
    Long save(MMap param) throws Exception;
    Long delete(MMap param) throws Exception;
    MMap getValueById(MMap param);
    Long update(MMap param) throws Exception;
    int count();
}
