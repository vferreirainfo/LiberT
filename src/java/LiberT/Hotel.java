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
public class Hotel {

    int clavierPrimaire;
    String nomHotel;
    Adresse adresseHotel;
    int nombreDeEtoiles;
    String courrier;
    int nombreTelephon;
    
    
    public Hotel()
    {
        
    }
    public Hotel (String nomHotel, Adresse adresse, int nombreEtoiles, String courrierElectronique, int nombreT)
    {
        this.nomHotel = nomHotel;
        adresseHotel = adresse;
        nombreDeEtoiles = nombreEtoiles;
        nombreTelephon = nombreT;
    }
    
    public int ObtenirClavierPrimaire()
    {
        return clavierPrimaire;
    }
    
    public String ObtenirNomHotel()
    {
        return nomHotel;
    }
    public void DefinirNomHotel(String nomHotel)
    {
        this.nomHotel = nomHotel;
    }
    public Adresse ObtenirLAdresse()
    {
        return adresseHotel;
    }
    public void DefinirLAdresse(Adresse adresse)
    {
        adresseHotel = adresse;
    }
}
