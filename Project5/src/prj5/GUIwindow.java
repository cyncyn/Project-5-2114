package prj5;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * This is the front end with the window,
 * buttons, and bring together the back end
 * 
 * @author lchar16
 * @version 2017.04.16
 *
 */
public class GUIwindow {

    // ~ Fields----------------------
    private Window window;
    private Button artistButton;
    private Button titleButton;
    private Button yearButton;
    private Button genreButton;
    private Button hobbyButton;
    private Button majorButton;
    private Button regionButton;
    private Button next;
    private Button previous;
    private Button quit;
    private TextShape[] titles;
    private Shape[] heards;
    private Shape[] likes;
    private Shape[] divs;

    private SongList songs;
    private StudentList students;
    private Reader reader;
    private String lastCalled;
    private boolean isClear;
    private int page;


    // ~ Constructor---------------------
    /**
     * new GUIwindow object that has buttons
     * set up and also window
     */
    public GUIwindow(SongList songList, StudentList studentList, Reader r) {
        window = new Window("Project 5");

        songs = songList;
        students = studentList;
        reader = r;

        setUpButtons();

        lastCalled = null;
        isClear = true;
        page = 0;
    }


    /**
     * instantiates and adds all the buttons
     */
    private void setUpButtons() {
        previous = new Button("Previous");
        window.addButton(previous, WindowSide.NORTH);
        previous.onClick(this, "clickedPrevious");

        artistButton = new Button("Sort by Artist Name");
        window.addButton(artistButton, WindowSide.NORTH);
        artistButton.onClick(this, "clickedArtist");

        titleButton = new Button("Sort by Title");
        window.addButton(titleButton, WindowSide.NORTH);
        titleButton.onClick(this, "clickedTitle");

        yearButton = new Button("Sort by Release Year");
        window.addButton(yearButton, WindowSide.NORTH);
        yearButton.onClick(this, "clickedYear");

        genreButton = new Button("Sort by Genre");
        window.addButton(genreButton, WindowSide.NORTH);
        genreButton.onClick(this, "clickedGenre");

        next = new Button("Next");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "clickedNext");

        hobbyButton = new Button("Represent Hobby");
        window.addButton(hobbyButton, WindowSide.SOUTH);
        hobbyButton.onClick(this, "clickedHobby");

        majorButton = new Button("Represent Major");
        window.addButton(majorButton, WindowSide.SOUTH);
        majorButton.onClick(this, "clickedMajor");

