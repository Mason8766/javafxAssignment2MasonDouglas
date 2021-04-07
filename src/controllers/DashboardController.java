package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.Army;
import models.Unit;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DashboardController implements Initializable{

    @FXML
    private ListView<Army> lstArmy;

    @FXML
    private ListView<Army> lstArmyUnits;

    @FXML
    private ListView<String> lstUnits;

    @FXML
    private Button btnNewArmy;

    @FXML
    private Button btnNewUnit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("starting");
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("Chaos");
        keywords.add("Skaven");
        keywords.add("Clan Verminous");
        Unit clanrat = new Unit("Clanrat",6,1,5,"Rusty Spear",keywords,6);
        Unit stormvermin = new Unit("stormvermin",6,1,4,"Rusty Halberd",keywords,14);
        keywords.removeAll(keywords);
        keywords.add("Chaos");
        keywords.add("Skaven");
        keywords.add("Master Clan");
        Unit greySeer = new Unit("greySeer",6,1,4,"Staff",keywords,120);


//
//        //list containing students hobbies
//        List Units = new ArrayList<Unit>();
//        Units.add(clanrat);
//        Units.add(stormvermin);
//        Units.add(greySeer);

        //list containing students hobbies
        List Units = new ArrayList<String>();
        Units.add(clanrat.getName());
        Units.add(stormvermin.getName());
        Units.add(greySeer.getName());


        //for each member of the array, insert it into the list view
        for(int i = 0; i < Units.size();i++){
            String unit = (Units.get(i).toString());
            System.out.println(unit);
            lstUnits.getItems().addAll(unit);
        }


    }
}
