package edu.miracosta.cs113;

public class Student {

	private String name;
	
	/**
	 * Full constructor, specifying student name
	 * 
	 * @param name
	 *            students name
	 */
	public Student(String name){
		this.name = name;
	}
	
	/**
	 * Accessor for name
	 * 
	 * @return name of student
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Mutator for student name
	 * 
	 * @param name
	 *            new student name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * return student in String form  
	 * 
	 * @return
	 * 			Returns studnet name
	 */
	public String toString(){
		return name;
	}
	
	/**
	 * return equality of students   
	 * @param other
	 * 			Object being checked against for equality	
	 * @return
	 * 			Returns true if students have the same name.  otherwise, false
	 */
	@Override
	public boolean equals(Object other){
		return other instanceof Student && this.name.equals(((Student) other).getName());
	
	}
}
