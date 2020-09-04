package programers_Lv2;


public class Exam37 {
	static int[] nums = {1,2,7,6,4 };
	static int answer = 0;

	public static void main(String[] args) {
		answer = 0;
		boolean[] visited = new boolean[nums.length];
		int[] temp = new int[nums.length];
		
        combination(nums, visited, 0, nums.length, 3);
        System.out.println(answer);

		
	}

	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
        	int temp = 0;
            for(int i = 0; i < arr.length; i++) {
            	if(visited[i] == true) {
            		temp += arr[i];
            	}
            }
            if(getPrimeNumber(temp)) {
            	answer++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

	static boolean getPrimeNumber(int value) {
		boolean flag = true;
		for (int i = 2; i < value; i++) {
			if (value % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
