package edu.miracosta.cs113;

public class Term implements Comparable<Term> {

	int coefficient;
	int exponent;
	/**
	 * Full constructor, specifying each part of Term
	 * 
	 * @param coef
	 *            integer polynomials coefficient
	 * @param exp
	 *            integer polynomials exponent
	 */
	public Term(int coef, int exp){
		coefficient = coef;
		exponent = exp;
	}
	
	
	
	/**
	 * Accessor for coefficient value
	 * 
	 * @return coefficient integer value
	 */
	public int getCoefficient() {
		return coefficient;
	}



	/**
	 * Mutator for coefficient value
	 * 
	 * @param coefficient
	 *            new coefficient value
	 */
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}



	/**
	 * Accessor for exponent value
	 * 
	 * @return exponent integer value
	 */
	public int getExponet() {
		return exponent;
	}

	/**
	 * Mutator for exponent value
	 * 
	 * @param exponent
	 *            integer value representing the new exponent
	 */
	public void setExponet(int exponent) {
		this.exponent = exponent;
	}

	/**
	 * Compares calling terms exponent with another terms exponent.  
	 * 
	 * @param comparingNode
	 * 			Term being used to compare against
	 * @return
	 * 			Returns 1 if calling instance is greater than comparing term,
	 * -1 if it is less than, or 0 if it is equal to.
	 */
	@Override
	public int compareTo(Term comparingNode) {
		if(this.exponent < comparingNode.exponent){
			return -1;
		}else if(this.exponent > comparingNode.exponent){
			return 1;
		}else
		return 0;
	}
	/**
	 * return polynomial in String form  
	 * 
	 * @return
	 * 			Returns String version of polynomial.
	 */
	@Override
	public String toString(){
		return coefficient+"^"+exponent;
	}
	
	/**
	 * return equality of calling Term to passed object  
	 * @param other
	 * 			Objecting being checked against for equality	
	 * @return
	 * 			Returns true if passed object if a Term and has the same coefficient and exponent values.
	 */
	@Override
	public boolean equals(Object other){
		if(other instanceof Term && ((Term) other).coefficient == this.coefficient && ((Term)other).exponent == this.exponent){
			return true;
		}else{
			return false;
		}
	}

}
