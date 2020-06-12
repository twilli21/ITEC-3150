package review5.thread3.forkJoin;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RandomAssign {

	public static void main(String[] args) {
		int n = 20000000;
		int[] A = new int[n];
		int[] B = new int[n];
		Random rand = new Random();
		
		long tic = System.currentTimeMillis();
		// Sequentially assign random integers to array elements
		for (int i = 0; i < n; i++) {
			A[i] = rand.nextInt();
		}
		long toc = System.currentTimeMillis();
		//System.out.println(Arrays.toString(A));
		System.out.println("Sequential time is " +  (toc - tic) + " milliseconds");
		System.out.println();
		
		tic = System.currentTimeMillis();
		parallelAssign(B);
		toc = System.currentTimeMillis();
		//System.out.println(Arrays.toString(B));
		System.out.println("Parallel time is " +  (toc - tic) + " milliseconds");
	}
	
	
	/**
	 * Assigns random integers to the elements of a given array in parallel
	 * 
	 * @param A  the array to assign random integers to
	 */
	public static void parallelAssign(int[] A) {
		RecursiveAction task = new AssignTask(A, 0, A.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		System.out.println(AssignTask.numTasks + " parallel subtasks each executed sequentially");
	}

	
	/**
	 * Recursive Action Class for the fork-join task that when executed assigns 
	 * random integers to the elements of a given array by parallel divide-and-conquer
	 * 
	 * Supports parallelAssign()
	 * 
	 */
	private static class AssignTask extends RecursiveAction {
		private static Lock lock = new ReentrantLock();
		private static int numTasks;
		private final static int THRESHOLD = 2000;
		private int[] arr;
		private int low;
		private int high;
		
		AssignTask(int[] arr, int low, int high) {
			this.arr = arr;
			this.low = low;
			this.high = high;
		}
		
		@Override
		protected void compute() {
			// Base Case: If the length of the subarray assigned to the task
			// is smaller than the threshold, then sequentially assign
			// random integers to the elements of the subarray
			if (high - low < THRESHOLD) {
				Random rand = new Random();
				for (int i = low; i < high; i++) {
					arr[i] = rand.nextInt();
				}
				lock.lock();
				numTasks += 1;
				lock.unlock();
			}
			else {
				// Divide the subarray into two halves of (almost) equal size
				int mid = (low + high) / 2;
				
				// Recurse on the two halves in parallel
				invokeAll(new AssignTask(arr, low, mid), new AssignTask(arr, mid, high));
				//The above line is a simpler way to do the following in comments
				
//				RecursiveAction left = new AssignTask(arr, low, mid);
//				RecursiveAction right = new AssignTask(arr, mid, high);
//				left.fork(); 
//				right.fork();
//				left.join();
//				right.join();
			}
		}
	}
}
