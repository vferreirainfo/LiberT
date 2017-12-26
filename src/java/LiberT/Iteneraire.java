/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiberT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Vitor
 */
@Path("int")
public class Iteneraire {


    //int pkIteneraireId;
    String autoroute;
    String partiPeage;
    String arrivePeage;
    int distanceIteneraire;
    String nombreNode;
    int idListeIteneraires; 
    
    
    /**
     * Creates a new instance of Iteneraire
     */
    
    
    //Construtores - Constructeurs de Iteneraire (objet)
    public Iteneraire() {
    }

    
    public Iteneraire (String autoroute, String partiPeage, String arrivePeage)
    {
        this.autoroute = autoroute;
        this.partiPeage = partiPeage;
        this.arrivePeage = arrivePeage;
    }
    
    public Iteneraire (String autoroute, String partiPeage, String arrivePeage, int idIteneraires)
    {
        this.autoroute = autoroute;
        this.partiPeage = partiPeage;
        this.arrivePeage = arrivePeage;
        this.idListeIteneraires = idIteneraires;
    }
    
    
    
    //Property's - Get et Set pour chaque attribute/variable d'Iteneraire
    
    public String ObtenirAutoRoute()
    {
       return autoroute;
    }
    public void DefinirAutoRoute(String aeroute, boolean verValue)
    {
        if(verValue==true)
        {
            autoroute = aeroute;
        }
        
    }
    public String ObtenirLieuParti ()
    {
        return partiPeage;
    }
    public void DefinirLieuParti (String partiPeage, boolean verValue)
    {
        if(verValue==true)
        {
             this.partiPeage = partiPeage;
        }
    }
    public String ObtenirLieuDArrive()
    {
        return arrivePeage;
    }
    public void DefinirLieuDArrive(String arrivePeage, boolean verValue)
    {
        if(verValue == true)
        {
            this.arrivePeage = arrivePeage;
        }
        
    }
    public int ObtenirIdListeIteneraires()
    {
        return idListeIteneraires;
    }
    public void DefinirIdListeIteneraires(int idListe)
    {
        idListeIteneraires = idListe;
    }
    
    public int ObtenirDistance()
    {
        return distanceIteneraire;
    }
    public void DefinirDistance(int dist)
    {
        distanceIteneraire = dist;
    }
    
    public String ObtenirNommbreNode()
    {
        return nombreNode;
    }
    
    public void DefinirNombreNode(String nodeNomb)
    {
        nombreNode = nodeNomb;
    }
    
    
    
    //Métodos - Les méthodes


    //Phase I - Valier l'autorute, et les lieus de parti et sorti

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/validerAE/{autoroute}")
    public boolean ValiderAutoRoute(@PathParam("autoroute") String ae)
    {
        boolean returnResultat=false;
        String expRegulier = "A[0-9]{2,3}";
        Pattern pat = Pattern.compile(expRegulier);
        Matcher match = pat.matcher(ae);
        
        if(match.find())
        {
            returnResultat=true;
        }
        return returnResultat;
        
    }
    
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/validerLieuPartiOuSorti/{lieu}")
    public boolean ValierLieuPartiEtSorti(@PathParam("lieu")String lieu)
    {
        boolean returnResultat = false;
        String expRegulier = "[A-Za-z]*"; // un ou plus d'ocorrences de A-Z et a-z
        Pattern pat = Pattern.compile(expRegulier);
        Matcher match = pat.matcher(lieu);
        
        if(match.find())
        {
            return returnResultat = true;
        }
        
        return returnResultat;
    }
    
    
    /**
     * Retrieves representation of an instance of LiberT.Iteneraire
     * @return an instance of java.lang.String
     */
    /*
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Iteneraire
     * @param content representation for the resource
     
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }**/
    
    
    
}
