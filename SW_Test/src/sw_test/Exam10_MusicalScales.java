package sw_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam10_MusicalScales {
	static int[] ascending = {1, 2, 3, 4, 5, 6, 7 ,8};
	static int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] musicalScales = new int[8];
		
		for(int i = 0; i < musicalScales.length; i++) {
			musicalScales[i] = Integer.parseInt(st.nextToken());
		}
		
		if(musicalScales[0] == 1) {
			for(int i = 0; i < musicalScales.length; i++) {
				if(musicalScales[i] != ascending[i]) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
		}else if(musicalScales[0] == 8) {
			for(int i = musicalScales.length -1; i < musicalScales.length ; i++) {
				if(musicalScales[i] != descending[i]) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
		}else System.out.println("mixed");

	}

}
