package programers_Lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Exam08 {
	//static String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
	static String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
	static StringBuilder sb;
	static ArrayList<String> list = new ArrayList<>();
	
	static boolean[] number;
	
	public static void main(String[] args) {
		number = new boolean[tickets.length];
		
		dfs(0, "ICN", "ICN");
		Collections.sort(list);
		System.out.println(list);
		String[] answer = list.get(0).trim().split(" ");
		System.out.println(answer);
	}
	
	private static void dfs(int cnt, String start, String answer) {
		if(cnt == tickets.length) {
			list.add(answer);
			return;
		}
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i][0].equals(start) && number[i] == false){
				number[i] = true;
				dfs(cnt + 1, tickets[i][1], answer + " " +tickets[i][1]);
				number[i] = false;
			}
		}
	}
}
