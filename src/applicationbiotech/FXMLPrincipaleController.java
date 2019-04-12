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

/**
 * FXMLPrincipaleController  est la classe avec les différents écouteurs 
 * @author Germain Natasha Grell Leyla
 * @version 28/03/2019
 * 
 */
public class FXMLPrincipaleController implements Initializable {
    ApplicationBiotech main=null;
    //Attribut
    //Pane
    @FXML
    private VBox vBoxMenu;
    
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane paneGestion;

    @FXML
    private Pane PaneCommande;

    @FXML
    private Pane paneLabel;
    
    @FXML
    private Pane paneTableAttente;

    @FXML
    private Pane paneLabel1;
    
    @FXML
    private Pane paneSolutionsCommande ; 
    
    @FXML
    private Pane pane;
    
    @FXML
    private Pane pane_attente;
    
    @FXML 
    private Pane paneTableEnCours;
    
    @FXML
    private Pane paneTableARenouv;
    
    @FXML
    private Pane paneConnexion;
    
    @FXML
    private Pane paneVerif;
    
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
    private Button btn_to_sol;

    @FXML
    private Button commande;

    @FXML
    private Button btn_attente;
    
    @FXML
    private Button btn_annul;
    
    @FXML
    private Button btn_valider_commande; 

    @FXML
    private Button btn_retour_inf_g;

    @FXML
    private Button btn_annuler_commande;
    
    @FXML
    private Button btn_en_cours;
    
    @FXML
    private Button btn_a_renouv;
    
    @FXML
    private Button btn_valide;
    
    @FXML
    private Button buttonDeco;
     
    @FXML
    private RadioButton radioOui;
     
    @FXML
    private RadioButton radioNon;
    
    @FXML
    private RadioButton radio384;
    
    @FXML
    private RadioButton radio96;
    
     Button buttonModif = new Button("modifier");

    
    //ComboBox
    @FXML 
    private ComboBox comboAgent;
    @FXML 
    private ComboBox comboReact;
    
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
    
    @FXML
    private Label labelNom;
    

     
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
    private TextField ab_field;
    
    
    @FXML 
    private TextField cell_field;
    
    @FXML
    private TextField identifiantText;
    
    @FXML
    private TextField mdpText;
    
    private void showAlert(Alert.AlertType alertType, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    //alert.initOwner(owner);
    alert.show();
    }
    
    
    
//Pour la commande
    
    
    public void initializeCommande(){
        //nettoyage des données
       comboAgent.getSelectionModel().clearSelection();
       Comboexp.getSelectionModel().clearSelection();
       comboReact.getSelectionModel().clearSelection();
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
       paneSolutionsCommande.setVisible(false);
       PaneCommande.setVisible(false);
       paneLabel.setVisible(false);
       initializeCommande();
       //réglage du menu
       falseDisable();  
    }
    
    public void falseDisable(){
        //bouton de menu non accesible
        commande.setDisable(false);
        btn_attente.setDisable(false);
        btn_en_cours.setDisable(false);
        btn_a_renouv.setDisable(false);
        //btn_valide.setDisable(false);
        
        paneTableARenouv.setDisable(false);
        paneTableAttente.setDisable(false);
        PaneCommande.setDisable(false);
        paneTableEnCours.setDisable(false);
        paneVerif.setVisible(false);
        paneSolutionsCommande.setDisable(false);
    }
    
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
    
    
    //Pour le menu
    public void handleButtonCommande(ActionEvent event) throws SQLException {
        allNotVisible();
        falseDisable();
        commande.setDisable(true);
        btn_attente.setDisable(true);
        btn_en_cours.setDisable(true);
        btn_a_renouv.setDisable(true);
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
        list = FXCollections.observableArrayList();
        requete = "select id_reactif , nom_reactif from reactif ";
        rs = st.executeQuery(requete);
        while (rs.next()){ 
            list.add(rs.getString("id_reactif")+"-"+rs.getString("nom_reactif"));
        }

        comboReact.setItems(list);
        }
    
    
    
    
    public void handleMenuAttente(ActionEvent event) {
        allNotVisible();
        falseDisable();
        if("Laborantin".equals(labelPoste.getText())){
            commande.setDisable(true);
        }
        paneTableAttente.setVisible(true);
        paneLabelAttente.setVisible(true);
    }
    
