package TicTacToe;

import java.util.Arrays;

public class TicTacToe {
	protected char[] board;
	protected char userMarker;
	protected char aiMarker;
	protected char winner;
	protected char currentMarker;
	
	public TicTacToe(char playerToken, char aiMarker) {
		this.userMarker = playerToken;
		this.aiMarker = aiMarker;
		this.winner = '-';
		this.board = setBoard();
	}
	
	public static char[] setBoard() {
		char[] board = new char[9];
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}
	
	public boolean playTurn(int spot) {
		boolean isValid = withinRange(spot) && !isSpotTaken(spot);
		if (isValid) {
			board[spot - 1] = currentMarker;
			currentMarker = currentMarker == userMarker ? aiMarker : userMarker;
		}
		return isValid;
	}
	
	public boolean withinRange(int spot) {
		return spot > 0 && spot < board.length + 1;
	}
	
	public boolean isSpotTaken(int spot) {
		return board[spot - 1] != '-' ? false : true;
	}
	
	public void drawBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
				System.out.println(" ------------");
			}
			System.out.print(" | " + board[i]);
		}
		System.out.println();
	}
	
	public void drawIndexBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
				System.out.println(" ------------");
			}
			System.out.print(" | " + (i + 1));
		}
		System.out.println();
	}
	
	public boolean isThereAWinner() {
		Character[][] conditions = {
		{board[0], board[1], board[2]},
		{board[3], board[4], board[5]},
		{board[6], board[7], board[8]},
		{board[0], board[3], board[6]},
		{board[1], board[4], board[7]},
		{board[2], board[5], board[8]},
		{board[0], board[4], board[8]},
		{board[2], board[4], board[6]}
		};
		
		boolean hasWinningCondition = Arrays.stream(conditions)
				.anyMatch(c -> Arrays.stream(c).allMatch(cond -> cond == 'X') ||
							   Arrays.stream(c).allMatch(cond -> cond == 'O'));
		
		return hasWinningCondition;
	}
}
