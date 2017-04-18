package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

public class SongListTest extends TestCase {

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
    private Song dive;
    private Song dont;
    private Song irresistible;

    private SongList list;


    /**
     * sets up the test with a SongList, 4 students
     * and 7 songs that are added to the list
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

        dive = new Song("Dive", "Ed Sheeran", 2017, "Pop");
        dive.addToHeards(charlie);
        dive.addToLikes(charlie);

        dont = new Song("Dont", "Ed Sheeran", 2015, "Pop");
        dont.addToHeards(charlie);
        dont.addToLikes(charlie);

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
        smile.addToHeards(charlie);

        irresistible = new Song("Irresistible", "Fall Out Boy", 2015, "Rock");

        list = new SongList();
        list.add(perfect);
        list.add(royals);
        list.add(closer);
        list.add(dont);
        list.add(starving);
        list.add(smile);
        list.add(dive);

    }


    /**
     * tests if the method adds correctly
     */
    public void testAdd() {
        assertEquals(7, list.getSize());

        list.add(irresistible);
        assertEquals(8, list.getSize());

    }


    /**
     * tests if it returns true when list is empty
     */
    public void testIsEmpty() {
        SongList list2 = new SongList();
        assertTrue(list2.isEmpty());
        list2.add(closer);
        assertFalse(list2.isEmpty());
    }


    /**
     * tests if this method clears the list correctly
     */
    public void testClear() {
        assertEquals(7, list.getSize());
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }


    /**
     * tests if toString outputs the right string
     */
    public void testToString() {
        SongList testList = new SongList();
        assertEquals("Song List of 0 songs.\n", testList.toString());
        testList.add(closer);
        assertEquals("Song List of 1 songs.\n" + "SONG 1 - Song Title: Closer\n"
            + "Song Artist: Chainsmokers\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n", testList.toString());
        testList.add(dive);
        assertEquals("Song List of 2 songs.\n" + "SONG 1 - Song Title: Closer\n"
            + "Song Artist: Chainsmokers\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n" + "SONG 2 - Song Title: Dive\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2017\n", testList.toString());
    }


    /**
     * tests if the iterator iterates through the list correctly
     */
    public void testIterator() {
        list.sortSongs(SortTypeEnum.title);
        Iterator<Song> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(closer, it.next());
        assertEquals(dive, it.next());
        assertEquals(dont, it.next());
        assertEquals(perfect, it.next());
        assertEquals(royals, it.next());
        assertEquals(smile, it.next());
        assertEquals(starving, it.next());
        assertFalse(it.hasNext());

        Exception exception = null;
        try {
            it.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof NoSuchElementException);

        SongList list2 = new SongList();
        Iterator<Song> it2 = list2.iterator();
        assertFalse(it2.hasNext());
    }


    /**
     * tests if the songs sort in the correct order
     * for each type of sort
     */
    public void testSortSongs() {
        // Sort by title
        list.sortSongs(SortTypeEnum.title);
        assertEquals("Song List of 7 songs.\n" + "SONG 1 - Song Title: Closer\n"
            + "Song Artist: Chainsmokers\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n" + "SONG 2 - Song Title: Dive\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2017\n" + "SONG 3 - Song Title: Dont\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n" + "SONG 4 - Song Title: Perfect\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2017\n" + "SONG 5 - Song Title: Royals\n"
            + "Song Artist: Lorde\n" + "Song Genre: Pop\n" + "Song Year: 2014\n"
            + "SONG 6 - Song Title: Smile\n" + "Song Artist: Uncle Kracker\n"
            + "Song Genre: Pop\n" + "Song Year: 2010\n"
            + "SONG 7 - Song Title: Starving\n"
            + "Song Artist: Hailee Steinfeld\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n", list.toString());

        // Sort by artist
        list.sortSongs(SortTypeEnum.artist);
        assertEquals("Song List of 7 songs.\n" + "SONG 1 - Song Title: Closer\n"
            + "Song Artist: Chainsmokers\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n" + "SONG 2 - Song Title: Dive\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2017\n" + "SONG 3 - Song Title: Dont\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n" + "SONG 4 - Song Title: Perfect\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2017\n" + "SONG 5 - Song Title: Starving\n"
            + "Song Artist: Hailee Steinfeld\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n" + "SONG 6 - Song Title: Royals\n"
            + "Song Artist: Lorde\n" + "Song Genre: Pop\n" + "Song Year: 2014\n"
            + "SONG 7 - Song Title: Smile\n" + "Song Artist: Uncle Kracker\n"
            + "Song Genre: Pop\n" + "Song Year: 2010\n", list.toString());

        // Sort by genre
        list.sortSongs(SortTypeEnum.genre);
        assertEquals("Song List of 7 songs.\n" + "SONG 1 - Song Title: Smile\n"
            + "Song Artist: Uncle Kracker\n" + "Song Genre: Pop\n"
            + "Song Year: 2010\n" + "SONG 2 - Song Title: Royals\n"
            + "Song Artist: Lorde\n" + "Song Genre: Pop\n" + "Song Year: 2014\n"
            + "SONG 3 - Song Title: Starving\n"
            + "Song Artist: Hailee Steinfeld\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n" + "SONG 4 - Song Title: Perfect\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2017\n" + "SONG 5 - Song Title: Dont\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n" + "SONG 6 - Song Title: Dive\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2017\n" + "SONG 7 - Song Title: Closer\n"
            + "Song Artist: Chainsmokers\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n", list.toString());

        // Sort by year
        list.sortSongs(SortTypeEnum.year);
        assertEquals("Song List of 7 songs.\n" + "SONG 1 - Song Title: Smile\n"
            + "Song Artist: Uncle Kracker\n" + "Song Genre: Pop\n"
            + "Song Year: 2010\n" + "SONG 2 - Song Title: Royals\n"
            + "Song Artist: Lorde\n" + "Song Genre: Pop\n" + "Song Year: 2014\n"
            + "SONG 3 - Song Title: Closer\n" + "Song Artist: Chainsmokers\n"
            + "Song Genre: Pop\n" + "Song Year: 2015\n"
            + "SONG 4 - Song Title: Dont\n" + "Song Artist: Ed Sheeran\n"
            + "Song Genre: Pop\n" + "Song Year: 2015\n"
            + "SONG 5 - Song Title: Starving\n"
            + "Song Artist: Hailee Steinfeld\n" + "Song Genre: Pop\n"
            + "Song Year: 2015\n" + "SONG 6 - Song Title: Dive\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2017\n" + "SONG 7 - Song Title: Perfect\n"
            + "Song Artist: Ed Sheeran\n" + "Song Genre: Pop\n"
            + "Song Year: 2017\n", list.toString());
    }

}