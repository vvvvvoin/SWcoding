package sw_AdvancedTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
class Ingreident{
	private int grade;
	private int cal;
	
	public Ingreident(int grade, int cal) {
		super();
		this.grade = grade;
		this.cal = cal;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		this.cal = cal;
	}
	
}

public class Exam01_Hamberger {
	static int maxCal;
	static int ingredientCase;
	static int resultScore;
	static ArrayList<Ingreident> array;
	static StringTokenizer st;
	static BufferedReader br;
	
	public static void main(String[] args) throws Exception {
		Scanner sc =  new Scanner(System.in);
		array = new  ArrayList<Ingreident>();
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = sc.nextInt();
		for(int i = 0; i < testCase; i++) {
			ingredientCase = sc.nextInt();
			maxCal = sc.nextInt();
			int grade, cal;
			
			for(int j = 0; j <ingredientCase; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				grade = Integer.parseInt(st.nextToken());
				cal = Integer.parseInt(st.nextToken());
				Ingreident ingreident = new Ingreident(grade, cal);
				array.add(ingreident);
			}
			
			
			
			bfs(0, 0, 0);
			
			System.out.println(resultScore);
			
		}
	}
	
	static void bfs(int cnt, int score, int cal) {
		if(cal > maxCal) {
			return;
		}
		if(ingredientCase == cnt) {
			resultScore = Math.max(score, resultScore);
			return;
		}
		
		bfs(cnt +1, score+ array.get(cnt).getGrade(), cal+ array.get(cnt).getCal());
		bfs(cnt +1, score, cal);
	}
}
