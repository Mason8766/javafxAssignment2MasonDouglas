package models;

import java.awt.*;
import java.util.ArrayList;

public class Unit {
    private String name;
    private int movementSpeed;
    private  int wounds;
    private int save;
    private String weapon;
    private ArrayList<String> keywords;
    private double value;



    public Unit(String name, int movementSpeed, int wounds, int save, String weapon, ArrayList<String> keywords, double value) {
        setName(name);
        setMovementSpeed(movementSpeed);
        setWounds(wounds);
        setSave(save);
        setWeapon(weapon);
        setKeywords(keywords);
        setValue(value);

    }

    public double pointCalculator(int numberOfModels){
        return numberOfModels*value;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if (name.length()>0){
            this.name = name;
        }else
            throw new IllegalArgumentException("name must be at least 1 characters long");
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        if (movementSpeed >0){
            this.movementSpeed = movementSpeed;
        }else
            throw new IllegalArgumentException("movement speed must be greater than 0");

    }

    public int getWounds() {
        return wounds;
    }

    public void setWounds(int wounds) {
        if (wounds >0){
            this.wounds = wounds;
        }else
            throw new IllegalArgumentException("wounds must be greater than 0");

    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        if (save >0){
            this.save = save;
        }else
            throw new IllegalArgumentException("save value must be greater than 0");
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        weapon = weapon.trim();
        if (weapon.length()>0){
            this.weapon = weapon;
        }else
            throw new IllegalArgumentException("Weapon must be at least 1 characters long");
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        if(keywords.isEmpty())
            throw new IllegalArgumentException("you must have at least 1 keyword");
        else
            this.keywords  = keywords;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value >0){
            this.value = value;
        }else
            throw new IllegalArgumentException("unit value must be greater than 0");
    }



}
