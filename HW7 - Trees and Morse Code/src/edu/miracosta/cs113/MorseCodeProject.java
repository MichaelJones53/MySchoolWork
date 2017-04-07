package edu.miracosta.cs113;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeProject {

	public static void main(String[] args) {
		String filename = "C:\\Users\\W7201584\\Desktop\\morse.txt";
		BinaryTree<String> morseTree = new BinaryTree<String>();

		try {
			FileInputStream instream = new FileInputStream(filename);
			Scanner scanner = new Scanner(instream);
			while (scanner.hasNext()) {
				morseTree = BinaryTree.readBinaryTree(scanner);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
