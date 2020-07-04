package com;
import org.junit.*;
import java.util.*;
import java.io.*;


class Game_win_exception extends Exception implements Serializable{
    public static final long serialVersionUID = 96;
    public Game_win_exception(String msg){
        super(msg);
    }
}
class Snake_exception extends Exception implements Serializable{
    public static final long serialVersionUID = 96;
    public Snake_exception(String msg){
        super(msg);
    }
}
class Vulture_exception extends Exception implements Serializable{
    public static final long serialVersionUID = 96;
    public Vulture_exception(String msg){
        super(msg);
    }
}
class Cricket_exception extends Exception implements Serializable {
    public static final long serialVersionUID = 96;
    public Cricket_exception(String msg){
        super(msg);
    }
}
class Trampoline_exception extends Exception implements Serializable {
    public static final long serialVersionUID = 96;
    public Trampoline_exception(String msg){
        super(msg);
    }
}
class White_exception extends Exception implements Serializable {
    public static final long serialVersionUID = 96;
    public White_exception(String msg){
        super(msg);
    }
}

abstract class Tile implements Serializable{
    public static final long serialVersionUID = 96;
    private final int attack;
    private final String tile_name;
    Tile(String tile_name,int attack) {
        this.attack=attack;
        this.tile_name=tile_name;
    }
    public int getAttack() {
        return attack;
    }
    // public void setAttack(int attack) {
    // 	this.attack = attack;
    // }
    public abstract void tile_special_attack(int tile);

    public String getTile_name() {
        return tile_name;
    }
}
class Snake extends Tile implements Serializable{
    public static final long serialVersionUID = 96;
    Snake(int attack){
        super("Snake",attack);
        // this.attack(attack);
    }
    @Override
    public void tile_special_attack(int tile) {
        try {
            get_snake_attack(tile);
        } catch (Snake_exception s) {
            System.out.println(s.getMessage());
        }
    }
    public void get_snake_attack(int t) throws Snake_exception{
        System.out.println("           Trying to shake the Tile-"+t);
        throw new Snake_exception("           Hiss...! I am a Snake, you go back "+this.getAttack()+" tiles!");
    }
}
class Vulture extends Tile implements Serializable{
    public static final long serialVersionUID = 96;
    Vulture(int attack){
        super("Vulture",attack);
        // this.attack(attack);
    }
    @Override
    public void tile_special_attack(int tile) {
        try {
            get_vulture_attack(tile);
        } catch (Vulture_exception s) {
            System.out.println(s.getMessage());
        }
    }
    public void get_vulture_attack(int t) throws Vulture_exception{
        System.out.println("           Trying to shake the Tile-"+t);
        throw new Vulture_exception("           Yapping...! I am a Vulture, you go back "+this.getAttack()+" tiles!");
    }
}
class Trampoline extends Tile implements Serializable {
    public static final long serialVersionUID = 96;
    Trampoline(int attack){
        super("Trampoline",attack);
        // this.attack(attack);
    }
    @Override
    public void tile_special_attack(int tile) {
        try {
            get_trampoline_attack(tile);
        } catch (Trampoline_exception s) {
            System.out.println(s.getMessage());
        }
    }
    public void get_trampoline_attack(int t) throws Trampoline_exception{
        System.out.println("           Trying to shake the Tile-"+t);
        throw new Trampoline_exception("           PingPong! I am a Trampoline, you advance "+(-this.getAttack())+" tiles!");
    }
}
class Cricket extends Tile implements Serializable {
    public static final long serialVersionUID = 96;
    Cricket(int attack){
        super("Cricket",attack);
        // this.attack(attack);
    }
    @Override
    public void tile_special_attack(int tile) {
        try {
            get_cricket_attack(tile);
        } catch (Cricket_exception s) {
            System.out.println(s.getMessage());
        }
    }
    public void get_cricket_attack(int t) throws Cricket_exception{
        System.out.println("           Trying to shake the Tile-"+t);
        throw new Cricket_exception("           Chirp...! I am a Cricket, you go back "+this.getAttack()+" tiles!");
    }

}
class White extends Tile implements Serializable{
    public static final long serialVersionUID = 96;
    White(int attack){
        super("White",attack);
        // this.attack(attack);
    }
    @Override
    public void tile_special_attack(int tile) {
        try {
            get_white_attack(tile);
        } catch (White_exception s) {
            System.out.println(s.getMessage());
        }
    }
    public void get_white_attack(int t) throws White_exception{
        System.out.println("           Trying to shake the Tile-"+t);
        throw new White_exception("           I am a White tile!");
    }
}

