/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationbiotech;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 *Classe qui stockent les différents paramétres (informations générales) de la commande
 */
public class Commande {
    String num, ab, type_exp, nb_slot, d_f, nb_sol, ty_pla;
    Button boutton;
    ObservableList<Solutions> ligne_commande= FXCollections.observableArrayList();
    FXMLPrincipaleController con;
    
    /**
     * Constructeur avec
     * @param num le numéro de la commande
     * @param ab l'agent biologique utilisé
     * @param type_exp le type d'expérience faite
     * @param nb_slot le nombre de slot
     * @param d_f la durée et la fréquence
     * @param boutton boutton pour prendre la commande
     * @param ligne_commande
     * @param type_plaque
     * @param con main
     */
    public Commande(String num, String ab, String type_exp, String nb_slot, String d_f, Button boutton, ObservableList<Solutions> ligne_commande, String type_plaque, FXMLPrincipaleController con){
        this.num = num;
        this.ab=ab;
        this.type_exp=type_exp;
        this.nb_slot=nb_slot;
        this.d_f=d_f;
        this.nb_sol=String.valueOf(ligne_commande.size());
        this.boutton=boutton;
        this.ligne_commande = ligne_commande;
        this.ty_pla=type_plaque;
        this.con=con;
        boutton.setOnAction((ActionEvent e) -> {
            Button btn_clicked = (Button)e.getSource();
            String buttonText = btn_clicked.getText();
            if (buttonText == "je prends") { // je prends assignation
                for (Commande co: con.getData_commande_att()){
                    if (co.getBoutton()==btn_clicked){
                        System.out.println(co.getNum());
                        con.getData_commande_att().remove(co);
                        break;
                    }
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

    public Button getBoutton() {
        return boutton;
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

    public void setBoutton(Button boutton) {
        this.boutton = boutton;
    }
    
}
