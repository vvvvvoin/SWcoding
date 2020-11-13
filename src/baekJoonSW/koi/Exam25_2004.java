package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//눈금 6개
//눈금의 색은 빨,파,노랑이 각각 두 개씩 존재
public class Exam25_2004 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		
		double currentD = n;
		
		for(int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = i;
			arr[b] = i;
		}
		
		for(int i = 1; i <= 3; i++) {			
			int cnt = 0;
			int indexA = 0;
			int indexB = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == i) {
					cnt++;
					if(cnt == 1)indexA = j;
					if(cnt == 2)indexB = j;
				}
			}
			
			if(cnt == 2) {
				
				double left = (double)(indexB + indexA) / 2;
				double right = (double)(currentD - left);

				if(left < right) {
					currentD -= left;
					int size = (int) Math.ceil(right);
					int[] temp = new int[size + 1];
					int c = 1;
					for(int j = (int) left + 1; j < arr.length; j++) {
						temp[c] = arr[j];
						c++;
					}
					c = 1;
					for(int j = (int) left; j >=0; j--) {
						temp[c] = arr[j];
						c++;
					}
					arr = temp;
				}else {
					currentD -= right ;
					int size = (int) Math.ceil(left);
					int[] temp = new int[size + 1];
					int c = size;
					for(int j = 0; j < temp.length; j++) {
						temp[j] = arr[j];
					}
					c = size;
					for(int j = size; j < arr.length; j++) {
						temp[c] = arr[j];
						c--;
					}
					arr = temp;
				}
			}
		}

		System.out.println(currentD);

	}
}
