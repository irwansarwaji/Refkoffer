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
import rekoffer.services.Session;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author wyomi beuker
 */
public class RemoveBaggageController implements Initializable {

    ViewSwitcher switcher = new ViewSwitcher();

    @FXML
    public TextField Label, confirmLabel;
    public Label warningLabel, user_name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //zet de naam en achternaam van de gebruiker boven in het scherm
        user_name.setText(Session.getSessionUser().getFirstName() + ", " + Session.getSessionUser().getLastName());

    }

    //deze knop brengt je terug naar het employee dashboard
    @FXML
    private void backButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("employee/Dashboard.fxml", event);
    }

    //deze knop logt je uit en brengt je terug naar het inlog scherm
    @FXML
    private void logoutButton(ActionEvent event) throws SQLException, IOException {
        DatabaseFunctions.disconnect();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("Login.fxml", event);
    }

    /*kijkt of de input gelijk is. zo ja word de baggage verwijderd.
      anders word om nieuwe input gevraagt.
    */
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
