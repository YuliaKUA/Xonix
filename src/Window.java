import javax.swing.*;

public class Window {
    final String TITLE = "Xonix";

    static final int POINT_SIZE = 10;

    static final int FIELD_WIDTH = 640 / POINT_SIZE;
    static final int FIELD_HEIGHT = 460 / POINT_SIZE;
    static final int FIELD_DX = 6;
    static final int FIELD_DY = 28 + 28;
    static final int START_LOCATION = 200;

    static JFrame startFrame = new JFrame();

    Window(){
        startFrame.setTitle(TITLE);

        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setBounds(START_LOCATION, START_LOCATION, FIELD_WIDTH * POINT_SIZE + FIELD_DX, FIELD_HEIGHT * POINT_SIZE + FIELD_DY);
        startFrame.setResizable(false);
    }

}

