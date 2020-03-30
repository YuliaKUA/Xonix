import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        GameXonix.field.paint(g);
        GameXonix.xonix.paint(g);
        GameXonix.balls.paint(g);
        GameXonix.cube.paint(g);
        GameXonix.gameover.paint(g);
        GameXonix.levelD.paint(g);

    }
}
