package Array;

/**
 * Given a tictactoe board, determine if there's a winner. 
 * Input shall be given as a "square array" (in which the length and width are the same) and players are either X or O.
 * 
 * Assumptions:
 * 1. Array size is 3x3
 * 2. Players are capital X and capital O
 * 3. Evaluating character (not a string)
 * 4. Result will be either 'true' if the given player is a winner or 'false' otherwise.
 * 
 * Runtime complexity: 
 * At worst, it'll run in O(n^2) if we don't have any winner
 * At best and in average, it'll run in O(log n).
 *  
 * Space complexity: O(1) as we don't create any other data structure.
 * 
 * @author javanese-javanerd
 */
public class TicTacToe {

	public static void main(String args[]) {
		char[][] board = {
				{'O', 'X', 'O',},
				{'X', 'O', 'O',},
				{'O', 'O', 'X',}
		};
		System.out.println("O winning?: " + determineWinner(board, 'O'));
	}
	
	public static boolean determineWinner(char[][] board, char player) {
		boolean winnerInHorizontal = checkHorizontal(board, player);
		boolean winnerInVertical = checkVertical(board, player);
		boolean winnerInDiagonal1 = checkDiagonal1(board, player);
		boolean winnerInDiagonal2 = checkDiagonal2(board, player);
		
		return winnerInHorizontal || winnerInVertical || winnerInDiagonal1 || winnerInDiagonal2;
	}
	
	private static boolean checkHorizontal(char[][] board, char player) {
		boolean potentialWinner = true;
		for (int x=0; x<board.length; x++) {
			for (int y=0; y<board[x].length; y++) {
				if (board[x][y] != player) {
					potentialWinner = false;
					break;
				}
				else {
					potentialWinner = true;
				}
			}
			
			if (potentialWinner) break;
		}
		return potentialWinner;
	}
	
	private static boolean checkVertical(char[][] board, char player) {
		boolean potentialWinner = true;
		for (int y=0; y<board.length; y++) {
			for (int x=0; x<board[y].length; x++) {
				if (board[x][y] != player) {
					potentialWinner = false;
					break;
				}
				else {
					potentialWinner = true;
				}
			}
			
			if (potentialWinner) break;
		}
		return potentialWinner;
	}
	
	private static boolean checkDiagonal1(char[][] board, char player) {
		boolean potentialWinner = true;
		for (int axis=0; axis<board.length; axis++) {
			if (board[axis][axis] != player) {
				potentialWinner = false;
				break;
			}
			else {
				potentialWinner = true;
			}
		}
		
		return potentialWinner;
	}
	
	private static boolean checkDiagonal2(char[][] board, char player) {
		boolean potentialWinner = true;
		int x = board.length-1;
		int y = 0;
		
		while (x >= 0 && y < board.length) {
			if (board[x][y] != player) {
				potentialWinner = false;
				break;
			}
			else {
				potentialWinner = true;
			}
			x--;
			y++;
		}
		
		return potentialWinner;
	}
}
