package tests;
import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.SymbolTable;


public class SymbolTableTests {
	
	
	@Test
	public void testAddEntry(){
		SymbolTable st = new SymbolTable();
		Assert.assertFalse(st.contains("test"));
		st.addEntry("test", 1010101);
		Assert.assertTrue(st.contains("test"));
	}
	
	@Test
	public void testContains(){
		SymbolTable st = new SymbolTable();
		Assert.assertFalse(st.contains("test"));
		Assert.assertTrue(st.contains("KBD"));
	}
	
	@Test
	public void testGetAddress(){
		SymbolTable st = new SymbolTable();
		Assert.assertTrue(st.getAddress("R0") == 0);
		Assert.assertTrue(st.getAddress("R15") == 15);
	}
	
	@Test
	public void isValidName(){
		SymbolTable st = new SymbolTable();
		Assert.assertFalse(SymbolTable.isValidName("!"));
		Assert.assertFalse(SymbolTable.isValidName("1Asdf"));
		Assert.assertTrue(SymbolTable.isValidName("_"));
		Assert.assertTrue(SymbolTable.isValidName("$asdf"));
		Assert.assertFalse(SymbolTable.isValidName(""));
		Assert.assertFalse(SymbolTable.isValidName(null));
		
	}
}
