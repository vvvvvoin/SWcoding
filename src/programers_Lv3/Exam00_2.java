package programers_Lv3;

import java.util.ArrayList;

public class Exam00_2 {
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
			arrayList.add(new Time(lines[i]));
		}
		
		int cnt = 0;
		for(int i = 0; i < arrayList.size(); i++) {
			double startTime = arrayList.get(i).startTime;
			double endTime = arrayList.get(i).endTime;
			int forntMax = 0;
			int backMax = 0;
			for(int j = 0; j < arrayList.size(); j++) {
				double startsSection = Math.round((startTime+0.999)*1000)/1000.0;  
                double endSection = Math.round((endTime+0.999)*1000)/1000.0;
				 if(startTime <= arrayList.get(j).endTime && arrayList.get(j).startTime <= startsSection) {
					 forntMax++;
				 }
				 if(endTime <= arrayList.get(j).endTime &&  arrayList.get(j).startTime <= endSection) {
					 backMax++;
				 }

			}
			if(cnt < Math.max(forntMax, backMax)) {
				cnt = Math.max(forntMax, backMax);
            }
			
		}
		
		System.out.println(arrayList);
		System.out.println(cnt);
		
	}
	
	static class Time{
		private double startTime;
		private double endTime;
		
		public Time(String time) {
			String[] times = time.split(" ");
			String[] tempTime = times[1].split(":");
			
			double endTime = Double.parseDouble(tempTime[0]) * 60 * 60;
			endTime += Double.parseDouble(tempTime[1]) * 60;
			endTime += Double.parseDouble(tempTime[2]);
			this.endTime = endTime;
			
			tempTime = times[2].split("s");
			double startTime = endTime - Double.parseDouble(tempTime[0]);
			startTime += (double) 0.001;
			this.startTime = Math.round(startTime*1000) / 1000.0;
	
			
		}

		@Override
		public String toString() {
			return "Time [startTime=" + startTime + ", endTime=" + endTime + "]";
		}

		
		
	}
}
