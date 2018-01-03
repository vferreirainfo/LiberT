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
public class MouvementPark {
    /**
     * Creates a new instance of MouvementPark
     */
    
    
    Park park;
    Date dtEntree;
    Date dtSorti;
    //TimeSpan t;
    float aPayer;
    Date dtMouvement;
    int mouvParkId;
    
    
    public MouvementPark() {
        
        
    }
    public Park ObtenirPark()
    {
        return park;
    }
    public void DefinirPark(Park p)
    {
        park=p;
    }
    public Date ObtenirDateDEntree()
    {
        return dtEntree;
    }
    public void DefinirDateDEntree(Date dt)
    {
        dtEntree=dt;
    }
    public Date ObtenirDateDeSorti()
    {
        return dtSorti;
    }
    public void DefinirDateSorti(Date dtSorti)
    {
        this.dtSorti = dtSorti;
    }
    public float ObtenirPrixStationment()
    {
        return aPayer;
    }
    public void DefinirPrixStationment(float prixDuStationment)
    {
        aPayer = prixDuStationment;
    }
    
    public Date ObtenirDateDuMouvement()
    {
        return dtMouvement;
    }
    public void DefinirDateMouvement(Date dt)
    {
        dtMouvement = dt;
    }
}