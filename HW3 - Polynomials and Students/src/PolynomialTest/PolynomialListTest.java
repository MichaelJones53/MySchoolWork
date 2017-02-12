package PolynomialTest;

import org.junit.Assert;
import org.junit.Test;
import edu.miracosta.cs113.PolynomialList;
import edu.miracosta.cs113.Term;


public class PolynomialListTest {

	
	
	
	@Test
	public void testAdd(){
		Term tempTerm = new Term(5, 6);
		PolynomialList<Term> list = new PolynomialList<>();
		list.add(tempTerm);
		Assert.assertTrue(list.get(0).equals(tempTerm));
	}
	
	@Test
	public void testGet(){
		Term tempTerm = new Term(1, 2);
		PolynomialList<Term> list = new PolynomialList<>();
		list.add(new Term(4,3));
		list.add(tempTerm);
		Assert.assertTrue(list.get(1).equals(tempTerm));
		
	}
	@Test
	public void testGetSize(){
		Term tempTerm = new Term(1, 2);
		PolynomialList<Term> list = new PolynomialList<>();
		list.add(new Term(4,3));
		list.add(tempTerm);
		Assert.assertTrue(list.getSize() == 2);
		
	}
	
	@Test
	public void testToString(){
		Term tempTerm = new Term(1, 2);
		PolynomialList<Term> list = new PolynomialList<>();
		list.add(tempTerm);
		Assert.assertTrue(list.toString().equals(tempTerm.getCoefficient()+"X^"+tempTerm.getExponet()));
		
	}
}
