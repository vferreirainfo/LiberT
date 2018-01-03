/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiberT;

import java.util.Date;

/**
 *
 * @author Vitor
 */
public class MouvementPeage {
    
    int mouvementPeageId;
    Peage peage;
    PrixPeage prixDuPeage;
    //Date dtMouvement;
    String dtMouvement;
    
    public MouvementPeage()
    {
        
    }
    public MouvementPeage (Peage peageAutoRoute, PrixPeage prix)
    {
        peage = peageAutoRoute;
        prixDuPeage = prix;
    }
    
    public int ObtenirMouvementPeage()
    {
        return mouvementPeageId;
    }
    public Peage ObtenirPeageDAutoroute()
    {
        return peage;
    }
    public void DefinirPeageDAutoroute(Peage peageAE)
    {
        peage = peageAE;
    }
    public PrixPeage ObtenirPrixPeage()
    {
        return prixDuPeage;
    }
    public void DefinirPrixPeage(PrixPeage prix)
    {
        prixDuPeage = prix;
    }
    
    public String ObtenirDateDuMouvement()
    {
        return dtMouvement;
    }
    public void DefinirDateDuMouvement(String dt)
    {
        dtMouvement = dt;
    }
    
}
