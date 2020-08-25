package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		 Scanner scan=new Scanner(System.in);
	        
	        int A =scan.nextInt();
	        double []b =new double[A];
	        double max=0;
	        
	        for(int i=0; i<A; i++){
	            b[i] = scan.nextInt();
	            if(b[i]>max){
	                max=b[i];
	            }
	        }
	        double sum=0;
	        for(int i=0; i<A; i++){
	        	if(b[i] == max) continue;
	            //b[i]=b[i]/max*100;
	            sum += b[i];
	        }
	        System.out.println(sum/(A*max*100));
	        //System.out.println(sum/A);

				
	}
}
