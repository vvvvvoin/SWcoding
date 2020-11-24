package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//	eoy1313참고
public class Exam53_2015 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[m][m];
		int[] grw = new int[m * 2];
		for (int o = 0; o < n; o++) {
			st = new StringTokenizer(br.readLine());
			int value0 = Integer.parseInt(st.nextToken());
			int value1 = Integer.parseInt(st.nextToken());
			//0, 1 경계에 +1함으로써 값을 누적시켜가면
			//아래 for문에서 왼쪽아래부터 위로 오른족경계로 이동하면서 누적된 값을 이용할 수 있다 
			grw[value0] ++;
			grw[value0 + value1]++;
		}
		int start = 0;
		int sum = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			sum += grw[start++];
			arr[i][0] = sum;
		}
		for (int i = 1; i < arr.length; i++) {
			sum += grw[start++];
			arr[0][i] = sum;
		}
		//성장률은 왼쪽아래부터 위로가고 위쪽경계에 다다르면 왼쪽으로 성장률은 커저간다
		//문제 조건에 왼쪽, 왼쪽위, 위의 성장률에 맞게 나머지 부분이 성장하느데
		//성장률은 위쪽이 점차 커지는 모습을 갖기에 위쪽값을 대입하는게 가장 큰값이 된다.
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[i][j] = Math.max(arr[i - 1][j], Math.max(arr[i][j - 1], arr[i - 1][j - 1]));
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[i][j] + 1 + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
