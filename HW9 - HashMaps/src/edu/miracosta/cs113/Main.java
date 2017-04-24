package edu.miracosta.cs113;

public class Main {

	public static void main(String[] args){
		HashTableChain<Integer, String> hashChain = new HashTableChain<Integer, String> ();
		
		hashChain.put(1, "one");
		hashChain.put(2, "two");
		hashChain.put(3, "three");
		System.out.println("\n\nHashChain should have size of 2 and have 3 entries");
		System.out.println(hashChain.toString());
		hashChain.put(4, "four");
		hashChain.put(5, "five");
		hashChain.put(6, "six");
		hashChain.put(7, "seven");
		hashChain.put(8, "eight");
		hashChain.put(9, "nine");
		hashChain.put(10, "ten");
		System.out.println("\n\nHashChain should have rehashed to size of 51 and have 10 entries");
		System.out.println(hashChain.toString());
		
		hashChain.remove(5);
		hashChain.remove(10);
		hashChain.remove(7);
		System.out.println("\n\n hashchian should have 7 entries, 0 should be null");
		System.out.println(hashChain.toString());
		
		System.out.println("\n\ngetting 6 should return six");
		System.out.println(hashChain.get(6));
		
		System.out.println("\n\ngetting 10 should return null");
		System.out.println(hashChain.get(10));
		
	}
}
