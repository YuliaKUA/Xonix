public class Delay {
    void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) { e.printStackTrace(); }
    }
}
