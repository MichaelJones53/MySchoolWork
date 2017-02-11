package PolynomialTest;

import org.junit.Assert;
import org.junit.Test;
import edu.miracosta.cs113.Term;


public class TermTest {
	@Test
	public void testPosCoefPosExp(){
		int coef= 2;
		int exp = 4;
		testGetCoefficient(coef, exp);
		testGetExponent(coef, exp);
		testSetCoefficient(coef);
		testSetExponent(exp);
		testCompareTo(new Term(coef, exp));
		testToString(coef, exp);
		
	}
	
	@Test
	public void testPosCoefZeroExp(){
		int coef= 2;
		int exp = 0;
		testGetCoefficient(coef, exp);
		testGetExponent(coef, exp);
		testSetCoefficient(coef);
		testSetExponent(exp);
		testCompareTo(new Term(coef, exp));
		testToString(coef, exp);
		
	}
	
	@Test
	public void testPosCoefNegExp(){
		int coef= 2;
		int exp = -4;
		testGetCoefficient(coef, exp);
		testGetExponent(coef, exp);
		testSetCoefficient(coef);
		testSetExponent(exp);
		testCompareTo(new Term(coef, exp));
		testToString(coef, exp);
		
	}
	
	@Test
	public void testZeroCoefPosExp(){
		int coef= 0;
		int exp = 4;
		testGetCoefficient(coef, exp);
		testGetExponent(coef, exp);
		testSetCoefficient(coef);
		testSetExponent(exp);
		testCompareTo(new Term(coef, exp));
		testToString(coef, exp);
		
	}
	
	@Test
	public void testZeroCoefZeroExp(){
		int coef= 0;
		int exp = 0;
		testGetCoefficient(coef, exp);
		testGetExponent(coef, exp);
		testSetCoefficient(coef);
		testSetExponent(exp);
		testCompareTo(new Term(coef, exp));
		testToString(coef, exp);
		
	}
	
	@Test
	public void testZeroCoefNegExp(){
		int coef= 0;
		int exp = -4;
		testGetCoefficient(coef, exp);
		testGetExponent(coef, exp);
		testSetCoefficient(coef);
		testSetExponent(exp);
		testCompareTo(new Term(coef, exp));
		testToString(coef, exp);
		
	}
	
	@Test
	public void testNegCoefPosExp(){
		int coef= -3;
		int exp = 4;
		testGetCoefficient(coef, exp);
		testGetExponent(coef, exp);
		testSetCoefficient(coef);
		testSetExponent(exp);
		testCompareTo(new Term(coef, exp));
		testToString(coef, exp);
		
	}
	
	@Test
	public void testNegCoefZeroExp(){
		int coef= -3;
		int exp = 0;
		testGetCoefficient(coef, exp);
		testGetExponent(coef, exp);
		testSetCoefficient(coef);
		testSetExponent(exp);
		testCompareTo(new Term(coef, exp));
		testToString(coef, exp);
		
	}
	
	@Test
	public void testNegCoefNegExp(){
		int coef= -3;
		int exp = -4;
		testGetCoefficient(coef, exp);
		testGetExponent(coef, exp);
		testSetCoefficient(coef);
		testSetExponent(exp);
		testCompareTo(new Term(coef, exp));
		testToString(coef, exp);
		
	}
	
	@Test
	public void testGreaterThanCompare(){
		int callingCoef = 4;
		int callingExp = 5;
		int otherCoef = 4;
		int otherExp = 3;
		Term callingTerm = new Term(callingCoef, callingExp);
		Term otherTerm = new Term(otherCoef, otherExp);
		Assert.assertTrue(callingTerm.compareTo(otherTerm)== 1);
		
	}
	
	@Test
	public void testLessThanCompare(){
		int callingCoef = 4;
		int callingExp = 5;
		int otherCoef = 4;
		int otherExp = 9;
		Term callingTerm = new Term(callingCoef, callingExp);
		Term otherTerm = new Term(otherCoef, otherExp);
		Assert.assertTrue(callingTerm.compareTo(otherTerm)== -1);
		
	}
	
