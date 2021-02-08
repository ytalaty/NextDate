package edu.depaul.se433.nextdate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/*
 * Assignment: #3
 * Topic: Unit Testing using Dates
 * Author: Yusuf Talaty
 */

public class DateObjTest {

	@Test
	@DisplayName("Should return next day in past and future")
	void simplestNextDate() {
		DateObj today = new DateObj(2019, 4, 14);
		DateObj tomorrow = today.nextDate();
		assertEquals(new DateObj(2019, 4, 15), tomorrow);
		DateObj today5 = new DateObj(1999, 11, 20);
		DateObj tomorrow3 = today5.nextDate();
		assertEquals(new DateObj(1999, 11, 21), tomorrow3);
		DateObj today6 = new DateObj(2020, 3, 31);
		DateObj tomorrow6 = today6.nextDate();
		assertEquals(new DateObj(2020, 4, 1), tomorrow6);
	}
	
	@Test
	@DisplayName("Should return next month in simplest case")
	void simplestMonthCase() {
		DateObj today1 = new DateObj(2019, 10, 31);
		DateObj tomorrow1 = today1.nextDate();
		assertEquals(new DateObj(2019, 11, 1), tomorrow1);
		DateObj today2 = new DateObj(1999, 5, 31);
		DateObj tomorrow2 = today2.nextDate();
		assertEquals(new DateObj(1999, 6, 1), tomorrow2);
	}
	
	@Test
	@DisplayName("Should return next month and next year in simplest case")
	void simplestYearCase() {
		DateObj today2 = new DateObj(2019, 12, 31);
		DateObj tomorrow2 = today2.nextDate();
		assertEquals(new DateObj(2020, 1, 1), tomorrow2);
		DateObj today3 = new DateObj(1998, 12, 31);
		DateObj tomorrow3 = today3.nextDate();
		assertEquals(new DateObj(1999, 1, 1), tomorrow3);
	}
	
	@Test
	@DisplayName("Should fail when creating invalid dates")
	void exceptionTest() {
		try {
		      DateObj today3 = new DateObj(2020, 44, 14);
		      fail("Can't create a date with invalid month.");
		    } catch (IllegalArgumentException e) { }
		try {
		      DateObj today4 = new DateObj(2020, 4, 40);
		      fail("Can't create a date with invalid day.");
		    } catch (IllegalArgumentException e) { }
		try {
			DateObj today8 = new DateObj(2020, 3, 32);
			fail("Invalid number of days in the month of March.");
		} catch (IllegalArgumentException e) { }
		try {
			DateObj today9 = new DateObj(2019, 2, 29);
			fail("Invalid Leap year.");
		} catch (IllegalArgumentException e) { }
		try {
			DateObj today10 = new DateObj(-1, 2, 28);
			fail("Can't create a date with invalid year.");
		} catch (IllegalArgumentException e) { }
	}
	
	@Test
	@DisplayName("should handle leap years correctly")
	void leapYearCase() {
		DateObj today6 = new DateObj(2000, 2, 28);
		DateObj tomorrow4 = today6.nextDate();
		assertEquals(new DateObj(2000, 2, 29), tomorrow4);
		assertEquals(new DateObj(2000, 3, 1), tomorrow4.nextDate());
		DateObj today7 = new DateObj(2008, 2, 28);
		DateObj tomorrow7 = today7.nextDate();
		assertEquals(new DateObj(2008, 2, 29), tomorrow7);
	}
	
	@Test
	@DisplayName("should handle non leap years correctly")
	void nonleapYearCase() {
		DateObj today9 = new DateObj(2019, 2, 28);
		DateObj tomorrow9 = today9.nextDate();
		assertEquals(new DateObj(2019, 3, 1), tomorrow9);
		DateObj today10 = new DateObj(2001, 2, 28);
		DateObj tomorrow10 = today10.nextDate();
		assertEquals(new DateObj(2001, 3, 1), tomorrow10);
	}
}
