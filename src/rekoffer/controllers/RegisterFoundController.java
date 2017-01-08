/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rekoffer.models.Baggage;
import rekoffer.services.DatabaseFunctions;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import rekoffer.services.Session;
import rekoffer.views.ViewSwitcher;

/**
 * FXML Controller class
 *
 * @author damon
 */
public class RegisterFoundController implements Initializable {

    ViewSwitcher switcher = new ViewSwitcher();

    @FXML
    public Label user_name,errorMessage;
    public TextField label, firstname_owner, lastname_owner, airport_site, airport_origin, colour, model, brand;
    public TextArea special;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        user_name.setText(Session.getSessionUser().getFirstName() + ", " + Session.getSessionUser().getLastName());

    }

    @FXML
    private void returnDashboard(ActionEvent event) throws IOException, SQLException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("employee/Dashboard.fxml", event);
    }

    @FXML
    private void registerLost(ActionEvent event) throws IOException, SQLException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switcher.switchView("employee/RegisterLost.fxml", event);
    }

    @FXML
    private void saveBaggage(ActionEvent event) throws IOException, SQLException {

      
            String mLabel, mFirstNameOwner, mLastNameOwner, mColour, mModel, mBrand, mSpecial, mSite, mOrigin;
            mLabel = label.getText();
            mFirstNameOwner = firstname_owner.getText();
            mLastNameOwner = lastname_owner.getText();
            mColour = colour.getText();
            mModel = model.getText();
            mBrand = brand.getText();
            mSpecial = special.getText();
            mSite = airport_site.getText();
            mOrigin = airport_origin.getText();

            Baggage newBaggage = new Baggage(mLabel, mFirstNameOwner, mLastNameOwner, 2, mModel, mBrand, mColour, mSpecial, mSite, mOrigin);
            
            System.out.println("special");
            System.out.println(mSpecial);

            DatabaseFunctions.createNewFoundBaggage(newBaggage);
            DatabaseFunctions.disconnect();

            returnAfterSaving(event);

        

    }

    private void returnAfterSaving(ActionEvent event) throws IOException {
        Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = switcher.getLoader("employee/Dashboard.fxml");
        Parent root = (Parent) loader.load();

        Scene scene = new Scene(root);
        st.setScene(scene);

        EmployeeDashboardController controller = loader.<EmployeeDashboardController>getController();
        controller.setSavedStatus(true);
        st.show();
    }
}
