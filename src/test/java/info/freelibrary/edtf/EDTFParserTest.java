package info.freelibrary.edtf;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EDTFParserTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(EDTFParserTest.class);
	
	private static DateTimeParser myParser;

	@BeforeClass
	public static void runBeforeClass() {
		myParser = new DateTimeParser();
	}

	@Test
	public void level0YearTest() {
		try { // Standard ISO 8601 four-digit year
			myParser.parse("1991");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}

		try { // Spec assumes astronomical numbering, which includes year zero
			myParser.parse("0000");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try { // Year MUST have four digits so below should throw exception
			myParser.parse("400");
			fail("Parser allowed less than four digit year");
		}
		catch (SyntaxException details) {}
		
		try { // Negative years are allowed
			myParser.parse("-1000");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
	}

	@Test
	public void level0YearMonthTest() {
		try { // Standard ISO 8601 four-digit year and two digit month
			myParser.parse("1990-12");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try { // Standard ISO 8601 four-digit year and two digit month
			myParser.parse("1992/12");
			fail("Year-month dates must use a hyphen as a delimiter");
		}
		catch (SyntaxException details) {}
		
		try { // Negative year-month dates are allowed
			myParser.parse("-1993-12");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try { // Year MUST have four digits so below should throw exception
			myParser.parse("400-12");
			fail("Parser allowed less than four digit year");
		}
		catch (SyntaxException details) {}
		
		try { // Month MUST have two digits so below should throw exception
			myParser.parse("1994-1");
			fail("Parser allowed less than two digit month");
		}
		catch (SyntaxException details) {}
	}

	@Test
	public void level0YearMonthDayTest() {
		try { // Standard ISO 8601 4 digit year, 2 digit month, 2 digit day
			myParser.parse("1992-12-12");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try { // Negative year-month-day dates are allowed
			myParser.parse("-1993-12-01");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try { // Day MUST have two digits so below should throw exception
			myParser.parse("1984-01-1");
			fail("Parser allowed less than two digit day");
		}
		catch (SyntaxException details) {}
	
		try { // Month MUST have two digits so below should throw exception
			myParser.parse("1994-1-01");
			fail("Parser allowed less than two digit month");
		}
		catch (SyntaxException details) {}
		
		try { // Day month combination must be valid
			myParser.parse("1986-02-31");
			fail("Parser allowed invalid day-month combination: 1986-02-31");
		}
		catch (SyntaxException details) {}
	}
	
	@Test
	public void level0HourMinuteSecondTest() {
		try { // Standard ISO 8601 4 digit year, 2 digit month, 2 digit day
			myParser.parse("2001-02-03T09:30:01");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try { // Negative ISO 8601 4 digit year, 2 digit month, 2 digit day
			myParser.parse("-2007-02-03T09:30:01");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try { // Year, month, day delimiters should be dashes, not slashes
			myParser.parse("1971/02/03T09:30:01");
			fail("Failed to disallow slashes for year, month, day delimiters");
		}
		catch (SyntaxException details) {}

		try { // 'T' should be used as the date/time delimiter
			myParser.parse("1973-02-03 09:30:01");
			fail("Failed to require 'T' as date/time delimiter");
		}
		catch (SyntaxException details) {}
		
		try { // ':' should be used as time unit delimiter
			myParser.parse("1972-02-03T09-30-01");
			fail("Failed to require ':' as time unit delimiter");
		}
		catch (SyntaxException details) {}
		
		try { // Standard ISO 8601 in Zulu time zone
			myParser.parse("1998-01-03T09:30:01Z");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try { // Testing Zulu time zone but with other character
			myParser.parse("1962-02-03T09-30-01T");
			fail("Failed to require 'Z' as Zulu time zone indicator");
		}
		catch (SyntaxException details) {}
		
		try { // Standard ISO 8601 with 24:00:00
			myParser.parse("1893-01-03T24:00:00");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try {
			myParser.parse("1883-01-03T24:00:00+01:59");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try {
			myParser.parse("1883-01-03T24:00:00+14:00");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try {
			myParser.parse("1883-01-03T24:00:00-14:00");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
		
		try {
			myParser.parse("1883-01-03T24:00:00-00:45");
		}
		catch (SyntaxException details) {
			fail(details.getMessage());
		}
	}
}
