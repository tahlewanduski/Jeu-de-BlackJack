package cartes.monJeu.vue;

import cartes.monJeu.controleur.ControleurPiocheVersPaquet;
import cartes.monJeu.modele.Paquet;

/**
 * Clase VuePaquetCache qui hérite de VuePaquet
 */
public class VuePaquetCache extends VuePaquet {
    protected ControleurPiocheVersPaquet controleur;

    /**
     * Constructeur de la classe VuePaquetCache appelant le constructeur de la classe mère VuePaquet avec le paramètre visible à false et un nouveau controleur ControleurPiocheVersPaquet
     * @param paquet Le paquet de cartes
     * @param destination Le paquet de destination
     */
    public VuePaquetCache(Paquet paquet, Paquet destination) {
        super(paquet, destination, false);
        this.paquet = paquet;
        this.dx = 2;
        this.dy = 2;
        this.controleur = new ControleurPiocheVersPaquet(this, destination);
        this.playable = true;
    }

    /**
     * Méthode onClick qui appelle la méthode {@link cartes.monJeu.controleur.ControleurPiocheVersPaquet#piocher() piocher} de la classe ControleurPiocheVersPaquet
     * @param c La carte cliquée
     * @param v Un boolean qui dit si le paquet est visible
     */
    @Override
    public void onClick(VueCarte c, boolean v) {
        // this.removeAll();
        this.controleur.piocher();
    }

    /**
     * Méthode melanger qui appelle la méthode {@link cartes.monJeu.controleur.ControleurPiocheVersPaquet#melanger() melanger} de la classe ControleurPiocheVersPaquet
     */
    public void melanger() {
        this.controleur.melanger();
    }

    public ControleurPiocheVersPaquet getControleur() {
        return controleur;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
}