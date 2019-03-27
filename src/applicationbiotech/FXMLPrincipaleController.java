/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationbiotech;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author gphy
 */
public class FXMLPrincipaleController implements Initializable {
    
        ObservableList <String> AgentList = 
            FXCollections.observableArrayList(
            "fraise",
            "citron",
            "orange"
            );
        
    
        ObservableList <String> comboList = 
            FXCollections.observableArrayList(
            "colorimétrique",
            "opacimétrique"
            );
        
        ObservableList <String> plaqueList = 
            FXCollections.observableArrayList(
            "394",
            "96"
            );

    
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane paneGestion;

    @FXML
    private Pane PaneCommande;

    @FXML
    private Pane paneLabel;

    @FXML
    private Button btn_to_sol;

    @FXML
    private Button commande;

    @FXML
    private Button btn_attente;

    @FXML
    private Pane paneTableAttente;

    @FXML
    private Pane paneLabel1;
    
    @FXML
    private Pane paneSolutionsCommande ; 

    @FXML
    private Button btn_valider_commande; 

    @FXML
    private Button btn_retour_inf_g;

    @FXML
    private Button btn_annuler_commande;

    @FXML
    private Pane pane;
    
    @FXML
    private Pane pane_attente;
    
    @FXML
    private ObservableList<Commande> data_table;
    
    @FXML 
    private ComboBox comboAgent;
    
    @FXML 
    private ComboBox Comboexp;
    
    @FXML 
    private ComboBox comboTypePlaque;
    
    @FXML
    private Label frequenceLabel;
    
     @FXML
     private TextField frequenceField;
     
     @FXML
     private Label a3TransparenceLabel;
     
     @FXML
     private TextField a3TransparenceField;
     
     @FXML
     private Label a3RougeLabel;
     
     @FXML
     private TextField a3RougeField;
     
     @FXML
     private Label a3BleuLabel;
     
     @FXML
     private TextField a3BleuField;
     
     @FXML
     private Label a3VertLabel;
     
     @FXML
     private TextField a3VertField;



    public void handleButtonCommande(ActionEvent event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        //pane_attente.setVisible(false); 
        paneLabel.setVisible(true);
        PaneCommande.setVisible(true);
        

    }
    
    public void handleButtonValider (ActionEvent e){
       //System.out.println("You clicked me!");
       paneSolutionsCommande.setVisible(true);
       PaneCommande.setVisible(false);
        
    }
    
    public void handleButtonRetour (ActionEvent f){
    //System.out.println("You clicked me!");
    paneSolutionsCommande.setVisible(false);
    PaneCommande.setVisible(true);
    }
    
    
    
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
    

    @FXML
    public void handleMenuAttente(ActionEvent event) {
        paneTableAttente.setVisible(true);
        PaneCommande.setVisible(false);
        paneLabel.setVisible(false);
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        loadData();
        PaneCommande.setVisible(false);
        comboAgent.setItems(AgentList);
        Comboexp.setItems(comboList);
        comboTypePlaque.setItems(plaqueList);
        paneTableAttente.setVisible(false);
        
        frequenceLabel.setVisible(false);
        frequenceField.setVisible(false);
        a3VertField.setVisible(false);
        a3VertLabel.setVisible(false);
        a3BleuField.setVisible(false);
        a3BleuLabel.setVisible(false);
        a3RougeField.setVisible(false);
        a3RougeLabel.setVisible(false);
        a3TransparenceField.setVisible(false);
        a3TransparenceLabel.setVisible(false);
                
        
    }    
    
    private void initTable(){
        initColumn();
    }
    
    private void initColumn(){
        //num, ab, type_exp, nb_slot, d_f, nb_sol;
        col_att_num_commande.setCellValueFactory(new PropertyValueFactory<>("num"));
        col_att_ab_commande.setCellValueFactory(new PropertyValueFactory<>("ab"));
        col_att_type_exp_commande.setCellValueFactory(new PropertyValueFactory<>("type_exp"));
        col_att_nb_slot_commande.setCellValueFactory(new PropertyValueFactory<>("nb_slot"));
        col_att_d_f.setCellValueFactory(new PropertyValueFactory<>("d_f"));
        col_att_nb_sol.setCellValueFactory(new PropertyValueFactory<>("nb_sol"));
        col_att_assignation.setCellValueFactory(new PropertyValueFactory<>("assignation"));
        editTableColumn();
    }
    
    private void editTableColumn(){
        
    }
    
    private void loadData() {
        data_table = FXCollections.observableArrayList();
        for( int i=0; i<7;i++){
            //data_table.add(new Commande(String.valueOf(i),"ab"+i,'type_exp'+i,"nb_slot"+i,"df"+i,"nb_sol"+i, new Button("je prends")));
            data_table.add(new Commande(String.valueOf(i),"ab","t","s","df","n", new Button("je prends"),this));
        }
        tab_attente.setItems(data_table);
    }

    public ObservableList<Commande> getData_table() {
        return data_table;
    }

    public TableView<Commande> getTab_attente() {
        return tab_attente;
    }
    
    
    
}
