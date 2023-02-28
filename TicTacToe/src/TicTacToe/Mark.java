package TicTacToe;

public enum Mark {
	X('X'), O('O'), 
	EMPTY('-'); 
	
	private final char symbol;
	
	Mark(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
