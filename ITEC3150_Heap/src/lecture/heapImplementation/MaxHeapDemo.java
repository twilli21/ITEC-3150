package lecture.heapImplementation;

/**
   This program demonstrates the heapsort algorithm.
*/
public class MaxHeapDemo
{  
   public static void main(String[] args)
   {  
      int[] a = ArrayUtil.randomIntArray(20, 100);
      ArrayUtil.print(a);
      
      Integer[] aa = new Integer[a.length];
      for (int i=0; i<a.length; i++)
    	  aa[i] = a[i];
      
      MaxHeap<Integer> heap = new MaxHeap<Integer>(aa);

      for (int i=0; i<a.length; i++)
    	  a[i] = (int) heap.remove();
      
      ArrayUtil.print(a);
   }
}
