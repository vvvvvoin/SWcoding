package programers_Lv2;

public class Exam04 {
	static int w = 8;
	static int h = 12;

	public static void main(String[] args) {
		//https://co-da-nam.tistory.com/30
        long answer = 0;
        for(int i = 0; i< h; i++){
            answer += Long.valueOf(w) * i / Long.valueOf(h);
        }
        System.out.println(answer *2);
	}
}