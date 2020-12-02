package companySWTest.nhngodo;

public class Godo04 {
	static String cardNumber = "11111101";
	//static String cardNumber = "21378";
	public static void main(String[] args) {
		String[] str = cardNumber.split("");
		//짝수
		if(cardNumber.length() % 2 == 0) {
			for(int i = 0; i < str.length; i++) {
				if((i + 1) % 2 != 0) {
					str[i] = Integer.parseInt(str[i]) * 2 + "";
				}
			}
		//홀수
		}else{
			for(int i = 0; i < str.length; i++) {
				if((i+1) % 2 == 0) {
					str[i] = Integer.parseInt(str[i]) * 2 + "";
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
			for(int j = 0; j < str[i].length(); j++) {
				answer += Integer.valueOf(str[i].charAt(j) + "");
			}
		}
		System.out.println();
		if(answer % 10 == 0) {
			System.out.println("VALID");
		}else {
			System.out.println("INVALID");
		}
		System.out.println(answer);
	}
}
