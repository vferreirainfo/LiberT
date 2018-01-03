/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.Adresse;
import LiberT.Client;
import LiberT.GestionMethodesClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@Path("serviceclient")
public class ServiceClient {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceClient
     */
    public ServiceClient() {
    }

    @GET
    @Path("/ObtenirTousClient")
    public GestionMethodesClient ObtenirTousClient()
    {
        //variables tempoeraties pour Adresse
        String lieudAdress;
        int nombrePorte, department;
        String ville;
        
        // pk et fk pour client-->Adresse
        int fkAdresse, pkAdresse;
        
        
        //variables temporaries pour client 
        int pclavier; 
        String premierNom, dernierNom;
        Date dateNaissance;
        int nombreTelephone;
        int nombreTelephoneMobile;
        String courrier;
        int nombreFiscaux;
                
        
        
        //List de clients et un client individuel
        Client clientIndividuel = new Client();
        GestionMethodesClient gs = new GestionMethodesClient();
        List<Client> client = new ArrayList<Client>();
        String exMessage="";
        boolean etat=false;
        
        //BD
        Connection con; Statement st,stI; ResultSet rs, rsI; 
        String driver, username, password, url;
        String sqlQuery,sqlQueryAdresse;
        
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://DESKTOP-VUQIPI7;databaseName=liberT";
        username = "sa";
        password = "zauwitch";
        
        try
        {
            int beginingTableFieldNumber = 1;
            Class.forName(driver);
            con=DriverManager.getConnection(url, username, password);
            st = con.createStatement();
            stI=con.createStatement();
            con.commit();
            sqlQuery = "Select * from dbo.Client";
            sqlQueryAdresse="Select * from dbo.Adresse";
            rs = st.executeQuery(sqlQuery);
            rsI = stI.executeQuery(sqlQueryAdresse);
            while(rs.next())
            {
               pclavier = rs.getInt("clientId");
               premierNom = rs.getString("preNom");
               dernierNom = rs.getString("nom");
               dateNaissance = rs.getDate("neADate");
               nombreTelephone = rs.getInt("nombreTelephone");
               nombreTelephoneMobile = rs.getInt("nombreTelMobile");
               courrier = rs.getString("email");
               nombreFiscaux = rs.getInt("nombreFiscaux");
               clientIndividuel.DefinirIdClient(pclavier);
               clientIndividuel.DefinirPremierNomClient(premierNom);
               clientIndividuel.DefinirNomClient(dernierNom);
               clientIndividuel.DefinirDateDeNaissance(dateNaissance);
               
               fkAdresse = rs.getInt("Adresse_adressId");
               while(rsI.next())
               {
                   pkAdresse=rsI.getInt("adressId");
                   //Si les deux variables sont égales (match)
                   if(fkAdresse==pkAdresse)
                   {
                       lieudAdress = rsI.getString("lieudAdress");
                       nombrePorte = rsI.getInt("nombreDePorte");
                       department = rsI.getInt("department");
                       ville = rsI.getString("ville");
                       Adresse ad = new Adresse();
                       ad.DefinirLieuDAdresse(lieudAdress);
                       ad.DefinirNombrePorte(nombrePorte);
                       ad.DefinirDepartment(department);
                       ad.DefinirVille(ville);
                       clientIndividuel.DefinirAdresseDuClient(ad);
                       
                   }
               }
               
               
               
               client.add(clientIndividuel);
               clientIndividuel = new Client();
               
            }
            
            con.close();
            gs = new GestionMethodesClient(client,exMessage, etat);
        }
        catch(Exception ex)
        {
            exMessage = ex.getMessage();
            etat=false;
        }
        
      
        return gs;
        
    }
    
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
    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceClient
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceClient
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
