package com.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;

public class ZonedDateTimeDemo {

	public static void main(String[] args) {
		ZonedDateTime zdt1 = ZonedDateTime.now();
		System.out.println(zdt1);
		ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(zdt2);
		MonthDay md = MonthDay.now();
		System.out.println(md);
		Period p = Period.of(2, 2, 10);
		Temporal addTo = p.addTo(LocalDate.now());
		System.out.println(addTo);
		Instant i = Instant.now();
		System.out.println(i);
	}

}
