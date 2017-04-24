package edu.miracosta.cs113;

public class Main {

	public static void main(String[] args){
		HashTableChain<Integer, String> hashChain = new HashTableChain<Integer, String> ();
		
		hashChain.put(5, "five");
		
		hashChain.put(2, "two");
		hashChain.put(3, "three");
		System.out.println(hashChain.toString());
		hashChain.put(1, "one");
		hashChain.put(10, "ten");
	
		hashChain.put(6, "six");
		hashChain.put(7, "seven");
		
		hashChain.put(8, "eight");
		System.out.println(hashChain.toString());
		hashChain.put(11, "six");
		hashChain.put(12, "seven");
		
		hashChain.put(13, "eight");
		System.out.println(hashChain.toString());
		hashChain.put(15, "six");
		hashChain.put(16, "seven");
		
		hashChain.put(17, "eight");
		System.out.println(hashChain.toString());
		hashChain.put(18, "six");
		hashChain.put(19, "seven");
		
		hashChain.put(20, "eight");
		System.out.println(hashChain.toString());
		
	}
}
