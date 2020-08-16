package programers;

public class Exam29 {
	static int x = 9998;
	public static void main(String[] args) {
		String str = "" + x;
        int temp = 0;
        for(int i = 0; i<str.length(); i++){
        	System.out.println(temp);
           temp += Integer.parseInt(Character.toString(str.charAt(i)));
        }
        
        if((x % temp) == 0) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        System.out.println(temp);
	}
}
