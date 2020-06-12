/**
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3150 Spring 2020
 * Written: January 9, 2020
 * 
 * 
 * This class describes a subclass of Course called Math
 * 
 * Purpose: Contains the attributes specific to a type of Course called
 *          Math.
 */

package No3_text_io_Homework1;

public class Math extends Course
{

	private boolean stem;
	private String type;
	
	public Math(int crn, String name, String category, boolean stem, String type)
	{
		super(crn, name, category);
		this.stem = stem;
		this.type = type;
	}

	public boolean isStem()
	{
		return stem;
	}

	public String getType()
	{
		return type;
	}

	@Override
	public String toString()
	{
		return super.toString() + " Math [stem=" + stem + ", type=" + type + "]";
	}

}