class game implements Serializable{

    public static final long serialVersionUID = 96;
    private int length_of_track;
    private String name;
    private int roll;
    int count=0;
    private boolean flag25=false;
    private boolean flag50=false;
    private boolean flag75=false;
    private final int attack_trampoline_tiles;
    private final int attack_snake_tiles;
    private final int attack_cricket_tiles;
    private final int attack_vulture_tiles;
    private final int attack_white_tiles;
    private int total_snake;
    private int total_vulture;
    private int total_trampoline;
    private int total_cricket;
    Random rand = new Random();
    private int next_tile=0;
    private int current_tile_number;
    private ArrayList<Tile> tiles;
    game(String name,int length_of_track) {
        this.name=name;
        this.length_of_track=length_of_track;
        this.current_tile_number=0;
        this.roll=0;
        total_cricket=0;
        total_snake=0;
        total_trampoline=0;
        total_vulture=0;
        this.attack_cricket_tiles=1+rand.nextInt(10);
        this.attack_vulture_tiles=1+rand.nextInt(10);
        this.attack_snake_tiles=1+rand.nextInt(10);
        this.attack_trampoline_tiles=-(1+rand.nextInt(10));
        attack_white_tiles=0;
        tiles=new ArrayList<Tile>();
    }
    public int dice_roll(){
        return 1+rand.nextInt(6);
    }
    public void game_win(){
        try {
            game_win_func();
        } catch (Game_win_exception g) {
            // System.out.println("333333333333333333333333333333333333333");
            System.out.println(g.getMessage());
        }
    }
    @Override
    public boolean equals(Object o){
        if(o!=null && getClass()==o.getClass()){
            game g3	=	(game)o;
            return (g3.getCurrent_tile_number()==this.getCurrent_tile_number() && g3.getName().equals(this.getName()) && g3.getRoll()==this.getRoll() && g3.getLength_of_track()==this.getLength_of_track());
        }
        else{
            return false;
        }
    }
    public void game_win_func() throws Game_win_exception{
        System.out.println(getName()+" wins the race in "+getRoll()+" rolls!");
        System.out.println("Total Snake Bites = ​ "+getTotal_snake());
        System.out.println("Total Vulture Bites = ​ "+getTotal_vulture());
        System.out.println("Total Cricket Bites = ​ "+getTotal_cricket());
        System.out.println("Total Trampolines = ​ "+getTotal_trampoline());
        // System.out.println("1111111111111111111");
        throw new Game_win_exception("<----------------Game Ended---------------->");
    }
    public void game_initial_loop() throws IOException,ClassNotFoundException{
        this.roll++;
        int temp=dice_roll();
        while(temp!=6){
            System.out.println("[Roll-"+getRoll()+"]: "+getName()+" rolled "+temp+" at Tile-1, OOPs you need 6 to start");
            temp=dice_roll();

            this.roll++;
        }
        System.out.println("[Roll-"+getRoll()+"]: "+getName()+" rolled "+temp+" at Tile-1. You are out of the cage! You get a free roll");
        current_tile_number=1;
        game_main_loop();
    }
    public void game_main_loop() throws IOException,ClassNotFoundException{
        Scanner scan = new Scanner(System.in);
        try{
            int temp;
            int abc=0;
            Tile tile_temp;
            while(current_tile_number!=getLength_of_track()){
                // try {
                //     Thread.sleep(50);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
                if(current_tile_number>=(getLength_of_track()/4) && !flag25){
                    flag25=true;
                    System.out.println("Do you want to save the game ?(y/n)");
                    String input = scan.next();
                    while(!input.equals("y") && !input.equals("n")){
                        System.out.println("please try again");
                        input=scan.next();
                    }
                    if(input.equals("y")){
                        ObjectOutputStream out = null;
                        try{
                            out = new ObjectOutputStream(new FileOutputStream(this.getName()));
                            out.writeObject(this);
                        }
                        finally{
                            out.close();
                            System.exit(1);
                        }
                    }
                }
                if(current_tile_number>=(getLength_of_track()/2) && !flag50){
                    flag50=true;flag25=true;
                    System.out.println("Do you want to save the game ?(y/n)");
                    String input = scan.next();
                    while(!input.equals("y") && !input.equals("n")){
                        System.out.println("please try again");
                        input=scan.next();
                    }
                    if(input.equals("y")){
                        ObjectOutputStream out = null;
                        try{
                            out = new ObjectOutputStream(new FileOutputStream(this.getName()));
                            out.writeObject(this);
                        }
                        finally{
                            out.close();
                            System.exit(1);
                        }
                    }
                }
                if(current_tile_number>=(getLength_of_track()*3)/4 && !flag75){
                    flag75=true;flag50=true;flag25=true;
                    System.out.println("Do you want to save the game ?(y/n)");
                    String input = scan.next();
                    while(!input.equals("y") && !input.equals("n")){
                        System.out.println("please try again");
                        input=scan.next();
                    }
                    if(input.equals("y")){
                        ObjectOutputStream out = null;
                        try{
                            out = new ObjectOutputStream(new FileOutputStream(this.getName()));
                            out.writeObject(this);
                        }
                        finally{
                            out.close();
                            System.exit(1);
                        }
                    }
                }
                this.roll++;
                if(getRoll()>=10*getLength_of_track()){
                    System.out.println("Error detected ... Reconfiguring...");
                    setRoll(0);
                    setTotal_cricket(0);
                    setTotal_snake(0);
                    setTotal_trampoline(0);
                    setTotal_vulture(0);
                    tiles = new ArrayList<Tile>();
                    create_track();
                    game_initial_loop();
                }
                temp=dice_roll();
                if(temp+getCurrent_tile_number()<=getLength_of_track()){
                    System.out.println("[Roll-"+getRoll()+"]: "+getName()+" rolled "+temp+" at Tile-"+getCurrent_tile_number()+", landed on Tile "+(temp+getCurrent_tile_number()));
                    abc=this.getCurrent_tile_number()+temp;
                    setCurrent_tile_number(this.getCurrent_tile_number()+temp);
                    if(getCurrent_tile_number()==getLength_of_track()){
                        // System.out.println("<----------------Game Ended---------------->");
                        game_win();
                        System.exit(1);
                    }
                    // try{
                    tile_temp=tiles.get(this.getCurrent_tile_number()-1);
                    // }
                    // catch(IndexOutOfBoundsException e){
                    // e.getMessage();
                    // }
                    if(tile_temp.getTile_name().equals("Snake")){ this.total_snake++;}
                    else if(tile_temp.getTile_name().equals("Vulture")){ this.total_vulture++;}
                    else if(tile_temp.getTile_name().equals("Cricket")){ this.total_cricket++;}
                    else if(tile_temp.getTile_name().equals("Trampoline")){ this.total_trampoline++;}
                    tile_temp.tile_special_attack(this.getCurrent_tile_number());
                    setCurrent_tile_number(this.getCurrent_tile_number()-tile_temp.getAttack());
                    if(getCurrent_tile_number()>getLength_of_track()){
                        setCurrent_tile_number(abc);
                    }
                    if(getCurrent_tile_number()==getLength_of_track()){
                        System.out.println("[Roll-"+getRoll()+"]: "+getName()+" rolled "+temp+" at Tile-"+getCurrent_tile_number()+", landed on Tile "+getCurrent_tile_number());
                        game_win();
                        // System.out.println("<----------------Game Ended---------------->");
                        // System.out.println(getName()+" wins the race in "+getRoll()+" rolls!");
                        // System.out.println("Total Snake Bites = ​ "+getTotal_snake());
                        // System.out.println("Total Vulture Bites = ​ "+getTotal_vulture());
                        // System.out.println("Total Cricket Bites = ​ "+getTotal_cricket());
                        // System.out.println("Total Trampoline Bites = ​ "+getTotal_trampoline());
                        System.exit(1);
                    }
                }
                else{
                    System.out.println("[Roll-"+getRoll()+"]: "+getName()+" rolled "+temp+" at Tile-"+getCurrent_tile_number()+", landed on Tile "+getCurrent_tile_number());
                }
                if(getCurrent_tile_number()<1){
                    setCurrent_tile_number(1);
                    game_initial_loop();
                }
                else{
                    System.out.println("           "+getName()+" moved to Tile-"+getCurrent_tile_number());
                }
            }
        }
        catch(Exception e){
            System.out.println("Error in game");
            e.getMessage();
        }
    }

