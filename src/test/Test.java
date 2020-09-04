package test;

import java.util.ArrayList;
import java.util.Stack;

public class Test {
	static int[] arr = {50, 54, 56, 56 };
	public static void main(String[] args) {
		
		boolean[] visited = new boolean[arr.length];
		int start = 0;
		int size = arr.length;
		int r = 2;
		combination(arr, visited, start, size, r);
		
	}
	private static void combination(int[] arr, boolean[] visited, int start, int size, int n) {
		if(n == 0) {
			for(int i =0; i < arr.length; i++) {
				if(visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		
		for(int i = start; i < arr.length; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, size, n - 1);
			visited[i] = false;
		}

		
	}

}

