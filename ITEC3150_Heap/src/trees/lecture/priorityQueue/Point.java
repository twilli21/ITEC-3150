package trees.lecture.priorityQueue;

/**
   This class encapsulates a work order with a priority.
 */
public class Point
{
	private double x;
	private double y;
	private String name;
	
	/**
      Constructs a work order with a given priority and description.
      @param aPriority the priority of this work order
      @param aDescription the description of this work order
	 */
	public Point(double x, double y, String name)
	{
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	public String toString()
	{
		return name + "(" + x + ", " + y + ")";
	}

}
