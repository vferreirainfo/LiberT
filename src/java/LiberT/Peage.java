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
public class Peage {
    
    int peageId;
    String descriptif;
    Adresse adresse;
    
    
    
    public Peage()
    {
        
    }
    public int ObtenirLeId()
    {
        return peageId;
    }
    public String ObtenirDescriptif()
    {
        return descriptif;
    }
    public void DefinirDescriptif(String desc)
    {
        descriptif = desc;
    }
    
    public Adresse ObtenirAdresse()
    {
        return adresse;
    }
    
    public void DefinirAdresse(Adresse adresse)
    {
        this.adresse = adresse;
    }
    
}
