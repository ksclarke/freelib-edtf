package info.freelibrary.edtf;

import static org.junit.Assert.*;

import java.util.Iterator;

import static info.freelibrary.edtf.OpenDateInterval.OPEN_END;
import static info.freelibrary.edtf.OpenDateInterval.OPEN_START;

import org.junit.Before;
import org.junit.Test;

public class OpenDateIntervalTest {

	private LocalDate myBoundary;

	@Before
	public void setUp() throws Exception {
		myBoundary = new LocalDate("1970-06-01");
	}

	@Test
	public void testGetBoundary() {
		OpenDateInterval interval = new OpenDateInterval(OPEN_END, myBoundary);
		assertEquals(interval.getBoundary().toString(), "1970-06-01");
		interval = new OpenDateInterval(OPEN_START, myBoundary);
		assertEquals(interval.getBoundary().toString(), "1970-06-01");
	}

	@Test
	public void testContains() {
		OpenDateInterval interval = new OpenDateInterval(OPEN_END, myBoundary);
		assertTrue(interval.contains(new LocalDate("1970-06-15")));
		assertFalse(interval.contains(new LocalDate("1970-05-15")));

		interval = new OpenDateInterval(OPEN_START, myBoundary);
		assertTrue(interval.contains(new LocalDate("1970-05-01")));
		assertFalse(interval.contains(new LocalDate("1970-07-15")));
	}

	@Test
	public void testEqualsObject() {
		OpenDateInterval interval1 = new OpenDateInterval(OPEN_END, myBoundary);
		OpenDateInterval interval2 = new OpenDateInterval(OPEN_END, myBoundary);
		
		assertEquals(interval1, interval2);
		
		interval1 = new OpenDateInterval(OPEN_START, myBoundary);
		interval2 = new OpenDateInterval(OPEN_START, myBoundary);
		
		assertEquals(interval1, interval2);
		
		interval1 = new OpenDateInterval(OPEN_START, myBoundary);
		interval2 = new OpenDateInterval(OPEN_START, new LocalDate("1992-09-01"));
		
		assertNotEquals(interval1, interval2);
	}

	@Test
	public void testToString() {
		OpenDateInterval interval = new OpenDateInterval(OPEN_END, myBoundary);
		assertEquals(interval.toString(), "1970-06-01/open");
		
		interval = new OpenDateInterval(OPEN_END, myBoundary);
		assertNotEquals(interval.toString(), "open/1970-06-01");
	}

	@Test
	public void testIterator() {
		OpenDateInterval interval = new OpenDateInterval(OPEN_END, myBoundary);
		Iterator<LocalDate> iterator = interval.iterator();
		LocalDate currentDate = myBoundary;
		int count = 0;
		
		while(iterator.hasNext()) {
			assertEquals(currentDate, iterator.next());
			currentDate = currentDate.plusDays(1);
			count += 1;
		}
		
		assertEquals(OpenDateInterval.DEFAULT_ITERATOR_SIZE, count);
	}

	@Test
	public void testIteratorInt() {
		int intervalLimit = 10;
		OpenDateInterval interval = new OpenDateInterval(OPEN_END, myBoundary);
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
