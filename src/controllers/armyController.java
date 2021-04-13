package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    //Array list holding data that is used in application
    ArrayList<Unit> unitHolder = new ArrayList<Unit>();
    ArrayList<Army> armyHolder = new ArrayList<Army>();
    ArrayList<Unit> armyUnit = new ArrayList<Unit>();

    /***
     * Clears certain arrays and listviews
     */
    public void clear(){
        armyUnit.clear();
        lblRoster.getItems().clear();
    }
    @FXML
    private Label lblError;

    /***
     * When user clicks clear button, clear all info
     * @param event
     */
    @FXML
    void btnClearClicked(ActionEvent event) {
        clear();
    }

    /***
     * Start of Scene, populates alliance listview
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lstAlliance.getItems().addAll("Order","Chaos","Death","Destruction");
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
    private Button btnClear;

    @FXML
    private Button btndashboard;
    @FXML
    private Button btnCreateArmy;

    @FXML
    private ListView<String> lblRoster;

    @FXML
    private ListView<String> lstAlliance;

    /***
     * Adds selected unit into the army roster, and moves it to the army roster listview
     * @param event
     */
    @FXML
    void addUnitClicked(ActionEvent event) {



            armyUnit.add(unitHolder.get(lblArmyUnitList.getSelectionModel().getSelectedIndex())); //adds based of listview Index
            lblRoster.getItems().clear();
        try {
            for (int i = 0; i < armyUnit.size(); i++) {
                Unit unitRoster = (Unit) armyUnit.get(i);
                System.out.println(unitRoster.getName());
                lblRoster.getItems().addAll(unitRoster.getName());
            }
        }catch (IllegalArgumentException e){
            lblError.setText("No Unit Selected");
        }

    }

    /***
     * Returns to dashboard
     * @param event
     * @throws IOException
     */
    @FXML
    void bttnDashboardClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/dashboard.fxml"));
        Parent root = loader.load();

        Scene Stage = new Scene(root);

        DashboardController controller = loader.getController();


        controller.initData(unitHolder,armyHolder);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Stage);
        window.show();
    }

    /***
     * creates the army, and then brigns user back to dashboard
     * @param event
     * @throws IOException
     */
    @FXML
    void createArmyClicked(ActionEvent event) throws IOException {

        try{ //if possible, make army
        armyHolder.add(new Army(txtArmyName.getText(),lstAlliance.getSelectionModel().getSelectedItem(),armyUnit ));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/dashboard.fxml"));
        Parent root = loader.load();

        Scene Stage = new Scene(root);


        DashboardController controller = loader.getController();


        controller.initData(unitHolder,armyHolder);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Stage);
        window.show();
        }catch (IllegalArgumentException e){ //if error in army creation
            lblError.setText(e.getMessage());
        }
    }


    /***
     * Data recived from other forms
     * @param unitHolderMain
     * @param armyHolderMain
     */
    public void initData(ArrayList<Unit> unitHolderMain, ArrayList<Army> armyHolderMain) {
        unitHolder.addAll(unitHolderMain);
        for(int i = 0; i < unitHolderMain.size();i++){
            Unit unit = (Unit) unitHolderMain.get(i);

            lblArmyUnitList.getItems().addAll(unit.getName());
        }

        armyHolder.addAll(armyHolderMain);

    }
}
