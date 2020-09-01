package programers_Lv2;

public class Exam23 {
	
	static String s = "(()(";

	public static void main(String[] args) {
		int index = 0;
		int right = 0;
		int left = 0;
		boolean flag = false;
		while (true) {
			for (int i = index; i < s.length(); i++) {
				if(s.charAt(0) == ')') {
					flag = true;
					break;
				}
				
				if (s.charAt(i) == '(')
					left++;
				if (s.charAt(i) == ')')
					right++;

				if (left != 0 && right != 0 && left == right) {
					index = i + 1;
					break;
				}

			}
			System.out.println(left + "    " + right);
			if(index == s.length()) break;
			if(left != right) flag = true;
			if(flag) break;
		}
		
		System.out.println(flag);
	}

}
