package info.freelibrary.edtf;

import org.joda.time.DurationFieldType;
import org.joda.time.PeriodType;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadableInterval;
import org.joda.time.ReadablePartial;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.FieldUtils;

public final class Years extends BaseSingleFieldPeriod {

    /**
	 * Generated <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -2916543954991921519L;

	/** Constant representing zero years. */
    public static final Years ZERO = new Years(0);

    /** Constant representing one year. */
    public static final Years ONE = new Years(1);
    
    /** Constant representing two years. */
    public static final Years TWO = new Years(2);
    
    /** Constant representing three years. */
    public static final Years THREE = new Years(3);
    
    /** Constant representing the maximum number of years that can be stored in this object. */
    public static final Years MAX_VALUE = new Years(Integer.MAX_VALUE);
    
    /** Constant representing the minimum number of years that can be stored in this object. */
    public static final Years MIN_VALUE = new Years(Integer.MIN_VALUE);

    /**
     * Obtains an instance of <code>Years</code> that may be cached.
     * <code>Years</code> is immutable, so instances can be cached and shared.
     * This factory method provides access to shared instances.
     *
     * @param aYearCount  the number of years to obtain an instance for
     * @return the instance of Years
     */
    public static Years years(int aYearCount) {
        switch (aYearCount) {
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case Integer.MAX_VALUE:
                return MAX_VALUE;
            case Integer.MIN_VALUE:
                return MIN_VALUE;
            default:
                return new Years(aYearCount);
        }
    }

    /**
     * Creates a <code>Years</code> representing the number of whole years
     * between the two specified DateTimes. This method correctly handles
     * any daylight savings time changes that may occur during the interval.
     *
     * @param aStart  the start instant, must not be null
     * @param aEnd  the end instant, must not be null
     * @return the period in years
     * @throws IllegalArgumentException if the instants are null or invalid
     */
    public static Years yearsBetween(ReadableInstant aStart, ReadableInstant aEnd) {
    	return years(org.joda.time.Years.yearsBetween(aStart, aEnd).getYears());
    }

    /**
     * Creates a <code>Years</code> representing the number of whole years
     * between the two specified partial DateTimes.
     * <p>
     * The two partials must contain the same fields, for example you can specify
     * two <code>LocalDate</code> objects.
     *
     * @param aStart  the start partial date, must not be null
     * @param aEnd  the end partial date, must not be null
     * @return the period in years
     * @throws IllegalArgumentException if the partials are null or invalid
     */
    public static Years yearsBetween(ReadablePartial aStart, ReadablePartial aEnd) {
    	return years(org.joda.time.Years.yearsBetween(aStart, aEnd).getYears());
    }

    /**
     * Creates a <code>Years</code> representing the number of whole years
     * in the specified interval. This method correctly handles any daylight
     * savings time changes that may occur during the interval.
     *
     * @param aInterval  the interval to extract years from, null returns zero
     * @return the period in years
     * @throws IllegalArgumentException if the partials are null or invalid
     */
    public static Years yearsIn(ReadableInterval aInterval) {
    	return years(org.joda.time.Years.yearsIn(aInterval).getYears());
    }

    /**
     * Creates a new <code>Years</code> by parsing a string in the ISO8601 format 'PnY'.
     * <p>
     * The parse will accept the full ISO syntax of PnYnMnWnDTnHnMnS however only the
     * years component may be non-zero. If any other component is non-zero, an exception
     * will be thrown.
     *
     * @param aPeriodString  the period string, null returns zero
     * @return the period in years
     * @throws IllegalArgumentException if the string format is invalid
     */
    public static Years parseYears(String aPeriodString) {
    	return years(org.joda.time.Years.parseYears(aPeriodString).getYears());
    }

    /**
     * Creates a new instance representing a number of years.
     * You should consider using the factory method {@link #years(int)}
     * instead of the constructor.
     *
     * @param aYearCount  the number of years to represent
     */
    private Years(int aYearCount) {
        super(aYearCount);
    }

