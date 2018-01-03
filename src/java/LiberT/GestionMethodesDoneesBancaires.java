/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiberT;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class GestionMethodesDoneesBancaires {
    
    DoneesBancaires dbancaires = new DoneesBancaires();
    List<DoneesBancaires> listeDoneesBancaires = new ArrayList<DoneesBancaires>();
    
    String exceptionnelMessage; boolean etatMethod=false;
    
    public GestionMethodesDoneesBancaires(){
        
    }
    
    public GestionMethodesDoneesBancaires(DoneesBancaires dbanc, String excMessage, boolean etat)
    {
        dbancaires=dbanc;
        exceptionnelMessage = excMessage;
        etatMethod = etat;
    }

    
    public DoneesBancaires ObtenirDoneesBancaires()
    {
        return dbancaires;
    }
    public void DefinirDoneesBancaires(DoneesBancaires dbancaires)
    {
        this.dbancaires = dbancaires;
    }
    
    public String ObtenirExceptionnelMessage()
    {
        return exceptionnelMessage;
    }
    public void DefinirExceptionnelMessage(String exMessage)
    {
        exceptionnelMessage = exMessage;
    }
    
    public boolean ObtenirEtatOperationMethod()
    {
        return etatMethod;
    }
    public void DefinirEtatOperationMethod(boolean etat)
    {
        etatMethod = etat;
    }
    
}
