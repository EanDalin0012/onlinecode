package com.onlinecode.admins.utils;

import com.onlinecode.core.exception.ApplicationException;
import com.onlinecode.core.exception.ValueException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.utils.MRUtil;

public class FieldValueValidator {
    public static void validateFieldValue(MMap ipParam, String... ipFields) throws ApplicationException, ValueException {
        ValidatorUtil.validate(ipParam, ipFields);
        ValidatorUtil.validateValue(ipParam, ipFields);
    }
}
