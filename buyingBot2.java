package bot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.*;

public class buyingBot2 {
    String set;
    int quantity;
    ArrayList<String> items;
    ArrayList<String> buySlots;
    Random rand = new Random();
    Robot robot = new Robot();
    typer typer = new typer();
    
    public static void main(String[] args) throws AWTException{
        buyingBot2 one = new buyingBot2();
    }
    
    public buyingBot2() throws AWTException{
        items = getSet();
        buySlots = buySlotCoords();
        buy();
    }
    
    //method to ask what set and how many
    public ArrayList<String> getSet(){
        Scanner scanner = new Scanner(System.in);
        set = scanner.next();
        quantity = scanner.nextInt();
        scanner.close();
        switch(set){
            case "s":
                return getSubjArray();
            case "a":
                return getArmArray();
            default:
                return getBandosArray();
        }
    }
    
    public ArrayList<String> getSubjArray(){
        ArrayList<String> items = new ArrayList<>();
        items.add("boots of sub");
        items.add("garb of sub");
        items.add("gloves of sub");
        items.add("gown of sub");
        items.add("hood of sub");
        items.add("ward of sub");
        Collections.shuffle(items); 
        return items;
    }
    
    public ArrayList<String> getBandosArray(){
        ArrayList<String> items = new ArrayList<>();
        items.add("bandos boo");
        items.add("bandos che");
        items.add("bandos glo");
        items.add("bandos hel");
        items.add("bandos tas");
        items.add("bandos war");
        Collections.shuffle(items);
        return items;
    }
    
    public ArrayList<String> getArmArray(){
        ArrayList<String> items = new ArrayList<>();
        items.add("armadyl boo");
        items.add("armadyl buc");
        items.add("armadyl chai");
        items.add("armadyl che");
        items.add("armadyl glo");
        items.add("armadyl hel");
        Collections.shuffle(items);
        return items;
    }
    
    public ArrayList<String> buySlotCoords(){
        ArrayList<String> coords = new ArrayList<>();
        coords.add("335,260");
        coords.add("512,260");
        coords.add("689,260");
        coords.add("335,388");
        coords.add("512,388");
        coords.add("689,388");
        coords.add("335,516");
        coords.add("512,516");
        return coords;
    }
    
    public String[] getCoords(int slot, ArrayList<String> list){
        return list.get(slot).split(",");
    }
    
    public int adjustX(String[] coords){
        return Integer.valueOf(coords[0]) + rand.nextInt(39);
    }
    
    public int adjustY(String[] coords){
        return Integer.valueOf(coords[1]) + rand.nextInt(39);
    }
    
    public void click(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(rand.nextInt(98 - 20) + 20);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(rand.nextInt(92 - 79) + 79);
    }
    
    public int getXSelect(){
        return rand.nextInt((462 - 307) + 1) + 307;
    }
    
    public int getYSelect(){
        return rand.nextInt((496 - 456) + 1) + 456;
    }
    
    public int getXQuantity(){
        return rand.nextInt(376 - 350) + 350;
    }
    
    public int getYQuantity(){
        return rand.nextInt(371 - 355) + 355;
    }
    
    public int getXConfirm(){
        return rand.nextInt(633 - 489)+ 489;
    }
    
    public int getYConfirm(){
        return rand.nextInt(593 - 574) + 574;
    }
    
    public void buy(){
        for(int i = 0; i < items.size(); i++){
            String[] buySlotCoords = getCoords(i, buySlots);
            robot.mouseMove(adjustX(buySlotCoords),adjustY(buySlotCoords));
            robot.delay(rand.nextInt(2396 - 1850) + 1850);
            click();
            robot.delay(rand.nextInt(2396 - 1850) + 1850);
            typer.type(items.get(i), robot); 
            robot.delay(rand.nextInt(1596 - 1150) + 1150);
            robot.mouseMove(getXSelect(),getYSelect());
            click();
            robot.delay(rand.nextInt(1596 - 1150) + 1150); 
            robot.mouseMove(getXQuantity(),getYQuantity());
            for(int j = 0; j < quantity; j++){
                click();
            }
            robot.delay(rand.nextInt(1596 - 1150) + 1150);
            robot.mouseMove(755 + rand.nextInt(12), 330 + rand.nextInt(12));
            for(int k = 0; k < rand.nextInt(4) + 4; k++){
                click();
            }
            robot.delay(rand.nextInt(1230 - 1045) + 1045);
            robot.mouseMove(getXConfirm(),getYConfirm());  
            click();
            robot.delay(rand.nextInt(954 - 476) + 1500);
        }
    }
}
