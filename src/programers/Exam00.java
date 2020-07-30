package programers;

import java.util.Stack;

public class Exam00 {
	static int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
	static int[] moves = {1,5,3,5,1,2,1,4};
	static int score = 0;
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) {
		for(int i =0; i < moves.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[j][moves[i]-1] != 0) {
					
					if(stack.isEmpty()) {
						stack.add(board[j][moves[i]-1]);
						board[j][moves[i]-1] = 0;
						break;
					}else {
						//스택에 있을경우
						//같을 경우
						if(stack.peek() == board[j][moves[i]-1]) {
							stack.pop();
							score += 2;
							board[j][moves[i]-1] = 0;
							break;
						}else {
							//다를 경우
							stack.add(board[j][moves[i]-1]);
							board[j][moves[i]-1] = 0;
							break;
						}
						
					}
					
					
					
				}
			}
			
		}
		System.out.println(score);
	}

}
