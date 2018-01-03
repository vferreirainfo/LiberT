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
public class Mouvement {


    int mouvementId;
    Date dateDuMouvement;
    
    // Quelque mouvement il y a un client
    Client clId;
    
    //Il y a jusqu'un mouvement, qui peut être, de ...
    
    MouvementStationService mouvementSt;  // ça ex: Payment de 40€ de carburant
    MouvementPark mouvementPark; // ou cette ... Um mouvement de Park (payment du stationment de la voiture)
    MouvementRestaurant mouvementRestaurant;
    Hotel hotel; // un client peut être "dormir",  dans une hotel, en une periode de 1/2 nuits, 1 semaine ... Alors, Il va a payer chaque nuit  
    
    
    
    
    public Mouvement ()
    {}
    
    public Mouvement (int mouvementId, Date dateDuMouvement, Client client, MouvementPark mouvPark)
    {
        this.mouvementId = mouvementId;
        this.dateDuMouvement = dateDuMouvement;
        this.clId = client;
        this.mouvementPark = mouvPark;
    
    }
    
    
    public Mouvement(int mouvementId,Date dateDuMouvement, Client client, MouvementStationService mvst)
    {
        this.mouvementId = mouvementId;
        this.dateDuMouvement = dateDuMouvement;
        this.clId = client;
        this.mouvementSt = mvst;
    } 
       
    /*
    public Mouvement (Date dateDuMouvement, Client client, Park parkStationment)
    {
        this.dateDuMouvement = dateDuMouvement;
        this.clId = client;
        this.park = parkStationment;
    }*/
    
    public int ObtenirMouvementId()
    {
        return mouvementId;
        
    }
    public void DefinirMouvementId(int mouvId)
    {
        mouvementId=mouvId;
    }
    
    public MouvementStationService ObtenirMouvementStationService()
    {
        return mouvementSt;
    }
    public void DefinirMouvementStationService(MouvementStationService mvst)
    {
        mouvementSt = mvst;
    }
    
    public MouvementPark ObtenirMouvementPark()
    {
        return this.mouvementPark;
    }
    public void DefinirMouvementPark(MouvementPark mouvPark)
    {
        mouvementPark = mouvPark;
    }
    
    public MouvementRestaurant ObtenirMouvementRestaurant()
    {
        return this.mouvementRestaurant;
    }
    
    public void DefinirMouvementRestaurant(MouvementRestaurant mouvRest)
    {
        mouvementRestaurant = mouvRest;
    }
    
    
    
}