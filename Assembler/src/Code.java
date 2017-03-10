import java.util.HashMap;



public class Code {

	private HashMap<String, String> compCodes;
	private HashMap<String, String> destCodes;
	private HashMap<String, String> jumpCodes;
	
	public Code(){
		compCodes = new HashMap<String, String>();
		destCodes = new HashMap<String, String>();
		jumpCodes = new HashMap<String, String>();
		
		compCodes.put("0", "0101010");
		compCodes.put("1", "0111111");
		compCodes.put("-1", "0111010");
		compCodes.put("D", "0001100");
		compCodes.put("A", "0110000");
		compCodes.put("!D", "0001101");
		compCodes.put("!A", "0110001");
		compCodes.put("-D", "0001111");
		compCodes.put("-A", "0110011");
		compCodes.put("D+1", "0011111");
		compCodes.put("1+D", "0011111");
		compCodes.put("A+1", "0110111");
		compCodes.put("1+A", "0110111");
		compCodes.put("D-1", "0001110");
		compCodes.put("A-1", "0110010");
		compCodes.put("D+A", "0000010");
		compCodes.put("A+D", "0000010");
		compCodes.put("D-A", "0010011");
		compCodes.put("A-D", "0000111");
		compCodes.put("D&A", "0000000");
		//should i have an A&D?
		compCodes.put("D|A", "0010101");
		
		
		
		
	}
}
