/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueantenainarandrianantoandro.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import mg.itu.tpbanqueantenainarandrianantoandro.ejb.GestionnaireCompte;
import mg.itu.tpbanqueantenainarandrianantoandro.entities.CompteBancaire;

/**
 *
 * @author Antenaina
 */
@Named(value = "transfert")
@RequestScoped
public class TransfertBean {

    private CompteBancaire source;
    private CompteBancaire destination;
    private int montant;

    @EJB
    private GestionnaireCompte transfert;

    public TransfertBean() {
    }

    public CompteBancaire getSource() {
        return source;
    }

    public void setSource(CompteBancaire source) {
        this.source = source;
    }

    public CompteBancaire getDestination() {
        return destination;
    }

    public void setDestination(CompteBancaire destination) {
        this.destination = destination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String update() {
        transfert.transferer(source, destination, montant);

        return "listeComptes.xhtml?faces-redirect=true";
    }
}
