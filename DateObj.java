package edu.depaul.se433.nextdate;

import java.util.Calendar;
import java.util.Date;
/*
 * Assignment: #3
 * Topic: Unit Testing using Dates
 * Author: Yusuf Talaty
 */

/**
 * Implements a next date function for the sake of learning
 * unit test strategies.
 */
public class DateObj {
	
	private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private int year;
	private int month;
	private int day;
	
	public DateObj(int year, int month, int day) {
		if (month < 1 || month > 12)      throw new IllegalArgumentException();
		if (day < 1 || day > DAYS[month]) throw new IllegalArgumentException();
		if (year <= 0) throw new IllegalArgumentException();
		if (month == 2 && day == 29 && !isLeapYear(year)) throw new IllegalArgumentException();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	private static boolean isLeapYear(int year) {
		if (year % 400 == 0) return true;
		if (year % 100 == 0) return false;
		return year % 4 == 0;
	}
	
	private static boolean isValid(int month, int day, int year) {
		if (month < 1 || month > 12)      return false;
		if (day < 1 || day > DAYS[month]) return false;
		if (month == 2 && day == 29 && !isLeapYear(year)) return false;
		return true;
	}
	
	public DateObj nextDate() {
		if (isValid(month, day + 1, year) ) return new DateObj(year, month, day + 1);
		else if (isValid(month + 1, 1, year)) return new DateObj(year, month + 1, 1);
		else return new DateObj(year + 1, 1, 1);
	}
	
	public Date asDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		Date date = cal.getTime();
		return date;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (! (other instanceof DateObj)) {
			return false;
		}
		DateObj otherDate = (DateObj) other;
		
		return (otherDate.year == year) && (otherDate.month == month) && (otherDate.day == day);
		
	}
	
	@Override
	public String toString() {
		return String.format("Date[year: %d, month: %d, day: %d]", year, month, day);
	}

}
