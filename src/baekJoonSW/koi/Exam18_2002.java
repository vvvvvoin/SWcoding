package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exam18_2002 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] number;
	static String[] color;
	static boolean flag;
	static int max;
	public static void main(String[] args) throws Exception {		
		br = new BufferedReader(new InputStreamReader(System.in));
		flag = false;
		max = 0;
		color = new String[5];
		number = new int[5];
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			color[i] = st.nextToken();
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		rule01();
		rule02();
		rule03();
		rule04();
		rule05();
		rule06();
		rule07();
		rule08();
		if(flag == false) {
			max = Math.max(max, Arrays.stream(number).max().getAsInt() + 100);
		}
		System.out.println(max);
	}
	
	private static void rule08() {
		HashMap<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < 5; i++) {
			numberMap.put(number[i], numberMap.getOrDefault(number[i], 0) + 1);
		}
		for(int key : numberMap.keySet()) {
			if(numberMap.get(key) == 2) {
				flag = true;
				max = Math.max(max, key + 200);
			}
		}
	}

	private static void rule07() {
		HashMap<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < 5; i++) {
			numberMap.put(number[i], numberMap.getOrDefault(number[i], 0) + 1);
		}
		boolean flag1 = false;
		boolean flag2 = false;
		int key1 = 0;
		int key2 = 0;
		for(int key : numberMap.keySet()) {
			if(numberMap.get(key) == 2) {
				if(flag1 == false && flag2 == false) {
					key1 = key;
					flag1 = true;
				}else if(flag1 && flag2 == false) {
					key2 = key;
					flag2 = true;
				}			
			}
		}
		if(flag1 && flag2) {
			flag = true;
			max = Math.max(max, (key1 > key2) ? ((key1 * 10) + key2 + 300) : ((key2 * 10) + key1 + 300));
		}
		
	}

	private static void rule06() {
		HashMap<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < 5; i++) {
			numberMap.put(number[i], numberMap.getOrDefault(number[i], 0) + 1);
		}
		
		for(int key : numberMap.keySet()) {
			if(numberMap.get(key) == 3) {
				max = Math.max(max, key + 400);
				flag = true;
			}
		}
		
	}

	private static void rule05() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 5; i++) {
			list.add(number[i]);
		}
		Collections.sort(list);
		int value = list.get(0);
		boolean sameNum = true;
		for(int i = 1; i < list.size(); i++) {
			if(++value != list.get(i)) {
				sameNum = false;
				break;
			}
		}
		if(sameNum == true) {
			flag = true;
			max = Math.max(max, Arrays.stream(number).max().getAsInt() + 500);
		}
	}

	private static void rule04() {
		HashMap<String, Integer> colorMap = new HashMap<String, Integer>();
		for(int i = 0; i < 5; i++) {
			colorMap.put(color[i], colorMap.getOrDefault(number[i], 0) + 1);
		}
		
		if(colorMap.size() == 1) {
			flag = true;
			max = Math.max(max, Arrays.stream(number).max().getAsInt() + 600);
		}
	}

	private static void rule03() {
		HashMap<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < 5; i++) {
			numberMap.put(number[i], numberMap.getOrDefault(number[i], 0) + 1);
		}
		int value = 0;
		boolean flag01 = false;
		boolean flag02 = false;
		if(numberMap.size() == 2) {
			for(int key : numberMap.keySet()) {
				if(numberMap.get(key) == 3) {
					value += key * 10;
					flag01 = true;
				}else if(numberMap.get(key) == 2) {
					value += key + 700;
					flag02 = true;
				}
			}
		}
		if(flag01 && flag02) {
			max = Math.max(max, value);
			flag = true;
		}
	}

	private static void rule02() {
		HashMap<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < 5; i++) {
			numberMap.put(number[i], numberMap.getOrDefault(number[i], 0) + 1);
		}
		
		if(numberMap.size() == 2) {
			for(int key : numberMap.keySet()) {
				if(numberMap.get(key) == 4) {
					max = Math.max(max, key + 800);
					flag = true;
				}
			}
		}
		
	}

	private static void rule01() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<String, Integer> colorMap = new HashMap<String, Integer>();
		for(int i = 0; i < 5; i++) {
			list.add(number[i]);
			colorMap.put(color[i], colorMap.getOrDefault(color[i], 0) + 1);
		}
		Collections.sort(list);
		int value = list.get(0);
		boolean sameNum = true;
		for(int i = 1; i < list.size(); i++) {
			if(++value != list.get(i)) {
				sameNum = false;
				break;
			}
		}
		if(sameNum == true && colorMap.size() == 1) {
			max = Math.max(max, Arrays.stream(number).max().getAsInt() + 900);
			flag = true;
		}
	}
}
