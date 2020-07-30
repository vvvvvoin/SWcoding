package sw_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class EXAM03_MayAvg {
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st, st2;

		int n = Integer.parseInt(br.readLine());
		String[] array = new String[n];
		double[] resultArray = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = br.readLine();
		}

		int sum = 0;
		double avg = 0;
		double count = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(array[i], " ");
			int firstN = Integer.parseInt(st.nextToken());
			for (int j = 0; j < firstN; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			avg = (double) sum / firstN;

			st2 = new StringTokenizer(array[i], " ");
			int firstN2 = Integer.parseInt(st2.nextToken());
			for (int j = 0; j < firstN2; j++) {
				if (Integer.parseInt(st2.nextToken()) > avg) {
					count++;
				}
			}
			resultArray[i] = (count / firstN2) * 100;

			avg = 0;
			sum = 0;
			count = 0;
		}
		for(int i =0; i <n; i++) {
			System.out.printf("%.3f", resultArray[i]);
		}
	}

}