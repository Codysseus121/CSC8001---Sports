
/**
 * Class Event is a class designed to create objects containing information about athletic events.
 * It includes simple methods to set event name, tickets available, print a list of events and store events in ascending 
 * alphabetical order. It implements the Comparable interface.
 * Dimitrios P.
 * 12-12-2017
 */
public class Event implements Comparable <Event>
{
    private String eventName;
    private int ticketsAv;

    /**
     * Constructor for objects of class Event (no arguments)
     */
    public Event()
    {

    }

    /**
     * Constructor for objects of class Event 
     * @param name of type String:the name of the event
     */
    public Event(String name)
    {
        this.eventName=name;

    }

    /**
     * Constructor for objects of class Event 
     * @param name of type String:the name of the event
     * @param tickets of type integer:the number of tickets available
     */
    public Event (String name, int tickets) 
    {
        this.eventName=name;
        this.ticketsAv=tickets;
     }

    /**
     * Method to set name of event
     * @name of String type
     * 
     */
    public void setEventName (String name)
    {
        eventName=name;
    }

    /**
     * Method to set number of available tickets
     */
    public void setTickets (int tickets)
    {
        ticketsAv=tickets;
    }

    /**
     * Method to get Event name
     */

    public String getEventName()
    {
        return eventName;}

    /**
     * Method to get no of tickets
     * 
     */
    public int getTickets()
    {
        return ticketsAv;
    }

    /**
     * compareTo Method
     */

    public int compareTo (Event e)
    {
        int eventCompare=eventName.compareTo(e.eventName);
        return eventCompare;
    }

    public String toString ()
    {
        return eventName + " (" + ticketsAv + ")";
    }
    
}
