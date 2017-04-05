
import java.util.Scanner;

//C:\Users\W7201584\Desktop\test.vm


public class VirtualMachinePart1 {
	// ALGORITHM:
	// get input file name
	// create output file name and stream
	
	// print out "done" message to user
	// close output file stream
	public static void main(String[] args) {
		
		String inputFileName, outputFileName;
	
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
		
		outputFileName = inputFileName.substring(0,inputFileName.lastIndexOf('.')) + ".txt";
							
		compilerToVM(inputFileName, inputFileName.substring(0,inputFileName.lastIndexOf('.')) + ".txt");
	}
	
	private static void compilerToVM(String inFile, String outFile){
		Parser parser = new Parser(inFile);
		CodeWriter codeWriter = new CodeWriter(outFile);
		while(parser.hasMoreCommands()){
			parser.advance();
			if(parser.getCommandType() == 'Z'){
				//skips commented/empty lines
			}else if(parser.getCommandType() == Parser.C_PUSH || parser.getCommandType() == Parser.C_POP){
				codeWriter.WritePushPop(parser.getCommandType(), parser.arg1() , parser.arg2());
				
			}
			
		}
		System.out.println("Done");
		codeWriter.close();
		
	}

}
