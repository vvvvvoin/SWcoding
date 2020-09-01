package programers_Lv2;

public class Exam25 {
	static int n = 78;
	public static void main(String[] args) {
		// 스트림 썼는데 효율성에서 시관초과가 떴다
		// 주석된 코드를 for문으로 수정하면 통과된다
		String str = Integer.toBinaryString(n);
		System.out.println(Integer.toBinaryString(n));
		long count1 = str.chars().filter(e -> e == '1').count();
		String value = "";
		int cnt = 1;
		long count2 = 0;
		while(true) {
			value = Integer.toBinaryString(n + cnt++);
			for(int i = 0; i < value.length(); i++) {
				if(value.charAt(i) == '1') {
					count2++;
				}
			}
			if(count2 == count1)break;
			count2 = 0;
			//if(value.chars().filter(a -> a == '1').count() == count1)break;
		}
		System.out.println(Integer.parseInt(value, 2));
	}
}
