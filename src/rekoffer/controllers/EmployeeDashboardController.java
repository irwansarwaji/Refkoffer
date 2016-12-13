/*
 * employee dashboard 
 * employee can submit baggage 
 * employee can search baggage
 */
package rekoffer.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import rekoffer.models.Baggage;
import rekoffer.services.DatabaseFunctions;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static rekoffer.services.DatabaseFunctions.disconnect;
import rekoffer.services.Session;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author Damon
 */
public class EmployeeDashboardController implements Initializable {

    boolean savedBaggage;
    ViewSwitcher switcher = new ViewSwitcher();
    List<Baggage> baggageList = new ArrayList<Baggage>();
    
    @FXML
    private TableColumn<?, ?> firstname;
    @FXML
    private TableColumn<?, ?> lastname;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> suitcaselabel;
    @FXML
    private TableColumn<?, ?> suitcasetype;
    @FXML
    private TableColumn<?, ?> suitcasebrand;
    @FXML
    private TableColumn<?, ?> suitcasecolor;
    @FXML
    private TableColumn<?, ?> status;

    @FXML
    public Label user_name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /**
         * shows the user
         */
        user_name.setText(Session.getSessionUser().getFirstName() + ", " + Session.getSessionUser().getLastName());

    }

    
    /**
     * button that takes you to the next screen
     * @param event
     * @throws SQLException
     * @throws IOException 
     */
    @FXML
    private void searchAction(ActionEvent event) throws SQLException, IOException {

        //switcher.switchView("employee/RegisterLost.fxml", event);
        ResultSet rs = DatabaseFunctions.getAllBaggage();
        
        

        while (rs.next()) {
            System.out.println(rs.getString("first_name")
                    + rs.getString("last_name") + rs.getString("first_name"));
            
           /*Baggage baggage = new Baggage(rs.getInt("id"), rs.getString("suitcase_label"), 
            rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), 
            rs.getString("zip"), rs.getString("country"), rs.getString("phone"), rs.getString("email"),
            rs.getInt("suitcase_type"), rs.getString("suitcase_brand"), rs.getString("suitcase_color"),
            rs.getString("suitcase_other"), rs.getString("suitcase_image"), rs.getString("suitcase_notes"), 
            rs.getString("airport_site"), rs.getString("airport_origin"), rs.getString("additional_contact_info"));
            
            baggageList.add(baggage);
            baggageList.get(0).getFirstName();
            baggageList.get(1).getLastName();
            baggageList.get(2).getLabel();
            baggageList.get(3).getSuitcaseType();
            baggageList.get(4).getSuitcaseBrand();
            baggageList.get(5).getSuitcaseColor();
            baggageList.get(6).getSuitcaseType(); */

        }
    }
    
    void setSavedStatus(boolean savedBaggage)
    {
        this.savedBaggage = savedBaggage;
    }

    /**
     * log out button
     * @param event
     * @throws SQLException
     * @throws IOException 
     */
    @FXML
    private void logoutButton(ActionEvent event) throws SQLException, IOException {
        disconnect();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("Login.fxml", event);
    }
    
    @FXML
    private void registerAction(ActionEvent event) throws SQLException, IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("employee/RegisterLost.fxml", event);
    }
    
    @FXML
    private void refreshAction(ActionEvent event) throws SQLException, IOException {
        System.out.println("Refresh kappa123");
    }

}
