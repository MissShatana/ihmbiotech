/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationbiotech;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 *Classe qui crée les différentes solutions que veut le chercheur
 */
public class Solutions {
    private String  qt_ab, qt_cell, ty_cell;
    private int id;
    FXMLPrincipaleController con;
    
    /**
     * Constructeur de la solution avec
     * @param qt_ab quantité d'agent biologique
     * @param qt_cell quantité de cellules
     * @param ty_cell type de cellules
     * @param con main
     */
    public Solutions(int id,String qt_ab, String qt_cell, String ty_cell, FXMLPrincipaleController con){
        this.qt_ab=qt_ab;
        this.qt_cell=qt_cell;
        this.ty_cell=ty_cell;
        this.con=con;
        this.id=id;
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
    
    
}
