package controllers;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    ArrayList<Unit> unitHolderMain =new ArrayList<Unit>(); //holds the list of ALL units for entire application
    ArrayList<Army> armyHolderMain =new ArrayList<Army>();//holds the list of all Armys for the entire application
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


    }

    @FXML
    private Label lblSize;

    @FXML
    private Label lblCost;

    @FXML
    private TextField txtNumberOfModels;

    @FXML
    private Button btnCalculate;

    /**
     * When Clicked, calculate the points of the selected unit, depending on amount of models
     * @param event
     */
    @FXML
    void CalculateClicked(ActionEvent event) {
        try {
            String models = txtNumberOfModels.getText();
            int numb = Integer.parseInt(models);
            Unit unit = unitHolderMain.get(lstUnits.getSelectionModel().getSelectedIndex());
            System.out.println(unit.getName());
            lblCost.setText("Cost of Unit: " + (Double.toString(unit.pointCalculator(numb))));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
    /***
     * When the user wishes to make a new army, open new Scene and pass data
     * @param event
     * @throws IOException
     */
    @FXML
    void newArmyClicked(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/armyCreator.fxml"));
        Parent root = loader.load();

        Scene Stage = new Scene(root);


        armyController controller = loader.getController();
        controller.initData(unitHolderMain,armyHolderMain); //data passing


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Stage);
        window.show();

    }

    /***
     * When the user wishes to make a new unit, opens new Scene and pass data
     * @param event
     * @throws IOException
     */
    @FXML
    private void newUnitClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/unitCreator.fxml"));
        Parent root = loader.load();

        Scene Stage = new Scene(root);

        UnitController controller = loader.getController();
        controller.initData(unitHolderMain);//data pass

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Stage);
        window.show();
    }

    /***
     * When a army is selected from the listview, display its units
     * @param event
     */
    @FXML
    void armySelectedClick(MouseEvent event) {
        lstArmyUnits.getItems().clear();
        if (lstArmy.getSelectionModel().getSelectedIndex() >=0){
            Army army = armyHolderMain.get(lstArmy.getSelectionModel().getSelectedIndex());
            lblSize.setText("#of Units: "+(Integer.toString(army.sizeOfRoster())));
            for (int i= 0; i <army.getRoster().size(); i++){
                Unit unit = army.getRoster().get(i);
                lstArmyUnits.getItems().addAll(unit.getName());
            }
        }

    }

    /***
     * Collects data from other forms and adds to main list
     * @param unitHolder
     * @param armyHolder
     */
    public void initData(ArrayList<Unit> unitHolder,ArrayList<Army> armyHolder) {
        //collects unit data
        unitHolderMain.addAll(unitHolder);
        for(int i = 0; i < unitHolderMain.size();i++){
            Unit unit = (Unit) unitHolderMain.get(i);
            lstUnits.getItems().addAll(unit.getName());//adds name to listview
        }
        //collects army data
        armyHolderMain.addAll(armyHolder);
        for(int i = 0; i < armyHolderMain.size();i++){
            Army army = (Army) armyHolderMain.get(i);
            lstArmy.getItems().addAll(army.getName());
        }



    }
}
