package Homework6;

public class TestMyDoublyLinkedListRemove
{
	/** Main method */
	public static void main(String[] args)
	{
		// Create a list for strings
		MyDoublyLinkedList<String> list = new MyDoublyLinkedList<String>();

		// Add elements to the list
		list.add("America"); // Add it to the list
		list.add(0, "Canada"); // Add it to the beginning of the list
		list.add("Russia"); // Add it to the end of the list
		list.addLast("France"); // Add it to the end of the list
		list.add(2, "Germany"); // Add it to the list at index 2
		list.add(5, "Norway"); // Add it to the list at index 5
		list.add(0, "Poland"); // Same as list.addFirst("Poland")
		System.out.println("(1) " + list);
		System.out.println("(1 reverse) " + list.toStringReverse());

		// Remove elements from the list
		list.remove(0); // Same as list.remove("Australia") in this case
		System.out.println("(2) " + list);
		System.out.println("(2 reverse) " + list.toStringReverse());

		list.remove(2); // Remove the element at index 2
		System.out.println("(3) " + list);
		System.out.println("(3 reverse) " + list.toStringReverse());

		list.remove(list.size() - 1); // Remove the last element
		System.out.println("(4) " + list);
		System.out.println("(4 reverse) " + list.toStringReverse());

		list.clear();
		System.out.println("\nAfter clearing the list, the list size is " + list.size());

	}
}