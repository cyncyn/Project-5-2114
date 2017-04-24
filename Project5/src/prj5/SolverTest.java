package prj5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * SolverTest will test all of the methods in
 * Solver to make sure that they run and perform as expected
 *
 * @author cynthz5
 * @version 2017.04.16
 */

public class SolverTest extends student.TestCase {
    private HashMap<String, int[]> testMajor;
    private HashMap<String, int[]> testRegion;
    private HashMap<String, int[]> testHobby;

    private Song song;


    /**
     * sets up each test method before it runs
     */
    public void setUp() {
        new Solver();
        song = new Song("Perfect", "Ed Seeran", 2017, "pop");

        Student cynthia = new Student("CS", "NOVA", "coughing");
        Student charlie = new Student("ME", "Thailand", "squatting");
        Student mitchell = new Student("CS", "NOVA", "kungfu fighting");
        Student vikram = new Student("Bio", "Little Asia", "eating");

        song.addToHeards(cynthia);
        song.addToHeards(charlie);
        song.addToHeards(mitchell);
        song.addToHeards(vikram);

        song.addToLikes(cynthia);
        song.addToLikes(charlie);

        // creates the HashMap with majors as keys
        testMajor = new HashMap<>();
        int[] heardsLikes = new int[2];
        heardsLikes[0] = 2;
        heardsLikes[1] = 1;
        testMajor.put("CS", heardsLikes);

        heardsLikes = new int[2];
        heardsLikes[0] = 1;
        heardsLikes[1] = 1;
        testMajor.put("ME", heardsLikes);

        heardsLikes = new int[2];
        heardsLikes[0] = 1;
        heardsLikes[1] = 0;
        testMajor.put("Bio", heardsLikes);

        // creates the HashMap with regions as keys
        testRegion = new HashMap<>();
        heardsLikes = new int[2];
        heardsLikes[0] = 2;
        heardsLikes[1] = 1;
        testRegion.put("NOVA", heardsLikes);

        heardsLikes = new int[2];
        heardsLikes[0] = 1;
        heardsLikes[1] = 1;
        testRegion.put("Thailand", heardsLikes);

        heardsLikes = new int[2];
        heardsLikes[0] = 1;
        heardsLikes[1] = 0;
        testRegion.put("Little Asia", heardsLikes);

        // creates the HashMap with hobbies as keys
        testHobby = new HashMap<>();
        heardsLikes = new int[2];
        heardsLikes[0] = 1;
        heardsLikes[1] = 1;
        testHobby.put("coughing", heardsLikes);

        heardsLikes = new int[2];
        heardsLikes[0] = 1;
        heardsLikes[1] = 1;
        testHobby.put("squatting", heardsLikes);

        heardsLikes = new int[2];
        heardsLikes[0] = 1;
        heardsLikes[1] = 0;
        testHobby.put("kungfu fighting", heardsLikes);

        heardsLikes = new int[2];
        heardsLikes[0] = 1;
        heardsLikes[1] = 0;
        testHobby.put("eating", heardsLikes);
    }


    /**
     * tests to see if the HashMap of specific attributes and respective heards
     * and likes is returned correctly
     */
    public void testSolve() {
        HashMap<String, int[]> resultMajor = Solver.solve(song, "major");
        assertEquals(testMajor.keySet(), resultMajor.keySet());
        Iterator<String> itMajor = testMajor.keySet().iterator();

        while (itMajor.hasNext()) {
            String key = itMajor.next();
            System.out.println(testMajor.get(key)[0]);
            System.out.println(resultMajor.get(key)[0]);
            assertTrue(Arrays.equals(testMajor.get(key), resultMajor.get(key)));

        }

        HashMap<String, int[]> resultRegion = Solver.solve(song, "region");
        assertEquals(testRegion.keySet(), resultRegion.keySet());
        Iterator<String> itRegion = testRegion.keySet().iterator();

        while (itRegion.hasNext()) {
            String key = itRegion.next();
            assertTrue(Arrays.equals(testRegion.get(key), resultRegion.get(
                key)));

        }

        HashMap<String, int[]> resultHobby = Solver.solve(song, "hobby");
        assertEquals(testHobby.keySet(), resultHobby.keySet());
        Iterator<String> itHobby = testHobby.keySet().iterator();

        while (itHobby.hasNext()) {
            String key = itHobby.next();
            assertTrue(Arrays.equals(testHobby.get(key), resultHobby.get(key)));

        }
    }
}