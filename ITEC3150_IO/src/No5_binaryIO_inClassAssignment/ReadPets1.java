package No5_binaryIO_inClassAssignment;

import java.io.*;
import java.util.Scanner;

/**
 * @author Taylor Williams
 * @version 1.0 Course: ITEC 3150 Spring 2020 Written: January 9, 2020
 */
public class ReadPets1
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = keyboard.next();
		keyboard.close();

		try
		{ // Create an output stream for file pets1.dat
			DataInputStream input = new DataInputStream(new FileInputStream(fileName));

			// Read student test scores from the file
			Dog dog = new Dog(input.readUTF(), input.readUTF(), input.readUTF(), input.readInt(), input.readUTF(),
					input.readUTF());
			Cat cat = new Cat(input.readUTF(), input.readUTF(), input.readUTF(), input.readInt(), input.readBoolean(),
					input.readBoolean(), input.readUTF());
			Other other = new Other(input.readUTF(), input.readUTF(), input.readUTF(), input.readInt(),
					input.readBoolean(), input.readUTF());

			System.out.println(dog);
			System.out.println(cat);
			System.out.println(other);

			input.close();
		}
		catch (IOException e)
		{
			System.out.println("Problem writing to file- ending program");
			System.exit(0);
		}
	}
}
