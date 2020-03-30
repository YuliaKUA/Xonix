import java.awt.*;

public class Field {
    private final int WATER_AREA = (Window.FIELD_WIDTH - 4) * (Window.FIELD_HEIGHT - 4);
    private int[][] field = new int[Window.FIELD_WIDTH][Window.FIELD_HEIGHT];
    private float currentWaterArea;
    private int countScore = 0;

    Field() {
        init();
    }

    void dropp(){
        countScore = 0;
    }
    void init() {
        for (int y = 0; y < Window.FIELD_HEIGHT; y++)
            for (int x = 0; x < Window.FIELD_WIDTH; x++)
                field[x][y] = (x < 2 || x > Window.FIELD_WIDTH - 3 || y < 2 || y > Window.FIELD_HEIGHT - 3)? GameXonix.COLOR_LAND : GameXonix.COLOR_WATER;
        currentWaterArea = WATER_AREA;
    }

    int getColor(int x, int y) {
        if (x < 0 || y < 0 || x > Window.FIELD_WIDTH - 1 || y > Window.FIELD_HEIGHT - 1) return GameXonix.COLOR_WATER;
        return field[x][y];
    }

    void setColor(int x, int y, int color) { field[x][y] = color; }

    int getCountScore() { return countScore; }
    float getCurrentPercent() { return 100f - currentWaterArea / WATER_AREA * 100; }

    void clearTrack() { // clear track of Xonix
        for (int y = 0; y < Window.FIELD_HEIGHT; y++)
            for (int x = 0; x < Window.FIELD_WIDTH; x++)
                if (field[x][y] == GameXonix.COLOR_TRACK) field[x][y] = GameXonix.COLOR_WATER;
    }

    void fillTemporary(int x, int y) {
        if (field[x][y] > GameXonix.COLOR_WATER) return;
        field[x][y] = GameXonix.COLOR_TEMP; // filling temporary color
        for (int dx = -1; dx < 2; dx++)
            for (int dy = -1; dy < 2; dy++) fillTemporary(x + dx, y + dy);
    }

    void tryToFill() {
        currentWaterArea = 0;
        for (Ball ball : GameXonix.balls.getBalls()) fillTemporary(ball.getX(), ball.getY());
        for (int y = 0; y < Window.FIELD_HEIGHT; y++)
            for (int x = 0; x < Window.FIELD_WIDTH; x++) {
                if (field[x][y] == GameXonix.COLOR_TRACK || field[x][y] == GameXonix.COLOR_WATER) {
                    field[x][y] = GameXonix.COLOR_LAND;
                    countScore += 10;
                }
                if (field[x][y] == GameXonix.COLOR_TEMP) {
                    field[x][y] = GameXonix.COLOR_WATER;
                    currentWaterArea++;
                }
            }
    }

    void paint(Graphics g) {
        for (int y = 0; y < Window.FIELD_HEIGHT; y++)
            for (int x = 0; x < Window.FIELD_WIDTH; x++) {

                if(field[x][y] == GameXonix.COLOR_WATER){
                    g.setColor(new Color(0x0B6ADE));
                }else{
                    g.setColor(new Color(field[x][y]));
                }

                g.fillRect(x * Window.POINT_SIZE, y * Window.POINT_SIZE, Window.POINT_SIZE, Window.POINT_SIZE);
            }
    }
}
