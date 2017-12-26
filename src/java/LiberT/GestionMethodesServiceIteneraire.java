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
public class GestionMethodesServiceIteneraire
{
    List<Iteneraire> routes = new ArrayList<Iteneraire>();
    boolean returnMethodEtat;
    String msgExc;
    
    
    public GestionMethodesServiceIteneraire(){
        
    }
    
    public List<Iteneraire> ObtenirTousIteneraires()
    {
        return routes;
    }
    public void DefinirTousIteneraires(List<Iteneraire> routes)
    {
        this.routes = routes;
    }
    public boolean ObtenirEtatDOperationMethod()
    {
        return returnMethodEtat;
    }
    public void DefinirMethodEtat(boolean resultatOperation)
    {
        returnMethodEtat = resultatOperation;
    }
    
    public String ObtenirMessageDException()
    {
        return msgExc;
    }
    public void DefinirMessageDException(String excMsg)
    {
        this.msgExc = excMsg;
    }
   
    
    
            
}
