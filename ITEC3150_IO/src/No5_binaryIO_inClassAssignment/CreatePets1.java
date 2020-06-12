package No5_binaryIO_inClassAssignment;

import java.io.*;
import java.util.Scanner;

/**
 * @author Taylor Williams
 * @version 1.0 Course: ITEC 3150 Spring 2020 Written: January 15, 2020
 */
public class CreatePets1
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = keyboard.next();
		keyboard.close();

		try
		{
			Dog dog = new Dog("Dog", "Spike", "Tommy", 5, "Dalmatian", "Brown");
			Cat cat = new Cat("Cat", "Fluffy", "Angelica", 5, true, true, "White");
			Other other = new Other("Other", "Perry", "Phinneas", 5, false, "Platypus");

			// Create an output stream for file pets1.dat
			DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName));

			// Write pet attributes to the file
			output.writeUTF(dog.getType());
			output.writeUTF(dog.getName());
			output.writeUTF(dog.getOwnerName());
			output.writeInt(dog.getAge());
			output.writeUTF(dog.getBreed());
			output.writeUTF(dog.getHairColor());
			output.writeUTF(cat.getType());
			output.writeUTF(cat.getName());
			output.writeUTF(cat.getOwnerName());
			output.writeInt(cat.getAge());
			output.writeBoolean(cat.isLongHair());
			output.writeBoolean(cat.isClawed());
			output.writeUTF(cat.getHairColor());
			output.writeUTF(other.getType());
			output.writeUTF(other.getName());
			output.writeUTF(other.getOwnerName());
			output.writeInt(other.getAge());
			output.writeBoolean(other.isSpecialHandling());
			output.writeUTF(other.getPetType());
			output.close(); // Needed. WHY?
		}
		catch (IOException e)
		{
			System.out.println("Problem writing to file- ending program");
			System.exit(0);
		}
	}
}
