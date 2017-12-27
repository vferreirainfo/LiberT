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
public class MouvementStationService {
   
    
    StationService station;
    float aPayer;
    Date dtDuMouvement;
    int listeProduitsId; //??
    
    
    
    public MouvementStationService(StationService station, float aPayer, Date dtMouvement)
    {
        this.station = station;
        this.aPayer=aPayer;
        dtDuMouvement = dtMouvement;
        
    }
    
    public int ListeProduitsId()
    {
        return listeProduitsId;
    }
    
    public void DefinirListeProduit(int listeProdId)
    {
        listeProduitsId = listeProdId; 
    }
    public StationService ObtenirStationService()
    {
        return station;
    }
    public void DefinirStationService(StationService st)
    {
        station = st;
    }
    
    public Date ObtenirDateMouvement()
    {
        return dtDuMouvement;
    }
    public void DefinirDateMouvement(Date date)
    {
        dtDuMouvement = date;
    }
    public float ObtenirPrixTotal()
    {
        return aPayer;
    }
    public void DefinirPrixTotal(float prix)
    {
        aPayer=prix;
    }
    
}
