package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam03_1996 {
	static BufferedReader br;
	static double[] array;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		array = new double[Integer.parseInt(br.readLine())];
		
		double currentValue = 0;
		double max = 0;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = Double.parseDouble(br.readLine());
		}
		
		currentValue = array[0];
		max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] * currentValue < array[i]) {
				currentValue = array[i];				
			}else {
				currentValue *= array[i];
			}
			if(max < currentValue) max = currentValue;
		}
		max = (double)Math.round(max*1000)/1000;
		System.out.printf("%.3f", max);
	}
}
