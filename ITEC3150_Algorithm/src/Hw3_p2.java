import java.util.Arrays;

public class Hw3_p2
{
	// HW7 Problem 2
	public static int[] closestPairFast2(long[] A)
	{
		int[] ans = new int[2];
		int n = A.length;
		ValIndexPair[] B = new ValIndexPair[n];
		for (int i = 0; i < n; i++)
		{
			B[i] = new ValIndexPair(A[i], i);
		}

		Arrays.sort(B);
		System.out.println("B: ");
		for (int i = 0; i < n; i++)
		{
			System.out.print(B[i].val + "@" + B[i].idx + " ");
		}
		System.out.println("\n");
		// Your code starts
		long min = Long.MAX_VALUE;
		int b = B.length;
		for (int i = 0; i < b - 1; i++)
		{
			long d = (B[i+1].val - B[i].val);
			if (d < min)
			{
				min = d;
				ans[0] = B[i+1].idx;
				ans[1] = B[i].idx;
			}
		}
		// Your code ends
		return ans;
	}

	public static void main(String[] args)
	{
		// Test driver for closestPairFast2
		
		int n = 5;
		long[] A = {8, 15, 19, 3, 12};
		System.out.println("A: ");
		for (int i = 0; i < n; i++)
		{
			System.out.print(A[i] + " ");
		}
		System.out.println("\n");
		int[] pairIndice = closestPairFast2(A);
		System.out.println("The two values are closest are at indice " + pairIndice[0] + " and " + pairIndice[1]);

		/*
		n = 500000;
		A = new long[n];
		for (int i = 0; i < n; i++)
		{
			A[i] = (long) (Math.random() * (1L << 60));
			// System.out.print(A[i] + " ");
		}
		System.out.println();

		System.out.println("closestPairFast2:");

		long tic2 = System.currentTimeMillis();
		pairIndice = closestPairFast2(A);
		;
		long toc2 = System.currentTimeMillis();

		System.out.println("The two values are closest are at indice " + pairIndice[0] + " and " + pairIndice[1]);
		System.out.printf("Time: %.2f seconds\n", (double) (toc2 - tic2) / 1000);
		*/
	}
}

class ValIndexPair implements Comparable<ValIndexPair>
{
	long val;
	int idx;

	ValIndexPair(long val, int idx)
	{
		this.val = val;
		this.idx = idx;
	}

	public int compareTo(ValIndexPair o)
	{
		if (this.val < o.val)
		{
			return -1;
		}
		else if (this.val == o.val)
		{
			return 0;
		}
		else
		{
			return 1; // this.val > o.val
		}
	}
}
