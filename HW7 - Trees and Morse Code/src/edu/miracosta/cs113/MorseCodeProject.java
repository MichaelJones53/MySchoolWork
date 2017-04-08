package edu.miracosta.cs113;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MorseCodeProject {

	private static BinaryTree<String> morseTree = new BinaryTree<String>();

	public static void main(String[] args) {
		String fileName = "morse.txt";

		boolean isRunning = true;
		Scanner keyboard = new Scanner(System.in);
		Scanner scanner;
		FileInputStream instream;
		int selection = 0;
		boolean enteringFileName = true;

		while (enteringFileName) {

			try {
				instream = new FileInputStream(fileName);
				scanner = new Scanner(instream);
				while (scanner.hasNext()) {
					morseTree = BinaryTree.readBinaryTree(scanner);

				}
				scanner.close();
				enteringFileName = false;
			} catch (FileNotFoundException e) {
				System.out.println("could not find file. Enter the file path");
				fileName = keyboard.nextLine();
			}

		}
		while (isRunning) {
			boolean isSelecting = true;
			System.out.println("");
			System.out.println("*************************************************");
			System.out.println("1 - display morse code table");
			System.out.println("2 - enter file path to translte from morse code to text");
			System.out.println("3 - enter text in console to translate to morse code");
			System.out.println("4 - Exit");
			System.out.println("*************************************************");

			while (isSelecting) {

				try {
					selection = keyboard.nextInt();
					if (selection > 4 || selection < 1) {
						throw new InputMismatchException();
					}
					isSelecting = false;
				} catch (InputMismatchException e) {
					System.out.println("Invalid entry.  try agian");
				} finally {
					keyboard.nextLine();
				}
			}

			if (selection == 1) {
				displayAsTable((treeAsTable(morseTree)));

			} else if (selection == 2) {
				System.out.println("enter the full file path to be translated");
				String userFileName = keyboard.nextLine();
				try {
					instream = new FileInputStream(userFileName);
					scanner = new Scanner(instream);
					while (scanner.hasNext()) {
						System.out.print(translateFromMorseToText(scanner.next().toLowerCase(), morseTree));
					}
					scanner.close();
				} catch (FileNotFoundException e) {
					System.out.println("file not found.  Returnning to main menu");
				}

			} else if (selection == 3) {

				String userString = null;
				System.out.println("Enter line of text to traslate.  numbers and special characers will be ignored!");
				userString = keyboard.nextLine();
				System.out.println(translateText(userString.toLowerCase()));

			} else {
				isRunning = false;
			}
		}
		keyboard.close();
		System.out.println("Toodles!");
	}

	/**
	 * generates table to view binary tree data
	 * 
	 * @param tree
	 *            Binary tree to generate table from
	 * @return String representation as data table of Binary Tree
	 */
	private static String treeAsTable(BinaryTree tree) {
		if (tree.isLeaf()) {
			return tree.getData() + "\n";
		} else {
			if (tree.getRightSubtree() == null) {
				return tree.getData() + "\n" + treeAsTable(tree.getLeftSubtree());
			}
			if (tree.getLeftSubtree() == null) {
				return tree.getData() + "\n" + treeAsTable(tree.getRightSubtree());
			}
			return tree.getData() + "\n" + treeAsTable(tree.getLeftSubtree()) + treeAsTable(tree.getRightSubtree());

		}

	}

	/**
	 * sorts and displays passed string as alphabetical table 5 columns in
	 * breadth
	 * 
	 * @param data
	 *            String to be dislayed as a table
	 */
	private static void displayAsTable(String data) {
		ArrayList<String> dataAsList = new ArrayList<String>();
		Scanner scanner = new Scanner(data);
		while (scanner.hasNext()) {
			String newData = scanner.next();
			if (!newData.equalsIgnoreCase("0")) {
				newData = newData.substring(0, 1) + "  " + newData.substring(1, newData.length());
				dataAsList.add(newData);
			}
		}
		Collections.sort(dataAsList);
		for (int i = 0; i < dataAsList.size(); i++) {
			if (i % 5 == 0) {
				System.out.println("");
			}
			System.out.print(dataAsList.get(i) + "\t");

		}
	}

	/**
	 * converts alphabetical text to morse code
	 * 
	 * @param data
	 *            string to be coverted
	 * @return morse code representation of provided data
	 */
	private static String translateText(String data) {

		return stringToMorse(data, 0);
	}

	private static String stringToMorse(String data, int position) {
		if (position == data.length()) {
			return "";
		} else {
			if (data.charAt(position) == ' ') {
				return " " + stringToMorse(data, position + 1);
			} else {

				return searchBinaryTree(data.charAt(position), morseTree) + " " + stringToMorse(data, position + 1);

			}
		}

	}

	/**
	 * Searches binary tree for provided character and provides morse
	 * representation
	 * 
	 * @param item
	 *            character being converted to morse
	 * @param tree
	 *            tree being searched for character
	 * @return returns the character in morse representation. returns empty
	 *         string if not found
	 */
	private static String searchBinaryTree(char item, BinaryTree<String> tree) {
		if (tree == null) {
			return "";
		} else if (tree.getData().toLowerCase().charAt(0) == item) {

			return tree.getData().substring(1);
		} else {
			return searchBinaryTree(item, tree.getLeftSubtree()) + searchBinaryTree(item, tree.getRightSubtree());

		}

	}

	/**
	 * translates morse code to alphabetical text
	 * 
	 * @param data
	 *            data to be translated
	 * @param tree
	 *            tree to be searched
	 * @return returns alphabetical representation of provided morse string
	 */
	private static char translateFromMorseToText(String data, BinaryTree<String> tree) {
		if (data.length() == 0) {
			return tree.getData().charAt(0);
		} else {
			if (data.charAt(0) == '*') {
				return translateFromMorseToText(data.substring(1), tree.getLeftSubtree());
			} else {
				return translateFromMorseToText(data.substring(1), tree.getRightSubtree());
			}
		}

	}
}
