package programers_Lv2;

import java.util.Stack;

import javax.jws.soap.SOAPBinding;

public class Exam42 {
	static int m = 8;
	static int n = 5;
//	static String[] board = { "CCBDE",
//										"AAADE", 
//										"AAABF",
//										"CCBBF" };
	// 문제에서 간과할 수 있는 것이 짝이 맞는 2 * 2가 아래 행으로 내려가는데
	// 이것을 아래서부터 계산해줘야 한다
	// 아래 케이스 그렇게 해야 해결된다
	static String[] board ={"HGNHU", 
									 "CRSHV", 
									 "UKHVL", 
									 "MJHQB", 
									 "GSHOT", 
									 "MQMJJ", 
									 "AGJKK", 
									 "QULKK"};


	static int answer = 0;
	static int[] moveI = {0, 0, 1, 1 };
	static int[] moveJ = {0, 1, 0, 1 };

	public static void main(String[] args) {
		answer = 0;
		Pos[][] array = new Pos[m][n];
		boolean[][] scoreCheck = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = new Pos(board[i].charAt(j) + "", i, j, false);
			}
		}
		int temp = 0;
		while (true) {
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if(!array[i][j].str.equals("")) {
						bfs(i, j, array, scoreCheck);
					}
				}
			}
			if(temp == answer) {
				break;
			}
			temp = answer;
			scoreCheck = initBoolean(scoreCheck);
			array = initArray(array);
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(array[i][j].str + " ");
				}
				System.out.println();
			}
		}
		System.out.println(answer);

	}

	private static Pos[][] initArray(Pos[][] array) {
		// 삭제표시가 되어있으면 존재하는 문자열을 삭제한다.
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(array[i][j].delete == true) {
					array[i][j].str = "";
					array[i][j].delete = false;
				}
			}
		}
		
		for(int i = m - 1; i >= 0; i--) {
			for(int j = 0; j < n; j++) {
				if(array[i][j].str.equals("")) {
					for(int k = i - 1; k >= 0; k--) {
						if(!array[k][j].str.equals("")) {
							array[i] [j].str = array[k][j].str;
							array[k][j].str = "";
							break;
						}
					}
				}
			}
		}
		
		
		return array;
	}

	private static boolean[][] initBoolean(boolean[][] scoreCheck) {
		for(int i = 0; i < scoreCheck.length; i++) {
			for(int j = 0; j < scoreCheck[0].length; j++) {
				scoreCheck[i][j] = false;
			}
		}
		return scoreCheck;
	}

	private static void bfs(int i, int j, Pos[][] array, boolean[][] scoreCheck) {
		boolean flag = true;
		String compare = array[i][j].str;
		for (int m = 0; m < 4; m++) {
			int nextI = i + moveI[m];
			int nextJ = j + moveJ[m];
			//if (nextI < array.length && nextJ < array[0].length && nextI >= 0 && nextJ >= 0) {
				if (!array[nextI][nextJ].str.equals(compare)) {
					flag = false;
					break;
				}
			//}
		}
		// 2*2 같은 문자일 경우
		if (flag) {
			for (int m1 = 0; m1 < 4; m1++) {
				array[i + moveI[m1]][j + moveJ[m1]].delete = true;
				if (scoreCheck[i + moveI[m1]][j + moveJ[m1]] == false) {
					scoreCheck[i + moveI[m1]][j + moveJ[m1]] = true;
					answer++;
				}
			}
		}

	}
	
	private static class Pos{
		private String str;
		private int i;
		private int j;
		private boolean delete;
		
		public Pos(String str, int i, int j, boolean delete) {
			super();
			this.str = str;
			this.i = i;
			this.j = j;
			this.delete = delete;
		}
	}
}
