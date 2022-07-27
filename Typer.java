package finalBot;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Typer {
    
    public void type(String item, Robot robot){   //this method is called by buying bot class
        Random rand = new Random();
        String[] items = splitString(item);
        for (int i = 0; i < items.length; i++){
            if ("@".equals(items[i])){ 
                typeAddressSign(robot,rand);
            }
            else{
                mistakeGenerator(robot, rand);
                typeLetter(robot, rand, getKeyEvent(items[i])); 
            }
        }
    }
    
    public void mistakeGenerator(Robot robot, Random rand){ //if mistake, pause then delete - to simulate a real person realizing and correcting mistake.
        if(rand.nextInt(20) == 1){ //simply used to give a 1 in 20 chance of making a mistake  
            typeLetter(robot, rand, newMistakeGenerator(rand));
            robot.delay(rand.nextInt(1213 - 834) + 834); //just add another delay
            typeLetter(robot, rand, KeyEvent.VK_BACK_SPACE);
            robot.delay(rand.nextInt(1213 - 834) + 834);  //just add another delay
        }
    }
    
    public String[] splitString(String item){  //splits string and returns array of characters
        String[] items = item.split("");
        return items;
    }
    
    public int getKeyEvent(String word){
        return java.awt.event.KeyEvent.getExtendedKeyCodeForChar(word.charAt(0));
    }
    
    public int newMistakeGenerator(Random rand){//return keyEvent for a randomly chosen string from the array
        String[] mistakes = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," ",",",".",";","[","-","0","1","2","3","4","5","6","7","8","9"};        
        return getKeyEvent(mistakes[rand.nextInt(mistakes.length)]); 
    } //is there a better way to generate mistakes
    
    public void typeAddressSign(Robot robot, Random rand){ //types @       
        robot.delay(rand.nextInt(98 - 20) + 20);
        robot.keyPress(KeyEvent.VK_SHIFT);
        typeDelay(robot, rand);
        robot.keyPress(KeyEvent.VK_QUOTE);
        robot.delay(rand.nextInt(98 - 20) + 20);
        robot.keyRelease(KeyEvent.VK_QUOTE); 
        robot.delay(rand.nextInt(98 - 20) + 20);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        typeDelay(robot, rand);
    }
    
    public void typeLetter(Robot robot, Random rand, int KeyEvent){    //types a letter using given keyevent
        robot.keyPress(KeyEvent);
        robot.delay(rand.nextInt(98 - 20) + 20);  //perhaps add another layer of delay
        robot.keyRelease(KeyEvent);
        typeDelay(robot, rand);
    }
    
    public void typeDelay(Robot robot, Random rand){ //this adds a delay between typing each character
        if (rand.nextInt(4) == 1){
            robot.delay(rand.nextInt(338 - 138) + 138);
        }
        else {
            robot.delay(rand.nextInt(138 - 45) + 45);
        }
    }
}
 
