package programers_Lv2;

import java.util.Stack;

public class Exam12 {
	static String p = ")(";
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		int left = 0;
		int right = 0;
		//전체문자열 p에서 시작에 상관없이 균형잡힌 괄호 문자열있경우 스택에 넣는다
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(') {
				sb.append("(");
				left++;
			}else {
				sb.append(")");
				right++;
			}
			
			if(left != 0 && right != 0 && right == left) {
				stack.add(sb.toString());
				sb.delete(0, sb.length());
				left = 0;
				right = 0;
			}
		}
		System.out.println(stack);
		String answer = recursion(stack);
		System.out.println(answer);
		
	}
	//스택안의 모든 엘리먼트는 다 균형잡힌 괄호이다
    //그렇기에 올바른 괄호 문자열을 찾거나
    //아닐경우 change함수를 실행한다
	static String recursion(Stack<String> queue) {
		String returnValue = "";
		while(!queue.isEmpty()) {
			String str = queue.pop();
			if(isPecfect(str)) {
				returnValue = str + returnValue;
				System.out.println("true");
			}else {
				//returnValue = change(str) + returnValue;
				//이거 실수해서 오려걸렸다
				returnValue = "(" + returnValue + ")" + change(str);
				System.out.println("false");
			}
		}

		return returnValue;
	}
	
	//해당 문자가 올바론 괄호 문자열인지 반환시킨다
	static boolean isPecfect(String str) {
		return str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')' ? true : false;
	}
	//해당문자의 앞뒤를 자르고 "(" -> "(",   ")" -> "(" 변환
	static String change(String str) {
		if(str == null || str.equals("")) {
			return "";
		}
		//앞뒤 제거
		str = str.substring(1, str.length() - 1);
		
		//"(" -> "(",   ")" -> "(" 변환
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				sb.append(")");
			}else {
				sb.append("(");
			}
		}
		return sb.toString();
	}

}



























