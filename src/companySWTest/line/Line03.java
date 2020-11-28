package companySWTest.line;

public class Line03 {
	static int n = 73425;
	//static int n = 10007;
	//static int n = 9;
	public static void main(String[] args) {
		String value = n + "";
		int cnt = 0;
		while(true) {
			if(value.length() == 1) break;
			cnt++;
			String temp1 = "";
			String temp2 = "";
			for(int i = value.length() - 1; i >= 0; i--) {
				if(i == (value.length() / 2) -1) {
					temp1 = value.substring(0, i + 1);
					break;
				}
				
				if(value.charAt(i) != '0') {
					temp2  = value.charAt(i) + temp2;					
				}else {
					temp1 = value.substring(0, i + 1);
					break;
				}
			}
			value = String.valueOf(Integer.parseInt(temp1) + Integer.parseInt(temp2));
		}
		
		int[] answer = new int[2];
		answer[0] = cnt;
		answer[1] = Integer.parseInt(value);
		
	}
}
