package No2_text_io_inClassExercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: ClientList
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class � This class describes ClientList used to contain the Pet
 *          item ClientList. It also contains the main method which starts the
 *          program.
 * 
 *          Purpose: � Methods and attributes needed to create a ClientList of
 *          Pet class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 *
 */
public class ClientManager
{

    /**
     * 
     * Method:main()
     * 
     * This method is the starting point of the program. It contains the initial
     * reading of items from the text file Pet.txt and a menu for allowing user
     * to choose various tasks.
     * 
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // create ClientList by reading in from text file named media.txt
        ClientList myClientList = new ClientList();

        // open text file
        File petFile = new File("pets.txt");
        // open a Scanner to read data from File
        Scanner petReader = null;
        try
        {
            petReader = new Scanner(petFile);
        } catch (FileNotFoundException e)
        {

            System.out.println("No ClientList Pet found- ClientList is empty");

        }

        // read one person at a time
        while (petReader != null && petReader.hasNext())
        {

            String category = petReader.nextLine();
            String name = petReader.nextLine();
            String ownerName = petReader.nextLine();
            String ageString = petReader.nextLine();
            int age = Integer.parseInt(ageString);

            if (category.equalsIgnoreCase("Other"))
            {
                String temp = petReader.nextLine();
                boolean handling = Boolean.parseBoolean(temp);
                String type = petReader.nextLine();
                Other tp = new Other(category, name, ownerName,age, handling, type);
                myClientList.addItem(tp);

            } 
            else if (category.equalsIgnoreCase("Cat"))
            {
                String temp = petReader.nextLine();
                boolean declawed = Boolean.parseBoolean(temp);
                temp = petReader.nextLine();
                boolean longHair = Boolean.parseBoolean(temp);
                String color = petReader.nextLine();

                Cat tp = new Cat(category, name, ownerName,age, longHair, declawed, color);
                myClientList.addItem(tp);

            } 
            else if (category.equalsIgnoreCase("Dog"))
            {
                String breed = petReader.nextLine();
                String color = petReader.nextLine();
                Dog tp = new Dog(category, name, ownerName,age,breed, color);
                myClientList.addItem(tp);
            }
            else
            {
                System.out.println("Unknown Pet type " + category);
            }

        }

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Client List");
        boolean done = false;
        while (!done)
        {
            System.out.println("Would you like to :");
            System.out.println("  1. View contents of Client List");
            System.out.println("  2. Search for a pet");
            System.out.println("  3. Remove a pet");
            System.out.println("  4. Add a pet");
            System.out.println("  5. Exit");
            String tp = keyboard.nextLine();
            int userInput = Integer.parseInt(tp);
            if (userInput == 1)
            {
                myClientList.printclientListItems();
            } else if (userInput == 2)
            {
                System.out.println("Please enter pet name");
                String  id = keyboard.nextLine();
                Pet item = myClientList.searchByName(id);
                if (item != null)
                {
                    System.out.println(item);
                } else
                {
                    System.out.println("Sorry- item not found");
                }
            } else if (userInput == 3)
            {
                System.out.println("Please enter pet name");
                String id2 = keyboard.nextLine();
                myClientList.removeItem(id2);
            } else if (userInput == 4)
            {
                System.out.println("Please enter pet type (cat/dog/other)");
                String type = keyboard.nextLine();
                System.out.println("Please enter pet name");
                String name = keyboard.nextLine();
                System.out.println("Please enter owner name");
                String ownerName = keyboard.nextLine();
                System.out.println("Please enter pet age");
                int age = keyboard.nextInt();
                if (type.equalsIgnoreCase("dog"))
                {
                	keyboard.nextLine();
                	System.out.println("Please enter dog breed");
                	String breed = keyboard.nextLine();
                	System.out.println("Please enter dog hair color");
                	String hairColor = keyboard.nextLine();
                	Dog dog1 = new Dog(type, name, ownerName, age, breed, hairColor);
                	myClientList.addItem(dog1);
                }
                else if (type.equalsIgnoreCase("cat"))
                {
                	System.out.println("This is a longhaired cat (true/false)");
                	boolean longHair = keyboard.nextBoolean();
                	System.out.println("This is a clawed cat (true/false)");
                	boolean clawed = keyboard.nextBoolean();
                	keyboard.nextLine();
                	System.out.println("Please enter cat hair color");
                	String hairColor = keyboard.nextLine();
                	Cat cat1 = new Cat(type, name, ownerName, age, longHair, clawed, hairColor);
                	myClientList.addItem(cat1);
                }
                else
                {
                	System.out.println("Is there any special handling?");
                	boolean specialHandling = keyboard.nextBoolean();
                	keyboard.nextLine();
                	System.out.println("Please enter pet type");
                	String type2 = keyboard.nextLine();
                	Other other1 = new Other(type, name, ownerName, age, specialHandling, type2);
                	myClientList.addItem(other1);
                }
            }
            
            else
            {
                done = true;
                // write out contents of ClientList back to original file
                PrintWriter out = null;
                // open file for writing
                try
                {
                    out = new PrintWriter(new File("pets.txt"));
                } catch (FileNotFoundException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // write contents of each ClientList item to file
                for (Pet g : myClientList.getclientListItems())
                {
                    // first write the attributes common to all
                    out.println(g.getType());
                    out.println(g.getName());
                    out.println(g.getOwnerName()  );
                    out.println(g.getAge() );

                    if (g.getType().equalsIgnoreCase("Other"))
                    {
                        // cast to appropriate subclass
                        Other p = (Other) g;
                        out.println(p.isSpecialHandling() );
                        out.println(p.getPetType() );

                    } else if (g.getType().equalsIgnoreCase("Cat"))
                    {
                        // cast to appropriate subclass
                        Cat c = (Cat) g;
                        // write attributes specific to Cat
                        out.println(c.isClawed());
                        out.println(c.isLongHair());
                        out.println(c.getHairColor());

                    } else if (g.getType().equalsIgnoreCase("Dog"))
                    {
                        Dog m = (Dog) g;
                        out.println(m.getBreed());
                        out.println(m.getHairColor());


                    } else
                    {
                        System.out.println("Unknown Pet type " + g.getType());
                    }

                }
                out.close();

            }

        }

    }

}
