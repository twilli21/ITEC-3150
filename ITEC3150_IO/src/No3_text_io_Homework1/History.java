/**
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3150 Spring 2020
 * Written: January 9, 2020
 * 
 * 
 * This class describes a subclass of Course called History
 * 
 * Purpose: Contains the attributes specific to a type of Course called
 *          History.
 */

package No3_text_io_Homework1;

public class History extends Course
{
	
	private boolean eligible;
	private String type;
	
	public History(int crn, String name, String category, boolean eligible, String type)
	{
		super(crn, name, category);
		this.eligible = eligible;
		this.type = type;
	}

	public boolean isEligible()
	{
		return eligible;
	}

	public String getType()
	{
		return type;
	}

	@Override
	public String toString()
	{
		return super.toString() + " History [eligible=" + eligible + ", type=" + type + "]";
	}

}