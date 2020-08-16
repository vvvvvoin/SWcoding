package programers;

public class Exam18 {
	static String s = "try hello world";
	public static void main(String[] args) {
		String answer = "";
		String[] array = s.split("");
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for(String str : array) {
			for(int i = 0; i<str.length(); i++) {
				if(str.charAt(i) == ' ') {
					num = 0;
					sb.append(" ");
					continue;
				}else {
					if(num %2 == 0) {
						sb.append(str.toUpperCase());
						num++;
					}else {
						sb.append(str.toLowerCase());
						num++;
					}
				}
			}
		
		}
		answer = sb.toString();
		System.out.println(answer.trim());
	}

}
