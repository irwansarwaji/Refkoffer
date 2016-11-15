/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rekoffer.services.DatabaseFunctions;
import static rekoffer.services.Authenticate.*;
import rekoffer.views.ViewSwitcher;

/**
 *
 * @author Damon
 */
public class LoginController implements Initializable {

    @FXML
    public AnchorPane AnchorPane;
    public Label error_message;
    public TextField user_email;
    public PasswordField user_password;

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {
        ResultSet result = null;
        //Instatiate a new ViewSwitcher
        ViewSwitcher switcher = new ViewSwitcher();
        //Check if user input is empty
        if (!user_email.getText().equals("") && !user_password.getText().equals("")) {
            String mEmail = user_email.getText();
            String mPassword = user_password.getText();
            try {
                //Get the user from the database
                result = DatabaseFunctions.getUserByEmail(mEmail);
                if (!result.isBeforeFirst()) {
                    //No user exists with the email from user input
                    error_message.setText("Oops, something went wrong. Try again please");
                } else {
                    result.first();
                    //Check if user password is correct
                    if (authenticateUser(mPassword, result.getString("password"))) {
                        System.out.println("Correct password");
                        //Get our stage
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        //Send user to another view
                        switcher.switchView("manager/Dashboard.fxml", stage);

                    } else {
                        //Password is incorrect
                        error_message.setText("Oops, something went wrong. Try again please");
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                //When login attempt is finished. Close the connection to the database
                DatabaseFunctions.disconnect();
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
