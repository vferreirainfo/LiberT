/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.Adresse;
import LiberT.GestionMethodesPark;
import LiberT.Park;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Vitor
 */
@Path("servpark")
public class ServicePark {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceP
     */
    public ServicePark() {
    }

    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceP
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceP
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    
    
    @GET
    @Path("/ObtenirTousLesParks/")
    public GestionMethodesPark ObtenirTousLesParks()
    {
        //variables temporaries "Park"
        String nomPark, courrierElectronique;
        int nombreTel, adressIdFK;
        
        //variables temporaries pour "Adresse"
        String lieuDAdresse, villeDAdresse;
        int porte, department, idPark;
        
        //Pour utiliser avec le method
        GestionMethodesPark gmp;//=new GestionMethodesPark();
        Park parkIndividuel = new Park();
        List<Park> parks = new ArrayList<Park>();
        Adresse adresse = new Adresse();
        String excMessage="";boolean etat=false;
        
        //BD
        String username, url, driver, password;
        String sqlQuery;
        Statement st; Connection con; ResultSet rs;
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
            
            sqlQuery = "Select * from dbo.Adresse,dbo.Park WHERE dbo.Park.Adresse_adressId=dbo.Adresse.adressId";
            rs=st.executeQuery(sqlQuery);
            while(rs.next())
            {
                idPark = rs.getInt("parkID");
                nomPark = rs.getString("nomPark");
                courrierElectronique = rs.getString("courrierElectronique");
                nombreTel = rs.getInt("nombreTelephon");
                lieuDAdresse=rs.getString("lieuDAdress");
                porte=rs.getInt("nombreDePorte");
                department=rs.getInt("department");
                villeDAdresse = rs.getString("ville");
                
                parkIndividuel.DefinirNomPark(nomPark);
                parkIndividuel.DefinirCoruierEletronique(courrierElectronique);
                parkIndividuel.DefinirNombreTelephone(nombreTel);
                parkIndividuel.DefinirIdPark(idPark);
                adresse.DefinirLieuDAdresse(lieuDAdresse);
                adresse.DefinirNombrePorte(porte);
                adresse.DefinirDepartment(department);
                adresse.DefinirVille(villeDAdresse);
                parkIndividuel.DefinirAdresse(adresse);
                adresse=new Adresse();
                parks.add(parkIndividuel);
                parkIndividuel = new Park();
            }
            etat=true;
            gmp=new GestionMethodesPark(parks,excMessage, etat);
        }
        catch(Exception ex)
        {
           excMessage = ex.getMessage();
           etat=false;
           gmp = new GestionMethodesPark(excMessage, etat); 
        }
        return gmp;
    }
    
    
    
    @GET
    @Path("/ObtenirTousLesParks/{ville}")
    public GestionMethodesPark RecherchezEtReturnezTousLesParks(@PathParam("ville") String ville)
    {
        //variables temporaries "Park"
        String nomPark, courrierElectronique;
        int nombreTel, adressIdFK;
        
        //variables temporaries pour "Adresse"
        String lieuDAdresse, villeDAdresse;
        int porte, department;
        
        //Pour utiliser avec le method
        GestionMethodesPark gmp;//=new GestionMethodesPark();
        Park parkIndividuel = new Park();
        List<Park> parks = new ArrayList<Park>();
        Adresse adresse = new Adresse();
        String excMessage="";boolean etat=false;
        
        //BD
        String username, url, driver, password;
        String sqlQuery;
        Statement st; Connection con; ResultSet rs;
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
            
            sqlQuery = "Select * from dbo.Adresse,dbo.Park WHERE dbo.Park.Adresse_adressId=dbo.Adresse.adressId AND dbo.Adresse.ville='"+ville+"'";
            rs=st.executeQuery(sqlQuery);
            while(rs.next())
            {
                nomPark = rs.getString("nomPark");
                courrierElectronique = rs.getString("courrierElectronique");
                nombreTel = rs.getInt("nombreTel");
                lieuDAdresse=rs.getString("lieuDAdress");
                porte=rs.getInt("nombreDePorte");
                department=rs.getInt("department");
                ville = rs.getString("ville");
                
                parkIndividuel.DefinirNomPark(nomPark);
                parkIndividuel.DefinirCoruierEletronique(courrierElectronique);
                parkIndividuel.DefinirNombreTelephone(nombreTel);
                adresse.DefinirLieuDAdresse(lieuDAdresse);
                adresse.DefinirNombrePorte(porte);
                adresse.DefinirDepartment(department);
                adresse.DefinirVille(ville);
                parkIndividuel.DefinirAdresse(adresse);
                parks.add(parkIndividuel);
            }
            etat=true;
            gmp=new GestionMethodesPark(parks,excMessage, etat);
        }
        catch(Exception ex)
        {
           excMessage = ex.getMessage();
           etat=false;
           gmp = new GestionMethodesPark(excMessage, etat); 
        }
        return gmp;
    }
    
    
    
    
    
    @GET
    @Path("/ObtenirTousLesParksDepartment/{depart}")
    public GestionMethodesPark RecherchezEtReturnezTousLesParks(@PathParam("depart") int department)
    {
        //variables temporaries "Park"
        String nomPark, courrierElectronique;
        int nombreTel, adressIdFK;
        
        //variables temporaries pour "Adresse"
        String lieuDAdresse, villeDAdresse;
        int porte;
        String ville;
        //Pour utiliser avec le method
        GestionMethodesPark gmp;//=new GestionMethodesPark();
        Park parkIndividuel = new Park();
        List<Park> parks = new ArrayList<Park>();
        Adresse adresse = new Adresse();
        String excMessage="";boolean etat=false;
        
        //BD
        String username, url, driver, password;
        String sqlQuery;
        Statement st; Connection con; ResultSet rs;
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
            
            sqlQuery = "Select * from dbo.Adresse,dbo.Park WHERE dbo.Park.Adresse_adressId=dbo.Adresse.adressId AND dbo.Adresse.department="+department+"";
            rs=st.executeQuery(sqlQuery);
            while(rs.next())
            {
                nomPark = rs.getString("nomPark");
                courrierElectronique = rs.getString("courrierElectronique");
                nombreTel = rs.getInt("nombreTel");
                lieuDAdresse=rs.getString("lieuDAdress");
                porte=rs.getInt("nombreDePorte");
                department=rs.getInt("department");
                ville = rs.getString("ville");
                
                parkIndividuel.DefinirNomPark(nomPark);
                parkIndividuel.DefinirCoruierEletronique(courrierElectronique);
                parkIndividuel.DefinirNombreTelephone(nombreTel);
                adresse.DefinirLieuDAdresse(lieuDAdresse);
                adresse.DefinirNombrePorte(porte);
                adresse.DefinirDepartment(department);
                adresse.DefinirVille(ville);
                parkIndividuel.DefinirAdresse(adresse);
                parks.add(parkIndividuel);
            }
            etat=true;
            gmp=new GestionMethodesPark(parks,excMessage, etat);
        }
        catch(Exception ex)
        {
           excMessage = ex.getMessage();
           etat=false;
           gmp = new GestionMethodesPark(excMessage, etat); 
        }
        return gmp;
    }
    
}
