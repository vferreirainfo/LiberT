/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiberT;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Vitor
 */
@ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(LiberT.Client.class);
        resources.add(LiberT.Iteneraire.class);
        resources.add(ServiceLiberT.ServiceBaseDonees.class);
        resources.add(ServiceLiberT.ServiceClient.class);
        resources.add(ServiceLiberT.ServiceDoneesBancaires.class);
        resources.add(ServiceLiberT.ServiceHotel.class);
        resources.add(ServiceLiberT.ServiceInteneraire.class);
        resources.add(ServiceLiberT.ServiceMouvement.class);
        resources.add(ServiceLiberT.ServiceMouvementPeage.class);
        resources.add(ServiceLiberT.ServicePark.class);
        resources.add(ServiceLiberT.ServicePrixPeage.class);
        resources.add(ServiceLiberT.ServiceStationService.class);
        resources.add(ServiceLiberT.ServiceVoiture.class);
    }
    
}
