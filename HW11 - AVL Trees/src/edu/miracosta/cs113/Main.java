package edu.miracosta.cs113;

public class Main {

	public static void main(String[] args){
		BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();
		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		int[] data = new int[1000];
		
		for(int i = 0; i< data.length; i++){
			data[i] = (int)Math.floor(Math.random() *1001); 
		}
		
		for(int i = 0; i< data.length; i++){
			searchTree.add(data[i]); 
		}
		
		System.out.println(searchTree.toString());
		
		for(int i = 0; i< data.length; i++){
			avlTree.add(data[i]); 
		}
		
		System.out.println(avlTree.toString());
	}
}
