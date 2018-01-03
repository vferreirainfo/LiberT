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
public class StationService {

    
    int sserviceId; // Le pk dans la base de donées
    String nomStationService;
    Adresse adresse;
    String email;
    int nombreTelephone;
    
    public StationService()
    {
        
    }
    
    public StationService (String nomStation, Adresse adresseStService, String courrierElectronique)
    {
        nomStationService = nomStation;
        adresse = adresseStService;
        email = courrierElectronique;
    }
    
    
    public int ObtenirLeClavierPrimaire()
    {
        return sserviceId;
    }
    public void DefinirClavierPrimaire (int clavierPrimaire)
    {
        sserviceId = clavierPrimaire;
    }
    
    public String ObtenirNomStationService()
    {
        return nomStationService;
    }
    public void DefinirNomStationService(String nomStationService)
    {
        this.nomStationService = nomStationService;    
    }
    public Adresse ObtenirLAdresseStationService()
    {
        return adresse;
    }
    public void DefinirLAdresseStationService(Adresse adresse)
    {
        this.adresse = adresse;
    }
    
    public String ObtenirLeCourrierElectronique ()
    {
        return email;
    }
    public void DefinirLeCourrierElectronique(String courrier)
    {
        email = courrier;
    }
    public int ObtenirNombreTelephone()
    {
        return nombreTelephone;
    }
    public void DefinirNombreTelephone(int nombreT)
    {
        nombreTelephone=nombreT;
    }
    
}
