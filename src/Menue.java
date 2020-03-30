import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class MenueBack {
    static final int FIELD_WIDTH = 640;
    static final int FIELD_HEIGHT = 460;

    static boolean isPlay = false;
    static boolean isAbout = false;
    static boolean isOpt = false;
    static boolean isOut = false;

    static final int PLAY_LOCATION_WIDTH = FIELD_WIDTH / 2;
    static final int PLAY_LOCATION_HEIGHT = FIELD_HEIGHT / 4;

    static final int ABOUT_LOCATION_WIDTH = FIELD_WIDTH / 2;
    static final int ABOUT_LOCATION_HEIGHT = FIELD_HEIGHT / 2;

    static final int OPT_LOCATION_WIDTH = FIELD_WIDTH / 2;
    static final int OPT_LOCATION_HEIGHT = FIELD_HEIGHT / 4 * 3;

    public static int mouseX; //mouse coordinates
    public static int mouseY;

    static int buttonHight = 60;
    static int buttonWidth = 190;

    private String buttonPlay = "PLAY";
    private String buttonAbout = "ABOUT";
    private String buttonOpt = "OPTIONS";

    static int transpPlay = 0;
    static int transpAbout = 0;
    static int transpOpt = 0;

    public String filename = "E:/Game_prod/Xonix/sourse/menue_back.jpg";
    public String filenameAbout = "E:/Game_prod/Xonix/sourse/about.png";
    public static Image image, imageAbout ;

    MenueBack() throws IOException {
        image = ImageIO.read(new File(filename));
        imageAbout = ImageIO.read(new File(filenameAbout));
    }

    void update() {
        if(mouseX > PLAY_LOCATION_WIDTH - buttonWidth/2 &&
                mouseX < PLAY_LOCATION_WIDTH + buttonWidth/2 &&
                mouseY > PLAY_LOCATION_HEIGHT - buttonHight/2 &&
                mouseY < PLAY_LOCATION_HEIGHT + buttonHight/2){
            transpPlay = 70;
        }
        else{
            transpPlay = 0;
        }

        if(mouseX > ABOUT_LOCATION_WIDTH - buttonWidth/2 &&
                mouseX < ABOUT_LOCATION_WIDTH + buttonWidth/2 &&
                mouseY > ABOUT_LOCATION_HEIGHT - buttonHight/2 &&
                mouseY < ABOUT_LOCATION_HEIGHT + buttonHight/2){
            transpAbout = 70;
        }
        else{
            transpAbout = 0;
        }
        if(mouseX > OPT_LOCATION_WIDTH - buttonWidth/2 &&
                mouseX < OPT_LOCATION_WIDTH + buttonWidth/2 &&
                mouseY > OPT_LOCATION_HEIGHT - buttonHight/2 &&
                mouseY < OPT_LOCATION_HEIGHT + buttonHight/2){
            transpOpt = 70;
        }
        else{
            transpOpt = 0;
        }
    }

    private void paintButton(Graphics g, int LOCATION_WIDTH, int LOCATION_HEIGHT, String buttonName, int transp){
        g.setColor(Color.WHITE);
        g.drawRect(LOCATION_WIDTH - buttonWidth/2, LOCATION_HEIGHT - buttonHight/2,
                buttonWidth, buttonHight);
        g.setColor(new Color(255, 255, 255, transp));
        g.fillRect(LOCATION_WIDTH - buttonWidth/2, LOCATION_HEIGHT - buttonHight/2,
                buttonWidth, buttonHight);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesNewRoman", Font.BOLD, 40));
        long length = (int) g.getFontMetrics().getStringBounds(buttonName, g).getWidth();
        g.drawString(buttonName, (int)(LOCATION_WIDTH - length/2), (int)(LOCATION_HEIGHT + buttonHight/4));
    }

    void paint(Graphics g){
        g.drawImage(image, 0, 0, null);
        paintButton(g, PLAY_LOCATION_WIDTH, PLAY_LOCATION_HEIGHT, buttonPlay, transpPlay);
        paintButton(g, ABOUT_LOCATION_WIDTH, ABOUT_LOCATION_HEIGHT, buttonAbout, transpAbout);
        paintButton(g, OPT_LOCATION_WIDTH, OPT_LOCATION_HEIGHT, buttonOpt, transpOpt);

        if(isAbout){
            g.drawImage(image, 0, 0, null);
            g.drawImage(imageAbout, 0, 0, null);
        }
    }
}


public class Menue extends JPanel{
    public static MenueBack menueBack;

    static {
        try {
            menueBack = new MenueBack();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static CanvasMenu canvasBack = new CanvasMenu();


    Menue() throws IOException {
        new Window();

        Window.startFrame.add(BorderLayout.CENTER, canvasBack);

        Window.startFrame.setVisible(true);

        addMouseMotionListener(new Listeners());
        addMouseListener(new Listeners());

    }

    public void start(){
        GameXonix game = new GameXonix();

        while (true){
            menueBack.update();
            canvasBack.repaint();

            if(MenueBack.isPlay){
                MenueBack.isPlay = false;
                game.run();
            } else if(MenueBack.isAbout){
                MenueBack.isAbout = false;
                while(!MenueBack.isOut){canvasBack.repaint();}
                MenueBack.isOut = true;
            } else if(MenueBack.isOpt){
                MenueBack.isOpt = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Menue menue = new Menue();
        Window.startFrame.getContentPane().add(menue);
        menue.start();
    }
}

