/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiberT;

/**
 *
 * @author Vitor
 */
public class Restaurant {
   
    
    String nomRest;
    Adresse adress;
    EspeceAdresse esp;
    
    
    
    public Restaurant()
    {
        
    }
    public Restaurant (String nomRestaurant, Adresse ad)
    {
        nomRest = nomRestaurant;
        adress = ad;
    }
    
    
    public String NomRestaurant()
    {
        return nomRest;
    }
    public void NomRestaurant(String nom)
    {
        nomRest = nom;
    }
    
    public Adresse ObtenirAdresse()
    {
        return adress;
    }
    public void DefinirAdresse(Adresse ad)
    {
        adress = ad;
    }
}
