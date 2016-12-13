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
public class RegisterLostController implements Initializable {

    ViewSwitcher switcher = new ViewSwitcher();

    @FXML
    public Label user_name;
    public TextField label, firstname_owner, lastname_owner, zip, phone, email, colour, other, model, brand, country;
    public TextArea special, address;

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
    private void registerFound(ActionEvent event) throws IOException, SQLException {

    }

    @FXML
    private void saveBaggage(ActionEvent event) throws IOException, SQLException {

        if (label.getText().isEmpty() || firstname_owner.getText().isEmpty() || email.getText().isEmpty() || lastname_owner.getText().isEmpty()) {
            System.out.println("Bitchboy");
        } else {
            String mLabel, mFirstNameOwner, mLastNameOwner, mZip, mPhone, mEmail, mColour, mOther, mModel, mBrand, mSpecial, mAddress, mCountry;
            mLabel = label.getText();
            mCountry = country.getText();
            mFirstNameOwner = firstname_owner.getText();
            mLastNameOwner = lastname_owner.getText();
            mZip = zip.getText();
            mPhone = phone.getText();
            mEmail = email.getText();
            mColour = colour.getText();
            mModel = model.getText();
            mBrand = brand.getText();
            mSpecial = special.getText();
            mAddress = address.getText();

            Baggage newBaggage = new Baggage(mLabel, mFirstNameOwner, mLastNameOwner, mAddress, mZip, mCountry, mPhone, mEmail, 1, mModel, mBrand, mColour, mSpecial);

            DatabaseFunctions.createNewLostBaggage(newBaggage);
            DatabaseFunctions.disconnect();

            returnAfterSaving(event);

        }

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
