package info.freelibrary.edtf;

import java.io.Serializable;
import java.util.Calendar;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;

public class YearMonth implements Serializable, EDTFInstance, ReadablePartial {

	/**
	 * Generated <code>serialVersionUID</code>.
	 */
	private static final long serialVersionUID = -2068422436305205861L;

	private final org.joda.time.YearMonth myYearMonth;

	public YearMonth() {
		myYearMonth = new org.joda.time.YearMonth();
	}

	public YearMonth(Chronology aChronology) {
		myYearMonth = new org.joda.time.YearMonth(aChronology);
	}

	public YearMonth(DateTimeZone aZone) {
		myYearMonth = new org.joda.time.YearMonth(aZone);
	}

	public YearMonth(int aYear, int aMonthOfYear) {
		myYearMonth = new org.joda.time.YearMonth(aYear, aMonthOfYear);
	}

	public YearMonth(int aYear, int aMonthOfYear, Chronology aChronology) {
		myYearMonth = new org.joda.time.YearMonth(aYear, aMonthOfYear);
	}

	public YearMonth(long aInstant) {
		myYearMonth = new org.joda.time.YearMonth(aInstant);
	}

	public YearMonth(long aInstant, Chronology aChronology) {
		myYearMonth = new org.joda.time.YearMonth(aInstant, aChronology);
	}

	public YearMonth(Object aInstant) {
		myYearMonth = new org.joda.time.YearMonth(aInstant);
	}

	public YearMonth(Object aInstant, Chronology aChronology) {
		myYearMonth = new org.joda.time.YearMonth(aInstant, aChronology);
	}

	public YearMonth(org.joda.time.YearMonth aJodaYearMonth) {
		myYearMonth = aJodaYearMonth;
	}

	public static YearMonth now() {
		return new YearMonth();
	}

	public static YearMonth now(DateTimeZone aZone) {
		if (aZone == null) {
			throw new NullPointerException("Zone must not be null");
		}

		return new YearMonth(aZone);
	}

	public static YearMonth now(Chronology aChronology) {
		if (aChronology == null) {
			throw new NullPointerException("Chronology must not be null");
		}

		return new YearMonth(aChronology);
	}

	public static YearMonth fromCalendarFields(Calendar aCalendar) {
		return new YearMonth(aCalendar.get(Calendar.YEAR),
				aCalendar.get(Calendar.MONTH) + 1);
	}

	public int size() {
		return myYearMonth.size();
	}

	public YearMonth withChronologyRetainFields(Chronology aChronology) {
		return new YearMonth(
				myYearMonth.withChronologyRetainFields(aChronology));
	}

	public YearMonth plus(ReadablePeriod aPeriod) {
		return new YearMonth(myYearMonth.plus(aPeriod));
	}

	public YearMonth plusYears(int aYearCount) {
		return new YearMonth(myYearMonth.plusYears(aYearCount));
	}

	public YearMonth plusMonths(int aMonthCount) {
		return new YearMonth(myYearMonth.plusMonths(aMonthCount));
	}

	public YearMonth minus(ReadablePeriod aPeriod) {
		return new YearMonth(myYearMonth.minus(aPeriod));
	}
	
	public YearMonth minusMonths(int aMonthCount) {
		return new YearMonth(myYearMonth.minusMonths(aMonthCount));
	}

	public YearMonth minusYears(int aYearCount) {
		return new YearMonth(myYearMonth.minusYears(aYearCount));
	}
	
	public LocalDate toLocalDate(int aDayOfMonth) {
		return new LocalDate(myYearMonth.toLocalDate(aDayOfMonth));
	}
	
	public int getYearAsInt() {
		return myYearMonth.getYear();
	}

	public Year getYear() {
		return new Year(myYearMonth.getYear());
	}

	public int getMonthAsInt() {
		return myYearMonth.getMonthOfYear();
	}

	public Month getMonth() {
		return new Month(myYearMonth.getMonthOfYear());
	}

	public YearMonth withYear(int aYear) {
		return new YearMonth(myYearMonth.withYear(aYear));
	}

	public YearMonth withMonthOfYear(int aMonthOfYear) {
		return new YearMonth(myYearMonth.withMonthOfYear(aMonthOfYear));
	}

	public String toString() {
		return myYearMonth.toString();
	}

	@Override
	public int compareTo(ReadablePartial aPartial) {
		return myYearMonth.compareTo(aPartial);
	}

	@Override
	public int get(DateTimeFieldType aDateTimeFieldType) {
		return myYearMonth.get(aDateTimeFieldType);
	}

	@Override
	public Chronology getChronology() {
		return myYearMonth.getChronology();
	}

	@Override
	public DateTimeField getField(int aField) {
		return myYearMonth.getField(aField);
	}

	@Override
	public DateTimeFieldType getFieldType(int aFieldType) {
		return myYearMonth.getFieldType(aFieldType);
	}

	@Override
	public int getValue(int aFieldIndex) {
		return myYearMonth.getValue(aFieldIndex);
	}

	@Override
	public boolean isSupported(DateTimeFieldType aDateTimeFieldType) {
		return myYearMonth.isSupported(aDateTimeFieldType);
	}

	/**
	 * Note, this is the Joda DateTime; I can't extend it, it's final
	 */
	@Override
	public org.joda.time.DateTime toDateTime(ReadableInstant aReadableInstant) {
		return myYearMonth.toDateTime(aReadableInstant);
	}

}