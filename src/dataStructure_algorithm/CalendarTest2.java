package dataStructure_algorithm;

import java.util.Calendar;

public class CalendarTest2 {

	public static void main(String[] args) {
		final int YEAR = 2020;
		final int MONTH = 11;
		
		Calendar sc = Calendar.getInstance()		;
		Calendar ec = Calendar.getInstance()		;
		
		// Calendar 0이 1월이므로 -1을 해줘 지정한 월에 맞춘다
		sc.set(YEAR, MONTH - 1, 1);
		// 원하는 달력에 다음달 1일을 지정
		ec.set(YEAR, MONTH, 1);
		// 다음달에 1일을 빼 현재달의 마지막일을 지정하준다
		ec.add(Calendar.DATE, -1);
		// 마지막 일 설정
		int end_day = ec.get(Calendar.DATE);
		// 현재달의 시작 요일을 받는다
		int START_WEEK = sc.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("       "+YEAR + " 년   "+ MONTH + " 월");
		System.out.println(" SU  MO  TU  WE  TH  FR  SA");
		
		// 시작 요일만큼 공백을 미리 추가
		for(int i = 1; i < START_WEEK; i++) {
			System.out.print("      ");
		}
		for(int i = 1, n = START_WEEK; i <= end_day; i++, n++) {
			System.out.print(i < 10 ?   "    " + i : "  "+ i);
			if(n % 7 ==0) System.out.println();
		}
	}

}
