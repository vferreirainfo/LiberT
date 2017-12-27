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
public class GestionMethodesPark {
    
    
    //travaillez avec 1 park
    Park park = new Park();
    
    //travaillez avec un conjoint de park
    List<Park> tousLesParks = new ArrayList<Park>();
    
    //Autres variables
    String excMessage;
    boolean etat;
    
    public GestionMethodesPark()
    {
        
    }
    
    public GestionMethodesPark(Park park, String exc, boolean etatMethod)
    {
        this.park = park;
        excMessage = exc;   
        etat = etatMethod;
    }
    
    public GestionMethodesPark(List<Park> tousLesParks, String exc, boolean etatMethod)
    {
        this.tousLesParks = tousLesParks;
        excMessage = exc;   
        etat = etatMethod;
    }
    
    
    public GestionMethodesPark(List<Park> tousLesParks, String exc)
    {
        this.tousLesParks = tousLesParks;
        excMessage = exc;   
        
    }
    
    public GestionMethodesPark(Park park, String exc)
    {
        this.park = park;
        excMessage = exc;   
    }
    
    public boolean ObtenirActuelMethodEtat()
    {
        return etat;
    }
    public void DefinirActuelMethodEtat(boolean etat)
    {
        this.etat = etat;
    }
    public String ObtenirExceptionnelMessage()
    {
        return excMessage;
    }
    public void DefinirExceptionnelMessage(String excMessage)
    {
        this.excMessage = excMessage;
    }
    public Park ObtenirUnPark()
    {
        return park;
    }
    public void DefinirUnPark(Park park)
    {
        this.park = park;
    }
    public List<Park> ObtenirUnConjointParkStationment()
    {
        return tousLesParks;
    }
    public void DefinirUnConjointParkStationment(List<Park> parks)
    {
        tousLesParks = parks;
    }
    
    
}
