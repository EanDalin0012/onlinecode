package com.bizcode.core.map;


import com.bizcode.core.protocol.MProtocol;

import java.math.BigDecimal;
import java.util.*;

public class MultiMap extends ArrayList<LinkedHashMap<String, Object>> implements MProtocol {
    private static final long serialVersionUID = 8154940219462381299L;

    private boolean nullToInitialize = false;

    public boolean isNullToInitialize() {
        return this.nullToInitialize;
    }

    public void setNullToInitialize(boolean nullToInitialize) {
        this.nullToInitialize = nullToInitialize;
    }

    /**
     * Constructor for MMultiData
     */
    public MultiMap() {
        super();
    }

    /**
     * Constructor for MMultiData
     *
     * @param map
     */
    public MultiMap(List map) {
        super(map);
    }

    public Object[] getKeys() {
        Object[] keyArr = new Object[0];
        if (size() > 0) {
            keyArr = get(0).keySet().toArray();
        }
        return keyArr;
    }

    public void put(Object key, List l) {
        for (int i = 0; i < l.size(); i++) {
            if (size() < i + 1) {
                add(new MMap());
            }
            ((Map) get(i)).put(key, l.get(i));
        }
    }

    public void putAll(List m) {
        clear();
        addAll(m);
    }

    /**
     * Delete the data (column) for a given key.
     *
     * @param key Key in column to delete
     * @see #removeColumn(String)
     */
    public void removeColumn(String key) {
        for (int i = 0; i < this.size(); i++) {

            if (this.get(i).containsKey(key)) {
                this.get(i).remove(key);
            }
        }
    }

    /**
     * Delete the data (row) for a given key.
     *
     * @param keyIndex Key in row to delete
     * @see #removeRow(int)
     */
    public void removeRow(int keyIndex) {
        remove(keyIndex);
    }

    public Object getKeyWithIndex(int keyIndex) {
        return getKeyWithIndex(keyIndex, 0);
    }

    /**
     * Returns the key object corresponding to the index.
     *
     * @param keyIndex
     * @return int
     */
    public Object getKeyWithIndex(int keyIndex, int index) {
        Object retObj = null;
        Set<String> tempSet = this.get(index).keySet();

        if (keyIndex >= tempSet.size()) {
            System.out.println("\033[31;1m keyIndex >= tempSet.size() ===>> getKeyWithIndex( int keyIndex, int index ) \033[32;1;2m param: {" + keyIndex + ", " + index + "}! ");
        }

        Iterator<String> iterator = tempSet.iterator();
        for (int inx = 0; inx <= keyIndex; inx++) {
            retObj = iterator.next();
        }
        return retObj;
    }

