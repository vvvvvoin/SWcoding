package kakao;

public class Kakao01 {
	static String new_id = "abcdefghijklmn.p";
	public static void main(String[] args) {
		String temp1 = "";
		String temp2 = "";
		//1단계
		for(int i = 0; i < new_id.length(); i++) {
			temp1 += (new_id.charAt(i) +"").toLowerCase();
		}
		
		//2단계
		for(int i = 0; i < temp1.length(); i++) {
			if(temp1.charAt(i) >= 'a' && temp1.charAt(i) <= 'z' ) {
				temp2 += temp1.charAt(i);
			}else if(temp1.charAt(i) == '.' || temp1.charAt(i) == '_' || temp1.charAt(i) == '-') {
				temp2 += temp1.charAt(i);
			}else if(temp1.charAt(i) >= '0' && temp1.charAt(i) <= '9' ) {
				temp2 += temp1.charAt(i);
			}
		}
		temp1 = "";
		//3단계
		String dot = "";
		for(int i = 2; i < temp2.length(); i++) {
			dot += ".";
		}
		int size  = temp2.length();
		for(int i = 2; i < size; i++) {
			temp2 = temp2.replace(dot, ".");
			dot = dot.substring(0, dot.length() - 1);
		}

		//4단계
		if(temp2.charAt(0) == '.') {
			temp2 = temp2.substring(1, temp2.length());
		}
	
		
		//5단계
		if(temp2.equals("")) {
			temp2 = "a";
		}
		
		//6단계
		if(temp2.length() >= 16) {
			temp2 = temp2.substring(0, 15);
		}
		if(temp2.charAt(temp2.length() - 1) == '.') {
			temp2 = temp2.substring(0, temp2.length() - 1);
		}
		
		//7단계
		if (temp2.length() <= 2) {
			while (true) {
				temp2 += temp2.charAt(temp2.length() - 1);
				if (temp2.length() == 3) {
					break;
				}
			}
		}
		System.out.println(temp2);
	}
}
