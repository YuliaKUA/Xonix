import java.awt.*;

public class GameOver {
    //fields
    private final String GAME_OVER_MSG = "GAME OVER";
    private boolean gameOver;

    //methods
    boolean isGameOver() { return gameOver; }

    void paint(Graphics g) {
        if (GameXonix.xonix.getCountLives() == 0) {
            gameOver = true;
            g.setColor(Color.white);
            g.setFont(new Font("TimesNewRoman", Font.BOLD, 60));
            FontMetrics fm = g.getFontMetrics();
            g.drawString(GAME_OVER_MSG, (Window.FIELD_WIDTH * Window.POINT_SIZE + Window.FIELD_DX - fm.stringWidth(GAME_OVER_MSG))/2, (Window.FIELD_HEIGHT * Window.POINT_SIZE)/2);
        }
    }

    void dropp(){
        gameOver = false;
    }
}
