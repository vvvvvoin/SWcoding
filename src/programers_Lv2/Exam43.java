package programers_Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Exam43 {
	static int cacheSize = 3;
	// static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju",
	// "Pangyo", "Seoul", "NewYork", "LA"};
	static String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };

	public static void main(String[] args) {
		Queue<String> qu = new LinkedList<String>();
		int answer = 0;
		String city = "";
		for (String str : cities) {
			city = str.toLowerCase();
			if (qu.contains(city)) {
				answer++;
				qu.remove(city);
				if (qu.size() <= cacheSize) {
					qu.add(city);
				}
				if (qu.size() > cacheSize) {
					qu.poll();
				}
			} else {
				answer += 5;
				if (qu.size() <= cacheSize) {
					qu.add(city);
				}
				if (qu.size() > cacheSize) {
					qu.poll();
				}
			}

		}

		System.out.println(answer);
	}
}
