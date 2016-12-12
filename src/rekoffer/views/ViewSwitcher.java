
package rekoffer.views;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Damon
 */
public class ViewSwitcher {
   
    /**
     * Switches the view to any location within the view package.
     * @param viewName - The (string) location of the view e.g. employee/Dashboard.fxml
     * @param event - The (ActionEvent) that is given as parameter on an action from the FXML button. This is used to get the stage.
     * 
     * @throws IOException 
     */
    public void switchView(String viewName, ActionEvent event) throws IOException
    {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(viewName));  
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    

    public FXMLLoader getLoader(String viewName)
    { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource(viewName));
        return loader;
    }
    
}
