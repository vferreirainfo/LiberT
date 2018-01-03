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

enum EspecePark
{
    AirLibre,
    sub, // subterrâneo
}
public class Park {
    
    
    int idPark;
    Adresse adresse;
    String nomPark;
    String email;
    int nombreTelephon;
    EspecePark esp;
    
    //int capacite; //??
    
    public Park()
    {
        
    }
    
    public Park(Adresse ad, String nomPark, String courrier, int nombreTel, EspecePark espPark)
    {
        adresse = ad;
        this.nomPark = nomPark;
        email = courrier;
        nombreTelephon = nombreTel;
        esp = espPark;
    }
    
    public int ObtenirIDPark()
    {
        return this.idPark;
    }
    public void DefinirIdPark(int id)
    {
        idPark = id;
    }
    public Adresse ObtenirAdresse()
    {
        return adresse;
    }
    public void DefinirAdresse(Adresse ad)
    {
        adresse = ad; 
    }
    public String ObtenirNomPark()
    {
        return nomPark;
    }
    public void DefinirNomPark(String nomPark)
    {
        this.nomPark = nomPark;
    }
    
    public String ObtenirCourrierEletronique()
    {
        return email;
    }
    public void DefinirCoruierEletronique(String courrier)
    {
        email = courrier;
    }
    
    public int ObtenirNombreTelephone()
    {
        return nombreTelephon;
    }
    public void DefinirNombreTelephone(int nombre)
    {
        nombreTelephon = nombre;
    }
    public EspecePark ObtenirLeEspeceDuPark()
    {
        return this.esp;
    }
    public void DefinirEspecePark(EspecePark especePark)
    {
        esp=especePark;
    }
    

}