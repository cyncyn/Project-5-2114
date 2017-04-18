package prj5;

import student.TestCase;

/**
 * tests the method of the Song class
 * 
 * @author lchar16
 * @version 2017.04.14
 *
 */
public class SongTest extends TestCase {
    // ~ Fields--------------------
    private Student charlie;
    private Student cynthia;
    private Student vikram;
    private Student mitchell;
    private Song perfect;
    private Song closer;
    private Song royals;
    private Song smile;
    private Song starving;


    /**
     * sets up the test with 4 students
     * and 5 songs
     */
    public void setUp() {
        charlie = new Student("ME", "Thailand", "squatting");
        cynthia = new Student("CS", "China", "coughing");
        mitchell = new Student("CS", "NOVA", "kungfu fighting");
        vikram = new Student("Bio", "Little Asia", "eating");

        perfect = new Song("Perfect", "Ed Sheeran", 2017, "Pop");
        perfect.addToHeards(charlie);
        perfect.addToHeards(vikram);
        perfect.addToHeards(cynthia);
        perfect.addToLikes(charlie);
        perfect.addToLikes(vikram);

        closer = new Song("Closer", "Chainsmokers", 2015, "Pop");
        closer.addToHeards(charlie);
        closer.addToHeards(vikram);
        closer.addToHeards(mitchell);
        closer.addToHeards(cynthia);
        closer.addToLikes(charlie);

        royals = new Song("Royals", "Lorde", 2014, "Pop");
        royals.addToHeards(charlie);
        royals.addToHeards(cynthia);
        royals.addToLikes(cynthia);

        starving = new Song("Starving", "Hailee Steinfeld", 2015, "Pop");
        starving.addToHeards(charlie);
        starving.addToLikes(charlie);

        smile = new Song("Smile", "Uncle Kracker", 2010, "Pop");

    }


    /**
     * tests if getTitle returns right title
     */
    public void testGetTitle() {
        assertEquals("Perfect", perfect.getTitle());
    }


    /**
     * tests if getArtist returns right artist
     */
    public void testGetArtist() {
        assertEquals("Ed Sheeran", perfect.getArtist());
    }


    /**
     * tests if get year returns right year
     */
    public void testGetYear() {
        assertEquals(2017, perfect.getYear());
    }


    /**
     * tests if getGenre returns right genre
     */
    public void testGenre() {
        assertEquals("Pop", perfect.getGenre());
    }


    /**
     * tests if addToHeards increments the size of heards
     */
    public void testAddToHeards() {
        assertEquals(0, smile.getHeards().size());
        smile.addToHeards(charlie);
        smile.addToHeards(cynthia);
        assertEquals(2, smile.getHeards().size());
    }


    /**
     * tests if students get added to likes correctly
     */
    public void testAddToLikes() {
        assertEquals(1, royals.getLikes().size());
        royals.addToLikes(charlie);
        assertEquals(2, royals.getLikes().size());
        System.out.println(royals.toString());
    }


    /**
     * tests that heards returns the right list
     */
    public void testGetHeards() {
        assertEquals(3, perfect.getHeards().size());
    }


    /**
     * tests if toString returns the right representation
     */
    public void testToString() {
        String test = "Song Title: Smile\n" + "Song Artist: Uncle Kracker\n"
            + "Song Genre: Pop\n" + "Song Year: 2010";
        assertEquals(test, smile.toString());
        test = "Song Title: Closer\n" + "Song Artist: Chainsmokers\n"
            + "Song Genre: Pop\n" + "Song Year: 2015";
        assertEquals(test, closer.toString());
    }

}