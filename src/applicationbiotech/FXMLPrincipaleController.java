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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.converter.DefaultStringConverter;

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
    private ComboBox comboAgent;
    
    @FXML
    private Label agentLabel;
    
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
     
     @FXML
     private ToggleGroup myToggleGroup ;
     
     @FXML
     private RadioButton radioOui;
     
     @FXML
     private RadioButton radioNon;
     
     @FXML
     private TextField dureeField;
     
     @FXML
     private TextField a1RougeField;
     
     @FXML
     private TextField a2RougeField;
     
     @FXML
     private TextField a1BleuField;
     
     @FXML
     private TextField a2BleuField;
     
     @FXML
     private TextField a1VertField;
      
     @FXML
     private TextField a2VertField;
      
     @FXML
     private TextField a1TransparenceField;
     
     @FXML
     private TextField a2TransparenceField;
     
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
     private TextField slotField;
     
     @FXML
     private Label typePlaqueLabel;
     
     @FXML
     private Label typeExpLabel;
     
     @FXML
     private Label suiviLabel;
     
     
     

      
     





    public void handleButtonCommande(ActionEvent event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        //pane_attente.setVisible(false); 
        paneLabel.setVisible(true);
        PaneCommande.setVisible(true);
        

    }
    
    public void handleButtonValider (ActionEvent e){
        if ((comboAgent.getValue() != null) && (slotField.getText().isEmpty()!=true)&&(Comboexp.getValue() != null) && (comboTypePlaque.getValue() !=null) && (a1RougeField.getText().isEmpty() !=true) && (a2RougeField.getText().isEmpty() !=true) && (a1BleuField.getText().isEmpty() !=true) && (a2BleuField.getText().isEmpty() !=true) && (a1VertField.getText().isEmpty() !=true) && (a2VertField.getText().isEmpty() !=true) && (a1TransparenceField.getText().isEmpty() !=true) && (a2TransparenceField.getText().isEmpty() !=true) && (dureeField.getText().isEmpty() !=true) && (slotField.getText().isEmpty() !=true) &&((radioOui.isSelected() != true && a3RougeField.getText().isEmpty() !=true && a3VertField.getText().isEmpty() !=true && a3BleuField.getText().isEmpty() !=true && a3TransparenceField.getText().isEmpty() !=true && frequenceField.getText().isEmpty() !=true)|(radioNon.isSelected() != true)) ) {
            paneSolutionsCommande.setVisible(true);
            PaneCommande.setVisible(false);
        }
        else{
            //Label_error.setVisible(true);
             if ( comboAgent.getValue() == null  ){
                    agentLabel.setTextFill(Color.web("red"));
             }
             if (Comboexp.getValue() == null ){
                    typeExpLabel.setTextFill(Color.web("red")); 
             }
             if (slotField.getText().isEmpty()){
                    slotLabel.setTextFill(Color.web("red")); 
             }
             if (comboTypePlaque.getValue() == null ){
                    typePlaqueLabel.setTextFill(Color.web("red"));
             }
             if (radioOui.isSelected() == false && radioNon.isSelected() == false ){
                    suiviLabel.setTextFill(Color.web("red"));
             }
             if (radioOui.isSelected() == true){
                 suiviLabel.setTextFill(Color.web("black"));
                 if (a3RougeField.getText().isEmpty() ==true){
                     a3RougeLabel.setTextFill(Color.web("red"));
                 }
                 if (a3VertField.getText().isEmpty() ==true){
                     a3VertLabel.setTextFill(Color.web("red"));
                 }
                 if (a3BleuField.getText().isEmpty() ==true){
                     a3BleuLabel.setTextFill(Color.web("red"));
                 }
                 if (a3TransparenceField.getText().isEmpty() ==true){
                     a3TransparenceLabel.setTextFill(Color.web("red"));
                 }
                 if (frequenceField.getText().isEmpty() ==true){
                     frequenceLabel.setTextFill(Color.web("red"));
                 }
             }
             if (a1RougeField.getText().isEmpty() ==true ){
                 a1RougeLabel.setTextFill(Color.web("red"));
             }
             if (a2RougeField.getText() .isEmpty() ==true ){
                 a2RougeLabel.setTextFill(Color.web("red"));
             }
             if ( a1BleuField.getText().isEmpty() ==true ){
                 a1BleuLabel.setTextFill(Color.web("red"));
             }
             if (a2BleuField.getText().isEmpty() ==true  ){
                 a2BleuLabel.setTextFill(Color.web("red"));
             }
             if (a1VertField.getText().isEmpty() ==true  ){
                 a1VertLabel.setTextFill(Color.web("red"));
             }
             if (  a2VertField.getText().isEmpty() ==true  ){
                 a2VertLabel.setTextFill(Color.web("red"));
             }
             if (  a1TransparenceField.getText().isEmpty() ==true  ){
                 a1TransparenceLabel.setTextFill(Color.web("red"));
             }
             if (  a2TransparenceField.getText().isEmpty() ==true  ){
                 a2TransparenceLabel.setTextFill(Color.web("red"));
             }
             if (  dureeField.getText().isEmpty() ==true  ){
                 dureeLabel.setTextFill(Color.web("red"));
             }
        }
    }
             
                                          
    public void handleButtonRetour (ActionEvent f){
    //System.out.println("You clicked me!");
    paneSolutionsCommande.setVisible(false);
    PaneCommande.setVisible(true);
    }
    
        public void myGroupAction(ActionEvent action)
    {
       if(radioOui.isSelected()){
           
        frequenceLabel.setVisible(true);
        frequenceField.setVisible(true);
        a3VertField.setVisible(true);
        a3VertLabel.setVisible(true);
        a3BleuField.setVisible(true);
        a3BleuLabel.setVisible(true);
        a3RougeField.setVisible(true);
        a3RougeLabel.setVisible(true);
        a3TransparenceField.setVisible(true);
        a3TransparenceLabel.setVisible(true);
       }
       
        if(radioNon.isSelected()){
        
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
    
    private ObservableList<Commande> data_table;
    

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
        initTableSol();
        loadDataSol();
        PaneCommande.setVisible(false);
        comboAgent.setItems(AgentList);
        Comboexp.setItems(comboList);
        comboTypePlaque.setItems(plaqueList);
        comboTypeCell.setItems(type_cell);
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
    
    @FXML
    private TableView<Solutions> tab_Solutions;
       
    @FXML
    private TableColumn<Solutions, String> col_sol_qt_ab;

    @FXML
    private TableColumn<Solutions, String> col_sol_qt_cell;

    @FXML
    private TableColumn<Solutions, String> col_sol_ty_cell;
    
    private ObservableList<Solutions> data_table_sol;
    
    private ObservableList <String> type_cell = 
            FXCollections.observableArrayList(
            "Normales",
            "Cancéreuse"
            );

    private void initTableSol(){
        initColumnSol();
    }
    
    private void initColumnSol(){
        //num, ab, type_exp, nb_slot, d_f, nb_sol;
        col_sol_qt_ab.setCellValueFactory(new PropertyValueFactory<>("qt_ab"));
        col_sol_qt_cell.setCellValueFactory(new PropertyValueFactory<>("qt_cell"));
        col_sol_ty_cell.setCellValueFactory(new PropertyValueFactory<>("ty_cell"));
        editTableColumnSol();
    }
    
    private void editTableColumnSol(){
        col_sol_qt_ab.setCellFactory(TextFieldTableCell.forTableColumn());
        col_sol_qt_cell.setCellFactory(TextFieldTableCell.forTableColumn());
        col_sol_ty_cell.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), type_cell)); 
        tab_Solutions.setEditable(true);
    }
    
 
    @FXML private TextField ab_field;
    @FXML private TextField cell_field;
    @FXML private ComboBox<String> comboTypeCell;
    
    @FXML
    protected void addSolutions(ActionEvent event) {
        ObservableList<Solutions> data = tab_Solutions.getItems();
        data.add(new Solutions(ab_field.getText(),
            cell_field.getText(),
            comboTypeCell.getValue(),
            this
        ));
        comboTypeCell.getSelectionModel().clearSelection();
        ab_field.setText("");
        cell_field.setText("");
    }
    
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

    public String getComboTypeCell() {
        return comboTypeCell.getValue();
    }
    
}
