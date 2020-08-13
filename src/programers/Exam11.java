package programers;

public class Exam11 {
	static String s = "PyY";
	public static void main(String[] args) {
		boolean answer = true;
		int p = 0;
        int y = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.toString(s.charAt(i)).toUpperCase().equals("P")) p++;
            else if(Character.toString(s.charAt(i)).toUpperCase().equals("Y")) y++;
        }

        System.out.println(p);
        System.out.println(y);
        if(p == y) answer = true;
        else answer = false;
        System.out.println(answer);
	}
}
