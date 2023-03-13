package com.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class TimeApiDemo {

	public static void main(String[] args) {
		// util date
//		Date d = new Date();
//		System.out.println(d);
		// LocalDate dt = LocalDate.now();
//		LocalDate dt = LocalDate.now(Clock.systemDefaultZone());
//		LocalDate dt = LocalDate.now(ZoneId.of("Asia/Kolkata"));
//		LocalDate dt = LocalDate.of(2020, Month.MARCH, 10);
		LocalDate dt = LocalDate.parse("2020-01-03");
		LocalDate dt1 = dt.plusYears(9);
		LocalDate plusMonths = dt.plusMonths(6);
		System.out.println(dt1);
		System.out.println(plusMonths);

		System.out.println("*****************Time Practise*****************");
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		LocalTime minusHours = lt.minusHours(3);
		System.out.println(minusHours);
		int hour = lt.getHour();
		System.out.println(hour);
	}

}
