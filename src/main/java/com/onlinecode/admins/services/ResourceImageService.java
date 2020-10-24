package com.onlinecode.admins.services;

import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;

public interface ResourceImageService {
    Long save(MMap param) throws ValidatorException;
    Long delete(MMap param) throws ValidatorException;
    Long update(MMap param) throws ValidatorException;
    String getResourcesImageById(MMap param) throws ValidatorException;
}
