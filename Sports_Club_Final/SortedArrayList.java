import java.util.*;
/**
 * Class sortedArrayList <E> extends Arraylist<E>
 * A class to store type <E> objects sorted alphabetically in ascending order.
 * @Dimitrios P.
 * 6 December 2017
 */ 
public class SortedArrayList<E> extends ArrayList<E> 
{
     /**
     * Constructor for objects of class SortedArrayList
     */
    public SortedArrayList()
    {
        
    }

    /**
     * A method to insert objects into the ArrayList in alphabetical order
     * @param  Object E: the object to be inserted in the proper index of the list 
     * 
     */
    public void insert(E element)
    {
        int location;
        for (location=0; location<size();location++)
        {
            Comparable <E> temp = (Comparable<E>) get(location);
            if (temp.compareTo(element)>=0)
            {
                break;

            }

        }

        add(location, element);
    }

} 
