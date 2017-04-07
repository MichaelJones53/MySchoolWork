package edu.miracosta.cs113;

public class MorseLetter {
	private char alphaLetter;
	private String morseCode;
	
	public MorseLetter(char alpha, String morse){
		alphaLetter = alpha;
		morseCode = morse;
		
	}

	public char getAlphaLetter() {
		return alphaLetter;
	}


	public String getMorseCode() {
		return morseCode;
	}

	public String toString(){
		return alphaLetter +" "+morseCode;
	}
	
}
