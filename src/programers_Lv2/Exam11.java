package programers_Lv2;

public class Exam11 {
	static String name = "AAA";

	public static void main(String[] args) {
		int answer = 0;
		int min1 = 0;
		int min2 = 0;
		int minMove = 0;

		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != 'A') {
				min1 = (int) name.charAt(i) - 'A';
				min2 = 'Z' - (int) name.charAt(i) + 1;
				answer += Math.min(min1, min2);
			}

		}
		minMove = name.length() - 1;
		for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                int move = 2 * i + name.length() - next;
                minMove = Math.min(move, minMove);
            }
        }
		
		System.out.println(answer + minMove);
	}
}
