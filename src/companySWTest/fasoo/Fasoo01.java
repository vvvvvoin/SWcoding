package companySWTest.fasoo;

import java.util.HashMap;

public class Fasoo01 {
	static String s=  "{cpp{java}}{python}";
	static int[] idx = {0, 4, 9, 10, 11, 18};	
	public static void main(String[] args) {
		int[] answer = new int[idx.length];
		
		HashMap<Integer, Integer> map01 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map02 = new HashMap<Integer, Integer>();
		int point = s.lastIndexOf("{");
		for(int i = 0; i < s.length(); i++) {
			if(i > point) break;
			if(s.charAt(i) == '{') {
				int left = 1;
				int right = 0;
				for(int j = i + 1; j < s.length(); j++) {
					if(s.charAt(j) == '{') {
						left++;
					}else if(s.charAt(j) == '}') {
						right++;
					}
					if(left == right) {
						map01.put(i, j);
						map02.put(j, i);
						break;
					}
				}
			}
		}
		for(int i = 0; i < idx.length; i++) {
			if(map01.containsKey(idx[i])) {
				answer[i] = map01.get(idx[i]);
			}else if(map02.containsKey(idx[i])) {
				answer[i] = map02.get(idx[i]);
			}
		}
		for(int a : answer) {
			System.out.print(a + "  ");
		}
	}
	
}
