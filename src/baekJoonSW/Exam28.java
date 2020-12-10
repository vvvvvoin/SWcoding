package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam28 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>(100);
		int n = Integer.valueOf(br.readLine());
		for(int i = 0 ; i < n; i++) {
			int value = Integer.valueOf(br.readLine());
			if(value != 0) {
				list.add(value);
			}else {
				list.remove(list.size() - 1);
			}
		}
		int answer = 0;
		for(int v : list) {
			answer += v;
		}
		System.out.println(answer);
	}
}
