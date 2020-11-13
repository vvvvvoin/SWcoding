package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam38_2010 {
	static BufferedReader br;
	static StringTokenizer st;

	static String[] people;
	static String[][] line;
	static int findIndex = 0;
	static String[] compare;
	static String abcdef = "";
	static String answer = "";
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 65; i < 65 + n; i++) {
			abcdef += (char)(i);
		}
		
		int m = Integer.parseInt(br.readLine());
		String str = br.readLine();

		people = new String[n];
		compare = new String[n];
		for(int i = 0; i <people.length; i++) {
			people[i] = str.charAt(i) + "";
		}
		
		line = new String[m][n + 1];
		for(int i = 0; i < m; i++) {
			String temp = br.readLine();
			if(temp.contains("?")) findIndex = i;
			for(int j = 0; j < temp.length(); j++) {
				line[i][j + 1] = temp.charAt(j) + "";
			}
			line[i][0] = "*";
			line[i][line[0].length - 1] = "*";
		}

		com(1, compare.length);
		if(flag) {
			System.out.println(answer);
		}else {
			String x = "";
			for(int i = 0; i < n - 1; i++) {
				x += "x";
			}
			System.out.println(x);
		}
	}

	private static void com(int index, int n) {
		if(flag == true) return;
		if(n == 1) {
			if(check() && abcdef.equals(move())) {
				flag = true;
				for(int i = 1; i < line[0].length - 1; i++) {
					answer += line[findIndex][i];
				}
			}
			return;
		}
		line[findIndex][index] = "*";
		com(index + 1, n - 1);
		line[findIndex][index] = "-";
		com(index + 1, n - 1);
		return;
	}

	private static boolean check() {
		String str = "";
		for(int i = 0; i < line[0].length; i++) {
			str += line[findIndex][i];
		}
		if(str.contains("--")) {
			return false;
		}else {
			return true;
		}
	}

	private static String move() {
		String str = "";
		for (int k = 0; k < people.length; k++) {
			int index = k;
			for (int i = 0; i < line.length; i++) {
				String way = line[i][index] + line[i][index + 1];
				if (way.equals("-*")) {
					index -= 1;
				} else if (way.equals("*-")) {
					index += 1;
				}
			}
			compare[k] = people[index];
		}
		for(String s : compare) {
			str += s;
		}
		return str;
	}

}
