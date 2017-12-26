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
    
    
    int iteneraireID;
    int prixPeageId;
    int classPeageVoiture;
    float prixPeage;
    int conjIteneraire; // Le conjoint d'iteneraire
    
    public PrixPeage(){}
    
    public PrixPeage (int iteneraireId, int classPeageVoiture, float prixPeage)
    {
          this.iteneraireID = iteneraireId;
          this.classPeageVoiture = classPeageVoiture;
          this.prixPeage = prixPeage;
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
    public int ObtenirIdIteneraire()
    {
        return iteneraireID;
    }
    public void DefinirItenerireId(int id)
    {
        iteneraireID = id;
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
