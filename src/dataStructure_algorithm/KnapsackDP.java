package dataStructure_algorithm;

public class KnapsackDP {
	static int[] w = {10, 20, 30};
	static int[] v = {60, 100, 120};
	static int k = 50;
	
	public static void main(String[] args) {
		Gem[] arr = new Gem[w.length + 1];
		for(int i = 1; i < arr.length; i++) {
			arr[i] = new Gem(v[i - 1], w[i - 1]);
		}
		
		int[][] dp = new int[w.length + 1][k + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(j - arr[i].weight >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i].weight] + arr[i].value);					
				}else {
					dp[i][j] = dp[i- 1][j];
				}
			}
		}
		System.out.println(dp[v.length][k]);
	}
	
	private static class Gem {
		int value;
		int weight;
		public Gem(int value, int weight) {
			super();
			this.value = value;
			this.weight = weight;
		}		
	}
}
