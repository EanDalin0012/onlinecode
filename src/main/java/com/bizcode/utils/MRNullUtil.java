package com.bizcode.utils;

import java.util.List;
import java.util.Map;

public class MRNullUtil {
    /**
     * Constructor for MNullUtil
     */
    private MRNullUtil()	 {
        super();
    }

    /**
     * Check whether the input value is null.
     * All DB Access methods use this when null checking is required.
     *
     * @param value Object
     * @return boolean
     */
    public static boolean isNull(Object value) {
        return value == null;
    }

    /**
     * Check whether the input value is null.
     * The default is to return both "" and null as true.
     * All DB Access methods use this when null checking is required.
     *
     * @param value String
     * @return boolean
     */
    public static boolean isNone(String value) {
        return value == null || value.length() == 0;
    }

    /**
     * Returns true if value is null or size () = 0 otherwise false
     *
     * @param value List
     * @return boolean
     */
    public static boolean isNone(List value) {
        return (value == null || value.isEmpty());
    }

    /**
     * Returns true if value is null or size () = 0 otherwise false
     *
     * @param value Object[]
     * @return boolean
     */
    public static boolean isNone(Object[] value) {
        return (value == null || value.length == 0);
    }

    /**
     * Returns true if value is null or size () = 0 otherwise false
     *
     * @param value Map
     * @return boolean
     */
    public static boolean isNone(Map value) {
        return (value == null || value.isEmpty());
    }


    public static boolean notNone(String value) {
        return value != null && value.length() > 0;
    }

    /**
     * If the value of the original String is null or "", it returns defaultStr
     *
     * @param originalStr String (originalStr String)
     * @param defaultStr String (The String to be replaced if there is a null in the original String)
     * @return string
     */
    public static String NVL(String originalStr, String defaultStr) {
        if(originalStr == null || originalStr.length() < 1) return defaultStr;
        return originalStr;
    }

    /**
     * <code>
     * If object is null, or object.toString is null or "", defalutValue is returned
     * , otherwise object.toString is returned.
     * </code>
     * If the value of the original String is null or "", it returns defaultStr
     *
     * @param object (null)
     * @param defaultValue (The default value to return if Object is null)
     * @return String  (DefaultValue if Object is null, otherwise object.toString ())
     */
    public static String NVL(Object object, String defaultValue) {
        if(object == null) {
            return defaultValue;
        }
        return NVL(object.toString(), defaultValue);
    }

    /**
     * Prevent ' null ' output within jsp for normal type and convert it to a string for return
     *
     * @param object (Expected String to contain null in jsp)
     * @return string (String transformed to "")
     */
    public static String print(Object object) {
        if(object == null) {
            return "";
        }
        return object.toString();
    }
}
