package LiberT;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vitor
 */
public class GestionMethodesHotel {
    
    Hotel hot = new Hotel();
    
    List<Hotel> listHotels = new ArrayList<Hotel>();
    
    
    //Autres variables
    String excMessage; boolean etat;
    
    public GestionMethodesHotel()
    {
        
    }
    
    public GestionMethodesHotel(Hotel hotel, String exc, boolean etatMethod)
    {
        hot = hotel;
        excMessage = exc;
        etat = etatMethod;
    }
    public GestionMethodesHotel(Hotel hotel, String exc)
    {
        hot = hotel;
        excMessage = exc;
    }
    public GestionMethodesHotel(List<Hotel> hotels, String exc, boolean etatMethod)
    {
        listHotels = hotels;
        excMessage = exc;
        etat = etatMethod;
    }
    
    public GestionMethodesHotel(List<Hotel> hotels, String exc)
    {
        listHotels = hotels;
        excMessage = exc;
    }
    
    public GestionMethodesHotel(String exc, boolean etatMethod)
    {
        excMessage = exc;
        etat = etatMethod;
    }
    
    
    public Hotel ObtenirUnHotel()
    {
        return hot;
    }
    public void DefinirUnHotel(Hotel hotel)
    {
        hot = hotel;
    }
    public List<Hotel> ObtenirConjointHotel()
    {
        return listHotels;
    }
    public void DefinirConjointHotel(List<Hotel> hotel)
    {
        listHotels = hotel;
    }
    
    public String ObtenirExceptionnelMessage()
    {
        return excMessage;
    }
    public void DefinirExceptionnelMessage(String exc)
    {
        excMessage = exc;
    }
    public boolean ObtenirEtatMethod()
    {
        return etat;
    }
    public void DefinirEtatMethod(boolean etat)
    {
        this.etat = etat;
    }
    
    
    
            
}
