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
public class GestionMethodesVoiture {

    Voiture voit = new Voiture();
    
    List<Voiture> conjointDeVoitures = new ArrayList<Voiture>();

    String  excMessage; boolean etat;
    
    public GestionMethodesVoiture(){}
    
    public GestionMethodesVoiture(Voiture automobile, String exc, boolean etat)
    {
        voit = automobile;
        excMessage = exc;
        this.etat = etat;
    }
    
    public GestionMethodesVoiture(String exc, boolean etat)
    {
        excMessage = exc;
        this.etat = etat;
    }
    
    public GestionMethodesVoiture(List<Voiture> automobile, String exc, boolean etat)
    {
        conjointDeVoitures = automobile;
        excMessage = exc;
        this.etat = etat;
    }
    
    public Voiture ObtenirVoiture()
    {
        return voit;
    }
    public void DefinirVoiture(Voiture voiture)
    {
        voit = voiture;
    }
    public List<Voiture> ObtenirTousVoitures()
    {
        return conjointDeVoitures;
    }
    public void DefinirTousVoitures(List<Voiture> conjVoitures)
    {
        conjointDeVoitures = conjVoitures;
    }
    
    public String ObtenirExceptionnelMessage()
    {
        return excMessage;
    }
    public void DefinirExceptionnelMessage(String excMessage)
    {
        this.excMessage = excMessage;
    }
    public boolean ObtenirEtatMethod()
    {
        return etat;
    }
    public void DefinirEtatMethod(boolean etatMethod)
    {
        etat = etatMethod;
    }    
    
    
}
