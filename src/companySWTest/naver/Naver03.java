package companySWTest.naver;

import java.util.HashMap;

public class Naver03 {
	static HashMap<String, Integer> map;
	static long answer = 0;
	static int k = 5;
	public static void main(String[] args) {
		answer = 0;
		int[] howMany = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
		map = new HashMap<String, Integer>();
		for(int i = 0; i < 10; i++) {
			map.put(String.valueOf(i), howMany[i]);
		}
		
		int cnt = (k / 2) + 1;
		String max = "";
		for(int i = 0; i < cnt; i++) {
			max += "9";
		}
		for(int i = 0; i < Integer.parseInt(max); i++) {
			solution(i+"");
		}
		System.out.println(answer);
	}
	

	
	static void solution(String temp) {
		int sum = 0;
		boolean flag = false;
		for(int i = 0; i < temp.length(); i++) {
			sum += map.get(temp.charAt(i) + "");
			if(sum > k) {
				flag = true;
				break;
			}
		}
		
		if(flag == false) {
			if(sum == k) {
				
				System.out.println(temp);
				answer++;
			}
		}
		
	}


}
