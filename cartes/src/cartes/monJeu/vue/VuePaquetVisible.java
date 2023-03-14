package cartes.monJeu.vue;

import cartes.monJeu.controleur.ControleurChoixCarteVersPaquet;
import cartes.monJeu.modele.*;

/**
 * Classe VuePaquetVisible qui hérite de VuePaquet
 */
public class VuePaquetVisible extends VuePaquet {
    protected ControleurChoixCarteVersPaquet controleur;
    
    /**
     * Constructeur de la classe VuePaquetVisible appelant le constructeur de la classe mère VuePaquet avec le paramètre visible à true et un nouveau controleur ControleurChoixCarteVersPaquet
     * @param paquet Le paquet de cartes
     * @param destination Le paquet de destination
     */
    public VuePaquetVisible(Paquet paquet, Paquet destination) {
        super(paquet, destination, true);
        this.paquet = paquet;
        this.dx = this.largeurCarte;
        this.dy = 0;
        this.controleur = new ControleurChoixCarteVersPaquet(this, destination);
        this.playable = true;
    }

    public VuePaquetVisible(Paquet paquet, Paquet destination, boolean playable) {
        this(paquet, destination);
        this.playable = playable;
    }
    
    public VuePaquetVisible(Paquet paquet, Paquet destination, int dx) {
        super(paquet, destination, true);
        this.paquet = paquet;
        this.dx = dx;
        this.dy = 0;
        this.controleur = new ControleurChoixCarteVersPaquet(this, destination);
        this.playable = true;
    }

    public VuePaquetVisible(Paquet paquet, Paquet destination, int dx, boolean playable) {
        this(paquet, destination, dx);
        this.playable = playable;
    }

    /**
     * Méthode onClick qui appelle la méthode {@link cartes.monJeu.controleur.ControleurChoixCarteVersPaquet#deplacerVersPaquet(Carte) deplacerVersPaquet} de la classe ControleurChoixCarteVersPaquet
     * @param c La carte cliquée
     * @param v Un boolean qui dit si le paquet est visible
     */
    @Override
    public void onClick(VueCarte c, boolean v) {
        if(playable) {
            this.removeAll();
            this.controleur.tirerCarte(c.getCarte());
        }
    }

    /**
     * Méthode melanger qui appelle la méthode {@link cartes.monJeu.controleur.ControleurChoixCarteVersPaquet#trierCroissant() trierCroissant} de la classe ControleurChoixCarteVersPaquet
     */
    public void trierCroissant() {
        this.controleur.trierCroissant();
    }

    /**
     * Méthode melanger qui appelle la méthode {@link cartes.monJeu.controleur.ControleurChoixCarteVersPaquet#trierDecroissant() trierDecroissant} de la classe ControleurChoixCarteVersPaquet
     */
    public void trierDecroissant() {
        this.controleur.trierDecroissant();
    }

    public ControleurChoixCarteVersPaquet getControleur() {
        return controleur;
    }
}
