package review1.binaryIO;

import java.io.*;
import java.util.Scanner;

public class TestDataStreamWrite
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = keyboard.next();
		keyboard.close();

		try
		{ // Create an output stream for file temp.dat
			DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName));

			// Write student test scores to the file
			output.writeUTF("John");
			output.writeDouble(85.5);
			output.writeUTF("Jim");
			output.writeDouble(185.5);
			output.writeUTF("George");
			output.writeDouble(105.25);
			output.close(); // Needed. WHY?
		}
		catch (IOException e)
		{
			System.out.println("Problem writing to file- ending program");
			System.exit(0);
		}
	}
}
