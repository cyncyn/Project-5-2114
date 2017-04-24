package prj5;

import student.TestCase;

/**
 * Tests the methods of the Reader Class
 * 
 * @author mliou
 * @version 2017.04.16
 */
public class ReaderTest extends TestCase {
    // ~ Fields--------------------
    private Reader reader;


    /**
     * Sets up the variables before each test
     */
    public void setUp() {
        reader = new Reader("MusicSurveyData.csv", "SongList.csv");
    }


    /**
     * Tests that the readSongs method returns a SongList of the songs in the
     * file
     */
    public void testReadSongs() {
        assertEquals(59, reader.readSongs("SongList.csv").getSize());
    }


    /**
     * Tests that the readStudents method returns a StudentList of the students
     * in the file
     */
    public void testReadStudents() {
        assertEquals(207, reader.readStudents("MusicSurveyData.csv").size());
    }
}