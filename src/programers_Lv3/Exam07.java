package programers_Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class Exam07 {
	static int n = 6;
	static int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

	public static void main(String[] args) {
		int[] distance = new int[n + 1];
		boolean[][] arr = new boolean[n + 1][n + 1];
		for (int i = 0; i < edge.length; i++) {
			int a = edge[i][0];
			int b = edge[i][1];
			arr[a][b] = true;
			arr[b][a] = true;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		int maxDistance = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			// 1부터 시작할 필요 없음
			for (int i = 2; i < arr.length; i++) {
				// 연결되어 있고 계산된 값이 없는 경우
				if (arr[node][i] == true && distance[i] == 0) {
					// 현재 노드로부터 1떨어저있음
					distance[i] = distance[node] + 1;
					// 첫 시작이 1이였으므로 그 중 거리가 가장 큰 값을 지속적으로 갱신시킨다.
					maxDistance = Math.max(maxDistance, distance[i]);
					q.add(i);
				}
			}
		}

		int cnt = 0;
		for (int d : distance) {
			if (maxDistance == d)
				cnt++;
		}
		System.out.println(cnt);
	}

}
