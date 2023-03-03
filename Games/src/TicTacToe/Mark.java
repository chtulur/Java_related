package TicTacToe;

public enum Mark {
	X('X'), O('O'), 
	EMPTY('-'); 
	
	public final char symbol;
	
	Mark(char symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol == '-'? "-" : Character.toString(symbol);
	}
}
