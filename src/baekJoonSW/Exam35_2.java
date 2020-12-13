package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam35_2 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.valueOf(br.readLine());
		int[] arr =new int[size];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < size; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		int n = Integer.valueOf(br.readLine());
		for(int o = 0; o < n; o++) {
			st = new StringTokenizer(br.readLine());
			boolean flag = false;
			int s = Integer.valueOf(st.nextToken()) - 1;
			int e = Integer.valueOf(st.nextToken()) - 1;
			for(int i = s, j = e; i < j; i++, j--) {
				if(arr[i] != arr[j]) {
					bw.write("0\n");
					flag = true;
					break;
				}
			}
			if(flag == false) bw.write("1\n");
			
		}
		
		bw.flush();
		bw.close();
	}
}
