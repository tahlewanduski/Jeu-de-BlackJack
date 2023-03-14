package cartes.monJeu.controleur;

import cartes.monJeu.modele.*;
import cartes.monJeu.vue.*;

/**
 * Classe ControleurPiocheVersPaquet permettant de controller le déplacement d'une carte du paquet pioche vers un autre paquet.
 */
public class ControleurPiocheVersPaquet {
    private VuePaquetCache source;
    private Paquet destination;
    
    /**
     * Constructeur de la classe ControleurPiocheVersPaquet
     * @param source La vue du paquet source
     * @param destination Le paquet de destination
     */
    public ControleurPiocheVersPaquet(VuePaquetCache source, Paquet destination) {
        this.source = source;
        this.destination = destination;
    }

    /**
     * Méthode melanger qui appelle la méthode {@link cartes.monJeu.modele.Paquet#melanger() melanger} de la classe Paquet
     */
    public void piocher() {
        this.destination.ajouterCarte(this.source.getPaquet().piocheCarte());
    }

    /**
     * Méthode melanger qui appelle la méthode {@link cartes.monJeu.modele.Paquet#melanger() melanger} de la classe Paquet
     */
    public void melanger() {
        this.source.getPaquet().melanger();
    }
}
