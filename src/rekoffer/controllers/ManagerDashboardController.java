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
import javafx.stage.Stage;
import rekoffer.services.DatabaseFunctions;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author Jacco
 */
public class ManagerDashboardController implements Initializable {
ViewSwitcher switcher = new ViewSwitcher();
    @FXML
    public Label onlineUsers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("manager/NewUser.fxml", stage);
    }

    @FXML
    private void logoutButton(ActionEvent event) throws SQLException, IOException {
        DatabaseFunctions.disconnect();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("Login.fxml", stage);
    }

}
