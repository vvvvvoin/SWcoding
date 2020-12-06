package programers_Lv3;

public class Exam11 {
	static int m = 4;
	static int n = 3;
	static int[][] puddles = {{2, 2}};
	public static void main(String[] args) {
		int[][] dp = new int[n + 1][m + 1];
		for(int i = 0; i < puddles.length; i++) {
			for(int j = 0; j < puddles[0].length; j++) {
				dp[puddles[i][0]][puddles[i][1]] = -1;				
			}
		}
		
		dp[0][1] = 1;
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(dp[i][j] == -1)continue;
				if(dp[i - 1][j] != -1 && dp[i][j - 1] != -1) {
					dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000007; 									
				}else if(dp[i - 1][j] == -1 && dp[i][j - 1] != -1) {
					dp[i][j] = dp[i][j - 1] % 1000000007;
				}else if(dp[i - 1][j] != -1 && dp[i][j - 1] == -1) {
					dp[i][j] = dp[i - 1][j] % 1000000007;
				}
			}
		}
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println(dp[n][m] % 1000000007);
		
	}
}
