import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

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
	
	public void WritePushPop(char commmand, String segment, int index){
		
	}
	
	public void close(){
		
	}
	
}
