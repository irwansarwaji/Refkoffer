/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rekoffer.services.DatabaseFunctions;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author wyomi
 */
public class RemoveBaggageController implements Initializable {

    ViewSwitcher switcher = new ViewSwitcher();

    @FXML
    public TextField Label;
    public TextField confirmLabel;
    public Label warningLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("employee/Dashboard.fxml", event);
    }

    @FXML
    private void logoutButton(ActionEvent event) throws SQLException, IOException {
        DatabaseFunctions.disconnect();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("Login.fxml", event);
    }

    @FXML
    private void removeButton(ActionEvent event) throws SQLException, IOException {
        if (Label.getText() == null || Label.getText().trim().isEmpty() || confirmLabel.getText() == null || confirmLabel.getText().trim().isEmpty()) {
            //one of the textfields are empty
            warningLabel.setText("Textfield is empty!");
        } else if (Label.getText().equals(confirmLabel.getText())) {
            //labels match. Enter info in database
            DatabaseFunctions.removeBaggage(Label.getText());
            warningLabel.setText("Baggage is removed!");
        } else {
            //labels dont match
            warningLabel.setText("Labels don't match. Please try again.");
        }

    }
}
