package programers_Lv2;

public class Exam21 {
	static int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
	//static int[][] board = { { 0, 0, 1, 1 }, { 1, 1, 1, 1 }};
	static int max = 0;

	public static void main(String[] args) {
		// DP 문제였는데
		// 점화법 이라는 방법을 모르면 효율성에서는 빵점이 나온다
		// 다시 한번 어떻게되는지 이해하고 넘어가는 편이 좋을거같다
		
		
		int max = 0;
		int[][] array = new int[board.length + 1][board[0].length + 1];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1)
					array[i + 1][j + 1] = 1;
				else
					array[i + 1][j + 1] = 0;
			}
		}
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array[0].length; j++) {
				if (array[i][j] == 1) {
					int min = Math.min(array[i - 1][j], array[i][j - 1]);
					min = Math.min(array[i - 1][j - 1], min);
					
					array[i][j] = min + 1;
					max = Math.max(max, array[i][j]);
				}
			}

		}
		System.out.println(max * max);

	}
//	for(int i = 0; i < board.length; i++) {
//		for(int j = 0; j < board[0].length; j++) {
//			find(i , j);
//		}
//	}
	//효율성 빵점이다
	static void find(int x, int y) {
		if(board[x][y] == 0) return;
		boolean flag = false;
		int cnt = 0;
		int nextX = x - 1;
		int nextY = y - 1;
		while(true) {			
			if(nextX + 1 < board.length && nextY + 1 < board[0].length) {
				cnt = 0;
				nextX += 1;
				nextY += 1;
				for(int i = x; i <= nextX; i++) {
					for(int j = y; j <= nextY; j++) {
						if(board[i][j] == 0 ) {
							flag = true;
							break;
						}
						cnt++;
					}
					if(flag) break;
				}
				if(flag) break;
				max = Math.max(max, cnt);
			}else {
				break;
			}
		}
		
		
	}
}
