/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.Mouvement;
import LiberT.MouvementPeage;
import LiberT.Payments;
import LiberT.Voiture;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
@Path("servicemouvement")
public class ServiceMouvement {

    @Context
    private UriInfo context;

    //Donnees pour chaque mouvement;
    
    int fkMouvement=0; // si le fk de mouvement est de peage ou autre, obtenir le fk
    // si non fkMouvement <- 0
    Date dtDuMouvment;
    
    Connection con; ResultSet rs; Statement st;
    String url, password, username, sqlQuery, driver;
    String excMessage;
    boolean etatMethod=false;
    Mouvement mouvIndividuel = new Mouvement();
    List<Mouvement> mouvements = new ArrayList<Mouvement>();
    
    /**
     * Creates a new instance of ServiceMouvement
     */
    public ServiceMouvement() {
    }

    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceMouvement
     * @return an instance of java.lang.String
     */
    
    
    public boolean RegisterMouvementDePeage (MouvementPeage mouvPeage, Payments paymentMouvement,Voiture voiture)
    {
        int insertCount;
        String dtMouvement;
        int fkClient;
        int fkPayment;
        int fkPeageId;
        int fkMouvementAutre; //??
        int fkMouvementPeage;
        int especeMouvement=1; //Payments
        
        
        
        
        ServiceMouvementPeage svPeage = new ServiceMouvementPeage();
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://DESKTOP-VUQIPI7;    databaseName=liberT";
        username = "sa";
        password = "zauwitch";
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();
            con.commit();
            
            //Verifier la classe de voiture
            // si les classes de peage sont egales
            if (mouvPeage.ObtenirPrixPeage().ObtenirClassPeageVoiture() == voiture.ObtenirClassePeageVoiture())
            {
                // register le mouvement de peage dans le bd (table mouvement peage)
                if(svPeage.AdjouterEtRegisterMouvementDePeage(mouvPeage)==true)
                {
                    //Register mouvement
                    dtMouvement = mouvPeage.ObtenirDateDuMouvement();
                    fkClient = voiture.ObtenirConjointVoitures().ObtenirClient().ObtenirIdClient();
                    fkPeageId = mouvPeage.ObtenirPeageDAutoroute().ObtenirLeId();
                    fkMouvementAutre=0;
                    fkMouvementPeage = mouvPeage.ObtenirMouvementPeage();
                    fkPayment = paymentMouvement.ObtenirIdPayment();
                    
                    sqlQuery = "INSERT INTO Mouvement(dateDeMouvement,Client_clientId,Payments_payId,EspeceMouvement_espMouvmentId,peageId,MouvementStationService_mouvSServiceId,MouvementPark_mouvparkId,MouvementHotel_mouvementHotelId,MouvementFerry_mouvementFerryId,MouvementPeage_mouvPeageId) VALUES("+dtMouvement+","+fkClient+","+
                            fkPayment+","+especeMouvement+","+fkPeageId+","+fkMouvementAutre+","+fkMouvementAutre+","+fkMouvementAutre+","+fkMouvementAutre+","+fkMouvementAutre+")";
                    
                    
                    insertCount = st.executeUpdate(sqlQuery);
                    
                    etatMethod=true;
                
                
                
                }
                
            }
        }
        catch (Exception ex)
        {
            excMessage = ex.getMessage();
        }
        return etatMethod;
    }      
    
    
    /*
    @GET
    @Path("/ReconuDate/{date}")
    public boolean ReconuLeMouvementDate (@PathParam("date") String dateDuMouvement)
    {
        //String er = "[0-2]{";
    }
    */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceMouvement
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
