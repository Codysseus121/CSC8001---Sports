

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerTest
{
    private Event Archery;
    private Event Tennis;
    private Event Basketball;
    private Event Football;
    private SortedArrayList sortedAr1;
    private Event event1;
    private Event event2;
    private SortedArrayList sortedAr2;
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Customer customer4;
    private Customer customer5;

    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Archery = new Event();
        Tennis = new Event();
        Basketball = new Event();
        Football = new Event();
        Archery.setEventName("Archery");
        Tennis.setEventName("Tennis");
        Basketball.setEventName("Basketball");
        Football.setEventName("Football");
        sortedAr1 = new SortedArrayList();
        event1 = new Event("Equestrian", 23);
        event2 = new Event("Diving", 12);
        sortedAr2 = new SortedArrayList();
        sortedAr2.insert(Football);
        sortedAr2.insert(Tennis);
        sortedAr2.insert(Archery);
        sortedAr2.insert(event2);
        sortedAr2.insert(event1);
        sortedAr2.insert(Football);
        sortedAr2.insert(Basketball);
        customer1 = new Customer("John", "Archer");
        customer2 = new Customer("Anna", "Smith");
        customer3 = new Customer("John", "Smith");
        customer4 = new Customer("Tom", "Cook");
        customer5 = new Customer("Dorian", "Shaw");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
