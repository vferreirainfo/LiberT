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
public class Adresse {
    
    int idAdresse;
    String lieuAdresse;
    int nombrePorte;
    int department;
    String ville;
    
    
    
    public Adresse(){
    
        
    }
    
    public Adresse(String lieuAdresse, int nombreP, int depart, String ville)
    {
        this.lieuAdresse = lieuAdresse;
        this.nombrePorte = nombreP;
        this.ville = ville;
        this.department = depart;
    }
    
    public int ObtenirLeClavierPrimaire()
    {
        return idAdresse;
    }
    public String ObtenirLieuDAdresse()
    {
        return lieuAdresse;
    }
    public void DefinirLieuDAdresse(String lieu)
    {
        lieuAdresse=lieu;
    }
    public int ObtenirNombreDePorte()
    {
        return nombrePorte;
    }
    public void DefinirNombrePorte(int nombre)
    {
        nombrePorte = nombre;
    }
    
    public int ObtenirDepartment()
    {
        return department;
    }
    public void DefinirDepartment(int department)
    {
        this.department = department;
    }
    public String ObtenirVille()
    {
        return ville;
    }
    public void DefinirVille(String ville)
    {
        this.ville = ville;
    }
    
    
}
