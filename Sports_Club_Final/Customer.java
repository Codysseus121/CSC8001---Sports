import java.util.*;
/**
 * Class Customer 
 * Details of the customers of a Sports Club. 
 * @Dimitrios P.
 * @8 Dec 2017
 */
public class Customer implements Comparable <Customer>
{

    private String firstName;
    private String Surname;
    private sortedArrayList<Event> listOfEvents;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name1, String name2)
    {
        firstName=name1;
        Surname=name2;
        this.listOfEvents = new sortedArrayList<Event>();

    }

    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        firstName="";
        Surname="";
    }

    /**
     * A method to set the name of the Customer
     * @param name1, name2 of String type for the first and the last name
     */
    public void setName(String name1, String name2)
    {
        firstName=name1;
        Surname=name2;
    }

    /**
     * A method to get the customer's first name
     */
    public String getFname()
    {

        return firstName;
    }

    /**A method to get the customer's last name
     * 
     */
    public String getSurname()
    {
        return Surname;
    }

    /**A method to get the customer's full name
     * 
     */
    public String getFullName()
    {
        return firstName + " " + Surname;
    }

    /**A method to add an event to this customer's list of events.
     * The event is inserted in alphabetical order. 
     * 
     */
    public void setEvents (String name, Integer tickets)
    {
        Event e = new Event(name, tickets);
        listOfEvents.insert(e);

    }

    /**
     * A method to get this customer's list of events in String format.
     */
    public String getArrayList()
    {
        return listOfEvents.toString().replace("["," ").replace("]"," ");
    }

    /**A method to get this customer's list of events.
     * Returns a sortedArrayList object
     */
    public sortedArrayList getList()
    {

        return listOfEvents;
    }

    /**A method to retrieve an event from this customer's list of events
     * @param Event eventSearch:the object to be matched.
     */
    public Event getEvent(Event eventSearch)
    {
        Event eventFound =  new Event();
        int index=0;
        boolean found = false;
        while (index < listOfEvents.size() && !found) {

            for (Event event : listOfEvents){
                if (event.getEventName().equalsIgnoreCase (eventSearch.getEventName()))
                {
                    found = true;
                    eventFound = event;}

                else {
                    index++;}}
        }
        if (found){
            return eventFound;}
        else {
            System.out.println ("Event not found.");
            eventSearch = null;            

        }
        return eventFound;
    }

    /**
     * A method to remove an event from this customer's list of events.
     * 
     */
    public void removeEvent(Event event)
    {
        listOfEvents.remove(event);
    }

    /**The compareTo method of this class.
     * 
     */
    public int compareTo (Customer c)
    {
        int ln = Surname.compareTo(c.Surname);
        int fn = firstName.compareTo (c.firstName);
        if (ln != 0) 
            return ln;
        else
            return fn;
    }

    /**
     * The toString Method of this class
     */

    public String toString ()
    {
        return firstName + "  " + Surname;
    }

}

