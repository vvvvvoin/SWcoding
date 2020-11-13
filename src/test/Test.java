package test;

public class Test {

	public static void main(String[] args) {
		int n = 3;
		int[] arr = { 1, 2, 3 };
		int[] output = new int[2];
		boolean[] visited = new boolean[n];
		
		perm(arr, output, visited, 0, 2);
		comb(arr, visited, 0, 2);
	}

	private static void comb(int[] arr, boolean[] visited, int start, int n) {
		if(n == 0) {
			for(int i = 0 ; i < visited.length; i++) {
				if(visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
		
		for(int i = start; i < arr.length; i++) {
			visited[i] = true;
			comb(arr, visited, i + 1, n - 1);
			visited[i] = false;
		}
		
	}

	private static void perm(int[] arr, int[] output, boolean[] visited, int dept, int n) {
		if(n == dept) {
			String str = "";
			for(int i = 0; i < output.length; i++) {
					str += output[i] + " ";
			}
			System.out.println(str);
			return;
		}
		
		
		for(int i = 0; i < arr.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				output[dept] = arr[i];
				perm(arr, output, visited, dept + 1, n);
				visited[i] = false;
			}
		}
	}

}
