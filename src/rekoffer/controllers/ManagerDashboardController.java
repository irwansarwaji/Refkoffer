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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import rekoffer.models.User;
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
    public ListView userlist;
    
    //Dit is geen user object list maar een makkelijke manier voor nu
    public ObservableList<User> employees = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fillUserList();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    //switch view naar gebruiker aanmaakscherm
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("manager/NewUser.fxml", event);
    }

    //disconnecten van de database en teruggaan naar het inlogscherm
    @FXML
    private void logoutButton(ActionEvent event) throws SQLException, IOException {
        DatabaseFunctions.disconnect();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("Login.fxml", event);
    }
    
    //Switch view naar user password resetting
    @FXML
    private void resetPasswordButton(ActionEvent event) throws SQLException, IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("manager/ResetUserpassword.fxml", event);
    }
    
        //switch terug naar het vorige scherm
    @FXML
    private void statsOverview(ActionEvent event) throws SQLException, IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("manager/stats.fxml", event);
    }
    
    //Fills the existing userlist (listview) with all employees from the database
    private void fillUserList() throws SQLException
    {
       ResultSet result =  DatabaseFunctions.getAllUsers();
       while(result.next())
       {
           //Ik maak er nu een lange lelijke string van voor het laten zien.
           //Dit kan natuurlijk een mooie printF worden en misschien kan je er een mooi tabel van maken met headers boven aan om aantegeven dat het over een telefoonnummer gaat bijvoorbeeld
           //Dit laat alleen medewerkers zien, geen manager accounts.
           User employee = new User(result.getInt("id"), result.getString("email"),result.getString("first_name"), result.getString("last_name"), result.getString("phone"), result.getInt("type"));
           employees.add(employee);
       }
       
        userlist.setItems(employees);
    }

}
