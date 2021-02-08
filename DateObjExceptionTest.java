package edu.depaul.se433.nextdate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import static org.junit.Assert.*;

/*
 * Assignment: #4
 * Topic: Parameterized Tests with DateObj
 * Author: Yusuf Talaty
 */

/**
 * 
 * Uses Parameterised Testing to verify illegal DateObj construction.
 *
 */
public class DateObjExceptionTest {

	@Test(expected = IllegalArgumentException.class)
	public void invalid_month_should_throw_exception() {
		DateObj today = new DateObj(2020, 44, 14);
		DateObj today1 = new DateObj(1998, 0, 13);
		DateObj today10 = new DateObj(2019, -1, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalid_day_should_throw_exception() {
		DateObj today2 = new DateObj(2008, 4, 31);
		DateObj today3 = new DateObj(2009, 2, 30);
		DateObj today11 = new DateObj(2020, 10, 65);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalid_year_should_throw_exception() {
		DateObj today4 = new DateObj(0, 3, 1);
		DateObj today5 = new DateObj(-1, 12, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalid_leap_year_should_throw_exception() {
		DateObj today6 = new DateObj(2009, 2, 29);
		DateObj today7 = new DateObj(2001, 2, 29);
		DateObj today12 = new DateObj(2019, 2, 29);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalid_number_of_days_should_throw_exception() {
		DateObj today8 = new DateObj(2020, 3, 32);
		DateObj today9 = new DateObj(1998, 1, 35);
		DateObj today13 = new DateObj(2007, 6, 31);
	}
	
}