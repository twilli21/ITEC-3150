package Homework3;
import java.util.*;

public class Hw3_p4
{

	public static ArrayList<Player> voteCounts(ArrayList<String> votes)
	{
		ArrayList<Player> ans = new ArrayList<>();

		// Your code starts
		int n = votes.size();
		Collections.sort(votes);
		String name = votes.get(0);
		int count = 1;
		for (int i = 1; i < n; i++)
		{
			if (name.equals(votes.get(i)))
			{
				count++;
			} else
			{
				Player player = new Player(name, count);
				ans.add(player);
				name = votes.get(i);
				count = 1;
			}
		}
		Player player = new Player(name, count);
		ans.add(player);
		Collections.sort(ans, new PlayerComparator());
		// Your code ends

		return ans;
	}

	public static void main(String[] args)
	{
		// Test driver for voteCounts
		ArrayList<String> votes = new ArrayList<>();

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the votes: ");
		String name = input.next();
		while (!name.equals("end"))
		{
			votes.add(name);
			name = input.next();
		}

		ArrayList<Player> playerVotes = voteCounts(votes);
		for (int i = 0; i < playerVotes.size(); i++)
		{
			System.out.println(playerVotes.get(i).name + " received " + playerVotes.get(i).count + " votes.");
		}

	}

}

class Player
{
	String name;
	int count;

	Player(String name, int count)
	{
		this.name = name;
		this.count = count;
	}
}

class PlayerComparator implements Comparator<Player>
{

	/*
	 * This will sort by count in decreasing order and if the same count, sort by
	 * name by alphabetical order.
	 */
	@Override
	public int compare(Player o1, Player o2)
	{
		Player p1 = (Player) o1;
		Player p2 = (Player) o2;
		if (p1.count == p2.count)
		{
			return p1.name.compareTo(p2.name);
		} else
		{
			return p2.count - p1.count; // sorting by count in decreasing order.
			// p1.count - p2.count is for sorting by count in increasing order.
		}
	}
}
