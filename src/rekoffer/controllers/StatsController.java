/**
 * Controller voor de stats view
 *
 */
package rekoffer.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author Mohamed El Hallaoui
 */
public class StatsController implements Initializable {

    
    @FXML
    private void returnDashboard(ActionEvent event) throws IOException {
        ViewSwitcher switcher = new ViewSwitcher();
        switcher.switchView("employee/Dashboard.fxml", event);

  
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

}
