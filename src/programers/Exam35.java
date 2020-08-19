package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class Exam35 {
	static int N = 5;
	static int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

	public static void main(String[] args) {
		Stage[] mStages = new Stage[N];

		for (int i = 0; i < N; i++) {
			mStages[i] = new Stage(i + 1);
		}

		for (int user : stages) {
			if (user <= N) {
				mStages[user - 1].count++;
			}
		}

		int nowStageUser = stages.length;
		for (Stage stage : mStages) {
			if (stage.count == 0 || nowStageUser == 0) {
				stage.failRate = 0.0;
			} else {
				stage.failRate = (double) stage.count / nowStageUser;
				nowStageUser -= stage.count;
			}
		}

		Arrays.sort(mStages);
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = mStages[i].stageNumber;
		}
		System.out.println(answer);
	}

	static class Stage implements Comparable {
		int stageNumber;
		int count;
		double failRate;

		public Stage(int stage) {
			this.stageNumber = stage;
		}

		@Override
		public int compareTo(Object o) {
			Stage otherStage = (Stage) o;
			if (this.failRate == otherStage.failRate) {
				return Integer.compare(this.stageNumber, otherStage.stageNumber);
			}
			return -Double.compare(this.failRate, otherStage.failRate);
		}
	}
}
