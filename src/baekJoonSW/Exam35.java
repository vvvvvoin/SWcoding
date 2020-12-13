package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam35 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.valueOf(br.readLine());
		int[] arr =new int[size + 1];
		boolean[][] dp = new boolean[size + 1][size + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= size; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		for(int i = 1; i <= size; i++) {
			dp[i][i] = true;
		}
		
		for(int i = 1; i < size; i++) {
			if(arr[i] == arr[i + 1]) {
				dp[i][i+1] = true;
			}
		}
		
		for(int i = 2; i < size; i++) {
			for(int j = 1; j <= size - i ; j++) {
				if(arr[j] == arr[j + i] && dp[j+1][i + j -1] == true) {
					dp[j][j + i] = true;
				}
			}
		}
		
		int n = Integer.valueOf(br.readLine());
		for(int o = 0; o < n; o++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			if(dp[s][e])	bw.write("1\n");
			else bw.write("0\n");
	
		}
		bw.flush();
		bw.close();
	}
}
