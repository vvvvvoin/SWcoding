package shinhan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shin02 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String str = input.split(" ")[0];
		int n = Integer.parseInt(input.split(" ")[1]);
		String answer = "";
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			c = (char)( c  + n);
			if(!(c >= 'a' && c <= 'z')) {
				c = (char)(c-26);
			}
			answer += c;
		}
		
		System.out.println(answer);
		
	}
}
