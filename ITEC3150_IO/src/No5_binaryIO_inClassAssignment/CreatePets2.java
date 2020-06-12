package No5_binaryIO_inClassAssignment;

import java.io.*;

// NOTE :  This example demonstrates exception handling where user is not notified as to cause of exception 
// or problem - if there is a problem with output file- the program just ends.

public class CreatePets2
{
	public static void main(String[] args) throws IOException
	{
		try ( // Create an output stream for file object.dat
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("pets2.dat"));)
		{
			// Write an object to the file
			output.writeObject(new Dog("Dog", "Spike", "Tommy", 5, "Dalmatian", "Brown"));
			output.writeObject(new Cat("Cat", "Fluffy", "Angelica", 5, true, true, "White"));
			output.writeObject(new Other("Other", "Perry", "Phinneas", 5, false, "Platypus"));

			// output.close(); Not needed. Why?
		}
	}
}
