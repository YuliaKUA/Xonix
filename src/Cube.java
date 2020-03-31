import java.awt.*;

public class Cube {
    //fields
    private int x, y, dx, dy;

    //constructor
    Cube() {
        init();
    }

    //methods
    void init() { x = dx = dy = 1; }

    void updateDXandDY() {
        if (GameXonix.field.getColor(x + dx, y) == GameXonix.COLOR_WATER) dx = -dx;
        if (GameXonix.field.getColor(x, y + dy) == GameXonix.COLOR_WATER) dy = -dy;
    }

    void move() {
        updateDXandDY();
        x += dx;
        y += dy;
    }

    boolean isHitXonix() {
        updateDXandDY();
        if (x + dx == GameXonix.xonix.getX() && y + dy == GameXonix.xonix.getY()) return true;
        return false;
    }

    void paint(Graphics g) {
        g.setColor(new Color(0xFFFFFF));
        g.fillRect(x * Window.POINT_SIZE, y * Window.POINT_SIZE, Window.POINT_SIZE, Window.POINT_SIZE);
        g.setColor(new Color(GameXonix.COLOR_LAND));
        g.fillRect(x * Window.POINT_SIZE + 2, y * Window.POINT_SIZE + 2, Window.POINT_SIZE - 4, Window.POINT_SIZE - 4);
    }
}
