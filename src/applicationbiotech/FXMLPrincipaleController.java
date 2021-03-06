/*
 * Application pour gérer les données de laboratoire
 */
package applicationbiotech;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.util.converter.DefaultStringConverter;
import java.util.regex.*;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

/**
 * FXMLPrincipaleController  est la classe avec les différents écouteurs 
 * @author Germain Natasha Grell Leyla
 * @version 28/03/2019
 * 
 */
public class FXMLPrincipaleController implements Initializable {
    ApplicationBiotech main=null;
    //Attribut
    private String id_connexion;
    
    @FXML
    private RadioButton radioOui;
     
    @FXML
    private RadioButton radioNon;
    
    @FXML
    private RadioButton radio384;
    
    @FXML
    private RadioButton radio96;
    
    Button buttonModif = new Button("modifier");
    
    @FXML
    ListView<String> listpos ;
    
    
    //Pane des différentes page
    @FXML
    private VBox vBoxMenu;

    @FXML
    private Pane PaneCommande;
    
    @FXML
    private Pane paneTableAttente;
    
    @FXML
    private Pane paneSolutionsCommande; 
    
    @FXML 
    private Pane paneTableEnCours;
    
    @FXML
    private Pane paneTableARenouv;
    
    @FXML
    private Pane paneConnexion;
    
    @FXML
    private Pane paneVerif;
    
    
    //Pane avec label
    @FXML
    private Pane paneLabel;

    @FXML 
    private Pane paneLabelRenouv;
    
    @FXML 
    private Pane paneLabelCours;
    
    @FXML 
    private Pane paneLabelAttente;
    
    @FXML 
    private Pane paneLabelSol;
    

    
    //Button
    @FXML
    private Button btn_a_renouv;
    
    @FXML
    private Button btn_valide;

    @FXML
    private Button commande;

    @FXML
    private Button btn_attente;
    
    @FXML
    private Button btn_en_cours;
    
    @FXML
    private Button buttonDeco;

    
    //ComboBox
    @FXML 
    private ComboBox comboAgent;
    
    @FXML 
    private ComboBox comboReactC;
    
    @FXML 
    private ComboBox comboReactO;
    
    @FXML 
    private ComboBox Comboexp;

    private ObservableList <String> comboList = 
        FXCollections.observableArrayList(
        "colorimetrique",
        "opacimetrique"
        );

    //Label
    @FXML
    private Label agentLabel;

    @FXML
    private Label frequenceLabel;
       
    @FXML
    private Label a3RougeLabel;
    @FXML
    private Label reactField;
    
    @FXML
    private Label typePlaqueLabel;
     
    @FXML
    private Label typeExpLabel;
     
    @FXML
    private Label suiviLabel;
     
    @FXML
    private Label Label_error;
    
    @FXML
    private Label a1RougeLabel;
     
    @FXML
    private Label a2RougeLabel;
     
    @FXML
    private Label a1VertLabel;
     
    @FXML
    private Label a2VertLabel;
     
    @FXML
    private Label a1BleuLabel;
     
    @FXML
    private Label a2BleuLabel;
     
    @FXML
    private Label a1TransparenceLabel;
     
    @FXML
    private Label a2TransparenceLabel;
     
    @FXML
    private Label dureeLabel;
     
    @FXML
    private Label slotLabel;
    
    @FXML
    private Label Label_error_sol;
    
    @FXML 
    private Label Label_error_vide;
    
    @FXML
    private Label labelErrorConnexion;
    
    @FXML
    private Label labelPoste;
    
    @FXML
    private Label labelIdentite;

    
    //Spinner
    
    @FXML
    private Spinner<Integer>  spinnerDuree;
     
    @FXML
    private  Spinner<Integer>  spinnerRa1;
     
    @FXML
    private Spinner<Integer>  spinnerRa2;
     
    @FXML
    private Spinner<Double>  spinnerRa3;
     
    @FXML
    private Spinner<Integer>  spinnerVa1;
     
    @FXML
    private Spinner<Integer>  spinnerVa2;
      
    @FXML
    private Spinner<Integer>  spinnerBa1;
     
    @FXML
    private Spinner<Integer>  spinnerBa2;
    
    @FXML
    private Spinner<Integer>  spinnerFreq;
     
    @FXML
    private Spinner<Integer> spinnerTa1;
     
    @FXML
    private Spinner<Integer>  spinnerTa2;

    @FXML
    private Spinner<Integer> spinnerSlot;
    
    @FXML
    private Spinner<Integer>spinnerQsol;
    
    @FXML
    private Spinner<Integer>spinnerAB;
    
      
    //Field
    
    @FXML
    private TextField identifiantText;
    
    @FXML
    private TextField mdpText;
    

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Pour le menu
    public void handleButtonCommande(ActionEvent event) throws SQLException {
        allNotVisible();
        falseDisable();
        commande.setDisable(true);
        btn_attente.setDisable(true);
        btn_en_cours.setDisable(true);
        paneLabel.setVisible(true);
        PaneCommande.setVisible(true);

        //intialisation des agent_bio et reactifs
        String requete = "select id_agent, nom_agent from agent_bio";
        ObservableList <String> list = FXCollections.observableArrayList();
        Statement st = main.getCon().createStatement();
        ResultSet rs = st.executeQuery(requete);
        while (rs.next()){ 
            list.add(rs.getString("id_agent")+"-"+rs.getString("nom_agent"));
 
        }

        comboAgent.setItems(list);
        rs.close();
        ObservableList <String> listC = FXCollections.observableArrayList();
        ObservableList <String> listO = FXCollections.observableArrayList();
        requete = "select id_reactif , nom_reactif, type_reactif from reactif ";
        rs = st.executeQuery(requete);
        while (rs.next()){
            System.out.println(rs.getString("type_reactif"));
            if ("colorimetrique".equals(rs.getString("type_reactif"))){
                listC.add(rs.getString("id_reactif")+"-"+rs.getString("nom_reactif"));
            }
            else{
                listO.add(rs.getString("id_reactif")+"-"+rs.getString("nom_reactif"));
            }
        }

        comboReactO.setItems(listO);
        comboReactC.setItems(listC);
        clearInfoSolAttente();
        clearInfoSolCours();
        }

