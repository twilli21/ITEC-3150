package No6_binaryIO_Homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3150 Spring 2020
 * Written: January 22, 2020
 * 
 * 
 *          This class describes CourseList used to contain the Courses item
 *          CourseList. It also contains the main method which starts the
 *          program. It also converts the text to binary.
 * 
 *          Purpose: Methods and attributes needed to create a CourseList of
 *          Courses class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 * 
 */
public class ConvertTextToBinary
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
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws IOException
	{
		// create CourseList by reading in from text file named courses.txt
		CourseList myCourseList = new CourseList();

		// open text file
		File courseFile = new File("courses.txt");
		// open a Scanner to read data from File
		Scanner courseReader = null;
		try
		{
			courseReader = new Scanner(courseFile);
		}
		catch (FileNotFoundException e)
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
			} else if (category.equalsIgnoreCase("Math"))
			{
				boolean stem = courseReader.nextBoolean();
				courseReader.nextLine();
				String type = courseReader.nextLine();
				Math tp = new Math(crn, name, category, stem, type);
				myCourseList.addItem(tp);
			} else if (category.equalsIgnoreCase("History"))
			{
				boolean eligible = courseReader.nextBoolean();
				courseReader.nextLine();
				String type = courseReader.nextLine();
				History tp = new History(crn, name, category, eligible, type);
				myCourseList.addItem(tp);
			} else
			{
				System.out.println("Unknown Course type " + category);
			}
		}
		try ( // Create an output stream for file courseFile.dat
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("courseFile.dat"));)
		{
			for (Course c : myCourseList.getcourseListItems())
            {          
                if (c.getCategory().equalsIgnoreCase("English"))
                {
                    // cast to appropriate subclass
                    English e = (English) c;
                    // write attributes specific to English
                    output.writeObject(new English(e.getCrn(), e.getName(), e.getCategory(), e.getLevel(), e.getType()));
                }
                else if (c.getCategory().equalsIgnoreCase("Math"))
                {
                    // cast to appropriate subclass
                    Math m = (Math) c;
                    // write attributes specific to Math
                    output.writeObject(new Math(m.getCrn(), m.getName(), m.getCategory(), m.isStem(), m.getType()));
                }
                else if (c.getCategory().equalsIgnoreCase("History"))
                {
                	// cast to appropriate subclass
                    History h = (History) c;
                    // write attributes specific to History
                    output.writeObject(new History(h.getCrn(), h.getName(), h.getCategory(), h.isEligible(), h.getType()));
                }
            }
		}
	}
}