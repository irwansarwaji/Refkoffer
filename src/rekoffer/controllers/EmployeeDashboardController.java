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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author Damon
 */
public class EmployeeDashboardController implements Initializable {

    boolean savedBaggage;
    ViewSwitcher switcher = new ViewSwitcher();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("employee/RegisterLost.fxml", event);
    }
    
    void setSavedStatus(boolean savedBaggage)
    {
        this.savedBaggage = savedBaggage;
    }
}
