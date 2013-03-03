package info.freelibrary.edtf;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class LocalDateIntervalTest {
	
	private LocalDate fromDate;
	private LocalDate toDate;
	
	@Before
	public void setUp() throws Exception {
		fromDate = new LocalDate("2012-01-02");
		toDate = new LocalDate("2012-01-10");
	}
	
	@Test
	public void testGetStart() {
		LocalDateInterval interval = new LocalDateInterval(fromDate, toDate);
		assertTrue(interval.getStart().equals(new LocalDate("2012-01-02")));
	}

	@Test
	public void testGetEnd() {
		LocalDateInterval interval = new LocalDateInterval(fromDate, toDate);
		assertTrue(interval.getEnd().equals(new LocalDate("2012-01-10")));
	}

	@Test
	public void testGetDays() {
		LocalDateInterval interval = new LocalDateInterval(fromDate, toDate);
		assertEquals(interval.getDays(), 9);
	}

	@Test
	public void testContains() {
		LocalDateInterval interval = new LocalDateInterval(fromDate, toDate);
		assertTrue(interval.contains(new LocalDate("2012-01-05")));
	}

	@Test
	public void testToString() {
		LocalDateInterval interval = new LocalDateInterval(fromDate, toDate);
		assertEquals(interval.toString(), "2012-01-02/2012-01-10");
	}

	@Test
	public void testEqualsObject() {
		assertTrue(toDate.equals(new LocalDate("2012-01-10")));
	}

	@Test
	public void testIterator() {
		LocalDateInterval interval = new LocalDateInterval(fromDate, toDate);
		Iterator<LocalDate> iterator = interval.iterator();
		LocalDate currentDate = fromDate;
		int count = 0;
		
		while(iterator.hasNext()) {
			assertEquals(currentDate, iterator.next());
			currentDate = currentDate.plusDays(1);
			count += 1;
		}
		
		assertEquals(interval.getDays(), count);
	}

}
