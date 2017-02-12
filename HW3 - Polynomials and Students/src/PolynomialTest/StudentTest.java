package PolynomialTest;
import org.junit.Assert;
import org.junit.Test;
import edu.miracosta.cs113.Student;

public class StudentTest {

	@Test
	public void testGetName(){
		Student temp = new Student("Mark");
		Assert.assertTrue(temp.getName().equals("Mark"));
		
	}
	@Test
	public void testSetName(){
		Student temp = new Student("Mark");
		temp.setName("Jill");
		Assert.assertTrue(temp.getName().equals("Jill"));
		
	}
	
	@Test
	public void testToString(){
		Student temp = new Student("Mark");
		Assert.assertTrue(temp.toString().equals("Mark"));
		
	}
	
	@Test
	public void testEquals(){
		Student temp = new Student("Mark");
		Assert.assertTrue(temp.equals(new Student("Mark")));
		Assert.assertFalse(temp.equals(new Student("Tom")));
		
	}
}
