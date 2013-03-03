package info.freelibrary.edtf;

import java.io.Serializable;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

public class LocalDateTime implements Serializable,
		Comparable<ReadablePartial>, ReadablePartial, EDTFInstance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1073711746687991285L;

	private final org.joda.time.LocalDateTime myLocalDateTime;

	public LocalDateTime() {
		myLocalDateTime = new org.joda.time.LocalDateTime();
	}

	public LocalDateTime(org.joda.time.LocalDateTime aLocalDateTime) {
		myLocalDateTime = aLocalDateTime;
	}
	
	public LocalDateTime(Chronology aChronology) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aChronology);
	}

	public LocalDateTime(DateTimeZone aDateTimeZone) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aDateTimeZone);
	}

	public LocalDateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour);
	}

	public LocalDateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aSecondOfMinute);
	}

	public LocalDateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute,
			int aMillisOfSecond) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aSecondOfMinute,
				aMillisOfSecond);
	}

	public LocalDateTime(int aYear, int aMonthOfYear, int aDayOfMonth,
			int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute,
			int aMillisOfSecond, Chronology aChronology) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aYear, aMonthOfYear,
				aDayOfMonth, aHourOfDay, aMinuteOfHour, aSecondOfMinute,
				aMillisOfSecond, aChronology);
	}

	public LocalDateTime(long aInstant) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aInstant);
	}

	public LocalDateTime(long aInstant, Chronology aChronology) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aInstant, aChronology);
	}

	public LocalDateTime(long aInstant, DateTimeZone aDateTimeZone) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aInstant,
				aDateTimeZone);
	}

	public LocalDateTime(Object aInstant) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aInstant);
	}

	public LocalDateTime(Object aInstant, Chronology aChronology) {
		myLocalDateTime = new org.joda.time.LocalDateTime(aInstant, aChronology);
	}

	@Override
	public int get(DateTimeFieldType aDateTimeFieldType) {
		return myLocalDateTime.get(aDateTimeFieldType);
	}

	@Override
	public Chronology getChronology() {
		return myLocalDateTime.getChronology();
	}

	@Override
	public DateTimeField getField(int aFieldInt) {
		return myLocalDateTime.getField(aFieldInt);
	}

	@Override
	public DateTimeFieldType getFieldType(int aFieldInt) {
		return myLocalDateTime.getFieldType(aFieldInt);
	}

	@Override
	public int getValue(int aFieldInt) {
		return myLocalDateTime.getValue(aFieldInt);
	}

	@Override
	public boolean isSupported(DateTimeFieldType aDateTimeFieldType) {
		return myLocalDateTime.isSupported(aDateTimeFieldType);
	}

	@Override
	public int size() {
		return myLocalDateTime.size();
	}

	@Override
	public DateTime toDateTime(ReadableInstant aReadableInstant) {
		return myLocalDateTime.toDateTime(aReadableInstant);
	}

	@Override
	public int compareTo(ReadablePartial aReadablePartial) {
		return myLocalDateTime.compareTo(aReadablePartial);
	}

}
