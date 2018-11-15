import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Arrays;

import static java.lang.Math.abs;

public class Place {
    protected int id;
    protected String name;
    protected String description;
    protected static Place start;
    protected static HashMap<Integer, Place> places = new HashMap<Integer, Place>();
    protected ArrayList<Direction> directions = new ArrayList<Direction>();
    protected ArrayList<Character> characters = new ArrayList<>();
    protected ArrayList<Artifact> artifacts = new ArrayList<>();

    public Place(int id, String name, String description) {
        this.id = abs(id);
        this.name = name;
        this.description = description;
        if (places.isEmpty()) {
            start = this;
        }
        places.put(this.id, this);
        // System.out.println(id);
    }

    public static Place getStart(){
        return start;
    }

    public static Place getPlaceById(int id){
        return places.get(id);
    }

    public void addDirection(Direction d){
        directions.add(d);
    }

    public Place followDirection(String s){
        for (Direction d : directions){
            if (d.match(s)){
                try {
                    return d.follow(s);
                } catch (Direction.LockedDirectionException e){
                    return this;
                }
            }
        }
        return this;
    }

    public void addCharacter(Character c){
        characters.add(c);
    }

    public void removeCharacter(Character c){
        characters.remove(c);
    }

    public void addArtifact(Artifact a){
        artifacts.add(a);
    }

    public void removeArtifact(Artifact a){
        artifacts.remove(a);
    }

    public boolean isExit(){
        return id == 1;
    }

    public void display(){
        System.out.println(name);
        System.out.println(description);
        System.out.println("You see:");
        for (Artifact a : artifacts){
            a.print();
        }
    }

    public void useKey(Artifact a, Character c){
        for (Direction d : directions){
            d.useKey(a, c);
        }
    }

    public boolean hasArtifact(String s){
        for (Artifact a : artifacts){
            if (a.name().matches("(?i)" + s)){
                return true;
            }
        }
        return false;
    }

    public Artifact popItem(String s){
        for (Artifact a : artifacts){
            if (a.name().matches("(?i)" + s)){
                Artifact r = a;
                artifacts.remove(a);
                return r;
            }
        }
        return null;
    }

    public String name(){ return name; }

    public static int getRandomPlaceID(){
        ArrayList<Integer> p = new ArrayList<Integer>( places.keySet() );
        p.remove(0);
        p.remove(1);
        Collections.shuffle(p);
        return p.get(0);
    }
}