package finalBot;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Scanner;

public class Divination {
    Random rand = new Random();
    Robot robot = new Robot();
    MouseMovement mouse = new MouseMovement();
    int numberOfHarvests;  //when used in loop, use random number around given input
    int numberOfCycles; 
    
    public static void main(String[] args) throws AWTException{
        new Divination();
    }
    
    public Divination() throws AWTException{
        //detectLights();
        
        while(true){
            while(!checkForFullInventory()){
                detectLights();
                while(!completedHarvesting()){robot.delay(100);}
            }
            findPortal();
            while(!completedDeposit()){robot.delay(100);}
        }
    }
    
    public void detectLights(){
        Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage b;
        //int t = 20; 
        //outerloop:
        //while(t > 1){ System.out.println(t);
            b = robot.createScreenCapture(area);
            outerloop:
            for(int i = 300; i < 1000; i++){
                for(int j = 100; j < 600; j++){ 
                    if(b.getRGB(i, j) >= -14444000 && b.getRGB(i, j) <= -14430000){
                        mouseMove(robot, i, j);
                        click();
                        robot.delay(4000);
                        break outerloop;
                    }
                }
            //}
            //t--; 
        }
    }
    
    public Boolean completedHarvesting(){
        if(robot.getPixelColor(697, 41).getRGB() != -15000805){
            return true;
        }
        return false;
    }
    
    public Boolean checkForFullInventory(){              //1243, 540            1251, 548
        if(robot.getPixelColor(601, 582).getRGB() >= -3300000 && robot.getPixelColor(601, 582).getRGB() <= -3290000){       //put in another method if used multiple times
            return true;
        }
        return false;
    }
    
    public void findPortal(){
        Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage b;
        int t = 20; outerloop:
        while(t > 1){ System.out.println(t);
            b = robot.createScreenCapture(area);
            for(int i = 300; i < 1000; i++){
                for(int j = 100; j < 600; j++){ 
                    if(b.getRGB(i, j) >= -4660000 && b.getRGB(i, j) <= -4650000){   
                        mouseMove(robot, i, j);
                        click();
                        robot.delay(4000);
                        break outerloop;
                    }
                }
            }
            t--; 
        }
    }
    
    public Boolean completedDeposit(){ //could be opposite of checkfullinvent, could be same as completedharvesting
        if(robot.getPixelColor(697, 41).getRGB() != -15000805){
            return true;
        }
        return false;
    }
    
    public void click(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        generateShortRandomDelay();       
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        generateShortRandomDelay();  
    }
    
    public void generateShortRandomDelay(){
        robot.delay(rand.nextInt(100) + 20);  
        if(rand.nextInt(7) == 1){
            robot.delay(rand.nextInt(4) * 30); 
        }
    }
    
    public void mouseMove(Robot robot, int x, int y){ //need to convert to array necessary??? if so put method in mousemovement
        int[] finish = {x, y};
        mouse.reduction(robot, finish);
        //robot.mouseMove(x, y);
    }
    
    public void getNumHarvests(){ //input number of harvests before logging off
        Scanner scanner = new Scanner(System.in);
        numberOfHarvests = scanner.nextInt();
        scanner.close();
    }
    
    public void getNumCycles(){  //input number of cycles before stopping
        Scanner scanner = new Scanner(System.in);
        numberOfCycles = scanner.nextInt();
        scanner.close();
    }
    
    public void logOff(){
        //press exit button
        //check next page
        //press exit to lobby
    }
    
    public void lobby(){
        //wait for given period of time
        //move mouse every now and then
    }
    
    public void logOn(){
        //press log on button
        //check if logged on
    }
    
}
 