package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Army {
    private String name;
    private String grandAlliance;
    private ArrayList<Unit> roster;

    /**
     * Constructor
     * @param name
     * @param grandAlliance
     * @param roster
     */
    public Army(String name, String grandAlliance, ArrayList<Unit> roster) {
        setGrandAlliance(grandAlliance);
        setName(name);
        setRoster(roster);
    }

    /**
     * Returns a string version of army, and roster
     * @return
     */
    public String toString(){
        String print;
        print = name+" contain the following units: ";
        for(Unit unit: roster){
            print += unit.getName()+", ";
        }
        print = print.substring(0,print.length()-2);
        return print;
    }

    /***
     * Returns the amount of units in the armys roster
     * @return
     */
    public int sizeOfRoster(){
        return roster.size();
    }

    /***
     * Validates if the user entered a valid alliance for this army
     * @return
     */
    private List<String> validAlliance(){
        return Arrays.asList("Order","Death","Chaos","Destruction");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if (name.length()>0){
            this.name = name;
        }else
            throw new IllegalArgumentException("army name must be at least 1 characters long");
    }

    public String getGrandAlliance() {
        return grandAlliance;
    }

    public void setGrandAlliance(String grandAlliance) {
        grandAlliance = grandAlliance.trim();
        if(validAlliance().contains(grandAlliance)){
            this.grandAlliance = grandAlliance;
        }else{
            throw new IllegalArgumentException(grandAlliance + " was entered, valid Alliances are: "+validAlliance());
        }
    }

    public ArrayList<Unit> getRoster() {
        return roster;
    }

    public void setRoster(ArrayList<Unit> roster) {
        if(roster.isEmpty())
            throw new IllegalArgumentException("you must have at least 1 unit");
        else
            this.roster  = roster;
    }
}
