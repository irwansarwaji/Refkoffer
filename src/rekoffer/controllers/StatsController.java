/**
 * Controller voor de stats view
 *
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
import javafx.fxml.Initializable;
import rekoffer.services.DatabaseFunctions;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author Mohamed El Hallaoui
 */
public class StatsController implements Initializable {

    /**
     * Switches view from stats to managerdashboard
     * @param event
     * @throws IOException 
     */
    @FXML
    private void returnDashboard(ActionEvent event) throws IOException {
        ViewSwitcher switcher = new ViewSwitcher();
        switcher.switchView("manager/Dashboard.fxml", event);

  
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            ResultSet result = DatabaseFunctions.getBaggageBySuitcasetype(0);
            
            while(result.next()){
                System.out.println(result.getString("suitcase_label"));
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(StatsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
