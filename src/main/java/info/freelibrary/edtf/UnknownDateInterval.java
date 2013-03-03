package info.freelibrary.edtf;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnknownDateInterval implements EDTFInstance, Serializable {

	/**
	 * Generated <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -1941201160225670866L;

	public static final int DEFAULT_ITERATOR_SIZE = 50;

	public static final int UNKNOWN_START = 5;
	public static final int UNKNOWN_END = 7;

	private final LocalDate myBoundary;
	private final int myIntervalType;

	public UnknownDateInterval(int aIntervalType, LocalDate aBoundary) {
		if (aBoundary == null) {
			throw new NullPointerException("Supplied LocalDate may not be null");
		}

		myBoundary = aBoundary;
		myIntervalType = aIntervalType;
	}

	public LocalDate getBoundary() {
		return myBoundary;
	}

	public boolean isKnownRange() {
		return false;
	}
	
	public boolean contains(LocalDate aLocalDate) {
		switch (myIntervalType) {
		case UNKNOWN_START:
			return aLocalDate.isBefore(myBoundary);
		case UNKNOWN_END:
			return aLocalDate.isAfter(myBoundary);
		default:
			throw new IllegalArgumentException(
					"Interval type must be either: UNKNOWN_START or UNKNOWN_END");
		}
	}

	public boolean contains(LocalDate aLocalDate, int aDayRange) {
		switch (myIntervalType) {
		case UNKNOWN_START:
			return aLocalDate.isBefore(myBoundary)
					&& aLocalDate.isAfter(myBoundary.minusDays(aDayRange));
		case UNKNOWN_END:
			return aLocalDate.isAfter(myBoundary)
					&& aLocalDate.isBefore(myBoundary.plusDays(aDayRange));
		default:
			throw new IllegalArgumentException(
					"Interval type must be either: UNKNOWN_START or UNKNOWN_END");
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

		UnknownDateInterval odi = (UnknownDateInterval) aObject;

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
		case UNKNOWN_START:
			return "unknown/" + myBoundary.toString();
		case UNKNOWN_END:
			return myBoundary.toString() + "/unknown";
		default:
			throw new IllegalArgumentException(
					"Interval type must be either: UNKNOWN_START or UNKNOWN_END");
		}
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
					throw new NoSuchElementException("Last element reached");
				}

				if (myIntervalType == UNKNOWN_END) {
					myLocalDate = myLocalDate.plusDays(1);
				}
				else if (myIntervalType == UNKNOWN_START) {
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
