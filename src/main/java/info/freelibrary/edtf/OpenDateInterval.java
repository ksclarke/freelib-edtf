package info.freelibrary.edtf;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OpenDateInterval implements EDTFInstance, Serializable {

	/**
	 * Generated <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -2067063089433351247L;

	public static final int DEFAULT_ITERATOR_SIZE = 50;
	
	public static final int OPEN_START = 1;
	public static final int OPEN_END = 3;
	
	private final LocalDate myBoundary;
	private final int myIntervalType;

	public OpenDateInterval(int aIntervalType, LocalDate aBoundary) {
		if (aBoundary == null) {
			throw new NullPointerException("Supplied LocalDate may not be null");
		}

		myBoundary = aBoundary;
		myIntervalType = aIntervalType;
	}

	public LocalDate getBoundary() {
		return myBoundary;
	}

	public boolean contains(LocalDate aLocalDate) {
		switch (myIntervalType) {
		case OPEN_START:
			return aLocalDate.isBefore(myBoundary);
		case OPEN_END:
			return aLocalDate.isAfter(myBoundary);
		default:
			throw new IllegalArgumentException(
					"Interval type must be either: OPEN_START or OPEN_END");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = myBoundary == null ? 0 : myBoundary.hashCode();
		return prime * ((prime * result) + myIntervalType);
	}

	@Override
	public boolean equals(Object aObject) {
		if (this == aObject) {
			return true;
		}

		if (aObject == null || getClass() != aObject.getClass()) {
			return false;
		}

		OpenDateInterval odi = (OpenDateInterval) aObject;

		if (myBoundary == null) {
			if (odi.myBoundary != null) {
				return false;
			}
		}
		else if (!myBoundary.equals(odi.myBoundary)) {
			return false;
		}

		if (myIntervalType != odi.myIntervalType) {
			return false;
		}

		return true;
	}

	public String toString() {
		switch (myIntervalType) {
		case OPEN_START:
			return "open/" + myBoundary.toString();
		case OPEN_END:
			return myBoundary.toString() + "/open";
		default:
			throw new IllegalArgumentException(
					"Interval type must be either: OPEN_START or OPEN_END");
		}
	}

	public boolean isKnownRange() {
		return true;
	}
	
	public Iterator<LocalDate> iterator() {
		return iterator(DEFAULT_ITERATOR_SIZE);
	}

	public Iterator<LocalDate> iterator(final int aLimit) {
		if (aLimit <= 0) {
			throw new IllegalArgumentException(
					"Limit must be a positive number");
		}

		return new Iterator<LocalDate>() {

			private LocalDate myLocalDate = myBoundary;
			private int myIncrement;

			@Override
			public boolean hasNext() {
				return myIncrement < aLimit;
			}

			@Override
			public LocalDate next() {
				LocalDate localDate = myLocalDate;

				if (!hasNext()) {
					throw new NoSuchElementException("Last element of "
							+ aLimit + " reached");
				}

				if (myIntervalType == OPEN_END) {
					myLocalDate = myLocalDate.plusDays(1);
				}
				else if (myIntervalType == OPEN_START) {
					myLocalDate = myLocalDate.minusDays(1);
				}
				else {
					throw new RuntimeException("Unexpected interval type");
				}

				myIncrement += 1;
				return localDate;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
