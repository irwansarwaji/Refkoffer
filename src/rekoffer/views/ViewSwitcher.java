/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.views;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Damon
 */
public class ViewSwitcher {
   
    public void switchView(String viewName, Stage stage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(viewName));  
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
}
