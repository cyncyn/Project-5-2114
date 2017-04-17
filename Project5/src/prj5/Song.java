package prj5;

/**
 * The song class stores information for each song:
 * the artist name, title, year, and genre
 * 
 * @author lchar16
 * @version 2017.04.14
 *
 */
public class Song {
    // ~ Fields---------------------
    private String title;
    private String artist;
    private String genre;
    private int year;
    private StudentList heards;
    private StudentList likes;


    // ~ Constructor------------------
    /**
     * new Song object
     * 
     * @param t
     *            The title of the song
     * @param art
     *            Name of the artist
     * @param y
     *            Year it was released
     * @param gen
     *            Genre of the song
     */
    public Song(String t, String art, int y, String gen) {
        title = t;
        artist = art;
        year = y;
        genre = gen;
        heards = new StudentList();
        likes = new StudentList();
    }


    // ~ Methods-----------------------
    /**
     * @return the title of the Song
     */
    public String getTitle() {
        return title;
    }


    /**
     * @return the artist of the song
     */
    public String getArtist() {
        return artist;
    }


    /**
     * @return the year the song was released
     */
    public int getYear() {
        return year;
    }


    /**
     * @return the genre of the song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * adds a student who has heard this song
     * to the list
     * 
     * @param s
     *            Student who heard the song
     */
    public void addToHeards(Student s) {
        heards.add(s);
    }


    /**
     * adds a student who likes this song to
     * its list
     * 
     * @param s
     *            Student who liked the song
     */
    public void addToLikes(Student s) {
        // might want to throw exception if the student
        // hasn't heard the song
        likes.add(s);
    }


    /**
     * @return the list of Students who has heard
     *         the song
     */
    public StudentList getHeards() {
        return heards;
    }


    /**
     * @return the list of Students who has liked the song
     */
    public StudentList getLikes() {
        return likes;
    }


    /**
     * @return a string of the song's title, year,
     *         artist, and genre
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(title + "(" + year + ") by " + artist + ", Genre: "
            + genre);
        builder.append("\nStudents who have heard the song: " + heards
            .toString());
        builder.append("Students who like the song: " + likes.toString());
        return builder.toString();
    }

}
