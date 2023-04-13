/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueantenainarandrianantoandro.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
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
        boolean erreur = false;
        if (source.getId() == null || destination.getId() == null || source.getId() == 0 || destination.getId() == 0) {
            FacesMessage message
                    = new FacesMessage("Le destinataire ou l'expediteur n'existe pas");
            FacesContext.getCurrentInstance().addMessage("source-destination-null", message);
            erreur = true;
        }
        if (source.getSolde() < montant) {
            FacesMessage message
                    = new FacesMessage("Solde insuffisant");
            FacesContext.getCurrentInstance().addMessage("source-insuffisant", message);
            erreur = true;
        }
        if (erreur) {
            return null;
        }
//
//        boolean erreur = false;
//        CompteBancaire source = gestionnaireCompte.getCompte(idSource);
//        if (source == null) {
//            // Message d'erreur associé au composant source ; form:source est l'id client
//            // si l'id du formulaire est "form" et l'id du champ de saisie de l'id de la source est "source"
//            // dans la page JSF qui lance le transfert.
//            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
//            erreur = true;
//        } else {
//            if (source.getSolde() < montant) {
//
//                erreur = true;
//            }
//        }
//
//        if (erreur) { // en cas d'erreur, rester sur la même page
//            return null;
//        }
//        gestionnaireCompte.tranferer(source, destination, montant);
//
//        Util.addFlashInfoMessage("Transfert correctement effectué");

// Message de succès ; addFlash à cause de la redirection.
        transfert.transferer(source, destination, montant);
        Util.addFlashInfoMessage("Transfert correctement effectué");

        return "listeComptes.xhtml?faces-redirect=true";

    }
}
