import java.awt.*;

public class Ball {
    private int x, y, dx, dy;

    Ball() {
        do {
            x = GameXonix.random.nextInt(Window.FIELD_WIDTH);
            y = GameXonix.random.nextInt(Window.FIELD_HEIGHT);
        } while (GameXonix.field.getColor(x, y) > GameXonix.COLOR_WATER);
        dx = GameXonix.random.nextBoolean()? 1 : -1;
        dy = GameXonix.random.nextBoolean()? 1 : -1;
    }

    void updateDXandDY() {
        if (GameXonix.field.getColor(x + dx, y) == GameXonix.COLOR_LAND) dx = -dx;
        if (GameXonix.field.getColor(x, y + dy) == GameXonix.COLOR_LAND) dy = -dy;
    }

    void move() {
        updateDXandDY();
        x += dx;
        y += dy;
    }

    int getX() { return x; }
    int getY() { return y; }

    boolean isHitTrackOrXonix() {
        updateDXandDY();
        if (GameXonix.field.getColor(x + dx, y + dy) == GameXonix.COLOR_TRACK) return true;
        if (x + dx == GameXonix.xonix.getX() && y + dy == GameXonix.xonix.getY()) return true;
        return false;
    }

    void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x * Window.POINT_SIZE, y * Window.POINT_SIZE, Window.POINT_SIZE, Window.POINT_SIZE);
        g.setColor(new Color(GameXonix.COLOR_LAND));
        g.fillOval(x * Window.POINT_SIZE + 2, y * Window.POINT_SIZE + 2, Window.POINT_SIZE - 4, Window.POINT_SIZE - 4);
    }
}
