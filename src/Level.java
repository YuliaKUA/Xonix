import java.awt.*;

public class Level {
    //fields
    private String gameLevelMsg = "Level ";
    public int level = -1;

    //methods

    void paint(Graphics g) {
        if (GameXonix.level > level && GameXonix.level != 0) {
            this.level = GameXonix.level;

            g.setColor(Color.white);
            g.setFont(new Font("TimesNewRoman", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString(gameLevelMsg + level, (Window.FIELD_WIDTH * Window.POINT_SIZE + Window.FIELD_DX - fm.stringWidth(gameLevelMsg))/2, (Window.FIELD_HEIGHT * Window.POINT_SIZE)/2);
        }
    }
}
