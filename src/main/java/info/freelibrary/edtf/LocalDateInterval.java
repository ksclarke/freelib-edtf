package info.freelibrary.edtf;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.joda.time.Days;

final class LocalDateInterval implements Iterable<LocalDate> {

	private final LocalDate myStartDate;

	private final LocalDate myEndDate;

	private final int myDayCount;

	LocalDateInterval(LocalDate aStartDate, LocalDate aEndDate) {
		if (aStartDate == null) {
			throw new NullPointerException(
					"Supplied start date may not be null");
		}

		if (aEndDate == null) {
			throw new NullPointerException("");
		}

		myStartDate = aStartDate;
		myEndDate = aEndDate;

		if (myStartDate.isAfter(myEndDate)) {
			throw new IllegalArgumentException(
					"Supplied 'start' LocalDate is after supplied 'end' LocalDate");
		}

		myDayCount = Days.daysBetween(aStartDate, aEndDate).getDays() + 1;
	}

	public LocalDate getStart() {
		return myStartDate;
	}

	public LocalDate getEnd() {
		return myEndDate;
	}

	public int getDays() {
		return myDayCount;
	}

	public boolean contains(LocalDate aLocalDate) {
		return !aLocalDate.isAfter(myEndDate)
				&& !aLocalDate.isBefore(myStartDate);
	}

	@Override
	public String toString() {
		return myStartDate.toString() + "/" + myEndDate.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result
				+ ((myStartDate == null) ? 0 : myStartDate.hashCode());
		result = prime * result
				+ ((myEndDate == null) ? 0 : myEndDate.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object aObject) {
		if (this == aObject) {
			return true;
		}

		if (aObject == null || getClass() != aObject.getClass()) {
			return false;
		}

		LocalDateInterval ldi = (LocalDateInterval) aObject;

		if (myStartDate == null) {
			if (ldi.myStartDate != null) {
				return false;
			}
		}
		else if (!myStartDate.equals(ldi.myStartDate)) {
			return false;
		}

		if (myEndDate == null) {
			if (ldi.myEndDate != null) {
				return false;
			}
		}
		else if (!myEndDate.equals(ldi.myEndDate)) {
			return false;
		}

		return true;
	}

	public boolean isKnownRange() {
		return true;
	}
	
	@Override
	public Iterator<LocalDate> iterator() {
		return new Iterator<LocalDate>() {

			private LocalDate myLocalDate = myStartDate;

			@Override
			public boolean hasNext() {
				return !myLocalDate.isAfter(myEndDate);
			}

			@Override
			public LocalDate next() {
				LocalDate previousLocalDate = myLocalDate;

				if (!hasNext()) {
					throw new NoSuchElementException("Last element reached");
				}

				myLocalDate = myLocalDate.plusDays(1);
				return previousLocalDate;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
