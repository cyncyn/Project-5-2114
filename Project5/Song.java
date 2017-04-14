package prj5;

/**
 * The song class stores information for each song:
 * the artist name, title, year, and genre
 * @author lchar16
 * @version 2017.04.14
 *
 */
public class Song {
    //~ Fields---------------------
    private String title;
    private String artist;
    private String genre;
    private int year;
    private StudentList heards;
    private StudentList likes;
    
    //~ Constructor------------------
    /**
     * new Song object
     * @param t The title of the song
     * @param art Name of the artist
     * @param year Year it was released
     * @param gen Genre of the song
     */
    public Song(String t, String art, int y, String gen)
    {
        title = t;
        artist = art;
        year = y;
        genre = gen;
        heards = new StudentList();
        likes = new StudentList();
    }
    
    //~ Methods-----------------------
    /**
     * @return the title of the Song
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * @return the artist of the song
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * @return the year the song was released
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * @return the genre of the song
     */
    public String genre()
    {
        return genre;
    }
    
    /**
     * adds a student who has heard this song
     * to the list
     */
    public void addToHeards(Student s)
    {
        heards.add(s);
    }
    
    /**
     * adds a student who likes this song to
     * its list
     */
    public void addToLikes(Student s)
    {
        likes.add(s);
    }
    
    /**
     * @return the list of Students who has heard
     * the song
     */
    public StudentList getHeards()
    {
        return heards;
    }
    
    /**
     * @return the list of Students who has liked the song
     */
    public StudentList getLikes()
    {
        return likes;
    }

}
