package LiberT;

import java.util.ArrayList;
import java.util.List;







/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vitor
 */
public class GestionMethodesRestaurant {


    //Obtenir un restaurant
    Restaurant rest = new Restaurant();
   
    //Obtenir un conjount
    List<Restaurant> conjRest = new ArrayList<Restaurant>();
    
    //autres variables
    String excMessage; boolean etat; 
    
    
    
    public GestionMethodesRestaurant(){}
    
    //Definir plus tard constructeurs
    
    
    public Restaurant ObtenirUnRestaurant()
    {
        return rest;
    }
    public void DefinirUnRestaurant(Restaurant restaurant)
    {
        rest = restaurant;
    }
    
    public List<Restaurant> ObtenirConjointDeRestaurants()
    {
        return conjRest;
    }
    public void DefinirConjointRestaurants(List<Restaurant> conjRest)
    {
       this.conjRest = conjRest;
    }
    public String ObtenirExceptionnelMessage()
    {
        return excMessage;
    }
    public void DefinirExceptionnelMessage(String exc)
    {
        excMessage = exc;
    }
    public boolean ObtenirEtatMethod()
    {
        return etat;
    }
    public void DefinirEtatMethod(boolean etat)
    {
        this.etat = etat;
    }
}
