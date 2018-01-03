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
public class Proprietaire {
    
    int clavierPrimaireProp;
    String preNom;
    String nom;
    int nombreTelephone;
    int nombreTelMobile;
    String courrier;
    int nombreFiscaux;
    Adresse adresse;
    
    
    
    
    public Proprietaire()
    {
        
    }
    public Proprietaire(String preNom, String nom,int nombreTelephone, int nombreTelM, String couElectronique, int nombreFiscaux, Adresse ad)
    {
        this.preNom = preNom;
        this.nom = nom;
        this.nombreTelephone = nombreTelephone;
        nombreTelMobile = nombreTelM;
        courrier = couElectronique;
        this.nombreFiscaux = nombreFiscaux;
        adresse = ad;
    }
    
    public int ObtenirClavierPrimaireProprietaire()
    {
        return this.clavierPrimaireProp;
    }
    public void DefinirClavierPrimaireProprietaire(int clavier)
    {
        clavierPrimaireProp = clavier;
    }
    
    
    public String ObtenirPreNom()
    {
        return preNom;
    }
    public void DefinirPreNom(String preNom)
    {
        this.preNom = preNom;
    }
    public String ObtenirNom()
    {
        return nom;
    }
    public void DefinirNom(String nom)
    {
        this.nom=nom;
    }
    public int ObtenirNombreTelephon()
    {
        return nombreTelephone;
    }
    public void DefinirNombreTelephone(int nombreTelephone)
    {
        this.nombreTelephone = nombreTelephone;
    }
    public int ObtenirNombreTelephoneMobile()
    {
        return nombreTelMobile;
    }
    public void DefinirNombreTelephoneMobile(int nombreTelephone)
    {
        nombreTelMobile = nombreTelephone;
    }
    public String ObtenirCourrierElectronique()
    {
        return courrier;
    }
    public void DefinirCourrierElectronique(String courrier)
    {
        this.courrier = courrier;
    }
    
    public int ObtenirNombreFiscaux()
    {
        return nombreFiscaux;
    }
    public void DefinirNombreFiscaux (int nombFisc)
    {
        nombreFiscaux = nombFisc;
    }
    public Adresse ObtenirAdresseProprietaire()
    {
        return adresse;
    }
    public void DefinirAdresseProprietaire(Adresse adresse)
    {
        this.adresse = adresse;
    }
            
    
    
}