    public int getLength_of_track() {
        return this.length_of_track;
    }
    public void setLength_of_track(int length_of_track) {
        this.length_of_track = length_of_track;
    }
    public void create_track(){
        int num_cricket_tiles=0;
        int num_vulture_tiles=0;
        int num_trampoline_tiles=0;
        int num_white_tiles=0;
        int num_snake_tiles=0;
        int counter_trampoline_tiles=0;
        int counter_snake_tiles=0;
        int counter_cricket_tiles=0;
        int counter_vulture_tiles=0;
        int counter_white_tiles=0;
        int temp;
        System.out.println("Setting up the race track...");
        try{
            for(int i=0;i<length_of_track;i++){
                temp=1+rand.nextInt(30);
                if(temp==1 || temp==20){
                    counter_snake_tiles++;
                    tiles.add(new Snake(this.getAttack_snake_tiles()));
                }
                else if(temp==4 || temp==24){
                    counter_vulture_tiles++;
                    tiles.add(new Vulture(this.getAttack_vulture_tiles()));
                }
                else if(temp==10 || temp ==28){
                    counter_cricket_tiles++;
                    tiles.add(new Cricket(this.getAttack_cricket_tiles()));
                }
                else if(temp==15 || temp==29 || temp==26 || temp==7){
                    counter_trampoline_tiles++;
                    tiles.add(new Trampoline(this.getAttack_trampoline_tiles()));
                }
                else{
                    counter_white_tiles++;
                    tiles.add(new White(this.getAttack_white_tiles()));
                }
            }
        }
        catch(OutOfMemoryError r){
            r.getMessage();
        }
        System.out.println("Danger: There are "+counter_snake_tiles+", "+counter_cricket_tiles+", "+counter_vulture_tiles+" numbers of Snakes, Cricket, and Vultures respectively on your track!");
        System.out.println("Danger: Each Snake, Cricket, and Vultures can throw you back by "+ getAttack_snake_tiles()+", "+getAttack_cricket_tiles()+", "+getAttack_vulture_tiles()+" number of Tiles respectively!");
        System.out.println("Good News: There are "+counter_trampoline_tiles +" number of Trampolines on your track!");
        System.out.println("Good News: Each Trampoline can help you advance by "+-(getAttack_trampoline_tiles()) +" number of Tiles");
    }
    public void gamestart() throws IOException,ClassNotFoundException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter total number of tiles on the race track (length)");
        boolean done=true;
        while(done){
            try{
                this.length_of_track=Integer.parseInt(scan.next());
                done=false;
            }
            catch(NumberFormatException inp){
                // inp.printStackTrace();
                // System.out.println(inp.printStackTrace());
                System.out.println("Wrong input:");
                System.out.println("Please try again with an Integer");
            }
        }
        create_track();
        System.out.println("Enter the Player Name");
        name=scan.next();
        while(!name.matches("[a-zA-Z]+")){
            name = scan.nextLine();
            System.out.println("Please enter a valid name!");
        }
        game_begin();
    }
    public void game_begin() throws IOException,ClassNotFoundException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Starting the game with "+getName()+" at Tile-"+(getCurrent_tile_number()+1));
        System.out.println("Control transferred to Computer for rolling the Dice for "+getName());
        System.out.println("Hit enter to start the game");
        // System.out.print("");
        // while(!scan.hasNextLine()){System.out.println("ooo");}
        String temp = scan.nextLine();
