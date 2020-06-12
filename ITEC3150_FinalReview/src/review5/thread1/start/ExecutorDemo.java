package review5.thread1.start;

import java.util.concurrent.*;

public class ExecutorDemo
{
    public static void main(String[] args)
    {
        // Create a fixed thread pool with maximum three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);  //change to 3
//        ExecutorService executor = Executors.newCachedThreadPool();  // try this with the sleep
        

        // Submit runnable tasks to the executor
        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintChar('c', 100));
     
        
//        try {
//  			Thread.sleep(4000);
//  		} catch (InterruptedException e) {
//  		}
        
        executor.execute(new PrintChar('d', 100));
        executor.execute(new PrintChar('e', 100));
        executor.execute(new PrintChar('f', 100));
        executor.execute(new PrintChar('g', 100));
        
      

 
        // Shut down the executor
        executor.shutdown();
        System.out.println("\nMain thread (" +   Thread.currentThread().getName() + ") done!");
    }
}
