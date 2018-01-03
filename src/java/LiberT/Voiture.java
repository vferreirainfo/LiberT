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

/*
enum Marque
{
    AlfaRomeu,
    Audi,
    AstonMartin,
    BMW,
    Buick,
    Bugatti,
    Bentley,
    Cadillac,
    Citroen,
    Chrysler,
    Chevrolet,
    DAF,
    Dacia,
    Daewoo,
    Ford,
    Ferrari,
    Fiat,
    GMC,
    Hyundai,
    Honda,
    Iata,
    Iveco,
    Koensigg,
    Kawasaki,
    LandRover,
    RangeRover,
    Lamborghini,
    Lancia,
    Lada,
    Lincoln,
    Lotus,
    MAN,
    Maserati,
    Mazda,
    Mitisubishi,
    MercedesBenz,
    Mini,
    MG,
    Nissan,
    Opel,
    Peugeot,
    Plymouth,
    Pagani,
    Renault,
    RollsRoyce,
    Smart,
    Seat,
    Subaru,
    Toyota,
    Tata,
    Volkswagen,
    Volvo,
    Yamaha,
    
    
    
}*/
public class Voiture {
   
    int classPeageVoiture;
    int department;
    int clavierPrimaireVoiture;
    String marque;
    //Marque marqueDeVoiture;
    String model; // modifier l'identifieur (nom)
    String matriculeVoiture;
    String codPays;
    Date dateImmatriculation;
    Proprietaire prop;
    Client client;
    ConjointVoitures cVoitures;
    int conjointVoitures;
    //Object disposifif identifieur
    
    
    //FK
    int voitureArrayIndex;
    
    
    
    public Voiture()
    {
        
    }
    
    public Voiture (String marqueV, String model, String matricule)
    {
        marque = marqueV;
        this.model = model;
        matriculeVoiture = matricule;
    }
    
    public int ObtenirClavierPrimaireVoiture()
    {
        return this.clavierPrimaireVoiture;
    }
    public void DefinirClavierPrimaireVoiture(int clavier)
    {
        clavierPrimaireVoiture = clavier;
    }
    
    public String ObtenirMarque()
    {
        return marque;
    }
    
    public void MarqueVoiture(String marque)
    {
        this.marque = marque;
    }
    public String Modelo()
    {
        return model;
    }
    public void ModeloDeVoiture(String mod)
    {
        model=mod;  
    }
    
    public String ImmatriculationVoiture()
    {
        return matriculeVoiture;
    }
    public void ImmatriculationVoiture(String immatriculation)
    {
        matriculeVoiture = immatriculation;
    }
    
    
    public Date ObtenirDateDImmatriculation()
    {
        return dateImmatriculation;
    }
    
    public void DefinirDateDImmatriculation(Date dt)
    {
        dateImmatriculation = dt;
    }
    
    public Proprietaire ObtenirProprietaireDeVoiture()
    {
        return prop;
    }
    public void DefinirProprietaireDeVoiture(Proprietaire prop)
    {
        this.prop = prop;
    }
    
    public ConjointVoitures ObtenirConjointVoitures()
    {
        return this.cVoitures;
    }
    
    public void DefinirConjointVoitures(ConjointVoitures conjVoitures)
    {
        cVoitures = conjVoitures;
    }
    
    public String ObtenirPaysDeVoiture()
    {
        return codPays;
    }
    public void DefinirPaysDeVoiture(String paysId)
    {
        codPays = paysId;
    }
    
    public int ObtenirClassePeageVoiture()
    {
        return this.classPeageVoiture;
    }
    public void DefinirClassePeageVOiture(int classe)
    {
        classPeageVoiture = classe;
    }
    
    
    
}
