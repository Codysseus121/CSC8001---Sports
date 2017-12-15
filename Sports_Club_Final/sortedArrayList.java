import java.util.*;
/**
 * Class sortedArrayList <E> extends Arraylist<E>
 * A class to store type <E> objects sorted alphabetically in ascending order.
 * @Dimitrios Parzigkas
 * 6 December 2017
 */ 
public class sortedArrayList<E> extends ArrayList<E> 
{
     /**
     * Constructor for objects of class SortedArrayList
     */
    public sortedArrayList()
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
        for (location=0; location<sortedArrayList.super.size();location++)
        {
            Comparable <E> temp = (Comparable<E>) sortedArrayList.super.get(location);
            if (temp.compareTo(element)>=0)
            {
                break;

            }

        }

        sortedArrayList.super.add(location, element);
    }

} 