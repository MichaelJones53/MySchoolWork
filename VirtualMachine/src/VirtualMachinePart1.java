import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class VirtualMachinePart1 {
	// ALGORITHM:
	// get input file name
	// create output file name and stream
	
	// print out "done" message to user
	// close output file stream
	public static void main(String[] args) {
		
		String inputFileName, outputFileName;
		PrintWriter outputFile = null; //keep compiler happy
	
		//get input file name from command line or console input
		if(args.length == 1) {
			System.out.println("command line arg = " + args[0]);
			inputFileName = args[0];
		}
		else
		{
			Scanner keyboard = new Scanner(System.in);

			System.out.println("Please enter assembly file name you would like to assemble.");
			System.out.println("Don't forget the .vm extension: ");
			inputFileName = keyboard.nextLine();
					
			keyboard.close();
		}
		
		outputFileName = inputFileName.substring(0,inputFileName.lastIndexOf('.')) + ".hack";
							
		try {
			outputFile = new PrintWriter(new FileOutputStream(outputFileName));
		} catch (FileNotFoundException ex) {
			System.err.println("Could not open output file " + outputFileName);
			System.err.println("Run program again, make sure you have write permissions, etc.");
			System.exit(0);
		}
		
		compilerToVM(inputFileName);
	}
	
	private static void compilerToVM(String inputFile){
		Parser parser = new Parser(inputFile);
		while(parser.hasMoreCommands()){
			parser.advance();
			if(parser.getCommandType() == 'Z'){
				//skips commented/empty lines
			}else{
				System.out.println(parser.getCommandType());
			}
			
		}
		
	}

}
