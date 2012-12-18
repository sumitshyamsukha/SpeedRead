import acm.graphics.*;
import acm.program.*;
import java.io.*;
import java.util.*;

public class SpeedRead extends GraphicsProgram {
    private static Scanner sc;
    public void openFile()
    {
        try
        {
            sc = new Scanner(new File("file.txt"));
        } catch(Exception e)
        {
            GLabel label = new GLabel("NOTHING");
            label.setFont("Serif-72");
            add(label, 10, (getHeight() + label.getAscent()) / 2);
        }
    }

    public void closeFile()
    {
        sc.close();
    }
    public void init() {
        openFile();
    }
    public void run() {
        GLabel label = new GLabel("");
        add(label, 10, (getHeight() + label.getAscent()) / 2);
        while (sc.hasNext()) {
            label.setFont("Serif-72");
            label.setLabel(sc.next());
            pause(PAUSE_TIME);
        }
        pause(500);
        closeFile();
    }
    
    /* The number of milliseconds to pause on each cycle */
    private static int PAUSE_TIME = 150; // 600WpM (60*1000/WpM)

    public static final int APPLICATION_WIDTH = 700;
    public static final int APPLICATION_HEIGHT = 700;

    public static void main(String[] args) {
        new SpeedRead().start(args);
    }
}