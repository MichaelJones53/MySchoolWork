import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//C:\Users\W7201584\Desktop\test.vm


/*
 * CodeWriter: Translates VM commands into Hack assembly code.
 */
public class CodeWriter {

	private PrintWriter outputFile = null;
	
	public CodeWriter(String outputFileName){
		try {
			outputFile = new PrintWriter(new FileOutputStream(outputFileName));
		} catch (FileNotFoundException ex) {
			System.err.println("Could not open output file " + outputFileName);
			System.exit(0);
		}
	}
	
	public void setFileName(String fileName){
		
	}
	
	public void writeArithmetic(String command){
		
	}
	
	public void WritePushPop(char command, String segment, int index){
		if(command == Parser.C_PUSH){
			outputFile.println(command+"   "+segment+"    "+index);
		}else{
			if(segment == "local"){
				outputFile.println("@SP");
				outputFile.println("AM=M-1");
				outputFile.println("D=M");
				outputFile.println("@R13");
				outputFile.println("M=D");
				outputFile.println("@"+index);
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
				
			}else if(segment == "static"){
				
			}else if(segment  == "this"){
				
			}else if(segment == "that"){
				
			}else if(segment == "argument"){
				
			}else if(segment == "constant"){
				
			}else if(segment == "pointer"){
				
			}else if(segment == "temp"){
				
			}
		}
		//static, this, local, argument, that, constant, pointer, temp
	}
	
	public void close(){
		outputFile.close();
	}
	
}
