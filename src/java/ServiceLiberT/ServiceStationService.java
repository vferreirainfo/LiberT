/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.Adresse;
import LiberT.GestionMethodesStationService;
import LiberT.StationService;
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
@Path("servicestationservice")
public class ServiceStationService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceStation
     */
    public ServiceStationService() {
    }

    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceStation
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceStation
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    
    
    public GestionMethodesStationService ReturnezTousStationsService()
    {
        //variables temporaries "Station Service"
        String nomStationService, courrierElectronique;
        int nombreTel, adressIdFK, id;
        
        //variables temporaries pour "Adresse"
        String lieuDAdresse, villeDAdresse;
        int porte, department;
        
        //Pour utiliser avec le method
        GestionMethodesStationService gmss;//=new GestionMethodesPark();
        StationService ssIndividuel = new StationService();
        List<StationService> stationsDeService = new ArrayList<StationService>();
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
            
            sqlQuery = "Select * from dbo.Adresse,dbo.StationService WHERE dbo.StationService.Adresse_adressId=dbo.Adresse.adressId";
            rs=st.executeQuery(sqlQuery);
            while(rs.next())
            {
                id=rs.getInt("sserviceId");
                nomStationService = rs.getString("marque");
                //courrierElectronique = rs.getString("email");
                //nombreTel = rs.getInt("nombreTelephon");
                lieuDAdresse=rs.getString("lieuDAdress");
                ///porte=rs.getInt("nombreDePorte");
                //department=rs.getInt("department");
                villeDAdresse = rs.getString("ville");
                ssIndividuel.DefinirClavierPrimaire(id);
                ssIndividuel.DefinirNomStationService(nomStationService);
                //ssIndividuel.DefinirLeCourrierElectronique(courrierElectronique);
                //ssIndividuel.DefinirNombreTelephone(nombreTel);
                adresse.DefinirLieuDAdresse(lieuDAdresse);
                //adresse.DefinirNombrePorte(porte);
                //adresse.DefinirDepartment(department);
                adresse.DefinirVille(villeDAdresse);
                ssIndividuel.DefinirLAdresseStationService(adresse);
                adresse=new Adresse();
                stationsDeService.add(ssIndividuel);
                ssIndividuel = new StationService();
            }
            etat=true;
            gmss= new GestionMethodesStationService(stationsDeService,excMessage, etat);
           // con.close();
        }
        catch(Exception ex)
        {
           excMessage = ex.getMessage();
           etat=false;
           gmss = new GestionMethodesStationService(excMessage, etat); 
        }
        return gmss;

    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/ObtenirTousStationsService/{ville}")
    public GestionMethodesStationService RecherchezEtReturnezTousLesStationsService(@PathParam("ville") String ville)
    {
        //variables temporaries "Park"
        String nomStationService, courrierElectronique;
        int nombreTel, adressIdFK;
        
        //variables temporaries pour "Adresse"
        String lieuDAdresse, villeDAdresse;
        int porte, department;
        
        //Pour utiliser avec le method
        GestionMethodesStationService gmss;//=new GestionMethodesPark();
        StationService ssIndividuel = new StationService();
        List<StationService> stationsDeService = new ArrayList<StationService>();
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
            
            sqlQuery = "Select * from dbo.Adresse,dbo.StationService WHERE dbo.StationService.Adresse_adressId=dbo.Adresse.adressId AND dbo.Adresse.ville='"+ville+"'";
            rs=st.executeQuery(sqlQuery);
            while(rs.next())
            {
                nomStationService = rs.getString("marque");
                courrierElectronique = rs.getString("email");
                nombreTel = rs.getInt("nombreTelephon");
                lieuDAdresse=rs.getString("lieuDAdress");
                porte=rs.getInt("nombreDePorte");
                department=rs.getInt("department");
                villeDAdresse = rs.getString("ville");
                
                ssIndividuel.DefinirNomStationService(nomStationService);
                ssIndividuel.DefinirLeCourrierElectronique(courrierElectronique);
                ssIndividuel.DefinirNombreTelephone(nombreTel);
                adresse.DefinirLieuDAdresse(lieuDAdresse);
                adresse.DefinirNombrePorte(porte);
                adresse.DefinirDepartment(department);
                adresse.DefinirVille(villeDAdresse);
                ssIndividuel.DefinirLAdresseStationService(adresse);
                stationsDeService.add(ssIndividuel);
            }
            etat=true;
            gmss= new GestionMethodesStationService(stationsDeService,excMessage, etat);
           // con.close();
        }
        catch(Exception ex)
        {
           excMessage = ex.getMessage();
           etat=false;
           gmss = new GestionMethodesStationService(excMessage, etat); 
        }
        return gmss;
    }
}
