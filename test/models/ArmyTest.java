package models;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    Unit unit;
    Army army;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("Chaos");
        keywords.add("Skaven");
        keywords.add("Clan Verminous");
        unit = new Unit("Clanrat",6,1,5,"Rusty Spear",keywords,6);

        ArrayList<Unit> roster = new ArrayList<Unit>();
        roster.add(unit);
        army= new Army("Skaven","Chaos",roster);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void sizeOfRoster() {
        assertEquals(1, army.sizeOfRoster());

    }
    @org.junit.jupiter.api.Test
    public String toString() {
        assertEquals("Skaven contain the following units: Clanrat", army.toString());

        return army.toString();
    }
    @org.junit.jupiter.api.Test
    void setName() {
        army.setName("Skaven");
        assertEquals("Skaven", army.getName());

    }
    @org.junit.jupiter.api.Test
    void setNameInvalid() {
        army.setName("");
        assertEquals("", army.getName());
    }

    @org.junit.jupiter.api.Test
    void setGrandAlliance() {
        army.setGrandAlliance("Chaos");
        assertEquals("Chaos", army.getGrandAlliance());
    }
    @org.junit.jupiter.api.Test
    void setGrandAllianceInvalid() {
        army.setGrandAlliance("BREAK");
        assertEquals("BREAK", army.getGrandAlliance());
    }

    @org.junit.jupiter.api.Test
    void setRoster() {
        ArrayList<Unit> roster = new ArrayList<Unit>();
        roster.add(unit);

        army.setRoster(roster);
        assertEquals(roster, army.getRoster());
    }
    @org.junit.jupiter.api.Test
    void setRosterInvalid() {
        ArrayList<Unit> roster = new ArrayList<Unit>();


        army.setRoster(roster);
        assertEquals(roster, army.getRoster());
    }
}