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
import javafx.scene.input.MouseEvent;
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
    ArrayList<Army> armyHolderMain =new ArrayList<Army>();
    @FXML
    private ListView<String> lstArmy;

    @FXML
    private ListView<String> lstArmyUnits;

    @FXML
    private ListView<String> lstUnits;

    @FXML
    private Button btnNewArmy;

    @FXML
    private Button btnNewUnit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ////System.out.println("starting");
//


    }

    @FXML
    void newArmyClicked(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/armyCreator.fxml"));
        Parent root = loader.load();

        Scene Stage = new Scene(root);

        //access the controller and call a method
        armyController controller = loader.getController();
        controller.initData(unitHolderMain,armyHolderMain);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Stage);
        window.show();

//        Parent root = FXMLLoader.load(getClass().getResource("../views/armyCreator.fxml"));
//        Scene scene = new Scene(root);
//
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.setTitle("Warhammer Dashboard");
//        stage.show();
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

    @FXML
    void armySelectedClick(MouseEvent event) {
        lstArmyUnits.getItems().clear();
        if (lstArmy.getSelectionModel().getSelectedIndex() >=0){
            ////System.out.println("Displaying unit roster");

            Army army = armyHolderMain.get(lstArmy.getSelectionModel().getSelectedIndex());

            ////System.out.println(army.getName());
            ////System.out.println(army.getRoster().size());
            ////System.out.println(army.getRoster());

            for (int i= 0; i <army.getRoster().size(); i++){
                ////System.out.println("in loop");
                Unit unit = army.getRoster().get(i);
                lstArmyUnits.getItems().addAll(unit.getName());
            }
        }

    }

    public void initData(ArrayList<Unit> unitHolder,ArrayList<Army> armyHolder) {
        //System.out.println(armyHolder);
        unitHolderMain.addAll(unitHolder);
        ////System.out.println("Loading Unit");
        for(int i = 0; i < unitHolderMain.size();i++){
            Unit unit = (Unit) unitHolderMain.get(i);
            ////System.out.println(unit.getName());
            lstUnits.getItems().addAll(unit.getName());
        }

        armyHolderMain.addAll(armyHolder);
        ////System.out.println("Loading Army");
        ////System.out.println(armyHolderMain);
        for(int i = 0; i < armyHolderMain.size();i++){
            Army army = (Army) armyHolderMain.get(i);
            ////System.out.println(army.getName());
            lstArmy.getItems().addAll(army.getName());
        }


        ////System.out.println();
    }
}
