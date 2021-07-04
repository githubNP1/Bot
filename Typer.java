package bot;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Typer {
    
    public String[] splitString(String item){
        String[] items = item.split("");
        return items;
    }
    
    public int getKeyInput(String chara){
        switch(chara){
            case "a": 
                return KeyEvent.VK_A; 
            case "b": 
                return KeyEvent.VK_B; 
            case "c": 
                return KeyEvent.VK_C; 
            case "d": 
                return KeyEvent.VK_D; 
            case "e": 
                return KeyEvent.VK_E; 
            case "f": 
                return KeyEvent.VK_F;
            case "g": 
                return KeyEvent.VK_G;
            case "h": 
                return KeyEvent.VK_H; 
            case "i": 
                return KeyEvent.VK_I; 
            case "j": 
                return KeyEvent.VK_J; 
            case "k": 
                return KeyEvent.VK_K;
            case "l": 
                return KeyEvent.VK_L;
            case "m": 
                return KeyEvent.VK_M; 
            case "n": 
                return KeyEvent.VK_N; 
            case "o": 
                return KeyEvent.VK_O; 
            case "p": 
                return KeyEvent.VK_P;
            case "q": 
                return KeyEvent.VK_Q; 
            case "r": 
                return KeyEvent.VK_R;
            case "s": 
                return KeyEvent.VK_S;
            case "t": 
                return KeyEvent.VK_T; 
            case "u": 
                return KeyEvent.VK_U;
            case "v": 
                return KeyEvent.VK_V;
            case "w": 
                return KeyEvent.VK_W; 
            case "x": 
                return KeyEvent.VK_X; 
            case "y": 
                return KeyEvent.VK_Y;
            case "z": 
                return KeyEvent.VK_Z; 
            case " ": 
                return KeyEvent.VK_SPACE;
            case ",":
                return KeyEvent.VK_COMMA;
            case ".":
                return KeyEvent.VK_PERIOD;
            case ";":    
                return KeyEvent.VK_SEMICOLON;
            case "[":    
                return KeyEvent.VK_OPEN_BRACKET;
            case "-":    
                return KeyEvent.VK_MINUS;
            case "0": 
                return KeyEvent.VK_0; 
            case "1": 
                return KeyEvent.VK_1; 
            case "2": 
                return KeyEvent.VK_2; 
            case "3": 
                return KeyEvent.VK_3; 
            case "4": 
                return KeyEvent.VK_4; 
            case "5":    
                return KeyEvent.VK_5;
            case "6": 
                return KeyEvent.VK_6;
            case "7": 
                return KeyEvent.VK_7; 
            case "8": 
                return KeyEvent.VK_8; 
            case "9": 
                return KeyEvent.VK_9;
            default:
                throw new IllegalArgumentException("Cannot type character " + chara);
        }
    }
    
    public int typeDelay(){ //need too vary speeds more
        Random rand = new Random();
        int delay;
        int type = rand.nextInt(4);
        if (type == 2){
            delay = rand.nextInt(238 - 138) + 138;
        }
        else {
            delay = rand.nextInt(138 - 45) + 45;
        }
        return delay;
    }
    
    public String[] getMistakes(String letter){
        String[] mistakes = new String[4];
        switch(letter){
            case "a":
                mistakes[0] = "q";
                mistakes[1] = "z";
                mistakes[2] = "w";
                mistakes[3] = "s";
                return mistakes;
            case "b":
                mistakes[0] = "v";
                mistakes[1] = "g";
                mistakes[2] = " ";
                mistakes[3] = "n";
                return mistakes;
            case "c":
                mistakes[0] = "x";
                mistakes[1] = "d";
                mistakes[2] = "f";
                mistakes[3] = "v";
                return mistakes;
            case "d":
                mistakes[0] = "e";
                mistakes[1] = "s";
                mistakes[2] = "f";
                mistakes[3] = "x";
                return mistakes;
            case "e":
                mistakes[0] = "3"; //check if runescape type item accepts numbers
                mistakes[1] = "w";
                mistakes[2] = "d";
                mistakes[3] = "r";
                return mistakes;
            case "f":
                mistakes[0] = "r";
                mistakes[1] = "d";
                mistakes[2] = "g";
                mistakes[3] = "v";
                return mistakes;
            case "g":
                mistakes[0] = "t";
                mistakes[1] = "f";
                mistakes[2] = "h";
                mistakes[3] = "b";
                return mistakes;
            case "h":
                mistakes[0] = "y";
                mistakes[1] = "g";
                mistakes[2] = "n";
                mistakes[3] = "j";
                return mistakes;
            case "i":
                mistakes[0] = "8";
                mistakes[1] = "u";
                mistakes[2] = "o";
                mistakes[3] = "k";
                return mistakes;
            case "j":
                mistakes[0] = "u";
                mistakes[1] = "h";
                mistakes[2] = "k";
                mistakes[3] = "m";
                return mistakes;
            case "k":
                mistakes[0] = "0";
                mistakes[1] = "1";
                mistakes[2] = "2";
                mistakes[3] = "3";
               return mistakes;
            case "l":
                mistakes[0] = "o";
                mistakes[1] = "k";
                mistakes[2] = ".";
                mistakes[3] = ";";
                return mistakes;
            case "m":
                mistakes[0] = "n";
                mistakes[1] = "j";
                mistakes[2] = " ";
                mistakes[3] = ",";
                return mistakes;
            case "n":
                mistakes[0] = "b";
                mistakes[1] = "m";
                mistakes[2] = "j";
                mistakes[3] = " ";
                return mistakes;
            case "o":
                mistakes[0] = "0";
                mistakes[1] = "i";
                mistakes[2] = "p";
                mistakes[3] = "l";
                return mistakes;
            case "p":
                mistakes[0] = "-";
                mistakes[1] = "o";
                mistakes[2] = ";";
                mistakes[3] = "[";
                return mistakes;
            case "q":
                mistakes[0] = "a";
                mistakes[1] = "w";
                mistakes[2] = "2";
                mistakes[3] = "1";
                return mistakes;
            case "r":
                mistakes[0] = "5";
                mistakes[1] = "e";
                mistakes[2] = "f";
                mistakes[3] = "t";
                return mistakes;
            case "s":
                mistakes[0] = "w";
                mistakes[1] = "a";
                mistakes[2] = "d";
                mistakes[3] = "z";
                return mistakes;
            case "t":
                mistakes[0] = "6";
                mistakes[1] = "r";
                mistakes[2] = "g";
                mistakes[3] = "y";
                return mistakes;
            case "u":
                mistakes[0] = "7";
                mistakes[1] = "y";
                mistakes[2] = "j";
                mistakes[3] = "i";
                return mistakes;
            case "v":
                mistakes[0] = " ";
                mistakes[1] = "c";
                mistakes[2] = "b";
                mistakes[3] = "g";
                return mistakes;
            case "w":
                mistakes[0] = "3";
                mistakes[1] = "q";
                mistakes[2] = "s";
                mistakes[3] = "e";
                return mistakes;
            case "x":
                mistakes[0] = "z";
                mistakes[1] = "s";
                mistakes[2] = "d";
                mistakes[3] = "c";
                return mistakes;
            case "y":
                mistakes[0] = "7";
                mistakes[1] = "t";
                mistakes[2] = "h";
                mistakes[3] = "u";
                return mistakes;
            case "z":
                mistakes[0] = "a";
                mistakes[1] = "s";
                mistakes[2] = "x";
                mistakes[3] = "c";
                return mistakes;
            case " ":
                mistakes[0] = "v";
                mistakes[1] = "b";
                mistakes[2] = "n";
                mistakes[3] = "m";
                return mistakes;
            case ".":    
                mistakes[0] = ",";
                mistakes[1] = ";";
                mistakes[2] = "l";
                mistakes[3] = " ";
                return mistakes;
            case "1":
                mistakes[0] = "2";
                mistakes[1] = "3";
                mistakes[2] = "4";
                mistakes[3] = "k";
                return mistakes;
            case "2":
                mistakes[0] = "1";
                mistakes[1] = "3";
                mistakes[2] = "4";
                mistakes[3] = "k";
                return mistakes;
            case "3":
                mistakes[0] = "k";
                mistakes[1] = "2";
                mistakes[2] = "4";
                mistakes[3] = "5";
                return mistakes;
            case "4":
                mistakes[0] = "2";
                mistakes[1] = "3";
                mistakes[2] = "5";
                mistakes[3] = "k";
                return mistakes;
            case "5":
                mistakes[0] = "3";
                mistakes[1] = "4";
                mistakes[2] = "k";
                mistakes[3] = "7";
                return mistakes;
            case "6":
                mistakes[0] = "k";
                mistakes[1] = "5";
                mistakes[2] = "7";
                mistakes[3] = "8";
                return mistakes;
            case "7":
                mistakes[0] = "5";
                mistakes[1] = "6";
                mistakes[2] = "8";
                mistakes[3] = "k";
                return mistakes;
            case "8":
                mistakes[0] = "k";
                mistakes[1] = "7";
                mistakes[2] = "9";
                mistakes[3] = "0";
                return mistakes;
            case "9":
                mistakes[0] = "0";
                mistakes[1] = "k";
                mistakes[2] = "7";
                mistakes[3] = "8";
                return mistakes;
            case "0":
                mistakes[0] = "k";
                mistakes[1] = "7";
                mistakes[2] = "8";
                mistakes[3] = "9";
                return mistakes;
        }
        return null;
    }
    
    public String getMistake(String[] mistakes){
        Random rand = new Random();
        int select = rand.nextInt(4);
        return mistakes[select];
    }
    
    public void type(String item, Robot one){
        Random rand = new Random();
        String[] items = splitString(item);
        for (int i = 0; i < items.length; i++){
        
            if ("@".equals(items[i])){
                one.delay(rand.nextInt(98 - 20) + 20);
                one.keyPress(KeyEvent.VK_SHIFT);
                one.delay(typeDelay());
                one.keyPress(KeyEvent.VK_QUOTE);
                one.delay(rand.nextInt(98 - 20) + 20);
                one.keyRelease(KeyEvent.VK_QUOTE);
                one.delay(rand.nextInt(98 - 20) + 20);
                one.keyRelease(KeyEvent.VK_SHIFT);
                one.delay(typeDelay());
            }
            else{
                int numberOfMistake = rand.nextInt(15);
                if (numberOfMistake == 4){
                    String[] mistakes = getMistakes(items[i]);
                    String mistake = getMistake(mistakes);
                    int wrongLetter = getKeyInput(mistake); 

                    one.keyPress(wrongLetter);
                    one.delay(rand.nextInt(98 - 20) + 20);
                    one.keyRelease(wrongLetter);

                    one.delay(rand.nextInt(1213 - 834) + 834);
                    one.keyPress(KeyEvent.VK_BACK_SPACE);
                    one.delay(rand.nextInt(98 - 20) + 20);
                    one.keyRelease(KeyEvent.VK_BACK_SPACE);
                    one.delay(rand.nextInt(1213 - 834) + 834);
                }

                int letter = getKeyInput(items[i]);
                one.keyPress(letter);
                one.delay(rand.nextInt(98 - 20) + 20);
                one.keyRelease(letter);
                one.delay(typeDelay());
            }
        }
    }
}
 
