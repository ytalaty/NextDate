package edu.depaul.se433.nextdate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

/*
 * Assignment: #4
 * Topic: Parameterized Tests With DateObj
 * Author: Yusuf Talaty
 */

/**
 * 
 * Uses Parameterized Testing to verify valid nextDate() functionality.
 *
 */
@RunWith(Parameterized.class)
public class DateObjParamaterizedTest {
		private DateObj today;
		private DateObj expectedTomorrow;
		
		public DateObjParamaterizedTest(DateObj today, DateObj tomorrow) {
			this.today = today;
			this.expectedTomorrow = tomorrow;
		}
		
		@Parameters
		public static Collection<DateObj[]> data() {
			return Arrays.asList(new DateObj[][] {
				// today         tomorrow
				{ new DateObj(2008, 2, 29), new DateObj(2008, 3, 1) },
				{ new DateObj(2009, 2, 28), new DateObj(2009, 3, 1) },
				{ new DateObj(2009, 2, 10), new DateObj(2009, 2, 11) },
				{ new DateObj(2008, 3, 10), new DateObj(2008, 3, 11) },
				{ new DateObj(2008, 3, 29), new DateObj(2008, 3, 30) },
				{ new DateObj(2009, 3, 10), new DateObj(2009, 3, 11) },
				{ new DateObj(2009, 3, 31), new DateObj(2009, 4, 1) },
				{ new DateObj(2008, 12, 31), new DateObj(2009, 1, 1) },
				{ new DateObj(2021, 10, 31), new DateObj(2021, 11, 1) },
				{ new DateObj(2009, 4, 30), new DateObj(2009, 5, 1) },
				{ new DateObj(2008, 4, 29), new DateObj(2008, 4, 30) },
				{ new DateObj(1, 1, 1), new DateObj(1, 1, 2) },
				{ new DateObj(1999, 12, 31), new DateObj(2000, 1, 1) },
				{ new DateObj(2020, 3, 31), new DateObj(2020, 4, 1) },
				{ new DateObj(1999, 6, 1), new DateObj(1999, 6, 2) },
				{ new DateObj(2000, 2, 28), new DateObj(2000, 2, 29) },
				{ new DateObj(2000, 2, 29), new DateObj(2000, 3, 1) },
				{ new DateObj(2019, 2, 28), new DateObj(2019, 3, 1) }
			});
		}
		
		@Test
	    public void verify_nextdate_functionality() {
	        assertEquals(expectedTomorrow, today.nextDate());
	    }
		
}