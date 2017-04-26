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
    private StudentList students;


    // ~ Constructor------------------
    /**
     * Creates a new Reader object
     * 
     * @param songFile
     *            The name of the file containing the song information
     * @param studentFile
     *            The name of the file containing the student information
     */
    public Reader(String songFile, String studentFile) {
        SongList songList = readSongs(songFile);
        StudentList studentList = readStudents(studentFile);
        new GUIwindow();
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
        students = new StudentList();
        Scanner file = null;
        try {
            file = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

        while (file.hasNextLine()) {
            String studentInfo = file.nextLine();
            String[] info = studentInfo.split(",");
            Student student = new Student(info[2], info[3], info[4]);
            students.add(student);
            Iterator<Song> iter = songs.iterator();
            for (int i = 5; i < info.length; i++) {
                Song currSong = iter.next();
                if (info[i].equals("Yes")) {
                    currSong.addToHeards(student);
                }
                i++;

                if (info[i].equals("Yes") && info[i - 1].equals("Yes")) {
                    currSong.addToLikes(student);
                }

            }
        }

        return students;
    }
}
