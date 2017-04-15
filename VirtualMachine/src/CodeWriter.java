/**
*generates .asm code from parsed vm sting commands. @author Michael Jones
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


/*
 * CodeWriter: Translates VM commands into Hack assembly code.
 */
public class CodeWriter {

	private PrintWriter outputFile = null;
	private String fileName = null;

	//DESCRIPTION:		Opens the output file/stream and gets ready to write into it
	//PRECONDITION:		output file name provided
	//POSTCONDITION:	if file can't be opened, ends program w/error message
	public CodeWriter(String outputFileName) {
		try {
			outputFile = new PrintWriter(new FileOutputStream(outputFileName));
			
		} catch (FileNotFoundException e) {
			System.err.println("Could not open output file " + outputFileName);
			System.exit(0);
		}
		setFileName(outputFileName.toUpperCase());
	}

	//DESCRIPTION:		Informs the code writer that the translation of a new VM file is started.
	//PRECONDITION:		file name porvided
	//POSTCONDITION:	filename variable set to provided file name
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	//DESCRIPTION:		Writes the assembly code that is the translation of the given arithmetic command.
	//PRECONDITION:		command has been parsed from VM line
	//POSTCONDITION:	writes .asm code for provided arthimetic command
	public void writeArithmetic(String command) {
		if (command.equals("add")) {
			outputFile.println("//add called");
			outputFile.println("@SP");
			outputFile.println("AM=M-1");
			outputFile.println("D=M");
			outputFile.println("A=A-1");
			outputFile.println("M=M+D");
			outputFile.println("//add ended");
		} else if (command.equals("sub")) {
			outputFile.println("//sub called");
			outputFile.println("@SP");
			outputFile.println("AM=M-1");
			outputFile.println("D=M");
			outputFile.println("A=A-1");
			outputFile.println("M=M-D");
			outputFile.println("//sub ended");
		} else if (command.equals("and")) {
			outputFile.println("//and called");
			outputFile.println("@SP");
			outputFile.println("AM=M-1");
			outputFile.println("D=M");
			outputFile.println("A=A-1");
			outputFile.println("M=M&D");
			outputFile.println("//and ended");
		} else if (command.equals("or")) {
			outputFile.println("//or called");
			outputFile.println("@SP");
			outputFile.println("AM=M-1");
			outputFile.println("D=M");
			outputFile.println("A=A-1");
			outputFile.println("M=M|D");
			outputFile.println("//or ended");
		} else if (command.equals("eq")) {
			outputFile.println("//eq called");
			outputFile.println("@SP");
			outputFile.println("A=M-1");
			outputFile.println("A=A-1");
			outputFile.print("D=M");
			outputFile.println("A=A+1");
			outputFile.println("D=D-M");
			outputFile.println("@_1");
			outputFile.println("D;JEQ");
			outputFile.println("@_2");
			outputFile.println("D=0");
			outputFile.println("0;JMP");
			outputFile.println("(_1)");
			outputFile.println("D=-1");
			outputFile.println("(_2)");
			outputFile.println("@SP");
			outputFile.println("AM=M-1");
			outputFile.println("A=A-1");
			outputFile.println("M=D");
			outputFile.println("//eq ended");
		} else if (command.equals("lt")) {
			outputFile.println("//lt called");
			outputFile.println("@SP");
			outputFile.println("A=M-1");
			outputFile.println("A=A-1");
			outputFile.print("D=M");
			outputFile.println("A=A+1");
			outputFile.println("D=D-M");
			outputFile.println("@_1");
			outputFile.println("D;JLT");
			outputFile.println("@_2");
			outputFile.println("D=0");
			outputFile.println("0;JMP");
			outputFile.println("(_1)");
			outputFile.println("D=-1");
			outputFile.println("(_2)");
			outputFile.println("@SP");
			outputFile.println("AM=M-1");
			outputFile.println("A=A-1");
			outputFile.println("M=D");
			outputFile.println("//lt ended");
		} else if (command.equals("gt")) {
			outputFile.println("//gt called");
			outputFile.println("@SP");
			outputFile.println("A=M-1");
			outputFile.println("A=A-1");
			outputFile.print("D=M");
			outputFile.println("A=A+1");
			outputFile.println("D=D-M");
			outputFile.println("@_1");
			outputFile.println("D;JGT");
			outputFile.println("@_2");
			outputFile.println("D=0");
			outputFile.println("0;JMP");
			outputFile.println("(_1)");
			outputFile.println("D=-1");
			outputFile.println("(_2)");
			outputFile.println("@SP");
			outputFile.println("AM=M-1");
			outputFile.println("A=A-1");
			outputFile.println("M=D");
			outputFile.println("//gt ended");
		}
	}

	//DESCRIPTION:		Writes the assembly code that is the translation of the given command, where command is either C_PUSH or C_POP.
	//PRECONDITION:		command has been parsed from VM line
	//POSTCONDITION:	writes .asm code for provided push/pop command
	public void WritePushPop(char command, String segment, int index) {

		if (command == Parser.C_PUSH) {

			if (segment.equals("constant")) {
				outputFile.println("@" + index);
				outputFile.println("D=A");
				outputFile.println("@SP");
				outputFile.println("A=M");
				outputFile.println("M=D");
				outputFile.println("@SP");
				outputFile.println("M=M+1");

			}

		} else {
			if (segment.equals("local")) {
				outputFile.println("@SP");
				outputFile.println("AM=M-1");
				outputFile.println("D=M");
				outputFile.println("@R13");
				outputFile.println("M=D");
				outputFile.println("@" + index);
				outputFile.println("D=A");
				outputFile.println("@LCL");
				outputFile.println("D=M+D");
				outputFile.println("@R13");
				outputFile.println("M=D");
				outputFile.println("@SP");
				outputFile.println("AM=M-1");
				outputFile.println("D=M");
				outputFile.println("@R13");
				outputFile.println("A=M");
				outputFile.println("M=D");

			} else if (segment.equals("static")) {
				outputFile.println("@SP");
				outputFile.println("AM=M-1");
				outputFile.println("D=M");
				outputFile.println(fileName+"."+index);
				outputFile.println("M=D");
				
			}
		}
	}

	//DESCRIPTION:		Closes the output file.
	//PRECONDITION:		file is open
	//POSTCONDITION:	file is closed
	public void close() {
		outputFile.close();
	}

}
