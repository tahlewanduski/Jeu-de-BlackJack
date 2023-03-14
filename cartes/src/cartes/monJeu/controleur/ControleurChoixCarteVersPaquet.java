package cartes.monJeu.controleur;

import cartes.monJeu.vue.*;
import cartes.monJeu.modele.*;

/**
 * Classe ControleurChoixCarteVersPaquet permettant de controller le déplacement d'une carte du paquet pioche vers un autre paquet.
 */
public class ControleurChoixCarteVersPaquet {
    private VuePaquetVisible vueSource;
    private Paquet destination;
    
    /**
     * Constructeur de la classe ControleurChoixCarteVersPaquet
     * @param vueSource La vue du paquet source
     * @param destination Le paquet de destination
     */
    public ControleurChoixCarteVersPaquet(VuePaquetVisible vueSource, Paquet destination) {
        this.vueSource = vueSource;
        this.destination = destination;
    }

    /**
     * Méthode tirerCarte qui appelle la méthode {@link cartes.monJeu.modele.Paquet#tirerCarte() tirerCarte} de la classe Paquet
     * @param c La carte à tirer
     */
    public void tirerCarte(Carte carte){
        this.destination.ajouterCarte(carte);
        this.vueSource.getPaquet().retirerCarte(carte);
    }

    /**
     * Méthode trierCroissant qui appelle la méthode {@link cartes.monJeu.modele.Paquet#trierCroissant() trierCroissant} de la classe Paquet
     */
    public void trierCroissant() {
        this.vueSource.getPaquet().trierCroissant();
    }

    /**
     * Méthode trierDecroissant qui appelle la méthode {@link cartes.monJeu.modele.Paquet#trierDecroissant() trierDecroissant} de la classe Paquet
     */
    public void trierDecroissant() {
        this.vueSource.getPaquet().trierDecroissant();
    }
}
