

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SortedArrayListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SortedArrayListTest
{
    private Event Archery;
    private Event Tennis;
    private Event Basketball;
    private Event Football;
    private SortedArrayList sortedAr1;

    /**
     * Default constructor for test class SortedArrayListTest
     */
    public SortedArrayListTest()
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
