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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import rekoffer.models.Baggage;
import rekoffer.services.DatabaseFunctions;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rekoffer.models.Matchcase;
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
    List<Baggage> baggageList = new ArrayList<>();
    List<Baggage> filterBaggageList;
    List<Matchcase> matchesList;

    private TableColumn<?, ?> suitcasecolor;

    @FXML
    public Label user_name;
    public TextField filter_text;
    public ListView userlist1;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /**
         * shows the user
         */
        user_name.setText(Session.getSessionUser().getFirstName() + ", " + Session.getSessionUser().getLastName());

        //Eerste wat ik doe is een nieuwe lijst ophalen met ALLLE KOFFERS UIT DE DATABASE
        try {
            // fillList2();
            fillList();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fillList() throws SQLException {
        

        //switcher.switchView("employee/RegisterLost.fxml", event);
        ResultSet rs = DatabaseFunctions.getAllBaggage();

        //Voor iedere rij die wij uit de database halen doe :
        while (rs.next()) {

            //Maak een baggage object aan en vul hem met mooie attributen.
            Baggage baggage = new Baggage(rs.getInt("id"), rs.getString("suitcase_label"), rs.getString("country"), rs.getInt("suitcase_type"), rs.getString("suitcase_color"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("suitcase_model"), rs.getString("suitcase_brand"), rs.getString("airport_site"));

            //Nu ga ik deze toevoegen aan mijn lijstje
            baggageList.add(baggage);

        }
        
        //Nu heb ik een lijst met alle koffers uit de database!
    }

    /**
     * button that searches for bags
     *
     * @param event
     * @throws SQLException
     * @throws IOException
     */
    @FXML
    private void searchAction(ActionEvent event) throws SQLException, IOException {
        //Filter wordt de value waar we op zoeken (wat je intypt)
        String filter = filter_text.getText();

        //Een nieuwe lijst voor een nieuwe zoekpoging
        filterBaggageList = new ArrayList<>();

        for (Baggage bag : baggageList) {
            //Ik loop nu door de lijst met koffers
            //Als de naam de letters bevat van de naam die ik intype doen we wat
            // ?i betekent dat we geen fuck geven om hoofdletters
            // * Sterretje is een soort wildcard van sql  %LIKE%

            System.out.println(bag.getSuitcaseModel());
            if ((bag.getLastName().matches("(?i)" + filter + ".*"))
                    || bag.getFirstName().matches("(?i)" + filter + ".*")
                    || bag.getEmail().matches("(?i)" + filter + ".*")
                    || bag.getLabel().matches("(?i)" + filter + ".*")
                    || bag.getSuitcaseModel().matches("(?i)" + filter + ".*")
                    || bag.getSuitcaseBrand().matches("(?i)" + filter + ".*")
                    || bag.getSuitcaseColour().matches("(?i)" + filter + ".*")) {

                //Ik kijk nu alleen of de naam overeen komt, maar dat kan dus ook meer worden met een || in mijn IF functie
                //Voeg de koffer maar toe aan de tijdelijke lijst met resultaten
                filterBaggageList.add(bag);

            }

            //Ik vergelijk gewoon met de lijst die we al hebben ,geen nieuwe requests naar de database ! awesome!
            //Probeer de first_name van een van de koffer velden in de database te veranderen
            //Kijk of je 2x rick krijgt als er 2 koffers van rick zijn
        }

        //Print het maar lekker uit
        for (Baggage bag : filterBaggageList) {

            System.out.println(bag.getLabel()+bag.getCountry()+bag.getSuitcaseType()+bag.getSuitcaseColour()+bag.getFirstName()+bag.getLastName()+bag.getEmail()+bag.getSuitcaseModel()+bag.getSuitcaseBrand()+bag.getSuitcaseColour());
        }

        //Ik kan nu de lijst met alle koffers die kloppen met de zoekterm (filterBaggageList) meegeven aan een methode die mijn table laad met een lijst 
    }

    @FXML
    private void matchAction(ActionEvent event) throws SQLException, IOException {

        //Maak een neiwue lijst aan om de matches op te slaan.
        //Ik heb hier snel even een lokale class gemaakt genaamd : Matchase. Hier kan ik een match opslaan, en makkelijk zien wie koffer 1 en koffer 2 is.
        //Welke match bestat en welke de gevonden en verloren koffer registratie is. is zo makkelijk te zien.
        matchesList = new ArrayList<>();

        //Loop door de baggagelijst die wij al hebben.
        for (Baggage bag : baggageList) {

            //Nou kijk ik alleen naar type 1
            //Waarom? Omdat er altijd beide types bestaan als er een match is (1) en (2) dus.
            //Dit is alleen om ervoor te zorgen dat ik niet voor type 2 ook nog is ga kijken dan zou hij alles dubbel matchen toch.
            if (bag.getSuitcaseType() == 1) {
                //Nou loop ik voor elk stuk baggage door de hele lijst en vergelijk ik elke koffer met elke koffer
                for (Baggage compareBag : baggageList) {

                    //Dit ziet er raar uit maar.
                    //Ik kijk hier of de labels hetzelfde zijn (niet hoofdlettergevoelig). Daarna kijk ik of ze niet dezelfde ID hebben.
                    //Omdat hij elke koffer met elke koffer vergelijkt kan hij dus ook met zichzelf vergelijken. ||
                    //De ID is hetzelfde als hij zichzelf is. Dus vandaar deze preventie
                    //De laatste check is onnodig en kan je weghalen zodra je het begrijpt... het kijkt of de types niet hetzelfde zijn want een verloren koffer kan niet matchen met een verloren koffer.
                    //Dit wordt al voorkomen bij de IF van de eerste loop : regel 169
                    //Maar dit kan eventueel handig zijn als sommige vermissingen 2 keer geregistreerd staan.
                    if (bag.getLabel().equalsIgnoreCase(compareBag.getLabel()) 
                            
                            
                            && bag.getId() != compareBag.getId() && bag.getSuitcaseType() != compareBag.getSuitcaseType()
                            ) {
                        //Maak een match aan met de matchende registraties
                        Matchcase match = new Matchcase(bag, compareBag);
                        //Voeg hem maar toe aan de lijst
                        matchesList.add(match);
                    }

                }
            }
        }

        for (Matchcase match : matchesList) {
            System.out.println(match.toString());
        }
    }

    void setSavedStatus(boolean savedBaggage) {
        this.savedBaggage = savedBaggage;
    }

    /**
     * log out button
     *
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
      
        ObservableList<Baggage> baggageList2 = FXCollections.observableArrayList();
        
        ResultSet rs = DatabaseFunctions.getAllBaggage();

        //Voor iedere rij die wij uit de database halen doe :
        while (rs.next()) {

            //Maak een baggage object aan en vul hem met mooie attributen.
            Baggage baggage = new Baggage(rs.getInt("id"), rs.getString("suitcase_label"), rs.getString("country"), rs.getInt("suitcase_type"), rs.getString("suitcase_color"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("suitcase_model"), rs.getString("suitcase_brand"), rs.getString("airport_site"));

            //Nu ga ik deze toevoegen aan mijn lijstje
            baggageList2.add(baggage);

        }
        userlist1.setItems(baggageList2);

        //Nu heb ik een lijst met alle koffers uit de database!
    }
}
