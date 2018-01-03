/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.MouvementPeage;
import LiberT.Voiture;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
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
@Path("servmouvementpeage")
public class ServiceMouvementPeage {

    @Context
            
    //Donees de mouvement Peage
    
            
    int fkPrixPeage;
    int fkPeageId;
    String dtMouvement; // premier fois declaré comme Date
    java.sql.Date dtBD;  
    Calendar cal = Calendar.getInstance();
    boolean etat=false;
    
    Connection con; ResultSet rs; Statement st;
    String url, password, username, sqlQuery, driver;
    private UriInfo context;

    /**
     * Creates a new instance of ServiceMouvementPeage
     */
    public ServiceMouvementPeage() {
    }

    
    public boolean AdjouterEtRegisterMouvementDePeage (MouvementPeage mouvPeage)
    {
        int update_count;
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://DESKTOP-VUQIPI7;databaseName=liberT";
        username = "sa";
        password = "zauwitch";
        
        
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();
            con.commit();
            
            //Obtenir l'id (PK) de prix peage
            fkPrixPeage = mouvPeage.ObtenirPrixPeage().ObtenirPrixPeageId();
            
            //Obtenir l'id (PK) de peage
            //fkPeageId = mouvPeage.ObtenirPeageDAutoroute().ObtenirLeId();
            
            dtMouvement = mouvPeage.ObtenirDateDuMouvement();
            
            //String dtMouvement="12/12/2017";
            
            String dateQuery = "CAST(N'"+dtMouvement+"'AS Date)";
            // nous avons de donees
            //&& fkPeageId != 0
            if(fkPrixPeage != 0 )
            {
               sqlQuery = "INSERT INTO MouvementPeage (PrixPeage_prixPeageId, dateDuMouvement) VALUES("+fkPrixPeage+","+dateQuery+")";
               update_count = st.executeUpdate(sqlQuery);
            }
          
            st.close();
            etat=true;
            
        }
        catch (Exception ex)
        {
            String msg = ex.getMessage();
            return false;
        }
        
        return etat;
    }
    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceMouvementPeage
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceMouvementPeage
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
