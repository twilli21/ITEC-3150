package Homework8;



/**
 * Your implementation of the voteCount method for Problem 2 of Homework Assignment 8
 *
 * @author YOUR NAME HERE
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */

import java.util.*;

public class KSmallest {
	
	/**
	 * Finds and returns in the sorted order the k smallest elements of an input list  
	 * according to the ordering defined by a custom comparator
	 * 
	 * Time Complexity: O(n log k)
	 * 
	 * @param A        the input list
	 * @param k  	   the number of elements to return
	 * @param compare  a custom comparator for the elements of A
	 * @return   	   a list consisting of the k smallest elements of A in the sorted order;
	 * 		     	   if k > A.size(), return all elements of A in the sorted order
	 */
	public static <T> List<T> kSmallestFaster(List<T> A, int k, Comparator<T> compare) {
		// https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
		Comparator<T> revComp = compare.reversed();
		PriorityQueue<T> pq = new PriorityQueue<T>(A.size(), revComp);
		List<T> ans = new ArrayList<T>();
		for(T a: A)
		{
			if (pq.size() < k)
			{
				pq.offer(a);
			}
			else
			{
				if (compare.compare(a, pq.peek()) < 0)
				{
					pq.remove();
					pq.offer(a);
				}
			}
		}
		PriorityQueue<T> qp = new PriorityQueue<T>(pq.size(), compare);
		for(T p: pq)
		{
			qp.offer(p);
		}
		while (qp.size() > 0)
		{
			ans.add(qp.remove());
		}
		// TODO: Replace this line with your return statement
		return ans;
	}
	
	
	/**
	 * Finds and returns the k smallest elements of an input list
	 * according to the ordering defined by a custom comparator
	 * 
	 * Time Complexity: O(n log n)
	 * 
	 * @param A        the input list
	 * @param k  	   the number of elements to return
	 * @param compare  a custom comparator for the elements of A
	 * @return   	   a list consisting of the k smallest elements of A
	 * 			 	   in the sorted order
	 * @throws   	   IllegalArgumentException if k > A.size()
	 */
	public static <T> List<T> kSmallestSlower(List<T> A, int k, Comparator<T> compare) {
		if (k > A.size()) {
			throw new IllegalArgumentException("k too large");
		}
		
		PriorityQueue<T> pq = new PriorityQueue<>(A.size(), compare);
		pq.addAll(A);
		
		List<T> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(pq.remove());
		}
		
		return res;
	}
	
	
	public static void main(String [] args) {
		//test 1
		// Change the method invocation to kSmallestFaster after you are done with
		// defining the method
		List<String> stateList1 = new ArrayList<>();
		stateList1.add("Oklahoma");
		stateList1.add("Indiana");
		stateList1.add("Georgia");
		stateList1.add("Texas");
		
		List<String> smallestStrings = kSmallestSlower(stateList1, 3, Comparator.naturalOrder());
		System.out.println("3 smallest strings are: " + smallestStrings);
		List<String> smallestStrings2 = kSmallestFaster(stateList1, 3, Comparator.naturalOrder());
		System.out.println("3 smallest strings are: " + smallestStrings2);
		
		//test 2:
		// Change the method invocation to kSmallestFaster after you are done with
		// defining the method
		List<WorkOrder> orderList = new ArrayList<>();
		orderList.add(new WorkOrder(3, "Clean"));
		orderList.add(new WorkOrder(2, "Build new structures"));
		orderList.add(new WorkOrder(1, "Repair"));
		orderList.add(new WorkOrder(4, "Preserve Energy"));

		List<WorkOrder> highestPriorotyOrders = kSmallestSlower(orderList, 2, Comparator.naturalOrder());
		System.out.println("2 highest orders are: " + highestPriorotyOrders);
		List<WorkOrder> highestPriorotyOrders2 = kSmallestFaster(orderList, 2, Comparator.naturalOrder());
		System.out.println("2 highest orders are: " + highestPriorotyOrders2);
		
		//test 3
		// Change the method invocation to kSmallestFaster after you are done with
		// defining the method
		Point[] points = {
				 new Point (2, 3, "P1"), new Point (3.5, 4.1, "P2"), 
		         new Point (5.6, 7.8, "P3"), new Point (1, 2, "P4"),
		         new Point (0.5, 3, "P5")
		       };
		List<Point> pointList = new ArrayList<Point>();
		for (Point p: points) {
			pointList.add(p);
		}
		Point source = new Point(0, 0, "Source");
		
		Comparator<Point> comparator = new DistanceToSourceComparator(source);
		List<Point> closestPoints = kSmallestSlower(pointList, 3, comparator);
		System.out.println("3 closest points are: " + closestPoints);
		List<Point> closestPoints2 = kSmallestFaster(pointList, 3, comparator);
		System.out.println("3 closest points are: " + closestPoints2);
		
		/*
		int[] a = ArrayUtil.randomIntArray(1000000, 10000000);
	    List<Integer> integerList = new ArrayList<>();
	    for (int n: a) {
	    	integerList.add(n);
	    }
	    System.out.println(integerList);
	    long startTime = System.currentTimeMillis();
	    List<Integer> smallestIntegers = kSmallestFaster(integerList, 3, Comparator.naturalOrder());
	    long endTime = System.currentTimeMillis();
	    System.out.println("running time for 3 kSmallest among 1,000,000 integers: " + (endTime - startTime));
	    System.out.println("3 smallest integers are: " + smallestIntegers);
	    */
	}
}
