package review5.thread1.start;
/**
   This program runs two greeting threads in parallel.
*/
public class GreetingThreadStarter
{
   public static void main(String[] args)
   {
      GreetingRunnable r1 = new GreetingRunnable("Hello!");
      GreetingRunnable r2 = new GreetingRunnable("Bye bye!");
      Thread t1 = new Thread(r1);
      Thread t2 = new Thread(r2);
      
      t1.start();
      t2.start(); 
      
//      t1.run();
//      t2.run();
   }
}

