import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GameXonix {
    //fields
    static final int LEFT = 37; // key code
    static final int UP = 38;
    static final int RIGHT = 39;
    static final int DOWN = 40;

    static final int SHOW_DELAY = 60; //delay for animation

    static final int COLOR_TEMP = 1; //for temporary filling
    static final int COLOR_WATER = 0;
    static final int COLOR_LAND = 0x3D067F;
    static final int COLOR_TRACK = 0x901290;

    final int PERCENT_OF_WATER_CAPTURE = 80;
    final String FORMAT_STRING = "Score: %d %20s %d %20s %2.0f%%";

    static Random random = new Random();

    static JLabel board = new JLabel();
    final Font font = new Font("TimesNewRoman", Font.ITALIC, 21);
    static Canvas canvas = new Canvas();

    static Delay delay = new Delay();
    static Field field = new Field();
    static Xonix xonix = new Xonix();
    static Balls balls = new Balls();
    static Cube cube = new Cube();
    static GameOver gameover = new GameOver();
    static Level levelD = new Level();

    static int level;

    //constructor
    GameXonix(){
        board.setFont(font);
        board.setOpaque(true);
        board.setBackground(new Color(0x9CC3FC));
        board.setForeground(Color.black);
        board.setHorizontalAlignment(JLabel.CENTER);

        Window.startFrame.add(BorderLayout.CENTER, canvas);
        Window.startFrame.add(BorderLayout.SOUTH, board);

        Window.startFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() >= GameXonix.LEFT && e.getKeyCode() <= GameXonix.DOWN)
                    GameXonix.xonix.setDirection(e.getKeyCode());
            }
        });

        Window.startFrame.setVisible(true);

        level = 1;
    }

    //methods
    void run(){ // main loop of game
        delay.wait(SHOW_DELAY * 30);

        while (!gameover.isGameOver()) {
            xonix.move();
            balls.move();
            cube.move();

            board.setText(String.format(FORMAT_STRING, field.getCountScore(), "Health:", xonix.getCountLives(), "Full:", field.getCurrentPercent()));
            delay.wait(SHOW_DELAY);


            if (xonix.isSelfCrosed() || balls.isHitTrackOrXonix() || cube.isHitXonix()) {
                xonix.decreaseCountLives();
                if (xonix.getCountLives() > 0) {
                    xonix.init();
                    field.clearTrack();
                    delay.wait(SHOW_DELAY * 15);
                }
            }

            if (field.getCurrentPercent() >= PERCENT_OF_WATER_CAPTURE) {
                level++;

                field.init();
                xonix.init();
                cube.init();
                balls.add();
                canvas.repaint();
                delay.wait(SHOW_DELAY * 20);

            }

            canvas.repaint();
        }
        delay.wait(SHOW_DELAY * 20);
        dropp();
    }

    private void dropp(){
        level = 1;
        levelD.level = -1;
        gameover.dropp();
        xonix.dropp();
        xonix.init();
        field.init();
        field.dropp();
        cube.init();
        balls.dropp();
    }
}
