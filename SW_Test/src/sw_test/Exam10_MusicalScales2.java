package sw_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam10_MusicalScales2 {
	static String ascending = "1 2 3 4 5 6 7 8";
	static String descending = "8 7 6 5 4 3 2 1";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sb = br.readLine();
		
		if(sb.equals(ascending)) {
			System.out.println("asceding");
		}else if(sb.equals(descending)) {
			System.out.println("descending");
		} else System.out.println("mixed");
		

	}

}
