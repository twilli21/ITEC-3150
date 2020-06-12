package Homework8;


/**
   This class encapsulates a work order with a priority.
 */
public class WorkOrder implements Comparable<WorkOrder>
{
	private int priority;
	private String description;

	/**
      Constructs a work order with a given priority and description.
      @param aPriority the priority of this work order
      @param aDescription the description of this work order
	 */
	public WorkOrder(int aPriority, String aDescription)
	{
		priority = aPriority;
		description = aDescription;
	}

	public String toString()
	{
		return "WorkOrder (" + priority + ", " + description + ")";
	}

	@Override
	public int compareTo(WorkOrder other) {
		// TODO Auto-generated method stub
		if (priority < other.priority) return -1;
		if (priority > other.priority) return 1;
		return 0;
	}
}
