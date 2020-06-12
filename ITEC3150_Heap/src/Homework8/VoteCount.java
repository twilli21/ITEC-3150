package Homework8;


/**
 * Your implementation of the voteCount method for Problem 1 of Homework Assignment 10.
 *
 * @author YOUR NAME HERE
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */

import java.util.*;
import java.util.Map.Entry;

import trees.lecture.priorityQueue.DistanceToSourceComparator;
import trees.lecture.priorityQueue.Point;

public class VoteCount {
	
	/**
	 * Given an array list of strings each representing the name of a player receiving a vote,
	 * counts the number of votes each player receives (i.e. the number of times each name
	 * occurs in the input list) and orders the players in descending order of vote count.
	 * If two players have the same vote count, orders them alphabetically by name.
	 * 
	 * Time Complexity: O(n + k log k), where n is the size of the input list (i.e. the total 
	 * number of votes) and k is the number of players receiving votes
	 * 
	 * @param votes  an array list of strings each representing the name of a player receiving a vote
	 * @return       an array list of Player objects in descending order of count;
	 * 				 two players with the same vote count are ordered alphabetically by name
	 */
	public static ArrayList<Player> voteCount(ArrayList<String> votes) {
		Map<String, Integer> map = new HashMap<>();
		ArrayList<Player> ans = new ArrayList<>();
		for (int i = 0; i < votes.size(); i++)
		{
			if (map.containsKey(votes.get(i)))
			{
				int count = map.get(votes.get(i));
				count++;
				map.put(votes.get(i), count);
			}
			else
			{
				map.put(votes.get(i), 1);
			}
		}		
		PlayerComparator pc = new PlayerComparator();
		PriorityQueue<Player> queue = new PriorityQueue<Player>(pc);
		for (Map.Entry<String,Integer> entry : map.entrySet())
		{
			Player player = new Player(entry.getKey(), entry.getValue());
			queue.offer(player);
		}
		while (queue.size() > 0) {
			ans.add(queue.remove());
		}
		// Replace this line with your return statement
		return ans;
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> playerList = new ArrayList<>();
		playerList.add("Lebron");
		playerList.add("Kawhi");
		playerList.add("James");
		playerList.add("Giannis");
		playerList.add("Anthony");
		playerList.add("Luka");
		playerList.add("Kawhi");
		playerList.add("Lebron");
		playerList.add("Lebron");
		playerList.add("Anthony");
		playerList.add("Luka");

		System.out.println("Votes:" + playerList);
		System.out.println("Count:" + voteCount(playerList).toString());
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter more player names (enter quit when done): ");
		
		String name = input.nextLine();
		while (!name.contentEquals("done")) {
			playerList.add(name);
			name = input.nextLine();
		}
		System.out.println("Count:" + voteCount(playerList).toString());
	}
}


/**
 * The Player class whose objects represent players receiving votes
 * Instance variables name and count represent a player's name and vote count
 * 
 * DO NOT MODIFY THIS CLASS!!
 *
 */
class Player {
	String name;
	int count;
	
	Player(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	@Override
	public String toString() {
		String s = String.format("(%s, %d)", name, count);
		return s;
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
		}
		else
		{
			return p2.count - p1.count; // sorting by count in decreasing order.
			// p1.count - p2.count is for sorting by count in increasing order.
		}
	}
}
