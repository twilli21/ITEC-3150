package No5_binaryIO_inClassAssignment;

import java.io.*;

// NOTE This class demonstrates good exception handling

public class ReadPets2
{
	public static void main(String[] args)
	// throws ClassNotFoundException, IOException
	{
		try
		{ // Create an input stream for file object.dat
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("pets2.dat"));

			// Read a string, double value, and object from the file
			Dog dog = (Dog) (input.readObject());
			Cat cat = (Cat) (input.readObject());
			Other other = (Other) (input.readObject());

			System.out.println(dog);
			System.out.println(cat);
			System.out.println(other);
			
			input.close(); // Needed. Why?

		} catch (IOException i)
		{
			System.out.println("Unable to read from file");
			i.printStackTrace();
		} catch (ClassNotFoundException c)
		{
			System.out.println("Object read is not a java.util.Date instance");
		}

	}
}
