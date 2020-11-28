package companySWTest.nhn;

import java.util.ArrayList;

class Nhn03 {
	private static void solution(int numOfOrder, String[] orderArr) {
		for (int o = 0; o < numOfOrder; o++) {
			String nowStr = orderArr[o];
			while (true) {
				if (!nowStr.contains("("))
					break;

				int startIndex = nowStr.lastIndexOf("(");
				int endIndex = nowStr.indexOf(")");
				//1 
				if (Character.isDigit(nowStr.charAt(startIndex - 1))) {
					String left = "";
					String mid = "";
					String right = "";

					for (int i = 0; i < startIndex - 1; i++) {
						left += nowStr.charAt(i) + "";
					}
					int index = Integer.parseInt(nowStr.charAt(startIndex - 1) + "");
					for (int i = 0; i < index; i++) {
						mid += nowStr.substring(startIndex + 1, endIndex);
					}

					for (int i = endIndex + 1; i < nowStr.length(); i++) {
						right += nowStr.charAt(i) + "";
					}

					nowStr = left + mid + right;
				//2
				} else if ('A' <= (nowStr.charAt(startIndex - 1)) && 'Z' >= (nowStr.charAt(startIndex - 1))) {
					String left = "";
					String mid = "";
					String right = "";

					for (int i = 0; i < startIndex - 1; i++) {
						left += nowStr.charAt(i) + "";
					}

					for (int i = startIndex + 1; i < endIndex; i++) {
						mid += "" + nowStr.charAt(startIndex - 1) + nowStr.charAt(i);
					}

					for (int i = endIndex + 1; i < nowStr.length(); i++) {
						right += nowStr.charAt(i) + "";
					}

					nowStr = left + mid + right;
				}
			}
			//3
			ArrayList<Character> list = new ArrayList<Character>();
			for (int i = 0; i < nowStr.length(); i++) {
				if (Character.isDigit(nowStr.charAt(i))) {
					int cnt = Integer.parseInt(nowStr.charAt(i) + "");
					for (int j = 0; j < cnt; j++) {
						list.add(nowStr.charAt(i + 1));
					}
					i++;
				} else {
					list.add(nowStr.charAt(i));
				}
			}
			String answer = "";
			for (char a : list) {
				answer += a;
			}
			System.out.println(answer);
		}

	}
}