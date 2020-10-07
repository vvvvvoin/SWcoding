package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Exam06_1997 {
	static BufferedReader br;
	static int[][] array;
	static ArrayList<Pos> list;
	public static void main(String[] args) throws Exception {
		//정올에서는 모든 테스트케이스를 통과하는데
		//백준에서는 실패한다.
		//워낙 자바로 푼사람이 없어서 개념잡기가 어렵다.
		br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<Pos>(); 
		array = new int[10][10];
		for(int i = 0; i < array.length; i++) {
			String temp = br.readLine();
			for(int j = 0; j < array[0].length; j++) {
				array[i][j] = Integer.parseInt(temp.charAt(j) + "");
			}
		}
		int cnt = 0;
		for(int i = 0; i < array.length; i++) {
			cnt = 0;
			for(int j = 0; j < array.length; j++) {
				if(array[i][j] == 1) {
					cnt++;
				}
			}
			if(cnt == 1) {
				for(int j = 0; j < array.length; j++) {
					if(array[i][j] == 1) {
						list.add(new Pos(i + 1 ,j + 1));
					}
				}
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			cnt = 0;
			for(int j = 0; j < array.length; j++) {
				if(array[j][i] == 1) {
					cnt++;
				}
			}
			if(cnt == 1) {
				for(int j = 0; j < array.length; j++) {
					if(array[j][i] == 1) {
						list.add(new Pos(j + 1 ,i + 1));
					}
				}
			}
		}
		if(list.size() == 3) {
			Collections.sort(list);
			if(solution03() == true) {
				System.out.println("0");
			}else {
				for(Pos value : list) {
					System.out.println(value.row + " " + value.col);
				}
			}
		}else if(list.size() == 2){
			boolean b = check();
			if(b == true) {
				//col의 작은 변수의 row가 다른 변수보다 작을 경우 \  true
				solution01();
			}else {
				//col의 작은 변수의 row가 다른 변수보다 클 경우 /  false
				solution02();
			}
			Collections.sort(list);
			if(solution03() == true) {
				System.out.println("0");
			}else {
				for(Pos value : list) {
					System.out.println(value.row + " " + value.col);
				}
			}
		}else {
			System.out.println("0");
		}
	}
	
	private static boolean solution03() {
		String temp = "";
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				temp += array[i][j];
			}
			if(temp.contains("101")) {
				return true;
			}
		}
		return false;
	}

	private static void solution02() {
		int rightToLeft = 0;
		int cnt = 0;
		while (rightToLeft < 10) {
			int row = 0;
			int col = rightToLeft;
			cnt = 0;

			while (true) {
				if (array[row][col] == 1) {
					cnt++;
				}
				row += 1;
				col -= 1;
				if (row < 0 || col < 0 || row >= array.length || col >= array.length)
					break;
			}
			if (cnt == 1) {
				row = 0;
				col = rightToLeft;
				while (true) {
					if (array[row][col] == 1) {
						list.add(new Pos(row + 1, col + 1));
						break;
					}
					row += 1;
					col -= 1;
				}
			}
			row = 9;
			col = rightToLeft;
			cnt = 0;

			while (true) {
				if (array[row][col] == 1) {
					cnt++;
				}
				row -= 1;
				col += 1;
				if (row < 0 || col < 0 || row >= array.length || col >= array.length)
					break;
			}
			if (cnt == 1) {
				row = 9;
				col = rightToLeft;
				while (true) {
					if (array[row][col] == 1) {
						list.add(new Pos(row + 1, col + 1));
						break;
					}
					row -= 1;
					col += 1;
				}
			}
			rightToLeft++;

		}	
	}

	private static void solution01() {
		int leftToRight = 9;
		int cnt = 0;
		while (leftToRight > 0) {
			int row = 0;
			int col = leftToRight;
			cnt = 0;

			while (true) {
				if (array[row][col] == 1) {
					cnt++;
				}
				row += 1;
				col += 1;
				if (row < 0 || col < 0 || row >= array.length || col >= array.length)
					break;
			}
			if (cnt == 1) {
				row = 0;
				col = leftToRight;
				while (true) {
					if (array[row][col] == 1) {
						list.add(new Pos(row + 1, col + 1));
						break;
					}
					row += 1;
					col += 1;
				}
			}
			
			row = 9;
			col = leftToRight;
			cnt = 0;

			while (true) {
				if (array[row][col] == 1) {
					cnt++;
				}
				row -= 1;
				col -= 1;
				if (row < 0 || col < 0 || row >= array.length || col >= array.length)
					break;
			}
			if (cnt == 1) {
				row = 9;
				col = leftToRight;
				while (true) {
					if (array[row][col] == 1) {
						list.add(new Pos(row + 1, col + 1));
						break;
					}
					row -= 1;
					col -= 1;
				}
			}
			leftToRight--;

		}	
		
	}

	static boolean check() {
		int min = 999;
		Pos minPos = null;
		for(Pos value : list) {
			if(min > value.col) {
				minPos = value;
				min = minPos.col;
			}
		}
		//col의 작은 변수의 row가 다른 변수보다 작을 경우 \  true
		//col의 작은 변수의 row가 다른 변수보다 클 경우 /  false
		for(Pos value : list) {
			if(value.row != minPos.row && value.col != minPos.col) {
				if(minPos.row < value.row) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}

	private static class Pos implements Comparable<Pos>{
		int row;
		int col;
		public Pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "Pos [row=" + row + ", col=" + col + "]";
		}
		@Override
		public int compareTo(Pos o) {
			if(this.row == o.row) {
				if(this.col > o.col) return 1;
				else return -1;
			}
			if(this.row > o.row) {
				return 1;
			}
			return -1;
		}
		
	}
}
