package com.time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {

	public static void main(String[] args) {
//		LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime ldt = ZonedDateTime.now();

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(df.format(ldt));

		DateTimeFormatter df1 = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		System.out.println(df1.format(ldt));

		DateTimeFormatter df2 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss Z");
		System.out.println(df2.format(ldt));
	}

}
