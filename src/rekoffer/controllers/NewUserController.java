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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rekoffer.services.DatabaseFunctions;

/**
 * FXML Controller class
 *
 * @author jacco
 */
public class NewUserController implements Initializable {

    public TextField emailAddress;
    public PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
        @FXML
        private void saveButton(ActionEvent event) throws SQLException, IOException {
        DatabaseFunctions.createNewUser(emailAddress.getText(), password.getText());
    }
}
