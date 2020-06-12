package No4_binaryIO_lecture;
import java.io.*;
import java.util.Scanner;

public class TestDataStreamRead {
	public static void main(String[] args)  {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = keyboard.next();
		keyboard.close();

		try { // Create an input stream for file temp.dat
			DataInputStream input =
					new DataInputStream(new FileInputStream(fileName));

			// Read student test scores from the file
			System.out.println(input.readUTF() + " " + input.readDouble());
			System.out.println(input.readUTF() + " " + input.readDouble());
			System.out.println(input.readUTF() + " " + input.readDouble());
			input.close(); //Needed. WHY?
		}
		catch (IOException e)
		{
			System.out.println("Problem readingfile- ending program");
			System.exit(0);
		}
	}
}
