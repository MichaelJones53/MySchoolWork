/**
*parses lines from .vm file. @author Michael Jones
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * Handles the parsing of a single .vm file, and encapsulates access to the input code. It reads VM commands,
 * parses them, and provides convenient access to their components. In addition, it removes all white space and comments.
 */



public class Parser {

	public static final char C_ARITHMETIC = 'A';
	public static final char C_PUSH = 'P';
	public static final char C_POP = 'O';
	
	
	private Scanner inputFile;
	private char commandType;
	private String rawLine;
	private String cleanLine;
	

	//DESCRIPTION:		opens input file/stream and prepares to parse
	//PRECONDITION:		provided file is .vm file
	//POSTCONDITION:	if file can't be opened, ends program w/error message
	public Parser(String inFileName){
		try{
			inputFile = new Scanner(new FileInputStream(inFileName));
		}catch(IOException e){
			System.out.println("error, could not open file: "+inFileName);
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
	}
	//DESCRIPTION:		cleans raw instruction by removing non-essential parts
	//PRECONDITION:		String parameter given (not null)
	//POSTCONDITION:	returned without comments and whitespace
	private void cleanLine(){
		cleanLine = rawLine.trim();
		int commentLocation = cleanLine.indexOf("/");
		if(commentLocation != -1){
			cleanLine = cleanLine.substring(0,commentLocation).trim();
		}
	}

	
	//DESCRIPTION:		returns boolean if more commands left, closes stream if not
	//PRECONDITION:		file stream is open
	//POSTCONDITION:	returns true if more commands, else closes stream
	public boolean hasMoreCommands(){
		if(inputFile.hasNextLine()){
			return true;
		}else{
			inputFile.close();
			return false;
		}
		
	}
	
	//DESCRIPTION:		Reads the next command from the input and makes it the current command
	//PRECONDITION:		file stream is open, called only if hasMoreCommands()
	//POSTCONDITION:	current command set from input file
	public void advance(){
		//not finished
				cleanLine = null;
				rawLine = null;
				commandType = 'Z';
				if(hasMoreCommands()){
					rawLine = inputFile.nextLine();
					cleanLine();
					parseCommandType();
					
				}
	}
	
	//DESCRIPTION:		determines command type from current line
	//PRECONDITION:		String parameter is clean instruction
	//POSTCONDITION:	sets commandType to appropriate command type
	private void parseCommandType(){
		if(cleanLine.startsWith("push")){
			commandType = C_PUSH;
		
		}else if(cleanLine.startsWith("pop")){
			commandType = C_POP;
			
		}else{
			commandType = C_ARITHMETIC;
		}
	}
	
	
	/*
	 * Returns the first arg. of the current command.
	 * In the case of C_ARITHMETIC, the command itself
	 * (add, sub, etc.) is returned. Should not be called
	 * if the current command is C_RETURN.
	 */
	public String arg1(){
		if(commandType == C_ARITHMETIC){
			return cleanLine;
		}else{
			int firstSpace = cleanLine.indexOf(" ");
			String argumentsString = cleanLine.substring(firstSpace+1);
			
			return argumentsString.substring(0, argumentsString.indexOf(' '));
		}
	}
	
	/*
	 * Returns the second argument of the current
	 * command. Should be called only if the current
	 * command is C_PUSH, C_POP, C_FUNCTION, or
	 * C_CALL. 
	 */
	public int arg2(){
		String argumentsString = cleanLine.substring(cleanLine.lastIndexOf(" "));
		return Integer.parseInt(argumentsString.substring(argumentsString.indexOf(" ")+1));
	}
	
	//DESCRIPTION:		getter for command type
	//PRECONDITION:		advance has been called
	//POSTCONDITION:	returns char for command type
	public char getCommandType(){
		
		return commandType;
	}
	

}
