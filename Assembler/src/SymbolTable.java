
public class SymbolTable {

	//DESCRIPTION:		initializes hashmap with predefined symbols
	//PRECONDITION:		follows symbol/values from book/appendix
	//POSTCONDITION:	all hashmaps values have valid address integer
	public SymbolTable(){
		
	}
	//DESCRIPTION:		adds new pair of symbol/address to hashmap	
	//PRECONDITION:		symbol/address pair not in hashmap (check contains() 1st)
	//POSTCONDITION:	adds pair, returns true if addes, false if illegal name
	public boolean addEntry(String symbol, int address){
		//STUB
		return false;
	}
	
	//DESCRIPTION:		returns boolean of whether hashmap has symbol or not	
	//PRECONDITION:		table has been initalized
	//POSTCONDITION:	returns boolean if arg is in table or not
	public boolean contains(String symbol){
		//STUB
		return false;
	}
	
	//DESCRIPTION:		returns address in hashmap of given symbol
	//PRECONDITION:		symbol is in hashmap (check w/ contains() first)
	//POSTCONDITION:	returns address associated with symbol in hashmap
	public int getAddress(String symbol){
		//stub
		return -1;
	}
	
	
	public boolean isValidName(String symbol){
		//stub
		return false;
	}
	
	
	
}
