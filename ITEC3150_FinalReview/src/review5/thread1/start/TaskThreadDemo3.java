package review5.thread1.start;

public class TaskThreadDemo3
{
    public static void main(String[] args)
    {
        // Create tasks
        Runnable printA = new PrintChar3('a', 100);
        Runnable printB = new PrintChar3('b', 100);
        Runnable print100 = new PrintNum3(100);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        // Start threads
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// The task for printing a specified character in specified times
class PrintChar3 implements Runnable
{
    private char charToPrint; // The character to print
    private int times; // The times to repeat

    /**
     * Construct a task with specified character and number of times to print
     * the character
     */
    public PrintChar3(char c, int t)
    {
        charToPrint = c;
        times = t;
    }

    @Override
    /** Override the run() method to tell the system
     *  what the task to perform
     */
    public void run()
    {
        for (int i = 0; i < times; i++)
        {
            System.out.print(charToPrint);
        }
        System.out.println("\n" + charToPrint + " printing Thread (" +   Thread.currentThread().getName() + ") done!");
    }
}

// The task class for printing number from 1 to n for a given n
class PrintNum3 implements Runnable
{
    private int lastNum;

    /** Construct a task for printing 1, 2, ... i */
    public PrintNum3(int n)
    {
        lastNum = n;
    }

    @Override
    /** Tell the thread how to run */
    public void run()
    {
    	Thread thread4 = new Thread(new PrintChar('c', 1000));
    	thread4.setPriority(Thread.MAX_PRIORITY);
    	thread4.start();
        for (int i = 1; i <= lastNum; i++)
        {
            System.out.print(i + " ");
//            Thread.yield();
//            try {
//                if (i >= 50) Thread.sleep(1);
////                if (i==50) {
////                	thread4.join();
////                	System.out.println("thread printing c is alive: " + thread4.isAlive());
////                } 
//            }
//            catch (InterruptedException ex) {
//            } 
            
            

        }
        System.out.println("\nPrintNum Thread (" +   Thread.currentThread().getName() + ") done!");
    }
}
