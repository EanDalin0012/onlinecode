/*-----------------------------------------------------------------------------------------
 * NAME : ValidatorUtil.java
 * VER  : v0.1
 * PROJ : ppcb-apsara
 * Copyright 2018 PPCB All rights reserved
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2018-08-07   phorly          creation
 *---------------------------------------------------------------------------------------*/
package com.onlinecode.admins.utils;

import com.onlinecode.core.exception.ApplicationException;
import com.onlinecode.core.exception.ValueException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.utils.MRUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * <PRE>
 * -- detail description --
 * </PRE>
 *
 * @version 0.1, 2018-08-07
 * @logicalName ValidatorUtil
 */
public class ValidatorUtil {
    private static final Logger logger = LoggerFactory.getLogger(ValidatorUtil.class);

    public static void validate(MMap ipParam, String... ipFields) throws ApplicationException {
        for (String sKey : ipFields) {
            if (MRUtil.isEmpty(MRUtil.trim(ipParam.getString(sKey)))) {
                logger.info("Error : " + sKey + " is empty !!!");
                throw new ApplicationException(sKey, "Invalid field[" + sKey + "]. Please add field");
            }
        }
    }

    public static void validateNull(MMap ipParam, String... ipFields) throws ApplicationException {
        for (String sKey : ipFields) {
            if (MRUtil.isNull(ipParam.getString(sKey))) {
                logger.info(String.join(" ", "<<<<< *****", sKey, "is null !!!"));
                throw new ApplicationException(sKey, "field["+sKey+"] is null");
            }
        }
    }

    public static void validateValue(MMap ipParam, String... ipFields) throws ValueException {
        for (String sKey : ipFields) {
            if (MRUtil.isNull(ipParam.getString(sKey)) || StringUtils.isEmpty(sKey)) {
                throw new ValueException(sKey);
            }
        }
    }

    public static MMap emptyToBeNull(MMap ipParam, String... sField) {
        String sTemp = null;
        for (String sKey : sField) {
            sTemp = ipParam.getString(sKey);
            if (MRUtil.isEmpty(sTemp)) {
                ipParam.set(sKey, null);
            }
        }
        return ipParam;
    }

    public static MMap makeOptional(MMap ipParam, String sType, String... sField) {
        for (String sKey : sField) {
            if (!MRUtil.isEmpty(ipParam.getString(sKey))) {
                continue;
            }
            if (sType.equals("S")) {
                ipParam.set(sKey, "");
            } else if (sType.equals("L")) {
                ipParam.set(sKey, 0L);
            } else if (sType.equals("BD")) {
                ipParam.set(sKey, BigDecimal.ZERO);
            }
        }
        return ipParam;
    }
}
