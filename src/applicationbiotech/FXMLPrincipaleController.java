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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 *
 * @author gphy
 */
public class FXMLPrincipaleController implements Initializable {
    
    @FXML
    //private Label label;
    private Pane pane;
    private Pane pane_attente;
    
    @FXML
    private void handleButtonCommande(ActionEvent event) {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
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
    
    
    //public ObservableList<Commande> data_table;
    private final Commande co =new Commande("1","ab","t","s","df","n", new Button("je prends"));
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        loadData();
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
        ObservableList<Commande> data_table = FXCollections.observableArrayList();
        for( int i=0; i<7;i++){
            //data_table.add(new Commande(String.valueOf(i),"ab"+i,'type_exp'+i,"nb_slot"+i,"df"+i,"nb_sol"+i, new Button("je prends")));
            data_table.add(co);
            System.out.println(co);
        }
        tab_attente.setItems(data_table);
    }
    
    
}
