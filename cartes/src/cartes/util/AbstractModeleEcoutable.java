package cartes.util;

import java.util.List;

/**
 * Classe abstraite permettant de creer des modeles ecoutables.
 */
public abstract class AbstractModeleEcoutable implements ModeleEcoutable {
    protected List<EcouteurModele> ecouteurs;

    /**
     * Methode permettant de mettre a jour les ecouteurs.
     */
    protected void fireChangement() {
        if(this.ecouteurs != null) {
            for(EcouteurModele e : this.ecouteurs) {
                e.modeleMisAJour(this);
            }
        }
    }

    /**
     * Methode permettant d'ajouter un ecouteur au modele.
     * @param e L'ecouteur du modele.
     */
    public void ajoutEcouteur(EcouteurModele e) {
        if(this.ecouteurs == null) {
            this.ecouteurs = new java.util.ArrayList<EcouteurModele>();
        }
        this.ecouteurs.add(e);
    }
    
    /**
     * Methode permettant de retirer un ecouteur du modele.
     * @param e L'ecouteur du modele.
     */
    public void retraitEcouteur(EcouteurModele e) {
        this.ecouteurs.add(e);
    }
}
