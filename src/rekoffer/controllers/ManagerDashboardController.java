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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import rekoffer.services.DatabaseFunctions;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author Jacco Sierkstra
 */
public class ManagerDashboardController implements Initializable {

    ViewSwitcher switcher = new ViewSwitcher();
    @FXML
    public Label onlineUsers;
    public ListView email;
    public ListView firstName;
    public ListView lastName;
    public ListView phone;

    //Dit is geen user object list maar een makkelijke manier voor nu
    public ObservableList<String> emails = FXCollections.observableArrayList();
    public ObservableList<String> firstNames = FXCollections.observableArrayList();
    public ObservableList<String> lastNames = FXCollections.observableArrayList();
    public ObservableList<String> phones = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fillEmailList();
            fillFirstnameList();
            fillLastnameList();
            fillPhoneList();
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
    
    //switch view naar email reset scherm
    @FXML
    private void resetEmailButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("manager/ResetEmail.fxml", event);
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
    
    //Listview met emailadressen uit de database vullen
    private void fillEmailList() throws SQLException {
        ResultSet result = DatabaseFunctions.getAllEmails();
        while (result.next()) {

            emails.add(result.getString("email"));
        }

        email.setItems(emails);
    }

    //Listview met firstNames uit de database vullen
    private void fillFirstnameList() throws SQLException {
        ResultSet result = DatabaseFunctions.getAllFirstnames();
        while (result.next()) {

            firstNames.add(result.getString("first_name"));
        }

        firstName.setItems(firstNames);
    }

    //Listview met lastNames uit de database vullen
    private void fillLastnameList() throws SQLException {
        ResultSet result = DatabaseFunctions.getAllLastnames();
        while (result.next()) {

            lastNames.add(result.getString("last_name"));
        }

        lastName.setItems(lastNames);
    }

    //Listview met telefoonnummers uit de database vullen
    private void fillPhoneList() throws SQLException {
        ResultSet result = DatabaseFunctions.getAllPhonenumbers();
        while (result.next()) {

            phones.add(result.getString("phone"));
        }

        phone.setItems(phones);
    }

}
