/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.GestionMethodesPrixPeage;
import LiberT.Iteneraire;
import LiberT.PrixPeage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Vitor
 */
@Path("servPrixPeage")
public class ServicePrixPeage {

    String url, username, password, driver;
    String sqlQuery;
    Connection con; Statement st; ResultSet rs;  
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicePrixPeage
     */
    public ServicePrixPeage() {
    }

    /**
     * Retrieves representation of an instance of ServiceLiberT.ServicePrixPeage
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServicePrixPeage
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    
    public GestionMethodesPrixPeage ObtenirTousPrixPeages(int classVoiture)
    {
        //temporaire variables pour PrixPeage
        float prix;
        int classePeage;
        int idPrixPeage;
        
        
        //temporaire variables pour Iteneraire
        String autoroute;
        String lieuParti, lieuSorti;
        int distance;
        String nombreNode;
        
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://DESKTOP-VUQIPI7;databaseName=liberT";
        username = "sa";
        password = "zauwitch";
        
        
       //Objects
       GestionMethodesPrixPeage gmpp = new GestionMethodesPrixPeage();
       List<PrixPeage> listePrixPeages = new ArrayList<PrixPeage>();
       PrixPeage prixIndividuel = new PrixPeage();
       Iteneraire iteneraireIndividuel = new Iteneraire();
       
       
       //Exceptionnel message et etat du method
       String excMessage=" "; boolean etatMethod=false;
       
       try
       {
           Class.forName(driver);
           con = DriverManager.getConnection(url,username,password);
           st = con.createStatement();
           con.commit();
           
           sqlQuery = "Select * from dbo.PrixPeage, dbo.Iteneraire WHERE dbo.PrixPeage.Iteneraire_iteneraireID = Iteneraire.iteneraireId AND dbo.PrixPeage.classePeageVoiture="+classVoiture+"";
           rs = st.executeQuery(sqlQuery);
           while(rs.next())
           {
               prix = rs.getFloat("prixPeage");
               classePeage = rs.getInt("classePeageVoiture");
               idPrixPeage = rs.getInt("prixPeageId");
               prixIndividuel.DefinirPrixPeage(prix);
               prixIndividuel.DefinirClassPeageVoiture(classePeage);
               prixIndividuel.DefinirPrixPeageId(idPrixPeage);
               autoroute = rs.getString("autoroute");
               lieuParti = rs.getString("lieuParti");
               lieuSorti = rs.getString("lieuSorti");
               distance = rs.getInt("distance");
               nombreNode = rs.getString("nombreNode");
               iteneraireIndividuel.DefinirAutoRoute(autoroute, true);
               iteneraireIndividuel.DefinirLieuParti(lieuParti);
               iteneraireIndividuel.DefinirLieuDArrive(lieuSorti);
               iteneraireIndividuel.DefinirDistance(distance);
               iteneraireIndividuel.DefinirNombreNode(nombreNode);
               
               prixIndividuel.DefinirItenerireId(iteneraireIndividuel);
               iteneraireIndividuel = new Iteneraire();
               listePrixPeages.add(prixIndividuel);
               
               prixIndividuel = new PrixPeage();
               
               
               
           }
           etatMethod=true;
           gmpp = new GestionMethodesPrixPeage(listePrixPeages, excMessage, etatMethod);
       
       }
       catch (Exception ex)
       {
          gmpp.DefinirEtatMethod(false);
          gmpp.DefinirExceptionnelMessage(ex.getMessage());
       }
       return gmpp;
       
    }
}
