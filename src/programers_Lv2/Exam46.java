package programers_Lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exam46 {
//	static String m = "ABCDEFG";
//	static String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//	static String m = "CC#BCC#BCC#BCC#B";
//	static String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
//	static String m = "ABC";
//	static String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//	static String m = "C#D#F#";
//	static String[] musicinfos = {"13:00,13:10,HELLO,A#C#DFA#C#D#", "13:30,13:35,WORLD,A#C#D#F#ABC"};
	static String m = "A#";
	static String[] musicinfos = {"13:00,13:02,HAPPY,B#A#"};

	public static void main(String[] args) {
		ArrayList<Music> music = new ArrayList<Music>();
		ArrayList<Music> answerList = new ArrayList<Music>();
		
		String[] tab = m.split("");
		ArrayList<String> tabArrayList = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		boolean flag2 = false;
		for(int i =  tab.length - 1; i >= 0; i--) {
			if(tab[i].equals("#")) {
				flag2 = true;
			}else {
				if(flag2 == true) {
					stack.add(tab[i] + "#");	
					flag2 = false;
				}else {
					stack.add(tab[i]);
				}
			}
		}
		while(!stack.isEmpty()) {
			tabArrayList.add(stack.pop());
		}
				
		for(String str : musicinfos) {
			String[] temp = str.split(",");
			music.add(new Music(temp[0], temp[1], temp[2], temp[3]));
		}

		for(int k = 0; k < music.size(); k++) {
			boolean flag = false;
			for(int i = 0; i < music.get(k).tab.length; i++) {
				if(music.get(k).tab[i].equals(tabArrayList.get(0))) {
					int cnt = 0;
					for(int j = i; j < music.get(k).tab.length; j++) {
						if(music.get(k).tab[j].equals(tabArrayList.get(cnt))) {
							cnt++;
						}else {
							cnt = 0;
						}
						if(cnt == tabArrayList.size()) {
							answerList.add(music.get(k));
							flag = true;
							break;
						}
					}
				}
				if(flag) {
					break;
				}
			}
		}
		// 조건이 일치하는 음악이 여러개 인가?
		if(answerList.size() > 1) {
			int max = 0;
			int cnt = 0;
			for(int k = 0; k < answerList.size(); k++) {
				if(max <= answerList.get(k).realPlay) {
					max = answerList.get(k).realPlay;
					cnt++;
				}
			}
			if(cnt == 1) {
				for(int k = 0; k < answerList.size(); k++) {
					if(max == answerList.get(k).realPlay) {
						System.out.println("조건이 겹처 가장 길게 플레이된 음원");
						System.out.println(answerList.get(k).song);
					}
				}
			}else {
				for(int k = 0; k < answerList.size(); k++) {
					if(max == answerList.get(k).realPlay) {
						System.out.println("조건이 겹처 가장 먼저 나온 곡");
						System.out.println(answerList.get(k).song);
					}
				}
			}
			
		}else if(answerList.size() == 1){
			System.out.println("하나의 정답");
			System.out.println(answerList.get(0).song);
		}else {
			System.out.println("일치되는 곡 없음");
			System.out.println("None");
		}
		
		System.out.println(music.get(0).tab[0]);
		System.out.println(tabArrayList.get(0));
	}

	static class Music{
		String startTime;
		String endTime;
		String song;
		String[] tab;
		int realPlay;
				
		public Music(String startTime, String endTime, String song, String tab) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
			this.song = song;
			this.tab = makeTab(tab);
		}

		private String[] makeTab(String m) {
			int hour = 0;
			int min = 0;
			String[] start = startTime.split(":");
			String[] end = endTime.split(":");
			hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
			min = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
			min += hour * 60;
			this.realPlay = min;
			Stack<String> stack = new Stack<String>();
			
			
//			while(true){
//				if (m.charAt(cnt % m.length()) == '#') {
//					stack.add(stack.pop() + "#");
//					cnt++;
//				}else {
//					stack.add(m.charAt(cnt % m.length()) + "");
//					cnt++;
//				}
//				
//				if(stack.size() == min) break;
//			}
//			
//			String[] returnArray = new String[stack.size()];
//			for (int i = returnArray.length - 1; i >= 0; i--) {
//				returnArray[i] = stack.pop();
//			}
			
			int cnt = 0;
			String[] s = m.split("");
			for(int i = 0; i < s.length; i++) {
				if(s[i].equals("#")) {
					s[i] = "";
					s[i - 1] += "#";
				}
			}
			ArrayList<String> array = new ArrayList<String>();
			while(true) {
				if(!s[cnt].equals("")) {
					array.add(s[cnt]);
				}
				cnt++;
				if(cnt == s.length) break;
			}


			
			if(min >array.size()) {
				int size = array.size();
				for(int i = array.size(); i < min; i++) {
					array.add(array.get(i % size));
				}
				String[] returnArray = new String[array.size()];
				for(int i = 0; i < returnArray.length; i++) {
					returnArray[i] = array.get(i);
					System.out.print(returnArray[i] + " ");
					
				}
				System.out.println();
				return returnArray;
			}else {
				String[] returnArray = new String[min];
				for(int i = 0; i < returnArray.length; i++) {
					returnArray[i] = array.get(i);
					System.out.print(returnArray[i] + " ");
				}
				System.out.println();
				return returnArray;
			}
			
		}

		
	}
}



