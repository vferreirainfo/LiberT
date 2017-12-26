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
    
    
    
}
public class Voiture {
    
    
    Marque marqueDeVoiture;
    String modelo; // modifier l'identifieur (nom)
    String matriculeVoiture;
    int peageClass;
    char codPays;
    Date dateImmatriculation;
    
    //FK
    int voitureArrayIndex;
    
    
    
    public Voiture()
    {
        
    }
    
    public Voiture (Marque marqueV, String model, String matricule)
    {
        marqueDeVoiture = marqueV;
        modelo = model;
        matriculeVoiture = matricule;
    }
    
    public Marque ObtenirMarque()
    {
        return marqueDeVoiture;
    }
    
    public void MarqueVoiture(Marque m)
    {
        marqueDeVoiture = m;
    }
    public String Modelo()
    {
        return modelo;
    }
    public void ModeloDeVoiture(String mod)
    {
        modelo=mod;  
    }
    
    public int VoiturePeageClass()
    {
        return peageClass;
    }
    
    public void VoiturePeageClass(int peage)
    {
        peageClass = peage;
    }
    public String ImmatriculationVoiture()
    {
        return matriculeVoiture;
    }
    public void ImmatriculationVoiture(String immatriculation)
    {
        matriculeVoiture = immatriculation;
    }
    
    public char PaysDeVoiture()
    {
        return codPays;
    }
    
    public void PaysDeVoiture(char pays)
    {
        codPays = pays;
    }
    
}
