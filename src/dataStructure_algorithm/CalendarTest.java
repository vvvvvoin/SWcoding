package dataStructure_algorithm;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		final int[] TIME_UNIT= {3600, 60, 1};
		final String[] TIME_UNIT_NAME = {"시 ", "분 ", "초 "};
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(Calendar.HOUR_OF_DAY, 3);
		c1.set(Calendar.MINUTE, 20);
		c1.set(Calendar.SECOND, 30);
		
		long difference = Math.abs(c1.getTimeInMillis() - c2.getTimeInMillis()) / 1000;
		String temp = "";
		for(int i = 0; i < TIME_UNIT.length; i++) {
			temp += difference / TIME_UNIT[i] + TIME_UNIT_NAME[i];
			difference %= TIME_UNIT[i];
		}
		System.out.println(temp);
	}
}