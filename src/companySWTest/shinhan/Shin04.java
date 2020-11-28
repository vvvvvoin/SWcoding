package companySWTest.shinhan;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Shin04 {
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int cnt = Integer.parseInt(input);
		String[] operator = {"+", "-", "*", "@"};
		String[] array = new String[cnt + cnt - 1];
		int temp = 1;
		for(int i = 0; i < array.length; i++) {
			array[i] = "";
			if(i % 2 ==0) {
				array[i] += temp;
				temp++;
			}
		}
		
		solution(array, operator, 0, 0, cnt - 1);
		// 입력, 연산자, 몇개했는지, 몇개까지
		System.out.println(answer);
	}

	private static void solution(String[] array, String[] operator, int index , int dept, int m) {
		if(dept == m) {
			String temp = "";
			for(String a : array) {
				temp += a;
			}
			System.out.println(temp);
			cal(temp);
			return;
		}
		
		for(int i = index; i < array.length; i++) {
			if(i  % 2 != 0) {
				for(int j = 0; j < operator.length; j++) {
					array[i] = operator[j];					
					solution(array, operator, i+ 1, dept + 1,m);
				}
			}
		}
	}

	private static void cal(String temp) {
		String[] array = temp.split("");
		for(int i = 0; i < array.length; i++) {
			if(temp.charAt(i) == '@') {
				array[i + 1] = array[i - 1] + array[i + 1];
				array[i] =  "";
				array[i - 1] =  "";
				
			}
		}

		String op = "";
		int sum = 0;
		for(int i = 0; i < array.length ; i++) {
			if(array[i].equals("+")) {
				op = "+";
			}else if(array[i].equals("-")) {
				op = "-";
			}else if(array[i].equals("*")) {
				op = "*";
			}else if(array[i].equals("")) {
				continue;
			}else {
				if(op.equals("")) {
					sum += Integer.parseInt(array[i]);
				}else if(op.equals("+")) {
					sum += Integer.parseInt(array[i]);
				}else if(op.equals("-")) {
					sum -= Integer.parseInt(array[i]);
				}else if(op.equals("*")) {
					sum *= Integer.parseInt(array[i]);
				}
			}

		}
		System.out.println(sum);
		if(Math.abs(sum) <= 2) {
			answer++;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

