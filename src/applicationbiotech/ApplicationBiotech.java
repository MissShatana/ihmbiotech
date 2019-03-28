/*
 * classe ApplicationBiotech : lance l'application 
 */
package applicationbiotech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Grell Leyla Germain Natasha
 * @version 28/03/2019
 */
public class ApplicationBiotech extends Application {    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
        
        Scene scene1 = new Scene(root1);
        
        stage.setScene(scene1);
               
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
