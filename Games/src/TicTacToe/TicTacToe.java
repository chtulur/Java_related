package TicTacToe;

import java.util.Arrays;

public class TicTacToe {
	protected Character[] board;
	protected char userMarker;
	protected char aiMarker;
	protected char winner;
	protected char currentMarker;
	
	public TicTacToe(char playerToken, char aiMarker, char startingPlayer) {
		this.userMarker = playerToken;
		this.aiMarker = aiMarker;
		this.winner = '-';
		this.currentMarker = startingPlayer;
		this.board = setBoard();
	}
	
	public static Character[] setBoard() {
		return new Character[] {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
	}
	
	public boolean playTurn(int spot) {
		int actualSpot;
		if (spot >= 7) {
			actualSpot = spot - 6;
		} else if (spot <= 3) {
			actualSpot = spot + 6;
		} else {
			actualSpot = spot;
		}
		
		boolean isValid = withinRange(actualSpot) && !isSpotTaken(actualSpot);
		if (isValid) {
			board[actualSpot - 1] = currentMarker;
			currentMarker = currentMarker == userMarker ? aiMarker : userMarker;
		}
		
		return isValid;
	}
	
	public boolean withinRange(int spot) {
		return spot > 0 && spot < board.length + 1;
	}
	
	public boolean isSpotTaken(int spot) {
		return board[spot - 1] != '-';
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
	
	public static void drawIndexBoard() {
		System.out.println();
		System.out.println(" ------------");
		System.out.println(" | 7 | 8 | 9");
		System.out.println(" ------------");
		System.out.println(" | 4 | 5 | 6");
		System.out.println(" ------------");
		System.out.println(" | 1 | 2 | 3");
		System.out.println(" ------------");
		
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
				.anyMatch(c -> Arrays.stream(c).allMatch(cond -> cond == userMarker) ||
							   Arrays.stream(c).allMatch(cond -> cond == aiMarker));
		
		if (hasWinningCondition) {
			this.winner = this.currentMarker == this.userMarker ? this.aiMarker : this.userMarker;
		}
		
		return hasWinningCondition;
	}
	
	public boolean isTheBoardFilled() {
			return !Arrays.asList(board).contains('-');
	}
	
	public String gameOver() {
		if (this.winner == '-') {
			return "It's a draw";
		} else {
			return this.winner == this.userMarker 
					? "Congrats, you win!"
					: "Ai beats you, oof. sadge.";
		}
	}
}