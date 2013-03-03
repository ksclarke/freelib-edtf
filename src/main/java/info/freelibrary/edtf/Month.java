package info.freelibrary.edtf;

import java.io.Serializable;
import java.util.Calendar;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.ISODateTimeFormat;

public class Month extends BasePartial implements Serializable, EDTFInstance,
		ReadablePartial {

	/** The index of the monthOfYear field in the field array */
	public static final int MONTH_OF_YEAR = 0;

	private boolean myMonthIsKnown;
	private boolean myMonthIsCertain;

	public Month() {
		super();
	}

	public Month(DateTimeZone aZone) {
		super(ISOChronology.getInstance(aZone));
	}

	public Month(Chronology aChronology) {
		super(aChronology);
	}

	public Month(long aInstant) {
		super(aInstant);
	}

	public Month(long aInstant, Chronology aChronology) {
		super(aInstant, aChronology);
	}

	public Month(Object aInstant) {
		super(aInstant, null, ISODateTimeFormat.localDateParser());
	}

	public Month(Object aInstant, Chronology aChronology) {
		super(aInstant, DateTimeUtils.getChronology(aChronology),
				ISODateTimeFormat.localDateParser());
	}

	public Month(int aMonthInt) {

	}

	public static Month now() {
		return new Month();
	}

	public static Month now(DateTimeZone aZone) {
		if (aZone == null) {
			throw new NullPointerException("Zone must not be null");
		}

		return new Month(aZone);
	}

	public static Month now(Chronology aChronology) {
		if (aChronology == null) {
			throw new NullPointerException("Chronology must not be null");
		}

		return new Month(aChronology);
	}

	public boolean isKnown() {
		return myMonthIsKnown;
	}

	public boolean isCertain() {
		return myMonthIsCertain;
	}

	public static Month fromCalendarFields(Calendar aCalendar) {
		if (aCalendar == null) {
			throw new IllegalArgumentException("The calendar must not be null");
		}

		return new Month(aCalendar.get(Calendar.MONTH) + 1);
	}

	@Override
	public int compareTo(ReadablePartial arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get(DateTimeFieldType aFieldTypeIndex) {
		return 0;
	}

	@Override
	public DateTimeField getField(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTimeFieldType getFieldType(int aFieldTypeIndex) {
		switch (aFieldTypeIndex) {
		case MONTH_OF_YEAR:
			return DateTimeFieldType.monthOfYear();
		default:
			throw new IndexOutOfBoundsException("Index '"
					+ Integer.toString(aFieldTypeIndex) + "' out of bounds");
		}
	}

	@Override
	public boolean isSupported(DateTimeFieldType aDateTimeFieldType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public DateTime toDateTime(ReadableInstant arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DateTimeField getField(int arg0, Chronology arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
