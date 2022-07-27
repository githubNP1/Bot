package finalBot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.*;

public class Bot { //requires inputs of type of armour and quantity
    String set;
    int quantity;
    ArrayList<String> items;
    ArrayList<String> buySlots;
    Random rand = new Random();
    Robot robot = new Robot();
    Typer typer = new Typer();
    MouseMovement mouse = new MouseMovement();
    
    public static void main(String[] args) throws AWTException{
        new Bot(); 
    }
    
    public Bot() throws AWTException{
        items = getSet(); 
        buySlots = buySlotCoords();
        buy();
    }
    
    //method to ask what item set and how many
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
    //returns arraylist of item strings
    public ArrayList<String> getSubjArray(){
        ArrayList<String> items = new ArrayList<>();
        items.add("boots of sub");
        items.add("garb of sub");
        items.add("gloves of sub");
        items.add("gown of sub");
        items.add("hood of sub");
        items.add("ward of sub");
        Collections.shuffle(items);  //explain importance of shuffle
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
    
    public ArrayList<String> buySlotCoords(){ //returns arraylist of coord strings, coordinates are of certain points on the game ui
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
    
    //takes slot coords from coords list and returns coords in string array
    public String[] getCoords(int slot, ArrayList<String> list){
        return list.get(slot).split(",");
    }
    //coords represent an area on the ui, typically a rectangle, with length and width of 39 pixels and an origin of given coords.
    //this method returns a random coord within this area.
    public int adjustX(String[] coords){
        return Integer.valueOf(coords[0]) + rand.nextInt(39);
    }
    
    public int adjustY(String[] coords){
        return Integer.valueOf(coords[1]) + rand.nextInt(39);
    }
    //this method clicks the mouse with a random delays between the press and release, to simulate a human clicking, rather than a program.
    public void click(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(rand.nextInt(98 - 20) + 20);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(rand.nextInt(92 - 79) + 79);
    }
    //represents another box for the item
    public int getXSelect(){
        return rand.nextInt((462 - 307) + 1) + 307; 
    }
    
    public int getYSelect(){
        return rand.nextInt((370 - 330) + 1) + 330;  
    }
    //represents and area for adjusting the quantity of items to be bought.
    public int getXQuantity(){
        return rand.nextInt(353 - 327) + 327; 
    }
    
    public int getYQuantity(){   //new name?
        return rand.nextInt(371 - 355) + 355; 
    }
    //represents the confirm buttom to complete purchase.
    public int getXConfirm(){
        return rand.nextInt(631 - 491)+ 491; 
    }
    
    public int getYConfirm(){
        return rand.nextInt(591 - 573) + 573; 
    }
    
    public void buy(){
        for(int i = 0; i < items.size(); i++){          //for every item
            String[] buySlotCoords = getCoords(i, buySlots);     //get buy slot - could change so that buySlot Coords is already created before.
            mouseMove(robot, adjustX(buySlotCoords),adjustY(buySlotCoords)); //move mouse to buy slot
            robot.delay(rand.nextInt(2396 - 1850) + 1850);  //delay
            click();
            robot.delay(rand.nextInt(2396 - 1850) + 1850);
            typer.type(items.get(i), robot);  // type item
            robot.delay(rand.nextInt(1596 - 1150) + 1150);
            mouseMove(robot, getXSelect(),getYSelect()); //move to select item
            click();
            robot.delay(rand.nextInt(1596 - 1150) + 1150); 
            mouseMove(robot, getXQuantity(),getYQuantity()); //move to adjust quantity
            for(int j = 0; j < quantity; j++){
                click();
            }
            robot.delay(rand.nextInt(1596 - 1150) + 1150);
            mouseMove(robot, 775 + rand.nextInt(12), 327 + rand.nextInt(12)); //move to adjust price - change to methods like quantity
            for(int k = 0; k < rand.nextInt(4) + 4; k++){
                click();
            }
            robot.delay(rand.nextInt(1230 - 1045) + 1045);
            mouseMove(robot, getXConfirm(),getYConfirm());  //move to confirm
            click();
            robot.delay(rand.nextInt(954 - 476) + 1500);
        }
    }
    
    public void mouseMove(Robot robot, int x, int y){ //need to convert to array necessary??? if so put method in mousemovement
        int[] finish = {x, y};
        mouse.reduction(robot, finish);
        //robot.mouseMove(x, y);
    }
}
