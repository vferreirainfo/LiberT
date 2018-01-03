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
public class DoneesBancaires {
    
    int clavierPrimaire;
    
    // Cette "class" travail avec les DoneesBancaires de chaque Client
    long nombreNib;
    
    String banqueNom;
    
    Date dateDAutorization;
    
    
    Client client;
    
    public DoneesBancaires(){
        
    }
    
    public DoneesBancaires(long nombreNIB, String nomBanque,Date autorization)
    {
        nombreNib = nombreNIB;
        banqueNom = nomBanque;
        dateDAutorization = autorization;
    }
    
    public int ObtenirClavierPrimaire()
    {
        return clavierPrimaire;
    }
    public void DefinirClavierPrimaire(int clavierPrimaire)
    {
        this.clavierPrimaire = clavierPrimaire;
    }
    
    
    public long NombreDeNIB()
    {
        return nombreNib;
    }
    public void NombreDeNIB(long nombre)
    {
        nombreNib = nombre;
    }
    public String ObtenirNomBanque()
    {
        return banqueNom;
    }
    public void DefinirNomBanque(String nomBanque)
    {
        this.banqueNom = nomBanque;
    }
    
    public Date ObtenirDateDAutorization()
    {
        return this.dateDAutorization;
    }
    public void DefinirDateDAutorization(Date dtAutorization)
    {
        dateDAutorization = dtAutorization;
    }
    
    public Client ObtenirClient()
    {
        return client;
    }
    public void DefinirClient(Client c)
    {
        client=c;
    }
    
    
}
