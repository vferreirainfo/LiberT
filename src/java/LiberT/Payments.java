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
public class Payments {
    
    
    int idPayment;
    
    DoneesBancaires donBancaire;
    
    boolean etatPayment;
    
    public Payments()
    {
        
    }
    
    public Payments(boolean etat, DoneesBancaires donBancaires)
    {
        this.etatPayment = etat;
        this.donBancaire = donBancaires;
    }
    
    public int ObtenirIdPayment()
    {
        return idPayment;
    }
    public void DefinirIdPayment(int id)
    {
        idPayment = id;
    }
    
    public DoneesBancaires ObtenirDonneesBancaires()
    {
        return donBancaire;
    }
    public void DefinirDonneesBancaires(DoneesBancaires dbanc)
    {
        donBancaire=dbanc;
    }
    
    public boolean ObtenirEtatPayment()
    {
        return etatPayment;
    }
    public void DefinirEtatPayment(boolean etatPayment)
    {
        this.etatPayment=etatPayment;
    }
    
}
