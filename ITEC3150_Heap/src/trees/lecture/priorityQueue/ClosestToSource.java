package trees.lecture.priorityQueue;

import java.util.*;

public class ClosestToSource {
	public static void main(String[] args) {
		Point[] points = {
				 new Point (2, 3, "P1"), new Point (3.5, 4.1, "P2"), 
		         new Point (5.6, 7.8, "P3"), new Point (1, 2, "P4"),
		         new Point (0.5, 3, "P5")
		       };
		Point source = new Point(0, 0, "Source");
		
		//Add necessary code to create a priority queue of points. The priority is the 
		//distance of a point to the source.
		DistanceToSourceComparator dts = new DistanceToSourceComparator(source);
		PriorityQueue<Point> queue = new PriorityQueue<Point>(dts);
		for (Point p: points)
		{
			queue.offer(p);
		}
		
		System.out.print("The point closest to " + source + " is ");
    	System.out.println(queue.peek());
	}
}
