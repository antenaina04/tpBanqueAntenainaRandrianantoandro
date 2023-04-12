/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanqueantenainarandrianantoandro.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import mg.itu.tpbanqueantenainarandrianantoandro.entities.CompteBancaire;

/**
 *
 * @author Antenaina
 */
@Singleton
@Startup
public class GestionnaireCompteSingleton {

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    @PostConstruct
    public void init() {
        createAccounts();
    }

    public void createAccounts() {
        if (gestionnaireCompte.nbComptes() == 0) {
            CompteBancaire compte1 = new CompteBancaire("John Lennon", 150000);
            CompteBancaire compte2 = new CompteBancaire("Paul McCartney", 950000);
            CompteBancaire compte3 = new CompteBancaire("Ringo Starr", 20000);
            CompteBancaire compte4 = new CompteBancaire("Georges Harrisson", 100000);

            gestionnaireCompte.creerCompte(compte1);
            gestionnaireCompte.creerCompte(compte2);
            gestionnaireCompte.creerCompte(compte3);
            gestionnaireCompte.creerCompte(compte4);
        }
    }
}
