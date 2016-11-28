/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import rekoffer.services.Session;

/**
 * FXML Controller class
 *
 * @author damon
 */
public class RegisterLostController implements Initializable {

    @FXML
    public Label user_name;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        user_name.setText(Session.getSessionUser().getFirstName() + ", " + Session.getSessionUser().getLastName());
    }    
    
}
