package models;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    Unit unit;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("Chaos");
        keywords.add("Skaven");
        keywords.add("Clan Verminous");
        unit = new Unit("Clanrat",6,1,5,"Rusty Spear",keywords,6);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }



    @org.junit.jupiter.api.Test
    void setName() {
        unit.setName("Clanrat");
        assertEquals("Clanrat", unit.getName());
    }
    @org.junit.jupiter.api.Test
    void setNameInvalid() {
        unit.setName("");
        assertEquals("", unit.getName());
    }

    @org.junit.jupiter.api.Test
    void setMovementSpeed() {
        unit.setMovementSpeed(6);
        assertEquals(6, unit.getMovementSpeed(),6);
    }
    @org.junit.jupiter.api.Test
    void setMovementSpeedInvalid() {
        unit.setMovementSpeed(-1);
        assertEquals(-1, unit.getMovementSpeed(),-1);
    }

    @org.junit.jupiter.api.Test
    void setWounds() {
        unit.setWounds(1);
        assertEquals(1, unit.getWounds(),1);
    }
    @org.junit.jupiter.api.Test
    void setWoundsInvalid() {
        unit.setWounds(-1);
        assertEquals(-1, unit.getWounds(),-1);
    }

    @org.junit.jupiter.api.Test
    void setSave() {
        unit.setSave(5);
        assertEquals(5, unit.getSave(),5);
    }
    @org.junit.jupiter.api.Test
    void setSaveInvalid() {
        unit.setSave(-1);
        assertEquals(-1, unit.getSave(),-1);
    }

    @org.junit.jupiter.api.Test
    void setWeapon() {
        unit.setWeapon("Rusty Spear");
        assertEquals("Rusty Spear", unit.getWeapon());
    }
    @org.junit.jupiter.api.Test
    void setWeaponInvalid() {
        unit.setWeapon("");
        assertEquals("", unit.getWeapon());
    }

    @org.junit.jupiter.api.Test
    void setKeywords() {
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("Chaos");
        keywords.add("Skaven");
        keywords.add("Clan Verminous");

        unit.setKeywords(keywords);
        assertEquals(keywords, unit.getKeywords());
    }
    @org.junit.jupiter.api.Test
    void setKeywordsInvalid() {
        ArrayList<String> keywords = new ArrayList<String>();

        unit.setKeywords(keywords);
        assertEquals(keywords, unit.getKeywords());
    }

    @org.junit.jupiter.api.Test
    void setValue() {
        unit.setValue(6);
        assertEquals(6, unit.getValue(),6);
    }
    @org.junit.jupiter.api.Test
    void setValueInvalid() {
        unit.setValue(-1);
        assertEquals(-1, unit.getValue(),-1);
    }
    @org.junit.jupiter.api.Test
    private double pointCalculator(int numberOfModels) {
        pointCalculator(2);
        assertEquals(12, pointCalculator(2),12);
        return pointCalculator(2);
    }

}