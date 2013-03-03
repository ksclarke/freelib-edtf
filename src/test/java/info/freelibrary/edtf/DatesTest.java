package info.freelibrary.edtf;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

public class DatesTest {
	
    @Test
    public void testEarlierReadablePartial_yesterdayAndToday_yesterdayIsReturned() {
        LocalDate today = new LocalDate();
        LocalDate yesterday = today.minusDays(1);

        assertEquals(yesterday, Dates.earlier(today, yesterday));
        assertEquals(yesterday, Dates.earlier(yesterday, today));
    }

    @Test
    public void testLaterReadablePartial_yesterdayAndToday_todayIsReturned() {
        LocalDate today = new LocalDate();
        LocalDate yesterday = today.minusDays(1);

        assertEquals(today, Dates.later(today, yesterday));
        assertEquals(today, Dates.later(yesterday, today));
    }

    @Test
    public void testEarlierReadableInstant_nowAndSecondAgo_secondAgoIsReturned() {
        DateTime now = new DateTime();
        DateTime secondAgo = now.minusSeconds(1);

        assertEquals(secondAgo, Dates.earlier(now, secondAgo));
        assertEquals(secondAgo, Dates.earlier(secondAgo, now));
    }

    @Test
    public void testLaterReadableInstant_nowAndSecondAgo_nowIsReturned() {
        DateTime now = new DateTime();
        DateTime secondAgo = now.minusSeconds(1);

        assertEquals(now, Dates.later(now, secondAgo));
        assertEquals(now, Dates.later(secondAgo, now));
    }

}
