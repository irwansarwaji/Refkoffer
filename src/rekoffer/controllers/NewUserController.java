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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rekoffer.services.DatabaseFunctions;
import rekoffer.views.ViewSwitcher;
import rekoffer.services.DatabaseFunctions;

/**
 * FXML Controller class
 *
 * @author jacco
 */
public class NewUserController implements Initializable {

    ViewSwitcher switcher = new ViewSwitcher();
    public TextField emailAddress;
    public PasswordField password;
    public PasswordField repeatPassword;
    public Label wrongPassword;

    /**
     * initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //Savebutton action voor het opslaan van de ingevoerde informatie
    @FXML
    private void saveButton(ActionEvent event) throws SQLException, IOException {
        if (password.getText() == null || password.getText().trim().isEmpty() || repeatPassword.getText() == null || repeatPassword.getText().trim().isEmpty()) {
            //one of the password fields are empty
            wrongPassword.setText("Password is empty!");
        } else if (emailAddress.getText() == null || emailAddress.getText().trim().isEmpty()) {
            wrongPassword.setText("Emailaddress is empty!");
        } else if (password.getText().equals(repeatPassword.getText())) {
            //passwords match. Enter info in database
            DatabaseFunctions.createNewUser(emailAddress.getText(), password.getText(), repeatPassword.getText());
            wrongPassword.setText("New user saved!");
        } else {
            //passwords dont match
            wrongPassword.setText("Passwords don't match. Please try again.");
        }

    }

    @FXML
    private void backButton(ActionEvent event) throws SQLException, IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("manager/Dashboard.fxml", stage);
    }
    @FXML
    private void logoutButton(ActionEvent event) throws SQLException, IOException {
        DatabaseFunctions.disconnect();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("Login.fxml", stage);
    }
}