    /**
     * Resolves singletons.
     * 
     * @return the singleton instance
     */
    private Object readResolve() {
        return Years.years(getValue());
    }

    /**
     * Gets the duration field type, which is <code>years</code>.
     *
     * @return the period type
     */
    public DurationFieldType getFieldType() {
        return DurationFieldType.years();
    }

    /**
     * Gets the period type, which is <code>years</code>.
     *
     * @return the period type
     */
    public PeriodType getPeriodType() {
        return PeriodType.years();
    }

    /**
     * Gets the number of years that this period represents.
     *
     * @return the number of years in the period
     */
    public int getYears() {
        return getValue();
    }

    /**
     * Returns a new instance with the specified number of years added.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param aYearCount  the amount of years to add, may be negative
     * @return the new period plus the specified number of years
     * @throws ArithmeticException if the result overflows an int
     */
    public Years plus(int aYearCount) {
        if (aYearCount == 0) {
            return this;
        }

        return Years.years(FieldUtils.safeAdd(getValue(), aYearCount));
    }

    /**
     * Returns a new instance with the specified number of years added.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param aYears  the amount of years to add, may be negative, null means zero
     * @return the new period plus the specified number of years
     * @throws ArithmeticException if the result overflows an int
     */
    public Years plus(Years aYears) {
        if (aYears == null) {
            return this;
        }

        return plus(aYears.getValue());
    }

    /**
     * Returns a new instance with the specified number of years taken away.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param aYearCount  the amount of years to take away, may be negative
     * @return the new period minus the specified number of years
     * @throws ArithmeticException if the result overflows an int
     */
    public Years minus(int aYearCount) {
        return plus(FieldUtils.safeNegate(aYearCount));
    }

    /**
     * Returns a new instance with the specified number of years taken away.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param aYears  the amount of years to take away, may be negative, null means zero
     * @return the new period minus the specified number of years
     * @throws ArithmeticException if the result overflows an int
     */
    public Years minus(Years aYears) {
        if (aYears == null) {
            return this;
        }

        return minus(aYears.getValue());
    }

    /**
     * Returns a new instance with the years multiplied by the specified scalar.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param aScalar  the amount to multiply by, may be negative
     * @return the new period multiplied by the specified scalar
     * @throws ArithmeticException if the result overflows an int
     */
    public Years multipliedBy(int aScalar) {
        return Years.years(FieldUtils.safeMultiply(getValue(), aScalar));
    }

    /**
     * Returns a new instance with the years divided by the specified divisor.
     * The calculation uses integer division, thus 3 divided by 2 is 1.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param aDivisor  the amount to divide by, may be negative
     * @return the new period divided by the specified divisor
     * @throws ArithmeticException if the divisor is zero
     */
    public Years dividedBy(int aDivisor) {
        if (aDivisor == 1) {
            return this;
        }

        return Years.years(getValue() / aDivisor);
    }

    /**
     * Returns a new instance with the years value negated.
     *
     * @return the new period with a negated value
     * @throws ArithmeticException if the result overflows an int
     */
    public Years negated() {
        return Years.years(FieldUtils.safeNegate(getValue()));
    }

    /**
     * Is this years instance greater than the specified number of years.
     *
     * @param aYears  the other period, null means zero
     * @return true if this years instance is greater than the specified one
     */
    public boolean isGreaterThan(Years aYears) {
        if (aYears == null) {
            return getValue() > 0;
        }

        return getValue() > aYears.getValue();
    }

    /**
     * Is this years instance less than the specified number of years.
     *
     * @param aYears  the other period, null means zero
     * @return true if this years instance is less than the specified one
     */
    public boolean isLessThan(Years aYears) {
        if (aYears == null) {
            return getValue() < 0;
        }

        return getValue() < aYears.getValue();
    }

    /**
     * Gets this instance as a String in the ISO8601 duration format.
     * <p>
     * For example, "P4Y" represents 4 years.
     *
     * @return the value as an ISO8601 string
     */
    public String toString() {
        return "P" + String.valueOf(getValue()) + "Y";
    }

}
