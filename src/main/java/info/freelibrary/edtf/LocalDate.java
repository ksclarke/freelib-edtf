package info.freelibrary.edtf;

import java.io.Serializable;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

public final class LocalDate implements Serializable, ReadablePartial,
		Comparable<ReadablePartial>, EDTF {

	/**
	 * Generated <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -4270736028882834273L;

	private final org.joda.time.LocalDate myLocalDate;

	public LocalDate() {
		myLocalDate = new org.joda.time.LocalDate();
	}

	public LocalDate(Chronology aChronology) {
		myLocalDate = new org.joda.time.LocalDate(aChronology);
	}

	public LocalDate(DateTimeZone aDateTimeZone) {
		myLocalDate = new org.joda.time.LocalDate(aDateTimeZone);
	}

	public LocalDate(int aYear, int aMonthOfYear, int aDayOfMonth) {
		myLocalDate = new org.joda.time.LocalDate(aYear, aMonthOfYear,
				aDayOfMonth);
	}

	public LocalDate(int aYear, int aMonthOfYear, int aDayOfMonth,
			Chronology aChronology) {
		myLocalDate = new org.joda.time.LocalDate(aYear, aMonthOfYear,
				aDayOfMonth, aChronology);
	}

	public LocalDate(long aInstant) {
		myLocalDate = new org.joda.time.LocalDate(aInstant);
	}

	public LocalDate(long aInstant, Chronology aChronology) {
		myLocalDate = new org.joda.time.LocalDate(aInstant, aChronology);
	}

	public LocalDate(long aInstant, DateTimeZone aZone) {
		myLocalDate = new org.joda.time.LocalDate(aInstant, aZone);
	}

	public LocalDate(Object aInstant) {
		myLocalDate = new org.joda.time.LocalDate(aInstant);
	}

	public LocalDate(Object aInstant, Chronology aChronology) {
		myLocalDate = new org.joda.time.LocalDate(aInstant, aChronology);
	}

	public LocalDate(Object aInstant, DateTimeZone aZone) {
		myLocalDate = new org.joda.time.LocalDate(aInstant, aZone);
	}

	@Override
	public int compareTo(ReadablePartial aReadablePartial) {
		return myLocalDate.compareTo(aReadablePartial);
	}

	@Override
	public int get(DateTimeFieldType aDateTimeFieldType) {
		return myLocalDate.get(aDateTimeFieldType);
	}

	@Override
	public Chronology getChronology() {
		return myLocalDate.getChronology();
	}

	@Override
	public DateTimeField getField(int aFieldInt) {
		return myLocalDate.getField(aFieldInt);
	}

	@Override
	public DateTimeFieldType getFieldType(int aFieldInt) {
		return myLocalDate.getFieldType(aFieldInt);
	}

	@Override
	public int getValue(int aFieldInt) {
		return myLocalDate.getValue(aFieldInt);
	}

	@Override
	public boolean isSupported(DateTimeFieldType aDateTimeFieldType) {
		return myLocalDate.isSupported(aDateTimeFieldType);
	}

	@Override
	public int size() {
		return myLocalDate.size();
	}

	@Override
	public DateTime toDateTime(ReadableInstant aInstant) {
		return myLocalDate.toDateTime(aInstant);
	}

}
