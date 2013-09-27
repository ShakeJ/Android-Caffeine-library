package caffeine.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.text.format.Time;

@SuppressLint("SimpleDateFormat")
public final class DateUtil
{
   public static final String YEAR = "yyyy";
   public static final String MONTH = "MM";
   public static final String DAY = "dd";
   public static final String FULL_TIME = "HH:mm:ss";
   public static final String YEAR_MONTH = YEAR + "-" + MONTH;
   public static final String FULL_DATE = YEAR_MONTH + "-" + DAY;
   public static final String FULL_DATE_TIME = FULL_DATE + " " + FULL_TIME;
   public static final String FULL_TIME_ZONE = FULL_DATE + "'T'" + FULL_TIME + "'Z'";
   
   
   /**
    * <br>
    * Convert date format
    * @param format
    * @param date
    * @return String
    */
   private static String format(String format, Date date)
   {
      SimpleDateFormat f = new SimpleDateFormat(format);
      return f.format(date);
   }
   
   
   /**
    * <br>
    * Convert date format
    * @param format
    * @param date
    * @return String
    */
   private static String format(String format)
   {
      return format(format, Calendar.getInstance().getTime());
   }
   
   
   /**
    * <br>
    * Current date in format
    * @param format
    * @return String
    */
   public static String date(String format)
   {
      return format(format);
   }
   
   
   /**
    * <br>
    * Current date
    * @return (String) yyyy-MM-dd HH:mm:ss
    */
   public static String now()
   {
      return format(FULL_DATE_TIME);
   }
   
   
   /**
    * <br>
    * Today date (Day)
    * @return (String) yyyy-MM-dd
    */
   public static String today()
   {
      return format(FULL_DATE);
   }
   
   
   /**
    * <br>
    * Current Time
    * @return HH:mm:ss
    */
   public static String time()
   {
      return format(FULL_TIME);
   }
   
   
   /**
    * <br>
    * This year
    * @return year
    */
   public static String year()
   {
      return format(YEAR);
   }
   
   
   /**
    * <br>
    * This month
    * @return month
    */
   public static String month()
   {
      return format(MONTH);
   }
   
   
   /**
    * <br>
    * Today
    * @return day
    */
   public static String day()
   {
      return format(DAY);
   }
   
   
   /**
    * <br>
    * In this month, yyyy-MM
    * @return yyyy-MM 2011-04
    */
   public static String ym()
   {
      return format(YEAR_MONTH);
   }
   
   
   /**
    * <br>
    * yyyy-mm-dd to date
    * @param format yyyy-mm-dd
    * @param date
    * @return '2013-01-23'
    */
   public static String fromDate(String format, Date date)
   {
      return format(format, date);
   }
   
   
   /**
    * <br>
    * yyyy-MM-dd HH:mm:ss to Date String
    * @param $fromFormat (yyyy-MM-dd HH:mm:ss)
    * @param $toFormat (yyyy-MM-dd)
    * @param $dateStr (yyyy-MM-dd HH:mm:ss)
    * @return
    */
   public static String fromString(String fromFormat, String toFormat, String dateStr)
   {
      try
      {
         Date date = new SimpleDateFormat(fromFormat).parse(dateStr);
         return format(toFormat, date);
      } catch (ParseException e)
      {
         return dateStr;
      }
   }
   
   
   /**
    * <br>
    * Long to date
    * @param format
    * @param dateLong
    * @return date String
    */
   public static String fromLong(String format, Long dateLong)
   {
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(dateLong);
      
      return format(format, calendar.getTime());
   }
   
   
   /**
    * <br>
    * From now to a few years ago or after few years
    * @param before or after year
    * @return yyyy-MM-dd
    */
   public static String addYear(int moveYear)
   {
      Calendar calendar = Calendar.getInstance();
      return addYear(format(FULL_DATE, calendar.getTime()), moveYear, FULL_DATE);
   }
   
   
   /**
    * <br>
    * From 'dateString' to a few years ago or after few years
    * @param dateStr
    * @param efore or after year
    * @return yyyy-MM
    */
   public static String addYear(String dateStr, int moveYear)
   {
      return addYear(dateStr, moveYear, YEAR_MONTH);
   }
   
   
   /**
    * <br>
    * From 'dateString' after few years
    * @param dateStr
    * @param add year
    * @param format (putForamt equal outputForamt)
    * @return format
    */
   public static String addYear(String dateStr, int addYear, String format)
   {
      return addYear(dateStr, addYear, format, format);
   }
   
   
   /**
    * <br>
    * From 'dateString' after few years
    * @param dateStr
    * @param add year
    * @param inFormat
    * @param outFormat
    * @return
    */
   public static String addYear(String dateStr, int addYear, String inFormat, String outFormat)
   {
      try
      {
         Date date = new SimpleDateFormat(inFormat).parse(dateStr);
         
         Calendar calendar = Calendar.getInstance();
         calendar.setTime(date);
         calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + addYear);
         return format(outFormat, calendar.getTime());
      } catch (ParseException e)
      {
         return dateStr;
      }
   }
   
   
   /**
    * <br>
    * From now to a few months ago or after few months
    * @param after or before month
    * @return yyyy-MM-dd
    */
   public static String addMonth(int moveMonth)
   {
      Calendar calendar = Calendar.getInstance();
      return addMonth(format(FULL_DATE, calendar.getTime()), moveMonth, FULL_DATE);
   }
   
   
   /**
    * <br>
    * From 'dateStr' to a few months ago or after few months
    * @param dateStr
    * @param move month
    * @return yyyy-MM
    */
   public static String addMonth(String dateStr, int moveMonth)
   {
      return addMonth(dateStr, moveMonth, YEAR_MONTH);
   }
   
   
   /**
    * <br>
    * From 'dateStr' after few months
    * @param dateStr
    * @param move month
    * @param format
    * @return format
    */
   public static String addMonth(String dateStr, int moveMonth, String format)
   {
      return addMonth(dateStr, moveMonth, format, format);
   }
   
   
   /**
    * <br>
    * From 'dateStr' after few months
    * @param dateStr
    * @param move month
    * @param inFormat
    * @param outFormat
    * @return
    */
   public static String addMonth(String dateStr, int moveMonth, String inFormat, String outFormat)
   {
      try
      {
         Date date = new SimpleDateFormat(inFormat).parse(dateStr);
         
         Calendar calendar = Calendar.getInstance();
         calendar.setTime(date);
         calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + moveMonth);
         return format(outFormat, calendar.getTime());
      } catch (ParseException e)
      {
         return dateStr;
      }
   }
   
   
   /**
    * <br>
    * From now to a few days ago or after few days
    * @param move
    * @return yyyy-MM-dd
    */
   public static String addDay(int $add)
   {
      Calendar calendar = Calendar.getInstance();
      return addDay(format(FULL_DATE, calendar.getTime()), $add, FULL_DATE);
   }
   
   
   /**
    * <br>
    * From now to a few days ago or after few days
    * @param $add
    * @param $format 넘어 온 format과 가져갈 format이 같아야 함
    * @return format
    */
   public static String addDay(int $add, String $format)
   {
      Calendar calendar = Calendar.getInstance();
      return addDay(format($format, calendar.getTime()), $add, $format);
   }
   
   
   /**
    * <br>
    * From 'dateStr' to a few days ago or after few days
    * @param dateStr
    * @param move days
    * @return yyyy-MM-dd
    */
   public static String addDay(String $dateStr, int moveDays)
   {
      return addDay($dateStr, moveDays, FULL_DATE);
   }
   
   
   /**
    * <br>
    * From 'dateStr' to a few days ago or after few days
    * @param $dateStr
    * @param move days
    * @param $format
    * @return $format
    */
   public static String addDay(String dateStr, int moveDays, String format)
   {
      return addDay(dateStr, moveDays, format, format);
   }
   
   
   /**
    * $dateStr로 부터 $add 일 후 <br>
    * @param $dateStr
    * @param $add
    * @param $inFormat 넘어 온 format
    * @param $outFormat 가져갈 format
    * @return
    */
   public static String addDay(String $dateStr, int $add, String $inFormat, String $outFormat)
   {
      try
      {
         Date date = new SimpleDateFormat($inFormat).parse($dateStr);
         
         Calendar calendar = Calendar.getInstance();
         calendar.setTime(date);
         calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + $add);
         return format($outFormat, calendar.getTime());
      } catch (ParseException e)
      {
         return $dateStr;
      }
   }
   
   
   /**
    * 해당 년월의 마지막 날짜를 가져온다 <br>
    * @param $year 년
    * @param $month 월
    * @return 마지막 날짜
    */
   public static int lastDay(int $year, int $month)
   {
      Calendar calendar = Calendar.getInstance();
      calendar.set(Calendar.YEAR, $year);
      calendar.set(Calendar.MONTH, $month);
      calendar.set(Calendar.DAY_OF_MONTH, 1);
      calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
      return Integer.parseInt(format(DAY, calendar.getTime()));
   }
   
   
   /**
    * 두 일시 중에 더 나중의 일시를 가져온다. <br>
    * @param $format 날짜 형식
    * @param $date1 비교할 일시1
    * @param $date2 비교할 일시2
    * @return
    */
   public static String compareLastDateTime(String $format, String $date1, String $date2)
   {
      Date dt1, dt2;
      String result = null;
      try
      {
         dt1 = new SimpleDateFormat($format).parse($date1);
         dt2 = new SimpleDateFormat($format).parse($date2);
         
         if (dt1.compareTo(dt2) > 0)
            result = format($format, dt1);
         else
            result = format($format, dt2);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return result;
   }
   
   
   /**
    * <br>
    * UTC + Locale Time<br />
    * <b>(only running device)</b>
    * @param format
    * @param date 2011-02-17T07:43:30Z
    * @return
    */
   public static String localTimeFromUTC(String format, String dateValue)
   {
      try
      {
         Date date = new SimpleDateFormat(FULL_TIME_ZONE).parse(dateValue);
         
         Time time = new Time();
         Long offset = time.normalize(time.isDst == 0); // -32400000밀리초
         
         Calendar calendar = Calendar.getInstance();
         calendar.setTime(date);
         calendar.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND) - Long.valueOf(offset).intValue());
         return format(format, calendar.getTime());
      } catch (ParseException e)
      {
         return dateValue;
      }
   }
   
   
   /**
    * <br>
    * Current UTC
    * @param format
    * @return
    */
   public static String nowUTC(String format)
   {
      return format(format, Calendar.getInstance(Locale.UK).getTime());
   }
   
   
   /**
    * <br>
    * Get the day of the date
    * @param year 2012
    * @param month 5
    * @param$day 21
    * @return 1:Sun ~ 7:Sat
    */
   public static int dayIndexOfWeek(int year, int month, int day)
   {
      Calendar calendar = Calendar.getInstance();
      calendar.set(year, month - 1, day);
      return calendar.get(Calendar.DAY_OF_WEEK);
   }
   
   
   /**
    * <br>
    * Certain days of the date the other day bringing attention
    * @param year
    * @param month
    * @param day
    * @param dayIndex 1:Sun ~ 7:Sat
    * @return
    */
   public static Date dayOfWeek(int year, int month, int day, int dayIndex)
   {
      Calendar calendar = Calendar.getInstance();
      calendar.set(year, month - 1, day + dayIndex - dayIndexOfWeek(year, month, day));
      return calendar.getTime();
   }
   
   
   /**
    * <br>
    * Get the day of the 'Sun' date
    * @param $year 연도
    * @param $month 월
    * @param $day 일
    * @return
    */
   public static Date sundayOfWeek(int year, int month, int day)
   {
      return dayOfWeek(year, month, day, Calendar.SUNDAY);
   }
   
   
   /**
    * 해당 날짜가 있는 주의 토요일 가져오기 <br>
    * Get the day of the 'Sat' date
    * @param year 연도
    * @param month 월
    * @param day 일
    * @return
    */
   public static Date saturdayOfWeek(int year, int month, int day)
   {
      return dayOfWeek(year, month, day, Calendar.SATURDAY);
   }
   
   
   /**
    * 해당 날짜와 오늘 날짜가 같은가 <br>
    * That date and today's date or equal
    * @param $year
    * @param $month
    * @param $day
    * @return
    */
   public static boolean isToday(int year, int month, int day)
   {
      Calendar calendar1 = Calendar.getInstance();
      calendar1.set(year, year - 1, day);
      
      Calendar calendar2 = Calendar.getInstance();
      
      return calendar1.compareTo(calendar2) == 0;
   }
   
   
   /**
    * 해당 월이 이번 달인가 <br>
    * Is the month same this month?
    * @param year
    * @param month
    * @return
    */
   public static boolean isThisMonth(int year, int month)
   {
      Calendar calendar1 = Calendar.getInstance();
      calendar1.set(year, month - 1, calendar1.get(Calendar.DAY_OF_MONTH));
      
      Calendar calendar2 = Calendar.getInstance();
      
      return calendar1.compareTo(calendar2) == 0;
   }
   
   
   /**
    * 해당 날짜가 토요일인가 <br>
    * Is the date saturday?
    * @param year
    * @param month
    * @param day
    * @return
    */
   public static boolean isSaturday(int year, int month, int day)
   {
      return dayIndexOfWeek(year, month, day) == Calendar.SATURDAY;
   }
   
   
   /**
    * 해당 날짜가 일요일인가 <br>
    * Is the date sunday?
    * @param year
    * @param month
    * @param day
    * @return
    */
   public static boolean isSunday(int year, int month, int day)
   {
      return dayIndexOfWeek(year, month, day) == Calendar.SUNDAY;
   }
}
