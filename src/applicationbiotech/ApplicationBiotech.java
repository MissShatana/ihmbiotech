/*
 * classe ApplicationBiotech : lance l'application 
 */
package applicationbiotech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Statement;

/**
 * @author Grell Leyla Germain Natasha
 * @version 28/03/2019
 */
public class ApplicationBiotech extends Application {    
    Connection connexion;
    Statement stm;
    
    public Connection connect_to_BDD(){
        String url = "jdbc:oracle:thin:@192.168.254.3:1521:PFPBS";
        String user = "GROUPE_24";
        String password = "GROUPE_24";
        
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connexion = DriverManager.getConnection(url, user, password);
            return connexion;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        connexion =connect_to_BDD();
//        if (connexion ==null) {
//            System.out.println("nope");
//        }
//        else{
//       try {
//           System.out.println("co ok");
//           System.out.println(connexion);
//           String requete = "Select * from personnel_labo";
//           Statement stmt = connexion.createStatement();
//
//            ResultSet res = stmt.executeQuery(requete);
//            ResultSetMetaData rsmd = res.getMetaData();
//            int nbCols = rsmd.getColumnCount();
//            while (res.next()) {
//                for (int i = 1; i <= nbCols; i++){
//                    System.out.print(res.getString(i) + " ");
//                }
//                System.out.println();
//                }
//                res.close();
//
//            } catch (SQLException e) {
//
//            //traitement de l'exception
//  }
//        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPrincipal.fxml"));
        Parent root1 = (Parent) loader.load();
        FXMLPrincipaleController controller= loader.getController();
        controller.setMain(this);
        Scene scene1 = new Scene(root1);
        stage.setScene(scene1);
               
        stage.show();
    }
   

    public static void main(String[] args) {
        launch(args);
    }
    
    public Connection getCon(){
        return connexion;
    }  
}
