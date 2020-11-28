package companySWTest.nhn;

class Nhn01 {
	private static class Who {
		char who;
		int cnt;

		public Who(char who, int cnt) {
			super();
			this.who = who;
			this.cnt = cnt;
		}
	}

	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		Who[] who = new Who[numOfAllPlayers - 1];
		Who nowWho = new Who((char) 65, 1);
		int nowPos = 0;
		for (int i = 0; i < who.length; i++) {
			who[i] = new Who((char) (66 + i), 0);
		}

		for (int i = 0; i < numOfGames; i++) {
			int target = numOfMovesPerGame[i];
			nowPos += target;

			if (nowPos >= numOfAllPlayers) {
				nowPos %= numOfAllPlayers - 1;
			} else if (nowPos < 0) {
				nowPos += numOfAllPlayers - 1;
			}

			boolean flag = false;
			for (int j = 0; j < namesOfQuickPlayers.length; j++) {
				if (namesOfQuickPlayers[j] == who[nowPos].who) {
					flag = true;
					break;
				}
			}
			if (flag == true) {
				nowWho.cnt++;
			} else {
				Who temp = who[nowPos];
				who[nowPos] = nowWho;
				nowWho = temp;
				nowWho.cnt++;
			}

		}
		for (Who w : who) {
			System.out.println(w.who + " " + w.cnt);
		}
		System.out.println(nowWho.who + " " + nowWho.cnt);
	}

}