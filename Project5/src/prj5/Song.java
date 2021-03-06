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
    private int[] hobbiesHeards;
    private int[] regionsHeards;
    private int[] majorsHeards;
    private int[] hobbiesLikes;
    private int[] regionsLikes;
    private int[] majorsLikes;


    // ~ Constructor------------------
    /**
     * Creates a new Song object
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

        hobbiesHeards = new int[4];
        regionsHeards = new int[4];
        majorsHeards = new int[4];
        for (int i = 0; i < 4; i++) {
            hobbiesHeards[i] = 0;
            regionsHeards[i] = 0;
            majorsHeards[i] = 0;
        }

        hobbiesLikes = new int[4];
        regionsLikes = new int[4];
        majorsLikes = new int[4];
        for (int i = 0; i < 4; i++) {
            hobbiesLikes[i] = 0;
            regionsLikes[i] = 0;
            majorsLikes[i] = 0;
        }
    }


    // ~ Methods-----------------------
    /**
     * Gets the title of song
     * 
     * @return the title of the Song
     */
    public String getTitle() {
        return title;
    }


    /**
     * Gets the artist of the song
     * 
     * @return the artist of the song
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Gets the year of the song's release
     * 
     * @return the year the song was released
     */
    public int getYear() {
        return year;
    }


    /**
     * Gets the genre of the song
     * 
     * @return the genre of the song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * adds a student who has heard this song
     * to the list of students who have heard this song
     * 
     * @param s
     *            The student to be added
     */
    public void addToHeards(Student s) {
        heards.add(s);
    }


    /**
     * adds a student who likes this song to
     * the list students who like this song
     * 
     * @param s
     *            The student to be added
     */
    public void addToLikes(Student s) {
        likes.add(s);
    }


    /**
     * Gets the list of students who have heard the song
     * 
     * @return the list of Students who has heard
     *         the song
     */
    public StudentList getHeards() {
        return heards;
    }


    /**
     * Gets the list of students who have liked the song
     * 
     * @return the list of Students who has liked the song
     */
    public StudentList getLikes() {
        return likes;
    }


    /**
     * Returns a string in the format
     * Song Title: Title
     * Song Artist: Artist
     * Song Genre: Genre
     * Song Year: Year
     * 
     * @return a string of the song's title, year,
     *         artist, and genre
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Song Title: " + title);
        builder.append("\nSong Artist: " + artist);
        builder.append("\nSong Genre: " + genre);
        builder.append("\nSong Year: " + year);
        return builder.toString();
    }


    /**
     * keeps a total of how many students have each type of attribute and have
     * heard this song in order to calculate the percentages later
     * 
     * @param s
     *            The student being analyzed
     */
    public void updateHeardTotals(Student s) {
        // for hobbies
        if (s.getHobby().equals("reading")) {
            hobbiesHeards[0]++;
        }
        else if (s.getHobby().equals("art")) {
            hobbiesHeards[1]++;
        }
        else if (s.getHobby().equals("sports")) {
            hobbiesHeards[2]++;
        }
        else if (s.getHobby().equals("music")) {
            hobbiesHeards[3]++;
        }

        // for major
        if (s.getMajor().equals("Computer Science")) {
            majorsHeards[0]++;
        }
        else if (s.getMajor().equals("Other Engineering")) {
            majorsHeards[1]++;
        }
        else if (s.getMajor().equals("Math or CMDA")) {
            majorsHeards[2]++;
        }
        else if (s.getMajor().equals("Other")) {
            majorsHeards[3]++;
        }

        // for region
        if (s.getRegion().equals("Northeast")) {
            regionsHeards[0]++;
        }
        else if (s.getRegion().equals("Southeast")) {
            regionsHeards[1]++;
        }
        else if (s.getRegion().contains("other")) {
            regionsHeards[2]++;
        }
        else if (s.getRegion().contains("Outside")) {
            regionsHeards[3]++;
        }
    }


    /**
     * keeps a total of how many students have each type of attribute and like
     * this song in order to calculate the percentages later
     * 
     * @param s
     *            The student being analyzed
     */
    public void updateLikeTotals(Student s) {
        // for hobbies
        if (s.getHobby().equals("reading")) {
            hobbiesLikes[0]++;
        }
        else if (s.getHobby().equals("art")) {
            hobbiesLikes[1]++;
        }
        else if (s.getHobby().equals("sports")) {
            hobbiesLikes[2]++;
        }
        else if (s.getHobby().equals("music")) {
            hobbiesLikes[3]++;
        }

        // for major
        if (s.getMajor().equals("Computer Science")) {
            majorsLikes[0]++;
        }
        else if (s.getMajor().equals("Other Engineering")) {
            majorsLikes[1]++;
        }
        else if (s.getMajor().equals("Math or CMDA")) {
            majorsLikes[2]++;
        }
        else if (s.getMajor().equals("Other")) {
            majorsLikes[3]++;
        }

        // for region
        if (s.getRegion().equals("Northeast")) {
            regionsLikes[0]++;
        }
        else if (s.getRegion().equals("Southeast")) {
            regionsLikes[1]++;
        }
        else if (s.getRegion().contains("other")) {
            regionsLikes[2]++;
        }
        else if (s.getRegion().contains("Outside")) {
            regionsLikes[3]++;
        }
    }


    /**
     * Gets the array containing the total number of students who have heard the
     * song for each hobby
     * 
     * @return the total number of students that have each specific hobby and
     *         have heard this song
     */
    public int[] getHobbiesHeards() {
        return hobbiesHeards;
    }


    /**
     * Gets the array containing the total number of students who have heard the
     * song for each major
     * 
     * @return the total number of students that have each specific major and
     *         have heard this song
     */
    public int[] getMajorsHeards() {
        return majorsHeards;
    }


    /**
     * Gets the array containing the total number of students who have heard the
     * song for each region
     * 
     * @return the total number of students that have each specific region and
     *         have heard this song
     */
    public int[] getRegionsHeards() {
        return regionsHeards;
    }


    /**
     * Gets the array containing the total number of students who have liked the
     * song for each hobby
     * 
     * @return the total number of students that have each specific hobby and
     *         like this song
     */
    public int[] getHobbiesLikes() {
        return hobbiesLikes;
    }


    /**
     * Gets the array containing the total number of students who have liked the
     * song for each major
     * 
     * @return the total number of students that have each specific major and
     *         like this song
     */
    public int[] getMajorsLikes() {
        return majorsLikes;
    }


    /**
     * Gets the array containing the total number of students who have liked the
     * song for each region
     * 
     * @return the total number of students that have each specific region and
     *         like this song
     */
    public int[] getRegionsLikes() {
        return regionsLikes;
    }

}
