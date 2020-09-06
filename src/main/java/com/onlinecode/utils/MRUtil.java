package com.bizcode.utils;

import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MRUtil extends StringUtils {

    public final static String LINE_SEPERATOR = "\n";
    public final static String DOT_SEPERATOR = ".";
    public final static String NULL_CHARACTER_UPP_STRING = "NULL";
    public final static String NULL_CHARACTER_LOW_STRING = "null";
    public final static String TRUE_STRING = "true";
    public final static String FALSE_STRING = "false";
    public final static String ZERO = "0";

    /**
     * <pre>
     * 	Removes control characters (char <= 32) to starts of this String
     * </pre>
     *
     * @param s
     * @return
     */
    public static String ltrim(String s) {
        return s.replaceAll("^\\s+", EMPTY);
    }

    /**
     * <pre>
     * 	Removes control characters (char <= 32) from ends of this String
     * </pre>
     *
     * @param s
     * @return
     */
    public static String rtrim(String s) {
        return s.replaceAll("\\s+$", EMPTY);
    }

    /**
     * <pre>
     * 	Removes control characters (char <= 32) from both ends of this String, handling null by returning null.
     * </pre>
     *
     * @param s
     * @return
     */
    public static String trim(String s) {
        return StringUtils.trim(s);
    }

    /**
     * <pre>
     * 	Checks if the string is blank or null after removes control characters (char <= 32) from both ends of this String.
     * </pre>
     *
     * @param s
     * @return
     */
    public static boolean trimIsEmpty(String s) {
        return isEmpty(trimToEmpty(s));
    }

    /**
     * <pre>
     * 	Checks if the string contains only digits
     * </pre>
     *
     * @param digit
     * @return
     * @throws NumberFormatException
     */
    public static boolean isDigit(String digit) {
        try {
            BigDecimal n = new BigDecimal(digit);
            if (n.toString().length() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * <pre>
     * 	Checks if the string is blank or null
     * </pre>
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return StringUtils.isEmpty(s);
    }

    /**
     * <pre>
     * 	Left pad a String with a specified String.
     * </pre>
     *
     * @param str
     * @param size
     * @param padStr
     * @return
     */
    public static String leftPad(String str, int size, String padStr) {
        return StringUtils.leftPad(str, size, padStr);
    }

    /**
     * <pre>
     * 	Right pad a String with a specified String.
     * </pre>
     *
     * @param str
     * @param size
     * @param padStr
     * @return
     */
    public static String rightPad(String str, int size, String padStr) {
        return StringUtils.rightPad(str, size, padStr);
    }

    /**
     * <pre>
     * 	This String returning an empty String ("") if the String
     * is {@code null}
     * </pre>
     *
     * @param str
     * @return
     */
    public static String nullToEmpty(String str) {
        return str == null ? EMPTY : str;
    }

    /**
     * <pre>
     * 	This String returning the input value if the String
     * is {@code null}
     * </pre>
     *
     * @param str
     * @return
     */
    public static String nullToValue(String str, String value) {
        return str == null ? value : str;
    }

    /**
     * <pre>
     * 	Gets a substring from the specified String avoiding exceptions.
     * </pre>
     *
     * @param str
     * @return
     */
    public static String substring(String str, int start) {
        return StringUtils.substring(str, start);
    }

    /**
     * <pre>
     * 	Gets a substring from the specified String avoiding exceptions.
     * </pre>
     *
     * @param str
     * @return
     */
    public static String substring(String str, int start, int end) {
        return StringUtils.substring(str, start, end);
    }

    /**
     * <pre>
     * 	Converts a String to upper case as per String.toUpperCase().
     * </pre>
     *
     * @param str
     * @return
     */
    public static String upperCase(String str) {
        return StringUtils.upperCase(str);
    }

    /**
     * <pre>
     * 	Converts a String to lower case as per String.toLowerCase().
     * </pre>
     *
     * @param str
     * @return
     */
    public static String lowerCase(String str) {
        return StringUtils.lowerCase(str);
    }

    /**
     * <pre>
     * 	Encode the input value as Base64.
     * </pre>
     *
     * @param text
     * @return
     */
    public static String encodeBase64ByString(String text) {
        byte[] bytes = text.getBytes();
        String encodedBase64string = Base64.encodeBase64String(bytes);
        return encodedBase64string;
    }

    /**
     * <pre>
     * 	Decode the input value as Base64.
     * </pre>
     *
     * @param key
     * @return
     */
    public static String decodeBase64ToString(String key) {
        byte[] decodedBytes = Base64.decodeBase64(key);
        return new String(decodedBytes);
    }

    /**
     * <pre>
     * 	Fill the right with the character given in the string
     * </pre>
     *
     * @param str
     * @param chr
     * @param len
     * @return
     */
    public static String fillRight(String str, byte chr, int len) {
        if (str == null) {
            str = EMPTY;
        }
        byte[] ss;
        try {
            ss = str.getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            return str;
        }

        if (len <= ss.length) {
            return str;
        }

        byte[] chs = new byte[len];
        int j = 0;
        for (int inx = 0; inx < ss.length; inx++) {
            chs[j++] = ss[inx];
        }
        for (; j < len; j++) {
            chs[j] = chr;
        }
        try {
            return new String(chs, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * <pre>
     * 	string character (true, false) to boolean type cast
     * </pre>
     *
     * @param targetString
     * @throws
     * @logicalName
     * @return boolean
     * @fullPath
     */
    public static boolean stringToBoolean(String targetString) {
        boolean flag = false;
        if ((trim(lowerCase(targetString)).equalsIgnoreCase(TRUE_STRING)) || (trim(lowerCase(targetString)).equalsIgnoreCase(FALSE_STRING))) {
            if (trim(lowerCase(targetString)).equalsIgnoreCase(TRUE_STRING)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * <pre>
     * 	Crop string by length
     * </pre>
     *
     * @param str
     * @param idx
     * @param length
     * @return
     */
    public static String cropByte(String str, int idx, int length) {
        if (str == null) {
            return EMPTY;
        }

        String tmp = str;
        int slen = 0, blen = 0, islen = 0, iblen = 0;
        char c;

        if (tmp.getBytes().length < idx + length) {
            length = tmp.getBytes().length - idx;
        }

        while (blen < idx + length) {
            c = tmp.charAt(slen);

            if (iblen < idx) {
                iblen++;
                islen++;
                if (c > 0x007F) {
                    iblen++;
                }
            }

            blen++;
            slen++;

            if (c > 0x007F) {
                blen++;
            }
        }

        String ret = tmp.substring(islen, slen);

        if (ret.getBytes().length > length) {
            ret = alignLeftWithSpace(tmp.substring(islen, slen - 1), length, false);
        }
        return ret;
    }

    public static int getByteLength(String inputText) {
        return inputText.getBytes().length;
    }

    public static int getByteLength(String inputText, String characterSet) {
        try {
            return inputText.getBytes(characterSet).length;
        } catch (UnsupportedEncodingException e) {
            return inputText.getBytes().length;
        }
    }

    /**
     * <pre>
     *     number format
     * </pre>
     *
     * @param inputText  type String
     * @param startIndex type int
     * @param bytes      type int
     * @return String
     **/
    public static String getByteString(String inputText, int startIndex, int bytes) {
        return getByteString(inputText, startIndex, bytes, null);
    }

    /**
     * <pre>
     *     number format
     * </pre>
     *
     * @param inputText    type String
     * @param startIndex   type int
     * @param bytes        type int
     * @param characterSet type String
     * @return String
     **/
    public static String getByteString(String inputText, int startIndex, int bytes, String characterSet) {
        String result = EMPTY;
        try {
            result = new String(inputText.getBytes(characterSet), startIndex, bytes);
        } catch (UnsupportedEncodingException e) {
            result = new String(inputText.getBytes(), startIndex, bytes);
        }
        return result;
    }

    /**
     * <pre>
     *     number format
     * </pre>
     *
     * @param number type BigDecimal
     * @return String
     **/
    public static String numberFormat(BigDecimal number) {
        return numberFormat(number, "#,###.00");
    }

    /**
     * <pre>
     *     format number to String
     * </pre>
     *
     * @param number type BigDecimal
     * @param format type String
     * @return String
     **/
    public static String numberFormat(BigDecimal number, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(number);
    }

    /**
     * <pre>
     * 	Align left with space in the string
     * </pre>
     *
     * @param str        type String
     * @param width      type int
     * @param isPadSpace type boolean
     * @return String
     * @throws Exception
     * @logicalName
     * @fullPath
     */
    public static String alignLeftWithSpace(String str, int width, boolean isPadSpace) {
        int diff = 0;
        int strLength = 0;

        if (str == null) {
            strLength = 0;
            str = EMPTY;
        } else {
            strLength = str.getBytes().length;
        }

        if (strLength < width) {
            if (isPadSpace) {
                diff = width - strLength;
                char[] blanks = new char[diff];
                for (int inx = 0; inx < diff; inx++) {
                    blanks[inx] = ' ';
                }

                return str.concat(new String(blanks));
            } else {
                if (strLength == 0) {
                    return "";
                } else {
                    return str;
                }
            }
        } else if (strLength > width) {
            return new String(str.getBytes(), 0, width);
        } else {
            return str;
        }
    }

    /**
     * <pre>
     * 	Checks if the string is null
     * </pre>
     *
     * @param s type String
     * @return boolean
     */
    public static boolean isNull(String s) {
        return (s == null) ? true : false;
    }

    /**
     * <pre>
     * 	Checks if the object is null
     * </pre>
     *
     * @param obj type object
     * @return boolean
     */
    public static boolean isNull(Object obj) {
        return (obj == null) ? true : false;
    }

    /**
     * @param input type MMap
     */
    public static void NVL(MMap input) {
        NVL(input, SPACE);
    }

    /**
     * @param input      type MMap
     * @param defaultStr type String
     */
    public static void NVL(MMap input, String defaultStr) {
        if (input != null) {

            for (Object entryObject : input.entrySet()) {
                Map.Entry entry = (Map.Entry) entryObject;
                String key = (String) entry.getKey();
                Object o = entry.getValue();

                if (o != null && o instanceof String) {
                    if (isNone((String) o)) {
                        input.setString(key, defaultStr);
                    }
                }
            }
        }
    }

    public static boolean isNone(String value) {
        return value == null || value.length() == 0;
    }

    /**
     * @param str
     * @param pattern
     * @return long
     * @throws Exception
     */
    public static long indexOf(String str, String pattern) throws Exception {
        long result = 0;
        try {
            result = str.indexOf(pattern);
        } catch (Exception e) {
            if (str == null) {
                throw new Exception("indexOf(String str, String pattern) =====>>> str == null", e);
            }
            if (pattern == null) {
                throw new Exception("indexOf(String str, String pattern) ==== >> pattern == null", e);
            }
            throw new Exception("indexOf(String str, String pattern) ====>>> Exception", e);
        }
        return result;
    }

    /**
     * @param iString <p>
     * @return String
     * @throws Exception <p>
     *                   <DT>
     *                   <B>Examples:</B>
     *                   <DD>
     *                   <pre>
     *                   String oString = null;
     *                   oString = StringUTL.getLTRIM(&quot;	1234 &quot;);
     *                   </pre>
     */
    public static String getLTRIM(String iString) {

        if (iString == null) {
            return null;
        }

        String oString = EMPTY;

        for (int i = 0; i < iString.length(); i++) {
            if ((char) 0x20 < iString.charAt(i)) {
                oString = iString.substring(i);
                break;
            }
        }
        return oString;
    }

    /**
     * @param iString <p>
     * @return String
     * @throws Exception <p>
     *                   <DT>
     *                   <B>Examples:</B>
     *                   <DD>
     *
     *                   <pre>
     *                   String oString = null;
     *                   oString = StringUTL.getRTRIM(&quot;1224 &quot;);
     *                   </pre>
     */
    public static String getRTRIM(String iString) {

        if (iString == null) {
            return null;
        }

        String oString = EMPTY;

        for (int i = iString.length(); i > 0; i--) {
            if ((char) 0x20 < iString.charAt(i - 1)) {
                oString = iString.substring(0, i);
                break;
            }
        }
        return oString;
    }

    /**
     * <pre>
     *     string value
     * </pre>
     *
     * <br>
     * 1) LFStringUtil.compareStringArray("123", "1", "2", "3");<br>
     * 2) LFStringUtil.compareStringArray("123", "123");
     * <br>
     * [return]<br>
     * 1)false<br>
     * 2)true<br>
     *
     * @param arr
     * @param value
     * @return boolean
     * @throws Exception
     */
    public static boolean compareStringArray(String value, String... arr) throws Exception {
        boolean checking = false;

        try {
            if (arr != null) {

                for (int i = 0; i < arr.length; i++) {

                    if (arr[i].equals(value)) {
                        checking = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("compareStringArray(String value, String ...arr) <<<===>>>", e);
        }
        return checking;
    }

    /**
     * <pre>
     * string value
     * </pre>
     * <br>
     * String [] test = {"ab","cd","ef","ga","bb"};<br>
     * <br>
     * String b =  "ab";
     * boolean c = LFStringUtil.compareStringArray(test, b)<br>
     * <br>
     * [return]<br>
     * true<br>
     *
     * @param arr
     * @param value
     * @return boolean
     * @throws Exception
     */
    public static boolean compareStringArray(String[] arr, String value) throws Exception {
        boolean checking = false;

        try {
            if (arr != null) {

                for (int i = 0; i < arr.length; i++) {

                    if (arr[i].equals(value)) {
                        checking = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("compareStringArray(String[] arr , String value) === >> Exception", e);
        }

        return checking;
    }

    public static long byteLength(String s) throws Exception {
        long result = 0;
        if (s == null || "".equals(s)) {
            return 0;
        }
        try {
            result = (long) s.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e) {
            throw new Exception("byteLength(String s ) ====>>> UnsupportedEncodingException ", e);
        }
        return result;
    }

    /**
     * <pre>
     * String delim
     * </pre>
     *
     * @param s
     * @param delim
     * @return delim
     */
    public static String[] delimitedListToStringArray(String s, String delim) {
        if (s == null) return new String[0];

        if (delim == null) {
            return (new String[]{s});
        }

        List l = new LinkedList();
        int pos = 0;

        for (int delPos = 0; (delPos = s.indexOf(delim, pos)) != -1; ) {
            l.add(s.substring(pos, delPos));
            pos = delPos + delim.length();
        }

        if (pos <= s.length()) l.add(s.substring(pos));

        return (String[]) l.toArray(new String[l.size()]);
    }

    /**
     * <pre>
     * String
     * null
     * </pre>
     * <p>
     * String s = "&nbsp;&nbsp;&nbsp;";<br><br>
     * boolean b = MRStringUtil.trimNisEmpty(s);<br><br>
     * [return]<br>
     * true<br>
     *
     * @param s String
     * @return
     */
    public static boolean trimNisEmpty(String s) {

        String result = null;
        if (s != null) result = s.trim();
        return result == null ? true : false;
//        return MRNullUtil.isNone( result );
    }


    /**
     * <pre>
     *  Cut string by input length
     * </pre>
     *
     * @param str (String)
     * @param len (int)
     * @return String
     */
    public static String cutStringByByte(String str, int len) {
        if (str == null || str.length() == 0) {
            return EMPTY;
        }
        byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
        if (utf8.length < len) {
            len = utf8.length;
        }
        int n16 = 0;
        int advance = 1;
        int i = 0;
        while (i < len) {
            advance = 1;
            if ((utf8[i] & 0x80) == 0)
                i += 1;
            else if ((utf8[i] & 0xE0) == 0xC0)
                i += 2;
            else if ((utf8[i] & 0xF0) == 0xE0)
                i += 3;
            else {
                i += 4;
                advance = 2;
            }
            if (i <= len)
                n16 += advance;
        }
        return str.substring(0, n16);
    }

    /**
     * @param str    (String)
     * @param offset (int)
     * @param len    (int)
     * @return
     */
    public static String cutStringByByte(String str, int offset, int len) {
        if (str == null || str.length() == 0) {
            return EMPTY;
        }
        byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
        if (utf8.length < len) {
            len = utf8.length;
        }
        int n16 = 0;
        int advance = 1;
        int i = 0;
        while (i < len) {
            advance = 1;
            if ((utf8[i] & 0x80) == 0)
                i += 1;
            else if ((utf8[i] & 0xE0) == 0xC0)
                i += 2;
            else if ((utf8[i] & 0xF0) == 0xE0)
                i += 3;
            else {
                i += 4;
                advance = 2;
            }
            if (i <= len)
                n16 += advance;
        }
        return str.substring(offset, n16);
    }

    /**
     * <pre>
     * -- Convert String to multiple lines --
     * </pre>
     *
     * @param str    (String)
     * @param length (int)
     * @return
     * @throws
     * @serviceID
     * @logicalName
     * @fullPath
     */
    public static MultiMap convertToMultiLine(String str, int length) {

        MultiMap outputData = new MultiMap();

        if (str.length() <= length) {

            MMap line = new MMap();
            line.setString("line", str);
            outputData.addMMap(line);

        } else {

            String tobeString = str;

            do {

                String subString = subForOneLine(tobeString, length);

                MMap line = new MMap();
                line.setString("line", subString);
                outputData.addMMap(line);

                tobeString = tobeString.substring(subString.length() + 1);

                if (tobeString.length() <= length) {
                    MMap lastLine = new MMap();
                    lastLine.setString("line", tobeString);
                    outputData.addMMap(lastLine);
                }

            } while (tobeString.length() > length);
        }

        return outputData;
    }

    private static String subForOneLine(String str, int length) {

        if (str.length() > length) {

            str = str.substring(0, length);

            if (!str.substring(str.length() - 1).equals(" ")) {
                if (!str.substring(str.length()).equals(" ")) {
                    int lastIndexOfSpace = str.lastIndexOf(" ");
                    str = str.substring(0, lastIndexOfSpace);
                }
            } else {
                str = str.substring(0, length - 1);
            }
        }

        return str;
    }

    /**
     * Compiles the given regular expression and attempts to match the given
     * input against it.
     *
     * <p> If a pattern is to be used multiple times, compiling it once and reusing
     * it will be more efficient than invoking this method each time.  </p>
     *
     * @param cs    The character sequence to be matched
     * @param regex The expression to be compiled
     * @return whether or not the regular expression matches on the input
     */
    public static boolean matchesPattern(final CharSequence cs, String regex) {
        return Pattern.matches(regex, cs);
    }

    /**
     * Attempts to find the next subsequence of the input sequence that matches
     * the pattern.
     *
     * <p> This method starts at the beginning of this matcher's region, or, if
     * a previous invocation of the method was successful and the matcher has
     * not since been reset, at the first character not matched by the previous
     * match.
     *
     * <p> If the match succeeds then more information can be obtained via the
     * <tt>start</tt>, <tt>end</tt>, and <tt>group</tt> methods.  </p>
     *
     * @param cs    The character sequence to be matched
     * @param regex The expression to be compiled
     * @return <tt>true</tt> if, and only if, a subsequence of the input
     * sequence matches this matcher's pattern
     */
    public static boolean findPattern(final CharSequence cs, String regex) {
        return newMatcher(cs, regex).find();
    }

    /**
     * Creates a matcher that will match the given input against this pattern.
     *
     * @param cs    The character sequence to be matched
     * @param regex The expression to be compiled
     * @return A new matcher for this pattern
     */
    public static Matcher newMatcher(final CharSequence cs, String regex) {
        return Pattern.compile(regex).matcher(cs);
    }

}
