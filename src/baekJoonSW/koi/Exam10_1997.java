package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam10_1997 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int money;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		money = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ArrayList<Investment> list = new ArrayList<Investment>();
		
		for(int i = 1; i <= money; i++) {
			st = new StringTokenizer(br.readLine());
			int[] array = new int[N];
			st.nextToken();
			for(int j = 0; j < N; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}
			list.add(new Investment(i, array));
		}
		
		int max = 0;
		int[] answer = new int[N];
		for(int i = 0; i < list.size(); i++) {
			int tempMoney = money;
			int tempMax = 0;
			int[] tempArray = new int[N];
			boolean[] check = new boolean[N];
			for(int j = i; j < list.size(); j++) {
				int[] companyArray = list.get(j).company;
				int investMax = 0;
				int maxIndex = 0;
				for(int k = 0; k < N; k++) {
					if(companyArray[k] > max) {
						investMax = companyArray[k];
						maxIndex = k;
					}
				}
				
				if(tempMoney - (j + 1) >= 0 && check[j] == false) {
					check[j] = true;
					tempArray[maxIndex] += (j + 1);
					tempMoney -= (j + 1);
					tempMax += investMax;
				}
				if(tempMoney <= 0) break;
				
			}
			if(max < tempMax) {
				max = tempMax;
				answer = tempArray;
			}
		}
		
		System.out.println(max);
		String str = "";
		for(int value : answer) {
			str += value +" ";
		}
		System.out.println(str.trim());
	}
	private static class Investment{
		int money;
		int[] company;
		public Investment(int money, int[] company) {
			super();
			this.money = money;
			this.company = company;
		}
		@Override
		public String toString() {
			return "Investment [money=" + money + ", company=" + Arrays.toString(company) + "]";
		}
		
	}
}
