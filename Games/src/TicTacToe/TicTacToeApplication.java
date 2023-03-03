package TicTacToe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean playAgainPrompt = true;
		
		while(playAgainPrompt) {
			Random rand = new Random();
			char startingPlayer = rand.nextBoolean() ? 'O' : 'X';
			
			System.out.println("Choose your mark: type in either X or O");
			char mark = sc.next().charAt(0);
			char aiMark = mark == 'X'? 'O' : 'X';
			
			while (mark != 'X' && mark != 'O') {
				System.out.println("Invalid character, please type in X or O (uppercase).");
				mark = sc.next().charAt(0);
				aiMark = mark == 'X'? 'O' : 'X';
			}
			
			if (mark == startingPlayer) {
				System.out.println("You chose " + mark + ". You are the starting player.");
			} else {
				System.out.println("You chose " + mark + ". AI is the starting player.");
			}
			
			TicTacToe game = new TicTacToe(mark, aiMark, startingPlayer);
			TicTacToe.drawIndexBoard();
			System.out.println();
			System.out.println("Follow the template above");
			System.out.println();
			
			while(!game.isThereAWinner() && !game.isTheBoardFilled()) {
				game.drawBoard();
				
				if (game.currentMarker != game.userMarker) {
					aiTurn(game, rand);
				} else {
					System.out.println();
					System.out.println("Enter number from 1-9");
					playerTurn(game, sc);
					
				}
			}
			System.out.println();
			System.out.println(game.gameOver());
			game.drawBoard();
			
			System.out.println();
			System.out.println("Do you want to play again? Press 'y' for yes");
			
			char answer = sc.next().charAt(0);
			playAgainPrompt = answer == 'y' || answer == 'Y';
		}
		sc.close();
	}
	
	public static void playerTurn(TicTacToe game, Scanner sc) {
		try {
			if (game.playTurn(sc.nextInt())) {
				sc.nextLine();
			} else {
				System.out.println("Pick a valid spot.");
			}
			return;
		} catch(InputMismatchException e) {
			System.out.println("please enter a number from 1-9");
			 sc.nextLine();
		}
		playerTurn(game, sc);
	}
	
	public static void aiTurn(TicTacToe game, Random rand) {
		int aiSpot = rand.nextInt(9) + 1;
		
		while(!game.playTurn(aiSpot)) {
			aiSpot = rand.nextInt(9) + 1;
		}
	}
}