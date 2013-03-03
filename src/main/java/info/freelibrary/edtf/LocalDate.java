package info.freelibrary.edtf;

import java.io.Serializable;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePeriod;
import org.joda.time.ReadablePartial;
import org.joda.time.LocalDate.Property;

public class LocalDate implements ReadablePartial, EDTFInstance, Serializable,
		Comparable<ReadablePartial> {

	/**
	 * Generated <code>serialVersionUID</code>.
	 */
	private static final long serialVersionUID = -4270736028882834273L;

	/**
	 * Encapsulated Joda Time <code>LocalDate</code>.
	 */
	private final org.joda.time.LocalDate myLocalDate;

	public LocalDate() {
		myLocalDate = new org.joda.time.LocalDate();
	}

	public LocalDate(org.joda.time.LocalDate aLocalDate) {
		myLocalDate = aLocalDate;
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

	public static LocalDate now() {
		return new LocalDate();
	}

	public static LocalDate now(DateTimeZone aZone) {
		if (aZone == null) {
			throw new NullPointerException("Zone must not be null");
		}

		return new LocalDate(aZone);
	}

	public static LocalDate now(Chronology aChronology) {
		if (aChronology == null) {
			throw new NullPointerException("Chronology must not be null");
		}

		return new LocalDate(aChronology);
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

	public boolean isAfter(ReadablePartial aReadblePartial) {
		return myLocalDate.isAfter(aReadblePartial);
	}

	public boolean isBefore(ReadablePartial aReadablePartial) {
		return myLocalDate.isBefore(aReadablePartial);
	}

	public boolean isEqual(ReadablePartial aReadablePartial) {
		return myLocalDate.isEqual(aReadablePartial);
	}

	public Property centuryOfEra() {
		return myLocalDate.centuryOfEra();
	}

	public Property dayOfMonth() {
		return myLocalDate.dayOfMonth();
	}

	public Property dayOfWeek() {
		return myLocalDate.dayOfWeek();
	}

	public Property dayOfYear() {
		return myLocalDate.dayOfYear();
	}

	public Property era() {
		return myLocalDate.era();
	}

	public int getCenturyOfEra() {
		return myLocalDate.getCenturyOfEra();
	}

	public int getDayOfMonth() {
		return myLocalDate.getDayOfMonth();
	}

	public int getDayOfWeek() {
		return myLocalDate.getDayOfWeek();
	}

	public int getDayOfYear() {
		return myLocalDate.getDayOfYear();
	}

	public int getEra() {
		return myLocalDate.getEra();
	}

	public LocalDate plus(ReadablePeriod aReadablePeriod) {
		return new LocalDate(myLocalDate.plus(aReadablePeriod));
	}

	public LocalDate plusDays(int aDayCount) {
		return new LocalDate(myLocalDate.plusDays(aDayCount));
	}

	public LocalDate plusWeeks(int aWeekCount) {
		return new LocalDate(myLocalDate.plusWeeks(aWeekCount));
	}

	public LocalDate plusMonths(int aMonthCount) {
		return new LocalDate(myLocalDate.plusMonths(aMonthCount));
	}

	public LocalDate plusYears(int aYearCount) {
		return new LocalDate(myLocalDate.plusYears(aYearCount));
	}

	public LocalDate minus(ReadablePeriod aReadablePeriod) {
		return new LocalDate(myLocalDate.minus(aReadablePeriod));
	}

	public LocalDate minusDays(int aDayCount) {
		return new LocalDate(myLocalDate.minusDays(aDayCount));
	}

	public LocalDate minusWeeks(int aWeekCount) {
		return new LocalDate(myLocalDate.minusWeeks(aWeekCount));
	}

	public LocalDate minusMonths(int aMonthCount) {
		return new LocalDate(myLocalDate.minusMonths(aMonthCount));
	}

	public LocalDate minusYears(int aYearCount) {
		return new LocalDate(myLocalDate.minusYears(aYearCount));
	}

	public LocalDateTime toLocalDateTime(LocalTime aTime) {
		return new LocalDateTime(myLocalDate.toLocalDateTime(aTime
				.getLocalTime()));
	}

	public boolean equals(Object aObject) {
		return myLocalDate.equals(aObject);
	}

	public int hashCode() {
		return myLocalDate.hashCode();
	}

	public String toString() {
		return myLocalDate.toString();
	}

}
