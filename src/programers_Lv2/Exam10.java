package programers_Lv2;

public class Exam10 {
	static String number = "4177252841";
	static int k = 4;

	public static void main(String[] args) {
		//너무 어렵다
		//이런 방식을 알려면 수에 능통해야할거 같다
		//스택을 이용한 방법도 있느데 더 간결한 느낌이다
		StringBuilder sb = new StringBuilder();
		char max = 0;
		int index = 0;
		for(int i = 0; i < number.length() - k; i++) {
			max = 0;
			for(int j = index; j <= k+i; j++) {
				if(max < number.charAt(j)) {
					index = j+1;
					max = number.charAt(j);
				}
			}
			sb.append(max);
		}
		System.out.println(sb.toString());
		
	}
	

}
