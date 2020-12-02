package companySWTest.nhngodo;

public class Godo01 {
	//static int[] goods = {46,62,9};
	//static int[] goods = {50,62,93};
	//static int[] goods = {5,31,15};
	//static int[] goods = {5,3,15};
	static int[] goods = {50,50,50};
	
	public static void main(String[] args) {
		int[] arr = new int[goods.length];
		for(int i = 0; i < goods.length; i++) {
			arr[i] = goods[i];
			if(arr[i] < 50) {
				for(int j = i + 1; j < goods.length; j++) {
					if(goods[j] <= 49) {
						arr[i] += goods[j];
						goods[j] = 0;
						if(arr[i] > 50) break;
					}
				}
			}
			
		}
		int sum = 0;
		for(int value : arr) {
			if(value >= 50) {
				sum += value - 10;
			}else {
				sum += value;
			}
		}
		System.out.println(sum);
}
}