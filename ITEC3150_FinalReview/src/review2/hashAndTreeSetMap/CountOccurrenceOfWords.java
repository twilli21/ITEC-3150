package review2.hashAndTreeSetMap;


import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String[] words = {"Good", "morning", "Have", "a", "good", "class", "Have", "a",
				"good", "visit", "Have", "fun"};

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();

			if (!map.containsKey(key)) {
				map.put(key, 1);
			}
			else {
				int value = map.get(key);
				value++;
				map.put(key, value);
			}

		}

		// Display key and value for each entry
		Set<String> keys = map.keySet();
		for (String k: keys) {
			Integer v = map.get(k);
			System.out.println(k + " occurs " + v + " times");
		}
	}
}
