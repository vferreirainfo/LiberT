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
    
    // Cette "class" travail avec les DoneesBancaires de chaque Client
    int nombreNib;
    
    String banqueNom;
    
    Date dateDAutorization;
    
    
    public DoneesBancaires(){
        
    }
    
    public DoneesBancaires(int nombreNIB, String nomBanque,Date autorization)
    {
        nombreNib = nombreNIB;
        banqueNom = nomBanque;
        dateDAutorization = autorization;
    }
    
    
    public int NombreDeNIB()
    {
        return nombreNib;
    }
    public void NombreDeNIB(int nombre)
    {
        nombreNib = nombre;
    }
    
    
}
