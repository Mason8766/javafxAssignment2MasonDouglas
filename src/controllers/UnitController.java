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

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UnitController implements Initializable {
    //list to hold inbound and outbound data
    ArrayList<Unit> unitHolder = new ArrayList<Unit>();
    ArrayList<Army> armyHolder = new ArrayList<Army>();

    /***
     * Clears textfeild and listviews
     */
    public void clear(){
        txtName.clear();
        txtMovementSpeed.clear();
        txtWounds.clear();
        txtSave.clear();
        txtWeapon.clear();
        lblKeywords.getItems().clear();
        txtValue.clear();
        txtKeyword.clear();
        lblError.setText("");
    }
    @FXML
    private TextField txtName;

    @FXML
    private Label lblError;
    @FXML
    private TextField txtMovementSpeed;

    @FXML
    private TextField txtWounds;

    @FXML
    private TextField txtSave;

    @FXML
    private TextField txtWeapon;

    @FXML
    private TextField txtValue;

    @FXML
    private TextField txtKeyword;

    @FXML
    private Button btnKeyword;

    @FXML
    private ListView<String> lblKeywords;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnCreateUnit;

    /**
     * Starts form
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> keywords = new ArrayList<String>();
    }

    /**
     * Returns user back to dashboard with data
     * @param event
     * @throws IOException
     */
    @FXML
    void dashboardClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/dashboard.fxml"));
        Parent root = loader.load();

        Scene Stage = new Scene(root);


        DashboardController controller = loader.getController();
        controller.initData(unitHolder,armyHolder);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Stage);
        window.show();
//
    }

    /**
     * Adds entered keywords to listview, and to keyword array
     * @param event
     */
    @FXML
    void keywordClicked(ActionEvent event) {
        lblKeywords.getItems().add(txtKeyword.getText());
    }

    /**
     * Creates a new unit of user input, then clears form
     * @param event
     */
    @FXML
    void newUnitClicked(ActionEvent event) {

        ArrayList<String> keywords = new ArrayList<String>();
        keywords.addAll(lblKeywords.getItems());
//
        try{//if possible to create unit
        Unit newUnit = new Unit(txtName.getText(), Integer.parseInt(txtMovementSpeed.getText()),Integer.parseInt(txtWounds.getText()),Integer.parseInt(txtSave.getText()),txtWeapon.getText(),keywords,Double.parseDouble(txtValue.getText()));
        unitHolder.add(newUnit);
        clear();//clears form
        }catch (IllegalArgumentException e){//error
            lblError.setText(e.getMessage());
        }
    }

    /**
     * Data from other forms
     * @param unitHolderMain
     */
    public void initData(ArrayList<Unit> unitHolderMain) {
        unitHolder.addAll(unitHolderMain);
        for(int i = 0; i < unitHolderMain.size();i++){
            Unit unit = (Unit) unitHolderMain.get(i);
            System.out.println(unit.getName());
        }
    }
    @FXML
    private Button btnClear;

    /**
     * when clicked, clears form
     * @param event
     */
    @FXML
    void btnClearClicked(ActionEvent event) {
        clear();
    }
}
