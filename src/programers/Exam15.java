package programers;

public class Exam15 {
	static int n = 5000000;
	public static void main(String[] args) {
		int answer = 0;
        int[] number = new int[n+1];
        
        //2부터 시작해서 모든 배열에 값을 채워넣는다
        for(int i=2; i<=n; i++) {
            number[i] = i;
        }
        
        //값을 하나씩 꺼내서 그 값을 제외한 그 값의 배수들을 배열에서 삭제시킨다
        //만약 계산하는 값이 0 이면 다음으로 넘어간다
        for(int i=2; i<=n; i++) {
        	if(number[i]==0) continue;
            
            for(int j= 2*i; j<=n; j += i) {
                number[j] = 0;
            }
        }
        //0이 아닌 소수값을 리턴한다
        for(int i=0; i<number.length; i++) {
            if(number[i]!=0) {
                answer++;
            }
        }
        System.out.println(answer);
	}
}
