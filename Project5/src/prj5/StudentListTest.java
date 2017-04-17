package prj5;

import java.util.Iterator;
import student.TestCase;

/**
 * Tests the StudentList class and its methods
 * 
 * @author lchar16
 * @version 2017.04.14
 *
 */
public class StudentListTest extends TestCase {
    // ~ Fields---------------------
    private Student charlie;
    private Student cynthia;
    private Student mitchell;
    private Student vikram;
    private StudentList list;


    /**
     * sets up the test with 4 Students and an empty list
     */
    public void setUp() {
        charlie = new Student("ME", "Thailand", "squatting");
        cynthia = new Student("CS", "China", "coughing");
        mitchell = new Student("CS", "NOVA", "kungfu fighting");
        vikram = new Student("Bio", "Little Asia", "eating");

        list = new StudentList();
    }


    /**
     * tests if the size method returns the correct size
     */
    public void testSize() {
        assertEquals(0, list.size());
        list.add(charlie);
        assertEquals(1, list.size());

    }


    /**
     * tests if the add method adds people correctly
     */
    public void testAdd() {
        list.add(vikram);
        list.add(cynthia);
        list.add(charlie);
        assertEquals(3, list.size());
        list.add(mitchell);
        assertEquals(4, list.size());
        System.out.println(list.toString());
    }


    /**
     * tests if isEmpty returns true when it's empty
     * and false when it has people
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(vikram);
        assertFalse(list.isEmpty());
    }


    /**
     * tests if the get method returns the right student
     */
// public void testGet() {
// list.add(charlie);
// list.add(vikram);
// list.add(cynthia);
// list.add(mitchell);
// assertEquals(c, list.get(3));
// }

    /**
     * tests if clear clears the list
     */
    public void testClear() {
        list.add(charlie);
        list.add(vikram);
        list.add(cynthia);
        list.add(mitchell);

        assertEquals(4, list.size());
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        String test = "List of 0 Students.\n";
        assertEquals(test, list.toString());
    }


    /**
     * tests the to string method
     */
    public void testToString() {
        String test = "List of 0 Students.\n";
        assertEquals(test, list.toString());
    }


    /**
     * tests the iterator method
     */
    public void testIterator() {
        Iterator<Student> it = list.iterator();
        assertFalse(it.hasNext());

        list.add(charlie);
        list.add(cynthia);
        list.add(vikram);
        list.add(mitchell);

        Iterator<Student> it2 = list.iterator();
        assertTrue(it2.hasNext());
        assertEquals(mitchell, it2.next());
        assertEquals(vikram, it2.next());
        assertEquals(cynthia, it2.next());
        assertEquals(charlie, it2.next());

        assertFalse(it2.hasNext());
    }

}
