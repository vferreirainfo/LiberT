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
public class GestionMethodesStationService {
    
    // Pour returnez 1 object;
    
    StationService st = new StationService();
    
    
    //Obtenir un conjoint de Stations de Service
    List<StationService> stations = new ArrayList<StationService>();
    
    
    //Autres variables
    String excMessage;
    boolean etatDOperation;
    
    //Constructeurs
    
    public GestionMethodesStationService()
    {  
    }
    
    public GestionMethodesStationService(StationService service, String excMessage)
    {
        this.st = service;
        this.excMessage = excMessage;
    }
    
    
    public GestionMethodesStationService(StationService service, String excMessage, boolean etat)
    {
        this.st = service;
        this.excMessage = excMessage;
        this.etatDOperation = etat;
    }
    
    
    public GestionMethodesStationService(StationService service, boolean etat)
    {
        this.st = service;
        this.etatDOperation = etat;
    }
    
    public GestionMethodesStationService (List<StationService> conjSt, boolean etat)
    {
        stations = conjSt;
        etatDOperation = etat;
    }
    
    public GestionMethodesStationService (List<StationService> conjSt, String exc, boolean etat)
    {
        stations = conjSt;
        excMessage = exc;
        etatDOperation = etat;
    }
    
    public GestionMethodesStationService (String exc, boolean etat)
    {
        excMessage = exc;
        etatDOperation = etat; 
    } 
    
    public List<StationService> ObtenirListeStationsService()
    {
        return stations;
    }
    public void DefinirListeStationsService(List<StationService> listeStService)
    {
        stations = listeStService;
    }
    public StationService ObtenirStationService()
    {
         return st;
    }
    public void DefinirStationService (StationService st)
    {
        this.st = st;
    }
    public String ObtenirExceptionnelMessage()
    {
         return excMessage;
    }
    public void DefinirExceptionnelMessage(String excMessage)
    {
         this.excMessage = excMessage;
    }
     public boolean ObtenirOperationEtat()
     {
         return this.etatDOperation;
     }
     public void DefinirOperationEtat (boolean etat)
     {
         etatDOperation = etat;
     }
}
