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
import models.Unit;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UnitController implements Initializable {
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
        Parent root = FXMLLoader.load(getClass().getResource("../views/dashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Warhammer Dashboard");
        stage.show();
    }

    @FXML
    void keywordClicked(ActionEvent event) {

    }

    @FXML
    void newUnitClicked(ActionEvent event) {

    }
}
