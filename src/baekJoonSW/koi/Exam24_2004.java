package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exam24_2004 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static HashMap<String, String> map = new HashMap<String, String>();
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map.put("000000" ,"A");
		map.put("001111", "B");
		map.put("010011", "C");
		map.put("011100", "D");
		map.put("100110", "E");
		map.put("101001", "F");
		map.put("110101", "G");
		map.put("111010", "H");

		String str = br.readLine();
		for(int i = 0; i < str.length(); i += 6) {
			list.add(str.substring(i, i + 6));
		}
		String answer = "";
		for(int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			if(map.containsKey(temp)) {
				answer += map.get(temp);
			}else {
				boolean check = false;
				String[] arr = temp.split("");
				for(int j = 0; j < arr.length; j++) {
					String s = change(arr, j);
					if(map.containsKey(s)) {
						check = true;
						answer += map.get(s);
						break;
					}
					change(arr, j);
				}
				if(check == false) {
					System.out.println(i + 1);
					return;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static String change(String[] arr, int index) {
		if(arr[index].equals("1")) {
			arr[index] = "0";
		}else {
			arr[index] = "1";
		}
		String str = "";
		for(String value : arr) {
			str += value;
		}
		return str;
	}
}
