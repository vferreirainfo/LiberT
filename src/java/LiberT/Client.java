/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiberT;

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
    
    String prenom;
    String nom;
    String nombreTele;
    String nombreMobile;
    EspeceAdresse adressClient;
    String nomAdress;
    int nombrePorte;
    String code; // 
    
    
    @Context
    private UriInfo context;

    public Client()
    {
    }
    
    public Client (String premierNom, String nomDeFamilie, String nombreTel, String mobile, EspeceAdresse adressC, int nombreDeLaPorte, String codeDeVille)
    {
        prenom = premierNom;
        nom = nomDeFamilie;
        nombreTele = nombreTel;
        nombreMobile = mobile;
        adressClient = adressC;
        nombrePorte = nombreDeLaPorte;
        code = codeDeVille;
    }
    
    
    public String PremierNomClient()
    {
        return prenom;
    }
    public void PremierNomClient(String preNom)
    {
        prenom = preNom;
    }
    public String NomClient()
    {
        return nom;
    }
    public void NomClient(String nomClient)
    {
        nom = nomClient;
    }
    public String NombreTelephoneClient()
    {
        return nombreTele;
    }
    public void NombreTelephoneClient(String nombre, boolean regexResult)
    {
        if(regexResult==true)
            nombreTele = nombre;
    }
    
    /**
     *
     * @param exp
     * @param expReg
     * @return
     */
    @GET
    @Produces("application/text")
    @Path("Client/get/regex/{nombre}/{regex}")
    public static boolean ValiderNombreTeleMaison(@PathParam("nombre") String exp,@PathParam("regex") String expReg)
    {
        boolean result=false;
        Pattern p = Pattern.compile(expReg);
        Matcher m = p.matcher(exp);
        
        if(m.find())// encontrou valor
        {
            result=true;
        }
        return result;
        
    }

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