        regionButton = new Button("Represent Region");
        window.addButton(regionButton, WindowSide.SOUTH);
        regionButton.onClick(this, "clickedRegion");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");
    }


    /**
     * this method sets up the window with the legend,
     * and 9 glyphs with the song titles, like, and heard bars
     */
    private void setUpWindow() {
        int startX = 125;
        int startY = 10;
        int xinc = 250;
        int yinc = 180;
        titles = new TextShape[9];
        for (int i = 0; i < titles.length; i = i + 3) {
            for (int j = 0; j < 3; j++) {
                titles[i + j] = new TextShape(startX + (j * xinc), startY + ((i
                    / 3) * yinc), "title" + (i + j));
            }
        }
        for (int i = 0; i < titles.length; i++) {
            window.addShape(titles[i]);
            centerTitle(titles[i]);
        }

        int divStartX = 120;
        int divStartY = 50;
        int divHeight = 10;
        int divWidth = 40;

        divs = new Shape[9];
        for (int i = 0; i < divs.length; i = i + 3) {
            for (int j = 0; j < 3; j++) {
                divs[i + j] = new Shape(divStartX + (j * xinc), divStartY + ((i
                    / 3) * yinc), divHeight, divWidth, Color.BLACK);
            }
        }
        for (int i = 0; i < divs.length; i++) {
            window.addShape(divs[i]);
        }

        int barHeight = 10;
        int barWidth = 100;
        heards = new Shape[36];
        for (int i = 0; i < heards.length; i = i + 12) {
            for (int j = 0; j < 3; j++) {
                heards[i + (4 * j)] = new Shape(divStartX - barWidth + (j
                    * xinc), divStartY + ((i / 12) * yinc), barWidth, barHeight,
                    Color.MAGENTA);
                heards[(i + (4 * j)) + 1] = new Shape(divStartX - barWidth + (j
                    * xinc), divStartY + barHeight + ((i / 12) * yinc),
                    barWidth, barHeight, Color.BLUE);
                heards[(i + (4 * j)) + 2] = new Shape(divStartX - barWidth + (j
                    * xinc), divStartY + (2 * barHeight) + ((i / 12) * yinc),
                    barWidth, barHeight, Color.YELLOW);
                heards[(i + (4 * j)) + 3] = new Shape(divStartX - barWidth + (j
                    * xinc), divStartY + (3 * barHeight) + ((i / 12) * yinc),
                    barWidth, barHeight, Color.GREEN);
            }
        }
        for (int i = 0; i < heards.length; i++) {
            window.addShape(heards[i]);
        }

        likes = new Shape[36];
        for (int i = 0; i < heards.length; i = i + 12) {
            for (int j = 0; j < 3; j++) {
                likes[i + (4 * j)] = new Shape(divStartX + divHeight + (j
                    * xinc), divStartY + ((i / 12) * yinc), barWidth, barHeight,
                    Color.MAGENTA);
                likes[(i + (4 * j)) + 1] = new Shape(divStartX + divHeight + (j
                    * xinc), divStartY + barHeight + ((i / 12) * yinc),
                    barWidth, barHeight, Color.BLUE);
                likes[(i + (4 * j)) + 2] = new Shape(divStartX + divHeight + (j
                    * xinc), divStartY + (2 * barHeight) + ((i / 12) * yinc),
                    barWidth, barHeight, Color.YELLOW);
                likes[(i + (4 * j)) + 3] = new Shape(divStartX + divHeight + (j
                    * xinc), divStartY + (3 * barHeight) + ((i / 12) * yinc),
                    barWidth, barHeight, Color.GREEN);
            }
        }
        for (int i = 0; i < heards.length; i++) {
            window.addShape(likes[i]);
        }

        // Legend
        int legendStartX = 775;
        int legendStartY = 200;
        int legendWidth = 150;
        int legendHeight = 250;
        TextShape legendTitle = new TextShape(legendStartX, legendStartY,
            "Legend Title");
        legendTitle.setBackgroundColor(Color.WHITE);
        legendTitle.move(legendWidth / 2 - legendTitle.getWidth() / 2, 5);
        window.addShape(legendTitle);

        Shape legendDivider = new Shape(legendStartX + legendWidth / 2
            - divHeight / 2, 400, divHeight, divWidth, Color.BLACK);
        window.addShape(legendDivider);

        TextShape legendSongTitle = new TextShape(legendStartX + legendWidth
            / 2, legendStartY + 180, "Song Title");
        legendSongTitle.move(-legendSongTitle.getWidth() / 2, 0);
        legendSongTitle.setBackgroundColor(Color.WHITE);
        window.addShape(legendSongTitle);

        TextShape legendHeards = new TextShape(legendStartX + legendWidth / 2
            - divHeight / 2, 400 + divHeight / 2, "Heards");
        legendHeards.move(-legendHeards.getWidth() - 5, 0);
        legendHeards.setBackgroundColor(Color.WHITE);
        window.addShape(legendHeards);

        TextShape legendLikes = new TextShape(legendStartX + legendWidth / 2
            - divHeight / 2, 400 + divHeight / 2, "Likes");
        legendLikes.move(divHeight, 0);
        legendLikes.setBackgroundColor(Color.WHITE);
        window.addShape(legendLikes);

        TextShape legendAttribute1 = new TextShape(legendStartX + legendWidth
            / 2, legendStartY + 50, "Attribute 1", Color.MAGENTA);
        legendAttribute1.move(-legendAttribute1.getWidth() / 2, 0);
        legendAttribute1.setBackgroundColor(Color.WHITE);
        window.addShape(legendAttribute1);

        TextShape legendAttribute2 = new TextShape(legendStartX + legendWidth
            / 2, legendStartY + 75, "Attribute 2", Color.BLUE);
        legendAttribute2.move(-legendAttribute2.getWidth() / 2, 0);
        legendAttribute2.setBackgroundColor(Color.WHITE);
        window.addShape(legendAttribute2);

        TextShape legendAttribute3 = new TextShape(legendStartX + legendWidth
            / 2, legendStartY + 100, "Attribute 3", Color.YELLOW);
        legendAttribute3.move(-legendAttribute3.getWidth() / 2, 0);
        legendAttribute3.setBackgroundColor(Color.WHITE);
        window.addShape(legendAttribute3);

        TextShape legendAttribute4 = new TextShape(legendStartX + legendWidth
            / 2, legendStartY + 125, "Attribute 4", Color.GREEN);
        legendAttribute4.move(-legendAttribute4.getWidth() / 2, 0);
        legendAttribute4.setBackgroundColor(Color.WHITE);
        window.addShape(legendAttribute4);

        Shape legendOutline = new Shape(legendStartX, legendStartY, legendWidth,
            legendHeight, Color.BLACK);
        legendOutline.setBackgroundColor(Color.WHITE);
        window.addShape(legendOutline);

    }


    /**
     * centers the title
     */
    private void centerTitle(TextShape title) {
        int len = title.getText().length();
        int starting = title.getX();
        int newStart = starting - ((len / 2) * 5);
        title.setX(newStart);

    }


    /**
     * Sorts the songs by alphabetical order according to their titles
     * 
     * @param titleButton
     *            The button that sorts the songs by title
     */
    public void clickedTitle(Button titleButton) {
        window.removeAllShapes();
        setUpWindow();
        songs.sortSongs(SortTypeEnum.title);
        displayNewSortedSongs();

        switch (lastCalled) {
            case "hobby":
                clickedHobby(hobbyButton);
                break;
            case "region":
                break;
            case "major":
                clickedMajor(majorButton);
                break;
            default:
                break;

        }
    }


    /**
     * Sorts the songs by alphabetical order according to their titles
     * 
     * @param titleButton
     *            The button that sorts the songs by title
     */
    public void clickedGenre(Button genreButton) {
        window.removeAllShapes();
        setUpWindow();
        songs.sortSongs(SortTypeEnum.genre);
        displayNewSortedSongs();

        switch (lastCalled) {
            case "hobby":
                clickedHobby(hobbyButton);
                break;
            case "region":
                break;
            case "major":
                clickedMajor(majorButton);
                break;
            default:
                break;
        }
    }


    /**
     * Sorts songs according to their year of release
     * 
     * @param yearButton
     *            the button that sorts songs by year
     */
    public void clickedYear(Button yearButton) {
        window.removeAllShapes();
        setUpWindow();
        songs.sortSongs(SortTypeEnum.year);
        displayNewSortedSongs();

        switch (lastCalled) {
            case "hobby":
                clickedHobby(hobbyButton);
                break;
            case "region":
                break;
            case "major":
                clickedMajor(majorButton);
                break;
            default:
                break;
        }
    }


    /**
     * sorts songs alphabetically according to artist name
     * 
     * @param artistButton
     *            the button that sorts songs by artist
     */
    public void clickedArtist(Button artistButton) {
        window.removeAllShapes();
        setUpWindow();
        songs.sortSongs(SortTypeEnum.artist);
        displayNewSortedSongs();

        switch (lastCalled) {
            case "hobby":
                clickedHobby(hobbyButton);
                break;
            case "region":

                break;
            case "major":
                clickedMajor(majorButton);
                break;
            default:
                break;
        }
    }


    /**
     * displays the songs in order after they have been sorted
     */
    private void displayNewSortedSongs() {
        // int i = page * 9;
        int i = 0;
        Iterator<Song> it = songs.iterator();
        while (i < 9) // i+9 // it.hasNext())
        {
            Song currentSong = it.next();
            /*
             * for (int j = 0; j < i; j++) {
             * currentSong = it.next();
             * }
             */
            titles[i].setText(currentSong.getTitle());
            centerTitle(titles[i]);
            i++;
        }
    }


    /**
     * displays the heard bars
     * 
     * @param pos
     *            starting position
     * @param first
     * @param second
     * @param third
     * @param fourth
     */
    private void displayHeardBars(
        int pos,
        int first,
        int second,
        int third,
        int fourth) {

        int barHeight = 10;
        int startX = divs[pos / 4].getX() - 100;
        int newStartFirst = startX + (100 - first);
        int startY1 = heards[pos].getY();
        int newStartSecond = startX + (100 - second);
        int startY2 = heards[pos + 1].getY();
        int newStartThird = startX + (100 - third);
        int startY3 = heards[pos + 2].getY();
        int newStartFourth = startX + (100 - fourth);
        int startY4 = heards[pos + 3].getY();
        heards[pos].remove();
        heards[pos] = new Shape(newStartFirst, startY1, first, barHeight,
            Color.MAGENTA);
        heards[pos + 1].remove();
        heards[pos + 1] = new Shape(newStartSecond, startY2, second, barHeight,
            Color.BLUE);
        heards[pos + 2].remove();
        heards[pos + 2] = new Shape(newStartThird, startY3, third, barHeight,
            Color.YELLOW);
        heards[pos + 3].remove();
        heards[pos + 3] = new Shape(newStartFourth, startY4, fourth, barHeight,
            Color.GREEN);
        for (int i = 0; i < 4; i++) {
            window.addShape(heards[pos + i]);
        }
    }


    /**
     * displays the liked bars
     * 
     * @param pos
     *            starting position
     * @param first
     * @param second
     * @param third
     * @param fourth
     */
    private void displayLikedBars(
        int pos,
        int first,
        int second,
        int third,
        int fourth) {

        int barHeight = 10;
        int startX = likes[pos].getX();
        int startY1 = likes[pos].getY();
        int startY2 = likes[pos + 1].getY();
        int startY3 = likes[pos + 2].getY();
        int startY4 = likes[pos + 3].getY();
        likes[pos].remove();
        likes[pos] = new Shape(startX, startY1, first, barHeight,
            Color.MAGENTA);
        likes[pos + 1].remove();
        likes[pos + 1] = new Shape(startX, startY2, second, barHeight,
            Color.BLUE);
        likes[pos + 2].remove();
        likes[pos + 2] = new Shape(startX, startY3, third, barHeight,
            Color.YELLOW);
        likes[pos + 3].remove();
        likes[pos + 3] = new Shape(startX, startY4, fourth, barHeight,
            Color.GREEN);
        for (int i = 0; i < 4; i++) {
            window.addShape(likes[pos + i]);
        }
    }


    /**
     * 
     * @param hobbyButton
     *            the button that indicates the user
     *            wants to represent the likes and heards by hobby
     */
    public void clickedHobby(Button hobbyButton) {
        /*
         * if (isClear) {
         * clickedTitle(titleButton);
         * isClear = false;
         * }
         */

        Iterator<Song> it = songs.iterator();
        int i = 0;
        while (it.hasNext()) {
            Song currentSong = it.next();
            HashMap<String, int[]> resultHobby = Solver.solve(currentSong,
                "hobby");
            // Reading
            int[] reading = resultHobby.get("reading");
            double percentHeardReading = 0;
            double percentLikedReading = 0;
            int totalReadingHeards = currentSong.getHobbiesHeards()[0];
            int totalReadingLikes = currentSong.getHobbiesLikes()[0];
            if (reading != null && totalReadingHeards > 0) {
                percentHeardReading = ((double)reading[0]
                    / (double)totalReadingHeards) * 100;
                Math.round(percentHeardReading);
            }
            if (reading != null && totalReadingLikes > 0) {
                percentLikedReading = ((double)reading[1]
                    / (double)totalReadingLikes) * 100;
                Math.round(percentLikedReading);
            }
            // Art
            int[] art = resultHobby.get("art");
            double percentHeardArt = 0;
            double percentLikedArt = 0;
            int totalArtHeards = currentSong.getHobbiesHeards()[1];
            int totalArtLikes = currentSong.getHobbiesLikes()[1];
            if (art != null && totalArtHeards > 0) {
                percentHeardArt = ((double)art[0] / (double)totalArtHeards)
                    * 100;
                Math.round(percentHeardArt);
            }
            if (art != null && totalArtLikes > 0) {
                percentLikedArt = ((double)art[1] / (double)totalArtLikes)
                    * 100;
                Math.round(percentLikedArt);
            }
            // Sports
            int[] sports = resultHobby.get("sports");
            double percentHeardSports = 0;
            double percentLikedSports = 0;
            int totalSportsHeards = currentSong.getHobbiesHeards()[2];
            int totalSportsLikes = currentSong.getHobbiesLikes()[2];
            if (sports != null && totalSportsHeards > 0) {
                percentHeardSports = ((double)sports[0]
                    / (double)totalSportsHeards) * 100;
                Math.round(percentHeardSports);
            }
            if (sports != null && totalSportsLikes > 0) {
                percentLikedSports = ((double)sports[1]
                    / (double)totalSportsLikes) * 100;
                Math.round(percentLikedSports);
            }
            // Music
            int[] music = resultHobby.get("music");
            double percentHeardMusic = 0;
            double percentLikedMusic = 0;
            int totalMusicHeards = currentSong.getHobbiesHeards()[3];
            int totalMusicLikes = currentSong.getHobbiesLikes()[3];
            if (music != null && totalMusicHeards > 0) {
                percentHeardMusic = ((double)music[0]
                    / (double)totalMusicHeards) * 100;
            }
            if (music != null && totalMusicLikes > 0) {
                percentLikedMusic = ((double)music[1] / (double)totalMusicLikes)
                    * 100;
            }

            displayHeardBars(i, (int)percentHeardReading, (int)percentHeardArt,
                (int)percentHeardSports, (int)percentHeardMusic);
            displayLikedBars(i, (int)percentLikedReading, (int)percentLikedArt,
                (int)percentLikedSports, (int)percentLikedMusic);
            i = i + 4;

            lastCalled = "hobby";

            System.out.println(currentSong.toString());
            System.out.println("Heard");
            System.out.println("reading:" + (int)percentHeardReading + " art:"
                + (int)percentHeardArt + " sports:" + (int)percentHeardSports
                + " music:" + (int)percentHeardMusic);
            System.out.println("Likes");
            System.out.println("reading:" + (int)percentLikedReading + " art:"
                + (int)percentLikedArt + " sports:" + (int)percentLikedSports
                + " music:" + (int)percentLikedMusic);
            System.out.println("");

        }
    }


    /**
     * 
     * @param majorButton
     *            the button that indicates the user
     *            wants to represent the likes and heards by major
     */
    public void clickedMajor(Button majorButton) {
        /*
         * if (isClear) {
         * clickedTitle(titleButton);
         * isClear = false;
         * }
         */

        Iterator<Song> it = songs.iterator();
        int i = 0;
        while (it.hasNext()) {
            Song currentSong = it.next();
            HashMap<String, int[]> resultMajor = Solver.solve(currentSong,
                "major");
            // CS
            int[] CS = resultMajor.get("Computer Science");
            double percentHeardCS = 0;
            double percentLikedCS = 0;
            int totalCSHeards = currentSong.getMajorsHeards()[0];
            int totalCSLikes = currentSong.getMajorsLikes()[0];
            if (CS != null && totalCSHeards > 0) {
                percentHeardCS = ((double)CS[0] / (double)totalCSHeards) * 100;
                Math.round(percentHeardCS);
            }
            if (CS != null && totalCSLikes > 0) {
                percentLikedCS = ((double)CS[1] / (double)totalCSLikes) * 100;
                Math.round(percentLikedCS);
            }
            // other enginering
            int[] enge = resultMajor.get("Other Engineering");
            double percentHeardEnge = 0;
            double percentLikedEnge = 0;
            int totalEngeHeards = currentSong.getMajorsHeards()[1];
            int totalEngeLikes = currentSong.getMajorsLikes()[1];
            if (enge != null && totalEngeHeards > 0) {
                percentHeardEnge = ((double)enge[0] / (double)totalEngeHeards)
                    * 100;
                Math.round(percentHeardEnge);
            }
            if (enge != null && totalEngeLikes > 0) {
                percentLikedEnge = ((double)enge[1] / (double)totalEngeLikes)
                    * 100;
                Math.round(percentLikedEnge);
            }
            // math
            int[] math = resultMajor.get("Math or CMDA");
            double percentHeardMath = 0;
            double percentLikedMath = 0;
            int totalMathHeards = currentSong.getMajorsHeards()[2];
            int totalMathLikes = currentSong.getMajorsLikes()[2];
            if (math != null && totalMathHeards > 0) {
                percentHeardMath = ((double)math[0] / (double)totalMathHeards)
                    * 100;
                Math.round(percentHeardMath);
            }
            if (math != null && totalMathLikes > 0) {
                percentLikedMath = ((double)math[1] / (double)totalMathLikes)
                    * 100;
                Math.round(percentLikedMath);
            }
            // other
            int[] other = resultMajor.get("Other");
            double percentHeardOther = 0;
            double percentLikedOther = 0;
            int totalOtherHeards = currentSong.getMajorsHeards()[3];
            int totalOtherLikes = currentSong.getMajorsLikes()[3];
            if (other != null && totalOtherHeards > 0) {
                percentHeardOther = ((double)other[0]
                    / (double)totalOtherHeards) * 100;
            }
            if (other != null && totalOtherLikes > 0) {
                percentLikedOther = ((double)other[1] / (double)totalOtherLikes)
                    * 100;
            }

            displayHeardBars(i, (int)percentHeardCS, (int)percentHeardEnge,
                (int)percentHeardMath, (int)percentHeardOther);
            displayLikedBars(i, (int)percentLikedCS, (int)percentLikedEnge,
                (int)percentLikedMath, (int)percentLikedOther);
            i = i + 4;

            lastCalled = "major";

            System.out.println(currentSong.toString());
            System.out.println("Heard");
            System.out.println("CS:" + (int)percentHeardCS + " Enge:"
                + (int)percentHeardEnge + " math:" + (int)percentHeardMath
                + " other:" + (int)percentHeardOther);
            System.out.println("Likes");
            System.out.println("CS:" + (int)percentLikedCS + " Enge:"
                + (int)percentLikedEnge + " math:" + (int)percentLikedMath
                + " other:" + (int)percentLikedOther);
            System.out.println("");

        }
    }


    /**
     * 
     * @param next
     *            the button that displays the next set of 9 songs
     */
    public void clickedNext(Button next) {
        int numPages = songs.getSize() / 9;
        if (songs.getSize() % 9 == 0) {
            numPages += 1;
        }

        if (page < numPages) {
            page++;
            displayNewSortedSongs();
        }

        if (page == numPages - 1) {
            next.disable();
        }

    }


    /**
     * 
     * @param previous
     *            the button that displays the previous set of 9 songs
     */
    public void clickedPrevious(Button previous) {
        int numPages = songs.getSize() / 9;
        if (songs.getSize() % 9 == 0) {
            numPages += 1;
        }

        if (page > 0) {
            page--;
            displayNewSortedSongs();
        }

        if (page == 0) {
            previous.disable();
        }

    }


    /**
     * 
     * @param quit
     *            the button that exits the program
     */
    public void clickedQuit(Button quit) {
        System.exit(0);
    }
}
