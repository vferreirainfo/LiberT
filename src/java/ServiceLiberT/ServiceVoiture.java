/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLiberT;

import LiberT.*;
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
@Path("servicevoiture")
public class ServiceVoiture {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceVoiture
     */
    public ServiceVoiture() {
    }

    /**
     * Retrieves representation of an instance of ServiceLiberT.ServiceVoiture
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServiceVoiture
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @GET
    @Path("/obtenirtouslesvoitures/{idClient}")
    public GestionMethodesVoiture ObtenirTousLesVoitures(@PathParam("idClient") int clientId)
    {            
        //données de la voiture
        int voitureId;
        String immatriculation;
        String marque, model;
        Date dateDImmatriculation;
        char codeDuPays;
        int codeIdentifieur;
        
        //donnnes du proprietaire
        int propId;
        String nomP, prenomProprietaire;
        int nombreTelephoneP; int nombreTelMobileP;
        String email; int nombreFiscauxP;
        
        //donnees de conjoint voiture,client, et conjoint voitures
        int pkConjVoitures,pkClient;
        String preNom, nom;
        Date neADate;
        int nombreTelephone, nombreTelephoneMobile;
        String courrier; int nombreFiscaux;
        
        //Donees de adresse
        String lieuDAdresse;
        int nombrePorte;
        int department;
        String ville;
        
        
        //
        Voiture voitureIndividuel = new Voiture();
        List<Voiture> conjVoitures = new ArrayList<Voiture>();
        String excMessage=""; boolean etat;
        GestionMethodesVoiture gmv = new GestionMethodesVoiture();
        Proprietaire prop = new Proprietaire();
        Client client = new Client();
        Adresse adresse = new Adresse();
        ConjointVoitures cjVoit = new ConjointVoitures();
        
        //BD
        String url, username, password, driver;
        String sqlQuery;
        Connection con; Statement st; ResultSet rs;
           
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://DESKTOP-VUQIPI7;databaseName=liberT";
        username = "sa";
        password = "zauwitch";
        
        
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            con.commit();
            sqlQuery="Select * from dbo.Voiture, dbo.ConjointVoitures, dbo.Client, dbo.ProprietaireVoiture, dbo.Adresse WHERE dbo.Voiture.ConjointVoitures_cjVoitureId=dbo.ConjointVoitures.cjVoitureId AND dbo.ConjointVoitures.Client_clientId=dbo.Client.clientId AND dbo.Client.clientId="+clientId+" AND dbo.Voiture.ProprietaireVoiture_clientId=dbo.ProprietaireVoiture.proprietaireId AND dbo.Client.Adresse_adressId = dbo.Adresse.adressId";
            rs = st.executeQuery(sqlQuery);
            while(rs.next())
            {
                //voiture
                voitureId = rs.getInt("voitureId");
                //codeDuPays = rs.("codeDuPays");   
                immatriculation = rs.getString("immatriculation");
                dateDImmatriculation = rs.getDate("dateDImmatriculation");
                marque = rs.getString("marque");
                model = rs.getString("model");
                codeIdentifieur = rs.getInt("DispositifIdentifieur_dispositifId");
                //conjointvoiture
                pkConjVoitures = rs.getInt("cjVoitureId");
                
                
                //proprietaire 
                propId = rs.getInt("proprietaireId");
                prenomProprietaire = rs.getString("preNomProprietaire");
                nomP = rs.getString("nomProprietaire");
                nombreTelephoneP = rs.getInt("nombreTelephoneProp");
                nombreTelMobileP = rs.getInt("nombreTelMobileProp");
                email = rs.getString("emailProp");
                nombreFiscauxP = rs.getInt("nombreFiscauxProp");
                //Proprietaire
                prop.DefinirPreNom(prenomProprietaire);
                prop.DefinirNom(nomP);
                prop.DefinirNombreTelephone(nombreTelephoneP);
                prop.DefinirNombreTelephoneMobile(nombreTelMobileP);
                prop.DefinirCourrierElectronique(email);
                prop.DefinirNombreFiscaux(nombreFiscauxP);
                prop.DefinirAdresseProprietaire(adresse);
                voitureIndividuel.DefinirProprietaireDeVoiture(prop);
                
                
                //client
                pkClient = rs.getInt("clientId");
                preNom = rs.getString("prenom");
                nom = rs.getString("nom");
                neADate = rs.getDate("neADate");
                nombreTelephone = rs.getInt("nombreTelephone");
                nombreTelephoneMobile = rs.getInt("nombreTelMobile");
                courrier = rs.getString("email");
                nombreFiscaux = rs.getInt("nombreFiscaux");
                
                
                //Catch Adresse
                lieuDAdresse = rs.getString("lieudAdress");
                nombrePorte = rs.getInt("nombreDePorte");
                department = rs.getInt("department");
                ville = rs.getString("ville");
                
                
                //Voiture
                voitureIndividuel.DefinirClavierPrimaireVoiture(voitureId);
                voitureIndividuel.MarqueVoiture(marque);
                voitureIndividuel.ModeloDeVoiture(model);
                voitureIndividuel.ImmatriculationVoiture(immatriculation);
                voitureIndividuel.DefinirDateDImmatriculation(dateDImmatriculation);
                
                
                //Adresse
                adresse.DefinirLieuDAdresse(lieuDAdresse);
                adresse.DefinirNombrePorte(nombrePorte);
                adresse.DefinirDepartment(department);
                adresse.DefinirVille(ville);
                
                
                //Client
                client.DefinirIdClient(pkClient);
                client.DefinirPremierNomClient(preNom);
                client.DefinirNomClient(nom);
                client.DefinirDateDeNaissance(neADate);
                client.DefinirNombreTelephoneClient(nombreTelephone);
                client.DefinirNombreMobileClient(nombreTelephoneMobile);
                client.DefinirCourrierEletronique(courrier);
                client.DefinirNombreFiscaux(nombreFiscaux);
                client.DefinirAdresseDuClient(adresse);
                
                cjVoit.DefinirIdConjointVoitures(pkConjVoitures);
                cjVoit.DefinirClient(client);
                voitureIndividuel.DefinirConjointVoitures(cjVoit);
                conjVoitures.add(voitureIndividuel);
                voitureIndividuel = new Voiture();
                
            }
            etat = true;
            gmv = new GestionMethodesVoiture(conjVoitures,excMessage, etat);
        }
        catch(Exception ex)
        {
            etat = false;
            gmv = new GestionMethodesVoiture(excMessage, etat);
        }
        return gmv;
    }
    
    @GET
    @Path("/obtenirvoiture/{immatriculation}")
    public GestionMethodesVoiture ObtenirVoiture(@PathParam("immatriculation") String immatriculation)
    {
          //données de la voiture
        int voitureId;
        String marque, model;
        Date dateDImmatriculation;
        String codeDuPays;
        int codeIdentifieur;
        
        //donnnes du proprietaire
        int propId;
        String nomP, prenomProprietaire;
        int nombreTelephoneP; int nombreTelMobileP;
        String email; int nombreFiscauxP;
        
        //donnees de conjoint voiture,client, et conjoint voitures
        int pkConjVoitures,pkClient;
        String preNom, nom;
        Date neADate;
        int nombreTelephone, nombreTelephoneMobile;
        String courrier; int nombreFiscaux;
        
        //Donees de adresse
        String lieuDAdresse;
        int nombrePorte;
        int department;
        String ville;
        
        
        //
        Voiture voitureIndividuel = new Voiture();
        String excMessage=""; boolean etat;
        GestionMethodesVoiture gmv = new GestionMethodesVoiture();
        Proprietaire prop = new Proprietaire();
        Client client = new Client();
        Adresse adresse = new Adresse();
        ConjointVoitures cjVoit = new ConjointVoitures();
        
        //BD
        String url, username, password, driver;
        String sqlQuery;
        Connection con; Statement st; ResultSet rs;
           
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://DESKTOP-VUQIPI7;databaseName=liberT";
        username = "sa";
        password = "zauwitch";
        
        
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            con.commit();
            sqlQuery="Select * from dbo.Voiture, dbo.ConjointVoitures, dbo.Client,dbo.ProprietaireVoiture,dbo.Adresse WHERE dbo.Voiture.immatriculation='"+immatriculation+"' AND dbo.Voiture.ProprietaireVoiture_clientId=dbo.ProprietaireVoiture.proprietaireId AND dbo.Voiture.ConjointVoitures_cjVoitureId=dbo.ConjointVoitures.cjVoitureId AND dbo.ConjointVoitures.Client_clientId=dbo.Client.clientId AND dbo.Client.Adresse_adressId = dbo.Adresse.adressId AND dbo.ProprietaireVoiture.adressId = dbo.Adresse.adressId";
            rs = st.executeQuery(sqlQuery);
            while(rs.next())
            {
                
                //voiture
                voitureId = rs.getInt("voitureId");
                
                codeDuPays = rs.getString("codeDuPays");   
                dateDImmatriculation = rs.getDate("dateDImmatriculation");
                marque = rs.getString("marque");
                model = rs.getString("model");
                codeIdentifieur = rs.getInt("DispositifIdentifieur_dispositifId");
                //Voiture
                voitureIndividuel.DefinirClavierPrimaireVoiture(voitureId);
                voitureIndividuel.MarqueVoiture(marque);
                voitureIndividuel.DefinirPaysDeVoiture(codeDuPays);
                voitureIndividuel.ModeloDeVoiture(model);
                voitureIndividuel.ImmatriculationVoiture(immatriculation);
                voitureIndividuel.DefinirDateDImmatriculation(dateDImmatriculation);
                
               
                //proprietaire 
                propId = rs.getInt("proprietaireId");
                prenomProprietaire = rs.getString("preNomProprietaire");
                nomP = rs.getString("nomProprietaire");
                nombreTelephoneP = rs.getInt("nombreTelephoneProp");
                nombreTelMobileP = rs.getInt("nombreTelMobileProp");
                email = rs.getString("emailProp");
                nombreFiscauxP = rs.getInt("nombreFiscauxProp");
                //Proprietaire
                prop.DefinirPreNom(prenomProprietaire);
                prop.DefinirNom(nomP);
                prop.DefinirNombreTelephone(nombreTelephoneP);
                prop.DefinirNombreTelephoneMobile(nombreTelMobileP);
                prop.DefinirCourrierElectronique(email);
                prop.DefinirNombreFiscaux(nombreFiscauxP);
                //Catch Adresse
                lieuDAdresse = rs.getString("lieudAdress");
                nombrePorte = rs.getInt("nombreDePorte");
                department = rs.getInt("department");
                ville = rs.getString("ville");
                
                
                //Adresse
                adresse.DefinirLieuDAdresse(lieuDAdresse);
                adresse.DefinirNombrePorte(nombrePorte);
                adresse.DefinirDepartment(department);
                adresse.DefinirVille(ville);
                prop.DefinirAdresseProprietaire(adresse);
                voitureIndividuel.DefinirProprietaireDeVoiture(prop);
               
                //conjointvoiture
                pkConjVoitures = rs.getInt("cjVoitureId");
                
                
                //client
                pkClient = rs.getInt("clientId");
                preNom = rs.getString("prenom");
                nom = rs.getString("nom");
                neADate = rs.getDate("neADate");
                nombreTelephone = rs.getInt("nombreTelephone");
                nombreTelephoneMobile = rs.getInt("nombreTelMobile");
                courrier = rs.getString("email");
                nombreFiscaux = rs.getInt("nombreFiscaux");
                
                //Catch Adresse
                lieuDAdresse = rs.getString("lieudAdress");
                nombrePorte = rs.getInt("nombreDePorte");
                department = rs.getInt("department");
                ville = rs.getString("ville");
                
                //Adresse
                adresse.DefinirLieuDAdresse(lieuDAdresse);
                adresse.DefinirNombrePorte(nombrePorte);
                adresse.DefinirDepartment(department);
                adresse.DefinirVille(ville);
                
                //Client
                client.DefinirIdClient(pkClient);
                client.DefinirPremierNomClient(preNom);
                client.DefinirNomClient(nom);
                client.DefinirDateDeNaissance(neADate);
                client.DefinirNombreTelephoneClient(nombreTelephone);
                client.DefinirNombreMobileClient(nombreTelephoneMobile);
                client.DefinirCourrierEletronique(courrier);
                client.DefinirNombreFiscaux(nombreFiscaux);
                client.DefinirAdresseDuClient(adresse);
                
                cjVoit.DefinirIdConjointVoitures(pkConjVoitures);
                cjVoit.DefinirClient(client);
                voitureIndividuel.DefinirConjointVoitures(cjVoit);
                
            }
            etat = true;
            gmv = new GestionMethodesVoiture(voitureIndividuel,excMessage, etat);
        }
        catch(Exception ex)
        {
            etat = false;
            gmv = new GestionMethodesVoiture(excMessage, etat);
        }
        return gmv;
    }
}