	@Test
	public void testEqualToCompare(){
		int callingCoef = 4;
		int callingExp = 5;
		int otherCoef = 4;
		int otherExp = 5;
		Term callingTerm = new Term(callingCoef, callingExp);
		Term otherTerm = new Term(otherCoef, otherExp);
		Assert.assertTrue(callingTerm.compareTo(otherTerm)== 0);	
	}
	
	@Test
	public void testEqualTo(){
		int callingCoef = 4;
		int callingExp = 5;
		int otherCoef = 4;
		int otherExp = 5;
		Term callingTerm = new Term(callingCoef, callingExp);
		Term otherTerm = new Term(otherCoef, otherExp);
		Assert.assertTrue(callingTerm.equals(otherTerm));
	}
	
	@Test
	public void testNotEqualToDifferentCoefficient(){
		int callingCoef = 2;
		int callingExp = 3;
		int otherCoef = 4;
		int otherExp = 5;
		Term callingTerm = new Term(callingCoef, callingExp);
		Term otherTerm = new Term(otherCoef, otherExp);
		Assert.assertFalse(callingTerm.equals(otherTerm));
	}
	@Test
	public void testNotEqualToDifferentExponent(){
		int callingCoef = 4;
		int callingExp = 2;
		int otherCoef = 4;
		int otherExp = 3;
		Term callingTerm = new Term(callingCoef, callingExp);
		Term otherTerm = new Term(otherCoef, otherExp);
		Assert.assertFalse(callingTerm.equals(otherTerm));
	}
	@Test
	public void testNotEqualToDifferentClass(){
		int callingCoef = 4;
		int callingExp = 3;
		Term callingTerm = new Term(callingCoef, callingExp);
		Assert.assertFalse(callingTerm.equals(new Object()));
	}
	@Test
	public void testNotEqualTo1(){
		int callingCoef = 4;
		int callingExp = 3;
		int otherCoef = 4;
		int otherExp = 5;
		Term callingTerm = new Term(callingCoef, callingExp);
		Term otherTerm = new Term(otherCoef, otherExp);
		Assert.assertFalse(callingTerm.equals(otherTerm));
	}
	public void testGetCoefficient(int testCoef, int testExp){
		Term testTerm = new Term(testCoef, testExp);
		Assert.assertTrue(testTerm.getCoefficient() == testCoef);
	}
	public void testGetExponent(int testCoef, int testExp){
		Term testTerm = new Term(testCoef, testExp);
		Assert.assertTrue(testTerm.getExponet() == testExp);
	}
	
	public void testSetCoefficient(int newCoefficient){
		Term testTerm = new Term(3, 5);
		testTerm.setCoefficient(newCoefficient);
		Assert.assertTrue(testTerm.getCoefficient() == newCoefficient);
	}
	
	public void testSetExponent(int newExponent){
		Term testTerm = new Term(3, 5);
		testTerm.setExponet(newExponent);
		Assert.assertTrue(testTerm.getExponet() == newExponent);
	}
	
	public void testCompareTo(Term otherTerm){
		Term testTerm = new Term(3, 5);
		if(testTerm.getExponet() < otherTerm.getExponet()){
			Assert.assertTrue(testTerm.compareTo(otherTerm) == -1);
		}else if(testTerm.getExponet() > otherTerm.getExponet()){
			Assert.assertTrue(testTerm.compareTo(otherTerm) == 1);
		}else if(testTerm.getExponet() == otherTerm.getExponet()){
			Assert.assertTrue(testTerm.compareTo(otherTerm) == 0);
		}
		
	}
	
	public void testToString(int testCoef, int testExp){
		Term testTerm = new Term(testCoef, testExp);
		Assert.assertTrue(testTerm.toString().equals(testCoef+"^"+testExp));
	}
}
