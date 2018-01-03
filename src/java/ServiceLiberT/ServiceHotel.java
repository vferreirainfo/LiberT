/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.Adresse;
import LiberT.GestionMethodesHotel;
import LiberT.Hotel;
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
@Path("servhotel")
public class ServiceHotel {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceHotel
     */
    public ServiceHotel() {
    }
    
    

    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceHotel
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceHotel
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    public GestionMethodesHotel ObtenirTousLesHotels()
    {
         //variables temporaries "Hotel"
        String nomHotel, courrierElectronique;
        int nombreTel, adressIdFK;
        int idHotel;
        
        //variables temporaries pour "Adresse"
        String lieuDAdresse, villeDAdresse;
        int porte, department;
        
        //Pour utiliser avec le method
        GestionMethodesHotel gmh;//=new GestionMethodesPark();
        Hotel hotelIndividuel = new Hotel();
        List<Hotel> listeHotel = new ArrayList<Hotel>();
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
            st = con.createStatement();
            con.commit();
            
            sqlQuery = "Select * from dbo.Adresse,dbo.Hotel WHERE dbo.Hotel.Adresse_adressId=dbo.Adresse.adressId";
            rs=st.executeQuery(sqlQuery);
            while(rs.next())
            {
                idHotel = rs.getInt("hotelId");
                nomHotel = rs.getString("nomHotel");
                courrierElectronique = rs.getString("courrierElectronique");
                nombreTel = rs.getInt("nombreTel");
                lieuDAdresse=rs.getString("lieuDAdress");
                porte=rs.getInt("nombreDePorte");
                department=rs.getInt("department");
                villeDAdresse = rs.getString("ville");
                
                hotelIndividuel.DefinirNomHotel(nomHotel);
                hotelIndividuel.DefinirLeCourrierElectronique(courrierElectronique);
                hotelIndividuel.DefinirNombreTelephone(nombreTel);
                hotelIndividuel.DefinirClavierPrimaire(idHotel);
                adresse.DefinirLieuDAdresse(lieuDAdresse);
                adresse.DefinirNombrePorte(porte);
                adresse.DefinirDepartment(department);
                adresse.DefinirVille(villeDAdresse);
                hotelIndividuel.DefinirLAdresse(adresse);
                adresse = new Adresse();
                listeHotel.add(hotelIndividuel);
                hotelIndividuel = new Hotel();
            }
            etat=true;
            gmh= new GestionMethodesHotel(listeHotel,excMessage, etat);
           // con.close();
        }
        catch(Exception ex)
        {
           excMessage = ex.getMessage();
           etat=false;
           gmh = new GestionMethodesHotel(excMessage, etat); 
        }
        return gmh;
    }
}
