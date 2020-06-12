/**
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3150 Spring 2020
 * Written: January 9, 2020
 * 
 * 
 * This class describes a subclass of Course called English
 * 
 * Purpose: Contains the attributes specific to a type of Course called
 *          English.
 */
package No6_binaryIO_Homework;

public class English extends Course
{
	
	private String level;
	private String type;
	
	public English(int crn, String name, String category, String level, String type)
	{
		super(crn, name, category);
		this.level = level;
		this.type = type;
	}

	public String getLevel()
	{
		return level;
	}

	public String getType()
	{
		return type;
	}

	@Override
	public String toString()
	{
		return super.toString() + " English [level=" + level + ", type=" + type +  "]";
	}
	
}