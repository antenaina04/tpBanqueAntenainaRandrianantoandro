/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueantenainarandrianantoandro.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import mg.itu.tpbanqueantenainarandrianantoandro.ejb.GestionnaireCompte;
import mg.itu.tpbanqueantenainarandrianantoandro.entities.CompteBancaire;

/**
 *
 * @author Antenaina
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    private List<CompteBancaire> compteBancaireListes;

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public List<CompteBancaire> getAllComptes() {
        if (compteBancaireListes == null) {
            compteBancaireListes = gestionnaireCompte.getAllComptes();
        }
        return (List<CompteBancaire>) compteBancaireListes;
    }
}