//        temp=scan.nextLine();
        while(!temp.isEmpty()){
            System.out.println("Please press enter to start the game..");
            temp=scan.nextLine();
        }
        // if(temp.isEmpty()){

        //     System.out.println("222222222"+temp+"kkk");
        // }
        // System.out.println("jjjj");
        System.out.println("<---------------- Game Started ---------------->");
        game_initial_loop();

    }
    public int getAttack_trampoline_tiles() {
        return attack_trampoline_tiles;
    }
    public int getAttack_snake_tiles() {
        return attack_snake_tiles;
    }
    public int getAttack_cricket_tiles() {
        return attack_cricket_tiles;
    }
    public int getAttack_vulture_tiles() {
        return attack_vulture_tiles;
    }
    public int getAttack_white_tiles() {
        return attack_white_tiles;
    }
    public ArrayList<Tile> getTiles() {
        return tiles;
    }
    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCurrent_tile_number() {
        return current_tile_number;
    }
    public void setCurrent_tile_number(int current_tile_number) {
        this.current_tile_number = current_tile_number;
    }
    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getTotal_snake() {
        return total_snake;
    }

    public void setTotal_snake(int total_snake) {
        this.total_snake = total_snake;
    }

    public int getTotal_vulture() {
        return total_vulture;
    }

    public void setTotal_vulture(int total_vulture) {
        this.total_vulture = total_vulture;
    }

    public int getTotal_trampoline() {
        return total_trampoline;
    }

    public void setTotal_trampoline(int total_trampoline) {
        this.total_trampoline = total_trampoline;
    }

    public int getTotal_cricket() {
        return total_cricket;
    }

    public void setTotal_cricket(int total_cricket) {
        this.total_cricket = total_cricket;
    }
}
public class app {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        Scanner scan = new Scanner(System.in);
        boolean gtg=true;
        while(gtg){
            System.out.println("Do you want to load from a previously saved game(y/n)");
            String saveornot=scan.next();
            while(!saveornot.equals("y") && !saveornot.equals("n")){
                System.out.println("please try again with y or n");
                saveornot=scan.next();
            }
            if(saveornot.equals("y")){
                System.out.println("Enter name");
                String abc = scan.next();
                ObjectInputStream in = null;
                try{
                    in = new ObjectInputStream(new FileInputStream(abc));
                    game g = (game)in.readObject();
                    gtg=false;
                    g.game_main_loop();
                    in.close();
                }
                catch(FileNotFoundException f){
                    System.out.println("User not saved");
                    System.out.println("Please try again...................");
                }
            }
            else{
                gtg=false;
                System.out.println("Enter total number of tiles on the race track (length)");
                // game g = new game();
                // g.gamestart();
                boolean done=true;
                int lot=0;
                while(done){
                    try{
                        lot=Integer.parseInt(scan.next());
                        if(lot<4){
                            System.out.println("Track size to be atleast 4");
                            // throw NumberFormatException("abc");
                        }
                        else{
                            done=false;
                        }
                    }
                    catch(NumberFormatException inp){
                        System.out.println("Wrong input:");
                        System.out.println("Please try again with an Integer");
                    }
                }
                System.out.println("Enter the Player Name");
                String name=scan.next();
                while(!name.matches("[a-zA-Z]+")){
                    name = scan.nextLine();
                    System.out.println("Please enter a valid name!");
                }
                game g = new game(name,lot);
                g.create_track();
                g.game_begin();

            }
        }
    }
}