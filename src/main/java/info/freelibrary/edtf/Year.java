package info.freelibrary.edtf;

import java.io.Serializable;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.ReadablePartial;
import org.joda.time.base.BasePartial;

public class Year extends BasePartial implements ReadablePartial, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6906752458471600393L;

	private static final DateTimeFieldType[] FIELD_TYPES = new DateTimeFieldType[] { DateTimeFieldType
			.year() };

	public static final int YEAR = 0;

	private boolean myYearIsKnown;
	private boolean myYearIsCertain;

	public Year() {
		myYearIsKnown = false;
	}

	public Year(int aYearInt) {

	}

	public boolean isKnown() {
		return myYearIsKnown;
	}

	public boolean isCertain() {
		return myYearIsCertain;
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	protected DateTimeField getField(int aFieldIndex, Chronology aChronology) {
		switch (aFieldIndex) {
		case YEAR:
			return aChronology.year();
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + aFieldIndex);
		}
	}

}
