package Hangman;

import java.io.IOException;
import java.util.Scanner;

public class HangmanApplication {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		boolean doYouWantToPlay = true;
		
		while(doYouWantToPlay) {
			Hangman game = new Hangman();
			
			do {
				System.out.println();
				game.drawPicture();
				System.out.println();
				System.out.println("The word is: " + game.mysteryWord);
				System.out.println("Current guess: " + game.currentGuess);
				
				System.out.println(game.drawPicture());
				char guessedLetter = sc.next().charAt(0);
				game.guess(guessedLetter);
			}
			while(!game.gameOver());
			
			System.out.println(game.drawPicture());
			
			if (game.guessesLeft == 0) {
				System.out.println("Sorry, game over. The word was " + game.mysteryWord);
			} else {
				System.out.println("Congrats! The word was " + game.mysteryWord);
			}
			   
			System.out.println("Play again? y/N");
			Character response = (sc.next().toUpperCase()).charAt(0);
			doYouWantToPlay = response == 'Y';
			
		}
	}

}
