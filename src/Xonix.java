/* Java. Classic Game Xonix
 * @author Yulia Kuznetsova
 * dated March 30, 2020
 */
import java.awt.*;

public class Xonix {
    private int x, y, direction, countLives = 3;
    private boolean isWater, isSelfCross;

    Xonix() {
        init();
    }

    void dropp(){
        countLives = 3;
    }

    void init() {
        y = 0;
        x = Window.FIELD_WIDTH / 2;
        direction = 0;
        isWater = false;
    }

    int getX() { return x; }
    int getY() { return y; }
    int getCountLives() { return countLives; }

    void decreaseCountLives() { countLives--; }

    void setDirection(int direction) { this.direction = direction; }

    void move() {
        if (direction == GameXonix. LEFT) x--;
        if (direction == GameXonix.RIGHT) x++;
        if (direction == GameXonix.UP) y--;
        if (direction == GameXonix.DOWN) y++;
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (y > Window.FIELD_HEIGHT - 2) y = Window.FIELD_HEIGHT - 2;
        if (x > Window.FIELD_WIDTH - 2) x = Window.FIELD_WIDTH - 2;
        isSelfCross = GameXonix.field.getColor(x, y) == GameXonix.COLOR_TRACK;
        if (GameXonix.field.getColor(x, y) == GameXonix.COLOR_LAND && isWater) {
            direction = 0;
            isWater = false;
            GameXonix.field.tryToFill();
        }
        if (GameXonix.field.getColor(x, y) == GameXonix.COLOR_WATER) {
            isWater = true;
            GameXonix.field.setColor(x, y, GameXonix.COLOR_TRACK);
        }
    }

    boolean isSelfCrosed() { return isSelfCross; }

    void paint(Graphics g) {
        g.setColor((GameXonix.field.getColor(x, y) == GameXonix.COLOR_LAND) ? new Color(GameXonix.COLOR_TRACK) : Color.white);
        g.fillRect(x * Window.POINT_SIZE, y * Window.POINT_SIZE, Window.POINT_SIZE, Window.POINT_SIZE);
        g.setColor((GameXonix.field.getColor(x, y) == GameXonix.COLOR_LAND) ? Color.white : new Color(GameXonix.COLOR_TRACK));
        g.fillRect(x * Window.POINT_SIZE + 3, y * Window.POINT_SIZE + 3, Window.POINT_SIZE - 6, Window.POINT_SIZE - 6);
    }
}
