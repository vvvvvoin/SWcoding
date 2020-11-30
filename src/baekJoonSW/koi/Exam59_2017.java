package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam59_2017 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int TIME;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		TIME = Integer.parseInt(st.nextToken());
		arr = new int[n][4];
		dp = new int[n][TIME + 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
			arr[i][2] = Integer.parseInt(s[2]);
			arr[i][3] = Integer.parseInt(s[3]);
		}
		
		dp[0][arr[0][0]] = arr[0][1];
		dp[0][arr[0][2]] = Math.max(dp[0][arr[0][2]], arr[0][3]);


		int answer = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= TIME; j++) {
				if (dp[i - 1][j] == -1)	continue;
				else {
					//걷기 시간과 더했을 경우 제한시간 이내인 경우
					if (arr[i][0] + j <= TIME ) {
						//i번째의 걷기시간을 더해서 갱신시켜준다
						//그중 큰 것을 두가지로 나뉘는데
						//이전에 해당시간에서의 가치와 현재가치를 더했을 경우 바뀌는 시간과
						//이전에 다른 지점에서의 걷기와 자전거로 인해 다음 시간에 갔던 경우와 비교해서 큰 것을 넣어 갱신한다.
						dp[i][j + arr[i][0]] = Math.max(dp[i - 1][j] + arr[i][1], dp[i][j + arr[i][0]]);
						//answer = Math.max(answer, dp[i][j + arr[i][0]]);
					}
					
	                // i가 1일때 걷기는 이전에 가치를 찾을 수 없기에 이전 가치와 현재가치가 합쳐지게 된다.
					// 하지만 구간이 많아질 수록 겹치는 구간이 생길 수 있기 때문에 갱신될 때의 시간을 반드시 비교해야한다.
					
					// 자전거
					if (arr[i][2] + j <= TIME ) {
						dp[i][j + arr[i][2]] = Math.max(dp[i - 1][j] + arr[i][3], dp[i][j + arr[i][2]]);
						//answer = Math.max(answer, dp[i][j + arr[i][2]]);
					}
				}
				
			}

		}
		// 연산 중간에 최대값을 찾게 되면
		// 모든 경로를 다 들러야 하는데 중간에 최대 시간에 다다랐는데 우연치않게 최대에 이익값이 저장되면
		// 해당값을 최대값으로 정답을 반환한다.
		// 하지만 모든 경로를 다 돌아야 하기 때문에 다음 연산의 다른 수단이 해당 값에 시간을 더하면(arr[i][2] + j <= TIME) 이미 초괴되었기 떄문에
		//(만약 0일 경우에는 true가 되지만 다시 다음 것을 확인하면 초과될수 있음, 마지막에 0초도 최대이익이면 가능함
		// 해당값을 취급하지 않게 된다.
		// 그리고 마지막 경산에서 다뤄진 값만을 찾아 최대값을 반환시킨다.
		for(int i = 1; i<= TIME; i++) {
			answer = Math.max(answer, dp[n - 1][i]);
		}
		
		System.out.println(answer);
	}
}
