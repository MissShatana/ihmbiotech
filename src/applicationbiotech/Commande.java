/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationbiotech;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 *
 * @author gphy
 */
public class Commande {
    String num, ab, type_exp, nb_slot, d_f, nb_sol;
    Button assignation;
    FXMLPrincipaleController con;
    
    public Commande(String num, String ab, String type_exp, String nb_slot, String d_f, String nb_sol, Button assignation, FXMLPrincipaleController con){
        this.num = num;
        this.ab=ab;
        this.type_exp=type_exp;
        this.nb_slot=nb_slot;
        this.d_f=d_f;
        this.nb_sol=nb_sol;
        this.assignation=assignation;
        this.con=con;
        assignation.setOnAction((ActionEvent e) -> {
            for (Commande co: con.getData_table()){
                if (co.getAssignation()==assignation){
                    System.out.println(co.getNum());
                    con.getData_table().remove(co);
                    break;
                }
            }
        });
        
    }

    public String getNum() {
        return num;
    }

    public String getAb() {
        return ab;
    }

    public String getType_exp() {
        return type_exp;
    }

    public String getNb_slot() {
        return nb_slot;
    }

    public String getD_f() {
        return d_f;
    }

    public String getNb_sol() {
        return nb_sol;
    }

    public Button getAssignation() {
        return assignation;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setAb(String ab) {
        this.ab = ab;
    }

    public void setType_exp(String type_exp) {
        this.type_exp = type_exp;
    }

    public void setNb_slot(String nb_slot) {
        this.nb_slot = nb_slot;
    }

    public void setD_f(String d_f) {
        this.d_f = d_f;
    }

    public void setNb_sol(String nb_sol) {
        this.nb_sol = nb_sol;
    }

    public void setAssignation(Button assignation) {
        this.assignation = assignation;
    }
    
}
