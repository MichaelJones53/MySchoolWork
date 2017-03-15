package edu.miracosta.cs113;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
	private static final char NO_COMMAND = 'N';
	private static final char A_COMMAND = 'A';
	private static final char C_COMMAND = 'C';
	private static final char L_COMMAND = 'L';
	
	private Scanner inputFile;
	private int lineNumber = 0;
	private String cleanLine;
	private String rawLine;
	private char commandType;
	private String symbol;
	private String destMnemonic;
	private String compMnemonic;
	private String jumpMnemonic;
	
	//DESCRIPTION:		opens input file/stream and prepares to parse
	//PRECONDITION:		provided file in ASM file
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
			cleanLine = rawLine;
			int commentLocation = cleanLine.indexOf("/");
			if(commentLocation != -1){
				cleanLine = cleanLine.substring(0,commentLocation);
			}
			cleanLine = cleanLine.replaceAll("\t", "");
			cleanLine = cleanLine.replaceAll(" ", "");
		}
		
		//DESCRIPTION:		determines command type from parameter
		//PRECONDITION:		String parameter is clean instruction
		//POSTCONDITION:	sets commandType to 'A' (A-instruction),'C'(C-instruction), 'L'(Label), or 'N' (no command)
		private void parseCommandType(){
			if(cleanLine != null && !cleanLine.isEmpty()){
				if(cleanLine.charAt(0) == '@'){
					commandType = A_COMMAND;
					lineNumber++;
				}
				else if(cleanLine.charAt(0) == 'M' || cleanLine.charAt(0) == 'A' || cleanLine.charAt(0) == 'D' || cleanLine.charAt(0) == '0' ){
					commandType = C_COMMAND;
					lineNumber++;
				}else if(cleanLine.charAt(0) == '('){
					commandType = L_COMMAND;
				}else{
					commandType = NO_COMMAND;
				}
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
	
	//DESCRIPTION:		reads next line from file and parses it into instance vars
	//PRECONDITION:		file stream is open, called only if hasMoreCommands()
	//POSTCONDITION:	current instruction parts put into instance vars
	public void advance(){
		//not finished
		cleanLine = null;
		rawLine = null;
		commandType = 'N';
		symbol = null;
		destMnemonic = null;
		compMnemonic = null;
		jumpMnemonic = null;
		if(hasMoreCommands()){
			rawLine = inputFile.nextLine();
			cleanLine();
			parse();
		}
	}
	
	
	//DESCRIPTION:		helper method parses line depending on instruction type
	//PRECONDITION:		advance() called so cleanLine has value
	//POSTCONDITION:	appropriate parts (instance vars) of instruction filled
	private void parse(){
		//stub
		parseCommandType();
		if(commandType == A_COMMAND){
			parseSymbol();
		}else if(commandType == C_COMMAND){
			parseDest();
			parseComp();
			parseJump();
		}else if(commandType == L_COMMAND){
			parseSymbol();
		}else{
			// no command
		}
	}
	
	//DESCRIPTION:		parses symbol for A- or L-commands
	//PRECONDITION:		advanced() called so cleanLine has value, call for A- and L-commands only
	//POSTCONDITION:	symbol has appropriate value from instruction assigned
	private void parseSymbol(){
		if(cleanLine.charAt(0) == '@'){
			symbol = cleanLine.substring(1);
		}else{
			symbol = cleanLine.substring(1, cleanLine.indexOf(")"));
		}
	}
	
	//DESCRIPTION:		helper method parses line to get dest part
	//PRECONDITION:		advance() called so cleanLine has value, call for C-Instructions only 
	//POSTCONDITION:	destMnemonic set to appropriate value from instruction
	private void parseDest(){
		//stub
		if(cleanLine.contains("=")){
			destMnemonic = cleanLine.substring(0, cleanLine.indexOf("="));
		}
		
		
	}
	
	//DESCRIPTION:		helper method parses line to get comp part
	//PRECONDITION:		advance() called so cleanLine has value, call for C-instructions only
	//POSTCONDITION:	compMnemonic set to appropriate value from instruction
	private void parseComp(){
		//stub
		if(cleanLine.contains("=")){
			compMnemonic = cleanLine.substring(cleanLine.indexOf("=")+1);
		}else{
			compMnemonic = cleanLine.substring(0, cleanLine.indexOf(";"));
		}
	}
	
	//DESCRIPTION:		helper method parses line to get jump part
	//PRECONDITION:		advance() called so cleanLine has value, call for C-instruction only
	//POSTCONDITION:	jumMnemonic set to appropriate value from instruction
	private void parseJump(){
		//stub
		if(cleanLine.contains(";")){
			jumpMnemonic = cleanLine.substring(cleanLine.indexOf(';')+1);
		}
	}
	
	//DESCRIPTION:		getter for command type
	//PRECONDITION:		cleanLine has been parsed (advance was called)
	//POSTCONDITION:	returns char for command type (N/A/C/L)
	public char getCommandType(){
		//stub
		return commandType;
	}
	
	//DESCRIPTION:		getter for symbol name
	//PRECONDITION:		cleanLine has been parsed (advance was called), call for labels only (use getCommandType())
	//POSTCONDITION:	returns string for symbol name
	public String getSymbol(){
		//stub
		return symbol;
	}
	
	//DESCRIPTION:		getter  for dest of C-instruction
	//PRECONDITION:		cleanLine has been parsed (advance was called), call for C-instruction only (use getCommandType())
	//POSTCONDITION:	returns mnemonic (ASM symbol) for dest part
	public String getDest(){
		//stub
		return destMnemonic;
	}
	
	//DESCRIPTION:		getter for comp of C-instruction
	//PRECONDITION:		cleanLine has been parsed (advance was called), call for C-instruction only (use getCommandType())
	//POSTCONDITION:	returns mnemonic (ASM symbol) for comp part
	public String getComp(){
		//stub
		return compMnemonic;
	}
	
	//DESCRIPTION:		getter for jump part of C-instruction
	//PRECONDITION:		cleanLine has been parsed (advance was called), call for C-instruction only (use getCommandType())
	//POSTCONDITION:	returns mnemonic (ASM symbol) for comp part
	public String getJump(){
		//stub
		return jumpMnemonic;
	}
	
	//DESCRIPTION:		getter for string version of command type (debugging)
	//PRECONDITION:		advance() and parse() have been called
	//POSTCONDITION:	returns string version of command type
	public String getCommandTypeString(){
		return ""+commandType;
	}
	
	//DESCRIPTION:		getter for rawLine from file (debugging)
	//PRECONDITION:		advance() was called to put value from file in here
	//POSTCONDITION:	returns string of current original line from file
	public String getRawLine(){
		return rawLine;
	}
	
	//DESCRIPTION:		getter for cleanLine from file (debugging)
	//PRECONDITION:		advance() was called to put value from file in here
	//POSTCONDITION:	returns string of current clean instruction from file
	public String getCleanLine(){
		return cleanLine;
	}
	
	//DESCRIPTION:		getter for lineNumber (debugging)
	//PRECONDITION:		n/a
	//POSTCONDITION:	returns line number currently being processed from file
	public int getLineNumber(){
		return lineNumber;
	}
	
	
	
	
	
	
	
	
	
	
	

}
