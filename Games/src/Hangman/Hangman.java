package Hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {
	
	String mysteryWord;
	StringBuilder currentGuess;
	ArrayList<Character> previousGuessses = new ArrayList<>();
	
	int guessesLeft = 6;
	
	ArrayList<String> dictionary = new ArrayList<>();
	private static FileReader fileReader;
	private BufferedReader bufferedReader;
	
	public Hangman() throws IOException {
//		initializeStreams();
		dictionary.add("responsibility");
		dictionary.add("recession");
		dictionary.add("uncommon");
		dictionary.add("xenophile");
		dictionary.add("algebra");
		mysteryWord = pickWord();
		currentGuess = initializeCurrentGuess();
	}
	
//	public void initializeStreams() throws IOException {
//		try {
//			File inFile = new File("dictionary.txt");
//			fileReader = new FileReader(inFile);
//			System.out.println("hi");
//			bufferedReader = new BufferedReader(fileReader);
//			
//			
//			String currentLine = bufferedReader.readLine();
//			while(currentLine != null) {
//				dictionary.add(currentLine);
//				currentLine = bufferedReader.readLine();
//			}
//			
//			bufferedReader.close();
//			fileReader.close();
//		} catch(IOException e) {
//			System.out.println("Something went wrong with your file! Could not init streams.");
//		}
//	}
	
	public String pickWord() {
		Random rand = new Random();
		int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
		return dictionary.get(wordIndex);
	}
	
	public StringBuilder initializeCurrentGuess() {
		StringBuilder current = new StringBuilder();
		for (int i = 0; i < mysteryWord.length() *2; i ++) {
			if (i % 2 == 0) {
				current.append("_");
			} else {
				current.append(" ");
			}
		}
		return current;
	}
	
	public boolean gameOver() {
		StringBuilder userWord = new StringBuilder();
		
		for (int i =0; i < currentGuess.length(); i+= 2) {
				userWord.append(currentGuess.charAt(i));
		}
		
		return guessesLeft == 0 || mysteryWord.equals(userWord.toString());
	}
	
	public void guess(char letter) {
		if (mysteryWord.indexOf(letter) == -1) {
			guessesLeft--;
		} else {
			for (int i = 0; i < mysteryWord.length(); i++) {
				char c = mysteryWord.charAt(i);
				if (c == letter) {
					currentGuess.setCharAt(i * 2, c);
				}
			}
		}
	}
	
	public String drawPicture() {
		switch(guessesLeft) {
		case 6:
			return " - - - - -\n"+
				"|        |\n"+
				"|        \n" +
				"|        \n" +
				"|        \n" +
				"|        \n" +
				"|\n" +
				"|\n";
		case 5: 
			return " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|        \n" +
				"|        \n" +
				"|        \n" +
				"|\n" +
				"|\n";
		case 4: 
			return " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|        |\n" +
				"|        \n" +
				"|        \n" +
				"|\n" +
				"|\n";
		case 3: 
			return " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|        |\\ \n" +
				"|        \n" +
				"|        \n" +
				"|\n" +
				"|\n";
		case 2: 
			return " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|       /|\\ \n" +
				"|        \n" +
				"|        \n" +
				"|\n" +
				"|\n";
		case 1: 
			return " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|       /|\\ \n" +
				"|         \\ \n" +
				"|        \n" +
				"|\n" +
				"|\n";
		case 0: 
			return " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|       /|\\ \n" +
				"|       / \\ \n" +
				"|        \n" +
				"|\n" +
				"|\n";
		default: 
			return " - - - - -\n"+
				"|        |\n"+
				"|        \n" +
				"|        \n" +
				"|        \n" +
				"|        \n" +
				"|\n" +
				"|\n";
		}
	}
}
