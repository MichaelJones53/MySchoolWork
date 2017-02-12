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
		Student temp = new Student("temp");
		StudentList<Student> list = new StudentList<>();
		Assert.assertTrue(list.removeFirst() == null);
		list.addFirst(temp);
		Assert.assertTrue(list.removeFirst().equals(temp));
		list.addEnd(new Student("Barry"));
		list.addEnd(new Student("Jill"));
		list.addEnd(new Student("Gabe"));
		list.addFirst(temp);
		Assert.assertTrue(list.removeFirst().equals(temp));
	}
	
	@Test
	public void testRemoveSpecific(){
		Student temp = new Student("temp");
		StudentList<Student> list = new StudentList<>();
		Assert.assertTrue(list.removeSpecific(temp) == null);
		list.addFirst(new Student("Sally"));
		list.addFirst(new Student("Tom"));
		list.addFirst(new Student("Mark"));
		list.addFirst(new Student("Lunch"));
		Assert.assertTrue(list.removeSpecific(new Student("Tom")).equals(new Student("Tom")));
		Assert.assertTrue(list.removeSpecific(new Student("Lunch")).equals(new Student("Lunch")));
		Assert.assertTrue(list.removeSpecific(new Student("Sally")).equals(new Student("Sally")));
		Assert.assertTrue(list.removeSpecific(new Student("John")) == null);
		Assert.assertTrue(list.removeSpecific(new Student("Mark")).equals(new Student("Mark")));
		Assert.assertTrue(list.removeSpecific(new Student("John")) == null);
		
		
	}
	
	@Test
	public void testGetSize(){
		StudentList<Student> list = new StudentList<>();
		Assert.assertTrue(list.getSize() == 0);
		list.addEnd(new Student("Tom"));
		Assert.assertTrue(list.getSize() == 1);
	}
	
	@Test
	public void testToString(){
		StudentList<Student> list = new StudentList<>();
		Assert.assertTrue(list.toString().equals(""));
		list.addEnd(new Student("Tom"));
		list.addFirst(new Student("Terry"));
		Assert.assertTrue(list.toString().equals("Terry, Tom"));
	}
	
}
