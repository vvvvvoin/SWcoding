package dataStructure;

public class Hanoi {
	public static void main(String[] args) {
		hanoi(3 , 1, 2, 3);
	}

	private static void hanoi(int n, int from, int by, int to) {
		if(n == 1) {
			move(from, to);
		}else {
			hanoi(n - 1, from, to, by);
			move(from, to);
			hanoi(n - 1, by, from, to);
		}
		
	}

	private static void move(int from, int to) {
		System.out.println("from : " + from + "  to : " + to);
	}
}
