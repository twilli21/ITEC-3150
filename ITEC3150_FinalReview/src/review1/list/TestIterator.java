package review1.list;


import java.util.*;

public class TestIterator {
  public static void main(String[] args) {
    Collection<String> collection = new ArrayList<>();
    collection.add("New York"); 
    collection.add("Atlanta"); 
    collection.add("Dallas"); 
    collection.add("Madison"); 
    System.out.println("1. " + collection);
    
    Iterator<String> iterator1 = collection.iterator();
    System.out.print(iterator1.next().toUpperCase() + ", ");
    System.out.print(iterator1.next().toUpperCase() + "\n");
    iterator1.remove();
    System.out.println("2. " + collection);
    
    Iterator<String> iterator2 = collection.iterator();
    while (iterator2.hasNext()) {
      System.out.print(iterator2.next().toUpperCase() + " ");
    }
    System.out.println();
    
    System.out.println("3. ");
    ArrayList<String> list = (ArrayList<String>)collection;
    ListIterator<String> iterator3 = list.listIterator();
    System.out.print(iterator3.next().toUpperCase() + " ");
    System.out.print(iterator3.next().toUpperCase() + " ");
    System.out.print(iterator3.previous().toUpperCase() + "\n");
    iterator3.remove();
    System.out.println("4. " + collection);
    
    ListIterator<String> iterator4 = list.listIterator();
    while (iterator4.hasNext()) {
      System.out.print(iterator4.next().toUpperCase() + " ");
    }
    System.out.println();
  }
}
