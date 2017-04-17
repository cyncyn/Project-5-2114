package prj5;

import java.awt.Color;
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
// private int windowHeight;
// private int windowWidth;
// private int cellHeight;
// private int cellWidth;
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


    // ~ Constructor---------------------
    public GUIwindow() {
        window = new Window("Project 5");

        setUpButtons();

        setUpWindow();
    }


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


    private void setUpWindow() {
        int startX = 100;
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
        }

        int divStartX = 120;
        int divStartY = 50;
        int divHeight = 10;
        int divWidth = 40;

        Shape[] divs = new Shape[9];
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
        int barWidth = 40;
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
        int legendStartX = 700;
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
}
