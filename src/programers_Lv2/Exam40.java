package programers_Lv2;

public class Exam40 {
	static int n = 8;
	static int a = 4;
	static int b = 7;
	public static void main(String[] args) {
		int answer = 0;
		int cnt = 0;
		while(cnt  < 20) {
			answer++;

			//작은 숫자를 +1했을때 짝수이고 서로 값을 뺐을 경우 1이 나올때가 break;
			if(a > b) {
				if((b + 1) % 2 ==0) {
					if(a - b == 1) {
						break;
					}
				}
			}else {
				if((a + 1) % 2 ==0) {
					if(b - a == 1) {
						break;
					}
				}
			}
			
			System.out.println(a + "  " + b);
				a = fight(a);				
				b = fight(b);
		}
		
		System.out.println(answer);
	}
	
	static Integer fight(int value) {
		if(value == 1) return 1;
		if(value / 2 ==0) {
			value = value / 2;
		}else {
			value = (value + 1) / 2;
		}
		
		return value;
	}
}

