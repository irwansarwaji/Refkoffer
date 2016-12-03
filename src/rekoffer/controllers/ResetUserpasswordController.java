/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import rekoffer.services.DatabaseFunctions;
import rekoffer.views.ViewSwitcher;
import java.util.Collection;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jacco
 */
public class ResetUserpasswordController implements Initializable {

    public TextField emailAddress;
    public PasswordField password;
    public PasswordField repeatPassword;
    public Label warningLabel;
    ViewSwitcher switcher = new ViewSwitcher();
    
    //terug naar het vorige scherm
    @FXML
    private void backButton(ActionEvent event) throws SQLException, IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("manager/Dashboard.fxml", event);
    }

    //disconnecten van de database en teruggaan naar het inlogscherm
    @FXML
    private void logoutButton(ActionEvent event) throws SQLException, IOException {
        DatabaseFunctions.disconnect();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("Login.fxml", event);
    }

//    Alle ingevoerde data opslaan als het goed is ingevuld, anders de juiste
//    errormessages teruggeven
    @FXML
    private void saveButton(ActionEvent event) throws SQLException, IOException {
        if (password.getText() == null || password.getText().trim().isEmpty() || repeatPassword.getText() == null || repeatPassword.getText().trim().isEmpty()) {
            //one of the password fields are empty
            warningLabel.setText("Password is empty!");
        } else if (emailAddress.getText() == null || emailAddress.getText().trim().isEmpty()) {
            warningLabel.setText("Emailaddress is empty!");
        } else if (password.getText().equals(repeatPassword.getText())) {
            //passwords match. Enter info in database
            DatabaseFunctions.setNewPasswordByEmail(emailAddress.getText(), password.getText());
            warningLabel.setText("Password is changed!");
        } else {
            //passwords dont match
            warningLabel.setText("Passwords don't match. Please try again.");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
