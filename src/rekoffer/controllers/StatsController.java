/*
 *Mohamed El Hallaoui
 *IS104
 *FXML Controller class
 * @author Mohamed ElHallaoui
*/
package rekoffer.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class StatsController implements Initializable {
    //ID linken van Knop
    @FXML
    public Button mijnliefeknopje;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
        
    }    
    //Control panel van knop, en action handler
     @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {
         System.out.println("Hello World!");
         mijnliefeknopje.setText("harambe");
        

    }
}
