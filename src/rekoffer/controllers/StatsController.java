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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import rekoffer.models.Label;
import rekoffer.services.DatabaseFunctions;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author Mohamed El Hallaoui
 */
public class StatsController implements Initializable {


    //Declaring 3 listviews for Lost, Matched and Found labels
    @FXML
    public ListView matchedView;
    public ListView lostView;
    public ListView foundView;

    
    /**
     * View switches from stats view to manager dashboard
     * @param event
     * @throws IOException 
     */
    @FXML
    private void returnDashboard(ActionEvent event) throws IOException {
        ViewSwitcher switcher = new ViewSwitcher();
        switcher.switchView("manager/Dashboard.fxml", event);

    }
    
    //Declaring 3 Arraylists for Matched, Lost and Found labels
    public ObservableList<Label> labelsMatched = FXCollections.observableArrayList();
    public ObservableList<Label> labelsLost = FXCollections.observableArrayList();
    public ObservableList<Label> labelsFound = FXCollections.observableArrayList();
    
    
    /**
     * Fills the matchedlabellist with all matched labels from the database by using an SQL statement and filling the MatchedView with the results from the statement
     * @throws SQLException 
     */
    private void fillMatchedLabelList() throws SQLException {
        ResultSet matchedResult = DatabaseFunctions.getMatchedLabel();
        while (matchedResult.next()) {
            Label matchedLabel = new Label(matchedResult.getString("suitcase_label"));
            labelsMatched.add(matchedLabel);
        }

        matchedView.setItems(labelsMatched);
    }
    
    /**
     * Fills the lostlabellist with all lost labels from the database by using an SQL statement and filling the LostView with the results from the statement
     * @throws SQLException 
     */
    private void fillLostLabelList() throws SQLException {
        ResultSet lostResult = DatabaseFunctions.getLostLabel();
        while (lostResult.next()) {
            Label lostLabel = new Label(lostResult.getString("suitcase_label"));
            labelsLost.add(lostLabel);
        }

        lostView.setItems(labelsLost);
    }
    
    /**
     * Fills the foundlabellist with all found labels from the database by using an SQL statement and filling the LostView with the results from the statement
     * @throws SQLException 
     */
    private void fillFoundLabelList() throws SQLException {
        ResultSet foundResult = DatabaseFunctions.getFoundLabel();
        while (foundResult.next()) {
            Label foundLabel = new Label(foundResult.getString("suitcase_label"));
            labelsFound.add(foundLabel);
        }

        foundView.setItems(labelsFound);
    }

    /**
     * Executing code from given methods
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        try {
            fillLostLabelList();
            fillFoundLabelList();
            fillMatchedLabelList();
                    
        } catch (SQLException ex) {
            Logger.getLogger(StatsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
