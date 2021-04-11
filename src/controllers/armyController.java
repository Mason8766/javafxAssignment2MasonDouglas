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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Army;
import models.Unit;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class armyController  implements Initializable {
    ArrayList<Unit> unitHolder = new ArrayList<Unit>();
    ArrayList<Army> armyHolder = new ArrayList<Army>();
    ArrayList<Unit> armyUnit = new ArrayList<Unit>();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lstAlliance.getItems().addAll("Order","Chaos","Death","Destruction");






        //for each member of the array, insert it into the list view
        for(int i = 0; i < unitHolder.size();i++){
            Unit unit = (Unit) unitHolder.get(i);
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
    private Button btnCreateArmy;

    @FXML
    private ListView<String> lblRoster;

    @FXML
    private ListView<String> lstAlliance;

    @FXML
    void addUnitClicked(ActionEvent event) {
        armyUnit.add(unitHolder.get(lblArmyUnitList.getSelectionModel().getSelectedIndex()));
        //System.out.println(lblArmyUnitList.getSelectionModel().getSelectedIndex());
//        roster.add(unitHolder.get(lblArmyUnitList.getSelectionModel().getSelectedIndex()));
        lblRoster.getItems().clear();
        for(int i = 0; i < armyUnit.size();i++){
            Unit unitRoster = (Unit) armyUnit.get(i);
            System.out.println(unitRoster.getName());
            lblRoster.getItems().addAll(unitRoster.getName());
        }

    }
    @FXML
    void createArmyClicked(ActionEvent event) throws IOException {


        armyHolder.add(new Army(txtArmyName.getText(),lstAlliance.getSelectionModel().getSelectedItem(),armyUnit ));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/dashboard.fxml"));
        Parent root = loader.load();

        Scene Stage = new Scene(root);

        //access the controller and call a method
        DashboardController controller = loader.getController();


        controller.initData(unitHolder,armyHolder);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Stage);
        window.show();
    }



    public void initData(ArrayList<Unit> unitHolderMain, ArrayList<Army> armyHolderMain) {
        unitHolder.addAll(unitHolderMain);
        for(int i = 0; i < unitHolderMain.size();i++){
            Unit unit = (Unit) unitHolderMain.get(i);
            //System.out.println(unit.getName());
            lblArmyUnitList.getItems().addAll(unit.getName());
        }

        armyHolder.addAll(armyHolderMain);

    }
}
