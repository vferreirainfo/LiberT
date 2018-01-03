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
public class MouvementRestaurant {
 
     
    Restaurant restaurant; // ou ça
    int mvRestaurantId;
    float aPayer;
    Date dtMouvement;
    int listeProduitId;
    
    public MouvementRestaurant() {
    }
    
    public MouvementRestaurant(Restaurant rest, int mvRestId, float prix, Date dtMouv, int listeProd)
    {
        restaurant=rest;
        mvRestaurantId = mvRestId;
        aPayer = prix;
        dtMouvement = dtMouv;
        listeProduitId = listeProd;
    }
    
    public int ObtenirIdMouvementDeRestaurant()
    {
        return mvRestaurantId;
    }
    
    public void DefinirIdMouvementDeRestaurant(int id)
    {
       this.mvRestaurantId = id;
    }
    
    public Restaurant ObtenirRestaurant()
    {
        return restaurant;
    }
    public void DefinirRestaurant(Restaurant rest)
    {
        restaurant = rest;
    }
    
    public float ObtenirPrix()
    {
        return aPayer;
    }
    public void DefinirPrix(float prix)
    {
       aPayer=prix;
    }
    
    public Date ObtenirDateMouvement()
    {
        return dtMouvement;
    }
    public void DefinirDateMouvement(Date date)
    {
        dtMouvement = date;
    }

    
}
