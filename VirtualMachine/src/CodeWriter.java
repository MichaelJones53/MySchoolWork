import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//C:\Users\W7201584\Desktop\test.vm

/*
 * CodeWriter: Translates VM commands into Hack assembly code.
 */
public class CodeWriter {

	private PrintWriter outputFile = null;
	private String fileName = null;

	public CodeWriter(String outputFileName) {
		try {
			outputFile = new PrintWriter(new FileOutputStream(outputFileName));
			
		} catch (FileNotFoundException ex) {
			System.err.println("Could not open output file " + outputFileName);
			System.exit(0);
		}
		setFileName(outputFileName.toUpperCase());
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

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

	public void WritePushPop(char command, String segment, int index) {

		if (command == Parser.C_PUSH) {

			if (segment == "local") {

			} else if (segment.equals("static")) {
				
				
			} else if (segment.equals("this")) {

			} else if (segment.equals("that")) {

			}else if (segment.equals("constant")) {
				outputFile.println("//push constant entered");

				outputFile.println("@" + index);
				outputFile.println("D=A");
				outputFile.println("@SP");
				outputFile.println("A=M");
				outputFile.println("M=D");
				outputFile.println("@SP");

				outputFile.println("M=M+1");
				outputFile.println("//push constant ended");

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
				
			} else if (segment.equals("this")) {

			} else if (segment.equals("that")) {

			} else if (segment.equals("constant")) {

			}
		}
	}

	public void close() {
		outputFile.close();
	}

}
