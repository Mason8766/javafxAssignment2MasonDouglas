package controllers;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Army;
import models.Unit;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;


public class DashboardController implements Initializable{
    ArrayList<Unit> unitHolderMain =new ArrayList<Unit>();
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
//        ArrayList<String> keywords = new ArrayList<String>();
//        keywords.add("Chaos");
//        keywords.add("Skaven");
//        keywords.add("Clan Verminous");
//        Unit clanrat = new Unit("Clanrat",6,1,5,"Rusty Spear",keywords,6);
//        Unit stormvermin = new Unit("stormvermin",6,1,4,"Rusty Halberd",keywords,14);
//        keywords.removeAll(keywords);
//        keywords.add("Chaos");
//        keywords.add("Skaven");
//        keywords.add("Master Clan");
//        Unit greySeer = new Unit("greySeer",6,1,4,"Staff",keywords,120);
//
//        unitHolderMain.add(greySeer);
////
//        //list containing students hobbies
//        List Units = new ArrayList<Unit>();
//        Units.add(clanrat);
//        Units.add(stormvermin);
//        Units.add(greySeer);

        //list containing students hobbies
//        List Units = new ArrayList<String>();
//        Units.add(clanrat.getName());
//        Units.add(stormvermin.getName());
//        Units.add(greySeer.getName());


        //for each member of the array, insert it into the list view
        for(int i = 0; i < unitHolderMain.size();i++){
            Unit unit = (Unit) unitHolderMain.get(i);
            lstUnits.getItems().addAll(unit.getName());
        }


    }

    @FXML
    void newArmyClicked(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../views/armyCreator.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Warhammer Dashboard");
        stage.show();
    }
    @FXML
    private void newUnitClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/unitCreator.fxml"));
        Parent root = loader.load();

        Scene Stage = new Scene(root);

        //access the controller and call a method
        UnitController controller = loader.getController();
        controller.initData(unitHolderMain);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Stage);
        window.show();
//        Parent root = FXMLLoader.load(getClass().getResource("../views/unitCreator.fxml"));
//        Scene scene = new Scene(root);
//
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.setTitle("Warhammer Dashboard");
//        stage.show();

    }

    public void initData(ArrayList<Unit> unitHolder) {
        unitHolderMain.addAll(unitHolder);
        System.out.println("Loading");
        for(int i = 0; i < unitHolderMain.size();i++){
            Unit unit = (Unit) unitHolderMain.get(i);
            System.out.println(unit.getName());
            lstUnits.getItems().addAll(unit.getName());
        }

    }
}
