package review5.thread3.forkJoin;

/**
 * Modified from the code by Y. Daniel Liang
 * in Listing 32.11 of Introduction to Java Programming, 11th Edition
 */

import java.util.concurrent.*;

public class ParallelMax {
	public static void main(String[] args) {
		System.out.println("Number of processors is " +  Runtime.getRuntime().availableProcessors()); 
		
		// Create a list
		final int N = 300000000;
		int[] list = new int[N];
		// Assign random integers to array elements
		RandomAssign.parallelAssign(list);

		long startTime = System.currentTimeMillis();
		System.out.println("\nsequentialMax: " + sequentialMax(list));
		long endTime = System.currentTimeMillis();
		System.out.println("sequentialMax Time: " + (endTime - startTime) + " milliseconds");
		
		startTime = System.currentTimeMillis();
		System.out.println("\nparallelMax:   " + parallelMax(list));
		endTime = System.currentTimeMillis();
		System.out.println("parallelMax Time:   " + (endTime - startTime) + " milliseconds"); 
	}
	
	
	/**
	 * Sequentially computes the maximum element of an array
	 * 
	 * @param list  an array
	 * @return      the maximum element of the array
	 */
	public static int sequentialMax(int[] list) {
		return sequentialMax(list, 0, list.length);
	}
	
	
	/**
	 * Sequentially computes the maximum element of the subarray of
	 * a given array from an inclusive low index to an exclusive high index
	 * 
	 * @param list  an array
	 * @param low   the inclusive low index of a subarray
	 * @param high  the exclusive high index of a subarray
	 * @return      the maximum element of the subarray
	 */
	private static int sequentialMax(int[] list, int low, int high) {
		int max = list[low];
		for (int i = low+1; i < high; i++) {
        	if (list[i] > max) {
        		max = list[i];
        	}
        }
		return max;
	}
  
	
	/**
	 * Computes the maximum element of an array in parallel
	 * using the fork-join framework
	 * 
	 * @param list  an array
	 * @return      the maximum element of the array
	 */
	public static int parallelMax(int[] list) {
		RecursiveTask<Integer> task = new MaxTask(list, 0, list.length);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(task);
	}
  
 
	/**
	 * Recursive Task Class for the fork-join task that when executed assigns 
	 * random integers to the elements of a given array by parallel divide-and-conquer
	 * 
	 * Supports parallelMax()
	 * 
	 */
	private static class MaxTask extends RecursiveTask<Integer> {
		private final static int THRESHOLD = 30000000;
		private int[] list;
		private int low;
		private int high;

		public MaxTask(int[] list, int low, int high) {
			this.list = list;
			this.low = low;
			this.high = high;
		}

		@Override
		public Integer compute() {
			// Base Case: If the length of the subarray assigned to the task
			// is smaller than the threshold, then sequentially compute and return
			// the maximum element of the subarray
			if (high - low < THRESHOLD) {
				return sequentialMax(list, low, high);
			} 
			else {
				// Divide the subarray into two halves of (almost) equal size
				int mid = (low + high) / 2;
				
				// Recurse on the two halves in parallel
				RecursiveTask<Integer> left = new MaxTask(list, low, mid);
				RecursiveTask<Integer> right = new MaxTask(list, mid, high);
				right.fork();
				left.fork(); 
				
				// When the left and right returns, compute and return the
				// maximum of left and right
				return Math.max(left.join(), right.join());
			}
		}
	}
}


