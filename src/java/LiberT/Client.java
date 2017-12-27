/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiberT;

import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * REST Web Service
 *
 * @author Vitor
 */

    
enum EspeceAdresse
{
    Avenue,
    Rue,
    Boulevard,
}

@Path("Client")
public class Client {
    
    
    //Qu est-ce que c'est un Client?
    
    //Un client il y a attributtes:
    int idClient;
    String prenom;
    String nom;
    String nombreTele;
    String nombreMobile;
    EspeceAdresse adressClient;
    Adresse adresse; 
    Date dateNaissance;
    
    
    @Context
    private UriInfo context;

    public Client()
    {
    }
    
    public Client (String premierNom, String nomDeFamilie, String nombreTel, String mobile, Adresse adresse)
    {
        prenom = premierNom;
        nom = nomDeFamilie;
        nombreTele = nombreTel;
        nombreMobile = mobile;
        this.adresse = adresse;
    }
    
    public int ObtenirIdClient()
    {
        return idClient;
    }
    public void DefinirIdClient(int idClient)
    {
        this.idClient = idClient;
    }
    
    public String ObtenirPremierNomClient()
    {
        return prenom;
    }
    public void DefinirPremierNomClient(String preNom)
    {
        prenom = preNom;
    }
    public String ObtenirNomClient()
    {
        return nom;
    }
    public void DefinirNomClient(String nomClient)
    {
        nom = nomClient;
    }
    public String ObtenirNombreTelephoneClient()
    {
        return nombreTele;
    }
    public void DefinirNombreTelephoneClient(String nombre, boolean regexResult)
    {
        if(regexResult==true)
            nombreTele = nombre;
    }
    
    public String ObtenirNombreMobileClient()
    {
        return nombreMobile;
    }
    public void DefinirNombreMobileClient(String nombreMobile, boolean regexResult)
    {
        if(regexResult == true)
            this.nombreMobile = nombreMobile;
    }
    
    public Date ObtenirDateDeNaissance()
    {
        return dateNaissance;
    }
    public void DefinirDateDeNaissance(Date ne)
    {
        dateNaissance = ne;
    }
    
    public Adresse ObtenirAdresseDuClient()
    {
        return adresse;
    }
    
    public void DefinirAdresseDuClient(Adresse ad)
    {
        adresse = ad;
    }
    
    
    
    
    /**
     *
     * @param exp
     * @param expReg
     * @return
     */
    

    @GET
    @Produces("application/text")
    @Path("Client/get/{nomI}/{nomII}")
    public String JoinNom(@PathParam("nomI") String nomI, @PathParam("nomII") String nomII)
    {
        return nomI + nomII;
    }
    
    /*
    @GET
    @Produces("application/text")
    @Path("Utilizador")
    public String getText()
    {
        return "ABCDE";
    }
*/
}
