

import java.util.Scanner;

// DO NOT CHANGE ANYTHING in this file

public class TreeAssignment2 {
	public static void main(String[] args) {
		SimpleBSTMap tree = new SimpleBSTMap(); // Create a tree
	    tree.put(60, 6);
	    tree.put(20, 2);
	    tree.put(70, 7);
	    TreePlotting plotting = new TreePlotting(tree.getRoot());
		System.out.println(plotting);
	    
	    tree.put(80, 8);
	    System.out.println(plotting);
	    tree.put(10, 1);
	    System.out.println(plotting);
	    tree.put(40, 4);
	    System.out.println(plotting);
	    tree.put(30, 3);
	    System.out.println(plotting);
	    tree.put(50, 5);
	    System.out.println(plotting);
	    
	    System.out.println("The value for key 10 is " + tree.get(10));
	    System.out.println("The value for key 80 is " + tree.get(80));
	    System.out.println("The value for key 50 is " + tree.get(50));
	    System.out.println("The value for key 45 is " + tree.get(45));
	    
	    tree.put(90, 9);
		System.out.println(plotting);
	
		tree.put(5, 0);
		System.out.println(plotting);
		
		tree.put(2, 1);
		System.out.println(plotting);
	
		System.out.println(tree.inOrder());
	}
}
