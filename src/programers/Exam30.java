package programers;

public class Exam30 {
	static String phone_number = "01033334444";
	public static void main(String[] args) {
		String tempA = phone_number.substring(phone_number.length()-4, phone_number.length());
		//String tempB = phone_number.substring(0, phone_number.length()-4);
		String tempB = "";
		for(int i = 0; i < phone_number.length()-4; i++) {
			tempB += "*";
		}
		System.out.println(tempB + tempA);
				
	}
}
