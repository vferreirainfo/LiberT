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
public class Produits {

    int produitId;
    String nomProduit;
    float prix;
    boolean prixPerLitre;
    int listeProdId;
    
    public Produits(){}
    
    public Produits (String nomProd, float prix, boolean prixLitre, int listeProduitId)
    {
        nomProduit = nomProd;
        this.prix = prix;
        prixPerLitre = prixLitre;
        listeProdId = listeProduitId;
    }
    
    public int ObtenirProduitId()
    {
        return produitId;
    }
    public String ObtenirNomProduit()
    {
        return nomProduit;
    }
    public void DefinirNomProduit(String nom)
    {
        nomProduit = nom;
    }
    public float ObtenirPrixDuProduit()
    {
        return prix;
    }
    public void DefinirPrixDuProduit(float prix)
    {
        this.prix = prix;
    }
    public boolean ObtenirEtatPrixLitre()
    {
        return prixPerLitre;
    }
    public void DefinirEtatPrixLitre(boolean etat)
    {
        prixPerLitre = etat;
    }
    
    
    
}