    public void handleMenuAttente(ActionEvent event) {
        allNotVisible();
        falseDisable();
        if("Laborantin".equals(labelPoste.getText())){
            commande.setDisable(true);
        }
        paneTableAttente.setVisible(true);
        paneLabelAttente.setVisible(true);
        clearInfoSolAttente();
        clearInfoSolCours();
    }
    
    public void handlebuttoneExp_en_cours (ActionEvent event){
        allNotVisible();
        paneTableEnCours.setVisible(true);
            if("chercheur".equals(labelPoste.getText())){
                col_att_assignation1.setVisible(false);
        }
        clearInfoSolAttente();
        clearInfoSolCours();
        paneLabelCours.setVisible(true);
    }
        
    
    public void handlebutton_a_renouv (ActionEvent event){
        allNotVisible();
        paneTableARenouv.setVisible(true);
    }
       

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Connexion
    
    /**
    * Cette classe crée un pop up lorsque la connexion n'est pas bonne
    * @param alertType
    * @param title
    * @param message 
    */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    //alert.initOwner(owner);
    alert.show();
    }
    
    /**
     * Ecouteur du bouton connexion avec chargement des données si la connexion est bonne
     * @param event
     * @throws SQLException 
     */
    public void handleButtonConnexion (ActionEvent event ) throws SQLException{
        String sq1 = "Select id_personnel from connexion where identifiant_co = '"+identifiantText.getText()+"'and mdp_co = '" + mdpText.getText()+"'" ;                     
        Statement stmt = main.getCon().createStatement();
        ResultSet resultat = stmt.executeQuery(sq1);
         
        if (!resultat.next()){
            showAlert(Alert.AlertType.ERROR, "Erreur!", "Mauvais mot de passe et/ou identifiant");
            resultat.close();
        }else{
            sq1 = "select actif from personnel_labo where id_personnel='"+resultat.getString(1)+"'";
            stmt = main.getCon().createStatement();
            ResultSet rs2 = stmt.executeQuery(sq1);
            if (rs2.next()){
                int id = rs2.getInt(1);
                if (id == 1){
                    showAlert(Alert.AlertType.ERROR, "Erreur!", "Compte non actif");
                    rs2.close();
                    resultat.close();
                }
                else if (id == 0 ){
                    vBoxMenu.setVisible(true);
                    rs2.close();
                    String requete3 = "SELECT id_chercheur, id_personnel from chercheur where id_personnel= '"+resultat.getString(1)+"'";
                          
                    stmt = main.getCon().createStatement();
                    ResultSet rs3 = stmt.executeQuery(requete3);


                    //chercheur
                    if (rs3.next()){
                        System.out.println("chercheur");
                        id_connexion = rs3.getString("id_chercheur")+"-"+rs3.getString("id_personnel");
                        paneConnexion.setVisible(false);
                        commande.setDisable(false);
                        btn_attente.setDisable(false);
                        btn_en_cours.setDisable(false);
                        buttonDeco.setDisable(false);
                        labelPoste.setVisible(true);
                        labelPoste.setText("Chercheur");
                        rs3.close();
                                
                        sq1 = "SELECT nom,prenom from chercheur where id_personnel= '"+resultat.getString(1)+"'";
                        Statement st5 = main.getCon().createStatement();
                        rs3 = st5.executeQuery(sq1);
                        if (rs3.next()){
                            labelIdentite.setText(rs3.getString("prenom")+" "+rs3.getString("nom"));
                        }
                        rs3.close();
                        sq1 = "Select * from commande join reactif using(id_reactif) join agent_bio using(id_agent) where id_commande in (SELECT unique(id_commande) from commande join ligne_commande using(id_commande) where commande.id_personnel= '"+resultat.getString(1)+"' and statut = 'en attente')";
                        st5 = main.getCon().createStatement();
                        rs3 = st5.executeQuery(sq1);
                        while (rs3.next()){
                            //chargement des lignes de commande
                            sq1="Select * from ligne_commande join cellule using(id_cellule) where id_commande='"+rs3.getString("id_commande")+"'";
                            st5 = main.getCon().createStatement();
                            rs2=st5.executeQuery(sq1);
                            data_table_sol=FXCollections.observableArrayList();
                            while(rs2.next()){

                                ObservableList<String> listPos =FXCollections.observableArrayList();
                                sq1="Select * from slot where id_ligne_commande='"+rs2.getString("id_ligne_commande")+"'";
                                st5 = main.getCon().createStatement();
                                ResultSet rs4=st5.executeQuery(sq1);
                                while(rs4.next()){
                                    listPos.add(rs4.getString("id_slot")+" x: "+rs4.getString("posX")+" y: "+rs4.getString("posY"));
                                }
                                rs4.close();
                                data_table_sol.add(new Solutions(rs2.getInt("id_ligne_commande"),rs2.getString("quantite_agent_biologique"),rs2.getString("quantite_cellules"),rs2.getString("type_cellule"),new Button("Voir"),FXCollections.observableArrayList(listPos),this));
                            }
                            data_commande_att.add(new Commande(rs3.getString("id_commande"), rs3.getString("nom_agent"), rs3.getString("date_co"), rs3.getString("type_experience"), rs3.getString("nombre_slots"),rs3.getString("duree"),rs3.getString("frequence"),new Button("Modifier"),new Button("Infos"), FXCollections.observableArrayList(data_table_sol), rs3.getString("type_de_plaque"),rs3.getString("nom_reactif"), this ));
                        }
                        data_table_sol=FXCollections.observableArrayList();
                    }
                                
                    String requete4 = "SELECT id_laborantin, id_personnel from laborantin where id_personnel= '"+resultat.getString(1)+"'";
                    stmt = main.getCon().createStatement();
                    rs2 = stmt.executeQuery(requete4);          
                     //Laborantin  
                    if (rs2.next()){
                        System.out.println("laborantin");
                        id_connexion = rs2.getString("id_laborantin")+"-"+rs2.getString("id_personnel");
                        paneConnexion.setVisible(false);
                        btn_attente.setDisable(false);
                        btn_en_cours.setDisable(false);                             
                        labelPoste.setVisible(true);
                        labelPoste.setText("Laborantin");
                        buttonDeco.setDisable(false);
                        commande.setDisable(true);
                        rs2.close();
                        sq1 = "SELECT nom,prenom from laborantin where id_personnel= '"+resultat.getString(1)+"'";
                        stmt = main.getCon().createStatement();
                        rs2 = stmt.executeQuery(sq1);
                        if (rs2.next()){
                            labelIdentite.setText(rs2.getString("prenom")+" "+rs2.getString("nom"));
                        }
                        rs2.close();
                        sq1 = "Select * from commande join reactif using(id_reactif) join agent_bio using(id_agent) where id_commande in (SELECT unique(id_commande) from commande join ligne_commande using(id_commande) where statut = 'en attente')";
                        stmt = main.getCon().createStatement();
                        rs2 = stmt.executeQuery(sq1);
                        while (rs2.next()){
                            //chargement des lignes de commande
                            sq1="Select * from ligne_commande join cellule using(id_cellule) where id_commande='"+rs2.getString("id_commande")+"'";
                            stmt = main.getCon().createStatement();
                            rs3=stmt.executeQuery(sq1);
                            data_table_sol=FXCollections.observableArrayList();
                            while(rs3.next()){
                                
                                ObservableList<String> listPos =FXCollections.observableArrayList();
                                sq1="Select * from slot where id_ligne_commande="+rs3.getString("id_ligne_commande")+"";
                                stmt = main.getCon().createStatement();
                                ResultSet rs4=stmt.executeQuery(sq1);
                                while(rs4.next()){
                                    listPos.add(rs4.getString("id_slot")+" x: "+rs4.getString("posX")+" y: "+rs4.getString("posY"));
                                }
                                rs4.close();
                                data_table_sol.add(new Solutions(rs3.getInt("id_ligne_commande"),rs3.getString("quantite_agent_biologique"),rs3.getString("quantite_cellules"),rs3.getString("type_cellule"),new Button("Voir"),FXCollections.observableArrayList(listPos),this));
                            }
                            
                            data_commande_att.add(new Commande(rs2.getString("id_commande"), rs2.getString("nom_agent"), rs2.getString("date_co"), rs2.getString("type_experience"), rs2.getString("nombre_slots"),rs2.getString("duree"),rs2.getString("frequence"),new Button("Je prends"),new Button("Infos"), FXCollections.observableArrayList(data_table_sol), rs2.getString("type_de_plaque"),rs2.getString("nom_reactif"), this ));
                        }
                        data_table_sol=FXCollections.observableArrayList();        
                                 
                    }
                        
                }         
            }      
           
        }
        resultat.close();
    }
         
    /**
     * Ecouteur du bouton de déconnexion
     * @param e 
     */   
    public void handleButtonDeco (ActionEvent e){
        paneTableARenouv.setDisable(true);
        paneTableAttente.setDisable(true);
        PaneCommande.setDisable(true);
        paneTableEnCours.setDisable(true);
        paneVerif.setVisible(true);
        commande.setDisable(true);
        btn_attente.setDisable(true);
        btn_en_cours.setDisable(true);
        paneSolutionsCommande.setDisable(true);
        clearInfoSolAttente();
        clearInfoSolCours();
       }
       
    /**
     * Ecouteur du bouton oui pour la déconnexion
     * @param e 
     */
       public void handleButtonDecoOui (ActionEvent e){
        allNotVisible();
        paneConnexion.setVisible(true);
        vBoxMenu.setVisible(false);
        labelIdentite.setText("");
        labelPoste.setText("");
        identifiantText.setText("");
        mdpText.setText("");
        buttonDeco.setDisable(true);
        data_commande_att.clear();
        dataInfoSol.clear();
        initializeCommande();
        falseDisable();
        
       comboReactC.setDisable(true);
       comboReactO.setDisable(true);
        
        }
       
    /**
     * Ecouteur du bouton non de connexion
     * @param e 
     */   
    public void handleButtonDecoNon (ActionEvent e){
          
        //Réinitialisation de des champs de la connexion
        falseDisable();
          
        //Réinitialisation des champs de la commande 
        initializeCommande();
        if (labelPoste.getText() == "Chercheur") {
            commande.setDisable(false);
        }
        else if (labelPoste.getText() == "Laborantin"){
            commande.setDisable(true);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //La commande 
    
        public void initializeCommande(){
        //nettoyage des données
       comboAgent.getSelectionModel().clearSelection();
       Comboexp.getSelectionModel().clearSelection();
       comboReactO.getSelectionModel().clearSelection();
       comboReactC.getSelectionModel().clearSelection();
       radio384.setSelected(false);
       radio384.setSelected(false);
       radio96.setSelected(false);
       radioOui.setSelected(false);
       radioNon.setSelected(false);
       data_table_sol.removeAll(tab_Solutions.getItems());
       Label_error_sol.setVisible(false);
       Label_error.setVisible(false);
       
       dataSol.clear();
       //réinitialisation du pane
       Label_error_sol.setVisible(false);
       Label_error.setVisible(false);
       frequenceLabel.setVisible(false);
       spinnerFreq.setVisible(false);
       spinnerRa3.setVisible(false);
       a3RougeLabel.setVisible(false);
       initializeSpinner();
    }
        
        
    /**
     * Cette class annule la commande et écoute les deux bouttons annuler
     * les valeurs sont réinitialisées
     * @param e 
     */
    public void handleButtonAnnuler (ActionEvent e){
       allNotVisible();
       agentLabel.setTextFill(Color.web("black"));
       reactField.setTextFill(Color.web("black"));
       typeExpLabel.setTextFill(Color.web("black"));
       slotLabel.setTextFill(Color.web("black"));
       typePlaqueLabel.setTextFill(Color.web("black"));
       suiviLabel.setTextFill(Color.web("black"));
       a3RougeLabel.setTextFill(Color.web("black"));
       a2RougeLabel.setTextFill(Color.web("black"));
       a1RougeLabel.setTextFill(Color.web("black"));
       a2VertLabel.setTextFill(Color.web("black"));
       a1VertLabel.setTextFill(Color.web("black"));
       a1TransparenceLabel.setTextFill(Color.web("black"));
       a2TransparenceLabel.setTextFill(Color.web("black"));
       a2BleuLabel.setTextFill(Color.web("black"));
       a1BleuLabel.setTextFill(Color.web("black"));
       dureeLabel.setTextFill(Color.web("black"));
       Label_error.setVisible(false);
       paneSolutionsCommande.setVisible(false);
       PaneCommande.setVisible(false);
       paneLabel.setVisible(false);
       comboReactC.setDisable(true);
       comboReactO.setDisable(true);
       initializeCommande();
       //réglage du menu
       falseDisable();  
    }
    
      
    /**
     * Cette classe permet de faire apparaître les champs a3 et fréquence 
     * quand l'expérience est suivi dans le temps
     * et les faire disparaître quand elle ne l'est pas
     * @param action 
     */
    
    public void myGroupAction(ActionEvent action)
    {

       if(radioOui.isSelected()){
            frequenceLabel.setVisible(true);
            spinnerFreq.setVisible(true);
            spinnerRa3.setVisible(true);
            a3RougeLabel.setVisible(true);

       }
       
        if(radioNon.isSelected()){
            frequenceLabel.setVisible(false);
            spinnerFreq.setVisible(false);
            spinnerRa3.setVisible(false);
            a3RougeLabel.setVisible(false);

        }
    } 
    
    //La commande: Les informations générales
    
    /**
     * Cette classe écoute les bouttons valider de commande informations générales
     * si des champs sont vides un message d'erreur s'affiche et le champs vide est écrit en rouge
     * sinon on passe à solutions et la couleur des champs est réinitialisé à noir
     * @param e 
     */
    public void handleButtonValider (ActionEvent e){
        if ((comboAgent.getValue() != null) && (spinnerSlot.getValue() != 0 )&&(Comboexp.getValue() != null) | (radio384.isSelected() == true ) | (radio96.isSelected() == true ) && (spinnerRa1.getValue() !=0) && (spinnerRa2.getValue() != 0) && (spinnerBa1.getValue() != 0 ) && (spinnerBa2.getValue() != 0) && (spinnerVa1.getValue() != 0 ) && (spinnerVa2.getValue() != 0) && (spinnerTa1.getValue() != 0) && (spinnerTa2.getValue() != 0 ) && (spinnerDuree.getValue() != 0) && (spinnerSlot.getValue() != 0) &&((radioOui.isSelected() == true && spinnerRa3.getValue() != 0 && spinnerFreq.getValue() != 0 )|(radioNon.isSelected() == true)) ) {           
            paneSolutionsCommande.setVisible(true);
            PaneCommande.setVisible(false);
            paneLabelSol.setVisible(true);
            paneLabel.setVisible(false);
            agentLabel.setTextFill(Color.web("black"));
            reactField.setTextFill(Color.web("black"));
            typeExpLabel.setTextFill(Color.web("black"));
            slotLabel.setTextFill(Color.web("black"));
            typePlaqueLabel.setTextFill(Color.web("black"));
            suiviLabel.setTextFill(Color.web("black"));
            a3RougeLabel.setTextFill(Color.web("black"));
            a2RougeLabel.setTextFill(Color.web("black"));
            a1RougeLabel.setTextFill(Color.web("black"));
            a2VertLabel.setTextFill(Color.web("black"));
            a1VertLabel.setTextFill(Color.web("black"));
            a1TransparenceLabel.setTextFill(Color.web("black"));
            a2TransparenceLabel.setTextFill(Color.web("black"));
            a2BleuLabel.setTextFill(Color.web("black"));
            a1BleuLabel.setTextFill(Color.web("black"));
            dureeLabel.setTextFill(Color.web("black"));
            Label_error.setVisible(false);
        }
        else{
            reactField.setTextFill(Color.web("black"));
            agentLabel.setTextFill(Color.web("black"));
            typeExpLabel.setTextFill(Color.web("black"));
            slotLabel.setTextFill(Color.web("black"));
            typePlaqueLabel.setTextFill(Color.web("black"));
            suiviLabel.setTextFill(Color.web("black"));
            a3RougeLabel.setTextFill(Color.web("black"));
            a2RougeLabel.setTextFill(Color.web("black"));
            a1RougeLabel.setTextFill(Color.web("black"));
            a2VertLabel.setTextFill(Color.web("black"));
            a1VertLabel.setTextFill(Color.web("black"));
            a1TransparenceLabel.setTextFill(Color.web("black"));
            a2TransparenceLabel.setTextFill(Color.web("black"));
            a2BleuLabel.setTextFill(Color.web("black"));
            a1BleuLabel.setTextFill(Color.web("black"));
            dureeLabel.setTextFill(Color.web("black"));
            
            Label_error.setVisible(true);
                
             if ( comboAgent.getValue() == null  ){
                    agentLabel.setTextFill(Color.web("red"));
             }
             if (Comboexp.getValue() == null ){
                    typeExpLabel.setTextFill(Color.web("red")); 
                    reactField.setTextFill(Color.web("red"));
             } else{
                 if (Comboexp.getValue()=="opacimetrique" & comboReactO.getValue() == null){
                         reactField.setTextFill(Color.web("red"));
                     }
                 else if (Comboexp.getValue()=="colorimetrique" & comboReactC.getValue() == null){
                         reactField.setTextFill(Color.web("red"));
                }
                 
             }
             if (spinnerSlot.getValue()== 0){
                   slotLabel.setTextFill(Color.web("red")); 
             }
             if (radio384.isSelected() == false && radio96.isSelected()==false ){
                    typePlaqueLabel.setTextFill(Color.web("red"));
             }
                         
             if (radioOui.isSelected() == false && radioNon.isSelected() == false ){
                    suiviLabel.setTextFill(Color.web("red"));
             }
             if (radioOui.isSelected() == true){
                 suiviLabel.setTextFill(Color.web("black"));
                 if (spinnerRa3.getValue()== 0){
                     a3RougeLabel.setTextFill(Color.web("red"));
                 }
                 
                 if (spinnerFreq.getValue()== 0){
                     frequenceLabel.setTextFill(Color.web("red"));
                 }
             }
             if (spinnerRa1.getValue()== 0){
                 a1RougeLabel.setTextFill(Color.web("red"));
             }
             if (spinnerRa2.getValue()== 0){
                 a2RougeLabel.setTextFill(Color.web("red"));
             }
             if ( spinnerBa1.getValue()== 0){
                 a1BleuLabel.setTextFill(Color.web("red"));
             }
             if (spinnerBa2.getValue()== 0){
                 a2BleuLabel.setTextFill(Color.web("red"));
             }
             if (spinnerVa1.getValue()== 0){
                 a1VertLabel.setTextFill(Color.web("red"));
             }
             if (  spinnerVa2.getValue()== 0){
                 a2VertLabel.setTextFill(Color.web("red"));
             }
             if (  spinnerTa1.getValue()== 0){
                 a1TransparenceLabel.setTextFill(Color.web("red"));
             }
             if (  spinnerTa2.getValue()== 0){
                 a2TransparenceLabel.setTextFill(Color.web("red"));
             }
             if (  spinnerDuree.getValue()== 0){
                 dureeLabel.setTextFill(Color.web("red"));
             }
        }
    }
    
    
    /**
     * Cette classe permet d'afficher la combobox correspondant à 
     * l'opacimétrie ou la colorimétrie selon lechoix fait par l'utilisateur
     * @param e 
     */
    public void handleComboExp (ActionEvent e){
        comboReactC.setDisable(false);
        comboReactO.setDisable(false);
        if (Comboexp.getValue()=="opacimetrique"){
            comboReactO.setVisible(true);
            comboReactC.setVisible(false);
        }
        else if (Comboexp.getValue()=="colorimetrique"){
            comboReactC.setVisible(true);
            comboReactO.setVisible(false);
        }
    }
             
    //La commande : Pour la solution 
    /**
     * Cette classe écoute le boutton retour pour retourné 
     * sur la page informations générales de commande depuis solutions
     * @param f 
     */
    public void handleButtonRetour (ActionEvent f){
    paneSolutionsCommande.setVisible(false);
    PaneCommande.setVisible(true);
    }  
    
    /**
     * Cette classe écoute Valider sur la page solution
     * s'il n'y pas de données, un message d'erreur s'affiche
     * sinon les différents champs de commande informations générales et solutions sont réinitialiser
     * @param e  
     */
    
    public void handleButtonValiderComSol (ActionEvent e) throws SQLException{
        if (dataSol.isEmpty()){
            Label_error_sol.setVisible(true);
            Label_error_vide.setVisible(false);
        }
        else{
            
            String plaque="0";
            int suivi=0;
            String a3="0";
            String frequence ="0";
            
            if (radio384.isSelected()) {
                plaque="384";

            }else if (radio96.isSelected()) {  
                plaque="96";
             }
            if (radioNon.isSelected()){
                suivi =1; 
            }else{
                suivi =0;
                frequence = String.valueOf(spinnerFreq.getValue());
                a3 = String.valueOf(spinnerRa3.getValue());             
            }
            
            Pattern p = Pattern.compile("-");
            String[] items = p.split(String.valueOf(comboAgent.getValue()));           
            String id_agent1 = items[0];
            String id_react1="erreur";
            if (Comboexp.getValue()=="colorimetrique"){
                String[] items1 = p.split(String.valueOf(comboReactC.getValue()));           
                id_react1 = items1[0];
            }
            else if (Comboexp.getValue()=="opacimetrique"){
                String[] items1 = p.split(String.valueOf(comboReactO.getValue()));           
                id_react1 = items1[0];
            }

            String requete1 = "Select id_personnel from connexion where identifiant_co = '"+identifiantText.getText()+"'and mdp_co = '" + mdpText.getText()+"'" ;                     
            Statement stmt1 = main.getCon().createStatement();
            ResultSet personnel = stmt1.executeQuery(requete1);                          
            if (!personnel.next()){
                System.out.println("pas id_personnel");

            }else{System.out.println("bouh2");
                  System.out.println(personnel.getString(1));
                String requete2 = "select id_chercheur from chercheur where id_personnel ='"+personnel.getString(1)+"'";
                Statement stmt2 = main.getCon().createStatement();
                ResultSet chercheur = stmt2.executeQuery(requete2);

                if (!chercheur.next()){
                    System.out.println("pas id_chercheur");

                }else {System.out.println("bouh1");
                       System.out.println(chercheur.getString(1));
                    try{
                        String requete3 = "INSERT INTO Commande VALUES (1,"+id_agent1+","+personnel.getString(1)+","+chercheur.getString(1)+","+id_react1+","+suivi+","+null+","+spinnerSlot.getValue()+","+spinnerDuree.getValue()+","+frequence+",'"+Comboexp.getValue()+"',"+plaque+","+a3+","+spinnerVa2.getValue()+","+spinnerVa1.getValue()+","+spinnerBa2.getValue()+","+spinnerBa1.getValue()+","+spinnerTa1.getValue()+","+spinnerTa2.getValue()+","+spinnerRa1.getValue()+","+spinnerRa2.getValue()+")";                     
                        System.out.println("bouh");
                        Statement stmt3 = main.getCon().createStatement();
                        ResultSet resultat2 = stmt3.executeQuery(requete3);
                        requete3 = "select max(id_commande) from Commande";
                        stmt3 = main.getCon().createStatement();
                        ResultSet maxIDCommande1 = stmt3.executeQuery(requete3);
                        if (maxIDCommande1.next()){
                           data_commande_att.add(new Commande(maxIDCommande1.getString(1), String.valueOf(comboAgent.getValue()), String.valueOf(LocalDate.now()), String.valueOf(Comboexp.getValue()), String.valueOf(spinnerSlot.getValue()),String.valueOf(spinnerDuree.getValue()),String.valueOf(spinnerFreq.getValue()),buttonModif,new Button("Infos"), FXCollections.observableArrayList(dataSol), plaque,id_react1, this ));

                        }


                        for (Solutions sol: dataSol){
                            requete3 = "select max(id_commande) from Commande";
                            stmt3 = main.getCon().createStatement();
                            ResultSet maxIDCommande = stmt3.executeQuery(requete3);
                                requete3 = "select max(id_cellule) from cellule where type_cellule='"+sol.getTy_cell()+"'";
                                Statement stmt4 = main.getCon().createStatement();
                                ResultSet iDCell = stmt4.executeQuery(requete3);
                            if (iDCell.next() & maxIDCommande.next()){
                                    
                                    String requete4 = "INSERT INTO Ligne_commande values(1,"+iDCell.getString(1)+",null,null,null,"+maxIDCommande.getString(1)+","+sol.getQt_ab()+","+sol.getQt_cell()+",'créée',null,null)";
                                    Statement stmt5 = main.getCon().createStatement();
                                    ResultSet insertLC = stmt4.executeQuery(requete4);
                                    requete3 = "select max(id_ligne_commande) from ligne_commande";
                                    Statement stmt6 = main.getCon().createStatement();
                                    ResultSet maxIDLC = stmt3.executeQuery(requete3);
                                    if (maxIDLC.next()){
                                        for(int i = 0; i < spinnerSlot.getValue(); i++){
                                            String requete5 = "insert into slot values (1,2,3,"+maxIDLC.getString(1)+",null)";
                                            stmt3 = main.getCon().createStatement();
                                            ResultSet insertSlot = stmt3.executeQuery(requete5);
                                            insertSlot.close();
                                        }
                                    }
                                   insertLC.close();
                                   maxIDLC.close();
                                }
                                iDCell.close();
                                maxIDCommande.close();
                                
                                }
                               
                            
                            
                        resultat2.close();
                        
                        }catch(SQLException o){
                            System.out.println(o.getMessage());
                        }
                        

                    }
                }

            allNotVisible();   
            initializeCommande();
            data_table_sol.removeAll(tab_Solutions.getItems());
            commande.setDisable(false);
            btn_attente.setDisable(false);
            btn_en_cours.setDisable(false);
            paneTableAttente.setVisible(true);
            paneLabelAttente.setVisible(true);
            dataSol.clear();
            comboReactC.setDisable(true);
            comboReactO.setDisable(true);
        }
        
    }

   
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Attributs: Tableau pour les commandes en attente
    @FXML
    private TableView<Commande> tab_attente;
       
    @FXML
    private TableColumn<Commande, String> col_att_num_commande;

    @FXML
    private TableColumn<Commande, String> col_att_type_exp;

    @FXML
    private TableColumn<Commande, String> col_att_d;
    
    @FXML
    private TableColumn<Commande, String> col_att_f;
    
    @FXML
    private TableColumn<Commande, String> col_att_date_commande;

    @FXML
    private TableColumn<Commande, String> col_att_info;

    @FXML
    private TableColumn<Commande, Button> col_att_assignation;
    
    private ObservableList<Commande> data_commande_att= FXCollections.observableArrayList();
    
    @FXML
    private Label ValInfAB;

    @FXML
    private Label ValInfR;

    @FXML
    private Label ValInfNBSlot;

    @FXML
    private Label ValInfoPlaque;

    @FXML
    private Label ValInfoNBSol;
    
    @FXML
    private Label ValInfAB1;

    @FXML
    private Label ValInfR1;

    @FXML
    private Label ValInfNBSlot1;

    @FXML
    private Label ValInfoPlaque1;

    @FXML
    private Label ValInfoNBSol1;
    
    
    //Tableau pour les commandes en attente
    /**
     * Construction du tableau d'attente
     */
    private void initTable(){
        initColumn();
    }
    
    /**
     * Initialisation des colonnes
     */
    private void initColumn(){
        col_att_num_commande.setCellValueFactory(new PropertyValueFactory<>("num"));
        col_att_date_commande.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_att_type_exp.setCellValueFactory(new PropertyValueFactory<>("type_exp"));
        col_att_d.setCellValueFactory(new PropertyValueFactory<>("d"));
        col_att_f.setCellValueFactory(new PropertyValueFactory<>("f"));
        col_att_info.setCellValueFactory(new PropertyValueFactory<>("bouttonInfo"));
        col_att_assignation.setCellValueFactory(new PropertyValueFactory<>("bouttonAss"));
    }
    
    /**
     * loadData permet mettre les données dans le tableview
     */
    private void loadData(ObservableList<Commande> data_commande_att) {
        tab_attente.setItems(data_commande_att);
    }

    public ObservableList<Commande> getData_commande_att() {
        return data_commande_att;
    }

    public TableView<Commande> getTab_attente() {
        return tab_attente;
    }

    public void setValInfAB(String ValInfAB) {
        this.ValInfAB.setText(ValInfAB);
    }

    public void setValInfR(String ValInfR) {
        this.ValInfR.setText(ValInfR);
    }

    public void setValInfNBSlot(String ValInfNBSlot) {
        this.ValInfNBSlot.setText(ValInfNBSlot);
    }

    public void setValInfoNBSol(String ValInfoNBSol) {
        this.ValInfoNBSol.setText(ValInfoNBSol);
    }
    
    public void setValInfoPlaque(String ValInfoPlaque) {
        this.ValInfoPlaque.setText(ValInfoPlaque);
    }
    
    /**
     * Nettoyage des informations affichées pour la solutions en attente
     */
    public void clearInfoSolAttente(){
        setValInfAB("");
        setValInfR("");
        setValInfNBSlot("");
        setValInfoPlaque("");
        setValInfoNBSol("");
        dataInfoSol.clear();
        
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Attribut: Tableau des solution des expériences en attente
    @FXML
    private TableView<Solutions> TableInfoSol;

    @FXML
    private TableColumn<Solutions, String> InfoAB;

    @FXML
    private TableColumn<Solutions, String> InfoCell;

    @FXML
    private TableColumn<Solutions, String> InfoTypeCell;
    
    private ObservableList<Solutions> dataInfoSol = FXCollections.observableArrayList();;
    
    private void initTableInfoSol(){
        initColumnInfoSol();
    }
    
    /**
     * Initialisation des colonnes
     */
    private void initColumnInfoSol(){
        InfoAB.setCellValueFactory(new PropertyValueFactory<>("qt_ab"));
        InfoCell.setCellValueFactory(new PropertyValueFactory<>("qt_cell"));
        InfoTypeCell.setCellValueFactory(new PropertyValueFactory<>("ty_cell"));
    }
    
    /**
     * Chargement des données
     * @param dataInfoSol 
     */
    public void loadInfoData(ObservableList<Solutions> dataInfoSol) {
        TableInfoSol.setItems(dataInfoSol);
    }

    public ObservableList<Solutions> getData_InfoSol() {
        return dataInfoSol;
    }

    public TableView<Solutions> getTab_InfoSol() {
        return TableInfoSol;
    }

    public void setDataInfo (ObservableList<Solutions> Data){
        dataInfoSol.clear();
        dataInfoSol.addAll(Data);
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Attributs: Tableau pour les solutions dans la partie nouvelle commande
    @FXML
    private TableView<Solutions> tab_Solutions;
       
    @FXML
    private TableColumn<Solutions, String> col_sol_qt_ab;

    @FXML
    private TableColumn<Solutions, String> col_sol_qt_cell;

    @FXML
    private TableColumn<Solutions, String> col_sol_ty_cell;
    
    private ObservableList<Solutions> data_table_sol, dataSol;
    
    private ObservableList <String> type_cell = 
            FXCollections.observableArrayList(
            "Normales",
            "Cancéreuse"
            );

    //Tableau pour les solutions dans la partie nouvelle commande
    /**
     * Construction du tableau solutions
     */
    private void initTableSol(){
        initColumnSol();
    }
    
    /**
     * Initialisation des colonnes
     */
    private void initColumnSol(){
        col_sol_qt_ab.setCellValueFactory(new PropertyValueFactory<>("qt_ab"));
        col_sol_qt_cell.setCellValueFactory(new PropertyValueFactory<>("qt_cell"));
        col_sol_ty_cell.setCellValueFactory(new PropertyValueFactory<>("ty_cell"));
        editTableColumnSol();
    }
    
    /**
     * la classe editTableColumnSol permet de rendre les cellules éditable et d'enregistrer les nouvelles valeurs
     */
    private void editTableColumnSol(){
        col_sol_qt_ab.setCellFactory(TextFieldTableCell.forTableColumn());
        col_sol_qt_ab.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setQt_ab(e.getNewValue());
        });
        col_sol_qt_cell.setCellFactory(TextFieldTableCell.forTableColumn());
        col_sol_qt_cell.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setQt_ab(e.getNewValue());
        });
        col_sol_ty_cell.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), type_cell));
        col_sol_ty_cell.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setQt_ab(e.getNewValue());
        });
        
        tab_Solutions.setEditable(true);
    }
    
    /**
     * Classe qui écoute le bouton d'ajout de ligne au tableau des solutions
     */
    @FXML
    protected void addSolutions(ActionEvent event) {
        dataSol = tab_Solutions.getItems();
        if (spinnerAB.getValue()== 0 | spinnerQsol.getValue()== 0){
            Label_error_vide.setVisible(true);
        }
        else{
            Label_error_vide.setVisible(false);
            dataSol.add(new Solutions(1,String.valueOf(spinnerAB.getValue()),
                String.valueOf(spinnerQsol.getValue()),
                "normal",new Button("Voir"),null,
                this
            ));
            dataSol.add(new Solutions(1,String.valueOf(spinnerAB.getValue()),
                (String.valueOf(spinnerQsol.getValue())),
                "cancéreuse",new Button("Voir"),null,
                this
            ));
        }
        
        spinnerAB.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000,0));
        spinnerQsol.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000,0));
        Label_error_sol.setVisible(false);
    }
    
    /**
     * loadDataSol permet de mettre les données dans le tableview
     */
    private void loadDataSol() {
        dataSol = FXCollections.observableArrayList();
        tab_Solutions.setItems(dataSol);
    }

    public ObservableList<Solutions> getData_table_sol() {
        return dataSol;
    }

    public TableView<Solutions> getTab_Solutions() {
        return tab_Solutions;
    }

    public TableColumn<Solutions, String> getCol_sol_qt_cell() {
        return col_sol_qt_cell;
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Tableau des expériences en cours
    
    @FXML
    private TableView<Commande> tab_en_cours;

    @FXML
    private TableColumn<Commande, String> col_att_num_commande1;

    @FXML
    private TableColumn<Commande, String> col_att_date_commande1;

    @FXML
    private TableColumn<Commande, String> col_att_type_exp_commande1;

    @FXML
    private TableColumn<Commande, String> col_att_d1;

    @FXML
    private TableColumn<Commande, String> col_att_f1;

    @FXML
    private TableColumn<Commande, String> col_att_info1;

    @FXML
    private TableColumn<Commande, String> col_att_assignation1;
    
    private ObservableList<Commande> data_commande_en_cours= FXCollections.observableArrayList();
    
    //Tableau pour les commandes en cours
    /**
     * Construction du tableau en cours
     */
    private void initTable_commande_en_cours(){
        initColumn_commande_en_cours();

    }
    
    /**
     * Initialisation des colonnes
     */
    private void initColumn_commande_en_cours(){
        col_att_num_commande1.setCellValueFactory(new PropertyValueFactory<>("num"));
        col_att_date_commande1.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_att_type_exp_commande1.setCellValueFactory(new PropertyValueFactory<>("type_exp"));
        col_att_d1.setCellValueFactory(new PropertyValueFactory<>("d"));
        col_att_f1.setCellValueFactory(new PropertyValueFactory<>("f"));
        col_att_info1.setCellValueFactory(new PropertyValueFactory<>("bouttonInfo"));
        col_att_assignation1.setCellValueFactory(new PropertyValueFactory<>("bouttonAss"));
    

    }

    /**
    * loadData permet mettre les données dans le tableview
    */
    private void loadData_commande_en_cours(ObservableList<Commande> data_commande_en_cours) {
        tab_en_cours.setItems(data_commande_en_cours);
    }
    
    public ObservableList<Commande> getData_commande_en_cours() {
        return data_commande_en_cours;
    }
     
    /**
     * Ajoute des données au tableau
     * @param com 
     */
    public void addData_commande_en_cours(Commande com) {
        data_commande_en_cours.add(com);
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    //Attribut: Tableau des solution dans les expériences en cours
    @FXML
    private TableView<Solutions> TableInfoSol1;

    @FXML
    private TableColumn<Solutions, String> InfoAB1;

    @FXML
    private TableColumn<Solutions, String> InfoCell1;

    @FXML
    private TableColumn<Solutions, String> InfoTypeCell1;
    
    @FXML
    private TableColumn<Solutions, String> boutonpos;
    
    
    private ObservableList<Solutions> dataInfoSolc = FXCollections.observableArrayList();;
    
    
    //Tableau des solutions des expériences en cours
    
    /**
     * Initialisation des tableaux
     */
    private void initTableInfoSolc(){
        initColumnInfoSolc();
    }
    
    /**
     * Initialisation des colonnes
     */
    private void initColumnInfoSolc(){
        InfoAB1.setCellValueFactory(new PropertyValueFactory<>("qt_ab"));
        InfoCell1.setCellValueFactory(new PropertyValueFactory<>("qt_cell"));
        InfoTypeCell1.setCellValueFactory(new PropertyValueFactory<>("ty_cell"));
        boutonpos.setCellValueFactory(new PropertyValueFactory<>("boutonpos"));
    }
    
    /**
     * Chargement des données
     * @param dataInfoSolc Liste des solutions
     */
    public void loadInfoDatac(ObservableList<Solutions> dataInfoSolc) {
        TableInfoSol1.setItems(dataInfoSolc);
    }

    public ObservableList<Solutions> getData_InfoSolc() {
        return dataInfoSolc;
    }

    public TableView<Solutions> getTab_InfoSolc() {
        return TableInfoSol1;
    }

    public void setDataInfoc (ObservableList<Solutions> Data){
        dataInfoSolc.clear();
        dataInfoSolc.addAll(Data);
    }

    public void setValInfAB1(String ValInfAB1) {
        this.ValInfAB1.setText(ValInfAB1);
    }

    public void setValInfR1(String ValInfR1) {
        this.ValInfR1.setText(ValInfR1);
    }

    public void setValInfNBSlot1(String ValInfNBSlot1) {
        this.ValInfNBSlot1.setText(ValInfNBSlot1);
    }

    public void setValInfoPlaque1(String ValInfoPlaque1) {
        this.ValInfoPlaque1.setText(ValInfoPlaque1);
    }

    public void setValInfoNBSol1(String ValInfoNBSol1) {
        this.ValInfoNBSol1.setText(ValInfoNBSol1);
    }
    
    /**
     * Nettoyage des informations sur les solutions des expériences en cours
     */
    public void clearInfoSolCours(){
        setValInfAB1("");
        setValInfR1("");
        setValInfNBSlot1("");
        setValInfoPlaque1("");
        setValInfoNBSol1("");
        dataInfoSolc.clear();
        data.clear();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //les positions des solutions de l'expérience en cours
    ObservableList<String> data = FXCollections.observableArrayList();
    
    /**
     * Chergement des positions des solutions
     * @param data 
     */
    private void populateData(ObservableList<String> data) {
        listpos.setItems(data);
    }

    /**
     * Ajout des positions de la soltion
     * @param pos 
     */
    public void addPos(ObservableList<String> pos){
        data.clear();
        data.addAll(pos);
    }

    
    // Les itialisations
    
    /**
     * initialize: tous les attributs sont initialisés
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        loadData(data_commande_att);
        initTableSol();
        loadDataSol();
        initTable_commande_en_cours();
        loadData_commande_en_cours(data_commande_en_cours);
        initTableInfoSol();
        loadInfoData(dataInfoSol);
        initTableInfoSolc();
        loadInfoDatac(dataInfoSolc);
        allNotVisible();
        initializeSpinner();
        populateData(data);
        vBoxMenu.setVisible(false);
        Label_error_vide.setTextFill(Color.web("red"));
        Label_error_sol.setTextFill(Color.web("red"));
        Label_error.setTextFill(Color.web("red"));
        Comboexp.setItems(comboList);
        paneConnexion.setVisible(true);
        buttonDeco.setDisable(true);
        btn_a_renouv.setDisable(true);
        btn_valide.setDisable(true);
        comboReactC.setDisable(true);
        comboReactC.setVisible(true);
        comboReactO.setVisible(false);
    }
    
    
    public void setMain(ApplicationBiotech main){
     this.main=main;
    }

    public ApplicationBiotech getMain() {
        return main;
    }
    
    /**
     * Initialisation des spinners
     */
    public void initializeSpinner(){
        spinnerAB.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000,0));
        spinnerAB.setEditable(true);
        spinnerQsol.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000,0));
        spinnerQsol.setEditable(true);
        spinnerSlot.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerSlot.setEditable(false);
        spinnerFreq.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerFreq.setEditable(false);
        spinnerDuree.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerDuree.setEditable(false);
        spinnerRa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,255,0));
        spinnerRa1.setEditable(false);
        spinnerRa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,255,0));
        spinnerRa2.setEditable(false);
        spinnerRa3.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,1,0,0.1));
        spinnerRa3.setEditable(false);
        spinnerBa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,255,0));
        spinnerBa1.setEditable(false);
        spinnerBa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,255,0));
        spinnerBa2.setEditable(false);
        spinnerVa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,255,0));
        spinnerVa1.setEditable(false);
        spinnerVa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,255,0));
        spinnerVa2.setEditable(false);
        spinnerTa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,255,0));
        spinnerTa1.setEditable(false);
        spinnerTa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,255,0));
        spinnerTa2.setEditable(false);
    }

    public String getId_connexion() {
        return id_connexion;
    }
    
    /**
     * Enlève l'ensemble des disable
     */
    public void falseDisable(){
        //bouton de menu non accesible
        commande.setDisable(false);
        btn_attente.setDisable(false);
        btn_en_cours.setDisable(false);
        //btn_valide.setDisable(false);
        
        paneTableARenouv.setDisable(false);
        paneTableAttente.setDisable(false);
        PaneCommande.setDisable(false);
        paneTableEnCours.setDisable(false);
        paneVerif.setVisible(false);
        paneSolutionsCommande.setDisable(false);
    }
    
    /**
     * Classe qui met tous les panes en non visible
     */
    public void allNotVisible(){
        //les panes
        PaneCommande.setVisible(false);
        paneTableEnCours.setVisible(false);
        paneConnexion.setVisible(false);
        paneVerif.setVisible(false);
        paneTableAttente.setVisible(false);
        paneTableARenouv.setVisible(false);
        paneSolutionsCommande.setVisible(false);
        paneLabelAttente.setVisible(false);
        paneLabel.setVisible(false);
        paneLabelRenouv.setVisible(false);
        paneLabelCours.setVisible(false);
        paneLabelSol.setVisible(false);
        
        //les labels
        Label_error_vide.setVisible(false);
        Label_error_sol.setVisible(false);
        labelErrorConnexion.setVisible(false);
        Label_error.setVisible(false);
        frequenceLabel.setVisible(false);
        spinnerFreq.setVisible(false);
        spinnerRa3.setVisible(false);
        a3RougeLabel.setVisible(false);
    }
    
}
