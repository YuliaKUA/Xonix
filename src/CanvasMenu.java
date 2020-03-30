import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CanvasMenu extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Menue.menueBack.paint(g);
    }
}
