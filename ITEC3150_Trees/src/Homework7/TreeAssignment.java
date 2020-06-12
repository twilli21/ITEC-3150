package Homework7;



import java.util.Scanner;

// DO NOT CHANGE ANYTHING in this file

public class TreeAssignment {
	public static void main(String[] args) {
		BSTMap<Integer, String> tree = new BSTMap<>(); // Create a tree
	    tree.put(60, "cat");
	    tree.put(20, "dog");
	    tree.put(70, "a");
	    TreePlotting plotting = new TreePlotting(tree.getRoot());
		System.out.println(plotting);
	    tree.put(80, "b");
	    System.out.println(plotting);
	    tree.put(90, "999");
		System.out.println(plotting);
	    tree.put(10, "c");
	    System.out.println(plotting);
	    tree.put(40, "d");
	    System.out.println(plotting);
	    tree.put(30, "e");
	    System.out.println(plotting);
	    tree.put(50, "f");
	    System.out.println(plotting);
	    
	    System.out.println("The value for key 10 is " + tree.get(10));
	    System.out.println("The value for key 80 is " + tree.get(80));
	    System.out.println("The value for key 50 is " + tree.get(50));
	    System.out.println("The value for key 45 is " + tree.get(45));
	
	    System.out.println("In-Order: " + tree.inOrder());
		System.out.println("Reverse-Order: " + tree.reverseOrder());
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a value for k (smallest):");
		int k = input.nextInt();
		System.out.println("k smallest: " + tree.kSmallest(k));
	}
}
