/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import rekoffer.services.DatabaseFunctions;

/**
 *
 * @author Damon
 */
public class LoginController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException{
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        ResultSet result = null;

        
        try 
        {
            result = DatabaseFunctions.getUser();
            if(!result.isBeforeFirst())
            {
                System.out.println("Kinda empty");
            }
            else
            { 
                while(result.next())
                {
                    System.out.println(result.getString(1));
                    System.out.println(result.getString(2));
                    System.out.println(result.getString(3));
                }
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        finally
        {
            DatabaseFunctions.disconnect();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