    public void handlebuttoneExp_en_cours (ActionEvent event){
        allNotVisible();
        paneTableEnCours.setVisible(true);
            if("chercheur".equals(labelPoste.getText())){
                col_att_assignation1.setVisible(false);
        }
        
    }
        
    
    public void handlebutton_a_renouv (ActionEvent event){
        allNotVisible();
        paneTableARenouv.setVisible(true);
    }
       

    
    //connexion
    public void handleButtonConnexion (ActionEvent event ) throws SQLException{
        String sq1 = "Select id_personnel from connexion where identifiant_co = '"+identifiantText.getText()+"'and mdp_co = '" + mdpText.getText()+"'" ;                     
        Statement stmt = main.getCon().createStatement();
        ResultSet resultat = stmt.executeQuery(sq1);
         
        if (!resultat.next()){
            showAlert(Alert.AlertType.ERROR, "Erreur!", "Entrez un nom");
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
                    String requete3 = "SELECT id_chercheur from chercheur where id_personnel= '"+resultat.getString(1)+"'";
                    String requete4 = "SELECT id_laborantin from laborantin where id_personnel= '"+resultat.getString(1)+"'";
                    stmt = main.getCon().createStatement();
                    rs2 = stmt.executeQuery(requete4);
                                            
                    stmt = main.getCon().createStatement();
                    ResultSet rs3 = stmt.executeQuery(requete3);

                    //chercheur
                    if (rs3.next()){
                        paneConnexion.setVisible(false);
                        commande.setDisable(false);
                        btn_attente.setDisable(false);
                        btn_en_cours.setDisable(false);
                        btn_a_renouv.setDisable(false);
                        buttonDeco.setDisable(false);
                        labelPoste.setVisible(true);
                        labelPoste.setText("chercheur");
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
                                data_table_sol.add(new Solutions(rs2.getInt("id_ligne_commande"),rs2.getString("quantite_agent_biologique"),rs2.getString("quantite_cellules"),rs2.getString("type_cellule"),this));
                            }
                            data_commande_att.add(new Commande(rs3.getString("id_commande"), rs3.getString("nom_agent"), rs3.getString("date_co"), rs3.getString("type_experience"), rs3.getString("nombre_slots"),rs3.getString("duree"),rs3.getString("frequence"),new Button("Modifier"),new Button("Infos"), FXCollections.observableArrayList(data_table_sol), rs3.getString("type_de_plaque"),rs3.getString("nom_reactif"), this ));
                        }
                        data_table_sol=FXCollections.observableArrayList();
                    }
                                
                              
                     //Laborantin  
                    if (rs2.next()){
                        paneConnexion.setVisible(false);
                        btn_attente.setDisable(false);
                        btn_en_cours.setDisable(false);
                        btn_a_renouv.setDisable(false);                              
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
                            System.out.println(rs2.getString("id_commande"));
                            //chargement des lignes de commande
                            sq1="Select * from ligne_commande join cellule using(id_cellule) where id_commande='"+rs2.getString("id_commande")+"'";
                            stmt = main.getCon().createStatement();
                            rs3=stmt.executeQuery(sq1);
                            data_table_sol=FXCollections.observableArrayList();
                            while(rs3.next()){
                                System.out.println(rs3.getString("id_ligne_commande"));
                                data_table_sol.add(new Solutions(rs3.getInt("id_ligne_commande"),rs3.getString("quantite_agent_biologique"),rs3.getString("quantite_cellules"),rs3.getString("type_cellule"),this));
                            }
                            System.out.println(rs2.getString("nom_agent"));
                            System.out.println(rs2.getString("date_co"));
                            System.out.println(rs2.getString("type_experience"));
                            System.out.println(rs2.getString("nombre_slots"));
                            System.out.println(rs2.getString("duree"));
                            System.out.println(rs2.getString("frequence"));
                            System.out.println(rs2.getString("type_de_plaque"));
                            System.out.println(rs2.getString("nom_reactif"));
                            System.out.println(rs2.getString("id_commande"));
                            
                            data_commande_att.add(new Commande(rs2.getString("id_commande"), rs2.getString("nom_agent"), rs2.getString("date_co"), rs2.getString("type_experience"), rs2.getString("nombre_slots"),rs2.getString("duree"),rs2.getString("frequence"),new Button("Je prends"),new Button("Infos"), FXCollections.observableArrayList(data_table_sol), rs2.getString("type_de_plaque"),rs2.getString("nom_reactif"), this ));
                        }
                        data_table_sol=FXCollections.observableArrayList();        
                                 
                    }
                        
                }         
            }      
           
        }
        resultat.close();
    }
         
       
    public void handleButtonDeco (ActionEvent e){
        paneTableARenouv.setDisable(true);
        paneTableAttente.setDisable(true);
        PaneCommande.setDisable(true);
        paneTableEnCours.setDisable(true);
        paneVerif.setVisible(true);
        commande.setDisable(true);
        btn_attente.setDisable(true);
        btn_en_cours.setDisable(true);
        btn_a_renouv.setDisable(true);
        paneSolutionsCommande.setDisable(true);
       }
       
       public void handleButtonDecoOui (ActionEvent e){
        allNotVisible();
        paneConnexion.setVisible(true);
        vBoxMenu.setVisible(false);
        labelIdentite.setText("");
        labelPoste.setVisible(false);
        identifiantText.setText("");
        mdpText.setText("");
        buttonDeco.setDisable(true);
        data_commande_att.clear();
        dataInfoSol.clear();
        initializeCommande();
        falseDisable();
        
        }
       
    public void handleButtonDecoNon (ActionEvent e){
          
        //Réinitialisation de des champs de la connexion
        falseDisable();
          
        //Réinitialisation des champs de la commande 
        initializeCommande();
       

       }
       

    
    //La commande :Les informations générales
    
    /**
     * Cette classe écoute les bouttons valider de commande informations générales
     * si des champs sont vides un message d'erreur s'affiche et le champs vide est écrit en rouge
     * sinon on passe à solutions et la couleur des champs est réinitialisé à noir
     * @param e 
     */
    public void handleButtonValider (ActionEvent e){
        if ((comboAgent.getValue() != null) && (spinnerSlot.getValue() != 0 )&&(Comboexp.getValue() != null) | (radio384.isSelected() == true ) | (radio96.isSelected() == true ) && (spinnerRa1.getValue() !=0) && (spinnerRa1.getValue() != 0) && (spinnerBa1.getValue() != 0 ) && (spinnerBa2.getValue() != 0) && (spinnerVa1.getValue() != 0 ) && (spinnerVa2.getValue() != 0) && (spinnerTa1.getValue() != 0) && (spinnerTa2.getValue() != 0 ) && (spinnerDuree.getValue() != 0) && (spinnerSlot.getValue() != 0) &&((radioOui.isSelected() == true && spinnerRa3.getValue() != 0 && spinnerFreq.getValue() != 0 )|(radioNon.isSelected() == true)) ) {           
            paneSolutionsCommande.setVisible(true);
            PaneCommande.setVisible(false);
            paneLabelSol.setVisible(true);
            paneLabel.setVisible(false);
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
            Label_error.setVisible(false);
        }
        else{
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
             }
             if (spinnerSlot.getValue()== 0){
                   slotLabel.setTextFill(Color.web("red")); 
             }
             if (radio384.isSelected() == false  ){
                    typePlaqueLabel.setTextFill(Color.web("red"));
             }
             
             if (radio96.isSelected() == false  ){
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
            
            
            if (radio384.isSelected()) {
                data_commande_att.add(new Commande(String.valueOf(1), String.valueOf(comboAgent.getValue()), String.valueOf(LocalDate.now()), String.valueOf(Comboexp.getValue()), String.valueOf(spinnerSlot.getValue()),String.valueOf(spinnerDuree.getValue()),String.valueOf(spinnerFreq.getValue()),buttonModif,new Button("Infos"), FXCollections.observableArrayList(dataSol), "384",String.valueOf(comboReact.getValue()), this ));
                Pattern p = Pattern.compile("-");
                String[] items = p.split(String.valueOf(comboAgent.getValue()));           
                String id_agent1 = items[0];
                System.out.println(id_agent1);
                
                Pattern p1 = Pattern.compile("-");
                String[] items1 = p1.split(String.valueOf(comboReact.getValue()));           
                String id_react1 = items1[0];
                System.out.println(id_react1);
                
                if (radioNon.isSelected()){
                    int  suivi =1; 
                    String frequence; 
                    String a3;
                }else{
                    int suivi =0;
                    String frequence = String.valueOf(spinnerFreq.getValue());
                    String a3 = String.valueOf(spinnerRa3.getValue());             
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
                            String requete3 = "INSERT INTO Commande VALUES (1,"+id_agent1+","+personnel.getString(1)+","+chercheur.getString(1)+","+id_react1+","+1+","+null+","+spinnerSlot.getValue()+","+spinnerDuree.getValue()+","+null+",'"+Comboexp.getValue()+"',384,"+null+","+spinnerVa2.getValue()+","+spinnerVa1.getValue()+","+spinnerBa2.getValue()+","+spinnerBa1.getValue()+","+spinnerTa1.getValue()+","+spinnerTa2.getValue()+","+spinnerRa1.getValue()+","+spinnerRa2.getValue()+")";                     
                            System.out.println("bouh");
                            Statement stmt3 = main.getCon().createStatement();
                            ResultSet resultat2 = stmt3.executeQuery(requete3);
                        }catch(SQLException o){
                            System.out.println(o.getMessage());
                        }

            
                }
            }
            }

            if (radio96.isSelected()) {           
                data_commande_att.add(new Commande(String.valueOf(1), String.valueOf(comboAgent.getValue()),String.valueOf(LocalDate.now()), String.valueOf(Comboexp.getValue()), String.valueOf(spinnerSlot.getValue()),String.valueOf(spinnerDuree.getValue()),String.valueOf(spinnerFreq.getValue()),buttonModif,new Button("Infos"), FXCollections.observableArrayList(dataSol), "96", String.valueOf(comboReact.getValue()), this ));
                Pattern p = Pattern.compile("-");
                String[] items = p.split(String.valueOf(comboAgent.getValue()));           
                String id_agent2 = items[0];
                System.out.println(id_agent2);
                
                Pattern p1 = Pattern.compile("-");
                String[] items1 = p1.split(String.valueOf(comboReact.getValue()));           
                String id_react2 = items1[0];
                System.out.println(id_react2);
            
             }

            paneSolutionsCommande.setVisible(false);
            initializeCommande();
            data_table_sol.removeAll(tab_Solutions.getItems());
            commande.setDisable(false);
            btn_attente.setDisable(false);   
            dataSol.clear();
        }
        
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
    
    
    //Tableau pour les commandes en attente
    /**
     * Construction du tableau d'attente
     */
    private void initTable(){
        initColumn();
    }
    
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

    
    //solution dans attente
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
    
    private void initColumnInfoSol(){
        InfoAB.setCellValueFactory(new PropertyValueFactory<>("qt_ab"));
        InfoCell.setCellValueFactory(new PropertyValueFactory<>("qt_cell"));
        InfoTypeCell.setCellValueFactory(new PropertyValueFactory<>("ty_cell"));
    }
    
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
    
    
    //Attributs: Tableau pour les solutions
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

    //Tableau pour les solutions
    /**
     * Construction du tableau solutions
     */
    private void initTableSol(){
        initColumnSol();
    }
    
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
                "Normales",
                this
            ));
            dataSol.add(new Solutions(1,String.valueOf(spinnerAB.getValue()),
                (String.valueOf(spinnerQsol.getValue())),
                "Cancéreuse",
                this
            ));
        }
        
        spinnerAB.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerQsol.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
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
    /**tableau en cours*/
    
    @FXML
    private TableView<Commande> tab_attente1;

    @FXML
    private TableColumn<Commande, String> col_att_num_commande1;

    @FXML
    private TableColumn<Commande, String> col_att_ab_commande1;

    @FXML
    private TableColumn<Commande, String> col_att_type_exp_commande1;

    @FXML
    private TableColumn<Commande, String> col_att_nb_slot_commande1;

    @FXML
    private TableColumn<Commande, String> col_att_d_f1;

    @FXML
    private TableColumn<Commande, String> col_att_nb_sol1;

    @FXML
    private TableColumn<Commande, String> col_att_assignation1;
    
    private ObservableList<Commande> data_commande_en_cours= FXCollections.observableArrayList();
    
    //Tableau pour les commandes en attente
    /**
     * Construction du tableau d'attente
     */
    private void initTable_commande_en_cours(){
        initColumn_commande_en_cours();

    }
    
    private void initColumn_commande_en_cours(){
        col_att_num_commande1.setCellValueFactory(new PropertyValueFactory<>("num"));
        col_att_ab_commande1.setCellValueFactory(new PropertyValueFactory<>("ab"));
        col_att_type_exp_commande1.setCellValueFactory(new PropertyValueFactory<>("type_exp"));
        col_att_nb_slot_commande1.setCellValueFactory(new PropertyValueFactory<>("nb_slot"));
        col_att_d_f1.setCellValueFactory(new PropertyValueFactory<>("d_f"));
        col_att_nb_sol1.setCellValueFactory(new PropertyValueFactory<>("nb_sol"));
        col_att_assignation1.setCellValueFactory(new PropertyValueFactory<>("boutton"));
    

    }
    
    

     /**
     * loadData permet mettre les données dans le tableview
     */
    
    
    private void loadData_commande_en_cours(ObservableList<Commande> data_commande_en_cours) {
        tab_attente1.setItems(data_commande_en_cours);
    }
    
       public ObservableList<Commande> getData_commande_en_cours() {
        return data_commande_en_cours;
    }
       
    public void addData_commande_en_cours(Commande com) {
        data_commande_en_cours.add(com);
    }
       
    

   
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
        allNotVisible();
        initializeSpinner();
        vBoxMenu.setVisible(false);
        Label_error_vide.setTextFill(Color.web("red"));
        Label_error_sol.setTextFill(Color.web("red"));
        Label_error.setTextFill(Color.web("red"));
        Comboexp.setItems(comboList);
        paneConnexion.setVisible(true);
        buttonDeco.setDisable(true);  
    }
    
    
    public void setMain(ApplicationBiotech main){
     this.main=main;
    }
    
    
    public void initializeSpinner(){
        spinnerAB.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerQsol.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerSlot.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerFreq.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerDuree.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerRa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerRa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerRa3.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,1,0,0.1));
        spinnerBa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerBa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerVa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerVa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerTa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
        spinnerTa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
    }

}
