import java.util.Scanner;

public class Leprechaun extends NPC{
    public Leprechaun(Scanner s){
        super(s);
        health = 50;
        mana = 100;
        lives = 1;
    }

    public Leprechaun(int i, String s, String d){
        super(i, s, d);
        health = 1000;
        mana = 100;
        lives = 5;
    }
/*
    protected void lifeCheck(){
        lives--;
        health = 50;
        mana = 100;
    }

    public void cast(String spell, Place p){
        System.out.println("  ... nothing happened ... ");
    }
*/
}