package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam36 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		for(int i = 0 ; i < n; i++) {
			int m = Integer.valueOf(br.readLine());
			String[] arr = new String[m];
			for(int j = 0 ; j < m; j++) {
				arr[j]=br.readLine();
			}
			boolean flag = false;
			Arrays.sort(arr);
			for(int j = 1 ; j < m; j++) {
					if(arr[j].startsWith(arr[j - 1])) {
						bw.write("NO\n");
						flag = true;
						break;
					}
			}
			if(flag == false) bw.write("YES\n");
		}
		bw.flush();
		bw.close();
	}
}
