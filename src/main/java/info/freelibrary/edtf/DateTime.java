package info.freelibrary.edtf;

import java.io.Serializable;
import java.util.Locale;

import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInstant;

public class DateTime implements Serializable, ReadableInstant,
		ReadableDateTime, Comparable<ReadableInstant>, EDTFInstance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8154149204344109569L;

	private final org.joda.time.DateTime myDateTime;

	public DateTime() {
		myDateTime = new org.joda.time.DateTime();
	}

	public DateTime(org.joda.time.DateTime aJodaDateTime) {
		myDateTime = aJodaDateTime;
	}
	
	public DateTime(Chronology aChronology) {
		myDateTime = new org.joda.time.DateTime(aChronology);
	}

	public DateTime(DateTimeZone aDateTimeZone) {
		myDateTime = new org.joda.time.DateTime(aDateTimeZone);
	}

	public DateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour) {
		myDateTime = new org.joda.time.DateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour);
	}

	public DateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, Chronology aChronology) {
		myDateTime = new org.joda.time.DateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aChronology);
	}

	public DateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute) {
		myDateTime = new org.joda.time.DateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aSecondOfMinute);
	}

	public DateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute,
			Chronology aChronology) {
		myDateTime = new org.joda.time.DateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aSecondOfMinute,
				aChronology);
	}

	public DateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute,
			DateTimeZone aDateTimeZone) {
		myDateTime = new org.joda.time.DateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aSecondOfMinute,
				aDateTimeZone);
	}

	public DateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute,
			int aMillisOfSecond) {
		myDateTime = new org.joda.time.DateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aSecondOfMinute,
				aMillisOfSecond);
	}

	public DateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute,
			int aMillisOfSecond, Chronology aChronology) {
		myDateTime = new org.joda.time.DateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aSecondOfMinute,
				aMillisOfSecond, aChronology);
	}

	public DateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute,
			int aMillisOfSecond, DateTimeZone aDateTimeZone) {
		myDateTime = new org.joda.time.DateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aSecondOfMinute,
				aMillisOfSecond, aDateTimeZone);
	}

	public DateTime(long aInstant) {
		myDateTime = new org.joda.time.DateTime(aInstant);
	}

	public DateTime(long aInstant, Chronology aChronology) {
		myDateTime = new org.joda.time.DateTime(aInstant, aChronology);
	}

	public DateTime(Object aInstant) {
		myDateTime = new org.joda.time.DateTime(aInstant);
	}

	public DateTime(Object aInstant, Chronology aChronology) {
		myDateTime = new org.joda.time.DateTime(aInstant, aChronology);
	}

	public DateTime(Object aInstant, DateTimeZone aDateTimeZone) {
		myDateTime = new org.joda.time.DateTime(aInstant, aDateTimeZone);
	}

	@Override
	public int compareTo(ReadableInstant aReadableInstant) {
		return myDateTime.compareTo(aReadableInstant);
	}

	@Override
	public int getCenturyOfEra() {
		return myDateTime.getCenturyOfEra();
	}

	@Override
	public int getDayOfMonth() {
		return myDateTime.getDayOfMonth();
	}

	@Override
	public int getDayOfWeek() {
		return myDateTime.getDayOfWeek();
	}

	@Override
	public int getDayOfYear() {
		return myDateTime.getDayOfYear();
	}

	@Override
	public int getEra() {
		return myDateTime.getEra();
	}

	@Override
	public int getHourOfDay() {
		return myDateTime.getHourOfDay();
	}

	@Override
	public int getMillisOfDay() {
		return myDateTime.getMillisOfDay();
	}

	@Override
	public int getMillisOfSecond() {
		return myDateTime.getMillisOfSecond();
	}

	@Override
	public int getMinuteOfDay() {
		return myDateTime.getMinuteOfDay();
	}

	@Override
	public int getMinuteOfHour() {
		return myDateTime.getMinuteOfHour();
	}

	@Override
	public int getMonthOfYear() {
		return myDateTime.getMonthOfYear();
	}

	@Override
	public int getSecondOfDay() {
		return myDateTime.getSecondOfDay();
	}

	@Override
	public int getSecondOfMinute() {
		return myDateTime.getSecondOfMinute();
	}

	@Override
	public int getWeekOfWeekyear() {
		return myDateTime.getWeekOfWeekyear();
	}

	@Override
	public int getWeekyear() {
		return myDateTime.getWeekyear();
	}

	@Override
	public int getYear() {
		return myDateTime.getYear();
	}

	@Override
	public int getYearOfCentury() {
		return myDateTime.getYearOfCentury();
	}

	@Override
	public int getYearOfEra() {
		return myDateTime.getYearOfEra();
	}

	@Override
	public org.joda.time.DateTime toDateTime() {
		return myDateTime.toDateTime();
	}

	@Override
	public MutableDateTime toMutableDateTime() {
		return myDateTime.toMutableDateTime();
	}

	@Override
	public String toString(String aString) throws IllegalArgumentException {
		return myDateTime.toString(aString);
	}

	@Override
	public String toString(String aString, Locale aLocale)
			throws IllegalArgumentException {
		return myDateTime.toString(aString, aLocale);
	}

	@Override
	public int get(DateTimeFieldType aDateTimeField) {
		return myDateTime.get(aDateTimeField);
	}

	@Override
	public Chronology getChronology() {
		return myDateTime.getChronology();
	}

	@Override
	public long getMillis() {
		return myDateTime.getMillis();
	}

	@Override
	public DateTimeZone getZone() {
		return myDateTime.getZone();
	}

	@Override
	public boolean isAfter(ReadableInstant aReadableInstant) {
		return myDateTime.isAfter(aReadableInstant);
	}

	@Override
	public boolean isBefore(ReadableInstant aReadableInstant) {
		return myDateTime.isBefore(aReadableInstant);
	}

	@Override
	public boolean isEqual(ReadableInstant aReadableInstant) {
		return myDateTime.isEqual(aReadableInstant);
	}

	@Override
	public boolean isSupported(DateTimeFieldType aDateTimeField) {
		return myDateTime.isSupported(aDateTimeField);
	}

	@Override
	public Instant toInstant() {
		return myDateTime.toInstant();
	}
}
