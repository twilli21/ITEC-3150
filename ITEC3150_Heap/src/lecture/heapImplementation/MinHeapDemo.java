package lecture.heapImplementation;

/**
   This program demonstrates the heapsort algorithm.
*/
public class MinHeapDemo
{  
   public static void main(String[] args)
   {  
      int[] a = ArrayUtil.randomIntArray(20, 100);
      ArrayUtil.print(a);
      
      int[] b = new int[a.length];
      
      MinHeap heap = new MinHeap();
      for (int i=0; i<a.length; i++)
    	  heap.add((Integer) a[i]);
      
      for (int i=0; i<a.length; i++)
    	  b[i] = (int) heap.remove();
      
      
      ArrayUtil.print(b);
   }
}
