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
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UnitController implements Initializable {
    ArrayList<Unit> unitHolder = new ArrayList<Unit>();
    ArrayList<Army> armyHolder = new ArrayList<Army>();
    public void clear(){
        txtName.clear();
        txtMovementSpeed.clear();
        txtWounds.clear();
        txtSave.clear();
        txtWeapon.clear();
        lblKeywords.getItems().clear();
        txtValue.clear();
        txtKeyword.clear();
    }
    @FXML
    private TextField txtName;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> keywords = new ArrayList<String>();
    }
    @FXML
    void dashboardClicked(ActionEvent event) throws IOException {
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
//        Parent root = FXMLLoader.load(getClass().getResource("../views/dashboard.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.setTitle("Warhammer Dashboard");
//        stage.show();
    }

    @FXML
    void keywordClicked(ActionEvent event) {
        lblKeywords.getItems().add(txtKeyword.getText());
    }


    @FXML
    void newUnitClicked(ActionEvent event) {
        System.out.println("Clicked");
        String name = txtName.getText();
        int movementSpeed= Integer.parseInt(txtMovementSpeed.getText());
        int wounds = Integer.parseInt(txtWounds.getText());
        int save = Integer.parseInt(txtSave.getText());
        String weapon = txtWeapon.getText();
        double value= Double.parseDouble(txtValue.getText());

        ArrayList<String> keywords = new ArrayList<String>();
        keywords.addAll(lblKeywords.getItems());
//        for(int i = 0; i < lblKeywords.getItems().size();i++){
//            String keyword = (lblKeywords.getItems(i).toString());
//            keywords.add(keyword);
//        }

        Unit newUnit = new Unit(name,movementSpeed,wounds,save,weapon,keywords,value);

        System.out.println(newUnit.getName());
        System.out.println(newUnit.getMovementSpeed());
        System.out.println(newUnit.getKeywords());
        unitHolder.add(newUnit);
        clear();
    }

    public void initData(ArrayList<Unit> unitHolderMain) {
        unitHolder.addAll(unitHolderMain);
        for(int i = 0; i < unitHolderMain.size();i++){
            Unit unit = (Unit) unitHolderMain.get(i);
            System.out.println(unit.getName());
        }
    }
}
