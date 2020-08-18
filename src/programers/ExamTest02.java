package programers;

public class ExamTest02 {
	static String dartResult = "1D2S3T*";
	public static void main(String[] args) {
		int answer = 0;
		String[] tempArray = dartResult.split("");
		//배열 초기화
		String[] array = new String[4];
		for(int i = 0; i < array.length; i++) {
			array[i] = "";
		}
		
		int cnt = 0;
		for (int i = 0; i < tempArray.length; i++) {
			if(Character.isDigit(tempArray[i].charAt(0))) {
				if(Character.isDigit(tempArray[i+1].charAt(0))) {
					array[cnt+1] += tempArray[i];
					continue;
				}
				cnt++;
			}
			array[cnt] += tempArray[i];
		}

		double num = 0;
		int bonus = 0;		//Single = 1, Double = 2, Triple = 3
		boolean starBonus = false;
		int option = 0;		//스타상* = 1, 아차상# = 2;
		
		for(int i = 3; i>= 1; i--) {
			for(int j = 0; j<array[i].length(); j++) {
				num = Integer.parseInt(Character.toString(array[i].charAt(0)));
				if(Character.isDigit(array[i].charAt(1))) {
					num = 10;
				}
				if(array[i].charAt(j) == '*') {
					option = 1;
				}else if(array[i].charAt(j) == '#'){
					option = 2;
				}
				
				if(array[i].charAt(j) == 'S') {
					bonus = 1;
				} else if(array[i].charAt(j) == 'D') {
					bonus = 2;
				} else if(array[i].charAt(j) == 'T'){
					bonus= 3;
				}
			}
			num = Math.pow(num, bonus);
			System.out.println(num + "  " + starBonus);
			if(option == 1) {
				num *= 2;
			}else if (option == 2){
				num *= -1;
			}
			if(starBonus) {
				num *= 2;
				starBonus = false;
			}
			answer += num;
			System.out.println(num);
			num = 0;
			bonus = 0;
			if(option == 1) {
				starBonus = true;
			}
			option = 0;
		}
		System.out.println(answer);
	}
}
