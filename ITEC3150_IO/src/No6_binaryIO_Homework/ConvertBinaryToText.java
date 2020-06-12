package No6_binaryIO_Homework;

import java.io.*;

// NOTE This class demonstrates good exception handling
/**
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3150 Spring 2020
 * Written: January 22, 2020
 * 
 * 
 *          This class converts the binary from the file "courseFile.dat" into text.
 * 
 *          Purpose: Methods and attributes needed to create a CourseList of
 *          Courses class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 * 
 */
public class ConvertBinaryToText
{
	public static void main(String[] args)
	// throws ClassNotFoundException, IOException
	{
		try
		{ // Create an input stream for file object.dat
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("courseFile.dat"));

			// Read a string, double value, and object from the file
			English engl1 = (English) (input.readObject());
			Math math1 = (Math) (input.readObject());
			History hist1 = (History) (input.readObject());
			English engl2 = (English) (input.readObject());
			Math math2 = (Math) (input.readObject());
			History hist2 = (History) (input.readObject());

			System.out.println(engl1);
			System.out.println(math1);
			System.out.println(hist1);
			System.out.println(engl2);
			System.out.println(math2);
			System.out.println(hist2);
			
			input.close(); // Needed. Why?

		}
		catch (IOException i)
		{
			System.out.println("Unable to read from file");
			i.printStackTrace();
		}
		catch (ClassNotFoundException c)
		{
			System.out.println("Object read is not a java.util.Date instance");
		}

	}
}
