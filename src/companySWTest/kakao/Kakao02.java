package companySWTest.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kakao02 {
	//static String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
	//static String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
	static String[] orders = {"XYZ", "XWY", "WXA"};
	static int[] course = { 2, 3, 4 };
	static HashMap<String, Integer> menu;
	public static void main(String[] args) {
		//만들 수 있는 조합의 HashMap을 만들어 넣는다
		//그리고 orders에 있는 각 요소마다 만들 수 있는 경우의 수를 만들어
		//HashMap에 값을 상승시킨다
		menu = new HashMap<String, Integer>();
		for (int i = 0; i < orders.length; i++) {
			String a = reverseStr(orders[i]);
			char[] temp = a.toCharArray();
			for(int j = 2; j <= orders[i].length(); j++) {
				boolean[] visited = new boolean[orders[i].length()];
				combination(temp, visited, 0, orders[i].length(), j);				
			}
        }
		ArrayList<String> answerList = new ArrayList<String>();
		for(int i = 0; i < course.length; i++) {
			int size = course[i];
			int max = 0;
			for(String key1 : menu.keySet()) {
				if(key1.length() == size) {
					if(max <= menu.get(key1)) {
						max = menu.get(key1);
					}
				}
			}
			for (String key2 : menu.keySet()) {
				if(max == 1) break;
				if (key2.length() == size) {
					if (menu.get(key2) == max) {
						answerList.add(key2);
					}
				}
			}
		}
		System.out.println(menu);
		Collections.sort(answerList);
		String[] answer = new String[answerList.size()];
		for(int i=0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
			System.out.println(answer[i]);
		}
		
	}
	
	public static String reverseStr(String str){
	      char[] ch = str.toCharArray();
	      Arrays.sort(ch);
	      return new StringBuilder(new String(ch)).toString();
	 }
	
	static void combination(char[] str, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	    	String temp = "";
	    	for (int i = 0; i < n; i++) {
	            if (visited[i]) {
	                temp += str[i];
	            }
	        }
	    	menu.put(temp, menu.getOrDefault(temp, 0) + 1);
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(str, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
}
