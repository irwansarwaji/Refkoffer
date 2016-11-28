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
import rekoffer.models.User;
import rekoffer.services.DatabaseFunctions;
import static rekoffer.services.Authenticate.*;
import rekoffer.services.Session;
import rekoffer.views.ViewSwitcher;

/**
 *
 * @author Damon
 */
public class LoginController implements Initializable {

    public User loginUser;

    @FXML
    public AnchorPane AnchorPane;
    public Label error_message;
    public TextField user_email;
    public PasswordField user_password;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
        String mEmail = user_email.getText();
        String mPassword = user_password.getText();

        //Authenticate user
        if (checkInputAndAuthenticate(mEmail, mPassword)) {

            //Start user session
            Session.setSessionUser(loginUser);

            //Get the stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            //Send user to another view
            ViewSwitcher switcher = new ViewSwitcher();
            switcher.switchView("manager/Dashboard.fxml", stage);

        }
    }

    private boolean checkInputAndAuthenticate(String mEmail, String mPassword) throws SQLException {
        ResultSet result = null;

        //Check if user input is empty
        if (!user_email.getText().equals("") && !user_password.getText().equals("")) {
            try {
                //Get the user from the database
                result = DatabaseFunctions.getUserByEmail(mEmail);
                if (!result.isBeforeFirst()) {
                    //No user exists with the email from user input
                    return false;
                } else {
                    result.first();
                    //Check if user password is correct
                    if (authenticateUser(mPassword, result.getString("password"))) {
                        
                        //The User that is accessable by all methods of this class is set
                        loginUser = new User(result.getInt("id"), 
                                            result.getString("email"), 
                                            result.getString("first_name"), 
                                            result.getString("last_name"), 
                                            result.getString("phone"), 
                                            result.getInt("type"));
                        return true;
                    } else {
                        //Password is incorrect
                        return false;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            } finally {
                //When login attempt is finished. Close the connection to the database
                DatabaseFunctions.disconnect();
                System.out.println("Disconnect");
            }
        }
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
