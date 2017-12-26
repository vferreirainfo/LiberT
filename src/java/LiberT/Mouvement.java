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
    
    StationService station;  // ça ex: Payment de 40€ de carburant
    Park park; // ou cette ... Um mouvement de Park (payment du stationment de la voiture)
    Restaurant rest; // ou ça
    Hotel hotel; // un client peut être "dormir",  dans une hotel, en une periode de 1/2 nuits, 1 semaine ... Alors, Il va a payer chaque nuit  
    
    
   
    
    public Mouvement ()
    {}
    
    public Mouvement (int mouvementId, Date dateDuMouvement, Client client)
    {
        this.mouvementId = mouvementId;
        this.dateDuMouvement = dateDuMouvement;
        this.clId = client;
    
    }
    
    public Mouvement(Date dateDuMouvement, Client client, StationService station)
    {
        this.dateDuMouvement = dateDuMouvement;
        this.clId = client;
        this.station = station;
    } 
            
    public Mouvement (Date dateDuMouvement, Client client, Park parkStationment)
    {
        this.dateDuMouvement = dateDuMouvement;
        this.clId = client;
        this.park = parkStationment;
    }
    
    public int ObtenirMouvementId()
    {
        return mouvementId;
        
    }
    
    
    
    
}