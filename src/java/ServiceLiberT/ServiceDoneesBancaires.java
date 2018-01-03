/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.DoneesBancaires;
import LiberT.GestionMethodesDoneesBancaires;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
@Path("servDoneesBancaires")
public class ServiceDoneesBancaires {

   
    
    String url, username, password, driver;
    Connection con;
    Statement st;
    ResultSet rs;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceDoneesBancaires
     */
    public ServiceDoneesBancaires() {
    }

    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceDoneesBancaires
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceDoneesBancaires
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    
    public GestionMethodesDoneesBancaires ObtenirDoneesbancaires (int clientId)
    {
        GestionMethodesDoneesBancaires gmdb = new GestionMethodesDoneesBancaires();
        DoneesBancaires dbanc = new DoneesBancaires();
        int clavierPrimaire;
        boolean etat=false;
        String excMessage ="";
        long nombreNib;
        String nomBanque;
        Date date;
        
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://DESKTOP-VUQIPI7;    databaseName=liberT";
        username = "sa";
        password = "zauwitch";
        
        
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            st = con.createStatement();
            con.commit();
            String sqlQuery = "Select * from dbo.DoneesBancaires, dbo.Client WHERE dbo.DoneesBancaires.Client_clientId = dbo.Client.clientId AND dbo.Client.clientId = "+clientId+"";
            
            rs = st.executeQuery(sqlQuery);
            while (rs.next())
            {
                clavierPrimaire = rs.getInt("donBancId");
                date = rs.getDate("date");
                nomBanque = rs.getString("banque");
                nombreNib = rs.getLong("nombreNIB");
                dbanc.DefinirClavierPrimaire(clavierPrimaire);
                dbanc.DefinirNomBanque(nomBanque);
                dbanc.DefinirDateDAutorization(date);
                dbanc.NombreDeNIB(nombreNib);
                //gmdb.DefinirDoneesBancaires(dbanc);
             
                //dbanc = new DoneesBancaires();
            }
            etat=true;
            gmdb = new GestionMethodesDoneesBancaires(dbanc, excMessage, etat);
        }
        catch(Exception ex)
        {
            excMessage = ex.getMessage();
            etat=false; //!!!!
        }
        
        return gmdb;
    }
}
