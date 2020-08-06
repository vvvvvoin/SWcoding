package programers;


public class Exam04 {
	static int n = 5;
	static int[] lost = {2, 3};
	static int[] reserve = {3, 4};
	public static void main(String[] args) {
		int answer = 0;
		for(int i = 0; i <lost.length; i++) {
			for(int j = 0; j <reserve.length; j++) {
				if (reserve[j] == lost[i]) {
					reserve[j] = -1;
					lost[i] = -1;
					answer++;
					break;
				}
			}
		}
		
		for(int i = 0; i <lost.length; i++) {
			for(int j = 0; j <reserve.length; j++) {
				if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j] -1 ) {
					answer++;
					reserve[j] = -1;
					break;
				}
			}
		}
		
		answer =  n - lost.length + answer;
		
		System.out.println(answer);
	}

}
