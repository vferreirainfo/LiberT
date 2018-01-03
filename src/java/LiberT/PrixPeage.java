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
public class PrixPeage {
    
    
    Iteneraire iteneraire;
    int prixPeageId; 
    int classPeageVoiture;
    float prixPeage;
    int conjIteneraire; // Le conjoint d'iteneraire
    
    
    public PrixPeage(){}
    
    public PrixPeage (Iteneraire iteneraireAE, int classPeageVoiture, float prixPeage)
    {
          this.iteneraire = iteneraireAE;
          this.classPeageVoiture = classPeageVoiture;
          this.prixPeage = prixPeage;
    }
   
    public int ObtenirPrixPeageId()
    {
        return prixPeageId;
    }
    public void DefinirPrixPeageId(int id)
    {
        prixPeageId=id;
    }
    public int ObtenirClassPeageVoiture ()
    {
        return classPeageVoiture;
    }
    public void DefinirClassPeageVoiture(int classpeage)
    {
        classPeageVoiture = classpeage;
    }
    public float ObtenirPrixpeage()
    {
        return prixPeage;
    }
    public void DefinirPrixPeage(float prix)
    {
        prixPeage = prix;
    }
    public Iteneraire ObtenirIdIteneraire()
    {
        return iteneraire;
    }
    public void DefinirItenerireId(Iteneraire it)
    {
        iteneraire = it;
    }
    
    public int ObtenirConjIteneraireId()
    {
        return conjIteneraire;
    }
    public void DefinirConjItenerireId(int conjIteneraireId)
    {
        conjIteneraire = conjIteneraireId;
    }
    
    
}
