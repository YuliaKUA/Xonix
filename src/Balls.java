import java.util.ArrayList;
import java.awt.*;

public class Balls {
    private ArrayList<Ball> balls = new ArrayList<Ball>();

    Balls() {
        add();
    }

    void dropp(){
        balls.removeAll(balls);
        add();
    }

    void add() { balls.add(new Ball()); }

    void move() { for (Ball ball : balls) ball.move(); }

    ArrayList<Ball> getBalls() { return balls; }

    boolean isHitTrackOrXonix() {
        for (Ball ball : balls) if (ball.isHitTrackOrXonix()) return true;
        return false;
    }

    void paint(Graphics g) { for (Ball ball : balls) ball.paint(g); }
}
