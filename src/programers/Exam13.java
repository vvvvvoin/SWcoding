package programers;

public class Exam13 {
	static String s = "0111145360";
	public static void main(String[] args) {
		//나름 잘 풀었다고 생각했는데 정규표현식을 활용할줄은 몰랐다
		//대단한 사람들이다
		//람다식으로 이용하여 풀이하는게 귀찬은 작업에서 편리한거 같다
        if(s.length() ==6 ||  s.length() ==4){
            System.out.println(s.length() == s.chars().filter(e -> Character.isDigit(e)).count());    
        }else{
            System.out.println("false");
        }
	}
}
