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
public class ConjointVoitures {
    
    
    int conjointVoituresId;
    Client client;
    
    public ConjointVoitures()
    {
        
    }
    public ConjointVoitures(int id, Client c)
    {
        conjointVoituresId = id;
        client = c;
    }
    public int ObtenirIdConjointDeVoitures()
    {
        return conjointVoituresId;
    }
    public void DefinirIdConjointVoitures(int id)
    {
        conjointVoituresId = id;
    }
    public Client ObtenirClient()
    {
        return client;
    }
    public void DefinirClient(Client client)
    {
        this.client = client;
    }
            
    
    
}
