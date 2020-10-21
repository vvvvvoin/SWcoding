package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exam29_2006 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] student = new int[n][5];
		int[] cnt = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				student[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < student.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for(int j = 0; j < student[0].length; j++) {
				int clas = student[i][j];
				for(int k = 0; k < student.length; k ++) {
					if(student[k][j] == clas && i != k) {
						set.add(k);
					}
				}
			}
			cnt[i] = set.size();
		}
		int max = 0;
		int answer = 0;
		for(int i = 0; i < cnt.length; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
				answer = i;
			}
		}
		
		System.out.println(answer + 1);
	}

}
