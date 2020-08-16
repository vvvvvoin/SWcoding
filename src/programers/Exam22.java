package programers;

public class Exam22 {
	static long n = 3;

	public static void main(String[] args) {
	    double x =  Math.sqrt(n);
	    double answer = 0;
	    if(x %1 == 0){
	    	answer = (x+1) * (x+1);
	    }else{
	    	answer = -1;    
	    }
	    System.out.println((long)answer);
	}

}
