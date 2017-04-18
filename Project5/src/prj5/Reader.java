package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Reader reads in two files one of which contains information about the songs
 * and the other containing information about the students. It then creates a
 * SongList with the song information and a StudentList with the student
 * information. Using these lists it then creates a new Window
 * 
 * @author mliou
 * @version 2017.04.16
 *
 */
public class Reader {
    // ~ Fields---------------------
    private SongList songs;
    /*
     * private int[] hobbies;
     * private int[] regions;
     * private int[] majors;
     */


    // ~ Constructor------------------
    /**
     * Creates a new Reader object
     * 
     * @param songFile
     *            The name of the file containing the song information
     * @param studentFile
     *            The name of the file containing the student information
     */
    public Reader(String studentFile, String songFile) {
        /*
         * hobbies = new int[4];
         * regions = new int[4];
         * majors = new int[4];
         * for (int i = 0; i < 4; i++) {
         * hobbies[i] = 0;
         * regions[i] = 0;
         * majors[i] = 0;
         * }
         */
        SongList songList = readSongs(songFile);
        StudentList studentList = readStudents(studentFile);
        new GUIwindow(songList, studentList, this);
    }


    // ~ Methods------------------------
    /**
     * Reads in the song information from the song file. Using the information
     * it creates a new Song Object for each song and then adds it to a
     * SongList. After it reads through the whole file, it returns the SongList
     * 
     * @param fileName
     *            The name of the file containing the song information
     * @return The SongList containing all of the songs read in from the file
     */
    public SongList readSongs(String fileName) {
        songs = new SongList();
        Scanner file = null;
        try {
            file = new Scanner(new File(fileName));
            file.nextLine();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        while (file.hasNextLine()) {
            String songInfo = file.nextLine();
            String[] info = songInfo.split(",");
            Song song = new Song(info[0], info[1], Integer.valueOf(info[2]),
                info[3]);
            songs.add(song);
        }

        return songs;

    }


    /**
     * Reads in the student information from the student file. Using the
     * information it creates a new Student Object for each student and then
     * adds it to a StudentList. It then takes in the student's heards and likes
     * for each song and adds the student to the songs that they have heard and
     * the songs that they like. If a student said that they had not heard a
     * song but they liked it, they are not added to either of that song's
     * heards or likes
     * 
     * @param fileName
     *            The name of the file containing the student information
     * @return The StudentList containing all of the students read in from the
     *         file
     */
    public StudentList readStudents(String fileName) {
        StudentList students = new StudentList();
        Scanner file = null;
        try {
            file = new Scanner(new File(fileName));
            file.nextLine();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

        while (file.hasNextLine()) {
            String studentInfo = file.nextLine();
            String[] info = studentInfo.split(",");

            if (info.length > 5) {
                Student student = new Student(info[2], info[3], info[4]);
                students.add(student);
                Iterator<Song> iter = songs.iterator();
                for (int i = 5; i < info.length; i++) {
                    Song currSong = iter.next();
                    if (info[i].equals("Yes")) {
                        currSong.addToHeards(student);
                        currSong.updateHeardTotals(student);
                    }
                    else if (info[i].equals("No")) {
                        currSong.updateHeardTotals(student);
                    }
                    i++;

                    if (i < info.length && info[i].equals("Yes")) {
                        // && info[i-1].equals("Yes")){

                        currSong.addToLikes(student);
                        currSong.updateLikeTotals(student);
                    }
                    else if (i < info.length && info[i].equals("No")) {
                        currSong.updateLikeTotals(student);
                    }
                }

            }
        }

        return students;
    }

    /**
     * keeps a total of how many students have
     * each type of attribute in order to
     * calculate the percentages later
     * 
     * @param s
     *            Student to be analyzed
     */
    /*
     * private void countAttributes(Student s)
     * {
     * // for hobbies
     * if (s.getHobby().equals("reading"))
     * {
     * hobbies[0]++;
     * }
     * else if (s.getHobby().equals("art"))
     * {
     * hobbies[1]++;
     * }
     * else if (s.getHobby().equals("sports"))
     * {
     * hobbies[2]++;
     * }
     * else if (s.getHobby().equals("music"))
     * {
     * hobbies[3]++;
     * }
     * 
     * // for major
     * if (s.getMajor().equals("Computer Science"))
     * {
     * majors[0]++;
     * }
     * else if (s.getMajor().equals("Other Engineering"))
     * {
     * majors[1]++;
     * }
     * else if (s.getMajor().equals("Math or CMDA"))
     * {
     * majors[2]++;
     * }
     * else if (s.getMajor().equals("Other"))
     * {
     * majors[3]++;
     * }
     * 
     * // for state
     * if (s.getRegion().equals("Northeast"))
     * {
     * regions[0]++;
     * }
     * else if (s.getRegion().equals("Southeast"))
     * {
     * regions[1]++;
     * }
     * else if (s.getRegion().contains("other"))
     * {
     * regions[2]++;
     * }
     * else if (s.getRegion().contains("Outside"))
     * {
     * regions[3]++;
     * }
     * }
     */
    /**
     * @return the total number of students
     *         that have each specific hobby
     */
    // public int[] getTotalHobbies() {
    // return hobbies;
    // }

    /**
     * @return the total number of students
     *         that have each specific major
     */
    // public int[] getTotalMajors() {
    // return majors;
    // }

    /**
     * @return the total number of students
     *         that have each specific region
     */
    // public int[] getTotalRegions() {
    // return regions;
    // }
}
