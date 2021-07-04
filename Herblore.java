package bot;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Herblore {
    int minXBank, maxXBank, minYBank, maxYBank, minXWell, maxXWell, minYWell, maxYWell;
    
    public void getBankBoundaries(Robot one){
        one.delay(2000);
        Point p = MouseInfo.getPointerInfo().getLocation();
        minXBank = p.x;
        minYBank = p.y;
        System.out.println(minXBank + "," + minYBank);
        
        one.delay(3000);
        p = MouseInfo.getPointerInfo().getLocation();
        maxXBank = p.x;
        maxYBank = p.y;
        System.out.println(maxXBank + "," + maxYBank);
    }
    
    public void getWellBoundaries(Robot one){
        one.delay(2000);
        Point p = MouseInfo.getPointerInfo().getLocation();
        minXWell = p.x;
        minYWell = p.y;
        System.out.println(minXWell + "," + minYWell);
        
        one.delay(3000);
        p = MouseInfo.getPointerInfo().getLocation();
        maxXWell = p.x;
        maxYWell = p.y;
        System.out.println(maxXWell + "," + maxYWell); 
    }
    
    public void potion(Robot one){
        Random rand = new Random();
        int max = rand.nextInt((12 - 8) + 1) + 8;
        for(int i = 0;i<=max;i++){
            int x = rand.nextInt((maxXBank - minXBank) + 1) + minXBank;
            int y = rand.nextInt((maxYBank - minYBank) + 1) + minYBank;
            
            one.mouseMove(x, y); 
            //System.out.println("1");
            one.delay(rand.nextInt((492 - 379) + 1) + 379);
            one.mousePress(InputEvent.BUTTON1_MASK);
            one.delay(rand.nextInt((90 - 20) + 1) + 20);
            one.mouseRelease(InputEvent.BUTTON1_MASK);
            //System.out.println("2");
            one.delay(rand.nextInt((1298 - 920) + 1) + 920);
            one.mousePress(InputEvent.BUTTON1_MASK);
            one.delay(rand.nextInt((90 - 20) + 1) + 20);
            one.mouseRelease(InputEvent.BUTTON1_MASK);
            one.delay(rand.nextInt((1892 - 1679) + 1) + 1679);
            one.keyPress(KeyEvent.VK_2);
            one.delay(rand.nextInt((90 - 20) + 1) + 20);      
            one.keyRelease(KeyEvent.VK_2);
            one.delay(rand.nextInt((492 - 379) + 1) + 379);
            one.keyPress(KeyEvent.VK_2);
            one.delay(rand.nextInt((90 - 20) + 1) + 20);      
            one.keyRelease(KeyEvent.VK_2);
            if(rand.nextInt(2) == 0){
                one.delay(rand.nextInt((90 - 20) + 1) + 20);
                one.keyPress(KeyEvent.VK_2);
                one.delay(rand.nextInt((90 - 20) + 1) + 20);      
                one.keyRelease(KeyEvent.VK_2);
            }
            
            one.delay(rand.nextInt((2592 - 1379) + 1) + 1379);
            int v = rand.nextInt((maxXWell - minXWell) + 1) + minXWell;
            int w = rand.nextInt((maxYWell - minYWell) + 1) + minYWell;
            one.mouseMove(v, w); 
            one.delay(rand.nextInt((398 - 220) + 1) + 220);
            one.mousePress(InputEvent.BUTTON1_MASK);
            one.delay(rand.nextInt((90 - 20) + 1) + 20);
            one.mouseRelease(InputEvent.BUTTON1_MASK);
            one.delay(rand.nextInt((2992 - 2079) + 1) + 2079);
            one.keyPress(KeyEvent.VK_SPACE);
            one.delay(rand.nextInt((90 - 20) + 1) + 20);
            one.keyRelease(KeyEvent.VK_SPACE);
            one.delay(rand.nextInt((90 - 20) + 1) + 20);
            one.keyPress(KeyEvent.VK_SPACE);
            one.delay(rand.nextInt((90 - 20) + 1) + 20);
            one.keyRelease(KeyEvent.VK_SPACE);
            one.delay(19000); 
        }
    }
    
    public static void main(String[] args) throws AWTException{
        Robot one = new Robot();
        Herblore two = new Herblore();
        two.getBankBoundaries(one);
        two.getWellBoundaries(one);  
        Random three = new Random();
        for (int i = 0; i < 90; i++){
            two.potion(one);
            one.delay(three.nextInt((32346 - 27178) + 1) + 27178); 
        }
    }
}
