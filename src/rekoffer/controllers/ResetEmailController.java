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
 * @author jacco
 */
public class ResetEmailController implements Initializable {

    @FXML
    public TextField emailAddress;
    public Label warningLabel;
    public TextField newMail;
    public TextField confirmMail;

    ViewSwitcher switcher = new ViewSwitcher();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void saveButton(ActionEvent event) throws SQLException {

        if (emailAddress.getText() == null || emailAddress.getText().trim().isEmpty()) {
            warningLabel.setText("Old mailaddress is empty!");
        } else if (newMail.getText() == null || newMail.getText().trim().isEmpty() || confirmMail.getText() == null || confirmMail.getText().trim().isEmpty()) {
            //one of the new email fields are empty
            warningLabel.setText("New mailaddress is empty!");
        } else if (emailAddress.getText() == null || emailAddress.getText().trim().isEmpty()) {
            warningLabel.setText("Emailaddress is empty!");
        } else if (newMail.getText().equals(confirmMail.getText())) {
            //email addresses match, enter info in database
            DatabaseFunctions.setNewEmailByEmail(emailAddress.getText(), newMail.getText());
            warningLabel.setText("Email is changed!");
        } else {
            //new emailaddresses don't match
            warningLabel.setText("New emails don't match, please try again.");
        }
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("manager/Dashboard.fxml", event);
    }

    @FXML
    private void logoutButton(ActionEvent event) throws IOException, SQLException {
        DatabaseFunctions.disconnect();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("Login.fxml", event);
    }

}
