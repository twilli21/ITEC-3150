package HW5;
import java.util.*;

public class Hw5_p2 {
	
	// HW8 Problem 1 Graded Method
	public static ArrayList<ArrayList<Integer>> twoSumUnsorted(int[] A, int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		// Your code starts
		HashMap<Integer, Integer> map = new HashMap<>();
		int c = 0;
		for (int i = 0; i < A.length; i++)
		{
			c = target - A[i];
			if (map.containsKey(c))
			{
				ArrayList<Integer> pair = new ArrayList<>();
				int v = map.get(c);
				pair.add(v);
				pair.add(i);
				ans.add(pair);
			}
			else
			{
				map.put(A[i], i);
			}
		}
		// Your code ends
		
		return ans;
	}

	
	// Test driver for twoSumSorted2
	public static void main(String[] args) {
		int[] arr1 = {-5, 9, 0, 1, 6, -7, 7, 8, -2};
		int[] arr2 = {6, -2, 1, 7, 0, 8};
		int[] arr3 = {-12, 9, -9, 8, -5, 6, 4, 12, -1, 2, 0, 1, 7};
		
		ArrayList<ArrayList<Integer>> solution1 = twoSumUnsorted(arr1, 1);
		System.out.println(solution1);
		
		ArrayList<ArrayList<Integer>> solution2 = twoSumUnsorted(arr2, 3);
		System.out.println(solution2);

		ArrayList<ArrayList<Integer>> solution3 = twoSumUnsorted(arr3, 3);
		System.out.println(solution3);
	}

}
