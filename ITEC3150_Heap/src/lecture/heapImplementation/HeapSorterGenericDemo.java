package lecture.heapImplementation;

/**
   This program demonstrates the heapsort algorithm.
*/
public class HeapSorterGenericDemo
{  
   public static void main(String[] args)
   {  
	   WorkOrder[] orders = new WorkOrder[8];
	   orders[0] = new WorkOrder(3, "Shampoo carpets");
	   orders[1] = new WorkOrder(7, "Empty trash");
	   orders[2] = new WorkOrder(8, "Water plants");
	   orders[3] = new WorkOrder(10, "Remove pencil sharpener shavings");
	   orders[4] = new WorkOrder(6, "Replace light bulb");
	   orders[5] = new WorkOrder(1, "Fix broken sink");
	   orders[6] = new WorkOrder(9, "Clean coffee maker");
	   orders[7] = new WorkOrder(2, "Order cleaning supplies");

      HeapSorterGeneric<WorkOrder> sorter = new HeapSorterGeneric<WorkOrder>(orders);
      sorter.sort();
     
      for (int i=0; i<orders.length; i++) {
    	  System.out.println(orders[i]);
      }
   }
}
