import java.awt.event.*;

public class Listeners implements MouseListener, MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {
        MenueBack.mouseX = e.getX();
        MenueBack.mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        MenueBack.mouseX = e.getX();
        MenueBack.mouseY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(MenueBack.mouseX > MenueBack.PLAY_LOCATION_WIDTH - MenueBack.buttonWidth/2 &&
                MenueBack.mouseX < MenueBack.PLAY_LOCATION_WIDTH + MenueBack.buttonWidth/2 &&
                MenueBack.mouseY > MenueBack.PLAY_LOCATION_HEIGHT - MenueBack.buttonHight/2 &&
                MenueBack.mouseY < MenueBack.PLAY_LOCATION_HEIGHT + MenueBack.buttonHight/2){
            MenueBack.isPlay = true;
        } else if(MenueBack.mouseX > MenueBack.ABOUT_LOCATION_WIDTH - MenueBack.buttonWidth/2 &&
                MenueBack.mouseX < MenueBack.ABOUT_LOCATION_WIDTH + MenueBack.buttonWidth/2 &&
                MenueBack.mouseY > MenueBack.ABOUT_LOCATION_HEIGHT - MenueBack.buttonHight/2 &&
                MenueBack.mouseY < MenueBack.ABOUT_LOCATION_HEIGHT + MenueBack.buttonHight/2){
            MenueBack.isAbout = true;
            MenueBack.isOut = false;
        } else if(MenueBack.mouseX > MenueBack.OPT_LOCATION_WIDTH - MenueBack.buttonWidth/2 &&
                MenueBack.mouseX < MenueBack.OPT_LOCATION_WIDTH + MenueBack.buttonWidth/2 &&
                MenueBack.mouseY > MenueBack.OPT_LOCATION_HEIGHT - MenueBack.buttonHight/2 &&
                MenueBack.mouseY < MenueBack.OPT_LOCATION_HEIGHT + MenueBack.buttonHight/2){
            MenueBack.isOpt = true;
        } else{
            MenueBack.isOut = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("enter");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("exit");
    }
}
