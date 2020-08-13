package programers;

import java.util.ArrayList;
import java.util.Collections;

public class Exam12 {
	static String s = "abcFD";
	static String t = "BCAFDG";
	public static void main(String[] args) {
		ArrayList<String> upperList = new ArrayList<>();
        ArrayList<String> lowwerList = new ArrayList<>();
        for(int i = 0; i <s.length(); i++){
            if(Character.isUpperCase(s.charAt(i))){
                upperList.add(Character.toString(s.charAt(i)));
            }else{
                lowwerList.add(Character.toString(s.charAt(i)));
            }         
        }
        Collections.sort(upperList, Collections.reverseOrder());
        Collections.sort(lowwerList, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String str : lowwerList){
            sb.append(str);
        }
        for(String str : upperList){
            sb.append(str);
        }
        String answer = sb.toString();
        System.out.println(answer);
	}
}
