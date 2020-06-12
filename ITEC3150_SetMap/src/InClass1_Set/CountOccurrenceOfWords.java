package InClass1_Set;

import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		//Get a line from user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a line of text:");
		String text = input.nextLine();
		
		//Split the text into words.
		String[] words = text.split("[\\s+\\p{P}]");
		
		//TODO1: Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();
		

		//TODO2: Go through each element in array words, convert it to lowercase, and 
		// if the word is not "", check whether the word is already is in map, if so, 
		// increase its count (value), otherwise, create a new entry for this word with count 1.
		// and update the map with
		for (String w: words)
		{
			if (w.length() == 0)
			{
				continue;
			}
			String word = w.toLowerCase();
			if (map.containsKey(word))
			{
				int count = map.get(word);
				count++;
				map.put(word, count);
			}
			else
			{
				map.put(word, 1);
			}
		}
		
		
		// Display key and value for each entry
		map.forEach((k, v) -> System.out.println(k + "\t" + v));
	}
}