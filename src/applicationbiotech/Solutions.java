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
 *
 * @author Natashaa
 */
public class Solutions {
    private String qt_ab, qt_cell, ty_cell;
    FXMLPrincipaleController con;
    
    public Solutions(String qt_ab, String qt_cell, String ty_cell, FXMLPrincipaleController con){
        this.qt_ab=qt_ab;
        this.qt_cell=qt_cell;
        this.ty_cell=ty_cell;
        this.con=con;
    }

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
