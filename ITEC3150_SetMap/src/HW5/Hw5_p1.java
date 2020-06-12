package HW5;
import java.util.*;

public class Hw5_p1 {
	
	// HW8 Problem 1 Graded Method
	public static ArrayList<ArrayList<Integer>> twoSumSorted(int[] A, int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		// Your code starts
		int l = 0;
		int r = A.length-1;
		while(l < r)
		{
			int s = A[l] + A[r];
			if (s == target)
			{
				ArrayList<Integer> pair = new ArrayList<>();
				pair.add(l);
				pair.add(r);
				l++;
				r--;
				ans.add(pair);
			}
			if (s < target)
			{
				l++;
			}
			if (s > target)
			{
				r--;
			}
		}
		// Your code ends
		
		return ans;
	}

	
	// Test driver for twoSumSorted2
	public static void main(String[] args) {
		int[] arr1 = {-7, -5, -2, 0, 1, 6, 7, 8, 9};
		int[] arr2 = {-2, 0, 1, 6, 7, 8};
		int[] arr3 = {-12, -9, -5, -1, 0, 1, 2, 4, 6, 7, 8, 9, 12};
		
		ArrayList<ArrayList<Integer>> solution1 = twoSumSorted(arr1, 1);
		System.out.println(solution1);
		
		ArrayList<ArrayList<Integer>> solution2 = twoSumSorted(arr2, 3);
		System.out.println(solution2);

		ArrayList<ArrayList<Integer>> solution3 = twoSumSorted(arr3, 3);
		System.out.println(solution3);
	}

}
