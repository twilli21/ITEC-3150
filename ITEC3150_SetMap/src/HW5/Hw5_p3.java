package HW5;

public class Hw5_p3
{

	// HW8 Problem 2 Graded Method
	public static int removeDuplicates(int[] A)
	{
		int distinct = 0;

		// Your code starts
		int l = 0;
		int r = 1;
		while (r < A.length)
		{
			while (A[r] != A[l])
			{
				distinct++;
				l++;
				A[l] = A[r];
			}
			r++;
		}
		distinct++;
		// Your code ends

		return distinct;
	}

	// Test driver for removeDuplicates
	public static void main(String[] args)
	{
		int[] arr1 =
		{ 0, 1, 2, 5, 5, 6, 7, 7, 8 };
		int[] arr2 =
		{ -2, -2, 1, 6, 6, 8, 8 };
		int[] arr3 =
		{ 2, 2, 5, 5, 6, 6, 7, 8, 9, 9, 12, 12, 12 };

		System.out.println("arr1: ");
		printArray(arr1);
		int n1 = removeDuplicates(arr1);
		System.out.println("arr1 has " + n1 + " distinct values: ");
		printArray(arr1, n1);

		System.out.println("arr2: ");
		printArray(arr2);
		int n2 = removeDuplicates(arr2);
		System.out.println("arr2 has " + n2 + " distinct values: ");
		printArray(arr2, n2);

		System.out.println("arr3: ");
		printArray(arr3);
		int n3 = removeDuplicates(arr3);
		System.out.println("arr3 has " + n3 + " distinct values: ");
		printArray(arr3, n3);
	}

	public static void printArray(int[] arr)
	{
		System.out.print("[");
		for (int i = 0; i < arr.length; i++)
		{
			if (i == arr.length - 1)
				System.out.print(arr[i]);
			else
				System.out.print(arr[i] + ", ");
		}
		System.out.println("]");
	}

	public static void printArray(int[] arr, int count)
	{
		System.out.print("[");
		for (int i = 0; i < count; i++)
		{
			if (i == count - 1)
				System.out.print(arr[i]);
			else
				System.out.print(arr[i] + ", ");
		}
		System.out.println("]");
	}

}
