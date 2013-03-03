package info.freelibrary.edtf;

import java.io.Serializable;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

public final class LocalTime implements Serializable,
		Comparable<ReadablePartial>, ReadablePartial, EDTFInstance {

	/**
	 * Generated <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 8935491627802793170L;

	private final org.joda.time.LocalTime myLocalTime;

	public LocalTime() {
		myLocalTime = new org.joda.time.LocalTime();
	}

	public LocalTime(org.joda.time.LocalTime aLocalTime) {
		myLocalTime = aLocalTime;
	}
	
	public LocalTime(Chronology aChronology) {
		myLocalTime = new org.joda.time.LocalTime(aChronology);
	}

	public LocalTime(DateTimeZone aDateTimeZone) {
		myLocalTime = new org.joda.time.LocalTime(aDateTimeZone);
	}

	public LocalTime(int aHourOfDay, int aMinuteOfHour) {
		myLocalTime = new org.joda.time.LocalTime(aHourOfDay, aMinuteOfHour);
	}

	public LocalTime(int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute) {
		myLocalTime = new org.joda.time.LocalTime(aHourOfDay, aMinuteOfHour,
				aSecondOfMinute);
	}

	public LocalTime(int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute,
			int aMillisOfSecond) {
		myLocalTime = new org.joda.time.LocalTime(aHourOfDay, aMinuteOfHour,
				aSecondOfMinute, aMillisOfSecond);
	}

	public LocalTime(int aHourOfDay, int aMinuteOfHour, int aSecondOfMinute,
			int aMillisOfSecond, Chronology aChronology) {
		myLocalTime = new org.joda.time.LocalTime(aHourOfDay, aMinuteOfHour,
				aSecondOfMinute, aMillisOfSecond, aChronology);
	}

	public LocalTime(long aInstant) {
		myLocalTime = new org.joda.time.LocalTime(aInstant);
	}

	public LocalTime(long aInstant, Chronology aChronology) {
		myLocalTime = new org.joda.time.LocalTime(aInstant, aChronology);
	}

	public LocalTime(long aInstant, DateTimeZone aZone) {
		myLocalTime = new org.joda.time.LocalTime(aInstant, aZone);
	}

	public LocalTime(Object aInstant) {
		myLocalTime = new org.joda.time.LocalTime(aInstant);
	}

	public LocalTime(Object aInstant, Chronology aChronology) {
		myLocalTime = new org.joda.time.LocalTime(aInstant, aChronology);
	}

	public LocalTime(Object aInstant, DateTimeZone aZone) {
		myLocalTime = new org.joda.time.LocalTime(aInstant, aZone);
	}

	@Override
	public int get(DateTimeFieldType aDateTimeFieldType) {
		return myLocalTime.get(aDateTimeFieldType);
	}

	@Override
	public Chronology getChronology() {
		return myLocalTime.getChronology();
	}

	@Override
	public DateTimeField getField(int aFieldInt) {
		return myLocalTime.getField(aFieldInt);
	}

	@Override
	public DateTimeFieldType getFieldType(int aFieldInt) {
		return myLocalTime.getFieldType(aFieldInt);
	}

	@Override
	public int getValue(int aFieldInt) {
		return myLocalTime.getValue(aFieldInt);
	}

	@Override
	public boolean isSupported(DateTimeFieldType aDateTimeFieldType) {
		return myLocalTime.isSupported(aDateTimeFieldType);
	}

	@Override
	public int size() {
		return myLocalTime.size();
	}

	@Override
	public DateTime toDateTime(ReadableInstant aReadableInstant) {
		return myLocalTime.toDateTime(aReadableInstant);
	}

	@Override
	public int compareTo(ReadablePartial aReadablePartial) {
		return myLocalTime.compareTo(aReadablePartial);
	}
	
	org.joda.time.LocalTime getLocalTime() {
		return myLocalTime;
	}
}
