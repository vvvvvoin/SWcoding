package programers_Lv3;

import java.util.ArrayList;

// [1차] 추석트래픽
public class Exam00 {
//	static String[] lines = { "2016-09-15 01:00:04.001 2.0s","2016-09-15 01:00:07.000 2s" };
//	static String[] lines = { "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" };
	static String[] lines = { "2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"};
	public static void main(String[] args) {
		ArrayList<Time> arrayList = new ArrayList<Time>();
		for(int i = 0; i < lines.length; i++) {
			String[] str = lines[i].split(" ");
			String[] t = str[1].split(":");
			String[] m = t[2].split("\\.");
			arrayList.add(new Time(str[0], t[0], t[1], m[0], m[1], (str[2].replace("s", ""))));
		}
		
		System.out.println(arrayList);
		int startTime = (int) Double.parseDouble(arrayList.get(0).start);
		int endTime = (int) Double.parseDouble(arrayList.get(arrayList.size() - 1).end);
		int answer = 0;
//		while(true) {
//			if(startTime >= endTime ) break;
//			int cnt = 0;
//			
//			String time = startTime + "";
//			time = makeCorrect(time);
//			String end = String.valueOf(Integer.parseInt(time) + 1);
//			end = makeCorrect(end);
//			//시작과 끝 변수 값을 테스트케이스2번과 같이 햅자
//			for(int j = 0; j < arrayList.size(); j++) {
//				//System.out.println(arrayList.get(j));
//				 if(Double.parseDouble(time) > Double.parseDouble(arrayList.get(j).start) && 
//						Double.parseDouble(end) <  Double.parseDouble(arrayList.get(j).end)) {
//					cnt++;
//				}else if(Double.parseDouble(time) < Double.parseDouble(arrayList.get(j).start) && 	Double.parseDouble(end) > Double.parseDouble(arrayList.get(j).start) ||
//						Double.parseDouble(time) < Double.parseDouble(arrayList.get(j).end) && Double.parseDouble(end) > Double.parseDouble(arrayList.get(j).end) ) {
//					cnt++;
//				}
//			}
//			System.out.println("time = " + time + "  time + 1 = " + end + "  cnt = " + cnt);
//			startTime =  Integer.parseInt(time) + 1;
//			if(answer < cnt) {
//				answer = cnt;
//			}
//		}
		for(int i = 0; i < arrayList.size() - 1; i++) {
			int cnt = 0;
			String sTime = arrayList.get(i).end;
			if(i == 0) sTime = arrayList.get(i).start;
			String eTime = String.valueOf(Double.parseDouble(sTime) + 1);
			eTime = makeCorrect(eTime);
			for(int j = 0; j < arrayList.size(); j++) {
				System.out.println("time = " + sTime + "  time + 1 = " + eTime + "  cnt = " + cnt);
				 if(Double.parseDouble(sTime) > Double.parseDouble(arrayList.get(j).start) && 
						Double.parseDouble(eTime) <  Double.parseDouble(arrayList.get(j).end)) {
					cnt++;
				}else if(Double.parseDouble(sTime) <= Double.parseDouble(arrayList.get(j).start) && 	Double.parseDouble(eTime) > Double.parseDouble(arrayList.get(j).start) ||
						Double.parseDouble(sTime) <= Double.parseDouble(arrayList.get(j).end) && Double.parseDouble(eTime) > Double.parseDouble(arrayList.get(j).end) ) {
					cnt++;
				}
			}
			if (answer < cnt) {
				answer = cnt;
			}
		}
		
		
		System.out.println(answer);
	}
	
	static String makeCorrect(String time) {
		if(time.substring(4, time.length()).equals("60")) {
			time = String.valueOf(Integer.parseInt(time.substring(0, 4)) + 1) + "00";
		}
		//분
		if(time.substring(2, 4).equals("60")) {
			String temp = time.substring(4, time.length());
			time = String.valueOf(Integer.parseInt(time.substring(0, 2)) + 1) + "00" + temp;
		}
		return time;
	}
	
	static class Time{
		private String date;
		private int hour;
		private int min;
		private int sec;
		private double mSec;
		private String maintain;
		private String start;
		private String end;
		
		public Time(String date, String hour, String min, String sec, String mSec, String maintain) {
			super();
			this.date = date;
			this.hour = Integer.parseInt(hour);
			this.min = Integer.parseInt(min);
			this.sec = Integer.parseInt(sec);
			this.mSec = Double.parseDouble("0." + mSec);
			this.maintain = maintain;
			this.end = end();
			this.start = start();
		}

		private String start() {	
			String sec = String.valueOf((double)(this.sec + this.mSec) - Double.parseDouble(this.maintain));
			String min = "";
			if(Double.parseDouble(sec) < 0) {
				this.min -= 1;
				sec = String.valueOf(Double.parseDouble(sec) + 60);
				if(this.min < 0) {
					this.hour -=1;
					this.min += 60;
				}
			}
			if(this.min < 10) {
				min = "0" + this.min;
			}else if(this.min == 0) {
				min = "00";
			}else if(this.min >= 10) {
				min = String.valueOf(this.min);
			}
			sec = String.valueOf(Math.round((Double.parseDouble(sec) + 0.001) * 1000 )/ 1000.0);
			if(Double.parseDouble(sec) < 10) {
				sec = "0" + sec;
			}
			return this.hour + min + String.valueOf(sec);
		}

		private String end() {
			String min = "";
			if(this.min < 10) {
				min = "0" + this.min;
			}else {
				min = String.valueOf(this.min);
			}
			String sec = (double)(this.sec + this.mSec) + "";
			if(Double.parseDouble(sec) < 10) {
				sec = "0" + sec;
			}
			return this.hour + min + sec;
		}

		@Override
		public String toString() {
			return "Time [date=" + date + ", hour=" + hour + ", min=" + min + ", sec=" + sec + ", mSec=" + mSec
					+ ", maintain=" + maintain + ", start=" + start + ", end=" + end + "]";
		}

		
		
	}

}

