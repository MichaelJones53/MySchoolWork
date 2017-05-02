package edu.miracosta.cs113;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	private static final int NUMBER_TO_READ = 10;
	private static int data[];
	private static Scanner scannerMainFile = null;
	private static Scanner outputFileIn = null;
	private static Scanner outputA = null;
	private static Scanner outputB = null;
	private static PrintWriter writer = null;

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		String response = "";
		boolean isEntering = true;

		String file = "";
		String outputFileA = "outputA.txt";
		String outputFileB = "outputB.txt";
		String destinationFile = "";
		

		System.out.println("enter the path of the file of integers to be sorted "
				+ "\nor enter \"default\" (without the quotes) to use the toBeSorted file in the project folder");
		file = userIn.nextLine();

		if (file.toLowerCase().equals("default")) {
			file = "toBeSorted.txt";
		}

		try {
			scannerMainFile = new Scanner(new FileInputStream(file));

		} catch (FileNotFoundException e) {
			System.out.println("file not found.  program closing " + e.getMessage());
			System.exit(0);
		}

		
		try {

			writer = new PrintWriter(new FileOutputStream(outputFileA));
			writer = new PrintWriter(new FileOutputStream(outputFileB));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();

		while (scannerMainFile.hasNext()) {

			
			data = readInData(NUMBER_TO_READ);
		
			data = Sort.intArrayMergeSort(data);
			writeFile("outputA.txt");

			if (scannerMainFile.hasNext()) {

				data = readInData(NUMBER_TO_READ);
				data = Sort.intArrayMergeSort(data);
				writeFile("outputB.txt");

			}
		}

		scannerMainFile.close();

		while (isEntering) {
			System.out.println("enter \"same\" to overwrite the datafile with the sorted data or "
					+ "\nenter \"new\" to store data in new file titled \"destination\"");

			response = userIn.nextLine();
			if (response.equalsIgnoreCase("same")) {
				destinationFile = file;
				isEntering = false;
			} else if (response.equalsIgnoreCase("new")) {
				destinationFile = "destination.txt";
				isEntering = false;
			}else{
				System.out.println("invalid entry.  Try again.");
			}
		}

		userIn.close();
		
		try {
			writer = new PrintWriter(new FileOutputStream(destinationFile));
			outputA = new Scanner(new FileInputStream(outputFileA));
			outputB = new Scanner(new FileInputStream(outputFileB));
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
			System.out.println("Program closing");
			System.exit(0);
		}

		Sort.fileMergeSort(outputA, outputB, writer);
		writer.close();
		outputA.close();
		outputB.close();
		System.out.println("the file has been sorted.");

	}

	/**
	 * Helper Method.  reads in data from the main file to be sorted
	 * @param reads
	 * 		number of integers to read form the file
	 * @return
	 * 		returns arraylist of items read from the file
	 */
	private static int[] readInData(int reads) {
		ArrayList<Integer> newData = new ArrayList<Integer>();
		for (int i = 0; i < reads; i++) {
			newData.add(scannerMainFile.nextInt());

			if (!scannerMainFile.hasNext()) {
				i = reads;
			}
		}

		return toArray(newData);

	}
	/**
	 * Helper method.  Converts ArrayList<Integer> t int[]
	 * @param data
	 * 		ArrayList to be converted to array
	 * @return
	 * 		returns int array version of data
	 */

	private static int[] toArray(ArrayList<Integer> data) {
		int[] newData = new int[data.size()];
		for (int i = 0; i < data.size(); i++) {
			newData[i] = data.get(i);
		}

		return newData;
	}
/**
 * Helper method. writes data to file
 * @param fileName
 * 		name of the file to be written to
 */
	private static void writeFile(String fileName) {
		boolean fileFound = false;
		ArrayList<Integer> fileData = new ArrayList<Integer>();
		int[] newData;

		try {
			outputFileIn = new Scanner(new FileInputStream(fileName));
			fileFound = true;

		} catch (FileNotFoundException e) {
			fileFound = false;
		}

		if (fileFound) {

		
			while (outputFileIn.hasNext()) {

				fileData.add(new Integer(outputFileIn.next()));
			}
			outputFileIn.close();
		}
		
		newData = toArray(fileData);

		data = Sort.mergeSort(data, newData);
	
		try {

			writer = new PrintWriter(new FileOutputStream(fileName));

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		for (int i = 0; i < data.length; i++) {

			writer.println("" + data[i]);

		}
		writer.close();
	}

}
