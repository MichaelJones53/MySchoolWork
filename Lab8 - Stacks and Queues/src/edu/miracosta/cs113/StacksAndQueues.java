package edu.miracosta.cs113;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Lab8Driver.java : Lab 8 Driver program
 * 
 * @author Michael Jones
 * @version 1.0
 *
 */
public class StacksAndQueues {
	/**
	 * Driver for Lab 8 program assignment
	 * 
	 * @param args
	 *            command line arguments (unnused)	
	 */
	public static void main(String[] ars){
		System.out.println("-------------part 1------------------------");
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		
		stack1.push(-1);
		stack1.push(15);
		stack1.push(23);
		stack1.push(44);
		stack1.push(4);
		stack1.push(99);
		

		System.out.println(stack1.peek());
		System.out.println("-------------part 2------------------------");
		while(!stack1.isEmpty()){
			stack2.push(stack1.peek());
			System.out.println("stack2 added: "+stack2.peek());
			System.out.println("queue added item: "+queue.offer(stack1.pop()));
		}
		
		System.out.println("-------------part 3------------------------");
		
		while(!stack2.isEmpty()){
			System.out.print("Stack2 :"+stack2.pop()+"   \t");
			System.out.println("queue  :"+queue.poll());
		}
	}
}
