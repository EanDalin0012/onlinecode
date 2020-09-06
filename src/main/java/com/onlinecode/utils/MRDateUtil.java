package com.bizcode.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MRDateUtil<statc> {
    private static final Logger logger = LoggerFactory.getLogger(MRDateUtil.class);
    /**
     * year format : "yyyy"
     */
    public final static String FORMAT_YEAR = "yyyy";
    /**
     * month format : "MM"
     */
    public final static String FORMAT_MONTH = "MM";
    /**
     * day format : "dd"
     */
    public final static String FORMAT_DAY = "dd";
    /**
     * DATE format : "yyyyMMdd"
     */
    public final static String FORMAT_DATE = "yyyyMMdd";
    /**
     * DATETIME format : "yyyyMMddHHmmss"
     */
    public final static String FORMAT_DATETIME = "yyyyMMddHHmmss";
    /**
     * DATETIME format : "yyyyMMddHHmmssSSS"
     */
    public final static String FORMAT_FULL_DATETIME = "yyyyMMddHHmmssSSS";
    /**
     * TIME format : "HHmmss"
     */
    public final static String FORMAT_TIME = "HHmmss";
    /**
     * TIME format : "HH:mm:ss"
     */
    public final static String FORMAT_TIME_TYPE1 = "HH:mm:ss";
    /**
     * TIMESTAMP format : "HHmmssSSS"
     */
    public final static String FORMAT_TIMESTAMP = "HHmmssSSS";
    /**
     * hour format : "HH"
     */
    public final static String FORMAT_HOUR = "HH";
    /**
     * minute format : "mm"
     */
    public final static String FORMAT_MINUTE = "mm";
    /**
     * second format : "ss"
     */
    public final static String FORMAT_SECOND = "ss";
    /**
     * millisecond format : "SSS"
     */
    public final static String FORMAT_MILLISECOND = "SSS";

    /**
     * DATE format type 1 : "yyyy-MM-dd"
     */
    public final static String FORMAT_DATE_TYPE1 = "yyyy-MM-dd";

    /**
     * File logging format type 1 : "yyyyMMddaa"
     */
    public final static String FORMAT_FILE_LOG_TYPE1 = "yyyyMMddaa";

    /**
     * File logging format type 2 : "yyyyMMddHH"
     */
    public final static String FORMAT_FILE_LOG_TYPE2 = "yyyyMMddHH";

    /**
     * TIMESTAMP format : "yyyyMMddHHmm"
     */
    public final static String FORMAT_TIMESTAMP_TYPE1 = "yyyyMMddHHmm";

    /**
     * <pre>
     *  Get current system date
     * </pre>
     *
     * @return date Today's date
     */
    public static Date getDate() {

        return new Date();
    }


    /**
     * <pre>
     *  Get date from string type
     * </pre>
     *
     * @param date
     * @param format
     * @return
     * @throws Exception
     */
    public static Date toDate(String date, String format) throws Exception {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("en", "US"));
            return sdf.parse(date);
        } catch (ParseException e) {
            logger.info("toDate( String date, String format ) === >>> get error ParseException");
            throw new Exception("toDate( String date, String format ) ==== >>> ParseException ", e);
        }
    }


    /**
     * <pre>
     *  Get Date Object Convert from String using Default date format
     * </pre>
     *
     * @param yyyyMMdd {@link String}
     * @return date {@link Date}
     * @throws Exception
     */
    public static Date getDate(String yyyyMMdd) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
            return sdf.parse(yyyyMMdd);
        } catch (ParseException e) {
            logger.info("getDate( String yyyyMMdd ) === >>> get error ParseException");
            throw new Exception("getDate( String yyyyMMdd ) ==== >>> ParseException ", e);
        }
    }

    /**
     * <pre>
     *  Returns the year of the entered date
     * </pre>
     * Ex)
     * int year = MRDateUtil.getYear("20180701");
     * <p>
     * [return]
     * 2018
     *
     * @param date date
     * @return int year (yyyy)
     * @throws Exception
     */
    public static int getYear(String date) throws Exception {
        try {
            return Integer.parseInt(date.substring(0, 4));
        } catch (Exception e) {
            logger.info("getYear( String date ) === >>> get error ParseException");
            throw new Exception("getYear( String date ) ==== >>> ParseException ", e);
        }
    }

    /**
     * <pre>
     *  Returns the month of the entered date
     * </pre>
     * Ex)
     * int month = MRDateUtil.getMonth("20180701");
     * <p>
     * [return]
     * 7
     *
     * @param date date
     * @return int month (mm)
     * @throws Exception
     */
    public static int getMonth(String date) throws Exception {
        try {
            int month = Integer.parseInt(date.substring(4, 6));
            return month;
        } catch (Exception e) {
            logger.info("getMonth( String date ) === >>> get error ParseException");
            throw new Exception("getMonth( String date ) ==== >>> ParseException ", e);
        }
    }

    /**
     * <pre>
     *  Returns the day of the entered date
     * </pre>
     * <p>
     * Ex)
     * int day = MRDateUtil.getDay("20180701");
     * <p>
     * [return]
     * 1
     *
     * @param date date
     * @return int day (dd)
     * @throws Exception
     */
    public static int getDay(String date) throws Exception {
        try {
            return Integer.parseInt(date.substring(6, 8));
        } catch (Exception e) {
            logger.info("getDay( String date ) === >>> get error ParseException");
            throw new Exception("getDay( String date ) ==== >>> ParseException ", e);
        }
    }

    /**
     * <pre>
     *  Returns the hour of the entered time
     * </pre>
     * <p>
     * Ex)
     * int hour = MRDateUtil.getHour("2359");	//or "235959"
     * HHMM / HHMMSS TYPE
     * [return]
     * 23
     *
     * @param time time
     * @return int hour (hour)
     * @throws Exception
     */
    public static int getHour(String time) throws Exception {
        int rtnHour = -1;
        try {
            rtnHour = Integer.parseInt(time.substring(0, 2));
            return rtnHour;
        } catch (Exception e) {
            logger.info("getHour( String time ) === >>> get error ParseException");
            throw new Exception("getHour( String time ) ==== >>> ParseException ", e);
        }
    }

    /**
     * <pre>
     *  Returns the minute of the entered time
     * </pre>
     * <p>
     * Ex)
     * int hour = MRDateUtil.getMinute("2359");	//or "235959"
     * HHMM / HHMMSS TYPE
     * [return]
     * 59
     *
     * @param time time
     * @return int Minute (Minute)
     * @throws Exception
     */
    public static int getMinute(String time) throws Exception {
        int rtnMinute = -1;
        try {
            rtnMinute = Integer.parseInt(time.substring(2, 4));
            return rtnMinute;
        } catch (Exception e) {
            logger.info("getHour( String time ) === >>> get error Exception");
            throw new Exception("getMinute( String time ) ==== >>> Exception ", e);
        }
    }

    /**
     * <pre>
     *  Returns the second of the entered time
     * </pre>
     * <p>
     * Ex)
     * int hour = MRDateUtil.getMinute("235959");
     * HHMMSS TYPE
     * [return]
     * 59
     *
     * @param time time
     * @return int second (second)
     * @throws Exception
     */
    public static int getSecond(String time) throws Exception {
        int rtnSec = -1;
        try {
            if ((MRUtil.trim(time)).length() >= 6) {
                //hhmmss or hhmmss.sss
                rtnSec = Integer.parseInt(time.substring(4, 6));
            } else {
                rtnSec = 0;
            }
            return rtnSec;
        } catch (Exception e) {
            logger.info("getSecond( String time ) === >>> get error Exception");
            throw new Exception("getSecond( String time ) ==== >>> Exception ", e);
        }
    }

    /**
     * <pre>
     *  Compare the date entered and the middle of the month
     *  True if less than the middle of the month
     *  False if greater than the middle of the month
     * </pre>
     * Ex)
     * boolean retult = MRDateUtil.isFirstHalfMonth("20180714");
     * <p>
     * [return]
     * true
     *
     * @param date date
     * @return boolean retult
     * @throws Exception
     */
    public static boolean isFirstHalfMonth(String date) throws Exception {
        return getDay(date) < getMiddleDayMonth(date);
    }

    /**
     * <pre>
     *  Retrieves the previous date of the entered date.
     * </pre>
     * Ex)
     * String previousDay = MRDateUtil.getPreviousDay("20170614");
     * <p>
     * [return]
     * 20170613
     *
     * @param date date
     * @return String date
     * @throws Exception
     */
    public static String getPreviousDay(String date) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
            LocalDate localDate = LocalDate.parse(date, formatter);
            LocalDate yesterday = localDate.minusDays(1);
            return yesterday.format(formatter);
        } catch (Exception e) {
            logger.info("getPreviousDay( String date ) === >>> get error Exception");
            throw new Exception("getPreviousDay( String date ) ==== >>> Exception ", e);
        }
    }

    /**
     * <pre>
     *  Make sure that the date entered is the start of the month.
     *  True if start date
     *  False if it is not a start date
     * </pre>
     * Ex)
     * boolean retult = MRDateUtil.isFirstOfMonthFirstDay("20180714");
     * <p>
     * [return]
     * false
     *
     * @param date date
     * @return boolean retult
     * @throws Exception
     */
    public static boolean isFirstOfMonthFirstDay(String date) throws Exception {
        return getDay(date) == 1;
    }

    /**
     * <pre>
     *  Make sure the entry date is the middle of the month
     *  True if medium date
     *  False if it is not a medium date
     * </pre>
     * Ex)
     * boolean retult = MRDateUtil.isSecondHalfOfMonthFirstDay("20180615");
     * <p>
     * [return]
     * true
     *
     * @param date date
     * @return boolean retult
     * @throws Exception
     */
    public static boolean isSecondHalfOfMonthFirstDay(String date) throws Exception {
        return getDay(date) == getMiddleDayMonth(date);
    }

    /**
     * <pre>
     *  Returns the middle date of the date entered.
     * </pre>
     * Ex)
     * int day = MRDateUtil.getMiddleDayMonth("20170614");
     * <p>
     * [return]
     * 15
     *
     * @param date date
     * @return int day
     * @throws Exception
     */
    public static int getMiddleDayMonth(String date) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
            LocalDate localDate = LocalDate.parse(date, formatter);
            int daysInMonth = localDate.lengthOfMonth();
            int midDay = (int) Math.ceil(((double) daysInMonth) / 2);
            return midDay;
        } catch (Exception e) {
            logger.info("getMiddleDayMonth( String date ) === >>> Exception ");
            throw new Exception("getMiddleDayMonth( String date ) =====>>> Exception ", e);
        }
    }

    /**
     * <pre>
     *  Make sure that the date entered is greater than the start of month.
     *  True if it is greater than the first day of the month
     *  False if this is the first day of the month
     * </pre>
     * Ex)
     * boolean retult = MRDateUtil.isNotNewMonthFirstDay("20180601");
     * <p>
     * [return]
     * false
     *
     * @param date date
     * @return boolean retult
     * @throws Exception
     */
    public static boolean isNotNewMonthFirstDay(String date) throws Exception {
        return getDay(date) > 1;
    }

    /**
     * <pre>
     * Make sure that the date entered is the first day of the quarter.
     *  True if this is not the first date of the branch
     *  False if this is the first date of the branch
     * </pre>
     * Ex)
     * boolean retult = MRDateUtil.isNotNewQuaterFirstDay("20180601");
     * <p>
     * [return]
     * true
     *
     * @param date date
     * @return boolean retult
     * @throws Exception
     */
    public static boolean isNotNewQuaterFirstDay(String date) throws Exception {
        int month = getMonth(date), day = getDay(date);
        if (month == Calendar.JANUARY && day == 1 || month == Calendar.APRIL && day == 1
                || month == Calendar.JULY && day == 1 || month == Calendar.OCTOBER && day == 1) {
            return false;
        }
        return true;
    }

    /**
     * <pre>
     * Make sure that the date entered is the first day of the year
     *  True if this is not the first date of the year
     *  False if the first day of the year
     * </pre>
     * Ex)
     * boolean retult = MRDateUtil.isNotNewYearFirstDay("20180601");
     * <p>
     * [return]
     * true
     *
     * @param date date
     * @return boolean retult
     * @throws Exception
     */
    public static boolean isNotNewYearFirstDay(String date) throws Exception {
        int month = getMonth(date), day = getDay(date);
        return !(Calendar.JANUARY == month && day == 1);
    }

    /**
     * <pre>
     * Make sure that the date entered is the first day of the half year of the year
     *  True if this is not the first date of the half year of the year
     *  False if this is the first date of the half year of the year
     * </pre>
     * Ex)
     * boolean retult = MRDateUtil.isNotNewHalfYearFirstDay("20180701");
     * <p>
     * [return]
     * false
     *
     * @param date String
     * @return boolean retult
     * @throws Exception
     */
    public static boolean isNotNewHalfYearFirstDay(String date) throws Exception {
        int month = getMonth(date), day = getDay(date);

        if (month == Calendar.JANUARY && day == 1 || month == Calendar.JULY && day == 1) {
            return false;
        }
        return true;
    }

    /**
     * <pre>
     *  Get current system date using format
     * </pre>
     *
     * @return
     * @throws Exception
     */
    public static String getCurrentFormatDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("en", "US"));
        return sdf.format(Calendar.getInstance().getTime());
    }

    /**
     * <pre>
     *  Get current system date and time as string type (yyyyMMddHHmmss)
     * </pre>
     *
     * @return
     * @throws Exception
     */
    public static String getCurrentDateTime() {
        return getCurrentFormatDate(FORMAT_DATETIME);
    }

    /**
     * <pre>
     *  Get current system date and time as string type (yyyyMMddHHmmssSSS)
     * </pre>
     *
     * @return
     * @throws Exception
     */
    public static String getCurrentDateTimestamp() {
        return getCurrentFormatDate(FORMAT_FULL_DATETIME);
    }

    /**
     * <pre>
     *  Get current system time as string type (HHmmss)
     * </pre>
     *
     * @return
     * @throws Exception
     */
    public static String getCurrentTime() {
        return getCurrentFormatDate(FORMAT_TIME);
    }

    /**
     * <pre>
     *  Get current system date as string type (yyyyMMdd)
     * </pre>
     *
     * @return
     * @throws Exception
     */
    public static String getCurrentDate() {
        return getCurrentFormatDate(FORMAT_DATE);
    }

    /**
     * <pre>
     *  Get current system date as string type (HHmmssSSS)
     * </pre>
     *
     * @return
     * @throws Exception
     */
    public static String getCurrentTimestamp() {
        return getCurrentFormatDate(FORMAT_TIMESTAMP);
    }

    /**
     * <pre>
     *  Get current system date as format
     * </pre>
     *
     * @param format
     * @return
     * @throws Exception
     */
    public static String getCurrentDate(String format) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("en", "US"));
            return sdf.format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            logger.info("getCurrentDate( String format ) ===>>> Exception");
            throw new Exception("getCurrentDate( String format ) ===>>> Exception", e);
        }
    }

    /**
     * <pre>
     *  Change date from beforeFormat to afterFormat
     * </pre>
     *
     * @param date
     * @param beforeFormat
     * @param afterFormat
     * @return
     * @throws Exception
     */
    public static String changeDateFormat(String date, SimpleDateFormat beforeFormat, SimpleDateFormat afterFormat) throws Exception {
        Date tempDate;
        String changedDate = date;
        try {
            tempDate = beforeFormat.parse(date);
            changedDate = afterFormat.format(tempDate);
        } catch (ParseException e) {
            logger.info("changeDateFormat( String date, SimpleDateFormat beforeFormat, SimpleDateFormat afterFormat ) ===>> ParseException");
            throw new Exception("changeDateFormat( String date, SimpleDateFormat beforeFormat, SimpleDateFormat afterFormat ) ===>> ParseException", e);
        } catch (Exception e) {
            logger.info("changeDateFormat( String date, SimpleDateFormat beforeFormat, SimpleDateFormat afterFormat ) ===>> ParseException");
            throw new Exception("changeDateFormat( String date, SimpleDateFormat beforeFormat, SimpleDateFormat afterFormat ) ===>> ParseException", e);
        }
        return changedDate;
    }

    /**
     * <pre>
     *  Change date from beforeFormat to afterFormat
     * </pre>
     *
     * @param date
     * @param beforeFormatString
     * @param afterFormatString
     * @return
     * @throws Exception
     */
    public static String changeDateFormat(String date, String beforeFormatString, String afterFormatString) throws Exception {
        try {
            SimpleDateFormat beforeFormat = new SimpleDateFormat(beforeFormatString);
            SimpleDateFormat afterFormat = new SimpleDateFormat(afterFormatString, new Locale("en", "US"));
            return changeDateFormat(date, beforeFormat, afterFormat);

        } catch (Exception e) {
            logger.info("changeDateFormat( String date, SimpleDateFormat beforeFormat, SimpleDateFormat afterFormat ) ===>> ParseException");
            throw new Exception("changeDateFormat( String date, SimpleDateFormat beforeFormat, SimpleDateFormat afterFormat ) ===>> ParseException", e);

        }
    }

    /**
     * <pre>
     *  Compare the system date with the input date.
     * </pre>
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static boolean isToday(int year, int month, int day) {
        Calendar today = Calendar.getInstance();
        return (today.get(Calendar.YEAR) == year && today.get(Calendar.MONTH) + 1 == month
                && today.get(Calendar.DAY_OF_MONTH) == day);
    }

    /**
     * <pre>
     *  Compare the system date with the input date.
     * </pre>
     *
     * @param yyyyMMdd
     * @return
     * @throws Exception
     */
    public static boolean isToday(String yyyyMMdd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        try {
            Date date = sdf.parse(yyyyMMdd);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return isToday(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.DAY_OF_MONTH));
        } catch (ParseException e) {
            logger.info("isToday( String yyyyMMdd ) ===>> ParseException");
            throw new Exception("isToday( String yyyyMMdd ) ===>> ParseException", e);
        } catch (Exception e) {
            logger.info("isToday( String yyyyMMdd ) ===>> ParseException");
            throw new Exception("isToday( String yyyyMMdd ) ===>> ParseException", e);
        }
    }

    /**
     * <pre>
     *  Return the count of days of the month.
     * </pre>
     *
     * @param yyyyMMdd
     * @return
     * @throws Exception
     */
    public static int getCountDayOfMonth(String yyyyMMdd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        Date date;
        int lastDay = 0;
        try {
            date = sdf.parse(yyyyMMdd);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            logger.info("getCountDayOfMonth( String yyyyMMdd ) ===>> ParseException", e);
            throw new Exception("getCountDayOfMonth( String yyyyMMdd ) ===>> ParseException", e);
        } catch (Exception e) {
            logger.info("getCountDayOfMonth( String yyyyMMdd ) ===>> ParseException", e);
            throw new Exception("getCountDayOfMonth( String yyyyMMdd ) ===>> ParseException", e);
        }
        return lastDay;
    }

    /**
     * <pre>
     *  Return the count of days of the year.
     * </pre>
     *
     * @param yyyyMMdd
     * @return
     * @throws Exception
     */
    public static int getCountDayOfYear(String yyyyMMdd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        Date date;
        int countDays = 0;
        try {
            date = sdf.parse(yyyyMMdd);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            countDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
        } catch (ParseException e) {
            logger.info("getCountDayOfYear( String yyyyMMdd ) ===>> ParseException", e);
            throw new Exception("getCountDayOfYear( String yyyyMMdd )", e);
        } catch (Exception e) {
            logger.info("getCountDayOfYear( String yyyyMMdd ) ===>> ParseException", e);
            throw new Exception("getCountDayOfYear( String yyyyMMdd )", e);
        }
        return countDays;
    }

    /**
     * <pre>
     * Compare the two dates entered to get the number of days that are different.
     * </pre>
     *
     * @param fromDate
     * @param toDate
     * @param mode     (single : 1 , both : 2)
     * @param format
     * @return
     * @throws Exception
     */
    public static int getDiffBetweenDates(String fromDate, String toDate, int mode, String format) throws Exception {
        Long diffDays = 0L;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date beginDate = formatter.parse(fromDate);
            Date endDate = formatter.parse(toDate);

//			if ( beginDate.compareTo( endDate ) > 0 ) {
//				MExceptionPitcher.throwMaruException(MRExceptionCode.COM_UTL_004.getCode(),
//					MRDateUtil.class, "getDiffBetweenDates( String fromDate, String toDate, int mode, String format )");
//			}

            long diff = endDate.getTime() - beginDate.getTime();
            diffDays = diff / (24 * 60 * 60 * 1000);

            if (mode == 2) {
                diffDays++;
            }

        } catch (ParseException e) {
            logger.info("getDiffBetweenDates( String fromDate, String toDate, int mode, String format )", e);
            throw new Exception("getDiffBetweenDates( String fromDate, String toDate, int mode, String format )", e);
        } catch (Exception e) {
            logger.info("getDiffBetweenDates( String fromDate, String toDate, int mode, String format )", e);
            throw new Exception("getDiffBetweenDates( String fromDate, String toDate, int mode, String format )", e);
        }
        return diffDays.intValue();
    }

    /**
     * <pre>
     * Compare the two dates entered to get the number of days that are different.
     * </pre>
     *
     * @param fromDate
     * @param toDate
     * @param mode     (single : 1 , both : 2)
     * @return
     * @throws Exception
     */
    public static int getDiffBetweenDates(String fromDate, String toDate, int mode) throws Exception {
        return getDiffBetweenDates(fromDate, toDate, mode, FORMAT_DATE);
    }

    /**
     * <pre>
     * Compare the two dates entered to get the number of days that are different.
     * </pre>
     *
     * @param fromDate
     * @param toDate
     * @return
     * @throws Exception
     */
    public static int getDiffBetweenDates(String fromDate, String toDate) throws Exception {
        return getDiffBetweenDates(fromDate, toDate, 1, FORMAT_DATE);
    }

    /**
     * <pre>
     * Compare the two dates entered to get the number of days that are different.
     * </pre>
     *
     * @param fromDate
     * @param toDate
     * @param format
     * @return
     * @throws Exception
     */
    public static int getDiffBetweenDates(String fromDate, String toDate, String format) throws Exception {
        return getDiffBetweenDates(fromDate, toDate, 1, format);
    }

    /**
     * <pre>
     * Make sure you include today's date between the two dates you entered.
     * </pre>
     *
     * @param fromDate
     * @param toDate
     * @return
     * @throws Exception
     */
    public static boolean isBetweenWithinToday(String fromDate, String toDate) throws Exception {
        return isBetweenWithinToday(fromDate, toDate, FORMAT_DATE);
    }

    /**
     * <pre>
     * Make sure you include today's date between the two dates you entered.
     * </pre>
     *
     * @param fromDate
     * @param toDate
     * @param format
     * @return
     * @throws Exception
     */
    public static boolean isBetweenWithinToday(String fromDate, String toDate, String format) throws Exception {
        boolean result = false;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date beginDate = formatter.parse(fromDate);
            Date endDate = formatter.parse(toDate);

            Date todayDate = formatter.parse(getCurrentDate(format));

            return (todayDate.compareTo(beginDate) >= 0 && todayDate.compareTo(endDate) <= 0);

        } catch (ParseException e) {
            logger.info("isBetweenWithinToday( String fromDate, String toDate, String format )", e);
            throw new Exception("isBetweenWithinToday( String fromDate, String toDate, String format )", e);
        } catch (Exception e) {
            logger.info("isBetweenWithinToday( String fromDate, String toDate, String format )", e);
            throw new Exception("isBetweenWithinToday( String fromDate, String toDate, String format )", e);
        }
    }

    /**
     * <pre>
     * Make sure that the compared-date compared with the based-date is less then or equal.
     *
     * ex1) basedDate >= comparedDate : true
     * ex2) isLessThanEqualTo( "20180206", "20181231", "YYYYMMDD" )
     *     [return]
     *      false
     * </pre>
     *
     * @param basedDate
     * @param comparedDate
     * @param format
     * @return
     * @throws Exception
     */
    public static boolean isLessThanEqualTo(String basedDate, String comparedDate, String format) throws Exception {
        boolean result = false;
        try {
            int compare = compareTo(basedDate, comparedDate, format);
            result = (compare == 0 || compare == 1) ? true : false;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    /**
     * <pre>
     * Make sure that the compared-date compared with the based-date is less then or equal.
     *
     * ex1) basedDate >= comparedDate : true
     * ex2) isLessThanEqualTo( "20180206", "20181231" )
     *     [return]
     *      false
     * </pre>
     *
     * @param basedDate
     * @param comparedDate
     * @return
     * @throws Exception
     */
    public static boolean isLessThanEqualTo(String basedDate, String comparedDate) throws Exception {
        return isLessThanEqualTo(basedDate, comparedDate, FORMAT_DATE);
    }

    /**
     * <pre>
     * Make sure that the compared-date compared with the based-date is less then.
     *
     * ex1) basedDate > comparedDate : true
     * ex2) isLessThanTo( "20180206", "20181231", "YYYYMMDD" )
     *     [return]
     *      false
     * </pre>
     *
     * @param basedDate
     * @param comparedDate
     * @param format
     * @return
     * @throws Exception
     */
    public static boolean isLessThanTo(String basedDate, String comparedDate, String format) throws Exception {
        boolean result = false;
        try {
            int compare = compareTo(basedDate, comparedDate, format);
            result = (compare == 1) ? true : false;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    /**
     * <pre>
     * Make sure that the compared-date compared with the based-date is less then.
     *
     * ex1) basedDate > comparedDate : true
     * ex2) isLessThanTo( "20180206", "20181231" )
     *     [return]
     *      false
     * </pre>
     *
     * @param basedDate
     * @param comparedDate
     * @return
     * @throws Exception
     */
    public static boolean isLessThanTo(String basedDate, String comparedDate) throws Exception {
        return isLessThanTo(basedDate, comparedDate, FORMAT_DATE);
    }

    /**
     * <pre>
     * Make sure that the compared-date compared with the based-date is greater then or equal.
     *
     * ex1) basedDate <= comparedDate : true
     * ex2) isGreaterThanEqualTo( "20180206", "20181231", "YYYYMMDD" )
     *     [return]
     *      true
     * </pre>
     *
     * @param basedDate
     * @param comparedDate
     * @param format
     * @return
     * @throws Exception
     */
    public static boolean isGreaterThanEqualTo(String basedDate, String comparedDate, String format) throws Exception {

        boolean result = false;
        try {
            int compare = compareTo(basedDate, comparedDate, format);
            result = (compare == 0 || compare == -1) ? true : false;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    /**
     * <pre>
     * Make sure that the compared-date compared with the based-date is greater then or equal.
     *
     * ex1) basedDate <= comparedDate : true
     * ex2) isGreaterThanEqualTo( "20180206", "20181231" )
     *     [return]
     *      true
     * </pre>
     *
     * @param basedDate
     * @param comparedDate
     * @return
     * @throws Exception
     */
    public static boolean isGreaterThanEqualTo(String basedDate, String comparedDate) throws Exception {
        return isGreaterThanEqualTo(basedDate, comparedDate, FORMAT_DATE);
    }

    /**
     * <pre>
     * Make sure that the compared-date compared with the based-date is greater then.
     *
     * ex1) basedDate < comparedDate : true
     * ex2) isGreaterThanTo( "20180206", "20181231", "YYYYMMDD" )
     *     [return]
     *      true
     * </pre>
     *
     * @param basedDate
     * @param comparedDate
     * @param format
     * @return
     * @throws Exception
     */
    public static boolean isGreaterThanTo(String basedDate, String comparedDate, String format) throws Exception {
        boolean result = false;
        try {
            int compare = compareTo(basedDate, comparedDate, format);
            result = (compare == -1) ? true : false;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    /**
     * <pre>
     * Make sure that the compared-date compared with the based-date is greater then.
     *
     * ex1) basedDate < comparedDate : true
     * ex2) isGreaterThanTo( "20180206", "20181231" )
     *     [return]
     *      true
     * </pre>
     *
     * @param basedDate
     * @param comparedDate
     * @return
     * @throws Exception
     */
    public static boolean isGreaterThanTo(String basedDate, String comparedDate) throws Exception {
        return isGreaterThanTo(basedDate, comparedDate, FORMAT_DATE);
    }

    /**
     * <pre>
     * Make sure the end-date compared with the start-date.
     * </pre>
     *
     * @param startDate
     * @param endDate
     * @return less than : -1
     * eques : 0
     * greater than : 1
     * @throws Exception
     */
    public static int compareTo(String startDate, String endDate) throws Exception {
        return compareTo(startDate, endDate, FORMAT_DATE);
    }

    /**
     * <pre>
     * Make sure the end-date compared with the start-date.
     * </pre>
     *
     * @param startDate
     * @param endDate
     * @param format
     * @return less than : -1
     * eques : 0
     * greater than : 1
     * @throws Exception
     */
    public static int compareTo(String startDate, String endDate, String format) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date dtStart = formatter.parse(startDate);
            Date dtEnd = formatter.parse(endDate);
            return dtStart.compareTo(dtEnd);
        } catch (ParseException e) {
            logger.info("isLessThanEqualTo( String baseDate, String comparedDate, String format )", e);
            throw new Exception("isLessThanEqualTo( String baseDate, String comparedDate, String format )", e);

        } catch (Exception e) {
            logger.info("isLessThanEqualTo( String baseDate, String comparedDate, String format )", e);
            throw new Exception("isLessThanEqualTo( String baseDate, String comparedDate, String format )", e);

        }
        // return Integer.MIN_VALUE;
    }

    public static int compareTo(Date start, Date end) {
        return start.compareTo(end);
    }

    /**
     * <pre>
     * Returns the number of months in the two dates entered.
     * </pre>
     *
     * @param fromDate
     * @param toDate
     * @param mode     1 : single side , 2 : both side
     * @return
     * @throws Exception
     */
    public static long getDiffMonthBetweenDates(String fromDate, String toDate, int mode) throws Exception {
        long result = 0;

        try {

            fromDate = getDateStr(fromDate, FORMAT_DATE);
            toDate = getDateStr(toDate, FORMAT_DATE);

            Calendar beginDate = toCalendar(fromDate);
            Calendar closeDate = toCalendar(toDate);

            int compareDate = closeDate.compareTo(beginDate);

            if (compareDate < 0) {
                throw new Exception();
            } else {
                if (mode == 2) {
                    closeDate.add(Calendar.DATE, 1);
                }
            }

            long years = closeDate.get(Calendar.YEAR) - beginDate.get(Calendar.YEAR);
            long months = closeDate.get(Calendar.MONTH) - beginDate.get(Calendar.MONTH);

            result = (long) (years * 12 + months - 1);

            if ((beginDate.get(Calendar.DATE) < closeDate.get(Calendar.DATE)) || (beginDate.get(Calendar.DATE) == closeDate.get(Calendar.DATE)) || (closeDate.get(Calendar.DATE) == closeDate.getMaximum(Calendar.DAY_OF_MONTH)))
                result += 1;

        } catch (Exception e) {
            logger.info("getDiffMonthBetweenDates( String fromDate, String toDate, int mode, String format )", e);
            throw new Exception("getDiffMonthBetweenDates( String fromDate, String toDate, int mode, String format )", e);
        }
        return result;
    }

    /**
     * <pre>
     * Returns the number of months in the two dates entered.
     * </pre>
     *
     * @param fromDate
     * @param toDate
     * @param mode     1 : single side , 2 : both side
     * @return
     * @throws Exception
     */
    public static long getDiffMonthBetweenDates(String fromDate, String toDate, int mode, String format) throws Exception {
        long result = 0;

        try {

            fromDate = getDateStr(fromDate, format);
            toDate = getDateStr(toDate, format);

            Calendar beginDate = toCalendar(fromDate);
            Calendar closeDate = toCalendar(toDate);

            int compareDate = closeDate.compareTo(beginDate);

            if (compareDate < 0) {
                throw new Exception();
            } else {
                if (mode == 2) {
                    closeDate.add(Calendar.DATE, 1);
                }
            }

            long years = closeDate.get(Calendar.YEAR) - beginDate.get(Calendar.YEAR);
            long months = closeDate.get(Calendar.MONTH) - beginDate.get(Calendar.MONTH);

            result = (long) (years * 12 + months - 1);

            if ((beginDate.get(Calendar.DATE) < closeDate.get(Calendar.DATE)) || (beginDate.get(Calendar.DATE) == closeDate.get(Calendar.DATE)) || (closeDate.get(Calendar.DATE) == closeDate.getMaximum(Calendar.DAY_OF_MONTH)))
                result += 1;

        } catch (Exception e) {
            logger.info("getDiffMonthBetweenDates( String fromDate, String toDate, int mode )", e);
            throw new Exception("getDiffMonthBetweenDates( String fromDate, String toDate, int mode )", e);
        }

        return result;

    }

    /**
     * Transform date as long type to string format
     *
     * @param date
     * @param outputFormat
     */
    public static String getDateStr(long date, String outputFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(outputFormat, new Locale("en", "US"));
        return simpleDateFormat.format(new Date(date));
    }


    /**
     * Transform date as date type to string format
     *
     * @param date
     * @param outputFormat
     */
    public static String getDateStr(Date date, String outputFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(outputFormat, new Locale("en", "US"));
        return simpleDateFormat.format(date);
    }

    /**
     * Transform date as long type to string format
     *
     * @param date
     * @param inputFormat
     */
    public static String getDateStr(String date, String inputFormat) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inputFormat, new Locale("en", "US"));
        SimpleDateFormat baseDateFormat = new SimpleDateFormat(FORMAT_DATE);
        Date toDate = new Date();
        try {
            toDate = simpleDateFormat.parse(date);
        } catch (Exception e) {
            logger.info("getDateStr( String date, String inputFormat )", e);
            throw new Exception("getDateStr( String date, String inputFormat )", e);
        }
        return baseDateFormat.format(toDate);
    }

    /**
     * <pre>
     * Returns the date on which the entered base date is added or subtracted in hours, minutes, and seconds
     * </pre>
     * ex) String result = MRDateUtil.addTime( "20180315052700", 18, 33, 59 );
     * [return] 20180316000059
     *
     * @param sDate yyyymmddHHmmss format date
     * @param hour
     * @param min
     * @param sec
     * @return String (Result date)
     * @throws Exception
     */
    public static String addTime(String sDate, long hour, long min, long sec) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATETIME);
        Calendar cal = Calendar.getInstance();
        Date date = new Date();

        try {

            date = dateFormat.parse(sDate);

            if (!dateFormat.format(date).equals(sDate)) {
                throw new Exception();
            }

            cal.setTime(date);

            cal.add(Calendar.HOUR, (int) hour);
            cal.add(Calendar.MINUTE, (int) min);
            cal.add(Calendar.SECOND, (int) sec);

        } catch (Exception e) {

            if (sDate == null) {
                logger.info("addTime( String sDate, long hour , long min , long sec ) param: {" + sDate + ", " + hour + ", " + min + ", " + sec + "} \n=== >> Exception <<==== sDate == null ===>>>", e);
                throw new Exception("addTime( String sDate, long hour , long min , long sec ) param: {" + sDate + ", }", e);
            }
            if (e instanceof ParseException) {
                logger.info("addTime( String sDate, long hour , long min , long sec ) param: {" + sDate + ", " + hour + ", " + min + ", " + sec + "} \n=== >> Exception <<====  e instanceof ParseException ===>>>", e);
                throw new Exception("addTime( String sDate, long hour , long min , long sec ) param: {" + sDate + ", }", e);
            }
            if (!dateFormat.format(date).equals(sDate)) {
                logger.info("addTime( String sDate, long hour , long min , long sec ) param: {" + sDate + ", " + hour + ", " + min + ", " + sec + "} \n=== >> Exception <<====  !dateFormat.format( date ).equals( sDate )===>", e);
                throw new Exception("addTime( String sDate, long hour , long min , long sec ) param: {" + sDate + ", }", e);
            }
            logger.info("addTime( String sDate, long hour , long min , long sec ) param: {" + sDate + ", " + hour + ", " + min + ", " + sec + "} ", e);
            throw new Exception("addTime( String sDate, long hour , long min , long sec ) param: {" + sDate + ", }", e);
        }

        return dateFormat.format(cal.getTime());

    }

    /**
     * <pre>
     * Calculate and return the date elapsed in the entered date string
     * </pre>
     * <p>
     * ex) String result = MRDateUtil.addDay( "20180315", 5 );
     * [return]
     * 20180320
     *
     * @param sDate (Year Month Day)
     * @param day   (Elapsed days)
     * @return String (Year Month Day)
     * @throws Exception
     */
    public static String addDay(String sDate, long day) throws Exception {
        try {
            Calendar cal = toCalendar(sDate);
            cal.add(Calendar.DATE, (int) day);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
            return simpleDateFormat.format(cal.getTime());
        } catch (Exception e) {
            logger.info("addDay( String sDate, long day ) param: {" + sDate + ", " + day + "} ", e);
            throw new Exception("addDay( String sDate, long day )", e);
        }
    }

    /**
     * <pre>
     * Calculate and return the month elapsed in the entered date string
     * </pre>
     * <p>
     * ex) String result = MRDateUtil.addMonth( "20180315", 5 );
     * [return]
     * 20180815
     *
     * @param sDate (Year Month Day)
     * @param month (Elapsed months)
     * @return String (Year Month Day)
     * @throws Exception
     */
    public static String addMonth(String sDate, long month) throws Exception {
        try {
            Calendar cal = toCalendar(sDate);
            cal.add(Calendar.MONTH, (int) month);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
            return simpleDateFormat.format(cal.getTime());
        } catch (Exception e) {
            logger.info("addMonth( String sDate, long month ) param: {" + sDate + ", " + month + "} ", e);
            throw new Exception("addMonth( String sDate, long month )", e);
        }
    }

    /**
     * <pre>
     * Calculate and return the year elapsed in the entered date string
     * </pre>
     * <p>
     * ex) String result = MRDateUtil.addYear( "20180315", 5 );
     * [return]
     * 20230315
     *
     * @param sDate (Year Month Day)
     * @param year  (Elapsed years)
     * @return String (Year Month Day)
     * @throws Exception
     */
    public static String addYear(String sDate, long year) throws Exception {
        try {
            Calendar cal = toCalendar(sDate);
            cal.add(Calendar.YEAR, (int) year);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
            return simpleDateFormat.format(cal.getTime());
        } catch (Exception e) {
            logger.info("addYear( String sDate, long year ): {" + sDate + ", " + year + "} ", e);
            throw new Exception("addYear( String sDate, long year )", e);
        }
    }

    /**
     * Returns the input date as a Calendar object.
     *
     * @param pDate Date to return ( ex) 19980102 )
     * @return Calendar
     * Calendar for this date
     * @throws Exception
     */
    public static Calendar toCalendar(String pDate) throws Exception {
        try {
            Calendar calDate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
            Date inputDate = sdf.parse(pDate);
            calDate.setTime(inputDate);
            return calDate;
        } catch (ParseException e) {
            logger.info("addYear( String sDate, long year ): {" + pDate + "} ", e);
            throw new Exception("toCalendar( String pDate )", e);
        } catch (Exception e) {
            logger.info("addYear( String sDate, long year ): {" + pDate + "} ", e);
            throw new Exception("toCalendar( String pDate )", e);
        }
    }

    /**
     * Returns the input date as a Calendar object.
     *
     * @param pDate  Date to return ( ex) 19980102 )
     * @param format String Format
     * @return Calendar
     * Calendar for this date
     * @throws Exception
     */
    public static Calendar toCalendar(String pDate, String format) throws Exception {
        try {
            Calendar calDate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date inputDate = sdf.parse(pDate);
            calDate.setTime(inputDate);
            return calDate;
        } catch (ParseException e) {
            logger.info("toCalendar( String pDate, String format ): {" + pDate + " , " + format + "} ", e);
            throw new Exception("toCalendar( String pDate, String format )", e);
        } catch (Exception e) {
            logger.info("toCalendar( String pDate, String format ): {" + pDate + " , " + format + "} ", e);
            throw new Exception("toCalendar( String pDate, String format )", e);
        }
    }

    /**
     * Returns the input date as a Calendar object.
     *
     * @param pDate  Date to return ( ex) 19980102 )
     * @param pTime  Time to return ( ex) 130520 )
     * @param format String Format
     * @return Calendar
     * Calendar for this date
     * @throws Exception
     */
    public static Calendar toCalendar(String pDate, String pTime, String format) throws Exception {
        try {
            Calendar calDate = Calendar.getInstance();
            String date = pDate + pTime;
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date inputDate = sdf.parse(date);
            calDate.setTime(inputDate);
            return calDate;
        } catch (ParseException e) {
            logger.info("toCalendar( String pDate, String pTime, String format ): param{" + pDate + " , " + pTime + ", " + format + "} ", e);
            throw new Exception("toCalendar( String pDate, String pTime, String format )", e);
        } catch (Exception e) {
            logger.info("toCalendar( String pDate, String pTime, String format ): param{" + pDate + " , " + pTime + ", " + format + "} ", e);
            throw new Exception("toCalendar( String pDate, String pTime, String format )", e);
        }
    }

    /**
     * <pre>
     * Returns the first day of the specified date.
     * </pre>
     * Ex)
     * int firstDay = MRDateUtil.getFirstDayOfMonth(2018,7);
     * <p>
     * [return]
     * 1
     *
     * @param year  year
     * @param month month
     * @return int First date
     * @throws Exception
     */
    public static int getFirstDayOfMonth(int year, int month) throws Exception {
        Calendar calendar = Calendar.getInstance();
        try {

            calendar.set(year, month - 1, 1);
            return calendar.getActualMinimum(Calendar.DAY_OF_MONTH);

        } catch (Exception e) {
            logger.info("toCalendar( String pDate ): param{" + year + " , " + month + "} ", e);
            throw new Exception("toCalendar( String pDate )", e);
        }
    }

    /**
     * <pre>
     * Returns the first day of the specified date.
     * </pre>
     * Ex)
     * long firstDay = MRDateUtil.getFirstDayOfMonth(2018L,7L);
     * <p>
     * [return]
     * 1
     *
     * @param year  year
     * @param month month
     * @return long First date
     * @throws Exception
     */
    public static long getFirstDayOfMonth(long year, long month) throws Exception {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set((int) year, (int) month - 1, 1);
            return calendar.getActualMinimum(Calendar.DAY_OF_MONTH);

        } catch (Exception e) {
            logger.info("getFirstDayOfMonth( long year, long month ): param{" + year + " , " + month + "} ", e);
            throw new Exception("getFirstDayOfMonth( long year, long month )", e);
        }
    }

    /**
     * <pre>
     * Returns the first day of the specified date.
     * </pre>
     * Ex)
     * String firstDay = MRDateUtil.getFirstDayOfMonth("201807");
     * <p>
     * [return]
     * 1
     *
     * @param day yearMonth
     * @return String First date
     * @throws Exception
     */
    public static String getFirstDayOfMonth(String day) throws Exception {
        try {

            int year = Integer.parseInt(day.substring(0, 4));
            int month = Integer.parseInt(day.substring(4, 6));
            return Integer.toString(getFirstDayOfMonth(year, month));

        } catch (Exception e) {
            logger.info("getFirstDayOfMonth( String day ): param{" + day + " } ", e);
            throw new Exception("getFirstDayOfMonth( String day )", e);
        }
    }

    /**
     * <pre>
     * Returns N months and the first day of the specified date.
     * </pre>
     * Ex)
     * String plusFirstDay = MRDateUtil.getFirstDayOfMonth("20180715", 1);
     * String minuseFirstDay = MRDateUtil.getFirstDayOfMonth("20180715", -1);
     * <p>
     * [return]
     * 20180801
     * 20180601
     *
     * @param day   date
     * @param month Months
     * @return String N days before and after the first day
     * @throws Exception
     */
    public static String getFirstDayOfMonth(String day, long month) throws Exception {
        try {
            String sDate = day.substring(0, 6) + "01";
            return addMonth(sDate, month);
        } catch (Exception e) {
            logger.info("getFirstDayOfMonth( String day , long month): param{" + day + ", " + month + " } ", e);
            throw new Exception("getFirstDayOfMonth( String day , long month)", e);
        }
    }

    /**
     * <pre>
     * Return the first day of the month
     * </pre>
     * Ex)
     * String lastDate = MRDateUtil.getFirstDay("201807");
     * <p>
     * [return]
     * "20180701"
     *
     * @param date "YYYYMM" or "YYYYMMDD"
     * @return String first day "YYYYMMDD"
     * @throws Exception
     */
    public static String getFirstDay(String date) throws Exception {
        try {
            String sDate = date.substring(0, 6) + "01";

            if (isValidDate(sDate)) {
                return sDate;
            } else {
                logger.info("getFirstDayOfMonthDate( String yearMonth ): param{" + date + " } ");
                throw new Exception("getFirstDayOfMonthDate( String yearMonth )");
            }
        } catch (Exception e) {
            logger.info("getFirstDayOfMonthDate( String yearMonth ): param{" + date + " } ", e);
            throw new Exception("getFirstDayOfMonthDate( String yearMonth )", e);
        }
    }

    /**
     * <pre>
     * Return the last day of the day
     * </pre>
     * Ex)
     * String lastDate = MRDateUtil.getLastDay("20180715");
     * <p>
     * [return]
     * "20180731"
     *
     * @param date date
     * @return String last date
     * @throws Exception
     */
    public static String getLastDay(String date) throws Exception {
        try {
            String sDate = date.substring(0, 6);
            int lastDay = 0;
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
            Date dDate = formatter.parse(sDate + "01");
            cal.setTime(dDate);
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            return sDate + MRUtil.leftPad(String.valueOf(lastDay), 2, "0");
        } catch (Exception e) {
            logger.info("getLastDay( String date ): param{" + date + " } ", e);
            throw new Exception("getLastDay( String date )", e);
        }
    }

    /**
     * <pre>
     * Returns the last day of the specified date.
     * </pre>
     * Ex)
     * int lastDate = MRDateUtil.getLastDayOfMonth(2018, 7);
     * <p>
     * [return]
     * 31
     *
     * @param year, month (@int, @int)
     * @return int Last day
     * @throws Exception
     */
    public static int getLastDayOfMonth(int year, int month) throws Exception {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, 1);
            return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (Exception e) {
            logger.info("getLastDayOfMonth( int year, int month ): param{" + year + ", " + month + " } ", e);
            throw new Exception("getLastDayOfMonth( int year, int month )", e);
        }
    }

    /**
     * <pre>
     * Returns the last day of the specified date.
     * </pre>
     * Ex)
     * long lastDate = MRDateUtil.getLastDayOfMonth(2018L, 7L);
     * <p>
     * [return]
     * 31
     *
     * @param year, Month  (@long, @long)
     * @return long Last Day
     * @throws Exception
     */
    public static long getLastDayOfMonth(long year, long month) throws Exception {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set((int) year, (int) month - 1, 1);
            return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (Exception e) {
            logger.info("getLastDayOfMonth( int year, int month ): param{" + year + ", " + month + " } ", e);
            throw new Exception("getLastDayOfMonth( long year, long month )", e);
        }
    }

    /**
     * <pre>
     * Returns the last day of the specified date.
     * </pre>
     * Ex)
     * String lastDate = MRDateUtil.getLastDayOfMonth("201807");
     * <p>
     * [return]
     * "31"
     *
     * @param day String
     * @return String Last day
     * @throws Exception
     */
    public static String getLastDayOfMonth(String day) throws Exception {
        try {

            int year = Integer.parseInt(day.substring(0, 4));
            int month = Integer.parseInt(day.substring(4, 6));
            return Integer.toString(getLastDayOfMonth(year, month));

        } catch (Exception e) {
            logger.info("getLastDayOfMonth( String day ): param{" + day + " } ", e);
            throw new Exception("getLastDayOfMonth( String day )", e);
        }
    }

    /**
     * <pre>
     * Returns N months before and after the specified date.
     * </pre>
     * Ex)
     * String plusFirstDay = MRDateUtil.getLastDayOfMonth("20180715", 1);
     * String minuseFirstDay = MRDateUtil.getLastDayOfMonth("20180715", -1);
     * <p>
     * [return]
     * 20180831
     * 20180630
     *
     * @param day   date
     * @param month Months
     * @return String The last day of the month before and after N months
     * @throws Exception
     */
    public static String getLastDayOfMonth(String day, long month) throws Exception {
        try {
            String sDate = day.substring(0, 6) + "01";
            return getLastDay(addMonth(sDate, month));
        } catch (Exception e) {
            logger.info("getLastDayOfMonth( String day , long month): param{" + day + ", " + month + " } ", e);
            throw new Exception("getLastDayOfMonth( String day , long month)", e);
        }
    }

    /**
     * <pre>
     * Returns the date of the end of the previous year.
     * </pre>
     * Ex)
     * String lastDate = MRDateUtil.getLastDayOfYear();
     * <p>
     * [return]
     * 20171231
     *
     * @return String The end of last year
     * @throws Exception
     */
    public static String getLastDayOfYear() throws Exception {
        try {
            Calendar cal = Calendar.getInstance();

            int year = cal.get(Calendar.YEAR) - 1;
            cal.set(year, 11, 31);

            SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);

            return sdf.format(cal.getTime());
        } catch (Exception e) {
            logger.info("getLastDayOfYear(): param{''} ", e);
            throw new Exception("getLastDayOfYear()", e);
        }
    }

    /**
     * <pre>
     * Returns the date of the end of the previous year based on the base year.
     * </pre>
     * Ex)
     * String lastDate = MRDateUtil.getLastDayOfYear("20160514");
     * <p>
     * [return]
     * 20151231
     *
     * @param date @String
     * @return String Date of the previous year based on the reference year
     * @throws Exception
     */
    public static String getLastDayOfYear(String date) throws Exception {
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
            cal.setTime(formatter.parse(date));

            int year = cal.get(Calendar.YEAR) - 1;
            cal.set(year, 11, 31);

            SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            logger.info("getLastDayOfYear( String date ): param{" + date + "} ", e);
            throw new Exception("getLastDayOfYear( String date )", e);
        }
    }

    /**
     * <pre>
     * It fetches the first day of the quarter before and after the N branch.
     * </pre>
     * Ex)
     * String firstDay = MRDateUtil.getStartDayOfQuater("20170615", 3);
     * <p>
     * [return]
     * 20180101
     *
     * @param date   date
     * @param quater N before and after the quarter (in the case of the previous quarter -, in case of the latter quarter + use)
     * @return String start date of the quarter before and after the N-th quarter
     * @throws Exception
     */
    public static String getStartDayOfQuater(String date, long quater) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);

        try {
            String calcDate = addMonth(date, quater * 3);
            Date sDate = new SimpleDateFormat(FORMAT_DATE).parse(calcDate);
            long yearQuater = sDate.getMonth() / 3 + 1;
            sDate.setMonth((int) (yearQuater * 3 - 3));
            sDate.setDate(1);
            return sdf.format(sDate);
        } catch (Exception e) {
            logger.info("getStartDayOfQuater(String date, long quater): param{" + date + ", " + quater + "} ", e);
            throw new Exception("getStartDayOfQuater(String date, long quater)", e);
        }
    }

    /**
     * <pre>
     * It fetches the last day of the quarter before and after the N branch.
     * </pre>
     * Ex)
     * String firstDay = MRDateUtil.getEndDayOfQuater("20170615", 3);
     * <p>
     * [return]
     * 20180131
     *
     * @param date   date
     * @param quater N before and after the quarter (in the case of the previous quarter -, in case of the latter quarter + use)
     * @return String End date of the quarter before and after the N-th quarter
     * @throws Exception
     */
    public static String getEndDayOfQuater(String date, long quater) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        Calendar cal = Calendar.getInstance();

        try {
            String calcDate = addMonth(date, quater * 3);
            Date sDate = new SimpleDateFormat(FORMAT_DATE).parse(calcDate);
            long yearQuater = sDate.getMonth() / 3 + 1;
            cal.setTime(sDate);
            int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            sDate.setMonth((int) (yearQuater * 3 - 1));
            sDate.setDate(lastDay);
            return sdf.format(sDate);
        } catch (Exception e) {
            logger.info("getEndDayOfQuater(String date, long quater): param{" + date + ", " + quater + "} ", e);
            throw new Exception("getEndDayOfQuater(String date, long quater)", e);
        }
    }

    /**
     * <pre>
     * Verify that the data you entered is correct for the date format
     * </pre>
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static boolean isValidDate(String date) {
        return isValidDate(date, FORMAT_DATE);
    }

    /**
     * <pre>
     * Verify that the data you entered is correct for the date format
     * </pre>
     *
     * @param date
     * @param format
     * @return
     * @throws Exception
     */
    public static boolean isValidDate(String date, String format) {
        boolean result = false;

        SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("en", "US"));
        try {
            Date dDate = sdf.parse(date);
            String getDate = sdf.format(dDate);
            if (date.equals(getDate)) {
                result = true;
            }
        } catch (Exception e) {
        }
        return result;
    }
}
