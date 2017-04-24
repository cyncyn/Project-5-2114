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
    private Student cnr;
    private Student osa;
    private Student mos;
    private Student oom;
    private Song perfect;
    private Song closer;
    private Song royals;
    private Song smile;


    /**
     * sets up the test with 4 students
     * and 5 songs
     */
    public void setUp() {
        charlie = new Student("ME", "Thailand", "squatting");
        cynthia = new Student("CS", "China", "coughing");
        Student mitchell = new Student("CS", "NOVA", "kungfu fighting");
        Student vikram = new Student("Bio", "Little Asia", "eating");

        cnr = new Student("Computer Science", "Northeast", "reading");
        osa = new Student("Other Engineering", "Southeast", "art");
        mos = new Student("Math or CMDA", "other", "sports");
        oom = new Student("Other", "Outside", "music");

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

        Song starving = new Song("Starving", "Hailee Steinfeld", 2015, "Pop");
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


    /**
     * tests that the updateHeardsTotals method keeps a total of how many
     * students have each type of attribute and have heard this song
     */
    public void testUpdateHeardTotals() {
        perfect.updateHeardTotals(cnr);
        assertEquals(1, perfect.getHobbiesHeards()[0]);
        assertEquals(1, perfect.getMajorsHeards()[0]);
        assertEquals(1, perfect.getRegionsHeards()[0]);
        perfect.updateHeardTotals(osa);
        assertEquals(1, perfect.getHobbiesHeards()[1]);
        assertEquals(1, perfect.getMajorsHeards()[1]);
        assertEquals(1, perfect.getRegionsHeards()[1]);
        perfect.updateHeardTotals(mos);
        assertEquals(1, perfect.getHobbiesHeards()[2]);
        assertEquals(1, perfect.getMajorsHeards()[2]);
        assertEquals(1, perfect.getRegionsHeards()[2]);
        perfect.updateHeardTotals(oom);
        assertEquals(1, perfect.getHobbiesHeards()[3]);
        assertEquals(1, perfect.getMajorsHeards()[3]);
        assertEquals(1, perfect.getRegionsHeards()[3]);
        perfect.updateHeardTotals(charlie);
    }


    /**
     * tests that the updateHeardsTotals method keeps a total of how many
     * students have each type of attribute and have heard this song
     */
    public void testUpdateLikeTotals() {
        perfect.updateLikeTotals(cnr);
        assertEquals(1, perfect.getHobbiesLikes()[0]);
        assertEquals(1, perfect.getMajorsLikes()[0]);
        assertEquals(1, perfect.getRegionsLikes()[0]);
        perfect.updateLikeTotals(osa);
        assertEquals(1, perfect.getHobbiesLikes()[1]);
        assertEquals(1, perfect.getMajorsLikes()[1]);
        assertEquals(1, perfect.getRegionsLikes()[1]);
        perfect.updateLikeTotals(mos);
        assertEquals(1, perfect.getHobbiesLikes()[2]);
        assertEquals(1, perfect.getMajorsLikes()[2]);
        assertEquals(1, perfect.getRegionsLikes()[2]);
        perfect.updateLikeTotals(oom);
        assertEquals(1, perfect.getHobbiesLikes()[3]);
        assertEquals(1, perfect.getMajorsLikes()[3]);
        assertEquals(1, perfect.getRegionsLikes()[3]);
        perfect.updateLikeTotals(charlie);
    }

}