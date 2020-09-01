package programers_Lv2;

public class Exam26 {
	static int[][] land = {{ 1, 2, 3, 5 },
								 { 5, 6, 7, 100 }, 
								 { 4, 3, 2, 1 } };
//	//static int[][] land = {{9, 5, 2, 3}, 
//								{9, 8, 6, 7}, 
//								{8, 9, 7, 1}, 
//								{100, 9, 8, 1}};
//	완전탐색을 제외하고 최대값으로 구하려고 했을때의 반례
//	| 01 | 02 | 03 | 04 |
//
//	| 20 | 16 | 12 | 10 |
//
//	| 88 | 38 | 22 | 11 |
// DP문제이다
//	상당히 어려운 문제였고, 최대값으로 풀려고 고집했는데
//	반례하나에 다 무너졌다
//	뭔가 잘 안된다고 느끼면 방법을 바꿀수 있는 노력이 필요하다
	
	public static void main(String[] args) {
		for (int i = 1; i < land.length; i++) {
			land[i][0] += whoMax(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
			land[i][1] += whoMax(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
			land[i][2] += whoMax(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
			land[i][3] += whoMax(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
		}

		int answer = whoMax(land[land.length - 1][0], land[land.length - 1][1], land[land.length - 1][2],
				land[land.length - 1][3]);
		System.out.println(answer);
	}

	static Integer whoMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	static Integer whoMax(int a, int b, int c, int d) {
		return Math.max(a, Math.max(b, Math.max(c, d)));
	}
}
