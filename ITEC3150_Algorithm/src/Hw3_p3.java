
public class Hw3_p3
{
	public static int[] topScore(int[] scores)
	{
		int[] ans = new int[2];
		// Your code starts
		int n = scores.length;
		int max = 0;
		int count = 0;
		for (int i = 0; i < n; i++)
		{
			if (scores[i] > max)
			{
				max = scores[i];
				ans[0] = scores[i];
			}
		}
		for (int i = 0; i < n; i++)
		{
			if (max == scores[i])
			{
				count++;
			}
			ans[1] = count;
		}
		// Your code ends
		return ans;
	}

	public static void main(String[] args)
	{
		// Test drive for topScore
		int n = 8;
		int[] A = {54, 78, 62, 65, 74, 90, 90, 75};
		System.out.println("A: ");
		for (int i = 0; i < n; i++)
		{
			System.out.print(A[i] + " ");
		}
		System.out.println("\n");
		int[] scoreMultiple = topScore(A);
		System.out.println(scoreMultiple[0] + " is the highest score and it occurs " + scoreMultiple[1] + " times in the input array.");
	}

}
