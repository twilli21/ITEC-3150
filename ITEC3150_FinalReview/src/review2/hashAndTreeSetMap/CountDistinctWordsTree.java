package review2.hashAndTreeSetMap;


import java.util.*;

public class CountDistinctWordsTree {
  public static void main(String[] args) {
    // Set text in a string
    String[] words = {"Good", "morning", "Have", "a", "good", "class", "Have", "a",
    		"good", "visit", "Have", "fun"};
    
    // Create a TreeMap to hold words as key and count as value
    Set<String> set = new TreeSet<>();
    
    for (int i = 0; i < words.length; i++) {
      String key = words[i].toLowerCase();
      
      
        if (!set.contains(key)) {
           set.add(key);
        }
    }

    // Display all the (distinct) values in the set
    System.out.println("The distinct values in the set are: ");
    for (String k: set) {
       System.out.print(k + " ");
    }
  }
}
