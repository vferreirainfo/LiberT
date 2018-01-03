/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.GestionMethodesServiceIteneraire;
import LiberT.Iteneraire;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class ServiceInteneraire {

    @Context
    private UriInfo context;

    
    List<Iteneraire> liste = new ArrayList<Iteneraire>();
    
    
    /**
     * Creates a new instance of ServiceInteneraire
     */
    public ServiceInteneraire() {
    }
    
    
    public List<Iteneraire> ObtenirLaListeDIteneraires()
    {
        return liste;
    }
    public void DefinirLaListeDIteneraires(List<Iteneraire> list)
    {
        this.liste = list;
    }
    
    
    //Les Méthodes
    
    public boolean AjouterNouveauIteneraire(Iteneraire route)
    {
        
        boolean returnResult = false;
        
        if(route != null)
        {
            liste.add(route);
            returnResult = true;
        }
        
        return returnResult;
            
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/tousiteneraires/{ae}")
    public GestionMethodesServiceIteneraire RechercherEtAjouterTousItenerairesPourId(@PathParam ("ae") int idListe)
    {
        GestionMethodesServiceIteneraire gmsi = new GestionMethodesServiceIteneraire();
        
        String ae, partiPeage, arrivePeage;
        Iteneraire route = new Iteneraire();
        boolean returnResultat = false;
        Connection con; Statement st; ResultSet rs; 
        int beginingTableFieldNumber;
        String driver, url, username, password;
        String sqlQueryClient;
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://DESKTOP-VUQIPI7;databaseName=vinci-autoroutepeage";
        username = "sa";
        password = "zauwitch";
        

        //1 - Rechercher dans la base de donées
        //2 - Ajouter chaque iteneraire à la liste iteneraires
        try
        {
            beginingTableFieldNumber = 1; // Ne pas regarder et ajouter le clavier primaire de la table 
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            st=con.createStatement();
           
            con.commit();
            
            //le query sql
            sqlQueryClient = "Select * FROM dbo.itenerario";
            rs = st.executeQuery(sqlQueryClient);
            
            while (rs.next())
            {
                ae = rs.getString(beginingTableFieldNumber+1);
                partiPeage = rs.getString(beginingTableFieldNumber+2);
                arrivePeage = rs.getString(beginingTableFieldNumber+3);
            
            
                //valider
                if(route.ValiderAutoRoute(ae)==true&&route.ValierLieuPartiEtSorti(partiPeage)==true&&route.ValierLieuPartiEtSorti(arrivePeage)==true)
                {
                    boolean giveResult = true;
                    route.DefinirAutoRoute(ae, giveResult);
                    route.DefinirLieuParti(partiPeage);
                    route.DefinirLieuDArrive(arrivePeage);
                    
                }
                
                //Ajouter cette route a la liste
                liste.add(route);
                
                
            
            }
            
            returnResultat=true;
            //Ajouter la liste a l'objet GestionMethodesServiceIteneraire
            gmsi.DefinirTousIteneraires(liste); 
            gmsi.DefinirMethodEtat(returnResultat); // nous avons tous l'iteneraires... cette operation marche très bien!
                
                
            
        }
        catch(SQLException ex)
        {
           String msg;
           msg = ex.getMessage();
           gmsi.DefinirMethodEtat(returnResultat); // nous avons tous l'iteneraires... cette operation marche très bien!
           
           //Si nous 
        }
        catch (Exception ex)
        {
           String msg;
           msg = ex.getMessage();
           gmsi.DefinirMethodEtat(returnResultat); // nous avons tous l'iteneraires... cette operation marche très bien!
           
           //Si nous
        }
        
        
       return gmsi;
    }

    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceInteneraire
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceInteneraire
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}

