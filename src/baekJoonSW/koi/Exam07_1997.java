package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Exam07_1997 {
	static BufferedReader br;
	static String[] output;
	static boolean[] visited;
	static HashSet<Integer> set;
	static ArrayList<Integer> list;
	static int min;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		output= new String[4];
		visited = new boolean[4];
		set = new HashSet<Integer>();
		list = new ArrayList<Integer>();
		String temp = "";
		for(int i = 1111; i <= 9999; i++) {
			temp = i + "";
			if(!temp.contains("0")) {
				set.add(solution01(temp));
			}
		}
		for(int value : set) {
			list.add(value);
		}
		Collections.sort(list);
		
		String input = br.readLine().replaceAll(" ", "");
		int index = solution01(input);
		System.out.println(list.indexOf(index) + 1);
		
	}
	
	static Integer solution01(String string) {
		String a, b, c, d = "";
		a = "" + string.charAt(0) + string.charAt(1) + string.charAt(2) + string.charAt(3) ;  
		b = "" + string.charAt(1) + string.charAt(2) + string.charAt(3) + string.charAt(0);  
		c = "" + string.charAt(2) + string.charAt(3) + string.charAt(0) + string.charAt(1);  
		d = "" + string.charAt(3) + string.charAt(0) + string.charAt(1) + string.charAt(2);
		return Math.min(Integer.parseInt(a), Math.min(Integer.parseInt(b),Math.min(Integer.parseInt(c), Integer.parseInt(d))));
	}

}
