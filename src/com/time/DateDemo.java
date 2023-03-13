package com.time;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateDemo {

	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.isLeapYear(2020));
		System.out.println(gc.get(Calendar.DATE));
		gc.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));

		TimeZone tz = gc.getTimeZone();
		System.out.println(tz.getID());
	}

}
