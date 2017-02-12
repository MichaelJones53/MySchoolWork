package PolynomialTest;

import org.junit.Test;

import edu.miracosta.cs113.Student;
import edu.miracosta.cs113.StudentList;
import org.junit.Test;
import org.junit.Assert;

public class StudentListTest {

	@Test
	public void testAddFirst1(){
		Student testStudent = new Student("Honey");
		StudentList<Student> list = new StudentList<>(new Student("Mark"));
		list.addEnd(new Student("Tom"));
		list.addFirst(testStudent);
		Assert.assertTrue(list.get(0).equals(testStudent));
	}
	
	@Test
	public void testAddFirst2(){
		Student testStudent = new Student("Honey");
		StudentList<Student> list = new StudentList<>();
		list.addFirst(testStudent);
		Assert.assertTrue(list.get(0).equals(testStudent));
	}
	
	@Test
	public void testRemoveFirst(){
		System.out.println("testing removeFirst");
		Student testStudent = new Student("Honey");
		StudentList<Student> list = new StudentList<>(new Student("Butters"));
		list.addFirst(testStudent);
		System.out.println(list.toString());
		System.out.println("removing first...");
		list.removeFirst();
		System.out.println(list.toString());
		
	}
	
	@Test
	public void testRemoveSpecific(){
		System.out.println("------------------");
		System.out.println("testing removeSpecific");
		Student testStudent = new Student("Honey");
		StudentList<Student> list = new StudentList<>(new Student("Butters"));
		list.addFirst(testStudent);
		System.out.println(list.toString());
		System.out.println("removing \"Honey\"...");
		list.removeSpecific(new Student("Butters"));
		System.out.println(list.toString());
	}
	
}