    // ClassCastException
    public List<MMap> get(Object key) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < size(); i++) {
            list.add(get(i).get(key));
        }
        return list;
    }

    public List<MMap> toListData() {
        List<MMap> listData = new ArrayList<MMap>();
        for (LinkedHashMap<String, Object> map : this) {
            listData.add(new MMap(map));
        }
        return listData;
    }

    public void addMMap(MMap Data) {
        add(new MMap(Data));
    }

    /**
     * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
     *
     * @param key          String
     * @param index        int
     * @param replaceValue Object
     */
    public void modify(String key, int index, Object replaceValue) {
        if (!(size() > index)) {
            System.out.println("\033[31;1m !( size() > index ) ===>> modify( String key, int index, String replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        if (!get(index).containsKey(key)) {
            System.out.println("\033[31;1m !get( index ).containsKey( key ) ===>> modify( String key, int index, String replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        get(index).put(key, replaceValue);
    }

    /**
     * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
     *
     * @param key          String
     * @param index        int
     * @param replaceValue boolean
     */
    public void modifyBoolean(String key, int index, boolean replaceValue) {
        if (!(size() > index)) {
            System.out.println("\033[31;1m !( size() > index ) ===>> modifyBoolean( String key, int index, String replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        if (!get(index).containsKey(key)) {
            System.out.println("\033[31;1m !get( index ).containsKey( key ) ===>> modifyBoolean( String key, int index, String replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        get(index).put(key, replaceValue);
    }

    /**
     * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
     *
     * @param key          String
     * @param index        int
     * @param replaceValue String
     */
    public void modifyString(String key, int index, String replaceValue) {
        if (!(size() > index)) {
            System.out.println("\033[31;1m !( size() > index ) ===>> modifyString( String key, int index, String replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        get(index).put(key, replaceValue);
    }

    /**
     * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
     *
     * @param key          String
     * @param index        int
     * @param replaceValue int
     */
    public void modifyInt(String key, int index, int replaceValue) {
        if (!(size() > index)) {
            System.out.println("\033[31;1m !( size() > index ) ===>> modifyInt( String key, int index, int replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        get(index).put(key, replaceValue);
    }

    /**
     * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
     *
     * @param key          String
     * @param index        int
     * @param replaceValue double
     */
    public void modifyDouble(String key, int index, double replaceValue) {
        if (!(size() > index)) {
            System.out.println("\033[31;1m !( size() > index ) ===>> modifyDouble( String key, int index, double replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        get(index).put(key, replaceValue);
    }

    /**
     * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
     *
     * @param key          String
     * @param index        int
     * @param replaceValue float
     */
    public void modifyFloat(String key, int index, float replaceValue) {
        if (!(size() > index)) {
            System.out.println("\033[31;1m !( size() > index ) ===>> modifyFloat( String key, int index, float replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        get(index).put(key, replaceValue);
    }

    /**
     * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
     *
     * @param key          String
     * @param index        int
     * @param replaceValue long
     */
    public void modifyLong(String key, int index, long replaceValue) {
        if (!(size() > index)) {
            System.out.println("\033[31;1m !( size() > index ) ===>>modifyLong( String key, int index, long replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
//	        MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
//	                this.getClass(), "modify(Object key, int index, Object replaceValue)");
        }
        get(index).put(key, replaceValue);
    }

    /**
     * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
     *
     * @param key          String
     * @param index        int
     * @param replaceValue short
     */
    public void modifyShort(String key, int index, short replaceValue) {
        if (!(size() > index)) {
            System.out.println("\033[31;1m !( size() > index ) ===>>modifyShort( String key, int index, BigDecimal replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        get(index).put(key, replaceValue);
    }

    /**
     * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
     *
     * @param key          String
     * @param index        int
     * @param replaceValue BigDecimal
     */
    public void modifyBigDecimal(String key, int index, BigDecimal replaceValue) {
        if (!(size() > index)) {
            System.out.println("\033[31;1m !( size() > index ) ===>>modifyBigDecimal( String key, int index, BigDecimal replaceValue ) \033[32;1;2m param: {" + key + ", " + index + ", " + replaceValue + "}! ");
        }
        get(index).put(key, replaceValue);
    }

    /**
     * Set the value of the object type in the corresponding key value.
     *
     * @param key   Object
     * @param value Object
     */
    public void add(String key, Object value) {
        boolean add = false;
        for (int i = 0; i < size(); i++) {
            if (!get(i).containsKey(key)) {
                get(i).put(key, value);
                add = true;
                break;
            }
        }
        if (!add) {
            MMap row = new MMap();
            //row.set( key, value );
            add(row);
        }
    }

    /**
     * Set the value of the object type in the corresponding key value.
     *
     * @param key   Object
     * @param value Object
     */
    public void add(String key, List<Object> value) {
        boolean add = false;
        for (int i = 0; i < size(); i++) {
            if (!get(i).containsKey(key)) {
                get(i).put(key, value);
                add = true;
                break;
            }
        }
        if (!add) {
            MMap row = new MMap();
            //row.set( key, value );
            add(row);
        }
    }

    private Object getObject(Object key, int index) {

        try {
            if (size() <= index) {
                return null;
            } else {
                return get(index).get(key);
            }
        } catch (IndexOutOfBoundsException ioe) {
            throw ioe;
        }
    }

    /**
     * Return the value corresponding to the key and index in the form of an object.
     * Returns a null or empty string (if value is null and isNullToInitialise() is true)
     * if the key or value does not exist.
     *
     * @param key   Object
     * @param index int
     * @return Object
     */
    public Object get(Object key, int index) {
        Object o = getObject(key, index);

        if (o == null && isNullToInitialize()) {
            return "";
        }

        return o;
    }

    /**
     * Return the value corresponding to the keyIndex and index to the object.
     * Return a null or empty string (if value is null and isNullToInitialise () is true)
     * if the key or value does not exist.
     *
     * @param keyIndex int
     * @param index    int
     * @return Object
     * @see #getKeyWithIndex(int)
     * @see #get(Object, int)
     */
    public Object get(int keyIndex, int index) {
        Object key = getKeyWithIndex(keyIndex, index);
        return get(key, index);
    }

    /**
     * Return the value corresponding to the key and index in String format.
     * Returns a null or empty string (if value is null and isNullToInitialise() is true)
     * if the key or value does not exist.
     *
     * @param key   String
     * @param index int
     * @return String
     */
    public String getString(Object key, int index) {
        Object o = getObject(key, index);

        if (o == null) {
            if (isNullToInitialize()) {
                return "";
            }
            return null;
        } else {
            // If the key type is BigDecimal, it is represented as 0E-8 when the decimal point is set at least 8 digits.
            if (o instanceof BigDecimal) {
                return ((BigDecimal) o).toPlainString();
            } else {
                return o.toString();
            }
        }
    }

    /**
     * Return the value corresponding to the keyIndex and index in String format.
     * Returns a null or empty string (if value is null and isNullToInitialise() is true)
     * if the key or value does not exist.
     *
     * @param keyIndex int
     * @param index    int
     * @return String
     * @see #getKeyWithIndex(int)
     * @see #getString(Object, int)
     */
    public String getString(int keyIndex, int index) {
        Object key = getKeyWithIndex(keyIndex, index);
        return getString(key, index);
    }

    /**
     * Return the value corresponding to the key and index in boolean form.
     * Returns LRuntimeException or 0 (if value is null and isNullToInitialise() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting will occur only if value is Boolean or String,
     * otherwise MRuntimeException will occur.
     *
     * @param key   Object
     * @param index int
     * @return boolean
     */
    public boolean getBoolean(Object key, int index) {
        Object o = getObject(key, index);

        if (o == null) {
            if (isNullToInitialize()) {
                return false;
            }
        } else {
            if (o instanceof Boolean) {
                return ((Boolean) o).booleanValue();
            }
            if (o instanceof String) {
                try {
                    return Boolean.valueOf(o.toString()).booleanValue();
                } catch (Exception e) {
                    System.out.println("\033[31;1m Exception ===>> getInt(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
                    throw e;
//
                }
            }
        }
        return false; // prevent compile error line. unreachable block.
    }

    /**
     * Return the value corresponding to the keyIndex and index in boolean form.
     * Returns LRuntimeException or 0 (if value is null and isNullToInitialise() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting occurs only if value is Boolean or String,
     * otherwise MRuntimeException will occur.
     *
     * @param keyIndex int
     * @param index    int
     * @return boolean
     * @see #getKeyWithIndex(int)
     * @see #getBoolean(Object, int)
     */
    public boolean getBoolean(int keyIndex, int index) {
        Object key = getKeyWithIndex(keyIndex, index);
        return getBoolean(key, index);
    }

    /**
     * Return the value corresponding to the key and index in int.
     * Returns MRuntimeException or 0 (if value is null and isNullToInitialise() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting will occur only if value is Number or String,
     * otherwise MRuntimeException will occur.
     *
     * @param key   Object
     * @param index int
     * @return int
     */
    public int getInt(Object key, int index) {
        Object o = getObject(key, index);

        if (o == null) {
            if (isNullToInitialize()) {
                return 0;
            }
        } else {
            if (o instanceof Number) {
                return ((Number) o).intValue();
            }
            if (o instanceof String) {
                try {
                    return Integer.parseInt(o.toString());
                } catch (Exception e) {
                    System.out.println("\033[31;1m Exception ===>> getInt(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
                    throw e;
                }
            }
        }
        return 0; // prevent compile error line. It's unreachable block.
    }

    /**
     * Return the value corresponding to the keyIndex and index in int form.
     * Returns LRuntimeException or 0 (if value is null and isNullToInitialise() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting will occur only if value is Number or String,
     * otherwise MRuntimeException will occur.
     *
     * @param keyIndex int
     * @param index    int
     * @return int
     * @see #getKeyWithIndex(int)
     * @see #getInt(Object, int)
     */
    public int getInt(int keyIndex, int index) {
        Object key = getKeyWithIndex(keyIndex, index);
        return getInt(key, index);
    }

    /**
     * Return the value corresponding to the key and index in double.
     * Returns MRuntimeException or 0.0D (if value is null and isNullToInitialise() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting occurs only if value is Number or String,
     * otherwise MRuntimeException will occur.
     *
     * @param key   Object
     * @param index int
     * @return double
     */
    public double getDouble(Object key, int index) {
        Object o = getObject(key, index);

        if (o == null) {
            if (isNullToInitialize()) {
                return 0.0D;
            }
        } else {
            if (o instanceof Number) {
                return ((Number) o).doubleValue();
            }
            if (o instanceof String) {
                try {
                    return Double.parseDouble(o.toString());
                } catch (Exception e) {
                    System.out.println("\033[31;1m Exception ===>> getDouble(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
                    throw e;
                }
            }
        }
        return 0.0D; // prevent compile error line. unreachable block.
    }

    /**
     * Return the value corresponding to the keyIndex and index in double.
     * Returns MRuntimeException or 0.0D (value is null and isNullToInitialise() is true.)
     * if the key or value does not exist <br>
     * If value exists, type-casting will occur only if value is Number or String,
     * otherwise MRuntimeException will occur.
     *
     * @param keyIndex int
     * @param index    int
     * @return double
     * @see #getKeyWithIndex(int)
     * @see #getDouble(Object, int)
     */
    public double getDouble(int keyIndex, int index) {
        Object key = getKeyWithIndex(keyIndex, index);
        return getDouble(key, index);
    }

    /**
     * Return the value corresponding to the key and index in float form.
     * Returns MRuntimeException or 0.0F (if value is null and isNullToInitialize() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting occurs only if value is Number or String,
     * otherwise MRuntimeException will occur.
     *
     * @param key   Object
     * @param index int
     * @return float
     */
    public float getFloat(Object key, int index) {
        Object o = getObject(key, index);

        if (o == null) {
            if (isNullToInitialize()) {
                return 0.0F;
            }
            System.out.println("\033[31;1m o == null ===>> getFloat(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
//            MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
//        		this.getClass(), "getFloat(Object key, int index)");
        } else {
            if (o instanceof Number) {
                return ((Number) o).floatValue();
            }
            if (o instanceof String) {
                try {
                    return Float.parseFloat(o.toString());
                } catch (Exception e) {
                    throw e;
//                    MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
//                		this.getClass(), "getFloat(Object key, int index)", e);
                }
            }
            System.out.println("\033[31;1m else ===>> getFloat(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
//            MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
//        		this.getClass(), "getFloat(Object key, int index)");
        }
        return 0.0F; // prevent compile error  line. unreachable block.
    }

    /**
     * Return the value corresponding to the keyIndex and index in float.
     * Return MRuntimeException or 0.0F (if value is null and isNullToInitialise() is true).
     * if no key or value exists<br>
     * If value exists, type-casting occurs only if value is Number or String,
     * otherwise LRuntimeException will occur.
     *
     * @param keyIndex int
     * @param index    int
     * @return float
     * @see #getKeyWithIndex(int)
     * @see #getFloat(Object, int)
     */
    public float getFloat(int keyIndex, int index) {
        Object key = getKeyWithIndex(keyIndex, index);
        return getFloat(key, index);
    }

    /**
     * Return the value corresponding to the key and index in long format.
     * Returns MRuntimeException or 0L (if value is null and isNullToInitialise() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting occurs only if value is Number or String,
     * otherwise MRuntimeException will occur.
     *
     * @param key   Object
     * @param index int
     * @return long
     */
    public long getLong(Object key, int index) {
        Object o = getObject(key, index);

        if (o == null) {
            if (isNullToInitialize()) {
                return 0L;
            }
            System.out.println("\033[31;1m o == null ===>> getLong(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
//            MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
//        		this.getClass(), "getLong(Object key, int index)");
        } else {
            if (o instanceof Number) {
                return ((Number) o).longValue();
            }
            if (o instanceof String) {
                try {
                    return Long.parseLong(o.toString());
                } catch (Exception e) {
                    System.out.println("\033[31;1m Exception ===>> getLong(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
                    throw e;
//                    MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
//                		this.getClass(), "getLong(Object key, int index)", e);
                }
            }
            System.out.println("\033[31;1m else ===>> getLong(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
//            MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
//        		this.getClass(), "getLong(Object key, int index)");
        }
        return 0L; // prevent compile error line. unreachable block.
    }

    /**
     * Return the value corresponding to the keyIndex and index in long format.
     * Returns MRuntimeException or 0L (if value is null and isNullToInitialise() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting occurs only if value is Number or String,
     * otherwise MRuntimeException will occur.
     *
     * @param keyIndex int
     * @param index    int
     * @return long
     * @see #getKeyWithIndex(int)
     * @see #getLong(Object, int)
     */
    public long getLong(int keyIndex, int index) {
        Object key = getKeyWithIndex(keyIndex, index);
        return getLong(key, index);
    }

    /**
     * Return the value corresponding to the key and index in a short form.
     * Returns MRuntimeException or 0 (if value is null and isNullToInitialise() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting will occur only briefly
     * if value is Number or String, otherwise MRuntimeException will occur.
     *
     * @param key   Object
     * @param index int
     * @return short
     */
    public short getShort(Object key, int index) {
        Object o = getObject(key, index);

        if (o == null) {
            if (isNullToInitialize()) {
                return 0;
            }
            System.out.println("\033[31;1m isNullToInitialize() ===>> getShort(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
//            MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
//        		this.getClass(), "getShort(Object key, int index)");
        } else {
            if (o instanceof Number) {
                return ((Number) o).shortValue();
            }

            if (o instanceof String) {
                try {
                    return Short.parseShort(o.toString());
                } catch (Exception e) {
                    System.out.println("\033[31;1m getShort(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
                    throw e;
//                    MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
//                		this.getClass(), "getShort(Object key, int index)", e);
                }
            }
//            MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
//        		this.getClass(), "getShort(Object key, int index)");
        }
        return 0; // prevent compile error line. unreachable block.
    }

    /**
     * Return the value corresponding to the keyIndex and index in a short format.
     * Returns MRuntimeException or 0 (if value is null and isNullToInitialise() is true)
     * if key or value does not exist.<br>
     * If value exists, type-casting will occur only if value is Number or String,
     * otherwise MRuntimeException will occur.
     *
     * @param keyIndex int
     * @param index    int
     * @return short
     * @see #getKeyWithIndex(int)
     * @see #getShort(Object, int)
     */
    public short getShort(int keyIndex, int index) {
        Object key = getKeyWithIndex(keyIndex, index);
        return getShort(key, index);
    }

    /**
     * Return the value corresponding to the key and index in the BegDecimal format.
     * If the key or value does not exist, then MRuntimeException or BigDecimal (0)
     * (if value is null and isNullToInitialize() is true).< br >
     * If value is present, type-casting will occur only if value is BigDecimal,
     * otherwise MRuntimeException will occur.
     *
     * @param key   Object
     * @param index int
     * @return BigDecimal
     */
    public BigDecimal getBigDecimal(Object key, int index) {
        Object o = getObject(key, index);

        if (o == null) {
            if (isNullToInitialize()) {
                return new BigDecimal(0);
            }
            return null;
        } else {
            if (o instanceof BigDecimal) {
                return (BigDecimal) o;
            }

            // NOTE
            if (o instanceof Number) {
                return new BigDecimal(((Number) o).doubleValue());
            }

            if (o instanceof String) {
                try {
                    return new BigDecimal((String) o);
                } catch (Exception e) {
                    System.out.println("\033[31;1m getBigDecimal(Object key, int index) \033[32;1;2m param: {" + key + ", " + index + "}! ");
                    throw e;
//                    MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
//                        this.getClass(), "getBigDecimal(Object key, int index)", e);
                }
            }
//            MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
//        		this.getClass(), "getBigDecimal(Object key, int index)");
        }
        return new BigDecimal(0); // prevent compile error line. unreachable block.
    }

    /**
     * Return the value corresponding to the keyIndex and index in BegDecimal format.
     * If the key or value does not exist, then MRuntimeException or BigDecimal(0)
     * (if value is null and isNullToInitialize () is true).< br >
     * If value is present, type-casting will occur only if value is BigDecimal,
     * otherwise MRuntimeException will occur.
     *
     * @param keyIndex int
     * @param index    int
     * @return BigDecimal
     * @see #getKeyWithIndex(int)
     * @see #getBigDecimal(Object, int)
     */
    public BigDecimal getBigDecimal(int keyIndex, int index) {
        Object key = getKeyWithIndex(keyIndex, index);
        return getBigDecimal(key, index);
    }

    public int getDataCount() {
        return this.size();

    }

    @SuppressWarnings({"unchecked"})
    public MMap getData(int key) {
        Object obj = get(key);
        if (obj instanceof MMap) {
            return (MMap) obj;
        } else if (obj instanceof LinkedHashMap) {
            return new MMap((LinkedHashMap<String, Object>) obj);
        } else {
            return obj == null ? new MMap() : (MMap) obj;
        }
    }

    public void addMultiMap(MultiMap Data) {
        int cnt = Data.size();
        for (int i = 0; i < cnt; i++) {
            this.add(new MMap(Data.get(i)));
        }
    }

    public void addMMultiDataNoClone(MultiMap multiMap) {
        int cnt = multiMap.size();
        for (int i = 0; i < cnt; i++) {
            this.add(multiMap.get(i));
        }
    }

    public void addDataNoClone(MMap data) {
        add(data);
    }

    /**
     * This method returns the number of keys that make up the MMultiData.
     *
     * @return int
     */
    public int getKeyCount() {
        int keyCount = 0;
        if (size() > 0) keyCount = get(0).keySet().size();
        return keyCount;
    }


    /**
     * Returns the size (total number of rows) corresponding
     * to the key present in the MMultiData.
     * If the key does not exist, it returns 0.
     *
     * @return int
     * @see #getDataCount()
     */
    public int getDataCount(Object key) {
        return this.size();
    }

    /**
     * Check if key exists
     *
     * @param key target key
     * @return true - exist
     * false - not exist
     */
    public boolean containsKey(Object key) {
        if (this.size() == 0) {
            return false;
        } else {
            return containsKey(0, key);
        }
    }

    /**
     * Check if key exists
     *
     * @param index index
     * @param key   target key
     * @return true - exist
     * false - not exist
     */
    public boolean containsKey(int index, Object key) {
        if (index >= this.size()) {
            return false;
        } else {
            return get(index).containsKey(key);
        }
    }
}
