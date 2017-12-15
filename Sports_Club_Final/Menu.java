import java.util.*;
import java.io.*;

/**
 * Class Menu: a class to display on the screen an interactive menu.
 * Reads input from a file and allows the user to add/remove events from the records of registered customers,
 * to display all events and registered customers, and to send messages to users if no more tickets are available. 
 * Dimitrios Parzigkas
 * 14-12-2017
 */
public class Menu
{
    private static sortedArrayList <Event> events=new sortedArrayList<Event>(); 
    private static sortedArrayList <Customer> customers=new sortedArrayList<Customer>();
    private static Scanner sc=new Scanner(System.in);
    private static PrintWriter outFile;

    /**A method to read input from a file, store the input according to its type
     * to two sorted array lists available to other methods in the class.
     * 
     */
    private static void readFile() throws FileNotFoundException
    {
        Scanner inFile = new Scanner (new FileReader ("/home/codysseus/SportsList.txt")); 
        //add events to ArrayList from file
        int sportsno = inFile.nextInt();
        inFile.nextLine();
        for (int i=0;i<sportsno;i++)
        {
            String eventName=inFile.nextLine();
            int ticketsAv=inFile.nextInt();
            Event e = new Event(eventName, ticketsAv);    
            events.insert(e);
            inFile.nextLine();
        }
        //add customers to ArrayList from file
        int noOfCustomers=inFile.nextInt();
        inFile.nextLine();
        for (int i=0;i<noOfCustomers;i++)
        {
            String name1=inFile.next();
            String name2=inFile.next();
            Customer c = new Customer(name1, name2);
            customers.insert(c);

        }
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        readFile();
        printMenu();
        char ch = sc.next().charAt(0);
        sc.nextLine();
        while (ch!='f')
        {
            switch(ch)
            {
                case 'e': printEvents();
                break;
                case 'c': printCustomers();
                break;
                case 'b': addEvent();
                break;
                case 'r': removeEvent();
                break;
                default: System.out.println ("Invalid entry, please try again!");

            }
            printMenu();
            ch = sc.next().charAt(0);
            sc.nextLine();
        }
        System.out.println("Thank you for using Newcastle Sports Club! Goodbye...");
    }

    /**
     * A method to print the Menu on the screen.
     */
    private static void printMenu()
    {
        System.out.println("-------------------------------------------------");
        System.out.println("Welcome to Newcastle Sports Club!");
        System.out.println("To view a list of available events, press e");
        System.out.println("To view a list of registered customers, press c");
        System.out.println("To add tickets to a customer account, press b");
        System.out.println("To cancel/return tickets, press r");
        System.out.println("To exit, press f");
        System.out.println("-------------------------------------------------");
    }

    /**
     * A method that prints out a list of all events sorted alphabetically in ascending order
     */
    private static void printEvents()
    {
        System.out.println("Athletic Event       |       Tickets available");  
        System.out.println("-----------------------------------------------");

        for (Event e : events)
        { 
            System.out.printf("%-20s : %3d\n",e.getEventName(),e.getTickets());

        }

    }

    /**A method to add an event to a customer's record. It stores the name of the event and the tickets purchased.
     * The maximum number of events is three per customer. If no tickets are available, a text file will be printed
     * informing the customer that there are no tickets left. The method will request the name of the customer, the name 
     * of the event and the no of tickets required. User input is validated.
     */
    private static void addEvent() throws FileNotFoundException
    {
        Customer c = searchCustomer();
        Event e = searchEvent();
        System.out.println("Please enter the number of tickets you wish to buy for this event->");
        int ticketsBought=sc.nextInt();
        if (e.getTickets()>=ticketsBought && c.getList().size()<3)
        {
            c.setEvents(e.getEventName(), ticketsBought);
            e.setTickets(e.getTickets()- ticketsBought);}

        else if (e.getTickets()>=ticketsBought && c.getList().size()>=3)
        {
            System.out.println("Sorry, you are already registered for the maximum number of events.");
        }
        else
        {
            System.out.println("Sorry, no tickets left for this event.");
            PrintWriter outFile = new PrintWriter ("/home/codysseus/TicketsUnavailableMessage.txt");
            outFile.print("Dear ");
            outFile.println(c.getFullName());
            outFile.println(" ");
            outFile.println("Unfortunately, there are only " + e.getTickets() + " tickets left for this event(" + e.getEventName() +")"); 
            outFile.println(" ");
            outFile.println("Sincerely,");
            outFile.println("Newcastle Sports Club");
            outFile.close();

        }

    }

    /**
     * A method to remove an event from a customer's record.
     */
    private static void removeEvent()
    {
        Customer c = searchCustomer();
        System.out.println("Please enter the event you wish to cancel->");
        sc.nextLine();
        String eventName = sc.nextLine();
        Event eventSearch =  new Event(eventName);
        Event eventFound=c.getEvent(eventSearch);
        int returnTickets=eventFound.getTickets();
        c.removeEvent(eventFound);//removes event from Customer's list of events
        //and returns the correct number of tickets in the ArrayList of the Club
        int index=0;
        boolean found = false;
        while (index < events.size() && !found) {

            for (Event event : events){
                if (event.getEventName().equalsIgnoreCase (eventFound.getEventName()))
                {
                    found = true;
                    eventFound = event;}

                else {
                    index++;}}
        }
        if (found){
            eventFound.setTickets(eventFound.getTickets()+returnTickets);
        }

    }

    /** A method to retrieve a customer's name. Validates input.
     * 
     */
    private static Customer searchCustomer()
    {
        Customer customerSearch =  new Customer();
        boolean found = false;
        while (!found) 
        {
            System.out.println("Please enter the customer's full name");
            String firstName = sc.next().trim();
            String surname = sc.next().trim();
            customerSearch = new Customer (firstName, surname);

            for (Customer customer : customers)
            {
                if (customer.getFname().equalsIgnoreCase (customerSearch.getFname()) && 
                customer.getSurname().equalsIgnoreCase(customerSearch.getSurname()))
                {
                    found = true;
                    customerSearch = customer;
                    return customerSearch;

                }

            }

            System.out.println ("Customer not found.");
            found=false;

        }
        return customerSearch;     
    }

    /**A method to retrieve an event and the tickets left for that event. Validates input.
     * 
     */
    private static Event searchEvent()
    {
        Event eventSearch =  new Event();
        boolean found = false;
        sc.nextLine();
        while (!found) {

            System.out.println("Please enter the event you wish to access");
            String eventName = sc.nextLine().trim();
            eventSearch =  new Event(eventName);
            for (Event event : events){
                if (event.getEventName().equalsIgnoreCase (eventSearch.getEventName()))
                {
                    found = true;
                    eventSearch = event;
                    return eventSearch;
                }

            }

            System.out.println ("Event not found.");
            found=false;

        }
        return eventSearch;      

    }

    /**A method to print a record of all the registered customers, along with the events and the tickets 
     * they have purchased.
     * 
     */
    private static void printCustomers()
    {
        System.out.println("Customer      | Events (Tckts)");  
        System.out.println("------------------------------");

        for (Customer c : customers)
        { 
            System.out.printf("%10s:%10s\n",c.getFullName(), c.getArrayList());

        }
    }
}
