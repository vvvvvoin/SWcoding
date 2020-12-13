package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam34 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int answer = 0;
		String[] arr = br.readLine().split("-");
		for (int i = 0; i < arr.length; i++) {
			int temp = 0;

			String[] plusArr = arr[i].split("\\+");
			for (int j = 0; j < plusArr.length; j++) {
				temp += Integer.valueOf(plusArr[j]);
			}

			if (i == 0) {
				answer = temp;
			} else {
				answer -= temp;
			}
		}
		System.out.println(answer);
	}
}
