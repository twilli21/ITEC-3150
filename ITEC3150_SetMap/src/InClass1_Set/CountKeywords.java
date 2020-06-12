package InClass1_Set;

import java.util.*;
import java.io.*;

public class CountKeywords {
	public static void main(String[] args) throws Exception {  
		String aProgram = "public class TestTreeSetWithComparator {\r\n" + 
				"  public static void main(String[] args) {\r\n" + 
				"    // Create a tree set for geometric objects using a comparator\r\n" + 
				"    Set<GeometricObject> set =\r\n" + 
				"      new TreeSet<>(new GeometricObjectComparator());\r\n" + 
				"    set.add(new Rectangle(4, 5));\r\n" + 
				"    set.add(new Circle(40));\r\n" + 
				"    set.add(new Circle(40));\r\n" + 
				"    set.add(new Rectangle(4, 1));\r\n" + 
				"\r\n" + 
				"    // Display geometric objects in the tree set\r\n" + 
				"    System.out.println(\"A sorted set of geometric objects\");\r\n" + 
				"    for (GeometricObject element: set)\r\n" + 
				"      System.out.println(\"area = \" + element.getArea());\r\n" + 
				"  }\r\n" + 
				"}";

		System.out.println("The number of keywords in the program is " + countKeywords(aProgram));   
	}

	public static int countKeywords(String aProgram) {  
		// Array of all Java keywords + true, false and null
		String[] keywordString = {"abstract", "assert", "boolean", 
				"break", "byte", "case", "catch", "char", "class", "const",
				"continue", "default", "do", "double", "else", "enum",
				"extends", "for", "final", "finally", "float", "goto",
				"if", "implements", "import", "instanceof", "int", 
				"interface", "long", "native", "new", "package", "private",
				"protected", "public", "return", "short", "static", 
				"strictfp", "super", "switch", "synchronized", "this",
				"throw", "throws", "transient", "try", "void", "volatile",
				"while", "true", "false", "null"};

		//TODO1: Create a HashSet from the above array. 
		//Hint: Use Arrays.asList(keywordString) to convert the array to a list and 
		//use the list to create the hashset.
		HashSet<String> set = new HashSet<>(Arrays.asList(keywordString));
		int count = 0;    

		//TODO2: Create a Scanner from the parameter String. 
		//Check whether each word in the String is in the hashset.
		//If so, increase the counter.
		Scanner input = new Scanner(aProgram).useDelimiter("[\\s+\\p{P}]");
		while(input.hasNext())
		{
			String word = input.next();
			if (set.contains(word))
			{
				//System.out.println(word);
				count++;
			}
		}
		return count;
	}
}