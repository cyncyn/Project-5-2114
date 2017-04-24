package prj5;
import student.TestCase;

/**
 * This class tests the methods for the Student class
 * @author lchar16
 * @version 2017.04.14
 *
 */
public class StudentTest extends TestCase
{
    //~ Fields-----------------------
    private Student cynthia;

    /**
     * sets tests up with a new student
     */
    public void setUp()
    {
        cynthia = new Student("CS", "NOVA", "coughing");
    }

    /**
     * tests if getMajor returns correct major
     */
    public void testGetMajor() {
        assertEquals("CS", cynthia.getMajor());
    }

    /**
     * tests if getRegion returns correct region
     */
    public void testGetRegion() {
        assertEquals("NOVA", cynthia.getRegion());
    }

    /**
     * tests if getHobby returns correct hobby
     */
    public void testGetHobby() {
        assertEquals("coughing", cynthia.getHobby());
    }

    /**
     * tests if toString returns correct string
     */
    public void testToString() {
        String test = "Major: CS, Region: NOVA, Hobby: coughing.";
        assertEquals(test, cynthia.toString());
    }

}