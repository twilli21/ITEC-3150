package No4_binaryIO_lecture;
import java.io.*;
//import java.util.Scanner;

public class FixedLengthStringIO
{
    /** Read fixed number of characters from a DataInput stream */
    public static String readFixedLengthString(int size, DataInput in)

    {
        // Declare an array of characters
        char[] chars = new char[size];

        try
        {
            // Read fixed number of characters to the array
            for (int i = 0; i < size; i++) {
                chars[i] = in.readChar();
            }
        } catch (IOException e)
        {
            System.out.println("Problem reading from file");

        }

        return new String(chars);
    }

    /** Write fixed number of characters to a DataOutput stream */
    public static void writeFixedLengthString(String s, int size, DataOutput out)

    {
        char[] chars = new char[size];

        // Fill in string with characters
        s.getChars(0, Math.min(s.length(), size), chars, 0);

        // Fill in blank characters in the rest of the array
        for (int i = Math.min(s.length(), size); i < chars.length; i++)
            chars[i] = ' ';
        try
        {

            // Create and write a new string padded with blank characters
            out.writeChars(new String(chars));
        } catch (IOException e)
        {
            System.out.println("Problem writing to file");
        }
    }
    
    public static void main(String[] args) {
    	String[] records = new String[4];
    	records[0] = "John Smith 4.0  ";
    	records[1] = "Walter Allen 3.5";
    	records[2] = "Lisa Wang 3.75  ";
    	records[3] = "Alan Jones 2.75 ";

		try { // Create an input stream for file temp.dat
			DataOutputStream output =
					new DataOutputStream(new FileOutputStream("records.dat"));
			
			for (int i=0; i<4; i++) {
				writeFixedLengthString(records[i], 16, output);
			}
			
			output.close();
		}
		catch (IOException e)
		{
			System.out.println("Problem writing to file- ending program");
			System.exit(0);
		}
		
		try { // Create an input stream for file temp.dat
			DataInputStream input =
					new DataInputStream(new FileInputStream("records.dat"));
			
			for (int i=0; i<4; i++) {
				records[i] = readFixedLengthString(16, input);
				System.out.println(records[i]);
			}
			
			input.close();
		}
		catch (IOException e)
		{
			System.out.println("Problem readingfile- ending program");
			System.exit(0);
		}
    }
}
