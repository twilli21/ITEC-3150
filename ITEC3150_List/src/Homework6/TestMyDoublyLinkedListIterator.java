package Homework6;

public class TestMyDoublyLinkedListIterator
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

		java.util.Iterator<String> iterator = list.iterator();
		System.out.println("(1st element) " + iterator.next());
		System.out.println("(2nd element) " + iterator.next());
		System.out.println("(3rd element) " + iterator.next());
		System.out.println("Not done yet with traversing? " + iterator.hasNext());
		System.out.println("(removing 4th element) ");
		iterator.remove();

		while (iterator.hasNext())
		{
			System.out.println("(next element) " + iterator.next());
		}

		System.out.print("Using for-each loop to print all elements: ");
		for (String s : list)
			System.out.print(s + " ");
		System.out.println();
	}
}