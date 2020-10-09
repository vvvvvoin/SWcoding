package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Exam11_2000 {
	static BufferedReader br;
	static HashMap<Integer, Integer> map;
	static int firstNum;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<Integer, Integer>();
		
		firstNum = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= firstNum; i++) {
			int num1 = firstNum;
			int num2 = i;
			int cnt = 2;
			int temp = 0;
			while(true) {
				if(num1 - num2 >= 0 ) {
					cnt++;
					temp = num1;
					num1 = num2;
					num2 = temp - num2;
				}else {
					break;
				}
			}
			map.put(i, cnt);
		}
		int max = 0;
		int maxKey = 0;
		for(int key : map.keySet()) {
			if(max < map.get(key)) {
				max = map.get(key);
				maxKey = key;
			}
		}
		
		System.out.println(max);
		String str = "";
		int num1 = firstNum;
		int num2 = maxKey;
		int temp = 0;
		str += firstNum + " "  + maxKey  + " ";
		while(true) {
			if(num1 - num2 >= 0 ) {
				temp = num1;
				num1 = num2;
				num2 = temp - num2;
				str += num2 + " ";
			}else {
				break;
			}
		}
		System.out.println(str.trim());
	}
}
