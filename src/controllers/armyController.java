package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Army;
import models.Unit;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class armyController  implements Initializable {


    List roster = new ArrayList<Unit>();
    List Units = new ArrayList<Unit>();

    public void clear(){
        txtArmyName.clear();
        lblRoster.getItems().clear();
        roster.clear();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lstAlliance.getItems().addAll("Order","Chaos","Death","Destruction");


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
        Units.add(clanrat);
        Units.add(stormvermin);
        Units.add(greySeer);
        //Unit test = (Unit) Units.get(0);

        //for each member of the array, insert it into the list view
        for(int i = 0; i < Units.size();i++){
            Unit unit = (Unit) Units.get(i);
            lblArmyUnitList.getItems().addAll(unit.getName());
        }

    }
    @FXML
    private TextField txtArmyName;

    @FXML
    private ListView<String> lblArmyUnitList;

    @FXML
    private Button btnAddUnit;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnCreateArmy;

    @FXML
    private ListView<String> lblRoster;

    @FXML
    private ListView<String> lstAlliance;

    @FXML
    void addUnitClicked(ActionEvent event) {
        System.out.println(lblArmyUnitList.getSelectionModel().getSelectedIndex());
        roster.add(Units.get(lblArmyUnitList.getSelectionModel().getSelectedIndex()));
        lblRoster.getItems().clear();
        for(int i = 0; i < roster.size();i++){
            Unit unitRoster = (Unit) roster.get(i);
            System.out.println(unitRoster.getName());
            lblRoster.getItems().addAll(unitRoster.getName());
        }

    }
    @FXML
    void createArmyClicked(ActionEvent event) {

        Army newArmy = new Army(txtArmyName.getText(),lstAlliance.getSelectionModel().getSelectedItem(), (ArrayList<Unit>) roster);
        System.out.println(newArmy.toString());
        clear();
    }

    @FXML
    void dashboardClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/dashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Warhammer Dashboard");
        stage.show();

    }
}
