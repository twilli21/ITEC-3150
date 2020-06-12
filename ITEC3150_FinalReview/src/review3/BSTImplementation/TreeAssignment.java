package review3.BSTImplementation;

import java.util.Scanner;

// DO NOT CHANGE ANYTHING in this file

public class TreeAssignment {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string that represent an int BST: ");
		String intTreeString = input.nextLine();
		
		//(1) [3 [0 [-1] [2 [1]]] [6 [4] [8 [7] [9]]]]
		//(2) [47 [28 [23] [35 [30]]] [50 null [94 null [128]]]]
		IntTree testTree = new IntTree(intTreeString);
		System.out.println("Print the tree in a top-to-down fashion:");
		System.out.println(testTree);
		testTree.inOrder();
		testTree.reverseInOrder();
		testTree.preOrder();
		testTree.postOrder();
		
		// call already developed routine to count even branches - this 
		// counts branches with even nodes, not even leaf nodes
		int evenCount = testTree.countEvenBranches();
		System.out.println("\nThere are " + evenCount + " even branches");

		// call user developed routine to count left Nodes
		int leftNodes = testTree.countLeftNodes();

		System.out.println("The number of left nodes is " + leftNodes);

		// call second user developmed routine to sum the values of all the integers in the tree
		int totalSum = testTree.sumNodes();
		System.out.println("The total sum is " + totalSum);
	

		/*
		// create int tree with 10 random elements
		// you may make this smaller for testing
		IntTree theTree = new IntTree(3);

		// print the tree
		System.out.println("Print the tree in a top-to-down fashion:");
		System.out.println(theTree);
		theTree.printInOrder();
		theTree.printReverseInOrder();
		
		// call already developed routine to count even branches - this 
		// counts branches with even nodes, not even leaf nodes
		int evenCount2 = theTree.countEvenBranches();
		System.out.println("\nThere are " + evenCount2 + " even branches");

		// call user developed routine to count left Nodes
		int leftNodes2 = theTree.countLeftNodes();

		System.out.println("The number of left nodes is " + leftNodes2);

		// call second user developed routine to sum the values of all the integers in the tree
		int totalSum2 = theTree.sumNodes();
		System.out.println("The total sum is " + totalSum2);
		
		*/
	}

}
