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
public class GestionMethodesPrixPeage {
    
    
    List<PrixPeage> listPP = new ArrayList<PrixPeage>();
    
    
    String excMessage; 
    boolean etatMethod;
    
    public GestionMethodesPrixPeage()
    {
        
    }
    
    
    public GestionMethodesPrixPeage(List<PrixPeage> listePrixPeages, String excMessage, boolean etat)
    {
        listPP = listePrixPeages;
        this.excMessage = excMessage;
        etatMethod = etat;
    }
    
    public GestionMethodesPrixPeage(String excMessage, boolean etat)
    {
        this.excMessage = excMessage;
        etatMethod = etat;
    }
    
    public List<PrixPeage> ObtenirListePrixPeages()
    {
        return listPP;
    }
    public void DefinirListePrixPeage (List<PrixPeage> prixPeages)
    {
        listPP = prixPeages;
    }
    
    public String ObtenirExceptionnelMessage()
    {
        return excMessage;
    }
    public void DefinirExceptionnelMessage (String excMessage)
    {
        this.excMessage = excMessage;
    }
    public boolean ObtenirEtatMethod()
    {
        return etatMethod;
    }
    public void DefinirEtatMethod(boolean etat)
    {
        etatMethod = etat;
    }
    
    
}
