package bot;

import java.awt.*;
import java.awt.event.*;

public class Abyss {
    public static void main(String[] args) throws AWTException{
        Robot one = new Robot();
        one.delay(3000); 
        for (int i = 0; i <= 80; i++){
            one.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            one.delay(50); 
            one.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{
                Thread.sleep(660000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
                System.out.println(ex);
            }
        }
    }
}
