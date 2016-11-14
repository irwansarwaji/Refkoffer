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
        ViewSwitcher switcher = new ViewSwitcher();
       
        if (!user_email.getText().equals("") && !user_password.getText().equals("")) {
            String mEmail = user_email.getText();
            String mPassword = user_password.getText();
            try {
                result = DatabaseFunctions.getUserByEmail(mEmail);
                if (!result.isBeforeFirst()) {
                     error_message.setText("Oops, something went wrong. Try again please");
                } else {
                    result.first();
                    if(authenticateUser(mPassword,result.getString("password")))
                    {
                        System.out.println("Correct password");
                        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        switcher.switchView("manager/Dashboard.fxml", stage);

                    }
                    else
                    {
                        error_message.setText("Oops, something went wrong. Try again please");
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                DatabaseFunctions.disconnect();
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
