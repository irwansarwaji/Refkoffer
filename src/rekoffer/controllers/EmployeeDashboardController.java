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

    ViewSwitcher switcher = new ViewSwitcher();
    @FXML
    public Label user_name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        user_name.setText(Session.getSessionUser().getFirstName() + ", " + Session.getSessionUser().getLastName());

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("employee/RegisterLost.fxml", event);
    }

    @FXML
    private void logoutButton(ActionEvent event) throws SQLException, IOException {
        disconnect();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("Login.fxml", event);
    }

}
