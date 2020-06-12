package review2.list;

public class TestStack
{
	public static void main(String[] args)
	{
		// Create a stack
		java.util.Stack<String> stack = new java.util.Stack<>();

		// Add elements to the stack
		stack.push("Tom"); // Push it to the stack
		System.out.println("(1) " + stack);

		stack.push("Susan"); // Push it to the the stack
		System.out.println("(2) " + stack);

		stack.push("Kim"); // Push it to the stack
		stack.push("Michael"); // Push it to the stack
		System.out.println("(3) " + stack);

		// Remove elements from the stack
		System.out.println("(4) " + stack.pop());
		System.out.println("(5) " + stack.pop());
		System.out.println("(6) " + stack);
	}
}
