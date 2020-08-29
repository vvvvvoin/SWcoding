package programers_Lv2;

public class Exam20 {
	static int[] numbers = { 1, 1, 1, 1, 1 };
	static int target = 3;
	////////////////////////////////////////////
	static int answer = 0;
	public static void main(String[] args) {
		int node = 0;
		dfs(0);
		
		System.out.println(answer );
	}

	static void dfs(int node) {
		if(node == 5) {
			int sum = 0;
			for(int number : numbers) {
				sum += number;
			}
			if(sum == target) {
				answer++;
			}
		}else {
			numbers[node] *= 1;
			dfs(node + 1);
			
			numbers[node] *= -1;
			dfs(node + 1);
			
		}
	
	}

}
