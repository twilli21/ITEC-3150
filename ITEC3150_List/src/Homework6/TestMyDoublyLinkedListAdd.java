package Homework6;

public class TestMyDoublyLinkedListAdd
{
	/** Main method */
	public static void main(String[] args)
	{
		// Create a list for strings
		MyDoublyLinkedList<String> list = new MyDoublyLinkedList<String>();

		// Add elements to the list
		list.add("America"); // Add it to the list
		System.out.println("(1) " + list);
		System.out.println("(1 reverse) " + list.toStringReverse());

		list.add(0, "Canada"); // Add it to the beginning of the list
		System.out.println("(2) " + list);
		System.out.println("(2 reverse) " + list.toStringReverse());

		list.add("Russia"); // Add it to the end of the list
		System.out.println("(3) " + list);
		System.out.println("(3 reverse) " + list.toStringReverse());

		list.addLast("France"); // Add it to the end of the list
		System.out.println("(4) " + list);
		System.out.println("(4 reverse) " + list.toStringReverse());

		list.add(2, "Germany"); // Add it to the list at index 2
		System.out.println("(5) " + list);
		System.out.println("(5 reverse) " + list.toStringReverse());

		list.add(5, "Norway"); // Add it to the list at index 5
		System.out.println("(6) " + list);
		System.out.println("(6 reverse) " + list.toStringReverse());

		list.add(0, "Poland"); // Same as list.addFirst("Poland")
		System.out.println("(7) " + list);
		System.out.println("(7 reverse) " + list.toStringReverse());
	}
}