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
 * Classe qui stockent les différents paramétres (informations générales) de la commande
 * @author Natasha
 */
public class Commande {
    String num, ab, type_exp, nb_slot, d,f, nb_sol, ty_pla, reactif, date;
    Button bouttonAss;
    Button bouttonInfo;
    Button btn_en_cours ; 
    ObservableList<Solutions> ligne_commande= FXCollections.observableArrayList();
    FXMLPrincipaleController con;
    
    /**
     * Constructeur de la commande et controlleur des différents boutons
     * @param num le numéro de la commande
     * @param ab l'agent biologique utilisé
     * @param date
     * @param type_exp le type d'expérience faite
     * @param nb_slot le nombre de slot
     * @param d
     * @param f
     * @param bouttonAss
     * @param bouttonInfo
     * @param reactif
     * @param ligne_commande
     * @param type_plaque
     * @param con main
     */
    public Commande(String num, String ab, String date, String type_exp, String nb_slot, String d, String f, Button bouttonAss,Button bouttonInfo, ObservableList<Solutions> ligne_commande, String type_plaque, String reactif, FXMLPrincipaleController con){
        this.num = num;
        this.ab=ab;
        this.date=date;
        this.type_exp=type_exp;
        this.nb_slot=nb_slot;
        this.d=d;
        this.f=f;
        this.nb_sol=String.valueOf(ligne_commande.size());
        this.bouttonAss=bouttonAss;
        this.bouttonInfo=bouttonInfo;
        this.ligne_commande = ligne_commande;
        this.ty_pla=type_plaque;
        this.con=con;
        this.reactif=reactif;
        
        bouttonAss.setOnAction((ActionEvent e) -> {
            Button btn_clicked = (Button)e.getSource();
            String buttonText = btn_clicked.getText();
            if (buttonText == "Je prends") { // je prends assignation              
                for (Commande co: con.getData_commande_att()){
                    if (co.getBouttonAss()==btn_clicked){
                        co.setBouttonAss(new Button ("scan plaque"));
                        con.getData_commande_att().remove(co);
                        System.out.println(co);
                        con.addData_commande_en_cours(co);
                        System.out.println(con.getData_commande_en_cours().size());
                        for (Solutions sol: ligne_commande){
                            Pattern p =Pattern.compile("-");
                            String[] id =p.split(con.getId_connexion());
                            System.out.println(id[0]);
                            String sq1 = "update ligne_commande set id_laborantin="+id[0]+" where id_ligne_commande="+sol.getId()+"";
                            try {
                                Statement stmt = con.getMain().getCon().createStatement();
                                ResultSet rs = stmt.executeQuery(sq1);
                            } catch (SQLException ex) {
                                Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                        break;
                    }
                }
            } 
        });
        bouttonInfo.setOnAction((ActionEvent e) -> {
            Button btn_clicked = (Button)e.getSource();
            String buttonText = btn_clicked.getText();
            if (buttonText == "Infos") { // infos             
                for (Commande co: con.getData_commande_att()){
                    if (co.getBouttonInfo()==btn_clicked){
                        con.setValInfAB(co.getAb());
                        con.setValInfNBSlot(co.getNb_slot());
                        con.setValInfR(co.getReactif());
                        con.setValInfoNBSol(co.getNb_sol());
                        con.setValInfoPlaque(co.getTy_pla());
                        if (ligne_commande.isEmpty()){
                            System.out.println("aaaa");
                        }else{
                            con.setDataInfo(ligne_commande);
                        }
                        break;
                    }
                }
                for (Commande co: con.getData_commande_en_cours()){
                    if (co.getBouttonInfo()==btn_clicked){
                        con.setValInfAB1(co.getAb());
                        con.setValInfNBSlot1(co.getNb_slot());
                        con.setValInfR1(co.getReactif());
                        con.setValInfoNBSol1(co.getNb_sol());
                        con.setValInfoPlaque1(co.getTy_pla());
                        if (ligne_commande.isEmpty()){
                            System.out.println("aaaa");
                        }else{
                            
                            System.out.println("chargement");
                            con.setDataInfoc(ligne_commande);
                        }
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

    public String getD() {
        return d;
    }
    
    public String getF() {
        return f;
    }

    public String getNb_sol() {
        return nb_sol;
    }

    public String getTy_pla() {
        return ty_pla;
    }

    public ObservableList<Solutions> getLigne_commande() {
        return ligne_commande;
    }
    
    

    public Button getBouttonAss() {
        return bouttonAss;
    }
    
    public Button getBouttonInfo() {
        return bouttonInfo;
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

    public void setD(String d) {
        this.d = d;
    }
    
    public void setF(String f) {
        this.f = f;
    }

    public void setNb_sol(String nb_sol) {
        this.nb_sol = nb_sol;
    }

    public void setBouttonAss(Button boutton) {
        this.bouttonAss = boutton;
    }
    public void setBouttonInfo(Button boutton) {
        this.bouttonInfo = boutton;
    }

    public String getDate() {
        return date;
    }

    public String getReactif() {
        return reactif;
    }
    
}
