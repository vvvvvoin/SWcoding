package sw_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Exam08_MaxMin {
	static int max, min;
	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i <n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list.sort(Comparator.naturalOrder());
		int min = list.get(0);
		int max = list.get(list.size() -1);
		
		bw.write(min + "  " + max);
		bw.flush();
		bw.close();
		
		
	}
}
