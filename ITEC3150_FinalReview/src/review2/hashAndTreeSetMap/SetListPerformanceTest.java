package review2.hashAndTreeSetMap;


import java.util.*;

public class SetListPerformanceTest {
	static final int N = 50000;

	public static void main(String[] args) {  
		// Add numbers 0, 1, 2, ..., N - 1 to the array list
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(i);
		Collections.shuffle(list); // Shuffle the array list

		// Create a hash set, and test its performance
		Collection<Integer> set1 = new HashSet<>(list);
		System.out.println("HashSet: Member test time - " +
				getTestTime(set1) + " milliseconds");
		System.out.println("HashSet: Remove element time - " +
				getRemoveTime(set1) + " milliseconds");


		// Create a tree set, and test its performance
		Collection<Integer> set2 = new TreeSet<>(list);
		System.out.println("TreeSet: Member test time - " +
				getTestTime(set2) + " milliseconds");
		System.out.println("TreeSet: Remove element time - " +
				getRemoveTime(set2) + " milliseconds");

		// Create an array list, and test its performance
		Collection<Integer> list1 = new ArrayList<>(list);
		System.out.println("ArrayList: Member test time - " +
				getTestTime(list1) + " milliseconds");
		System.out.println("ArrayList: Remove element time - " +
				getRemoveTime(list1) + " milliseconds");

		// Create a linked list, and test its performance
		Collection<Integer> list2 = new LinkedList<>(list);
		System.out.println("LinkedList: Member test time - " +
				getTestTime(list2) + " milliseconds");
		System.out.println("LinkedList: Remove element time - " +
				getRemoveTime(list2) + " milliseconds");
	}

	public static long getTestTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();

		// Test if a number is in the collection
		for (int i = 0; i < N; i++)
			c.contains((int)(Math.random() * 2 * N));

		return System.currentTimeMillis() - startTime; 
	}

	public static long getRemoveTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < N; i++)
			c.remove(i);

		return System.currentTimeMillis() - startTime; 
	}
}