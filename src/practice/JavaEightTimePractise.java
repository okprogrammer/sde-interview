package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class JavaEightTimePractise {

	public static void main(String[] args) throws ParseException {

		// LocalTime, LocalDateTime, DateTime
//		System.out.println(LocalTime.now());
//		System.out.println(LocalDateTime.now());
//		System.out.println(LocalDate.now());
		LocalTime currentShipTime = LocalTime.parse("10:52 AM".toUpperCase(),
				DateTimeFormatter.ofPattern("h:mm a", Locale.US));
		LocalTime startTime = LocalTime.parse("3:30 pm".toUpperCase(),
				DateTimeFormatter.ofPattern("h:mm a", Locale.US));
		String endTime = LocalTime.parse("23:59".toUpperCase())
				.format(DateTimeFormatter.ofPattern("h:mm a", Locale.US));
		SimpleDateFormat s = new SimpleDateFormat("HH:mm");
		System.out.println(s.parseObject("23:59"));
		System.out.println(endTime);
//		if ((currentShipTime.isAfter(startTime) || currentShipTime.equals(startTime))
//				&& (currentShipTime.isBefore(endTime) || currentShipTime.equals(endTime))) {
//			System.out.println(true);
//		} else {
//			System.out.println(false);
//		}

	}

}
