package No3_text_io_Homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3150 Spring 2020
 * Written: January 9, 2020
 * 
 * 
 * This class describes CourseList used to contain the Courses
 * item CourseList. It also contains the main method which starts the
 * program.
 * 
 * Purpose: Methods and attributes needed to create a CourseList of
 *          Courses class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 *          
 */
public class CourseManager
{

	/**
     * 
     * Method:main()
     * 
     * This method is the starting point of the program. It contains the initial
     * reading of items from the text file Courses.txt and a menu for allowing user
     * to choose various tasks.
     * 
     * 
     * @param args
     */
	public static void main(String[] args)
	{
		// create CourseList by reading in from text file named media.txt
		CourseList myCourseList = new CourseList();
		
        // open text file
        File courseFile = new File("courses.txt");
        // open a Scanner to read data from File
        Scanner courseReader = null;
        try
        {
        	courseReader = new Scanner(courseFile);
		} catch (FileNotFoundException e)
        {
			System.out.println("No CourseList Course found- CourseList is empty");
		}
        
        // read one line at a time
        while (courseReader != null && courseReader.hasNext())
        {
        	
        	int crn = courseReader.nextInt();
        	courseReader.nextLine();
        	String name = courseReader.nextLine();
        	String category = courseReader.nextLine();
            
        	if (category.equalsIgnoreCase("English"))
            {        		
                String level = courseReader.nextLine();
                String type = courseReader.nextLine();
                English tp = new English(crn, name, category, level, type);
                myCourseList.addItem(tp);
            }
        	else if (category.equalsIgnoreCase("Math"))
            {
        		boolean stem = courseReader.nextBoolean();
        		courseReader.nextLine();
                String type = courseReader.nextLine();
                Math tp = new Math(crn, name, category, stem, type);
                myCourseList.addItem(tp);
            }
        	else if (category.equalsIgnoreCase("History"))
            {
                boolean eligible = courseReader.nextBoolean();
                courseReader.nextLine();
                String type = courseReader.nextLine();
                History tp = new History(crn, name, category, eligible, type);
                myCourseList.addItem(tp);
            }
        	else
        	{
        		System.out.println("Unknown Course type " + category);
        	}
        }
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Welcome to the Course List");
        boolean done = false;
        while (!done)
        {
        	System.out.println("Would you like to :");
            System.out.println("  1. View contents of Course List");
            System.out.println("  2. Search for a course");
            System.out.println("  3. Remove a course");
            System.out.println("  4. Add a course");
            System.out.println("  5. Exit");
            String tp = keyboard.nextLine();
            int userInput = Integer.parseInt(tp);
            if (userInput == 1)
            {
            	myCourseList.printcourseListItems();
            }
            else if (userInput == 2)
            {
                System.out.println("Please enter course name");
                String id = keyboard.nextLine();
                Course item = myCourseList.searchByName(id);
                if (item != null)
                {
                    System.out.println(item);
                }
                else
                {
                    System.out.println("Sorry- course not found");
                }
            }
            else if (userInput == 3)
            {
                System.out.println("Please enter course name");
                String id2 = keyboard.nextLine();
                myCourseList.removeItem(id2);
            }
            else if (userInput == 4)
            {
                System.out.println("Please enter CRN number");
                int crn = keyboard.nextInt();
                System.out.println("Please enter course name");
                keyboard.nextLine();
                String name = keyboard.nextLine();
                System.out.println("Please enter course category");
                String category = keyboard.nextLine();
                if (category.equalsIgnoreCase("english"))
                {
                	System.out.println("Please enter English course level");
                	String level = keyboard.nextLine();
                	System.out.println("Is the English course a reading course, a writing course, or both?");
                	String type = keyboard.nextLine();
                	English engl1 = new English(crn, name, category, level, type);
                	myCourseList.addItem(engl1);
                }
                else if (category.equalsIgnoreCase("math"))
                {
                	System.out.println("Is this a STEM course? (true/false)");
                	boolean stem = keyboard.nextBoolean();
                	keyboard.nextLine();
                	System.out.println("Is this course an online course, a in-person course, or a hybrid course?");
                	String type = keyboard.nextLine();
                   	Math math1 = new Math(crn, name, category, stem, type);
                	myCourseList.addItem(math1);
                }
                else
                {
                	System.out.println("Is this course Area E eligible? (true/false)");
                	boolean eligible = keyboard.nextBoolean();
                	keyboard.nextLine();
                	System.out.println("Is this course a recorded course, an online course, or an in-person course?");
                	String type = keyboard.nextLine();
                	History hist1 = new History(crn, name, category, eligible, type);
                	myCourseList.addItem(hist1);
                }
            }
            
            else
            {
                done = true;
                // write out contents of CourseList back to original file
                PrintWriter out = null;
                // open file for writing
                try
                {
                	out = new PrintWriter(new File("courses.txt"));
                } catch (FileNotFoundException e)
                {
                	e.printStackTrace();
                }
                
                // write contents of each CourseList item to file
                for (Course c : myCourseList.getcourseListItems())
                {
                	// first write the attributes common to all
                    out.println(c.getCrn());
                    out.println(c.getName());
                    out.println(c.getCategory());
                    
                    if (c.getCategory().equalsIgnoreCase("English"))
                    {
                        // cast to appropriate subclass
                        English e = (English) c;
                     // write attributes specific to English
                        out.println(e.getLevel() );
                        out.println(e.getType() );

                    }
                    else if (c.getCategory().equalsIgnoreCase("Math"))
                    {
                        // cast to appropriate subclass
                        Math m = (Math) c;
                        // write attributes specific to Math
                        out.println(m.isStem());
                        out.println(m.getType());
                    }
                    else if (c.getCategory().equalsIgnoreCase("History"))
                    {
                    	// cast to appropriate subclass
                        History h = (History) c;
                        // write attributes specific to History
                        out.println(h.isEligible());
                        out.println(h.getType());
                    }
                    else
                    {
                        System.out.println("Unknown Course type " + c.getCategory());
                    }

                }
                keyboard.close();
                out.close();
            }
        }
	}
}