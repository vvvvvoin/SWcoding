package programers_Lv2;


public class Exam07 {
	static String s = "ababcdcdababcdcd";

	public static void main(String[] args) {
		int answer = s.length();
		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder temp = new StringBuilder();
			
			for(int j = 0 ; j < s.length(); j = j + i) {
				StringBuilder sb = new StringBuilder();
				String str1 =""; 
				if(i+j >= s.length()) {
					str1 = s.substring(j, s.length());
				}else {
					str1 = s.substring(j, i+j);					
				}
				
				int cnt = 1;
				
				for(int k = i + j; k < s.length(); k = k + i) {
					String str2 = "";
					if(k + i >= s.length()) {
						str2 = s.substring(k, s.length());
					}else {
						str2 = s.substring(k, k+i);
					}
					
					if(str1.equals(str2)) {
						cnt++;
						j = k;
					}else {
						break;
					}
				}
				if(cnt == 1) sb.append(str1);
				else sb.append(cnt).append(str1);
				temp.append(sb.toString());
			}
			answer = Math.min(temp.toString().length(), answer);

		}
		System.out.println(answer);
		
	}
}
