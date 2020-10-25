package naver;

public class Naver01 {
	static int n = 6;
	static int[] p = {5,4,7,2,0,6};
	static int[] c = {4,6,4,9,2,3};
	
//	static int n = 7;
//	static int[] p = {6,2,1,0,2,4,3};
//	static int[] c = {3,6,6,2,3,7,6};
	public static void main(String[] args) {
		double stock = 0;
		double money = 0;
		double request = 0;
		int destroy = 0;
		String answer = "";
		boolean fail = false;
		for(int i = 0; i < n ; i++) {
			if(destroy == 3) {
				fail = true;
				money = (Math.round(money / i) * 100) / 100.0;
				answer = String.format("%.2f", money);
			}
			stock += p[i];
			request = c[i];
			
			if(stock < request) {
				destroy++;
			}else {
				if(destroy == 0) {
					money = money + request * 100;
				}else if(destroy == 1) {
					money = money + request * 50;
				}else if(destroy == 2) {
					money = money + request * 25;
				}
				stock -= request;
				destroy = 0;
				
			}
		}
		if(fail == false) {
			money = money / n;
			money = Math.round(money * 100) / 100.0;
			answer = String.format("%.2f", money);
		}
		
		System.out.println(answer);
	}

}
