package info.freelibrary.edtf;

import static info.freelibrary.edtf.UnknownDateInterval.UNKNOWN_END;
import static info.freelibrary.edtf.UnknownDateInterval.UNKNOWN_START;

import java.util.Iterator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnknownDateIntervalTest {

	private LocalDate myBoundary;

	@Before
	public void setUp() throws Exception {
		myBoundary = new LocalDate("1970-06-01");
	}
	
	@Test
	public void testGetBoundary() {
		UnknownDateInterval interval = new UnknownDateInterval(UNKNOWN_END, myBoundary);
		assertEquals(interval.getBoundary().toString(), "1970-06-01");
		interval = new UnknownDateInterval(UNKNOWN_START, myBoundary);
		assertEquals(interval.getBoundary().toString(), "1970-06-01");
	}

	@Test
	public void testContains() {
		UnknownDateInterval interval = new UnknownDateInterval(UNKNOWN_END, myBoundary);
		assertTrue(interval.contains(new LocalDate("1970-06-15")));
		assertFalse(interval.contains(new LocalDate("1970-05-15")));

		interval = new UnknownDateInterval(UNKNOWN_START, myBoundary);
		assertTrue(interval.contains(new LocalDate("1970-05-01")));
		assertFalse(interval.contains(new LocalDate("1970-07-15")));
	}
	
	@Test
	public void testContainsLocalDateInt() {
		UnknownDateInterval interval = new UnknownDateInterval(UNKNOWN_END, myBoundary);
		assertTrue(interval.contains(new LocalDate("1970-06-10"), 15));
		assertFalse(interval.contains(new LocalDate("1970-06-20"), 15));

		interval = new UnknownDateInterval(UNKNOWN_START, myBoundary);
		assertTrue(interval.contains(new LocalDate("1970-05-31"), 15));
		assertFalse(interval.contains(new LocalDate("1970-05-10"), 15));
	}

	@Test
	public void testEqualsObject() {
		UnknownDateInterval interval1 = new UnknownDateInterval(UNKNOWN_END, myBoundary);
		UnknownDateInterval interval2 = new UnknownDateInterval(UNKNOWN_END, myBoundary);
		
		assertEquals(interval1, interval2);
		
		interval1 = new UnknownDateInterval(UNKNOWN_START, myBoundary);
		interval2 = new UnknownDateInterval(UNKNOWN_START, myBoundary);
		
		assertEquals(interval1, interval2);
		
		interval1 = new UnknownDateInterval(UNKNOWN_START, myBoundary);
		interval2 = new UnknownDateInterval(UNKNOWN_START, new LocalDate("1992-09-01"));
		
		assertNotEquals(interval1, interval2);
	}

	@Test
	public void testToString() {
		UnknownDateInterval interval = new UnknownDateInterval(UNKNOWN_END, myBoundary);
		assertEquals(interval.toString(), "1970-06-01/unknown");
		
		interval = new UnknownDateInterval(UNKNOWN_END, myBoundary);
		assertNotEquals(interval.toString(), "unknown/1970-06-01");
	}

	@Test
	public void testIterator() {
		UnknownDateInterval interval = new UnknownDateInterval(UNKNOWN_END, myBoundary);
		Iterator<LocalDate> iterator = interval.iterator();
		LocalDate currentDate = myBoundary;
		int count = 0;
		
		while(iterator.hasNext()) {
			assertEquals(currentDate, iterator.next());
			currentDate = currentDate.plusDays(1);
			count += 1;
		}
		
		assertEquals(UnknownDateInterval.DEFAULT_ITERATOR_SIZE, count);
	}

	@Test
	public void testIteratorInt() {
		int intervalLimit = 10;
		UnknownDateInterval interval = new UnknownDateInterval(UNKNOWN_END, myBoundary);
		Iterator<LocalDate> iterator = interval.iterator(intervalLimit);
		LocalDate currentDate = myBoundary;
		int count = 0;
		
		while(iterator.hasNext()) {
			assertEquals(currentDate, iterator.next());
			currentDate = currentDate.plusDays(1);
			count += 1;
		}
		
		assertEquals(intervalLimit, count);
	}

}
