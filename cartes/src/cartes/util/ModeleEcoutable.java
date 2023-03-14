package cartes.util;

public interface ModeleEcoutable {
    /**
     * Methode permettant d'ajouter un ecouteur au modele.
     * @param e L'ecouteur du modele.
     */
    public void ajoutEcouteur(EcouteurModele e);

    /**
     * Methode permettant de retirer un ecouteur du modele.
     * @param e L'ecouteur du modele.
     */
    public void retraitEcouteur(EcouteurModele e);    
}
