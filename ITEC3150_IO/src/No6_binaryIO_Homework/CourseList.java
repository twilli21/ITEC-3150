/**
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3150 Spring 2020
 * Written: January 9, 2020
 * 
 * 
 * This class describes CourseList used to contain the Course
 * item CourseList. It also contains the main method which starts the
 * program.
 * 
 * Purpose: Methods and attributes needed to create a CourseList of
 *          Course class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 */
package No6_binaryIO_Homework;

import java.util.ArrayList;

public class CourseList
{
	// actual ClientList data
    private ArrayList<Course> courseListItems = new ArrayList<Course>();

    /**
     * Method:printcourseListItems()
     * 
     * This method prints the CourseList items contained in the courseListItems
     * Array list. It relies on the toString method of the various Course types to
     * print the items in a user friendly format.
     * 
     * 
     */
    public void printcourseListItems()
    {
    	for(int i = 0; i < courseListItems.size(); i++)
    	{
    		Course temp = courseListItems.get(i);
    		System.out.println(temp);
    	}
    }
    
    /**
     * Method:searchByName()
     * 
     * This method looks at each item in the courseListItems array list and if
     * its name attribute matches the input parameter id, that item is
     * returned to the caller. It returns null if item is not found.
     * 
     * @param name
     * 
     * @return Course
     * 
     */
    public Course searchByName(String name)
    {
        Course courses = null;
        for (Course temp : courseListItems)
        {
        	if (temp.getName().equalsIgnoreCase(name) )
            {
                courses = temp;
            }
        }
        return courses;
    }
    
    /**
     * @return the courseListItems
     */
    public ArrayList<Course> getcourseListItems()
    {
        return courseListItems;
    }
    
    /**
     * Method:addItem()
     * 
     * This method adds the parameter m to the courseListItems array list
     * 
     * @param c
     * 
     */
    public void addItem(Course c)
    {
    	courseListItems.add(c);
    }
    
    /**
     * Method:removeItem()
     * 
     * This method removes the item with id from the array list
     * 
     * @param crn
     * 
     */
    public void removeItem(String name)
    {
    	Course g = this.searchByName(name);
        if (g != null)
        {
        	courseListItems.remove(g);
        }
    }
}
