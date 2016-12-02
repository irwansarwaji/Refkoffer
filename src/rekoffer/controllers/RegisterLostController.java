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
import rekoffer.services.Session;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author damon
 */
public class RegisterLostController implements Initializable {

    @FXML
    public Label user_name;
    ViewSwitcher switcher = new ViewSwitcher();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        user_name.setText(Session.getSessionUser().getFirstName() + ", " + Session.getSessionUser().getLastName());

    }
        @FXML
        private void backButton
        (ActionEvent event) throws SQLException, IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            switcher.switchView("employee/Dashboard.fxml", event);
        }
    }
