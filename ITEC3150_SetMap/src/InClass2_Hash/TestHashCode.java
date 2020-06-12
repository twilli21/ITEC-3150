package InClass2_Hash;

public class TestHashCode {
  public static void main(String[] args) {
	//https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#hashCode--
	System.out.println("hash code for a: " + "a".hashCode());
	System.out.println('a' * 1);
	System.out.println("hash code for ba: " + "ba".hashCode());
	System.out.println('b' * 31 + 'a');
    System.out.println("hash code for Smith: " + "Smith".hashCode());
    System.out.println('S' * 31*31*31*31 + 'm'*31*31*31 + 'i'*31*31 + 't'*31 + 'h');
  
    DateWithYear date1 = new DateWithYear(2020, 2, 12);
    DateWithYear date2 = new DateWithYear(2020, 12, 2);
    System.out.println("hash code for 2020-02-12: " + date1.hashCode());
    System.out.println("hash code for 2020-12-02: " + date2.hashCode());
    
  
    PurchaseOrder order1 = new PurchaseOrder("SPRT-1001", 100, 5.99);
    PurchaseOrder order2 = new PurchaseOrder("HEAL-1665", 2000, 12.99);
    System.out.println("hash code for order1: " + order1.hashCode());
    System.out.println("hash code for order2: " + order2.hashCode());
    
  }
}