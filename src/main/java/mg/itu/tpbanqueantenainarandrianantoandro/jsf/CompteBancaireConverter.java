/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueantenainarandrianantoandro.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import mg.itu.tpbanqueantenainarandrianantoandro.ejb.GestionnaireCompte;
import mg.itu.tpbanqueantenainarandrianantoandro.entities.CompteBancaire;

/**
 *
 * @author Antenaina
 */
//@Named(value = "compteBancaireConverter")
//@RequestScoped
@FacesConverter(value = "compteBancaireConverter", managed = true)
public class CompteBancaireConverter implements Converter<CompteBancaire> {

    /**
     * Creates a new instance of CompteBancaireConverter
     */
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    @Override
    public CompteBancaire getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null) {
            return null;
        }
        Long id = Long.valueOf(value);
        return gestionnaireCompte.findById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, CompteBancaire compte) {
        if (compte == null) {
            return "";
        }
        return compte.getId().toString();
    }

}
