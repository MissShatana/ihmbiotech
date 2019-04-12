/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationbiotech;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 *Classe qui crée les différentes solutions que veut le chercheur
 */
public class Solutions {
    private String  qt_ab, qt_cell, ty_cell;
    private int id;
    FXMLPrincipaleController con;
    private Button boutonpos;
    ObservableList<String> listpos= FXCollections.observableArrayList();
    
    /**
     * Constructeur de la solution avec
     * @param qt_ab quantité d'agent biologique
     * @param qt_cell quantité de cellules
     * @param ty_cell type de cellules
     * @param boutonpos bouton
     * @param listpos liste des positions de la solutions sur la plaque
     * @param con main
     */
    public Solutions(int id,String qt_ab, String qt_cell, String ty_cell, Button boutonpos, ObservableList<String> listpos, FXMLPrincipaleController con){
        this.qt_ab=qt_ab;
        this.qt_cell=qt_cell;
        this.ty_cell=ty_cell;
        this.con=con;
        this.id=id;
        this.boutonpos=boutonpos;
        this.listpos=listpos;
        
        boutonpos.setOnAction((ActionEvent e) -> {
            Button btn_clicked = (Button)e.getSource();
            String buttonText = btn_clicked.getText();
            if (buttonText == "Voir") { // voir les positions des puits             
                for (Solutions co: con.getData_InfoSolc()){
                    System.out.println("for");
                    if (co.getBoutonpos()==btn_clicked){
                        System.out.println("if");
                        con.addPos(listpos);
                        break;
                    }
                }
            } 
        });
    }

    public int getId() {
        return id;
    }

    public Button getBoutonpos() {
        return boutonpos;
    }

    /**
     * getter pour la quantité d'agent biologique
     * @return quantité biologique
     */
    public String getQt_ab() {
        return qt_ab;
    }

    public String getQt_cell() {
        return qt_cell;
    }

    public String getTy_cell() {
        return ty_cell;
    }

    public FXMLPrincipaleController getCon() {
        return con;
    }

    public void setQt_ab(String qt_ab) {
        this.qt_ab = qt_ab;
    }

    public void setQt_cell(String qt_cell) {
        this.qt_cell = qt_cell;
    }

    public void setTy_cell(String ty_cell) {
        this.ty_cell = ty_cell;
    }

    public void setCon(FXMLPrincipaleController con) {
        this.con = con;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBoutonpos(Button boutonpos) {
        this.boutonpos = boutonpos;
    }
    
    
}
