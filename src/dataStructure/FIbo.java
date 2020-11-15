package dataStructure;

public class FIbo {
	public static void main(String[] args) {
		System.out.println(fiboRecursive(1));
		System.out.println(fibo(1));
	}
	public static int fibo(int n) {
		if(n <= 2)return 1;
		int first = 1;
		int second = 1;
		int value = 0;
		for(int i = 0; i < n - 2; i++){
			value = second + first;
			first = second;
			second = value;
		}
		return value;
	}
		
	
	public static int fiboRecursive(int n) {
		if (n <= 1)
			return n;
		else
			return fiboRecursive(n - 2) + fiboRecursive(n - 1);
	}

}
