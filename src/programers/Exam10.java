package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Exam10 {
	static String[] strings = {"abce", "abcd", "cdx"};
	static int n = 2;
	public static void main(String[] args) {
		for(int i = 0; i < strings.length; i++){
            strings[i] = Character.toString(strings[i].charAt(n))+strings[i];
        }
        Arrays.sort(strings);
        String[] answer = new String[strings.length];
        for(int i = 0; i < strings.length; i++){
            answer[i] = strings[i].substring(1, strings[i].length());
        }
		
		
		for(String str : answer) {
			System.out.println(str);
		}
	}
}
