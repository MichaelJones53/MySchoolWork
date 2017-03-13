package edu.miracosta.cs113;

import java.util.Scanner;

public class Parser {
	private static final char NO_COMMAND = 'N';
	private static final char A_COMMAND = 'A';
	private static final char C_COMMAND = 'C';
	private static final char L_COMMAND = 'L';
	
	private Scanner inputFile = new Scanner(System.in);
	private int lineNumber;
	private String cleanLine;
	private String rawLine;
	private char commandType;
	private String symbol;
	private String destMnemonic;
	private String compMnemonic;
	private String jumpMnemonic;
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public Parser(String inFileName){
		
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public boolean hasMoreCommands(){
		//STUB
		return false;
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public void advance(){
		//STUB
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
			}
			else if(cleanLine.charAt(0) == 'M' || cleanLine.charAt(0) == 'A' || cleanLine.charAt(0) == 'D' || cleanLine.charAt(0) == '0' ){
				commandType = C_COMMAND;
			}else if(cleanLine.charAt(0) == '('){
				commandType = L_COMMAND;
			}else{
				commandType = NO_COMMAND;
			}
		}
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	private void parse(){
		//stub
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	private void parseSymbol(){
		//stub
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	private void parseDest(){
		//stub
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	private void parseComp(){
		//stub
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	private void parseJump(){
		//stub
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public char getCommandType(){
		//stub
		return 'a';
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public String getSymbol(){
		//stub
		return "a";
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public String getDest(){
		//stub
		return "a";
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public String getComp(){
		//stub
		return "a";
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public String getJump(){
		//stub
		return "a";
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public String getCommandTypeString(){
		//stub
		return "a";
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public String getRawLine(){
		//stub
		return "a";
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public String getCleanLine(){
		//stub
		return "a";
	}
	
	//DESCRIPTION:
	//PRECONDITION:
	//POSTCONDITION:
	public String getLineNumber(){
		//stub
		return "a";
	}
	
	
	
	
	
	
	
	
	
	
	

}
