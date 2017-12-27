/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiberT;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class GestionMethodesClient {
    
    
    //Obtenir un client
    Client client = new Client();
    
    //Obtenir un conjoint de clients
    List<Client> conjointClients = new ArrayList<Client>();
    
    //Autres variables
    String excMessage;
    boolean etat;
    
    
    public GestionMethodesClient()
    {
        
    }
    
    public GestionMethodesClient(Client c, String exc, boolean etatMethod)
    {
        client = c;
        excMessage = exc;   
        etat = etatMethod;
    }
    public GestionMethodesClient(List<Client> conjoint, String exc, boolean etatMethod)
    {
        conjointClients = conjoint;
        excMessage = exc;   
        etat = etatMethod;
    }
    
    public GestionMethodesClient(Client c, String exc)
    {
        client = c;
        excMessage = exc;   
        
    }
    public GestionMethodesClient(List<Client> conjoint, String exc)
    {
        conjointClients = conjoint;
        excMessage = exc;   
       
    }
    
    public Client OtenirUnClient()
    {
        return client;
    }
    public void DefinirUnClient(Client c)
    {
        this.client =c;
    }
    public List<Client> ObtenbirConjointDeClients()
    {
        return conjointClients;
    }
    public void DefinirConjointDeClients(List<Client> conjC)
    {
        conjointClients = conjC;
    }
    public String ObtenirExceptionnelMessage()
    {
        return excMessage;
    }
    public void DefinirExceptionnelMessage(String msg)
    {
        excMessage = msg;
    }
    public boolean ObtenirEtatMethod()
    {
        return etat;
    }
    public void DefinirEtatMethod(boolean etatMeth)
    {
        etat = etatMeth;
    }   
}
