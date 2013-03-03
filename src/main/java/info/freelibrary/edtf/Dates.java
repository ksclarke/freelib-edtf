package info.freelibrary.edtf;

import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

public class Dates {

	public static <T extends ReadablePartial> T earlier(T aFirstDate,
			T aSecondDate) {
		if (aFirstDate == null) {
			throw new NullPointerException(
					"First date supplied not allowed to be null");
		}

		if (aSecondDate == null) {
			throw new NullPointerException(
					"Second date supplied not allowed to be null");
		}

		return aFirstDate.compareTo(aSecondDate) <= 0 ? aFirstDate
				: aSecondDate;
	}

	public static <T extends ReadablePartial> T later(T aFirstDate,
			T aSecondDate) {
		if (aFirstDate == null) {
			throw new NullPointerException(
					"First date supplied not allowed to be null");
		}

		if (aSecondDate == null) {
			throw new NullPointerException(
					"Second date supplied not allowed to be null");
		}

		return aFirstDate.compareTo(aSecondDate) >= 0 ? aFirstDate
				: aSecondDate;
	}

	public static <T extends ReadableInstant> T earlier(T aFirstDate,
			T aSecondDate) {
		if (aFirstDate == null) {
			throw new NullPointerException(
					"First date supplied not allowed to be null");
		}

		if (aSecondDate == null) {
			throw new NullPointerException(
					"Second date supplied not allowed to be null");
		}

		return aFirstDate.compareTo(aSecondDate) <= 0 ? aFirstDate
				: aSecondDate;
	}

	public static <T extends ReadableInstant> T later(T aFirstDate,
			T aSecondDate) {
		if (aFirstDate == null) {
			throw new NullPointerException(
					"First date supplied not allowed to be null");
		}

		if (aSecondDate == null) {
			throw new NullPointerException(
					"Second date supplied not allowed to be null");
		}

		return aFirstDate.compareTo(aSecondDate) >= 0 ? aFirstDate
				: aSecondDate;
	}
}
