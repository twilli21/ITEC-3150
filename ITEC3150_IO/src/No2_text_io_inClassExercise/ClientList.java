package No2_text_io_inClassExercise;

import java.util.ArrayList;


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
public class ClientList
{

    // actual ClientList data
    private ArrayList<Pet> clientListItems = new ArrayList<Pet>();

    /**
     * Method:printclientListItems()
     * 
     * This method prints the ClientList items contained in the clientListItems
     * Array list. It relies on the toString method of the various Pet types to
     * print the items in a user friendly format.
     * 
     * 
     */
    public void printclientListItems()
    {
        for (int i = 0; i < clientListItems.size(); i++)
        {
            Pet temp = clientListItems.get(i);
            System.out.println(temp);
        }

    }

    /**
     * Method:searchById()
     * 
     * This method looks at each item in the clientListItems array list and if
     * its idNumber attribute matches the input parameter id, that item is
     * returned to the caller. It returns null if item is not found.
     * 
     * @param name
     * 
     * @return Pet
     * 
     */
    public Pet searchByName(String name)
    {
        Pet item = null;
        for (Pet temp : clientListItems)
        {
            if (temp.getName().equalsIgnoreCase(name) )
            {
                item = temp;
            }

        }
        return item;
    }

    /**
     * @return the clientListItems
     */
    public ArrayList<Pet> getclientListItems()
    {
        return clientListItems;
    }

    /**
     * Method:addItem()
     * 
     * This method adds the parameter m to the clientListItems array list
     * 
     * @param m
     * 
     */
    public void addItem(Pet m)
    {
        clientListItems.add(m);
    }

    /**
     * Method:removeItem()
     * 
     * This method removes the item with id from the array list
     * 
     * @param m
     * 
     */
    public void removeItem(String name)
    {
        Pet g = this.searchByName(name);
        if (g != null)
        {
            clientListItems.remove(g);
        }
    }

}
