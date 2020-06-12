import java.util.Arrays;

public class ClosestPair1DStarter
{
	public static long closestPairSlow(long[] A)
	{
		long min = Long.MAX_VALUE;

		int n = A.length;
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				long d = Math.abs(A[i] - A[j]);
				if (d < min)
				{
					min = d;
				}	
			}
		}

		return min;
	}

	public static long closestPairFast(long[] A)
	{
		Arrays.sort(A);
		long min = Long.MAX_VALUE;
		int n = A.length;
		for (int i = 0; i < n - 1; i++)
		{
			long d = (A[i + 1] - A[i]);
			if (d < min)
			{
				min = d;
			}
		}
		return min;
	}

	public static void main(String[] args)
	{
		int n = 500000;
		long[] A = new long[n];
		for (int i = 0; i < n; i++)
		{
			A[i] = (long) (Math.random() * (1L << 60));
			//System.out.print(A[i] + " ");
		}
		System.out.println();

		System.out.println("closestPairFast:");

		long tic2 = System.currentTimeMillis();
		long minDist2 = closestPairFast(A);
		long toc2 = System.currentTimeMillis();

		System.out.printf("Minimum distance: %d\n", minDist2);
		System.out.printf("Time: %.2f seconds\n", (double) (toc2 - tic2) / 1000);

		System.out.println("\nclosestPairSlow:");

		long tic = System.currentTimeMillis();
		long minDist = closestPairSlow(A);
		long toc = System.currentTimeMillis();

		System.out.printf("Minimum distance: %d\n", minDist);
		System.out.printf("Time: %.2f seconds\n", (double) (toc - tic) / 1000);

	}

}
