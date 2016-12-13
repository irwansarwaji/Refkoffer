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
import javafx.stage.Stage;
import rekoffer.models.Baggage;
import rekoffer.services.DatabaseFunctions;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {

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
}
