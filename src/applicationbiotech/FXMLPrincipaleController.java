/*
 * Application pour gérer les données de laboratoire
 */
package applicationbiotech;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.util.converter.DefaultStringConverter;

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
    private RadioButton radioOui;
     
    @FXML
    private RadioButton radioNon;
    
    @FXML
    private RadioButton radio384;
    
    @FXML
    private RadioButton radio96;
    
    

    
    
    //ComboBox
    @FXML 
    private ComboBox comboAgent;
    
    @FXML 
    private ComboBox Comboexp;
    
    private ObservableList <String> AgentList = 
            FXCollections.observableArrayList(
            "fraise",
            "citron",
            "orange"
            );
        
    
     private ObservableList <String> comboList = 
            FXCollections.observableArrayList(
            "colorimétrique",
            "opacimétrique"
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
      
    //Field
    
    @FXML 
    private TextField ab_field;
    
    
    @FXML 
    private TextField cell_field;
    
    @FXML
    private TextField identifiantText;
    
    @FXML
    private TextField mdpText;
    
    
    
//Pour la commande
    /**
     * Cette class annule la commande et écoute les deux bouttons annuler
     * les valeurs sont réinitialisées
     * @param e 
     */
    public void handleButtonAnnuler (ActionEvent e){
       paneSolutionsCommande.setVisible(false);
       PaneCommande.setVisible(false);
       comboAgent.getSelectionModel().clearSelection();
       Comboexp.getSelectionModel().clearSelection();
        radio384.setSelected(false);
       radio96.setSelected(false);
       radioOui.setSelected(false);
       radioNon.setSelected(false);
       commande.setDisable(false);
       btn_attente.setDisable(false);
       data_table_sol.removeAll(tab_Solutions.getItems());
       Label_error_sol.setVisible(false);
       Label_error.setVisible(false);
       frequenceLabel.setVisible(false);
       spinnerFreq.setVisible(false);
       spinnerRa3.setVisible(false);
       a3RougeLabel.setVisible(false);
       spinnerSlot.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerFreq.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerRa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerRa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerRa3.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,1,0,0.1));
       spinnerBa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerBa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerVa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerVa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerTa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerTa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
       spinnerDuree.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
           
    }
    
    //Pour le menu
    public void handleButtonCommande(ActionEvent event) throws SQLException {
        
        paneLabel.setVisible(true);
        PaneCommande.setVisible(true);
        commande.setDisable(true);
        btn_attente.setDisable(false);
        paneTableAttente.setVisible(false);
        paneTableEnCours.setVisible(false);
        paneTableARenouv.setVisible(false);
        paneConnexion.setVisible(false);
        String requete = "select id_agent, nom_agent from agent_bio";
        ObservableList <String> list_ab = FXCollections.observableArrayList();
        System.out.println(main);
        System.out.println(main.getCon());
        System.out.println("print");
        Statement st = main.getCon().createStatement();
        ResultSet rs = st.executeQuery(requete);
        while (rs.next()){ 
            list_ab.add(rs.getString("id_agent")+rs.getString("nom_agent"));
        }

        comboAgent.setItems(list_ab);

        }
    
    public void handleMenuAttente(ActionEvent event) {
        paneTableAttente.setVisible(true);
        PaneCommande.setVisible(false);
        paneLabel.setVisible(false);
        paneTableEnCours.setVisible(false);
        commande.setDisable(false);
        paneConnexion.setVisible(false);
    }
    
       public void handlebuttoneExp_en_cours (ActionEvent event){
        
        paneTableEnCours.setVisible(true);
        paneTableAttente.setVisible(false);
        PaneCommande.setVisible(false);
        paneLabel.setVisible(false); 
        paneTableARenouv.setVisible(false);
        commande.setDisable(false);
        paneConnexion.setVisible(false);
        
    }
       public void handlebutton_a_renouv (ActionEvent event){
        
        paneTableARenouv.setVisible(true);
        paneTableAttente.setVisible(false);
        PaneCommande.setVisible(false);
        paneLabel.setVisible(false);
        paneTableEnCours.setVisible(false);
        commande.setDisable(false);
        paneConnexion.setVisible(false);
        
    }
       
       public void handleButtonConnexion (ActionEvent event ) throws SQLException{
        
         String requete = "Select id_personnel  from connexion where identifiant_co =" + identifiantText.getText()+ " and mdp_co = " + mdpText.getText() ;            
         System.out.println(main);
         System.out.println(main.getCon());
         System.out.println("print");
         Statement st1 = main.getCon().createStatement();
         ResultSet rs1 = st1.executeQuery(requete);
         if (!rs1.next()){
             infoBox("Please enter correct Email and Password", null, "Failed");
         }else{
             infoBox("Login Successfull",null,"Success" );
             String requete2 = "select actif personnel_labo where id_personnel="+rs1.next();
             System.out.println(main);
             System.out.println(main.getCon());
             System.out.println("print");
             Statement st2 = main.getCon().createStatement();
             ResultSet rs2 = st2.executeQuery(requete);
                int id = rs2.getInt(1);
                    if (id == 0){
                        infoBox("votre compte n'est plus actif",null,"Success" );                    
             }
                    if (id == 1 ){
                        String requete3 = "SELECT poste from echnom";
                    }
                    
                    
             
            
         
         }      
           
         paneConnexion.setVisible(false);
         commande.setDisable(false);
         btn_attente.setDisable(false);
         btn_en_cours.setDisable(false);
         btn_a_renouv.setDisable(false);
         btn_valide.setDisable(false);
           
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
    
    public void handleButtonValiderComSol (ActionEvent e){
        if (data_table_sol.isEmpty()){
            Label_error_sol.setVisible(true);
            Label_error_vide.setVisible(false);
        }
        else{
            System.out.println(new Button("Scanner plaque"));
            System.out.println(new Button("Scanner plaque"));
            
            if (radio384.isSelected()) {
            data_commande_att.add(new Commande(String.valueOf(1), String.valueOf(comboAgent.getValue()), String.valueOf(Comboexp.getValue()), String.valueOf(spinnerSlot.getValue()),spinnerDuree.getValue()+", "+spinnerFreq.getValue(),new Button("je prends"), data_table_sol, "384", this ));
            paneSolutionsCommande.setVisible(false);
            radioOui.setSelected(false);
            radioNon.setSelected(false);
            comboAgent.getSelectionModel().clearSelection();
            Comboexp.getSelectionModel().clearSelection();
            radio384.setSelected(false);
            radio96.setSelected(false);
            spinnerSlot.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerFreq.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerRa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerRa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerRa3.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,1,0,0.1));
            spinnerBa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerBa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerVa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerVa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerTa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerTa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerDuree.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            data_table_sol.removeAll(tab_Solutions.getItems());
            commande.setDisable(false);
            btn_attente.setDisable(false);
            frequenceLabel.setVisible(false);
            spinnerFreq.setVisible(false);
            spinnerRa3.setVisible(false);
            a3RougeLabel.setVisible(false);
            Label_error_sol.setVisible(false);
            Label_error.setVisible(false);
            spinnerSlot.setValueFactory( new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            }
            
        if (radio96.isSelected()) {
            data_commande_att.add(new Commande(String.valueOf(1), String.valueOf(comboAgent.getValue()), String.valueOf(Comboexp.getValue()), String.valueOf(spinnerSlot.getValue()),spinnerDuree.getValue()+", "+spinnerFreq.getValue(),new Button("je prends"), data_table_sol, "96", this ));
            paneSolutionsCommande.setVisible(false);
            radioOui.setSelected(false);
            radioNon.setSelected(false);
            comboAgent.getSelectionModel().clearSelection();
            Comboexp.getSelectionModel().clearSelection();
            radio384.setSelected(false);
            radio96.setSelected(false);
            spinnerSlot.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerFreq.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerRa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerRa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerRa3.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,1,0,0.1));
            spinnerBa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerBa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerVa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerVa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerTa1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerTa2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            spinnerDuree.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            data_table_sol.removeAll(tab_Solutions.getItems());
            commande.setDisable(false);
            btn_attente.setDisable(false);
            frequenceLabel.setVisible(false);
            spinnerFreq.setVisible(false);
            spinnerRa3.setVisible(false);
            a3RougeLabel.setVisible(false);
            Label_error_sol.setVisible(false);
            Label_error.setVisible(false);
            spinnerSlot.setValueFactory( new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0));
            }
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
//    
    
 
    
   
 

    //Attributs: Tableau pour les commandes en attente
    @FXML
    private TableView<Commande> tab_attente;
       
    @FXML
    private TableColumn<Commande, String> col_att_num_commande;

    @FXML
    private TableColumn<Commande, String> col_att_ab_commande;

    @FXML
    private TableColumn<Commande, String> col_att_type_exp_commande;

    @FXML
    private TableColumn<Commande, String> col_att_nb_slot_commande;

    @FXML
    private TableColumn<Commande, String> col_att_d_f;

    @FXML
    private TableColumn<Commande, String> col_att_nb_sol;

    @FXML
    private TableColumn<Commande, Button> col_att_assignation;
    
    private ObservableList<Commande> data_commande_att= FXCollections.observableArrayList();
    
    
    //Tableau pour les commandes en attente
    /**
     * Construction du tableau d'attente
     */
    private void initTable(){
        initColumn();
    }
    
    private void initColumn(){
        col_att_num_commande.setCellValueFactory(new PropertyValueFactory<>("num"));
        col_att_ab_commande.setCellValueFactory(new PropertyValueFactory<>("ab"));
        col_att_type_exp_commande.setCellValueFactory(new PropertyValueFactory<>("type_exp"));
        col_att_nb_slot_commande.setCellValueFactory(new PropertyValueFactory<>("nb_slot"));
        col_att_d_f.setCellValueFactory(new PropertyValueFactory<>("d_f"));
        col_att_nb_sol.setCellValueFactory(new PropertyValueFactory<>("nb_sol"));
        col_att_assignation.setCellValueFactory(new PropertyValueFactory<>("boutton"));
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
    
    
    
    //Attributs: Tableau pour les commandes en attente
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

    //Tableau pour les commandes en attente
    /**
     * Construction du tableau d'attente
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
        if (ab_field.getText().isEmpty() | cell_field.getText().isEmpty()){
            Label_error_vide.setVisible(true);
        }
        else{
            Label_error_vide.setVisible(false);
            dataSol.add(new Solutions(ab_field.getText(),
                cell_field.getText(),
                "Normales",
                this
            ));
            dataSol.add(new Solutions(ab_field.getText(),
                cell_field.getText(),
                "Cancéreuse",
                this
            ));
        }
        
        ab_field.setText("");
        cell_field.setText("");
        Label_error_sol.setVisible(false);
    }
    
    /**
     * loadDataSol permet mettre les données dans le tableview
     */
    private void loadDataSol() {
        data_table_sol = FXCollections.observableArrayList();
        tab_Solutions.setItems(data_table_sol);
    }

    public ObservableList<Solutions> getData_table_sol() {
        return data_table_sol;
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
        Label_error_vide.setVisible(false);
        Label_error_vide.setTextFill(Color.web("red"));
        Label_error_sol.setTextFill(Color.web("red"));
        Label_error.setTextFill(Color.web("red"));
        Label_error_sol.setVisible(false);
        Label_error.setVisible(false);
        commande.setDisable(true);
        btn_attente.setDisable(true);
        btn_en_cours.setDisable(true);
        btn_a_renouv.setDisable(true);
        btn_valide.setDisable(true);
        PaneCommande.setVisible(false);
        paneTableEnCours.setVisible(false);
        comboAgent.setItems(AgentList);
        Comboexp.setItems(comboList);
        paneConnexion.setVisible(true);
        
        paneTableAttente.setVisible(false);
        frequenceLabel.setVisible(false);

        spinnerFreq.setVisible(false);
        spinnerRa3.setVisible(false);
        a3RougeLabel.setVisible(false);
        
      
          SpinnerValueFactory<Integer> valueSlot = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);         
          spinnerSlot.setValueFactory(valueSlot);
          
          SpinnerValueFactory<Integer> valueFreq = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0); 
          spinnerFreq.setValueFactory(valueFreq);
          
          SpinnerValueFactory<Integer> valueDuree = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0); 
          spinnerDuree.setValueFactory(valueDuree);
          
          SpinnerValueFactory<Integer> valueRa1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0); 
          spinnerRa1.setValueFactory(valueRa1);
          
          SpinnerValueFactory<Integer> valueRa2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
         spinnerRa2.setValueFactory(valueRa2);
         
         SpinnerValueFactory<Double> valueRa3 = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,1,0,0.1);
         spinnerRa3.setValueFactory(valueRa3);
         
         SpinnerValueFactory<Integer> valueBa1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
         spinnerBa1.setValueFactory(valueBa1);
         
         SpinnerValueFactory<Integer> valueBa2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
         spinnerBa2.setValueFactory(valueBa2);
         
         
         SpinnerValueFactory<Integer> valueVa1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
         spinnerVa1.setValueFactory(valueVa1);
         
         SpinnerValueFactory<Integer> valueVa2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
         spinnerVa2.setValueFactory(valueVa2);
         
         
         SpinnerValueFactory<Integer> valueTa1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
         spinnerTa1.setValueFactory(valueTa1);
         
         SpinnerValueFactory<Integer> valueTa2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
         spinnerTa2.setValueFactory(valueTa2 );
                       
         
    }
    public void setMain(ApplicationBiotech main){
     this.main=main;
    }

    private void infoBox(String please_enter_correct_Email_and_Password, Object object, String failed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
