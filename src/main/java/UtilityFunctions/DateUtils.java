package UtilityFunctions;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.Period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * DateUtilities
 */

public final class DateUtils {

	private static final int END_INDEX = 3;
	private static final int MULTIPLICATION_FACTOR_TO_CONVERT_MINUTE_TO_MILLISECONDS = 1000;
	private static final int SECONDS_IN_MINUTE = 60;
	private static final String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
			"Friday", "Saturday" };
	private static final String[] strMonths = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	private DateUtils() {
	}

	public static String getCurrentTimeString() {
		return getCurrentTimeString("dd-MM-yyyy HH:mm:ss");
	}

	public static Date getCurrentDate() {
		return parseDate(getCurrentTimeString(), "dd-MM-yyyy HH:mm");
	}

	public static String getCurrentYearString() {
		return getCurrentTimeString("yyyy");
	}

	public static String getCurrentTimeString(String pattern) {
		final Calendar cal = getCurrentTime();
		final SimpleDateFormat sdf = getSimpleDateFormat(pattern);
		return sdf.format(cal.getTime());
	}

	public static Date parseDate(String date, String pattern) {
		final SimpleDateFormat sdf = getSimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static int compareDatesString(String dateString, String anotherDateString,
			SimpleDateFormat simpleDateFormat) {
		final Date date;
		final Date anotherDate;
		try {
			date = simpleDateFormat.parse(dateString);
			anotherDate = simpleDateFormat.parse(anotherDateString);
		} catch (ParseException e) {
			throw new AssertionError("Incorrect date format" + e);
		}
		return date.compareTo(anotherDate);
	}

	public static int getTimeDiffInMinutes(String dateString, String anotherDateString,
			SimpleDateFormat simpleDateFormat) {
		final Date date;
		final Date anotherDate;
		final long timeDiffInMilliSeconds;
		final int timeDiffInMinutes;
		try {
			date = simpleDateFormat.parse(dateString);
			anotherDate = simpleDateFormat.parse(anotherDateString);
		} catch (ParseException e) {
			throw new AssertionError("Incorrect date format" + e);
		}
		timeDiffInMilliSeconds = anotherDate.getTime() - date.getTime();
		timeDiffInMinutes = (int) timeDiffInMilliSeconds
				/ (SECONDS_IN_MINUTE * MULTIPLICATION_FACTOR_TO_CONVERT_MINUTE_TO_MILLISECONDS) % SECONDS_IN_MINUTE;
		return timeDiffInMinutes;
	}

	private static SimpleDateFormat getSimpleDateFormat(String pattern) {
		return new SimpleDateFormat(pattern, Locale.ENGLISH);
	}

	public static Calendar getCurrentTime() {
		return Calendar.getInstance(Locale.ENGLISH);
	}

	public static String splitMonthNameToThreeSymbols(String date, int monthIndex) {
		String month = date.split("\\W")[monthIndex];
		String monthNameSplit = date.split("\\W")[monthIndex].substring(0, END_INDEX);
		return date.replace(month, monthNameSplit);
	}

	/**
	 * Creates time zone with DST setting equal to New York
	 *
	 * @param rawOffset - offset for time zone you want to create
	 * @return - modified TimeZone
	 */
	public static TimeZone createTimeZone(int rawOffset) {
		TimeZone defaultTimeZone = TimeZone.getTimeZone("America/New_York");

		TimeZone newCustomTimeZone = (TimeZone) defaultTimeZone.clone();
		// set id is required because otherwise DateTimeZone.forTimeZone will take
		// timezone by ID "America/New_York"
		// and we will lose offset
		newCustomTimeZone.setID("SeleniumTimeZone");
		newCustomTimeZone.setRawOffset(rawOffset);
		return newCustomTimeZone;
	}

	public static void waitForAssignmentDate(DateTimeZone dateTimeZone, DateTime date) {
		DateTime currentTime = new DateTime(dateTimeZone);
		DateTime dateWithTimeZone = date.withZoneRetainFields(dateTimeZone);
		if (dateWithTimeZone.getMillis() > currentTime.getMillis()) {
			CustomWaits.waitForSomeTime((int) (dateWithTimeZone.getMillis() - currentTime.getMillis()),
					"Wait for date");
		}
	}

	public static boolean isWinterTime() {
		DateTime currentDate = new DateTime();
		DateTime firstNovemberSunday = currentDate.withMonthOfYear(1).withDayOfYear(1).withMonthOfYear(11)
				.withDayOfWeek(7);
		DateTime secondMarchSunday = currentDate.withMonthOfYear(1).withDayOfYear(1).withMonthOfYear(3).withDayOfWeek(7)
				.plusWeeks(1);
		int currentMonth = currentDate.monthOfYear().get();
		return (currentMonth == 12 || currentMonth == 1 || currentMonth == 2)
				|| (currentMonth == 3 && currentDate.isBefore(secondMarchSunday))
				|| (currentMonth == 11 && currentDate.isAfter(firstNovemberSunday));
	}

	/*
	 * Get factical difference between time zones
	 * 
	 * @param secondDate - DateTime because it can hold time zone
	 */
	public static int getTimeZoneDifferenceInHours(Date firstDate, DateTime secondDateTime) {
		return (new Period(firstDate.getTime(), secondDateTime.toDate().getTime())).getHours();
	}

	public static String getDayOfWeek(String yyyymmdd) {
		// String should be in YYYY-MM-DD format
		LocalDate dt = LocalDate.parse(yyyymmdd);
		return strDays[dt.getDayOfWeek()];
	}

	public static String getMonthName(String yyyymmdd) {
		LocalDate dt = LocalDate.parse(yyyymmdd);
		return strMonths[dt.getMonthOfYear()-1];
	}
	
	public static int getDayOfYear(String yyyymmdd) {
		LocalDate dt = LocalDate.parse(yyyymmdd);
		return dt.getDayOfYear();
	}

	
	public static void main(String[] args) {
		String dt = "2019-09-06";
		System.out.println(getDayOfWeek(dt));
		System.out.println(getMonthName(dt));
		System.out.println(getDayOfYear(dt));
	}
}