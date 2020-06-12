/**
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3150 Spring 2020
 * Written: January 9, 2020
 * 
 * 
 * This class contains information for all Courses
 * 
 * Purpose: The purpose is to hold the information for the broad attributes of the different Course.
 */
package No6_binaryIO_Homework;

import java.io.Serializable;

public class Course implements Serializable
{
	private int crn;
	private String name;
	private String category;
	
	public Course(int crn, String name, String category)
	{
		super();
		this.crn = crn;
		this.name = name;
		this.category = category;
	}

	public int getCrn()
	{
		return crn;
	}

	public String getName()
	{
		return name;
	}

	public String getCategory()
	{
		return category;
	}

	@Override
	public String toString()
	{
		return "Course [crn=" + crn + ", name=" + name + ", category=" + category + "]";
	}	
	
}