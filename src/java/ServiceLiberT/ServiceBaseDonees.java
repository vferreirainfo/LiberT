/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("servicedonees")
public class ServiceBaseDonees {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceBaseDonees
     */
    public ServiceBaseDonees() {
    }

    @GET
    @Path("/basedonees/returnezPKLibre/{nom}")
    public int ReturnezLeValuerPKLibre(@PathParam("nom") String nomTable)
    {
        int conter=0;
        Connection con; Statement st; ResultSet rs; 
        String driver, url, username, password;
        String sqlQuery;
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://DESKTOP-VUQIPI7;databaseName=liberT";
        username = "sa";
        password = "zauwitch";
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            st=con.createStatement();
            con.commit();
            sqlQuery = "Select * FROM dbo."+nomTable+"";
            rs = st.executeQuery(sqlQuery);

            
            while (rs.next())
            {
                conter++;
            }
            conter=conter+1;
        }
        catch(Exception ex)
        {
            
        }
        return conter;
    }
    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceBaseDonees
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceBaseDonees
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
